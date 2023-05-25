package ast;

/*
 * Esta classe representa um comando de .
 * 
 */
import java.util.HashMap;

public class Data extends Node {

      Node id;
      Node declList;

      public Data(int l, int c, Node id, Node declList) {
            super(l, c);
            this.id = id;
            this.declList = declList;
      }

      @Override
      public Object interpret(HashMap<String, Integer> m) {
            return 0;
      }

      public String dotString(){
            String s = getUid() + " [label= \""+this.getClass().getSimpleName()+"\"]\n";
            s+= getUid() +"--"+id.getUid()+"\n";
            s+=id.dotString();
   
            return s;
        }

      public String toString() {
            String declListString = declList != null ? declList.toString() : "";

          return "Data: {" + id + " {" + declListString + "}}";
      }

}
