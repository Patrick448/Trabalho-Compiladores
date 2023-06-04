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
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)lValue.getID().getName());
                         di.put(lValue.getID().getName(), x);
                    }
                    else
                    {
                         Stack<LValue> stack_aux = new Stack<LValue>();
                         stack_aux.push(aux);
                         while(aux.getExpr()!=null && aux.getLValue()!=null)
                         {
                              aux = aux.getLValue();
                              stack_aux.push(aux);
                         }
                         List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                         stack_aux.pop();
                         int i=0;
                         while(i<stack_aux.size())
                         {
                              if(stack_aux.size() != 1)
                              {
                                   lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                              }
                              System.out.println(lt);
                              stack_aux.pop();
                         }
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), x);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    Stack<LValue> stack_aux = new Stack<LValue>();
                    stack_aux.push(aux);
                    while(aux.getExpr()!=null && aux.getLValue()!=null)
                    {
                         aux = aux.getLValue();
                         stack_aux.push(aux);
                    }
                    List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                    System.out.println(stack_aux.peek().getID().getName());
                    stack_aux.pop();
                    int i=0;
                    while(i<stack_aux.size())
                    {
                         lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                         stack_aux.pop();
                    }
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), x);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), x);
               }
               return x;
          }
          else if(className.equals("Float"))
          {
               float y = (Float)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)lValue.getID().getName());
                         di.put(lValue.getID().getName(), y);
                    }
                    else
                    {
                         Stack<LValue> stack_aux = new Stack<LValue>();
                         while(aux.getExpr()!=null && aux.getLValue()!=null)
                         {
                              stack_aux.push(aux);
                              aux = aux.getLValue();
                         }
                         List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                         stack_aux.pop();
                         int i=0;
                         while(i<stack_aux.size())
                         {
                              if(stack_aux.size() != 1)
                              {
                              lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                              }
                              stack_aux.pop();
                         }
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), y);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    Stack<LValue> stack_aux = new Stack<LValue>();
                    stack_aux.push(aux);
                    while(aux.getExpr()!=null && aux.getLValue()!=null)
                    {
                         stack_aux.push(aux);
                         aux = aux.getLValue();
                    }
                    List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                    stack_aux.pop();
                    int i=0;
                    while(i<stack_aux.size())
                    {
                         lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                         stack_aux.pop();
                    }
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), y);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), y);
               }
               return y;
          }
          else if(className.equals("String"))
          {
               String k = (String)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)lValue.getID().getName());
                         di.put(lValue.getID().getName(), k);
                    }
                    else
                    {
                         Stack<LValue> stack_aux = new Stack<LValue>();
                         while(aux.getExpr()!=null && aux.getLValue()!=null)
                         {
                              stack_aux.push(aux);
                              aux = aux.getLValue();
                         }
                         List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                         stack_aux.pop();
                         int i=0;
                         while(i<stack_aux.size())
                         {
                              if(stack_aux.size() != 1)
                              {
                              lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                              }
                              stack_aux.pop();
                         }
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), k);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    Stack<LValue> stack_aux = new Stack<LValue>();
                    stack_aux.push(aux);
                    while(aux.getExpr()!=null && aux.getLValue()!=null)
                    {
                         stack_aux.push(aux);
                         aux = aux.getLValue();
                    }
                    List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                    stack_aux.pop();
                    int i=0;
                    while(i<stack_aux.size())
                    {
                         lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                         stack_aux.pop();
                    }
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), k);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), k);
               }
               return k;
          }
          else if(className.equals("Boolean"))
          {
               boolean b = (boolean)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)lValue.getID().getName());
                         di.put(lValue.getID().getName(), b);
                    }
                    else
                    {
                         Stack<LValue> stack_aux = new Stack<LValue>();
                         while(aux.getExpr()!=null && aux.getLValue()!=null)
                         {
                              stack_aux.push(aux);
                              aux = aux.getLValue();
                         }
                         List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                         stack_aux.pop();
                         int i=0;
                         while(i<stack_aux.size())
                         {
                              if(stack_aux.size() != 1)
                              {
                              lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                              }
                              stack_aux.pop();
                         }
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), b);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    Stack<LValue> stack_aux = new Stack<LValue>();
                    stack_aux.push(aux);
                    while(aux.getExpr()!=null && aux.getLValue()!=null)
                    {
                         stack_aux.push(aux);
                         aux = aux.getLValue();
                    }
                    List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                    stack_aux.pop();
                    int i=0;
                    while(i<stack_aux.size())
                    {
                         lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                         stack_aux.pop();
                    }
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), b);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), b);
               }
               return b;
          }
          else if(className.equals("DataInstance")){
               DataInstance d = (DataInstance)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)lValue.getID().getName());
                         di.put(lValue.getID().getName(), d);
                    }
                    else
                    {
                         Stack<LValue> stack_aux = new Stack<LValue>();
                         while(aux.getExpr()!=null && aux.getLValue()!=null)
                         {
                              stack_aux.push(aux);
                              aux = aux.getLValue();
                         }
                         List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                         stack_aux.pop();
                         int i=0;
                         while(i<stack_aux.size())
                         {
                              if(stack_aux.size() != 1)
                              {
                              lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                              }
                              stack_aux.pop();
                         }
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), d);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    Stack<LValue> stack_aux = new Stack<LValue>();
                    stack_aux.push(aux);
                    while(aux.getExpr()!=null && aux.getLValue()!=null)
                    {
                         stack_aux.push(aux);
                         aux = aux.getLValue();
                    }
                    List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                    stack_aux.pop();
                    int i=0;
                    while(i<stack_aux.size())
                    {
                         lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                         stack_aux.pop();
                    }
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), d);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), d);
               }
               return d;
          }
          else if(className.equals("ArrayList")){
               List<DataInstance> a = (List<DataInstance>)object;
               if (lValue.getExpr()==null && lValue.getLValue()!=null)
               {
                    LValue aux = lValue.getLValue();
                    if(aux.getLValue()==null)
                    {
                         DataInstance di =  (DataInstance)variables.peek().get((String)lValue.getID().getName());
                         di.put(lValue.getID().getName(), a);
                    }
                    else
                    {
                         Stack<LValue> stack_aux = new Stack<LValue>();
                         while(aux.getExpr()!=null && aux.getLValue()!=null)
                         {
                              stack_aux.push(aux);
                              aux = aux.getLValue();
                         }
                         List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                         stack_aux.pop();
                         int i=0;
                         while(i<stack_aux.size())
                         {
                              if(stack_aux.size() != 1)
                              {
                              lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                              }
                              stack_aux.pop();
                         }
                         DataInstance di =  (DataInstance)lt.get((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns));
                         di.put(lValue.getID().getName(), a);
                         lt.set((Integer)lValue.getLValue().getExpr().interpret(variables, functions, datas, returns), di);
                    }
               }
               else if(lValue.getLValue()!=null && lValue.getExpr()!=null)
               {
                    LValue aux = lValue.getLValue();
                    Stack<LValue> stack_aux = new Stack<LValue>();
                    stack_aux.push(aux);
                    while(aux.getExpr()!=null && aux.getLValue()!=null)
                    {
                         stack_aux.push(aux);
                         aux = aux.getLValue();
                    }
                    List lt =  (List)variables.peek().get(stack_aux.peek().getID().getName());
                    stack_aux.pop();
                    int i=0;
                    while(i<stack_aux.size())
                    {
                         lt = (List)lt.get((Integer)stack_aux.peek().getExpr().interpret(variables, functions, datas, returns));
                         stack_aux.pop();
                    }
                    lt.set((Integer)lValue.getExpr().interpret(variables, functions, datas, returns), a);
               }
               else{
                    variables.peek().put(lValue.getID().getName(), a);
               }
               return a;
          }
          return 0;
      }   
}
