package ast;

import java.util.HashMap;

public class Param extends Node{
    ID id;
    Type type;

    public Param(int l, int c, ID id, Type type) {
        super(l, c);
        this.id = id;
        this.type = type;
    }

    @Override
    public Object interpret(HashMap<String, Object> m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interpret'");
    }

    @Override
    public String dotString(){
        String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        
        s+= getUid() +"--"+id.getUid()+"\n";
        s+=id.dotString();

        s+= getUid() +"--"+type.getUid()+"\n"; 
        s+= type.dotString();  
        
        
        return s;
    }
    
}
