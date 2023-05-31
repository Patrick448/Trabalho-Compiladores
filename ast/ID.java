package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
 
import java.util.HashMap; 

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


    
      public Object interpret(HashMap<String,Object> m){
          return m.get(l);
      }
}
