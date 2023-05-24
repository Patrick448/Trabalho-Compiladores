package ast;

/*
 * Esta classe representa um comando de .
 * 
 */
import java.util.HashMap;

public class Data extends Node {

      String id;
      Node declList;

      public Data(int l, int c, String id, Node declList) {
            super(l, c);
            this.id = id;
            this.declList = declList;
      }

      @Override
      public int interpret(HashMap<String, Integer> m) {
            return 0;
      }

      public String dotString(){
            String s = getUid() + " [label= \"<"+id+">\"]\n";
   
            return s;
        }

      public String toString() {
            String declListString = declList != null ? declList.toString() : "";

          return "Data: {" + id + " {" + declListString + "}}";
      }

}
