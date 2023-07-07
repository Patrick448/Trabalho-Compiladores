package visitors;

import java.util.List;
import java.util.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ast.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class JasminGenVisitor extends Visitor {
    private STGroup groupTemplate;
    //private ST type, stmt, expr;
    //private List<ST> funcs, params;

    private Stack<ST> codeStack = new Stack<>();
    private String fileName;
    private ScopeVisitor scopeVisitor;
    private int unique_id=0;

    private String generatedCode;

    public JasminGenVisitor(ScopeVisitor scopeVisitor, String filename) {
        this.scopeVisitor = scopeVisitor;
        groupTemplate = new STGroupFile("./template/jasmin.stg");
        this.fileName = filename;
    }


    public String getGeneratedCode() {
        return generatedCode;
    }

    public void visit(Prog p) {
        ST template = groupTemplate.getInstanceOf("prog");
        fileName = this.fileName;
        template.add("name", fileName);

        if(p.getFuncList()!=null)
        {
            p.getFuncList().accept(this);
            template.add("funclist", codeStack.pop());
        }
        if(p.getDataList()!=null)
        {
            p.getDataList().accept(this);
            template.add("datalist", codeStack.pop());
        }

        generatedCode = template.render();
    }


    public void visit(FuncList f) {
        ST template = groupTemplate.getInstanceOf("funclist");
        List<ST> funcs = new ArrayList<ST>();

        for (Func func : f.getList()) {
            func.accept(this);
            funcs.add(codeStack.pop());
        }

        template.add("funcs", funcs);
        codeStack.push(template);

    }

    public void visit(Func f) {
        Integer count = 0;
        String s_p = "(";
        if(f.getParams()!=null)
        {
            for(Param p : f.getParams().getParamsList())
            {
                String p_type = p.getType().getFullName();
                if(count>0)
                {
                    s_p = s_p + "," + p_type;
                }
                else
                {
                    s_p = s_p + p_type;
                }
                count = count+1;
            }
        }
        s_p = s_p + ")";

        int scopeFunc_before = scopeVisitor.getScopeFunc();
        int level_before = scopeVisitor.getLevel();
        scopeVisitor.setLevel(0);
        scopeVisitor.setScopeFuncByName(f.getId().getName()+s_p);

        ST template = groupTemplate.getInstanceOf("func");
        String name = f.getId().getName();

        TypeList typeList = f.getReturns();
        if (typeList != null) {
            typeList.accept(this);
            template.add("returntypes", codeStack.pop());
        }
        else
        {
            template.add("returntypes", "void");
        }

        ParamsList params = f.getParams();
        if (params != null) {
            params.accept(this);
            template.add("paramslist", codeStack.pop());
        }

        CmdList cmdList = f.getCmdList();
        if (cmdList != null) {
            cmdList.accept(this);
            template.add("cmdlist", codeStack.pop());
        }


        template.add("name", "_" + name);
        codeStack.push(template);

        scopeVisitor.setLevel(level_before);
        scopeVisitor.setScopeFunc(scopeFunc_before);
    }

    public void visit(TypeList tl) {
        List<Type> list = tl.getReturnTypes();

        ST template = groupTemplate.getInstanceOf("multiple_returns");
        codeStack.push(template);
    }

    public void visit(ParamsList pl) {

        ST template = groupTemplate.getInstanceOf("paramslist");

        List<Param> params = pl.getParamsList();
        List<ST> paramsST = new ArrayList<>();

        for (Param p : params) {
            p.accept(this);
            paramsST.add(codeStack.pop());
        }

        template.add("params", paramsST);
        codeStack.push(template);

    }

    public void visit(Param p) {
        ST template = groupTemplate.getInstanceOf("param");
        p.getType().accept(this);
        template.add("type", codeStack.pop());

        p.getId().accept(this);
        template.add("id", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Type t) {
        ST typeTemplate = null;

        if (t.getName().equals("Int")) {
            typeTemplate = groupTemplate.getInstanceOf("int_type");
        } else if (t.getName().equals("Boolean")) {
            typeTemplate = groupTemplate.getInstanceOf("boolean_type");
        } else if (t.getName().equals("Char")) {
            typeTemplate = groupTemplate.getInstanceOf("string_type");
        } else if (t.getName().equals("Float")) {
            typeTemplate = groupTemplate.getInstanceOf("float_type");
        } else {
            typeTemplate = new ST("_" + t.getName());
        }

        codeStack.push(typeTemplate);
    }

    /*public void visit2(CmdList c) {
        scopeVisitor.addLevel();
        ST template = groupTemplate.getInstanceOf("cmdlist");

        List<Node> cmdlist = c.getList();
        List<ST> cmdlistST = new ArrayList<>();
        List<ST> variableslistST = new ArrayList<>();

        Iterator bKeyIterator = scopeVisitor.getCurrentScope().keySet().iterator();
        String key;
        String value;
        HashMap<String, String> difference = new HashMap<String, String>();

        while (bKeyIterator.hasNext()) {
            key = (String)bKeyIterator.next();
            if (!scopeVisitor.getCurrentScopeBefore().containsKey(key)) {
                value = scopeVisitor.getCurrentScope().get(key);
                difference.put(key, value);
            }
        }

        Iterator dKeyIterator = difference.keySet().iterator();
        while(dKeyIterator.hasNext())
        {
            key = (String) dKeyIterator.next();
            String s = (String) difference.get(key);
            ST typeTemplate = null;

            if(s.equals("Int"))
            {
                typeTemplate = groupTemplate.getInstanceOf("int_type");
                variableslistST.add(new ST(typeTemplate.render() + " _" + key + ";"));
            }
            else if(s.equals("Float"))
            {
                typeTemplate = groupTemplate.getInstanceOf("float_type");
                variableslistST.add(new ST(typeTemplate.render() + " _" + key + ";"));
            }
            else if(s.equals("Bool"))
            {
                typeTemplate = groupTemplate.getInstanceOf("boolean_type");
                variableslistST.add(new ST(typeTemplate.render() + " _" + key + ";"));
            }
            else if(s.equals("Char"))
            {
                typeTemplate = groupTemplate.getInstanceOf("string_type");
                variableslistST.add(new ST(typeTemplate.render() + " _" + key + ";"));
            }
            else if(s.contains("[]"))
            {
                int counter = s.split("\\[]", -1).length - 1;
                String v_s = "";
                int i = counter;
                while(i > 0)
                {
                    v_s = v_s + "Vector\\<";
                    i=i-1;
                }
                if(s.contains("Int"))
                {
                    typeTemplate = groupTemplate.getInstanceOf("int_type");
                    v_s = v_s+ typeTemplate.render();
                }
                else if(s.contains("Float"))
                {
                    typeTemplate = groupTemplate.getInstanceOf("float_type");
                    v_s = v_s+ typeTemplate.render();
                }
                else if(s.contains("Bool"))
                {
                    typeTemplate = groupTemplate.getInstanceOf("boolean_type");
                    v_s = v_s+ typeTemplate.render();
                }
                else if(s.contains("Char"))
                {
                    typeTemplate = groupTemplate.getInstanceOf("string_type");
                    v_s = v_s+ typeTemplate.render();
                }
                else
                {
                    int index = s.indexOf('[');
					String type = s.substring(0, index);
                    v_s = v_s + " _" + type;
                }
                i = counter;
                while(i > 0)
                {
                    v_s = v_s + ">";
                    i=i-1;
                }
                v_s = v_s+ " _" + key + ";";
                variableslistST.add(new ST(v_s));
            }
            else
            {
                variableslistST.add(new ST("_" + s + " _" + key + ";"));
            }
        }

        for (Node cmd : cmdlist) {
            cmd.accept(this);
            cmdlistST.add(codeStack.pop());
        }
        template.add("cmds", cmdlistST);
        template.add("variables", variableslistST);
        codeStack.push(template);
        scopeVisitor.subLevel();
    }*/

    private ST templateFromTypeStr(String type){
        ST typeTemplate=null;

        if(type.contains("[]")){
            ST vectorTemplate = groupTemplate.getInstanceOf("array");
            String typeSubstring = type.substring(0, type.length()-2);
            vectorTemplate.add("type", templateFromTypeStr(typeSubstring));
            return vectorTemplate;
        }
        else if(type.equals("Int"))
        {
            typeTemplate = groupTemplate.getInstanceOf("int_type");
        }
        else if(type.equals("Float"))
        {
            typeTemplate = groupTemplate.getInstanceOf("float_type");
        }
        else if(type.equals("Bool"))
        {
            typeTemplate = groupTemplate.getInstanceOf("boolean_type");
        }
        else if(type.equals("Char"))
        {
            typeTemplate = groupTemplate.getInstanceOf("string_type");
        }
        else
        {
            typeTemplate = new ST("_" + type);
        }

        return typeTemplate;
    }

    public void visit(CmdList c) {
        scopeVisitor.addLevel();
        ST template = groupTemplate.getInstanceOf("cmdlist");

        List<Node> cmdlist = c.getList();
        List<ST> cmdlistST = new ArrayList<>();
        List<ST> variableslistST = new ArrayList<>();

        Iterator<String> bKeyIterator = scopeVisitor.getCurrentScope().keySet().iterator();
        String key, value;
        HashMap<String, String> difference = new HashMap<String, String>();

        while (bKeyIterator.hasNext()) {
            key = bKeyIterator.next();
            if (!scopeVisitor.getCurrentScopeBefore().containsKey(key)) {
                value = scopeVisitor.getCurrentScope().get(key);
                difference.put(key, value);
            }
        }

        Iterator<String> dKeyIterator = difference.keySet().iterator();
        while(dKeyIterator.hasNext())
        {
            key = dKeyIterator.next();
            String s = difference.get(key);
            ST typeTemplate = templateFromTypeStr(s);
            ST varDeclTemplate = groupTemplate.getInstanceOf("var_decl");
            varDeclTemplate.add("type", typeTemplate);
            varDeclTemplate.add("name", "_"+key);
            variableslistST.add(varDeclTemplate);
        }

        for (Node cmd : cmdlist) {
            cmd.accept(this);
            cmdlistST.add(codeStack.pop());
        }
        template.add("cmds", cmdlistST);
        template.add("variables", variableslistST);
        codeStack.push(template);
        scopeVisitor.subLevel();
    }


    public void visit(Print p) {
        ST template = groupTemplate.getInstanceOf("print");
        p.getExpr().accept(this);
        template.add("expr", codeStack.pop());
        codeStack.push(template);
    }


    public void visit(Add a) {
        ST template = groupTemplate.getInstanceOf("add_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Sub a) {
        ST template = groupTemplate.getInstanceOf("sub_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Div a) {
        ST template = groupTemplate.getInstanceOf("div_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    public void visit(Mul a) {
        ST template = groupTemplate.getInstanceOf("mul_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    public void visit(Rest a) {
        ST template = groupTemplate.getInstanceOf("mod_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(And a) {
        ST template = groupTemplate.getInstanceOf("and_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }



    public void visit(GreaterThan a) {
        ST template = groupTemplate.getInstanceOf("gt_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(LessThan a) {
        ST template = groupTemplate.getInstanceOf("lt_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Diff a) {
        ST template = groupTemplate.getInstanceOf("diff_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(SubUni a) {
        ST template = groupTemplate.getInstanceOf("sub_uni_expr");
        a.getExpr().accept(this);

        template.add("expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Neg a) {
        ST template = groupTemplate.getInstanceOf("not_expr");
        a.getExpr().accept(this);

        template.add("expr", codeStack.pop());

        codeStack.push(template);
    }

    public void visit(Eq a) {
        ST template = groupTemplate.getInstanceOf("equals_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Int a) {
        codeStack.push(new ST(String.valueOf(a.getValue())));

    }


    public void visit(Char a) {
        codeStack.push(new ST("\"" + a.getValue() + "\""));
    }


    public void visit(Bool a) {
        codeStack.push(new ST(String.valueOf(a.getValue())));
    }


    public void visit(FloatAst a) {
        codeStack.push(new ST(String.valueOf(a.getValue())));
    }


    public void visit(Iterate a) {
        ST template = groupTemplate.getInstanceOf("iterate");
        a.getCondition().accept(this);
        a.getCmd().accept(this);
        template.add("cmdlist", codeStack.pop());
        template.add("expr", codeStack.pop());
        template.add("unique_id", unique_id);
        unique_id++;

        codeStack.push(template);

    }


    public void visit(If a) {
        ST template = groupTemplate.getInstanceOf("if");
        a.getTeste().accept(this);
        template.add("expr", codeStack.pop());

        if(a.getThn() != null){
            a.getThn().accept(this);
            template.add("thn", codeStack.pop());
        }

        if(a.getEls() != null){
            a.getEls().accept(this);
            template.add("else", codeStack.pop());
        }

        codeStack.push(template);

    }


    public void visit(Data a) {
        ST template = groupTemplate.getInstanceOf("data");
        a.getId().accept(this);
        if(a.getDeclList()!=null)
        {
            a.getDeclList().accept(this);
            template.add("declist", codeStack.pop());
        }
        template.add("name", codeStack.pop());

        codeStack.push(template);
    }

    public void visit(DataList a) {
        ST template = groupTemplate.getInstanceOf("datalist");
        List<ST> datas = new ArrayList<ST>();

        for(Data d:a.getList()){
            d.accept(this);
            datas.add(codeStack.pop());
        }

        template.add("datas", datas);
        codeStack.push(template);
    }


    public void visit(DeclList a) {
        ST template = groupTemplate.getInstanceOf("declist");
        List<ST> decls = new ArrayList<ST>();

        for(Decl d:a.getList()){
            d.accept(this);
            decls.add(codeStack.pop());
        }

        template.add("decls", decls);
        codeStack.push(template);
    }


    public void visit(Decl a) {
        ST template = groupTemplate.getInstanceOf("decl");
        a.getId().accept(this);
        a.getType().accept(this);
        template.add("type", codeStack.pop());
        template.add("name", codeStack.pop());
        codeStack.push(template);
    }


    public void visit(Attr a) {
        ST template = groupTemplate.getInstanceOf("attr");
        a.getLValue().accept(this);
        a.getExp().accept(this);
        template.add("expr", codeStack.pop());
        template.add("id", codeStack.pop());
        String type = scopeVisitor.getCurrentScope().get(a.getLValue().getID().getName());
        /*String type_t="";

        if(type.equals("Int"))
        {
            type_t = "Integer";
        }
        else if(type.equals("Float"))
        {
            type_t = "Float";
        }
        else if(type.equals("Bool"))
        {
            type_t = "Boolean";
        }
        else if(type.equals("Char"))
        {
            type_t = "String";
        }
        else if(type.contains("["))
        {
            int counter = type.split("\\[]", -1).length - 1;
            String v_s = "";
            int i = counter;
            while(i > 0)
            {
                v_s = v_s + "Vector<";
                i=i-1;
            }
            if(type.contains("Int"))
            {
                v_s += "Integer";
            }
            else if(type.contains("Float"))
            {
                v_s += "Float";
            }
            else if(type.contains("Bool"))
            {
                v_s += "Boolean";
            }
            else if(type.equals("Char"))
            {
                v_s += "String";
            }
            else
            {
                type_t = "_"+type;
            }
            i = 0;
            while(i > 0)
            {
                v_s = v_s + ">";
                i=i-1;
            }
            type_t = v_s;
        }
        else
        {
            type_t = "_"+type;
        }
        template.add("type", type_t);*/
        codeStack.push(template);
    }

    public void visit(LValue l) {
        ST vectorAccess = groupTemplate.getInstanceOf("lvalue");
        ST attrAccess = groupTemplate.getInstanceOf("lvalue_attribute");
        LValue lvChild = l.getLValue();
        Expr expr = l.getExpr();
        ID id = l.getID();

        if(lvChild != null && id != null){
            lvChild.accept(this);
            id.accept(this);
            attrAccess.add("attr", codeStack.pop());
            attrAccess.add("lvalue", codeStack.pop());
            codeStack.push(attrAccess);

        }else if(lvChild != null && expr != null){
            lvChild.accept(this);
            expr.accept(this);
            vectorAccess.add("expr", codeStack.pop());
            vectorAccess.add("lvalue", codeStack.pop());
            codeStack.push(vectorAccess);
        }
        else if(lvChild == null && id != null){
            id.accept(this);
        }

    }


    public void visit(New n) {
        ST template = null;
        n.getType().accept(this);

        if (n.getExpr() != null) {
            template = groupTemplate.getInstanceOf("new_array");
            n.getExpr().accept(this);
            template.add("expr", codeStack.pop());
            template.add("type", codeStack.pop());
        } else {
            template = groupTemplate.getInstanceOf("new_object");
            template.add("type", codeStack.pop());
        }

        codeStack.push(template);
    }


    public void visit(ID i) {

        codeStack.push(new ST("_"+ i.getName()));
    }

    public void visit(Read i) {
        ST template = groupTemplate.getInstanceOf("read");
        i.getLValue().accept(this);
        template.add("lvalue", codeStack.pop());
        codeStack.push(template);
    }


    public void visit(ReturnCMD r) {
        List<Expr> returns = r.getList().getList();
        if(returns.size() >= 1)
        {
            String s = "List\\<Object> arr = new ArrayList\\<Object>(); \n";
            int i = 0;
            for(Expr e: returns)
            {
                e.accept(this);
                s = s + "arr.add(" + codeStack.pop().render() + "); \n";
            }
            s = s + "return arr;";
            codeStack.push(new ST(s));
        }
        else if(returns.size() == 0)
        {
            codeStack.push(new ST("return;"));
        }

    }


    public void visit(CallFunction c) {
        List<ST> argsST = new ArrayList<>();
        List<ST> returnST = new ArrayList<>();

        ExprList args = c.getExpList();
        for(Node e: args.getList())
        {
            e.accept(this);
            argsST.add(codeStack.pop());
        }
        LValueList ret = c.getLValueList();
        int j = 0;
        ST template_r = null;
        for(LValue r: ret.getList())
        {
            template_r = groupTemplate.getInstanceOf("attrReturn");
            r.accept(this);
            template_r.add("name", codeStack.pop());
            String type = scopeVisitor.getCurrentScope().get(r.getID().getName());
            String type_t="";
            if(type.equals("Int"))
            {
                type_t = "Integer";
            }
            else if(type.equals("Float"))
            {
                type_t = "Float";
            }
            else if(type.equals("Bool"))
            {
                type_t = "Boolean";
            }
            else if(type.equals("Char"))
            {
                type_t = "String";
            }
            else if(type.contains("["))
            {
                int counter = type.split("\\[]", -1).length - 1;
                String v_s = "";
                int i = counter;
                while(i > 0)
                {
                    v_s = v_s + "Vector\\<";
                    i=i-1;
                }
                if(type.contains("Int"))
                {
                    v_s += "Integer";
                }
                else if(type.contains("Float"))
                {
                    v_s += "Float";
                }
                else if(type.contains("Bool"))
                {
                    v_s += "Boolean";
                }
                else if(type.equals("Char"))
                {
                    v_s += "String";
                }
                else
                {
                    type_t = "_"+type;
                }
                i = 0;
                while(i > 0)
                {
                    v_s = v_s + ">";
                    i=i-1;
                }
                type_t = v_s;
            }
            else
            {
                type_t = "_"+type;
            }
            template_r.add("type", type_t);
            template_r.add("expr", j);
            returnST.add(template_r);
        }
        ST template = groupTemplate.getInstanceOf("call");
        template.add("args", argsST);
        template.add("return", returnST);
        template.add("name", "_" + c.getId().getName());
        codeStack.push(template);
    }


    public void visit(CallFunctionVet c) {

        List<ST> argsST = new ArrayList<>();

        ExprList args = c.getExpList();
        for(Node e: args.getList())
        {
            e.accept(this);
            argsST.add(codeStack.pop());
        }
        ST template = groupTemplate.getInstanceOf("callvet");
        template.add("args", argsST);
        template.add("name", "_" + c.getId().getName());
        c.getLExp().accept(this);
        template.add("expr", codeStack.pop());
        codeStack.push(template);
    }

}