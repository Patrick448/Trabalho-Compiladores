package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class If extends Node {
      
      private Node teste;
      private Node thn;
      private Node els;
      
      public If(int lin, int col, Node teste, Node thn, Node els){
           super(lin,col);
           this.teste = teste;
           this.thn = thn;
           this.els = els;
      }
      
            
      public If(int lin, int col, Node teste, Node thn){
           super(lin,col);
           this.teste = teste;
           this.thn = thn;
           this.els = null;
      }
      
      public String toString(){
         String s = teste.toString();
         String sthn =  thn.toString();
         String sels =  els != null ? " : " + els.toString(): "" ;
         if(thn instanceof If){
             sthn = "(" + sthn + ")";
         }
         if(els != null && els instanceof If){
             sels = "(" + sels + ")";
         }
         s += " ? " + sthn + sels ;
         return  s; 
      }
      
      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        boolean n = (boolean)teste.interpret(variables, functions, datas, returns);  
        if(n){
              return thn.interpret(variables, functions, datas, returns);
        }
        else if(els !=null){
            return els.interpret(variables, functions, datas, returns);
        }
        return n;
      }
      
}
