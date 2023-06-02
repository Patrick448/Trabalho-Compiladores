package ast;

import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class Return extends Node{
    private Expr e;

    public Return(int l, int c, Expr v) {
        super(l, c);
        this.e = v;
    }

    public Expr getE() {
        return e;
    }

    @Override
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        return e;
    }

    @Override
    public String dotString(){
        String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        s+= getUid() +"--"+e.getUid()+"\n";
        s+=e.dotString();
        return s;
    }
    
    public String toString(){
        String s = e.toString();
        
        return s;
    }
}
