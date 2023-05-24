package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;

public class Func extends Node {

      ID id;
      Node params;
      Node returns;
      Node cmdList;

      public Func(int l, int c, ID id, Node params, Node returns, Node cmdList) {
            super(l, c);
            this.id = id;
            this.params = params;
            this.returns = returns;
            this.cmdList = cmdList;
      }

      @Override
      public int interpret(HashMap<String, Integer> m) {
            if(cmdList != null) cmdList.interpret(m);
            
            return 0;
      }

      public String dotString(){
            String s = getUid() + " [label=\""+ id+"()\"]\n";
   
            return s;
        }

      public String toString() {
            String paramsStr = params != null ? params.toString() : "";
            String returnsStr = returns != null ? returns.toString() : "";
            String cmdListStr = cmdList != null ? cmdList.toString() : "";

            

          return "Func " + id.toString() + "(" + paramsStr + ") ret (" +returnsStr+ ") {" + cmdListStr + "}";
      }

}
