package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class LValueList extends Node {
    
    private List<LValue> list;

    public LValueList(int l, int c,LValue data) {
          super(l, c);
          list = new ArrayList<LValue>();
          list.add(data);
    }

    
    public void addNode(LValue n) {
        list.add(n);
    }

    public List<LValue> getList() {
        return list;
    }

    @Override
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
          return list;
    }

    public String dotString(){
        String s = getUid() + " [label=LValueList]\n";

        for(Node n : list) {
            s+= getUid() +"--"+n.getUid()+"\n";
            s+= n.dotString();
        }

        return s;
    }

    public String toString() {
        String s = "ExprList:{";

        for(Node n : list) {
            s+= n.toString() + ", ";
        }
        s+="}";

        return s;
    }

}
