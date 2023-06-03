package ast;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class New extends Expr {
    private Type type;
    private Expr e;

    public New(int l, int c, Type type, Expr e) {
        super(l, c);
        this.type = type;
        this.e = e;
    }

    @Override
    public Object interpret(HashMap<String, Object> variables, List<Func> functions, HashMap<String, Data> datas,
            Stack<ExprList> returns) {

        
        HashMap<String, Object> attributes = new HashMap<String, Object>();

        for(Decl d : datas.get(type.getName()).getDeclList().getList()){
            attributes.put(d.getId().getName(), null);
        }
        
        DataInstance instance = new DataInstance(type, attributes);
        return instance;
    }

    @Override
    public String dotString() {
        String s = getUid() + " [label= \"" + this.getClass().getSimpleName() + "\"]\n";
        s += getUid() + "--" + type.getUid() + "\n";
        s += type.dotString();

        if (e != null) {
            s += getUid() + "--" + e.getUid() + "\n";
            s += e.dotString();
        }

        return s;
    }
    
    
}
