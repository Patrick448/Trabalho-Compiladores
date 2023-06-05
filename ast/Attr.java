package ast;

import java.nio.file.FileAlreadyExistsException;

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

    public List findDataInstace(LValue aux, Boolean vet, Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns)
    {
          Stack<LValue> stack_aux = new Stack<LValue>();
          stack_aux.push(aux);
          while(aux.getLValue()!=null)
          {
               aux = aux.getLValue();
               stack_aux.push(aux);
          }
          List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
          stack_aux.pop();
          int i=0;
          while(i<stack_aux.size())
          {
               if((stack_aux.size() != 1 || vet))
               {
                    lt = (List)lt.get((Integer)stack_aux.peek().getExpr().tryInterpret(variables, functions, datas, returns));
               }
               stack_aux.pop();
          }
          return lt;
    }
    
      
    /* public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
     
          Object object = e.tryInterpret(variables, functions, datas, returns);
          String className = object.getClass().getSimpleName();

          System.out.println(lValue);
          if(className.equals("Integer"))
          {
               int x = (Integer)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)aux.getID().getName());
                         di.put(lValue.getID().getName(), x);
                    }
                    else
                    {
                         List f = findDataInstace(aux, false, variables, functions, datas, returns);
                         DataInstance di =  (DataInstance)f.get((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), x);
                         f.set((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    List f = findDataInstace(aux, true, variables, functions, datas, returns);
                    f.set((Integer)lValue.getExpr().tryInterpret(variables, functions, datas, returns), x);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), x);
               }
          }
          else if(className.equals("Float"))
          {
               float y = (Float)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)aux.getID().getName());
                         di.put(lValue.getID().getName(), y);
                    }
                    else
                    {
                         List f = findDataInstace(aux, false, variables, functions, datas, returns);
                         DataInstance di =  (DataInstance)f.get((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), y);
                         f.set((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    List f = findDataInstace(aux, true, variables, functions, datas, returns);
                    f.set((Integer)lValue.getExpr().tryInterpret(variables, functions, datas, returns), y);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), y);
               }
          }
          else if(className.equals("String"))
          {
               String k = (String)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)aux.getID().getName());
                         di.put(lValue.getID().getName(), k);
                    }
                    else
                    {
                         List f = findDataInstace(aux, false, variables, functions, datas, returns);
                         DataInstance di =  (DataInstance)f.get((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), k);
                         f.set((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    List f = findDataInstace(aux, true, variables, functions, datas, returns);
                    f.set((Integer)lValue.getExpr().tryInterpret(variables, functions, datas, returns), k);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), k);
               }
          }
          else if(className.equals("Boolean"))
          {
               boolean b = (boolean)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)aux.getID().getName());
                         di.put(lValue.getID().getName(), b);
                    }
                    else
                    {
                         List f = findDataInstace(aux, false, variables, functions, datas, returns);
                         DataInstance di =  (DataInstance)f.get((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), b);
                         f.set((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    List f = findDataInstace(aux, true, variables, functions, datas, returns);
                    f.set((Integer)lValue.getExpr().tryInterpret(variables, functions, datas, returns), b);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), b);
               }
          }
          else if(className.equals("DataInstance")){
               DataInstance d = (DataInstance)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)aux.getID().getName());
                         di.put(lValue.getID().getName(), d);
                    }
                    else
                    {
                         List f = findDataInstace(aux, false, variables, functions, datas, returns);
                         DataInstance di =  (DataInstance)f.get((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), d);
                         f.set((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    List f = findDataInstace(aux, true, variables, functions, datas, returns);
                    f.set((Integer)lValue.getExpr().tryInterpret(variables, functions, datas, returns), d);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), d);
               }
          }
          else if(className.equals("ArrayList")){
               List<DataInstance> a = (List<DataInstance>)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)aux.getID().getName());
                         di.put(lValue.getID().getName(), a);
                    }
                    else
                    {
                         List f = findDataInstace(aux, false, variables, functions, datas, returns);
                         DataInstance di =  (DataInstance)f.get((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), a);
                         f.set((Integer)lValue.getLValue().getExpr().tryInterpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    List f = findDataInstace(aux, true, variables, functions, datas, returns);
                    f.set((Integer)lValue.getExpr().tryInterpret(variables, functions, datas, returns), a);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), a);
               }
          }
          return 0;
      }    */


      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
          Object value = e.interpret(variables, functions, datas, returns); 
          //System.out.println("l: " + lValue);    
          lValue.attribute(value, variables);
          return 0;
      }   
}