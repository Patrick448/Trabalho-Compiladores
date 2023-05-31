package ast;

import java.util.HashMap;

public class Null extends Expr {
      
      public  Null(int l, int c){
           super(l,c);
      }
      
      public Object getValue(){ return null;}
      
      //@Override
      public String toString(){
         return   "" + null ; 
      }

      public String dotString(){
            String s = getUid() + " [label=\"null\"]\n";
            
            return s;
        }
      
      public Object interpret(HashMap<String,Object> m){
            return "null";
      }
}