package ast;

/*
 * Esta classe representa uma expressão de Multiplicação.
 * Expr * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class Rest extends BinOP {
      public Rest(int lin, int col, Expr l, Expr r){
           super(lin,col,l,r);
      }
      
      //@Override
      public String toString(){
         String s = getLeft().toString();
         if(getLeft() instanceof Mul || getLeft() instanceof Add || getRight() instanceof Sub || getRight() instanceof Div || getRight() instanceof Rest){
            s += "(" + s + ")";
         }
         String ss = getRight().toString();
         if( getRight() instanceof Add || getRight() instanceof Sub ){
            ss = "(" + ss+ ")";
         }
         return   s + " % " + ss;
      }

      public String dotString(){
         String s = getUid() + " [label= \"*\"]\n";
         s+= getUid() +"--"+getLeft().getUid()+"\n";
         s+=getLeft().dotString();
         s+= getUid() +"--"+getRight().getUid()+"\n";
         s+=getRight().dotString();
         
         return s;
      }
      
      public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
         if(getLeft().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer") && getRight().interpret(variables, functions, datas, returns).getClass().getSimpleName().equals("Integer"))
         {
            return (Integer)getLeft().interpret(variables, functions, datas, returns) * (Integer)getRight().interpret(variables, functions, datas, returns);
         }
         return null;
      }
}
