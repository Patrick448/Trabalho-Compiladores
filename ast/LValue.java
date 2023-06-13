package ast;

import java.util.ArrayList;

import java.util.HashMap; 
import java.util.Stack;

import visitors.Visitor;

import java.util.List;
 
public class LValue extends Expr {
      
      private ID id;
      private LValue lv;
      private Expr e;
      
      public LValue(int l, int c, ID id, LValue a, Expr e){
           super(l,c);
           this.id  = id;
           this.lv = a;
           this.e = e;
      }
      
      public ID getID(){ 
         return id;
      }
      
      public LValue getLValue() {
          return lv;
      }

      public Expr getExpr() {
          return e;
      }

      //@Override
      public String toString(){
         String s = "";

         if(lv != null){
            s += lv.toString()+".";
         }
         if(e != null){
            s += e.toString()+".";
         }
         if(id != null){
            s += id.toString()+".";
         }
         return  s; 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(lv != null){
         s+= getUid() +"--"+ lv.getUid()+"\n";
         s+= lv.dotString(); 
        }
        if(e != null){
         s+= getUid() +"--"+ e.getUid()+"\n";
         s+= e.dotString(); 
        }
        if(id != null){
         s+= getUid() +"--"+ id.getUid()+"\n";
         s+= id.dotString(); 
        }
        
        return s;
    }

    public void attribute(Object value, Stack<HashMap<String,Object>> variables){

      if(lv != null){
         Object o = lv.interpret(variables, null, null, null);
         
         if(e != null){
            int index = (Integer)e.interpret(variables, null, null, null);
            ((List)o).set(index, value);
         }
 
         if(o instanceof DataInstance)
            ((DataInstance)o).put(id.getName(), value);
        
      } else
            variables.peek().put(id.getName(), value);
    }

    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){

      if(lv == null){
         Object o = variables.peek().get(id.getName());

         if(e != null){
            int index = (Integer)e.interpret(variables, functions, datas, returns);
            return ((List)o).get(index);
         }else{
            return o;
         }
         
      }else{
         Object o = lv.interpret(variables, functions, datas, returns);

         if(o instanceof ArrayList){
            int index = (Integer)e.interpret(variables, functions, datas, returns);
            return ((List)o).get(index);
         }else{
            return ((DataInstance)lv.interpret(variables, functions, datas, returns)).get(id.getName());

         }

      }
    }

   @Override
   public void accept(Visitor v) {v.visit(this);}
}
