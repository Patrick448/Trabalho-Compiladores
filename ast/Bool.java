package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */ 
import java.util.HashMap; 

public class Bool extends Expr {
      
      private boolean l;
     
      public  Bool(int l, int c, boolean v){
           super(l,c);
           this.l = v;
      }
      
      public boolean getValue(){ return l;}
      
      //@Override
      public String toString(){
         return   "" + l ; 
      }

      public String dotString(){
            String s = getUid() + " [label=\"Bool<"+l+">\"]\n";
            
            return s;
        }
      
      public Object interpret(HashMap<String,Object> m){
            return l;
      }
}
