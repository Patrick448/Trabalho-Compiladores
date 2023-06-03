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
          String key = "";
          if(lValue.getLValue()!=null){
               if(lValue.getLValue().getLValue()==null)
               {
                    key += (String)lValue.getLValue().getID().getName();
               }
               else
               {
                    key += (String)lValue.getLValue().getLValue().getID().getName();
               }
          }
          else
          {
               key += (String)lValue.getID().getName();
          }
          if(className.equals("Integer"))
          {
               int x = (Integer)object;
               if(lValue.getLValue()!=null && lValue.getID()!=null){
                    if(lValue.getLValue().getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get(key);
                         di.put(lValue.getID().getName(), x);
                    }
                    else
                    {
                         List lt =  (List)variables.peek().get(key);
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), x);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null){
                    List lt =  (List)variables.peek().get(key);
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), x);
               }
               else{
                    variables.peek().put(key, x);
               }
               return x;
          }
          else if(className.equals("Float"))
          {
               float y = (Float)object;
               if(lValue.getLValue()!=null && lValue.getID()!=null){
                    DataInstance di =  (DataInstance)variables.peek().get(key);
                    di.put(lValue.getID().getName(), y);
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null){
                    List lt =  (List)variables.peek().get(key);
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), y);
               }
               return y;
          }
          else if(className.equals("String"))
          {
               String k = (String)object;
               if(lValue.getLValue()!=null && lValue.getID()!=null){
                    DataInstance di =  (DataInstance)variables.peek().get(key);
                    di.put(lValue.getID().getName(), k);
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null){
                    List lt =  (List)variables.peek().get(key);
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), k);
               }
               else{
                    variables.peek().put(key, k);
               }
               return k;
          }
          else if(className.equals("Boolean"))
          {
               boolean b = (boolean)object;
               if(lValue.getLValue()!=null && lValue.getID()!=null){
                    DataInstance di =  (DataInstance)variables.peek().get(key);
                    di.put(lValue.getID().getName(), b);
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null){
                    List lt =  (List)variables.peek().get(key);
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), b);
               }
               else{
                    variables.peek().put(key, b);
               }
               return b;
          }
          else if(className.equals("DataInstance")){
               DataInstance d = (DataInstance)object;
               if(lValue.getLValue()!=null && lValue.getID()!=null){
                    DataInstance di =  (DataInstance)variables.peek().get(key);
                    di.put(lValue.getID().getName(), d);
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null){
                    List lt =  (List)variables.peek().get(key);
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), d);
               }
               else{
                    variables.peek().put(key, d);
               }
               return d;
          }
          else if(className.equals("ArrayList")){
               List<DataInstance> a = (List<DataInstance>)object;
               if(lValue.getLValue()!=null && lValue.getID()!=null){
                    DataInstance di =  (DataInstance)variables.peek().get(key);
                    di.put(lValue.getID().getName(), a);
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null){
                    List lt =  (List)variables.peek().get(key);
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), a);
               }
               else{
                    variables.peek().put(key, a);
               }
               return a;
          }
          return 0;
      }   
}
