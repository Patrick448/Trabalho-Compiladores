package ast;

import java.util.HashMap;

public abstract class Node {
      
      private int line,col, uid;
      
      public Node(int l, int c){
           line = l;
           col = c;
           this.uid = IdGenerator.getNextId();
      }

      public String dotString(){
            String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
            return s;
        }

        
      
      public int getLine(){ return line;}
      public int getCol(){ return col;}  
      public int getUid(){ return uid;}
      public abstract Object interpret(HashMap<String,Integer> m);
      
}
