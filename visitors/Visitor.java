package visitors;

import ast.*;

public abstract  class  Visitor {

     public abstract void visit(Node p);


     public abstract void visit(Prog p);

     public abstract void visit(FuncList f);

     public abstract void visit(Func f);

     public abstract void visit(CmdList c);

     public abstract void visit(Print p);

     public abstract void visit(Expr e);

     public abstract void visit(Add a);



     /*public abstract void visit(Add e);
          
     public abstract void visit(Var e);
     public abstract void visit(NInt e);
     public abstract void visit(Call e);
     
     public abstract void visit(Attr e);
     public abstract void visit(Print e);
     public abstract void visit(Block e);
     public abstract void visit(Func f);
     
     public abstract void visit(Param e);
     
     public abstract void visit(TyInt t);
     public abstract void visit(TyVoid t);*/
}
