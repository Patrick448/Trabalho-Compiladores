package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */ 
import java.util.HashMap; 

public class Char extends Expr {
      
      private String l;
     
      public  Char(int l, int c, String v){
           super(l,c);
           this.l = v;
      }
      
      public String getValue(){ return l;}
      
      //@Override
      public String toString(){
         return   "" + l ; 
      }

      public String dotString(){
            String s = getUid() + " [label=\"Char<"+l+">\"]\n";
            
            return s;
        }
      
      public Object interpret(HashMap<String,Object> m){
            return l;
      }
}
