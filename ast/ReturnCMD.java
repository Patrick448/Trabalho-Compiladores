package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;
 
public class ReturnCMD extends Node {
      
      private ReturnList r; 
      
      public ReturnCMD(int l, int c, ReturnList r){
           super(l,c);
           this.r  = r;
      }
      
      public ReturnList getList(){ return r;}
      
      //@Override
      public String toString(){
         return   "" + r.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(r != null){
           s+= getUid() +"--"+r.getUid()+"\n"; 
           s+= r.dotString();  
        }
        
        return s;
    }
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
      returns.push(r);
      return r;
   }
}
