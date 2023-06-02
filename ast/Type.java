package ast;

/*
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class Type extends Expr {
      
      private String l;
     
      public Type(int l, int c, String name){
           super(l,c);
           this.l = name;
      }
      
      public String getName(){ return l;}
      
      //@Override
      public String toString(){
         return   l; 
      }

        @Override
        public String dotString(){
            String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"<"+ getName() +">"+"\"]\n";
            return s;
        }
      
        public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
          return variables.get(l);
      }
}
