package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 

public class LessThan extends BinOP {
      public LessThan(int lin, int col, Expr l, Expr r){
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
         return   s + " < " + ss;
      }

      public String dotString(){
         String s = getUid() + " [label= \"<\"]\n";
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         
         return s;
      }
      
      public Object interpret(HashMap<String,Object> m){
         if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer") && getRight().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(m) < (Integer)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float") && getRight().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Float)getLeft().interpret(m) < (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer") && getRight().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Integer)getLeft().interpret(m) < (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float") && getRight().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Float)getLeft().interpret(m) < (Integer)getRight().interpret(m);
         }
         return null;
      }
}
