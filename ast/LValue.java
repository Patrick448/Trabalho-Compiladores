package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;
 
public class LValue extends Expr {
      
      private LValue lval;
      private ID id;
      
      public LValue(int l, int c, ID id){
           super(l,c);
           this.id  = id;
      }

      /*public LValue(int l, int c, LValue lval){
         super(l,c);
         this.lval  = lval;
    }*/
      
      public ID getID(){ 
         return id;
      }
      
      //@Override
      public String toString(){
         return  id.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(lval != null){
           s+= getUid() +"--"+lval.getUid()+"\n"; 
           s+= lval.dotString();  
           s+= getUid() +"--"+id.getUid()+"\n";
           s+= id.dotString();  
        }
        
        return s;
    }
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
        if(lval != null){
            DataInstance instance = (DataInstance)variables.peek().get(id.getName());
            variables.push(instance.getAttributes());
            return lval.interpret(variables, functions, datas, returns);
        }
        else{
            return variables.peek().get(id.getName());
        }
        
      }
}
