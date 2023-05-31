package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */
 
import java.util.HashMap; 
public class Sub extends BinOP {

      public Sub(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Sub || getLeft() instanceof Add){
            s = "(" + s + ")";
         }
         return   s + " - " + getRight().toString();
      }

      public String dotString(){
         String s = getUid() + " [label= \"-\"]\n";
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         
         return s;
     }
      
      public Object interpret(HashMap<String,Object> m){
         if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer") && getRight().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(m) - (Integer)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float") && getRight().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Float)getLeft().interpret(m) - (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Integer") && getRight().interpret(m).getClass().getSimpleName().equals("Float"))
         {
            return (Integer)getLeft().interpret(m) - (Float)getRight().interpret(m);
         }
         else if(getLeft().interpret(m).getClass().getSimpleName().equals("Float") && getRight().interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            return (Float)getLeft().interpret(m) - (Integer)getRight().interpret(m);
         }
         return null;
      }
      
}
