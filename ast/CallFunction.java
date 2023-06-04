package ast;

import java.util.HashMap; 
import java.util.Stack;
import java.util.List;


public class CallFunction extends Expr {
      
      private ID id;
      private ExprList e;
      private LValueList l; 
      
      public CallFunction(int l, int c, ID i, ExprList e, LValueList v){
           super(l, c);
           this.l = v;
           this.e  = e;
           this.id = i;
      }
      
      public LValueList getLValueList(){ return l;} 
      public ExprList getExpList(){   return e; }
      public ID getId(){return id;}
      
      public String toString(){
          String s = id.toString() + "(";
          if(e!=null)
          {
            s+= e.toString();
          }
          s+= ")";
          if(l!=null)
          {
            s+= "<" + l.toString() + ">";
          }
          return s;
      }

     public String dotString(){
        String s = getUid() + " [label= \"CallFunction\"]\n";
        s+= getUid() +"--"+id.getUid()+"\n";
        s+=id.dotString();
        if(e!=null)
        {
            s+= getUid() +"--"+e.getUid()+"\n";
            s+=e.dotString();
        }
        if(l!=null)
        {
            s+= getUid() +"--"+l.getUid()+"\n";
            s+=l.dotString();
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
                 f.getValuesParams().put(n.getId().getName(),e.getList().get(i).interpret(variables, functions, datas, returns));
                 i++;
            }
        }
    }

    private void put_returns_value(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns)
    {
        int i=0;
        for(LValue lv : l.getList())
        {
            variables.peek().put(lv.getID().getName(), returns.peek().get(i));
            i+=1;
        }
    }
    public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<List<Object>> returns){
        for(Func f : functions)
        {
            if(f.getId().getName().equals(id.getName()))
            {
                if(f.getParams()!=null)
                {
                    if(f.getParams().getParamsList().size()==e.getList().size()){
                        if(f.getReturns()!=null)
                        {
                            if(f.getReturns().getReturnTypes().size()==l.getList().size())
                            {
                                put_params_value(f, variables, functions, datas, returns);
                                f.interpret(variables, functions, datas, returns);
                                put_returns_value(variables, functions, datas, returns);
                                if(!returns.isEmpty())
                                {
                                    returns.pop();
                                }
                                break;
                            }
                        }
                        else if(l==null)
                        {
                            put_params_value(f, variables, functions, datas, returns);
                            f.interpret(variables, functions, datas, returns);
                            if(!returns.isEmpty())
                            {
                                returns.pop();
                            }
                            break;
                        }
                    }
                }
            }
            else if(e==null)
            {
                if(f.getReturns()!=null)
                {
                    if(f.getReturns().getReturnTypes().size()==l.getList().size())
                    {
                        f.interpret(variables, functions, datas, returns);
                        put_returns_value(variables, functions, datas, returns);
                        if(!returns.isEmpty())
                        {
                            returns.pop();
                        }
                        break;
                    }
                }
                else if(l==null)
                {
                    f.interpret(variables, functions, datas, returns);
                    if(!returns.isEmpty())
                    {
                        returns.pop();
                    }
                    break;
                }
            }
        }
        return 0;
    }
}
