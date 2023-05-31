package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
 
public class Print extends Node {
      
      private Expr e; 
      
      public Print(int l, int c, Expr e){
           super(l,c);
           this.e  = e;
      }
      
      public Expr getExpr(){ return e;}
      
      //@Override
      public String toString(){
         return   "print " + e.toString(); 
      }

      public String dotString(){
        String s = getUid() + " [label=\""+this.getClass().getSimpleName()+"\"]\n";
     
        if(e != null){
           s+= getUid() +"--"+e.getUid()+"\n"; 
           s+= e.dotString();  
        }
        
        return s;
    }
      public Object interpret(HashMap<String,Object> m){
         if(e.interpret(m).getClass().getSimpleName().equals("Integer"))
         {
            System.out.println("" + e.interpret(m));
         }
         else if(e.interpret(m).getClass().getSimpleName().equals("Float"))
         {
            System.out.println("" + e.interpret(m));
         }
         else if(e.interpret(m).getClass().getSimpleName().equals("Boolean"))
         {
            System.out.println("" + e.interpret(m));
         }
         else if(e.interpret(m).getClass().getSimpleName().equals("String"))
         {
            if(e.interpret(m).equals("'\\n'"))
            {
               System.out.println("\n");
            }
            else if(e.interpret(m).equals("'\\t'"))
            {
               System.out.println("\t");
            }
            else if(e.interpret(m).equals("'\\b'"))
            {
               System.out.println("\b");
            }
            else if(e.interpret(m).equals("'\\r'"))
            {
               System.out.println("\r");
            }
            else if(e.interpret(m).equals("'\\\\'"))
            {
               System.out.println("\\");
            }
            else if(e.interpret(m).equals("'\\''"))
            {
               System.out.println("'");
            }
            else
            {
               String s = (String)e.interpret(m);
               System.out.println("" + s.charAt(1));
            }
         }
         return 0;
      }
}
