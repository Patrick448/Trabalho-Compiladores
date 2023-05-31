package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;
 
public class Prog extends Node {
    Node dataList;
    Node funcList;

            
    public Prog(int l, int c, Node dataList, Node funcList) {
        super(l, c);
        this.dataList = dataList;
        this.funcList = funcList;
       
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
      
    public Object interpret(HashMap<String,Object> m){

        if (dataList != null) dataList.interpret(m);
        if (funcList != null) funcList.interpret(m);

        return 0;
    }

}
   