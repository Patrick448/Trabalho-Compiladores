package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
 
import java.util.HashMap; 
import java.util.Stack;

import visitors.Visitor;

import java.util.List;

public class ID extends Expr {
      
      private String l;
     
      public ID(int l, int c, String name){
           super(l,c);
           this.l = name;
      }
      
      public String getName(){ return l;}
      
      //@Override
      public String toString(){
         return   l; 
      }

            
      public String dotString(){
        String s = getUid() + " [label=\"ID<"+l+">\"]\n";
        
        return s;
    }

    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
      return variables.peek().get(l);
    }

    @Override
    public void accept(Visitor v) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
