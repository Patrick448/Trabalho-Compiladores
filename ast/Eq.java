package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 
import java.util.Stack;

import visitors.Visitor;

import java.util.List;

public class Eq extends BinOP {
      public Eq(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof And){
            s += "(" + s + ")";
         }
         String ss = getRight().toString();
         if( getRight() instanceof And){
            ss = "(" + ss+ ")";
         }
         return   s + " == " + ss;
      }

      public String dotString(){
         String s = getUid() + " [label= \"==\"]\n";
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         
         return s;
      }
      
      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
         Object ol = getLeft().tryInterpret(variables, functions, datas, returns);
         Object or = getRight().tryInterpret(variables, functions, datas, returns);

         if(ol.getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)ol == (Integer)or;
         }
         else if(ol.getClass().getSimpleName().equals("Float"))
         {
            return (Float)ol == (Float)or;
         }
         else if(ol.getClass().getSimpleName().equals("String"))
         {
            return (String)ol == (String)or;
         }
         else if(getLeft().tryInterpret(variables, functions, datas, returns).getClass().getSimpleName().equals("boolean"))
         {
            return (boolean)ol == (boolean)or;
         }
         else if(getLeft().tryInterpret(variables, functions, datas, returns).getClass().getSimpleName().equals("ArrayList"))
         {
            return (List)ol == (List)or;
         }
         else if(getLeft().tryInterpret(variables, functions, datas, returns).getClass().getSimpleName().equals("DataInstance"))
         {
            return (DataInstance)ol == (DataInstance)or;
         }
         return 0;
      }

      @Override
      public void accept(Visitor v) {
         // TODO Auto-generated method stub
         throw new UnsupportedOperationException("Unimplemented method 'accept'");
      }
}
