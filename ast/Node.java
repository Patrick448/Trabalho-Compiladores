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
            return "";
        }
      
      public int getLine(){ return line;}
      public int getCol(){ return col;}  
      public int getUid(){ return uid;}
      public abstract int interpret(HashMap<String,Integer> m);
      
}
