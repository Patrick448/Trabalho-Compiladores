package visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import ast.Add;
import ast.And;
import ast.Attr;
import ast.Bool;
import ast.CallFunction;
import ast.CallFunctionVet;
import ast.Char;
import ast.CmdList;
import ast.Data;
import ast.DataList;
import ast.Diff;
import ast.Div;
import ast.Eq;
import ast.FloatAst;
import ast.Func;
import ast.FuncList;
import ast.GreaterThan;
import ast.ID;
import ast.If;
import ast.Int;
import ast.Iterate;
import ast.LValue;
import ast.LessThan;
import ast.Mul;
import ast.Neg;
import ast.New;
import ast.Print;
import ast.Prog;
import ast.Read;
import ast.Rest;
import ast.ReturnCMD;
import ast.Sub;
import ast.SubUni;
import ast.Type;

public class JavaGenVisitor extends Visitor{
    private STGroup groupTemplate;
    private ST type, stmt, expr;
    //private List<ST> funcs, params;

    private Stack<ST> codeStack = new Stack<>();
    private String fileName;
    private ScopeVisitor scopeVisitor;

    public JavaGenVisitor(ScopeVisitor scopeVisitor, String filename){
        this.scopeVisitor = scopeVisitor;
        groupTemplate = new STGroupFile("./template/java.stg");
        this.fileName = fileName;
    }

    @Override
    public void visit(Prog p) {
        ST template = groupTemplate.getInstanceOf("prog");
        fileName = "Testando";
        template.add("name", fileName);
        //funcs = new ArrayList<ST>();

        p.getFuncList().accept(this);
        ST result = codeStack.pop();
       /* for(Func f : p.getFuncList().getList()) {
            f.accept(this);
        }
        template.add("funcs", funcs);*/

        template.add("funclist", result);

        System.out.println(template.render());

    }


    @Override
    public void visit(FuncList f) {
        ST template = groupTemplate.getInstanceOf("funclist");
        List<ST> funcs = new ArrayList<ST>();

        for(Func func : f.getList()) {
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
        template.add("name", "_"+name);
        codeStack.push(template);
    }

    @Override
    public void visit(CmdList c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Print p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Add a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Sub a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Div a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Mul a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Rest a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(And a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(GreaterThan a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LessThan a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Diff a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(SubUni a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Neg a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Eq a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Int a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Char a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Bool a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(FloatAst a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Iterate a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(If a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Data a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(DataList a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Type t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Attr a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LValue l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(New n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(ID i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Read i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(ReturnCMD r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
