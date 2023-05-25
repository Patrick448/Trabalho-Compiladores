package ast;

/*
 * 
 * 
 */
 
import java.util.HashMap; 
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
      
      public Object interpret(HashMap<String,Integer> m){
          while((Boolean)condition.intepret(m)){
          	cmd.interpret(m);
          }
          return 0;
      }
      
}
