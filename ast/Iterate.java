package ast;

/*
 * 
 * 
 */
 
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;

public class Iterate extends Node {
      
      private Expr condition;
      private Node cmd;
      
      public Iterate(int lin, int col, Expr condition, Node cmd){
           super(lin,col);
           this.condition = condition;
           this.cmd = cmd;
      }
      
      
      public String toString(){
         String condStr = condition.toString();
         String cmdStr =  cmd.toString();
         String s = "";

         s += "iterate (" + condStr +") " + cmdStr ;
         return  s; 
      }
      
      public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
        while((Boolean)condition.interpret(variables, functions, datas, returns)){
          	cmd.interpret(variables, functions, datas, returns);
        }
        return 0;
      }
      
}
