package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */ 
import java.util.HashMap; 

public class Num extends Expr {
      
      private int l;
     
      public  Num(int l, int c, int v){
           super(l,c);
           this.l = v;
      }
      
      public int getValue(){ return l;}
      
      //@Override
      public String toString(){
         return   "" + l ; 
      }

      public String dotString(){
            String s = getUid() + " [label=\"Num<"+l+">\"]\n";
            
            return s;
        }
      
      public Object interpret(HashMap<String,Integer> m){
            return l;
      }
}
