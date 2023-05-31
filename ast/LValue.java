package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
 
public class LValue extends Expr {
      
      private ID lval; 
      
      public LValue(int l, int c, ID lval){
           super(l,c);
           this.lval  = lval;
      }
      
      public ID getID(){ return lval;}
      
      //@Override
      public String toString(){
         return   "print " + lval.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(lval != null){
           s+= getUid() +"--"+lval.getUid()+"\n"; 
           s+= lval.dotString();  
        }
        
        return s;
    }
      public Object interpret(HashMap<String,Object> m){
        
        return lval.interpret(m);
      }
}
