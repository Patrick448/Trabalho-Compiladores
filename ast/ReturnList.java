package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class ReturnList extends Node {

    private List<Return> returnList;

    public ReturnList(int l, int c, Return first) {
        super(l, c);
        returnList = new ArrayList<Return>();
        if (first != null)
            returnList.add(first);
    }

    public void addNode(Return r) {
        returnList.add(r);
    }

    public List<Return> getReturnList() {
        return returnList;
    }
    
    @Override
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        return returnList;
    }

    @Override
    public String dotString() {
        String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        for (Return p : returnList) {
            s += getUid() + "--" + p.getUid() + "\n";
            s += p.dotString();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "return ";
        for (Return p : returnList) {
            s += p.toString() + ", ";
        }
        return s;
    }
    
}
