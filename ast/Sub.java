package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class Sub extends BinOP {

      public Sub(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Sub || getLeft() instanceof Add){
            s = "(" + s + ")";
         }
         return   s + " - " + getRight().toString();
      }

      public String dotString(){
         String s = getUid() + " [label= \"-\"]\n";
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         
         return s;
     }
      
     public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
         Object ol = getLeft().interpret(variables, functions, datas, returns);
         Object or = getRight().interpret(variables, functions, datas, returns);
         if(ol.getClass().getSimpleName().equals("Integer") && or.getClass().getSimpleName().equals("Integer"))
         {
            
            return (Integer)ol - (Integer)or;
         }
         else if(ol.getClass().getSimpleName().equals("Float") && or.getClass().getSimpleName().equals("Float"))
         {
            return (Float)ol - (Float)or;
         }
         return 0;
      }
      
}
