package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParamsList extends Node {

    List<Param> paramsList;

    public ParamsList(int l, int c, Param first) {
        super(l, c);
        paramsList = new ArrayList<Param>();
        if (first != null)
            paramsList.add(first);
    }

    public void addNode(Param p) {
        paramsList.add(p);
    }

    @Override
    public Object interpret(HashMap<String, Object> m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interpret'");
    }

    @Override
    public String dotString() {
        String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        for (Param p : paramsList) {
            s += getUid() + "--" + p.getUid() + "\n";
            s += p.dotString();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (Param p : paramsList) {
            s += p.toString() + ", ";
        }
        return s;
    }
    
}
