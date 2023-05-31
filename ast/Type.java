package ast;

/*
 */
 
import java.util.HashMap; 

public class Type extends Expr {
      
      private String l;
     
      public Type(int l, int c, String name){
           super(l,c);
           this.l = name;
      }
      
      public String getName(){ return l;}
      
      //@Override
      public String toString(){
         return   l; 
      }
      
      public Object interpret(HashMap<String,Object> m){
          return m.get(l);
      }
}
