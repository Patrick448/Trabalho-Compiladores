package ast;

/*
 * Esta classe representa um comando de .
 * 
 */
import java.util.HashMap;

public class Cmd extends Node {


      public Cmd(int l, int c) {
            super(l, c);

      }

      @Override
      public int interpret(HashMap<String, Integer> m) {
            return 0;
      }

      public String toString() {

          return "cmd";
      }

}
