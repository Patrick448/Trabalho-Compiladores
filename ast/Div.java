package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 

public class Div extends BinOP {
      public Div(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Mul || getLeft() instanceof Add || getRight() instanceof Sub || getRight() instanceof Div || getRight() instanceof Rest){
            s += "(" + s + ")";
         }
         String ss = getRight().toString();
         if( getRight() instanceof Add || getRight() instanceof Sub ){
            ss = "(" + ss+ ")";
         }
         return   s + " / " + ss;
      }
      
      public Object interpret(HashMap<String,Object> m){
         if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer") && getRight().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(m) / (Integer)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float") && getRight().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Float)getLeft().interpret(m) / (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer") && getRight().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Integer)getLeft().interpret(m) / (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float") && getRight().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Float)getLeft().interpret(m) / (Integer)getRight().interpret(m);
         }
         return null;
      }
}
