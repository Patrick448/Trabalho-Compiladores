package ast;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Expr
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

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
      
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
     if(e.interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer"))
          {
               int x = (Integer)e.interpret(variables, functions, datas, returns);
               variables.put((String)lValue.getID().getName(), x);
               return x;
          }
          else if(e.interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Float"))
          {
               float y = (Float)e.interpret(variables, functions, datas, returns);
               variables.put((String)lValue.getID().getName(), y);
               return y;
          }
          else if(e.interpret(variables, functions, datas,returns).getClass().getSimpleName().equals("String"))
          {
               String k = (String)e.interpret(variables, functions, datas, returns);
               variables.put((String)lValue.getID().getName(), k);
               return k;
          }
          else if(e.interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Boolean"))
          {
               boolean b = (boolean)e.interpret(variables, functions, datas, returns);
               variables.put((String)lValue.getID().getName(), b);
               return b;
          }
          return null;
      }   
}
