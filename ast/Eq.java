package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 

public class Eq extends BinOP {
      public Eq(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof And){
            s += "(" + s + ")";
         }
         String ss = getRight().toString();
         if( getRight() instanceof And){
            ss = "(" + ss+ ")";
         }
         return   s + " == " + ss;
      }
      
      public Object interpret(HashMap<String,Object> m){
         if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(m) == (Integer)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Float)getLeft().interpret(m) == (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("String"))
         {
            return (String)getLeft().interpret(m) == (String)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("boolean"))
         {
            return (boolean)getLeft().interpret(m) == (boolean)getRight().interpret(m);
         }
         return null;
      }
}
