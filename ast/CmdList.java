package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CmdList extends Node {
    
    Node id;
    List<Node> list;

    public CmdList(int l, int c,Node data) {
          super(l, c);
          list = new ArrayList<Node>();
          if(data != null)
            list.add(data);
    }

    
    public void addNode(Node n) {
        list.add(n);
    }

    @Override
    public Object interpret(HashMap<String, Object> m) {
          for(Node n : list) {
              n.interpret(m);
          }
          return 0;
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
            s+= n.toString() + ", ";
        }
        s+="}";

        return s;
    }

}
