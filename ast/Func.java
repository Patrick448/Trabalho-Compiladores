package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;

public class Func extends Node {

      ID id;
      Node params;
      Node returns;
      Node cmdList;

      public Func(int l, int c, ID id, ParamsList params, Node returns, Node cmdList) {
            super(l, c);
            this.id = id;
            this.params = params;
            this.returns = returns;
            this.cmdList = cmdList;
            
            //System.out.println("alo \n" +params.toString());
      }

      @Override
      public Object interpret(HashMap<String, Object> m) {
            if(cmdList != null) cmdList.interpret(m);
            
            return 0;
      }

      public String dotString(){
            String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
            
            s+= getUid() +"--"+id.getUid()+"\n";
            s+=id.dotString();

            if(cmdList != null){
               s+= getUid() +"--"+cmdList.getUid()+"\n"; 
               s+= cmdList.dotString();  
            }

            if(params != null){
                  System.out.println("params: " + params.dotString());
               s+= getUid() +"--"+params.getUid()+"\n"; 
               s+= params.dotString();  
            }
            
            
            return s;
        }

      public String toString() {
            String paramsStr = params != null ? params.toString() : "";
            String returnsStr = returns != null ? returns.toString() : "";
            String cmdListStr = cmdList != null ? cmdList.toString() : "";

            

          return "Func " + id.toString() + "(" + paramsStr + ") ret (" +returnsStr+ ") {" + cmdListStr + "}";
      }

}
