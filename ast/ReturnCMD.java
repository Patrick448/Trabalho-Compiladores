package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;
 
public class ReturnCMD extends Node {
      
      private ExprList e; 
      
      public ReturnCMD(int l, int c, ExprList e){
           super(l,c);
           this.e  = e;
      }
      
      public ExprList getList(){ return e;}
      
      //@Override
      public String toString(){
         return   "" + e.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(e != null){
           s+= getUid() +"--"+e.getUid()+"\n"; 
           s+= e.dotString();  
        }
        
        return s;
    }
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
      returns.push(e);
      return true;
   }
}
