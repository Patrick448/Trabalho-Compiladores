package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import visitors.Visitor;

import java.util.List;

public class Read extends Node {
      
      private LValue v; 
      
      public Read(int l, int c, LValue v){
           super(l,c);
           this.v  = v;
      }
      
      public Expr getExpr(){ return v;}
      
      //@Override
      public String toString(){
         return   "read " + v.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(v != null){
           s+= getUid() +"--"+v.getUid()+"\n"; 
           s+= v.dotString();  
        }
        
        return s;
    }
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){

        Scanner keyboard = new Scanner(System.in);
        String read = keyboard.next();
        variables.peek().put((String)v.getID().getName(), read);
        keyboard.close();

        return read;
    }

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
