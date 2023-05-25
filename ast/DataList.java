package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataList extends Node {
    
    Node id;
    List<Node> list;
    int uid = IdGenerator.getNextId();

    public DataList(int l, int c,Node data) {
          super(l, c);
          list = new ArrayList<Node>();
          list.add(data);
    }

    
    public void addNode(Node n) {
        list.add(n);
    }

    @Override
    public Object interpret(HashMap<String, Integer> m) {
          return 0;
    }

    public String dotString(){
        String s = getUid() + " [label=DataList]\n";

        for(Node n : list) {
            s+= getUid() +"--"+n.getUid()+"\n";
            s+= n.dotString();
        }

        return s;
    }

    public String toString() {
        String s = "DataList:{";

        for(Node n : list) {
            s+= n.toString() + ", ";
        }
        s+="}";

        return s;
    }

}
