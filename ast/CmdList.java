package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class CmdList extends Node {
    
    private List<Node> list;

    public CmdList(int l, int c, Node data) {
          super(l, c);
          list = new ArrayList<Node>();
          if(data != null)
            list.add(data);
    }

    
    public void addNode(Node n) {
        list.add(n);
    }

    public List<Node> getList() {
        return list;
    }

    @Override
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
        for(Node n : list) {
            Object o = n.interpret(variables, functions, datas, returns);
            try
            {
                Boolean run_return = (Boolean)o;
                if(n.getClass().getSimpleName().equals("ReturnCMD") || run_return)
                {
                    return true;
                }
            }
            catch(Exception e){}
        }
        return false;
    }

    public String dotString(){
        String s = getUid() + " [label=CmdList]\n";

        for(Node n : list) {
            s+= getUid() +"--"+n.getUid()+"\n";
            s+= n.dotString();
        }

        return s;
    }

    public String toString() {
        String s = "CmdList:{";

        for(Node n : list) {
            s+= n.toString() + "; ";
        }

        s+="}";

        return s;
    }

}
