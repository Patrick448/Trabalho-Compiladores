package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap; 
import java.util.Stack;
import java.util.List;
 
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
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
      Object object = e.interpret(variables, functions, datas, returns);
      String className = object.getClass().getSimpleName();
      
      if(className.equals("Integer"))
         {
            System.out.print("" + object);
         }
         else if(className.equals("Float"))
         {
            System.out.print("" + object);
         }
         else if(className.equals("Boolean"))
         {
            System.out.print("" + object);
         }
         else if(className.equals("String"))
         {
            if(object.equals("'\\n'"))
            {
               System.out.print("\n");
            }
            else if(object.equals("'\\t'"))
            {
               System.out.print("\t");
            }
            else if(object.equals("'\\b'"))
            {
               System.out.print("\b");
            }
            else if(object.equals("'\\r'"))
            {
               System.out.print("\r");
            }
            else if(object.equals("'\\\\'"))
            {
               System.out.print("\\");
            }
            else if(object.equals("'\\''"))
            {
               System.out.print("'");
            }

            else
            {
               String s = (String)object;
               System.out.print("" + s.charAt(1));
            }
         }

         else if(className.equals("DataInstance")){
            System.out.print(object.toString());
         }
         return 0;
      }
}
