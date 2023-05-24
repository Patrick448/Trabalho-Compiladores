package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FuncList extends Node {
    
    Node id;
    List<Func> list;

    public FuncList(int l, int c,Func data) {
          super(l, c);
          list = new ArrayList<Func>();
          list.add(data);
    }

    
    public void addNode(Func n) {
        list.add(n);
    }

    @Override
    public int interpret(HashMap<String, Integer> m) {

          for(Func n : list) {
              if(n.id.getName().equals("main")) {
                  n.interpret(m);
              }
          }
          return 0;
    }

    public String dotString(){
        String s = getUid() + " [label=FuncList]\n";

        for(Node n : list) {
            s+= getUid() +"--"+n.getUid()+"\n";
            s+= n.dotString();
        }

        return s;
    }

    public String toString() {
        String s = "FuncList:{";

        for(Node n : list) {
            s+= n.toString() + ", ";
        }
        s+="}";

        return s;
    }

}
