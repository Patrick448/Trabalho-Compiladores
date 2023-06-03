package ast;

/*
 * Esta classe representa um comando de .
 * Expr
 */
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class Decl extends Node {

      ID id;
      DataList declList;
      Type type;

      public Decl(int l, int c, ID id, Type type) {
            super(l, c);
            this.id = id;
            this.type = type;
      }

      @Override
      public Object interpret(Stack<HashMap<String,Object>> variables, List<Func> functions, HashMap<String, Data> datas, Stack<ExprList> returns){
            return 0;
      }

      public ID getId() {
            return id;
      }

      public String toString() {
          return type.toString() + " " + id.toString();
      }

      public String dotString() {
            String s = getUid() + " [label=\""+ this.getClass().getSimpleName()+"\"]\n";
        
            s+= getUid() +"--"+id.getUid()+"\n";
            s+=id.dotString();

            s+= getUid() +"--"+type.getUid()+"\n"; 
            s+= type.dotString();  
        
        
            return s;
        }
}
