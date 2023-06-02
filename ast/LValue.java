package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;
 
public class LValue extends Expr {
      
      private ID lval; 
      
      public LValue(int l, int c, ID lval){
           super(l,c);
           this.lval  = lval;
      }
      
      public ID getID(){ return lval;}
      
      //@Override
      public String toString(){
         return  lval.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(lval != null){
           s+= getUid() +"--"+lval.getUid()+"\n"; 
           s+= lval.dotString();  
        }
        
        return s;
    }
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        
        return lval.interpret(variables, functions, datas, returns);
      }
}
