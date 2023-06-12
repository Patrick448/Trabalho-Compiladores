package ast;

import java.util.HashMap;
import java.util.Stack;

import visitors.Visitable;
import visitors.Visitor;

import java.util.List;

public abstract class Node implements Visitable{
      
      private int line,col, uid;
      
      public Node(int l, int c){
           line = l;
           col = c;
           this.uid = IdGenerator.getNextId();
      }

      public String dotString(){
            String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
            return s;
        }

        
      
      public int getLine(){ return line;}
      public int getCol(){ return col;}  
      public int getUid(){ return uid;}
      public Object tryInterpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas,  Stack<List<Object>> returns){
            try{
                  return this.interpret(variables, functions, datas, returns);
            }
            catch(Exception e){
                  System.out.println("Error at line "+this.getLine()+", column "+this.getCol());
                  //e.printStackTrace(System.out);
                  System.exit(0);

                  return null;
            }
      }


      @Override
      public abstract void accept(Visitor v);

      public abstract Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas,  Stack<List<Object>> returns);
      
}
