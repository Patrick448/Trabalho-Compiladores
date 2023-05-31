package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeclList extends Node {
    
    Node id;
    List<Node> list;

    public DeclList(int l, int c,Node decl) {
          super(l, c);
          list = new ArrayList<Node>();
          list.add(decl);
    }

    
    public void addNode(Node n) {
        list.add(n);
    }

    @Override
    public Object interpret(HashMap<String, Object> m) {
          return 0;
    }

    public String dotString(){
        String s = getUid() + " [label=DeclList]\n";

        for(Node n : list) {
            s+= getUid() +"--"+n.getUid()+"\n";
            s+= n.dotString();
        }

        return s;
    }

    public String toString() {
        String s = "";

        for(Node n : list) {
            s+= n.toString() + ",";
        }
        return s;
    }

}
