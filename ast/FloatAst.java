package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */ 
import java.util.HashMap; 

public class FloatAst extends Expr {
      
      private float l;
     
      public  FloatAst(int l, int c, float v){
           super(l,c);
           this.l = v;
      }
      
      public float getValue(){ return l;}
      
      //@Override
      public String toString(){
         return   "" + l ; 
      }

      public String dotString(){
            String s = getUid() + " [label=\"Float<"+l+">\"]\n";
            
            return s;
        }
      
      public Object interpret(HashMap<String,Object> m){
            return l;
      }
}
