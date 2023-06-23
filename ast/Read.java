package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import visitors.Visitor;
import visitors.ScopeVisitor;
import java.util.List;

public class Read extends Node {
      
      private LValue vl; 
      
      public Read(int l, int c, LValue v){
           super(l,c);
           this.vl  = v;
      }
      
      public LValue getLValue(){ return vl;}
      
      //@Override
      public String toString(){
         return   "read " + vl.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(vl != null){
           s+= getUid() +"--"+vl.getUid()+"\n"; 
           s+= vl.dotString();  
        }
        
        return s;
    }
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns, ScopeVisitor v){

        Scanner keyboard = new Scanner(System.in);
        String read = keyboard.next().substring(0,1);
        variables.peek().put((String)vl.getID().getName(), read);
        keyboard.close();

        return read;
    }

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
