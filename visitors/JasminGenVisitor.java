package visitors;

import java.util.List;
import java.util.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ast.*;
import parser.langParser.LvalueContext;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class JasminGenVisitor extends Visitor {
    private STGroup groupTemplate;

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
            template.add("returntypes", "V");
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


        template.add("stack", scopeVisitor.getTamStack(scopeVisitor.getScopeFunc()));
        template.add("decls", scopeVisitor.getTamLocal(scopeVisitor.getScopeFunc()));
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

        codeStack.push(template);
    }


    public void visit(Type t) {
        ST typeTemplate = null;

        if (t.getName().equals("Int")) {
            typeTemplate = groupTemplate.getInstanceOf("int_type");
        } else if (t.getName().equals("Bool")) {
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

    public ST convertTypeName(String name) {
        ST typeTemplate = null;

        if (name.equals("Int")) {
            typeTemplate = groupTemplate.getInstanceOf("int_type");
        } else if (name.equals("Bool")) {
            typeTemplate = groupTemplate.getInstanceOf("boolean_type");
        } else if (name.equals("Char")) {
            typeTemplate = groupTemplate.getInstanceOf("string_type");
        } else if (name.equals("Float")) {
            typeTemplate = groupTemplate.getInstanceOf("float_type");
        } else {
            typeTemplate = new ST("_" + name);
        }

        return typeTemplate;
    }

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

        Iterator<String> bKeyIterator = scopeVisitor.getCurrentScope().keySet().iterator();
        String key, value;
        HashMap<String, String> difference = new HashMap<String, String>();

        while (bKeyIterator.hasNext()) {
            key = bKeyIterator.next();
            if (!scopeVisitor.getCurrentScopeBefore().containsKey(key)) {
                value = scopeVisitor.getCurrentScope().get(key).first();
                difference.put(key, value);
            }
        }

        Iterator<String> dKeyIterator = difference.keySet().iterator();
        while(dKeyIterator.hasNext())
        {
            key = dKeyIterator.next();
            String s = difference.get(key);
            ST typeTemplate = templateFromTypeStr(s);
        }

        for (Node cmd : cmdlist) {
            cmd.accept(this);
            cmdlistST.add(codeStack.pop());
        }
        template.add("cmds", cmdlistST);
        codeStack.push(template);
        scopeVisitor.subLevel();
    }


    public void visit(Print p) {
        ST template = groupTemplate.getInstanceOf("print");
        p.getExpr().accept(this);

        p.getExpr().accept(scopeVisitor);

        String type = scopeVisitor.getStack().pop();

        ST templateLoad;

        template.add("expr", codeStack.pop());

        template.add("type", convertTypeName(type));
        codeStack.push(template);
    }

    private String getPrefix(String type){
        String prefix = "";
        if(type.equals("Int")){
            prefix = "i";
        }else if(type.equals("Float")){
            prefix = "f";
        }
        return prefix;
    }

    public void visit(Add a) {

        a.accept(scopeVisitor);
        String type = scopeVisitor.getStack().pop();

        ST template = groupTemplate.getInstanceOf("add_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("prefix", getPrefix(type));
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Sub a) {
        a.accept(scopeVisitor);
        String type = scopeVisitor.getStack().pop();

        ST template = groupTemplate.getInstanceOf("sub_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("prefix", getPrefix(type));
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Div a) {
        a.accept(scopeVisitor);
        String type = scopeVisitor.getStack().pop();

        ST template = groupTemplate.getInstanceOf("div_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("prefix", getPrefix(type));
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    public void visit(Mul a) {
        a.accept(scopeVisitor);
        String type = scopeVisitor.getStack().pop();

        ST template = groupTemplate.getInstanceOf("mul_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("prefix", getPrefix(type));
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    public void visit(Rest a) {
        a.accept(scopeVisitor);
        String type = scopeVisitor.getStack().pop();

        ST template = groupTemplate.getInstanceOf("mod_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("prefix", getPrefix(type));
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
        unique_id++;

        codeStack.push(template);
    }



    public void visit(GreaterThan a) {
        ST template = groupTemplate.getInstanceOf("gt_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("unique_id", unique_id);
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());
        unique_id++;

        codeStack.push(template);
    }


    public void visit(LessThan a) {
        ST template = groupTemplate.getInstanceOf("lt_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("unique_id", unique_id);
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());
        unique_id++;

        codeStack.push(template);
    }


    public void visit(Diff a) {
        ST template = groupTemplate.getInstanceOf("diff_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("unique_id", unique_id);
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());
        unique_id++;

        codeStack.push(template);
    }


    public void visit(SubUni a) {
        a.accept(scopeVisitor);
        String type = scopeVisitor.getStack().pop();

        ST template = groupTemplate.getInstanceOf("sub_uni_expr");
        a.getExpr().accept(this);

        template.add("prefix", getPrefix(type));
        template.add("expr", codeStack.pop());

        codeStack.push(template);
    }


    public void visit(Neg a) {
        ST template = groupTemplate.getInstanceOf("not_expr");
        a.getExpr().accept(this);

        template.add("unique_id", unique_id);
        template.add("expr", codeStack.pop());
        unique_id++;

        codeStack.push(template);
    }

    public void visit(Eq a) {
        ST template = groupTemplate.getInstanceOf("equals_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("unique_id", unique_id);
        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());
        unique_id++;

        codeStack.push(template);
    }


    public void visit(Int a) {
        ST template = groupTemplate.getInstanceOf("push_stack");
        template.add("value", a.getValue());
        codeStack.push(template);
    }


    public void visit(Char a) {
        ST template = groupTemplate.getInstanceOf("push_stack");
        template.add("value","\"" + a.getValue() + "\"");
        codeStack.push(template);
    }


    public void visit(Bool a) {
        int boolVal = a.getValue() ? 1 : 0;
        ST template = groupTemplate.getInstanceOf("iconst");
        template.add("value", boolVal);
        codeStack.push(template);
    }


    public void visit(FloatAst a) {
        ST template = groupTemplate.getInstanceOf("push_stack");
        template.add("value", a.getValue());
        codeStack.push(template);
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
        ST test = codeStack.pop();
        System.out.println(test.render());
        template.add("expr", test);

        if(a.getThn() != null){
            a.getThn().accept(this);
            template.add("thn", codeStack.pop());
        }

        if(a.getEls() != null){
            a.getEls().accept(this);
            template.add("els", codeStack.pop());
        }

        template.add("unique_id", unique_id);
        unique_id++;
        codeStack.push(template);

    }


    public void visit(Data a) {
        ST template = groupTemplate.getInstanceOf("data");
        String name = a.getId().getName();
        if(a.getDeclList()!=null)
        {
            a.getDeclList().accept(this);
            template.add("declist", codeStack.pop());
        }
        template.add("name", new ST("_"+name));

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
        String name = a.getId().getName();
        a.getType().accept(this);
        template.add("type", codeStack.pop());
        template.add("name", new ST(name));
        codeStack.push(template);
    }


    public void visit(Attr a) {

        ST template = null;
        a.getExp().accept(this);
        LValue l = a.getLValue();
        while(l.getID()==null)
        {
            l = l.getLValue();
        }
        if(scopeVisitor.getCurrentScope().get(l.getID().getName()).first().equals("Int"))
        {
            template = groupTemplate.getInstanceOf("attrint");
        }
        else if(scopeVisitor.getCurrentScope().get(l.getID().getName()).first().equals("Char"))
        {
            template = groupTemplate.getInstanceOf("attrint");
        }
        else if(scopeVisitor.getCurrentScope().get(l.getID().getName()).first().equals("Float"))
        {
            template = groupTemplate.getInstanceOf("attrfloat");
        }
        else if(scopeVisitor.getCurrentScope().get(l.getID().getName()).first().equals("Bool"))
        {
            template = groupTemplate.getInstanceOf("attrint");
        }
        else
        {
            template = groupTemplate.getInstanceOf("attrobj");
        }
        
        template.add("expr", codeStack.pop());
        int value_var = scopeVisitor.getCurrentScope().get(a.getLValue().getID().getName()).second();
        template.add("num", value_var);
        String type = scopeVisitor.getCurrentScope().get(a.getLValue().getID().getName()).first();
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
        if(scopeVisitor.getCurrentScope().containsKey(i.getName()))
        {
            String s = scopeVisitor.getCurrentScope().get(i.getName()).first();
            String prefix = getPrefix(s);
            codeStack.push(new ST(prefix + "load_" + Integer.toString(scopeVisitor.getCurrentScope().get(i.getName()).second())));
        }
    }

    public void visit(Read i) {
        ST template = groupTemplate.getInstanceOf("read");
        ST templateS = null;
        if(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).first().equals("Int"))
        {
            templateS = groupTemplate.getInstanceOf("invocateScannerint");
            templateS.add("num", Integer.toString(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).second()));
        }
        else if(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).first().equals("Char"))
        {
            templateS = groupTemplate.getInstanceOf("invocateScannerLine");
            templateS.add("num", Integer.toString(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).second()));
        }
        else if(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).first().equals("Float"))
        {
            templateS = groupTemplate.getInstanceOf("invocateScannerfloat");
            templateS.add("num", Integer.toString(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).second()));
        }
        else
        {
            templateS = groupTemplate.getInstanceOf("invocateScannerint");
            templateS.add("num", Integer.toString(scopeVisitor.getCurrentScope().get(i.getLValue().getID().getName()).second()));
        }
        template.add("scanner", templateS.render());
        template.add("num",Integer.toString(scopeVisitor.getCurrentScope().size()));
        codeStack.push(template);
    }


    public void visit(ReturnCMD r) {
        List<Expr> returns = r.getList().getList();
        if(returns.size() >= 1)
        {
            String s = "new java/util/ArrayList; \n dup \n invokespecial java/util/ArrayList/<init>()V \n astore_" + scopeVisitor.getCurrentScope().size();
            int i = 0;
            for(Expr e: returns)
            {
                e.accept(this);
                s += "\n aload_" + scopeVisitor.getCurrentScope().size();
                s += "\n"+codeStack.pop().render();
                s += "\n invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;";
                s += "\n invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z \n pop";
            }
            s = s + "\n areturn";
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
        List<ST> paramsST = new ArrayList<>();

        ExprList args = c.getExpList();
        for(Node e: args.getList())
        {
            e.accept(this);
            argsST.add(codeStack.pop());
            e.accept(scopeVisitor);
            paramsST.add(templateFromTypeStr(scopeVisitor.getStack().pop()));
        }
        LValueList ret = c.getLValueList();
        int j = 0;
        ST template_r = null;
        for(LValue r: ret.getList())
        {
            r.accept(scopeVisitor);
            template_r = groupTemplate.getInstanceOf("attrReturn");
            template_r.add("prefix", getPrefix(scopeVisitor.getStack().pop()));
            template_r.add("num", scopeVisitor.getCurrentScope().get(r.getID().getName()).second());
            returnST.add(template_r);
        }
        ST template = groupTemplate.getInstanceOf("call");
        template.add("args", argsST);
        template.add("params", paramsST);
        template.add("return", returnST);
        template.add("name", "_" + c.getId().getName());
        template.add("filename", this.fileName);
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