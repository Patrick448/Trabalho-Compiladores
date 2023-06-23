package visitors;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

import ast.*;

public class ScopeVisitor extends Visitor {

	private static final String INT = "Int";
	private static final String FLOAT = "Float";
	private static final String BOOL = "Bool";
	private static final String CHAR = "Char";
	private static final String ERROR = "Error";
	private static final String CMD = "CMD";

	private HashMap<String, Integer> HashMapScope = new HashMap<String, Integer>();
	private List<List<HashMap<String, String>>> Variables = new ArrayList<List<HashMap<String, String>>>();
	private List<List<String>> Params = new ArrayList<List<String>>();
	private List<List<String>> Returns = new ArrayList<List<String>>();
	private HashMap<String, HashMap<String,String>> HashMapData = new HashMap<String, HashMap<String,String>>();
	private int level;
	private int scopeFunc;

	private Stack<String> typeStack = new Stack<String>();

	public ScopeVisitor() {}

	public Integer getScopeFunc()
	{
		return scopeFunc;
	}

	public void setScopeFuncByName(String name){
		Integer scope = HashMapScope.get(name);
		scopeFunc = scope;
	}

	public void setScopeFunc(Integer i){
		scopeFunc = i;
	}

	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer i){
		level = i;
	}

	public void addLevel(){
		level = level+1;
	}

	public void subLevel(){
		level = level-1;
	}

	public Stack<String> getStack()
	{
		return typeStack;
	}

	@Override
	public void visit(Prog p) {

		DataList dataList = p.getDataList();
		FuncList funcList = p.getFuncList();
		Boolean have_error = false;

		if (dataList != null)
		{
			dataList.accept(this);
			String d_type = typeStack.pop();
			if(d_type == ERROR)
			{
				have_error = true;
			}
		}
		if (funcList != null)
		{
			funcList.accept(this);
			String f_type = typeStack.pop();
			if(f_type == ERROR)
			{
				have_error = true;
			}
		}
		if(have_error)
		{
			typeStack.push(ERROR);
		} 
		else
		{
			typeStack.push(CMD);
		}
	}

	@Override
	public void visit(FuncList f) {

		List<Func> list = f.getList();
		List<HashMap<String,String>> scopeList;

		int scope_value = 0;
		HashMap<String,String> HashMapVariables;

		for (Func func : list) {
			scope_value = HashMapScope.size();
			Integer i = 0;
			String s_p = "(";
			if(func.getParams()!=null)
			{
				for(Param parameter : func.getParams().getParamsList())
				{
					if(i>0)
					{
						s_p = s_p + "," + parameter.getType().getFullName();
					}
					else
					{
						s_p = s_p + parameter.getType().getFullName();
					}
					i = i+1;
				}
			}
			s_p = s_p + ")";
			HashMapScope.put(func.getId().getName()+s_p, scope_value);

			scopeList = new ArrayList<HashMap<String,String>>();
			HashMapVariables = new HashMap<String,String>();

			List<String> ListParams = new ArrayList<String>();
			ParamsList params = func.getParams();

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
			scopeList.add(HashMapVariables);
			Variables.add(scopeList);

			List<String> ListReturn = new ArrayList<String>();

			TypeList returns = func.getReturns();

			if(returns!=null)
			{
				for(Type t : returns.getReturnTypes())
				{
					t.accept(this);
					ListReturn.add(typeStack.pop());
				}
			}

			Returns.add(ListReturn);
		}
		Boolean have_error = false;

		for (Func func : list) {
			func.accept(this);
			String func_type = typeStack.pop();
			if(func_type.equals(ERROR))
			{
				have_error = true;
			}
		}

		if(HashMapScope.containsKey("main()"))
		{
			int scope_main = HashMapScope.get("main()");
			if(Params.get(scope_main).size() != 0)
			{
				typeStack.push(ERROR);
				System.out.println("Error at line 0:0: Program don't have main() function");
			}
			else if(!have_error)
			{
				typeStack.push(CMD);
			}
			else
			{
				typeStack.push(ERROR);
			}
		}
		else
		{
			typeStack.push(ERROR);
			System.out.println("Error at line 0:0: Program don't have main() function");
		}
	}

	@Override
	public void visit(DataList d) {

		List<Data> list = d.getList();
		boolean have_error = false;
		for (Data data : list) {
			data.accept(this);
			String t_data = typeStack.pop();
			if(t_data == ERROR)
			{
				have_error = true;
			}
		}
		if(have_error)
		{
			typeStack.push(ERROR);
		}
		else
		{
			typeStack.push(CMD);
		}
	}

	@Override
	public void visit(Data d) {
		DeclList decls = d.getDeclList();
		if(HashMapData.containsKey(d.getId().getName()))
		{
			System.out.println("Error at line " + d.getLine() + ":" + d.getCol() + ": Data " + d.getId().getName() + " already declared");
			typeStack.push(ERROR);
			return;
		}
		HashMapData.put(d.getId().getName(), (new HashMap<String,String>()));
		if(decls!=null)
		{
			for(Decl decl : decls.getList())
			{
				decl.getType().accept(this);
				HashMapData.get(d.getId().getName()).put(decl.getId().getName(), typeStack.pop());
			}
		}
		typeStack.push(CMD);
		return;
	}

	@Override
	public void visit(Func f) {
		Integer i = 0;
		String s_p = "(";
		if(f.getParams()!=null)
		{
			for(Param parameter : f.getParams().getParamsList())
			{
				if(i>0)
				{
					s_p = s_p + "," + parameter.getType().getFullName();
				}
				else
				{
					s_p = s_p + parameter.getType().getFullName();
				}
				i = i+1;
			}
		}
		s_p = s_p + ")";
		scopeFunc = HashMapScope.get(f.getId().getName()+s_p);
		level = 0;
		CmdList cmds = f.getCmdList();
		cmds.accept(this); 
	}


	@Override
	public void visit(CmdList c) {

		HashMap<String,String> scopeCMD = (HashMap<String,String>) Variables.get(scopeFunc).get(level).clone();
		Variables.get(scopeFunc).add(scopeCMD);
		level = level + 1;

		List<Node> list = c.getList();
		boolean hasError = false;
		for (Node n : list) {
			n.accept(this);
			String test = typeStack.pop();
			if (test.equals(ERROR)) {
				hasError = true;
			}
		}

		if (hasError) {
			typeStack.push(ERROR);
		} else {
			typeStack.push(CMD);
		}

		level = level - 1;
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
		String n = t.getName();
		if(n.equals(INT)|| n.equals(FLOAT) || n.equals(BOOL) || n.equals(CHAR))
		{
			typeStack.push(t.getFullName());
		}
		else if(HashMapData.containsKey(t.getName()))
		{
			typeStack.push(t.getFullName());
		}
		else
		{
			typeStack.push(ERROR);
			System.out.println("Error at line " + t.getLine() + ":" + t.getCol() + ": Type " + t.getFullName() + " not exist");
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
			return;
	 
		}else if( r_type.equals(l_type)){
			typeStack.push(BOOL);
			return;
		}
		else {
			typeStack.push(ERROR);
			System.out.println("Error at line " + a.getLine() + ":" + a.getCol() + ": invalid comparison between " + l_type
					+ " and " + r_type + ".");
			return;
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
		Boolean have_error = false;

		String e_type = typeStack.pop();

		if (!e_type.equals(INT) && !e_type.equals(ERROR)) {
			have_error = true;
			System.out.println(
				"Error at line " + i.getLine() + ":" + i.getCol() + ": attempted to iterate with " + e_type + ".");
		} else if(e_type.equals(ERROR)){
			have_error = true;
		}

		Node c =  i.getCmd();
		c.accept(this);

		String c_type = typeStack.pop();

		if (c_type.equals(ERROR)||have_error) {
			typeStack.push(ERROR);
			return;
		} else {
			typeStack.push(CMD);
			return;
		}

	}

	public void visit(If i) {
		Expr e = (Expr) i.getTeste();
		e.accept(this);
		Boolean have_error = false;
		String e_type = typeStack.pop();

		if(!e_type.equals(BOOL) && !e_type.equals(ERROR))
		{
			have_error = true;
			System.out.println(
				"Error at line " + i.getLine() + ":" + i.getCol() + ": attempted to condition with " + e_type + ".");
		}

		Node c = i.getThn();
		c.accept(this);

		String thn_type = typeStack.pop();

		String else_type = "";
		if (i.getEls() != null) {
			Node c2 = i.getEls();
			c2.accept(this);
			else_type = typeStack.pop();
		}

		if(have_error)
		{
			typeStack.push(ERROR);
			return;
		}
		else if (thn_type.equals(ERROR) || e_type.equals(ERROR) || else_type.equals(ERROR)) {
			typeStack.push(ERROR);
			return;
		} else {
			typeStack.push(CMD);
			return;
		}

	}



	public void visit(Attr a) {
		Expr e = a.getExp();
		LValue l = a.getLValue();
		e.accept(this);
		String e_type = typeStack.pop();

		if(l.isSingleID()){
			if(Variables.get(scopeFunc).get(level).containsKey(a.getLValue().getID().getName()))
			{
				if(!e_type.equals(Variables.get(scopeFunc).get(level).get(a.getLValue().getID().getName())) && !e_type.equals(ERROR))	
				{
					typeStack.push(ERROR);
					System.out.println(
						"Error at line " + a.getLine() + ":" + a.getCol() + ": Attempted to attibute value of type " + e_type + 
						" to variable of type " + Variables.get(scopeFunc).get(level).get(a.getLValue().getID().getName()) + ".");
					return;
				}
				else if(e_type.equals(ERROR))
				{
					typeStack.push(ERROR);
					return;
				}
			}
			Variables.get(scopeFunc).get(level).put(a.getLValue().getID().getName(), e_type);
			if(e_type.equals(ERROR))
			{
				typeStack.push(ERROR);
				return;
			}
			else
			{
				typeStack.push(CMD);
				return;
			}
		}
		
		l.accept(this);
		String l_type = typeStack.pop();

		if(!l_type.equals(e_type) && !e_type.equals(ERROR) && !l_type.equals(ERROR)){
			typeStack.push(ERROR);
			System.out.println(
				"Error at line " + l.getLine() + ":" + l.getCol() + ": Attempted to attibute value of type " + e_type + " to variable of type " + l_type + ".");
		}else if(e_type.equals(ERROR) || l_type.equals(ERROR)){
			typeStack.push(ERROR);
		}
		else{
			typeStack.push(CMD);
		}
		return;
		
	}

	public void visit(LValue l) {

		LValue lv = l.getLValue();
		Expr e = l.getExpr();
		ID i = l.getID();
		if(lv != null){
			if(e==null){
				lv.accept(this);
				String type = typeStack.pop();
				if(type.equals(ERROR))
				{
					typeStack.push(ERROR);
					return;
				}
				if(HashMapData.get(type).containsKey(i.getName()))
				{
					typeStack.push(HashMapData.get(type).get(i.getName()));
				}
				else
				{
					typeStack.push(ERROR);
					{
						System.out.println(
							"Error at line " + l.getLine() + ":" + l.getCol() + ": The attribute " + i.getName() + " not exist in data " + type + ".");
					}
				}
			}
			else{
				e.accept(this);
				String e_type = typeStack.pop();

				if((!e_type.equals(INT)) && (!e_type.equals(ERROR)))
				{
					typeStack.push(ERROR);
					System.out.println(
						"Error at line " + l.getLine() + ":" + l.getCol() + ": A vector access expected INT, received" + e_type + ".");
				}
				else if(e_type.equals(ERROR))
				{
					typeStack.push(ERROR);
				}
				else
				{
					lv.accept(this);
					String type = typeStack.pop();
					if(type.equals(ERROR))
					{
						typeStack.push(ERROR);
					}
					else
					{
						int index = type.indexOf('[');
						int size = type.length();
						if(size > index+2)
						{
							type = type.substring(0, index) + type.substring(index+2, size);
						}
						else
						{
							type = type.substring(0, index);
						}
						typeStack.push(type);
					}
				}
			}
		}
		
		else{
			String type = Variables.get(scopeFunc).get(level).get(i.getName());
			if(type == null){
				typeStack.push(ERROR);
				System.out.println("Error at line " + l.getLine() + ":" + l.getCol() + ": Variable " + i.getName() + " was not inicialized.");
			}else{
				typeStack.push(type);
			}
		}
	}

	public void visit(ID i)
	{
		typeStack.push(Variables.get(scopeFunc).get(level).get(i.getName()));
	}

	public void visit(New n) {
		Expr e = n.getExpr();
		Type type = n.getType();
		if(e!=null)
		{
			e.accept(this);
			String e_type = typeStack.pop();
			if(!e_type.equals(INT) && !e_type.equals(ERROR))
			{
				typeStack.push(ERROR);
				System.out.println(
					"Error at line " + n.getLine() + ":" + n.getCol() + ": A vector access expected INT, received" + e_type + ".");
			}
			else if(e_type.equals(ERROR))
			{
				typeStack.push(ERROR);
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
		LValue lv = i.getLValue();
		if(Variables.get(scopeFunc).get(level).containsKey(lv.getID().getName()))
		{
			String t_read = Variables.get(scopeFunc).get(level).get(lv.getID().getName());
			if(!t_read.equals(CHAR) && !t_read.equals(ERROR))
			{
				System.out.println(
					"Error at line " + i.getLine() + ":" + i.getCol() + ": Attempted to attibute value of type " + CHAR + 
					" to variable of type " + t_read + ".");
				typeStack.push(ERROR);
				return;
			}
			if(t_read.equals(ERROR))
			{
				typeStack.push(ERROR);
				return;
			}
			else
			{
				typeStack.push(CMD);
				return;
			}
		}
		else
		{
			Variables.get(scopeFunc).get(level).put(lv.getID().getName(), CHAR);
			typeStack.push(CMD);
			return;
		}		
	}

	public void visit(ReturnCMD r) {
		ExprList e_list = r.getList();

		if(Returns.get(scopeFunc).size() == e_list.getList().size())
		{
			Integer i=0;
			for(Expr e : e_list.getList())
			{
				e.accept(this);
				String e_type = typeStack.pop();
				String expected = Returns.get(scopeFunc).get(i);
				if(!e_type.equals(expected) && !e_type.equals(ERROR))
				{
					typeStack.push(ERROR);
					System.out.println(
						"Error at line " + r.getLine() + ":" + r.getCol() + ": The " + (i+1) + "º return expected " + expected + " but received " + e_type + ".");
					return;
				}
				else if(e_type.equals(ERROR))
				{
					typeStack.push(ERROR);
					return;
				}
				i = i+1;
			}
			typeStack.push(CMD);
			return;
		}
		else
		{
			typeStack.push(ERROR);
			 	System.out.println(
					"Error at line " + r.getLine() + ":" + r.getCol() + ": The function expected " + Returns.get(scopeFunc).size() + " returns but received " + e_list.getList().size() + ".");
			return;
		}
	}

	public void visit(CallFunction c) {
		Integer count = 0;
		String s_p = "(";
			if(c.getExpList()!=null)
			{
				for(Expr e : c.getExpList().getList())
				{
					e.accept(this);
					String e_type = typeStack.pop();
					if(count>0)
					{
						s_p = s_p + "," + e_type;
					}
					else
					{
						s_p = s_p + e_type;
					}
					count = count+1;
				}
			}
		s_p = s_p + ")";

		LValueList lv_list = c.getLValueList();

		if(HashMapScope.containsKey(c.getId().getName()+s_p))
		{
			Integer scope = HashMapScope.get(c.getId().getName()+s_p);
				
			if(lv_list != null)
			{
				if(Returns.get(scope).size() == lv_list.getList().size())
				{
					Integer j = 0;
					for(LValue lv : lv_list.getList())
					{
						if(Variables.get(scopeFunc).get(level).containsKey(lv.getID().getName()))
						{
							if(!Returns.get(scope).get(j).equals(Variables.get(scopeFunc).get(level).get(lv.getID().getName())))	
							{
								typeStack.push(ERROR);
								System.out.println(
									"Error at line " + c.getLine() + ":" + c.getCol() + ": Attempted to attibute value of type " + Returns.get(scope).get(j) + 
									" to variable of type " + Variables.get(scopeFunc).get(level).get(lv.getID().getName()) + ".");
								return;
							}
						}
						Variables.get(scopeFunc).get(level).put(lv.getID().getName(), Returns.get(scope).get(j));
						j= j+1;
					}
					typeStack.push(CMD);
					return;
				}
				else
				{
					for(LValue lv : lv_list.getList())
					{
						if(!Variables.get(scopeFunc).get(level).containsKey(lv.getID().getName()))
						{
							Variables.get(scopeFunc).get(level).put(lv.getID().getName(), ERROR);
						}
					}
					typeStack.push(ERROR);
					System.out.println(
						"Error at line " + c.getLine() + ":" + c.getCol() + ": The function expected " + Returns.get(scope).size() + " variables to save return but received " + lv_list.getList().size() + ".");
					return;
				}
			}
			else if(Returns.get(scope).size() > 0)
			{
				typeStack.push(ERROR);
				System.out.println(
					"Error at line " + c.getLine() + ":" + c.getCol() + ": The function expected " + Returns.get(scope).size() + " variables to save return but received 0.");
				return;
			}
			typeStack.push(CMD);
		}
		else
		{
			if(lv_list != null)
			{
				for(LValue lv : lv_list.getList())
				{
					if(!Variables.get(scopeFunc).get(level).containsKey(lv.getID().getName()))
					{
						Variables.get(scopeFunc).get(level).put(lv.getID().getName(), ERROR);
					}
				}
			}
			typeStack.push(ERROR);
			System.out.println(
				"Error at line " + c.getLine() + ":" + c.getCol() + ": The function " + c.getId().getName()+s_p + " is not defined.");
			return;
		}
	}

	public void visit(CallFunctionVet c) {
		Integer count = 0;
		String s_p = "(";
		if(c.getExpList()!=null)
		{
			for(Expr e : c.getExpList().getList())
				{
					e.accept(this);
					String e_type = typeStack.pop();
					if(count>0)
					{
						s_p = s_p + "," + e_type;
					}
					else{
						s_p = s_p + e_type;
					}
					count = count+1;
				}
			}
		s_p = s_p + ")";
		if(HashMapScope.containsKey(c.getId().getName()+s_p))
		{
			Integer scope = HashMapScope.get(c.getId().getName()+s_p);
			ExprList e_list = c.getExpList();
			
			if(e_list!=null)
			{
				if(Params.get(scope).size() == e_list.getList().size())
				{
					Boolean have_error = false;
					Integer i=0;
					for(Expr e : e_list.getList())
					{
						e.accept(this);
						String e_type = typeStack.pop();
						String expected = Params.get(scope).get(i);
						if(!e_type.equals(expected) && !e_type.equals(ERROR))
						{
							have_error = true;
							System.out.println(
								"Error at line " + c.getLine() + ":" + c.getCol() + ": The " + (i+1) + "º parameter expected " + expected + " but received " + e_type + ".");
						}
						else if(e_type.equals(ERROR))
						{
							have_error = true;
						}
						i = i+1;
					}

					if(have_error)
					{
						typeStack.push(ERROR);
						return;
					}

					Expr e = c.getLExp();
					e.accept(this);
					String e_type = typeStack.pop();
					if(!e_type.equals(INT) && !e_type.equals(ERROR))
					{
						typeStack.push(ERROR);
						System.out.println(
							"Error at line " + c.getLine() + ":" + c.getCol() + ": The functions return position expected a " + INT + " but received a " + e_type + ".");
						return;
					}
					else if(e_type.equals(ERROR))
					{
						typeStack.push(ERROR);	
						return;
					} 
					else
					{
						Int i_value = (Int)e;
						int value = i_value.getValue();
						typeStack.push(Returns.get(scope).get(value));
						return;
					}
				}
				else
				{
					typeStack.push(ERROR);
						System.out.println(
							"Error at line " + c.getLine() + ":" + c.getCol() + ": The function expected " + Params.get(scope).size() + " parameters but received " + e_list.getList().size() + ".");
					return;
				}
			}
			else if(Params.get(scope).size() > 0)
			{
				typeStack.push(ERROR);
				System.out.println(
					"Error at line " + c.getLine() + ":" + c.getCol() + ": The function expected " + Params.get(scope).size() + " parameters but received 0.");
				return;
			}
			typeStack.push(CMD);
		}
		else
		{
			typeStack.push(ERROR);
				System.out.println(
					"Error at line " + c.getLine() + ":" + c.getCol() + ": The function " + c.getId().getName()+s_p + " is not defined.");
			return;
		}
	}
}
