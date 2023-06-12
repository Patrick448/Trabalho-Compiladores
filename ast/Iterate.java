package ast;

/*
 * 
 * 
 */
 
import java.util.HashMap; 
import java.util.Stack;

import visitors.Visitor;

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
      
      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
        int i = (Integer)condition.tryInterpret(variables, functions, datas, returns);
        while(i>0){
          	cmd.tryInterpret(variables, functions, datas, returns);
            i--;
        }
        return 0;
      }


      @Override
      public void accept(Visitor v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
      }
      
}
