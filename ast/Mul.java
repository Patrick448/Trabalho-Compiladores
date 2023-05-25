package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 

public class Mul extends BinOP {
      public Mul(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Mul || getLeft() instanceof Add){
            s += "(" + s + ")";
         }
         String ss = getRight().toString();
         if( getRight() instanceof Add){
            ss = "(" + ss+ ")";
         }
         return   s + " * " + ss;
      }
      
      public Object interpret(HashMap<String,Integer> m){
          return (Integer)getLeft().interpret(m) * (Integer)getRight().interpret(m);
      }
}
