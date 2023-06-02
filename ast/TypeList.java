package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class TypeList extends Node {

    private List<Type> list;

    public TypeList(int l, int c, Type first) {
        super(l, c);
        list = new ArrayList<Type>();
        if (first != null)
            list.add(first);
    }

    public void addNode(Type t) {
        list.add(t);
    }

    public List<Type> getReturnTypes() {
        return list;
    }

    @Override
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        return 0;
    }

    @Override
    public String dotString() {
        String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        for (Type t : list) {
            s += getUid() + "--" + t.getUid() + "\n";
            s += t.dotString();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (Type t : list) {
            s += t.toString() + ", ";
        }
        return s;
    }
    
}
