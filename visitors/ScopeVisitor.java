package visitors;

import java.util.List;
import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

import ast.*;
import util.*;

public class ScopeVisitor extends Visitor {

	private static final String INT = "INT";
	private static final String FLOAT = "FLOAT";
	private static final String BOOL = "BOOL";
	private static final String CHAR = "CHAR";
	private static final String ERROR = "ERROR";
	private static final String CMD = "CMD";

	private ScopeTable scopes;
	private int level;
	private Stack<String> typeStack = new Stack<String>();

	public ScopeVisitor() {
		scopes = new ScopeTable();
		level = scopes.getLevel();
	}

	@Override
	public void visit(Prog p) {

		DataList dataList = p.getDataList();
		FuncList funcList = p.getFuncList();

		if (dataList != null)
			dataList.accept(this);
		if (funcList != null)
			funcList.accept(this);
		System.out.println(typeStack);

	}

	@Override
	public void visit(FuncList f) {

		List<Func> list = f.getList();
		for (Func func : list) {
			// if(n.getId().getName().equals("main") && n.getParams()==null &&
			// n.getReturns()==null)
			// {
			func.accept(this);
			// break;
			// }
		}

	}

	@Override
	public void visit(DataList d) {

		List<Data> list = d.getList();
		for (Data data : list) {
			data.accept(this);

		}

	}

	@Override
	public void visit(Data d) {

		// d.accept(this);
		return;
	}

	@Override
	public void visit(Func f) {
		// ParamsList params = f.getParams();
		// params.accept(this);
		CmdList cmds = f.getCmdList();
		cmds.accept(this);
	}

	/*
	 * @Override
	 * public void visit(ParamsList p) {
	 * List<Param> list = p.getList();
	 * for(Param param : list)
	 * {
	 * param.accept(this);
	 * }
	 * }
	 * 
	 * @Override
	 * public void visit(Param p) {
	 * String typeName = p.getType().getName();
	 * 
	 * if(typeName.equals("int")){
	 * typeStack.push(INT);
	 * }
	 * else if(typeName.equals("float")){
	 * typeStack.push(FLOAT);
	 * }
	 * else if(typeName.equals("bool")){
	 * typeStack.push(BOOL);
	 * }
	 * else if(typeName.equals("char")){
	 * typeStack.push(CHAR);
	 * }
	 * 
	 * }
	 */

	@Override
	public void visit(CmdList c) {
		List<Node> list = c.getList();
		boolean hasError = false;

		for (Node n : list) {
			n.accept(this);
			if (typeStack.pop().equals(ERROR)) {
				hasError = true;
			}
		}

		if (hasError) {
			typeStack.push(ERROR);
		} else {
			typeStack.push(CMD);
		}
	}

	@Override
	public void visit(Print p) {
		Expr e = p.getExpr();
		e.accept(this);
		String type = typeStack.pop();

		if (type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else {
			typeStack.push(CMD);
		}

	}

	// f(r :: Racional): Float{
	// res = r.numerador / r.denominador;
	// x = (a+b) + d;
	// return res;
	// }

	@Override
	public void visit(Add a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(INT);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(FLOAT);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": invalid operation between "
					+ l_type + " and " + r_type + ".");
		}

	}

	@Override
	public void visit(Mul a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(INT);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(FLOAT);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": attempted to operate " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(Rest a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(INT);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(FLOAT);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": attempted to operate " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(Div a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(INT);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(FLOAT);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": attempted to operate " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(Sub a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(INT);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(FLOAT);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": attempted to operate " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(SubUni a) {
		Expr e = a.getExpr();
		e.accept(this);

		String e_type = typeStack.pop();

		if (e_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (e_type.equals(INT)) {
			typeStack.push(INT);
		} else if (e_type.equals(FLOAT)) {
			typeStack.push(FLOAT);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": attempted to operate " + e_type+".");
		}

	}

	@Override
	public void visit(Neg a) {
		Expr e = a.getExpr();
		e.accept(this);

		String e_type = typeStack.pop();

		if (e_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (e_type.equals(BOOL)) {
			typeStack.push(BOOL);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": attempted to operate " + e_type+".");
		}

	}

	@Override
	public void visit(And a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(BOOL) && l_type.equals(BOOL)) {
			typeStack.push(BOOL);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol()
					+ ": invalid logical operation between " + l_type + " and " + r_type + ".");
		}

	}

	@Override
	public void visit(GreaterThan a) {

		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(BOOL);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(BOOL);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": invalid comparison between " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(LessThan a) {

		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else if (r_type.equals(INT) && l_type.equals(INT)) {
			typeStack.push(BOOL);
		} else if (r_type.equals(FLOAT) && l_type.equals(FLOAT)) {
			typeStack.push(BOOL);
		} else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": invalid comparison between " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(Diff a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
	 
		}else if( r_type.equals(l_type)){
			typeStack.push(BOOL);
		}
		else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": invalid comparison between " + l_type
					+ " and " + r_type + ".");
		}

	}

	@Override
	public void visit(Eq a) {
		Expr l = a.getLeft();
		l.accept(this);
		Expr r = a.getRight();
		r.accept(this);
		String r_type = typeStack.pop();
		String l_type = typeStack.pop();

		if (r_type.equals(ERROR) || l_type.equals(ERROR)) {
			typeStack.push(ERROR);
	 
		}else if( r_type.equals(l_type)){
			typeStack.push(BOOL);
		}
		else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": invalid comparison between " + l_type
					+ " and " + r_type + ".");
		}
	}

	

	public void visit(Int i) {
		typeStack.push(INT);
	}

	public void visit(Char i) {
		typeStack.push(CHAR);
	}

	public void visit(FloatAst i) {
		typeStack.push(FLOAT);
	}

	public void visit(Bool i) {
		typeStack.push(BOOL);
	}

	public void visit(Iterate i) {
		Expr e = i.getCondition();
		e.accept(this);

		CmdList c = (CmdList) i.getCmd();
		c.accept(this);

		String c_type = typeStack.pop();
		String e_type = typeStack.pop();

		if (!e_type.equals(INT)) {
			typeStack.push(ERROR);
			System.out.println(
					"Error at line " + i.getLine() + ":" + i.getCol() + ": attempted to iterate with " + e_type + ".");
		} else if (c_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else {
			typeStack.push(CMD);
		}

	}

	public void visit(If i) {
		Expr e = (Expr) i.getTeste();
		e.accept(this);

		CmdList c = (CmdList) i.getThn();
		c.accept(this);

		String thn_type = typeStack.pop();
		String e_type = typeStack.pop();
		String else_type = "";
		if (i.getEls() != null) {
			CmdList c2 = (CmdList) i.getEls();
			c2.accept(this);
			else_type = typeStack.pop();
		}

		if (thn_type.equals(ERROR) || e_type.equals(ERROR) || else_type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else {
			typeStack.push(CMD);
		}

	}

	/*
	 * public void visit(Program p) {
	 * Func[] funs = p.getFuncs();
	 * for(int i = 0; i < funs.length; i++)
	 * funs[i].accept(this);
	 * }
	 * 
	 * public void visit(Add e) {
	 * Expr exp = e.getLeft();
	 * exp.accept(this);
	 * exp = e.getRight();
	 * exp.accept(this);
	 * }
	 * 
	 * public void visit(Var e) {
	 * Pair<Symbol, Integer> pair = scopes.search(e.getName());
	 * if(pair == null) { //
	 * System.err.println("Variable not declared: " + e.getName());
	 * System.exit(1);
	 * }
	 * // Diferença entre o nível atual e o da variável indica a profundidade que
	 * devemos retornar nos scopos para obter o valor da variável
	 * System.out.println("\u27e6" + e.getName() + "\u27e7 : " + pair.second());
	 * }
	 * 
	 * public void visit(NInt e) {
	 * 
	 * }
	 * 
	 * public void visit(Call e) {
	 * Expr args[] = e.getArgs();
	 * for(int i = 0; i < args.length; ++i)
	 * args[i].accept(this);
	 * }
	 * 
	 * public void visit(Attr e) {
	 * String name = e.getID();
	 * Expr exp = e.getExp();
	 * Pair<Symbol, Integer> pair = scopes.search(e.getID());
	 * if(pair == null) { //
	 * System.err.println("Variable not declared: " + name);
	 * System.exit(1);
	 * }
	 * System.out.println("<- \u27e6" + name + "\u27e7: " + pair.second());
	 * exp.accept(this);
	 * }
	 * 
	 * public void visit(Print e) {
	 * e.getExpr().accept(this);
	 * }
	 * 
	 * public void visit(Block e) {
	 * // Criar um novo escopo
	 * level = scopes.push();
	 * System.out.println("<<<<<<<<<< Bloco / " + level +" >>>>>>>>");
	 * Node[] ns = e.getStmts();
	 * for(int i = 0; i < ns.length; i++)
	 * ns[i].accept(this);
	 * level = scopes.pop();
	 * System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	 * }
	 * public void visit(Func f) {
	 * // Criar um novo escopo
	 * level = scopes.push();
	 * System.out.println("<<<<<<<<<< Função: " + f.getID() + " / " + level
	 * +" >>>>>>>>");
	 * Param[] ps = f.getParams();
	 * for(int i = 0; i < ps.length; i++)
	 * ps[i].accept(this);
	 * Block b = f.getBody();
	 * // Visita cada elemento do bloco aqui para evitar criar um escopo ao entrar
	 * no corpo da função
	 * Node[] ns = b.getStmts();
	 * for(int i = 0; i < ns.length; i++)
	 * ns[i].accept(this);
	 * level = scopes.pop();
	 * System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	 * }
	 * 
	 * public void visit(Param e) {
	 * System.out.println("adding ... " + e.getID());
	 * scopes.put(e.getID(), new Symbol());
	 * }
	 * 
	 * public void visit(TyInt t) {}
	 * 
	 * public void visit(TyVoid t) {}
	 */
}
