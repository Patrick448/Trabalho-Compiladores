package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */
 
import java.util.HashMap; 
public class Add extends BinOP {

      public Add(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Add){
            s = "(" + s + ")";
         }
         return   s + " + " + getRight().toString();
      }

      public String dotString(){
         String s = getUid() + " [label= \"+\"]\n";
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         
         return s;
     }
      
      public Object interpret(HashMap<String,Integer> m){
          return (Integer)getLeft().interpret(m) + (Integer)getRight().interpret(m);
      }
      
}
