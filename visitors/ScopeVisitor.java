package visitors;

import java.util.List;
import java.util.Stack;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;

import javax.lang.model.util.ElementScanner6;

import ast.*;
import util.*;

public class ScopeVisitor extends Visitor {

	private static final String INT = "Int";
	private static final String FLOAT = "Float";
	private static final String BOOL = "Bool";
	private static final String CHAR = "Char";
	private static final String DATA_INSTANCE = "DataInstance";
	private static final String ERROR = "Error";
	private static final String CMD = "CMD";

	private HashMap<String, Integer> HashMapScope = new HashMap<String, Integer>();
	private List<HashMap<String, String>> Variables = new ArrayList<HashMap<String, String>>();
	private List<List<String>> Params = new ArrayList<List<String>>();
	private List<List<String>> Returns = new ArrayList<List<String>>();
	private HashMap<String, HashMap<String,String>> HashMapData = new HashMap<String, HashMap<String,String>>();
	private int level;

	private Stack<String> typeStack = new Stack<String>();

	public ScopeVisitor() {
		//scopes = new ScopeTable();
		//level = scopes.getLevel();
	}

	@Override
	public void visit(Prog p) {

		DataList dataList = p.getDataList();
		FuncList funcList = p.getFuncList();

		if (dataList != null)
		{
			dataList.accept(this);
		}
		if (funcList != null)
		{
			funcList.accept(this);
		}
		System.out.println(typeStack);

	}

	@Override
	public void visit(FuncList f) {

		List<Func> list = f.getList();
		for (Func func : list) {
			func.accept(this);
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
		DeclList decls = d.getDeclList();
		HashMapData.put(d.getId().getName(), (new HashMap<String,String>()));
		if(decls!=null)
		{
			for(Decl decl : decls.getList())
			{
				decl.getType().accept(this);
				HashMapData.get(d.getId().getName()).put(decl.getId().getName(), typeStack.pop());
			}
		}
		return;
	}

	@Override
	public void visit(Func f) {

		int scope_value = HashMapScope.size();
		HashMapScope.put(f.getId().getName(), scope_value);

		HashMap<String,String> HashMapVariables = new HashMap<String,String>();
		List<String> ListParams = new ArrayList<String>();

		ParamsList params = f.getParams();

		if(params!=null)
		{
			for(Param p : params.getParamsList())
			{
				p.getType().accept(this);
				String type = typeStack.pop();
				HashMapVariables.put(p.getId().getName(), type);
				ListParams.add(type);
			}
		}

		Params.add(ListParams);
		Variables.add(HashMapVariables);

		List<String> ListReturn = new ArrayList<String>();

		TypeList returns = f.getReturns();

		if(returns!=null)
		{
			for(Type t : returns.getReturnTypes())
			{
				t.accept(this);
				ListReturn.add(typeStack.pop());
			}
		}

		Returns.add(ListReturn);
		level = scope_value;

		CmdList cmds = f.getCmdList();
		cmds.accept(this);
	}


	@Override
	public void visit(CmdList c) {
		List<Node> list = c.getList();
		boolean hasError = false;

		for (Node n : list) {
			n.accept(this);
			String test = typeStack.pop();
			System.out.println(test);
			if (test.equals(ERROR)) {
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

	@Override
	public void visit(Type t){
		if(t.getName().equals(INT))
		{
			typeStack.push(INT);
		}
		else if(t.getName().equals(FLOAT))
		{
			typeStack.push(FLOAT);
		}
		else if(t.getName().equals(BOOL))
		{
			typeStack.push(BOOL);
		}
		else if(t.getName().equals(CHAR))
		{
			typeStack.push(CHAR);
		}
		else if(HashMapData.containsKey(t.getName()))
		{
			typeStack.push(DATA_INSTANCE);
		}
		else
		{
			typeStack.push(ERROR);
		}

	}

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

	public void visit(Attr a) {
		if(a.getLValue().getLValue()==null)
		{
			if(a.getLValue().getExpr()==null)
			{
				Expr e = a.getExp();
				e.accept(this);
				String e_type = typeStack.pop();
				Variables.get(level).put(a.getLValue().getID().getName(), e_type);
				typeStack.push(e_type);
			}
		}
	}

	public void visit(LValue l) {

		LValue lv = l.getLValue();
		Expr e = l.getExpr();
		ID i = l.getID();

		if(lv==null)
		{
			if(e==null)
			{
				if(Variables.get(level).containsKey(i.getName()))
				{
					i.accept(this);
					String i_type = typeStack.pop(); 
					typeStack.push(i_type);
				}
				else
				{
					typeStack.push(ERROR);
					System.out.println(
						"Error at line " + l.getLine() + ":" + l.getCol() + ": The variable " + i.getName() + " is not inicialized.");
				}
			}
			else
			{
				if(Variables.get(level).containsKey(i.getName()))
				{
					e.accept(this);
					String e_type = typeStack.pop();
					if(!e_type.equals(INT))
					{
						typeStack.push(ERROR);
						System.out.println(
							"Error at line " + l.getLine() + ":" + l.getCol() + ": A vector access expected INT, received" + e_type + ".");
					}
					else
					{
						i.accept(this);
						String i_type = typeStack.pop(); 
						typeStack.push(i_type);
					}
				}
				else
				{
					typeStack.push(ERROR);
					System.out.println(
						"Error at line " + l.getLine() + ":" + l.getCol() + ": The variable " + i.getName() + " is not inicialized.");
				}
			}
		}
		else
		{

		}
	}




	public void visit(ID i)
	{
		typeStack.push(Variables.get(level).get(i.getName()));
	}

	public void visit(New n) {
		Expr e = n.getExpr();
		Type type = n.getType();
		if(e!=null)
		{
			e.accept(this);
			String e_type = typeStack.pop();
			if(!e_type.equals(INT))
			{
				typeStack.push(ERROR);
				System.out.println(
					"Error at line " + n.getLine() + ":" + n.getCol() + ": A vector access expected INT, received" + e_type + ".");
			}
			else
			{
				type.accept(this);
				String t_type = typeStack.pop();
				typeStack.push(t_type);
			}
		}
		else
		{
			type.accept(this);
			String t_type = typeStack.pop();
			typeStack.push(t_type);
		}
	}

	@Override
	public void visit(Read i) {
	
		Expr e = i.getExpr();
		e.accept(this);
		String type = typeStack.pop();

		if (type.equals(ERROR)) {
			typeStack.push(ERROR);
		} else {
			typeStack.push(CMD);
		}
			
	}
}
