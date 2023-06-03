package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class ReturnList extends Node {

    private List<Expr> returnList;

    public ReturnList(int l, int c, Expr first) {
        super(l, c);
        returnList = new ArrayList<Expr>();
        if (first != null)
            returnList.add(first);
    }

    public void addNode(Expr r) {
        returnList.add(r);
    }

    public List<Expr> getReturnList() {
        return returnList;
    }
    
    @Override
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
        return returnList;
    }

    @Override
    public String dotString() {
        String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        for (Expr p : returnList) {
            s += getUid() + "--" + p.getUid() + "\n";
            s += p.dotString();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "return ";
        for (Expr p : returnList) {
            s += p.toString() + ", ";
        }
        return s;
    }
    
}
