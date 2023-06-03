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
      
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
     
          Object object = e.interpret(variables, functions, datas, returns);
          String className = object.getClass().getSimpleName();
          if(className.equals("Integer"))
          {
               int x = (Integer)object;
               variables.peek().put((String)lValue.getID().getName(), x);
               return x;
          }
          else if(className.equals("Float"))
          {
               float y = (Float)object;
               variables.peek().put((String)lValue.getID().getName(), y);
               return y;
          }
          else if(className.equals("String"))
          {
               String k = (String)object;
               variables.peek().put((String)lValue.getID().getName(), k);
               return k;
          }
          else if(className.equals("Boolean"))
          {
               boolean b = (boolean)object;
               variables.peek().put((String)lValue.getID().getName(), b);
               return b;
          }
          else if(className.equals("DataInstance")){
               DataInstance d = (DataInstance)object;
               variables.peek().put((String)lValue.getID().getName(), d);
               return d;
          }
          else if(className.equals("ArrayList")){
               List a = (List)object;
               variables.peek().put((String)lValue.getID().getName(), (List)object);
               System.out.print(a);
          }
          return 0;
      }   
}
