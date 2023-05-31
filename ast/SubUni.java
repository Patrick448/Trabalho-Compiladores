package ast;

import java.util.HashMap; 

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

     public Object interpret(HashMap<String,Object> m){
        if(e.interpret(m).getClass().getSimpleName().equals("Integer"))
        {
           return -(Integer)e.interpret(m);
        }
        if(e.interpret(m).getClass().getSimpleName().equals("Float"))
        {
           return -(Float)e.interpret(m);
        }
        return null;
     }
      
}