package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;


public class Add extends BinOP {

      public Add(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Add || getLeft() instanceof Sub ){
            s = "(" + s + ")";
         }
         return   s + " + " + getRight().toString();
      }

      public String dotString(){
         String s = getUid() + " [label= \"+\"]\n";
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         
         return s;
     }
      
     public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
      if(getLeft().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer") && getRight().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(variables, functions, datas, returns) + (Integer)getRight().interpret(variables, functions, datas, returns);
         }
         else if(getLeft().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Float") && getRight().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Float"))
         {
            return (Float)getLeft().interpret(variables, functions, datas, returns) + (Float)getRight().interpret(variables, functions, datas, returns);
         }
         return 0;
      }
      
}
