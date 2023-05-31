package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 

public class And extends BinOP {
      public And(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof And){
            s = "(" + s + ")";
         }
         return   s + " && " + getRight().toString();
      }

      public Object interpret(HashMap<String,Object> m){
         System.out.println("" + getLeft().interpret(m).getClass().getSimpleName());
         if(getLeft().interpret(m).getClass().getSimpleName().equals("Boolean"))
         {
            return (boolean)getLeft().interpret(m) && (boolean)getRight().interpret(m);
         }
         return null;
      }
}
