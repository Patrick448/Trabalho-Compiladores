package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class Diff extends BinOP {
      public Diff(int lin, int col, Expr l, Expr r){
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
         return   s + " != " + ss;
      }

      public String dotString(){
         String s = getUid() + " [label= \"!=\"]\n";
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         
         return s;
      }
      
      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
         if(getLeft().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(variables, functions, datas, returns) != (Integer)getRight().interpret(variables, functions, datas, returns);
         }
         else if(getLeft().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Float"))
         {
            return (Float)getLeft().interpret(variables, functions, datas, returns) != (Float)getRight().interpret(variables, functions, datas, returns);
         }
         else if(getLeft().interpret(variables, functions, datas,returns).getClass().getSimpleName().equals("String"))
         {
            return (String)getLeft().interpret(variables, functions, datas, returns) != (String)getRight().interpret(variables, functions, datas, returns);
         }
         else if(getLeft().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("boolean"))
         {
            return (boolean)getLeft().interpret(variables, functions, datas, returns) != (boolean)getRight().interpret(variables, functions, datas, returns);
         }
         return 0;
      }
}
