package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Stack;
import java.util.List;

public class Func extends Node {

      private ID id;
      private ParamsList params;
      private TypeList returns;
      private CmdList cmdList;
      private HashMap<String, Object> valuesParams;

      public Func(int l, int c, ID id, ParamsList params, TypeList returns, CmdList cmdList) {
            super(l, c);
            this.id = id;
            this.params = params;
            this.returns = returns;
            this.cmdList = cmdList;
            this.valuesParams = new HashMap<String, Object>();
        }

      public ParamsList getParams() {
          return params;
      }

      public TypeList getReturns() {
          return returns;
      }

      public ID getId() {
          return id;
      }

      public CmdList getCmdList() {
          return cmdList;
      }
      
      public HashMap<String, Object> getValuesParams() {
          return valuesParams;
      }

      @Override
      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
            variables.push(valuesParams);
            if(cmdList != null) {return cmdList.interpret(variables, functions, datas, returns);};
            variables.pop();
            valuesParams.clear();
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
               s+= getUid() +"--"+params.getUid()+"\n"; 
               s+= params.dotString();  
            }

            if(returns != null){
               s+= getUid() +"--"+returns.getUid()+"\n"; 
               s+= returns.dotString();  
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
