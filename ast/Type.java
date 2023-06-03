package ast;

/*
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class Type extends Expr {
      
      private String l;
      private Boolean isVet;
      private int dim;

      public Type(int l, int c, String name, Boolean iv){
           super(l,c);
           this.l = name;
           this.isVet = iv;
      }
      
      public String getName(){ return l;}
      
      public Boolean getIsVet() {
          return isVet;
      }

      //@Override
      public String toString(){
        String s = l;
        if(isVet)
        {
          s+="[]";
        }
        return s; 
      }

      public void addDimension(){
        this.dim++;
      }

        @Override
        public String dotString(){
            String dimString = "";
            if(isVet)
            {
              for(int i = 0; i < dim; i++)
              {
                dimString += "[]";
              }
            }

            String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"<"+ getName() +">"+ dimString+"\"]\n";
            return s;
        }
      
        public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
          return variables.peek().get(l);
      }
}
