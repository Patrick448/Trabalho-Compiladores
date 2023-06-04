package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class ExprList extends Node {
    
    private List<Expr> list;

    public ExprList(int l, int c,Expr data) {
          super(l, c);
          list = new ArrayList<Expr>();
          list.add(data);
    }

    
    public void addNode(Expr n) {
        list.add(n);
    }

    public List<Expr> getList() {
        return list;
    }
    
    @Override
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){  
        List<Object> lo = new ArrayList<>();
        for(Expr i : list)
        {
            lo.add(i.interpret(variables, functions, datas, returns));
        }
        return lo;
    }

    public String dotString(){
        String s = getUid() + " [label=ExprList]\n";

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
