package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;

public class Decl extends Node {

      Node id;
      Node declList;
      Node type;

      public Decl(int l, int c, Node id, Node type) {
            super(l, c);
            this.id = id;
            this.type = type;
      }

      @Override
      public int interpret(HashMap<String, Integer> m) {
            return 0;
      }

      public String toString() {
          return type.toString() + " " + id.toString();
      }

}
