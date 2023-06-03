package ast;

import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class SubUni extends Expr {
      private Expr e;
      
      public SubUni(int lin, int col, Expr e){
           super(lin,col);
           this.e = e;
      }
      
      public void setExpr(Expr n){  this.e = n; }
      
      public Expr getExpr(){ return this.e;}

      public String toString(){
         String s = e.toString();
         if(e instanceof Add || e instanceof Sub || e instanceof Div || e instanceof Add || e instanceof Rest || e instanceof SubUni){
            s += "(" + s + ")";
         }
         return   "! " + s;
      }
      public String dotString(){
        String s = getUid() + " [label= \"-\"]\n";
        s+= getUid() +"--"+e.getUid()+"\n";
        s+=e.dotString();
        
        return s;
    }

    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
      if(e.interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer"))
        {
           return -(Integer)e.interpret(variables, functions, datas, returns);
        }
        if(e.interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Float"))
        {
           return -(Float)e.interpret(variables, functions, datas, returns);
        }
        return 0;
     }
      
}