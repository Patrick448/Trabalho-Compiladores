package ast;

import java.util.HashMap; 
import java.util.Stack;
import java.util.List;


public class CallFunctionVet extends Expr {
      
      private ID id;
      private ExprList le;
      private Expr e; 
      
      public CallFunctionVet(int l, int c, ID i, ExprList le, Expr e){
           super(l, c);
           this.le = le;
           this.e  = e;
           this.id = i;
      }
      
      public Expr getLExp(){ return e;} 
      public ExprList getExpList(){   return le; }
      public ID getId(){return id;}
      
      public String toString(){
        String s = id.toString() + "(";
        if(le!=null)
        {
          s+= le.toString();
        }
        s+= ")";
        if(e!=null)
        {
          s+= "[" + e.toString() + "]";
        }
        return s;
      }

     public String dotString(){
        String s = getUid() + " [label= \"CallFunction\"]\n";
        s+= getUid() +"--"+id.getUid()+"\n";
        s+=id.dotString();
        if(le!=null)
        {
            s+= getUid() +"--"+le.getUid()+"\n";
            s+=le.dotString();
        }
        if(e!=null)
        {
            s+= getUid() +"--"+e.getUid()+"\n";
            s+=e.dotString();
        }
        
        return s;
    }

    private void put_params_value(Func f, Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns)
    {
        int i=0;
        if(f.getParams() != null)
        {
            for(Param n : f.getParams().getParamsList())
            {
                f.getValuesParams().put(n.getId().getName(),le.getList().get(i).interpret(variables, functions, datas, returns));
                i++;
            }
        }
    }
      
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
        for(Func f : functions)
        {
            if(f.getId().getName().equals(id.getName()))
            {
                if(f.getParams()!=null)
                {
                    if(f.getParams().getParamsList().size()==le.getList().size()){
                        put_params_value(f, variables, functions, datas, returns);
                        f.interpret(variables, functions, datas, returns);
                        int max = returns.peek().size();
                        if((Integer)e.interpret(variables, functions, datas, returns)<max)
                        {
                            return returns.peek().get((Integer)e.interpret(variables, functions, datas, returns));
                        }
                    }
                }
            }
            else if(e==null)
            {
                f.interpret(variables, functions, datas, returns);
                int max = returns.peek().size();
                if((Integer)e.interpret(variables, functions, datas, returns)<max)
                {
                    return returns.peek().get((Integer)e.interpret(variables, functions, datas, returns));
                }
            }
        }
        return 0;
    }
}
