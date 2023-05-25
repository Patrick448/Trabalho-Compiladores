package ast;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Expr
 */
 
import java.util.HashMap; 

public class Attr extends Node {
      
      private LValue lValue;
      private Expr e; 
      
      public Attr(int l, int c, LValue lValue, Expr e){
           super(l, c);
           this.lValue = lValue;
           this.e  = e;
      }
      
      public LValue getLValue(){ return lValue;} 
      public Expr getExp(){   return e; }
      
      public String toString(){
          return lValue.toString() + " = " + e.toString();
      }

     public String dotString(){
        String s = getUid() + " [label= \"=\"]\n";
        s+= getUid() +"--"+lValue.getUid()+"\n";
        s+=lValue.dotString();
        s+= getUid() +"--"+e.getUid()+"\n";
        s+=e.dotString();
        
        return s;
    }
      
      public Object interpret(HashMap<String,Integer> m){
           int x = (Integer)e.interpret(m);
           m.put((String)lValue.getID().getName(), x);
           return x;
      }   
}
