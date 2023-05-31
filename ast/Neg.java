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
