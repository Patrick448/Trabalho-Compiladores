package visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ast.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class JavaGenVisitor extends Visitor {
    private STGroup groupTemplate;
    //private ST type, stmt, expr;
    //private List<ST> funcs, params;

    private Stack<ST> codeStack = new Stack<>();
    private String fileName;
    private ScopeVisitor scopeVisitor;

    public JavaGenVisitor(ScopeVisitor scopeVisitor, String filename) {
        this.scopeVisitor = scopeVisitor;
        groupTemplate = new STGroupFile("./template/java.stg");
        this.fileName = fileName;
    }

    @Override
    public void visit(Prog p) {
        ST template = groupTemplate.getInstanceOf("prog");
        fileName = "Testando";
        template.add("name", fileName);

        p.getFuncList().accept(this);
        template.add("funclist", codeStack.pop());

        p.getDataList().accept(this);
        template.add("datalist", codeStack.pop());

        System.out.println(template.render());

    }


    @Override
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

    @Override
    public void visit(Func f) {
        ST template = groupTemplate.getInstanceOf("func");
        String name = f.getId().getName();

        TypeList typeList = f.getReturns();
        if (typeList != null) {
            typeList.accept(this);
            template.add("returntypes", codeStack.pop());
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
    }

    @Override
    public void visit(TypeList tl) {
        List<Type> list = tl.getReturnTypes();


        if (list.size() == 1) {
            list.get(0).accept(this);
        } else {
            ST template = groupTemplate.getInstanceOf("multiple_returns");
            codeStack.push(template);
        }

    }

    @Override
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

    @Override
    public void visit(Param p) {
        ST template = groupTemplate.getInstanceOf("param");
        p.getType().accept(this);
        template.add("type", codeStack.pop());

        p.getId().accept(this);
        template.add("id", codeStack.pop());

        codeStack.push(template);
    }


    @Override
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
            typeTemplate = new ST(t.getName());
        }

        codeStack.push(typeTemplate);
    }

    @Override
    public void visit(CmdList c) {
        ST template = groupTemplate.getInstanceOf("cmdlist");

        List<Node> cmdlist = c.getList();
        List<ST> cmdlistST = new ArrayList<>();

        for (Node cmd : cmdlist) {
            cmd.accept(this);
            cmdlistST.add(codeStack.pop());
        }

        template.add("cmds", cmdlistST);
        codeStack.push(template);
    }

    @Override
    public void visit(Print p) {
        ST template = groupTemplate.getInstanceOf("print");
        p.getExpr().accept(this);
        template.add("expr", codeStack.pop());
        codeStack.push(template);
    }

    @Override
    public void visit(Add a) {
        ST template = groupTemplate.getInstanceOf("add_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Sub a) {
        ST template = groupTemplate.getInstanceOf("sub_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Div a) {
        ST template = groupTemplate.getInstanceOf("div_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Mul a) {
        ST template = groupTemplate.getInstanceOf("mul_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Rest a) {
        ST template = groupTemplate.getInstanceOf("mod_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(And a) {
        ST template = groupTemplate.getInstanceOf("and_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(GreaterThan a) {
        ST template = groupTemplate.getInstanceOf("gt_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(LessThan a) {
        ST template = groupTemplate.getInstanceOf("lt_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Diff a) {
        ST template = groupTemplate.getInstanceOf("diff_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(SubUni a) {
        ST template = groupTemplate.getInstanceOf("sub_uni_expr");
        a.getExpr().accept(this);

        template.add("expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Neg a) {
        ST template = groupTemplate.getInstanceOf("not_expr");
        a.getExpr().accept(this);

        template.add("expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Eq a) {
        ST template = groupTemplate.getInstanceOf("equals_expr");
        a.getLeft().accept(this);
        a.getRight().accept(this);

        template.add("right_expr", codeStack.pop());
        template.add("left_expr", codeStack.pop());

        codeStack.push(template);
    }

    @Override
    public void visit(Int a) {
        codeStack.push(new ST(String.valueOf(a.getValue())));

    }

    @Override
    public void visit(Char a) {
        codeStack.push(new ST("\"" + a.getValue() + "\""));
    }

    @Override
    public void visit(Bool a) {
        codeStack.push(new ST(String.valueOf(a.getValue())));
    }

    @Override
    public void visit(FloatAst a) {
        codeStack.push(new ST(String.valueOf(a.getValue())));
    }

    @Override
    public void visit(Iterate a) {
        ST template = groupTemplate.getInstanceOf("iterate");
        a.getCondition().accept(this);
        a.getCmd().accept(this);
        template.add("cmdlist", codeStack.pop());
        template.add("expr", codeStack.pop());

        codeStack.push(template);

    }

    @Override
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

    @Override
    public void visit(Data a) {
        ST template = groupTemplate.getInstanceOf("data");
        a.getId().accept(this);
        a.getDeclList().accept(this);
        template.add("declist", codeStack.pop());
        template.add("name", codeStack.pop());

        codeStack.push(template);
    }

    @Override
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

    @Override
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

    @Override
    public void visit(Decl a) {
        ST template = groupTemplate.getInstanceOf("decl");
        a.getId().accept(this);
        a.getType().accept(this);
        template.add("type", codeStack.pop());
        template.add("name", codeStack.pop());
        codeStack.push(template);
    }

    @Override
    public void visit(Attr a) {
        ST template = groupTemplate.getInstanceOf("attr");
        a.getLValue().accept(this);
        a.getExp().accept(this);
        template.add("expr", codeStack.pop());
        template.add("id", codeStack.pop());
        codeStack.push(template);
    }

    @Override
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
            //attrAccess.add("id", codeStack.pop());
            //codeStack.push(attrAccess);

        }

       /* if(lvChild != null){
            lvChild.accept(this);
            template.add("lvalue", codeStack.pop());

            if(expr != null){
                expr.accept(this);
                template.add("expr", codeStack.pop());
            }
            codeStack.push(template);

        }else{
            id.accept(this);
            attrAccess.add("id", codeStack.pop());
            codeStack.push(attrAccess);
        }*/

    }


    @Override
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

    @Override
    public void visit(ID i) {

        codeStack.push(new ST("_"+ i.getName()));
    }

    @Override
    public void visit(Read i) {
        ST template = groupTemplate.getInstanceOf("read");
        i.getLValue().accept(this);
        template.add("lvalue", codeStack.pop());
        codeStack.push(template);
    }

    @Override
    public void visit(ReturnCMD r) {
        codeStack.push(new ST("//return cmd"));

    }

    @Override
    public void visit(CallFunction c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(CallFunctionVet c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

}
