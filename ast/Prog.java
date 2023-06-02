package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class Prog extends Node {
    
	private HashMap<String, Data> hashDatas;
    private Stack<ReturnList> stackReturns;

    private DataList dataList;
    private FuncList funcList;
            
    public Prog(int l, int c, DataList dataList, FuncList funcList) {
        super(l, c);
        this.dataList = dataList;
        this.funcList = funcList;
        this.hashDatas = new HashMap<String, Data>();
    }

    public HashMap<String, Data> getHashDatas() {
        return hashDatas;
    }

    public Stack<ReturnList> getStackReturns() {
        return stackReturns;
    }

    public DataList getDataList() {
        return dataList;
    }

    public FuncList getFuncList() {
        return funcList;
    }

    public String toString(){
        String s = "";
        if(dataList != null) 
            s+= dataList.toString() +"\n";
        if(funcList != null) 
            s+= funcList.toString()+"\n";
  
        
        return "Prog:\n "+s+"\n";
    }

    public String dotString(){
        String s = "graph program {\n";
        s+= getUid() + " [label=Prog]\n";
        if(dataList != null){
            s+= getUid()+"--" +dataList.getUid()+"\n";
            s+= dataList.dotString();
        }
        if(funcList != null) {
            s+= getUid()+"--" +funcList.getUid()+"\n";
            s+= funcList.dotString();
        }
        
        
        s+="}";

        return s+"\n";
    }
      
    public Object interpret(HashMap<String,Object> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ReturnList> returns){
        if (dataList != null) dataList.interpret(variables, funcList.getList(), hashDatas, returns);
        if (funcList != null) funcList.interpret(variables, funcList.getList() , hashDatas, returns);

        return 0;
    }

}
   