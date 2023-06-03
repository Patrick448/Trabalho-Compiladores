package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;
 
public class LValue extends Expr {
      
      private ID id;
      
      public LValue(int l, int c, ID id){
           super(l,c);
           this.id  = id;
      }
      
      public ID getID(){ 
         return id;
      }
      
      //@Override
      public String toString(){
         return  id.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        s+= getUid() +"--"+id.getUid()+"\n";
        s+= id.dotString();  
        
        return s;
    }

    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
            return variables.peek().get(id.getName());
    }
}
