package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class NodeList extends Node {
    
    Node id;
    List<Node> list;

    public NodeList(int l, int c,Node data) {
          super(l, c);
          list = new ArrayList<Node>();
          list.add(data);
    }

    
    public void addNode(Node n) {
        list.add(n);
    }

    @Override
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        return 0;
    }

    public String toString() {
        String s = "";

        for(Node n : list) {
            s+= n.toString() + ", ";
        }

        return s;
    }

}
