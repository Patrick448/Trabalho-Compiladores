package ast;

import java.util.HashMap; 

public class Neg extends Expr {
   
      private Expr e;
      
      public Neg(int lin, int col, Expr e){
           super(lin,col);
           this.e = e;
      }
      
      public void setExpr(Expr n){  this.e = n; }
      
      public Expr getExpr(){ return this.e;}

      public String toString(){
         String s = e.toString();
         if(e instanceof And || e instanceof Neg || e instanceof LessThan || e instanceof GreaterThan || e instanceof Eq || e instanceof Diff){
            s = "(" + s + ")";
         }
         return   "! " + s;
      }

      public String dotString(){
        String s = getUid() + " [label= \"!\"]\n";
        s+= getUid() +"--"+e.getUid()+"\n";
        s+=e.dotString();
        
        return s;
    }

     public Object interpret(HashMap<String,Object> m){
        if(e.interpret(m).getClass().getSimpleName().equals("Boolean"))
        {
           return !(Boolean)e.interpret(m);
        }
        return null;
     }
      
}
