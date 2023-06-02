// Generated from /home/patrick/Desktop/Projects/Trabalho-Compiladores/parser/lang.g4 by ANTLR 4.9.2

    package parser;

    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		ID=39, INT=40, FLOAT=41, CHAR=42, TYPE=43, NEWLINE=44, LINE_COMMENT=45, 
		COMMENT=46, BLANK=47;
	public static final int
		RULE_prog = 0, RULE_dataList = 1, RULE_data = 2, RULE_funcList = 3, RULE_func = 4, 
		RULE_declList = 5, RULE_decl = 6, RULE_params = 7, RULE_param = 8, RULE_types = 9, 
		RULE_type = 10, RULE_cmdList = 11, RULE_cmd = 12, RULE_returnsFunction = 13, 
		RULE_returnElement = 14, RULE_exps = 15, RULE_exp = 16, RULE_rexp = 17, 
		RULE_aexp = 18, RULE_mexp = 19, RULE_sexp = 20, RULE_pexp = 21, RULE_lvalues = 22, 
		RULE_lvalue = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dataList", "data", "funcList", "func", "declList", "decl", "params", 
			"param", "types", "type", "cmdList", "cmd", "returnsFunction", "returnElement", 
			"exps", "exp", "rexp", "aexp", "mexp", "sexp", "pexp", "lvalues", "lvalue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'data'", "'{'", "'}'", "'('", "')'", "':'", "'::'", "';'", "','", 
			"'Int'", "'Char'", "'Float'", "'Bool'", "'print'", "'read'", "'iterate('", 
			"'='", "'if'", "'else'", "'return'", "'<'", "'>'", "'&&'", "'=='", "'!='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'true'", "'false'", "'null'", 
			"'new'", "'['", "']'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "INT", "FLOAT", "CHAR", "TYPE", "NEWLINE", "LINE_COMMENT", 
			"COMMENT", "BLANK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public langParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public Prog ast;
		public DataListContext d;
		public FuncListContext f;
		public DataListContext dataList() {
			return getRuleContext(DataListContext.class,0);
		}
		public FuncListContext funcList() {
			return getRuleContext(FuncListContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			((ProgContext)_localctx).d = dataList();
			setState(49);
			((ProgContext)_localctx).f = funcList();


			  if(((ProgContext)_localctx).d.ast != null){
			     ((ProgContext)_localctx).ast =  new Prog(((ProgContext)_localctx).d.ast.getLine(), ((ProgContext)_localctx).d.ast.getCol(), ((ProgContext)_localctx).d.ast, ((ProgContext)_localctx).f.ast);
			    }
			  else if(((ProgContext)_localctx).f.ast != null){
			    ((ProgContext)_localctx).ast =  new Prog(((ProgContext)_localctx).f.ast.getLine(), ((ProgContext)_localctx).f.ast.getCol(), ((ProgContext)_localctx).d.ast, ((ProgContext)_localctx).f.ast);
			    }
			  else{
			    ((ProgContext)_localctx).ast =  new Prog(0, 0, ((ProgContext)_localctx).d.ast, ((ProgContext)_localctx).f.ast);
			  }
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataListContext extends ParserRuleContext {
		public DataList ast;
		public DataContext d;
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public DataListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataList; }
	}

	public final DataListContext dataList() throws RecognitionException {
		DataListContext _localctx = new DataListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dataList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(52);
				((DataListContext)_localctx).d = data();

				    if(_localctx.ast == null){((DataListContext)_localctx).ast =  new DataList(((DataListContext)_localctx).d.ast.getLine(), ((DataListContext)_localctx).d.ast.getCol(), ((DataListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DataListContext)_localctx).d.ast);}
				  
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataContext extends ParserRuleContext {
		public Data ast;
		public Token kw;
		public Token TYPE;
		public DeclListContext declList;
		public TerminalNode TYPE() { return getToken(langParser.TYPE, 0); }
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			((DataContext)_localctx).kw = match(T__0);
			setState(61);
			((DataContext)_localctx).TYPE = match(TYPE);
			setState(62);
			match(T__1);
			setState(63);
			((DataContext)_localctx).declList = declList();
			setState(64);
			match(T__2);
			 ((DataContext)_localctx).ast =  new Data((((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getLine():0), (((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getCharPositionInLine():0), new Type((((DataContext)_localctx).TYPE!=null?((DataContext)_localctx).TYPE.getLine():0), (((DataContext)_localctx).TYPE!=null?((DataContext)_localctx).TYPE.getCharPositionInLine():0), (((DataContext)_localctx).TYPE!=null?((DataContext)_localctx).TYPE.getText():null)), ((DataContext)_localctx).declList.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncListContext extends ParserRuleContext {
		public FuncList ast;
		public FuncContext f;
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public FuncListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcList; }
	}

	public final FuncListContext funcList() throws RecognitionException {
		FuncListContext _localctx = new FuncListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(67);
				((FuncListContext)_localctx).f = func();

				    if(_localctx.ast == null){((FuncListContext)_localctx).ast =  new FuncList(((FuncListContext)_localctx).f.ast.getLine(), ((FuncListContext)_localctx).f.ast.getCol(), ((FuncListContext)_localctx).f.ast); }
				    else{_localctx.ast.addNode(((FuncListContext)_localctx).f.ast);}
				  
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public Func ast;
		public Token ID;
		public ParamsContext params;
		public TypesContext types;
		public CmdListContext cmdList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((FuncContext)_localctx).ID = match(ID);
			setState(76);
			match(T__3);
			setState(77);
			((FuncContext)_localctx).params = params();
			setState(78);
			match(T__4);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(79);
				match(T__5);
				}
			}

			setState(82);
			((FuncContext)_localctx).types = types();
			setState(83);
			match(T__1);
			setState(84);
			((FuncContext)_localctx).cmdList = cmdList();
			setState(85);
			match(T__2);

			    ((FuncContext)_localctx).ast =  new Func((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), new ID((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null)), ((FuncContext)_localctx).params.ast, ((FuncContext)_localctx).types.ast, ((FuncContext)_localctx).cmdList.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclListContext extends ParserRuleContext {
		public DeclList ast;
		public DeclContext d;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declList; }
	}

	public final DeclListContext declList() throws RecognitionException {
		DeclListContext _localctx = new DeclListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(88);
				((DeclListContext)_localctx).d = decl();

				    if(_localctx.ast == null){((DeclListContext)_localctx).ast =  new DeclList(((DeclListContext)_localctx).d.ast.getLine(), ((DeclListContext)_localctx).d.ast.getCol(), ((DeclListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DeclListContext)_localctx).d.ast);}
				  
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Decl ast;
		public Token ID;
		public TypeContext type;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((DeclContext)_localctx).ID = match(ID);
			setState(97);
			match(T__6);
			setState(98);
			((DeclContext)_localctx).type = type();
			setState(99);
			match(T__7);
			((DeclContext)_localctx).ast =  new Decl((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getLine():0), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getCharPositionInLine():0), new ID((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getLine():0), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getCharPositionInLine():0), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null)), ((DeclContext)_localctx).type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public ParamsList ast;
		public ParamContext p;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(102);
				((ParamsContext)_localctx).p = param();

				    if(_localctx.ast == null){((ParamsContext)_localctx).ast =  new ParamsList(((ParamsContext)_localctx).p.ast.getLine(), ((ParamsContext)_localctx).p.ast.getCol(), ((ParamsContext)_localctx).p.ast); }
				    else{_localctx.ast.addNode(((ParamsContext)_localctx).p.ast);}
				  
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Param ast;
		public Token ID;
		public TypeContext t;
		public TypeContext type;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((ParamContext)_localctx).ID = match(ID);
			setState(111);
			match(T__6);
			setState(112);
			((ParamContext)_localctx).t = ((ParamContext)_localctx).type = type();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(113);
				match(T__8);
				}
			}


			    ((ParamContext)_localctx).ast =  new Param((((ParamContext)_localctx).ID!=null?((ParamContext)_localctx).ID.getLine():0), (((ParamContext)_localctx).ID!=null?((ParamContext)_localctx).ID.getCharPositionInLine():0), new ID((((ParamContext)_localctx).ID!=null?((ParamContext)_localctx).ID.getLine():0), (((ParamContext)_localctx).ID!=null?((ParamContext)_localctx).ID.getCharPositionInLine():0), (((ParamContext)_localctx).ID!=null?((ParamContext)_localctx).ID.getText():null)), ((ParamContext)_localctx).type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public TypeList ast;
		public TypeContext t;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << TYPE))) != 0)) {
				{
				{
				setState(118);
				((TypesContext)_localctx).t = type();

				    if(_localctx.ast == null){((TypesContext)_localctx).ast =  new TypeList(((TypesContext)_localctx).t.ast.getLine(), ((TypesContext)_localctx).t.ast.getCol(), ((TypesContext)_localctx).t.ast); }
				    else{_localctx.ast.addNode(((TypesContext)_localctx).t.ast);}
				  
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public TerminalNode TYPE() { return getToken(langParser.TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				setState(126);
				((TypeContext)_localctx).t = match(T__9);
				setState(128);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(127);
					match(T__8);
					}
					break;
				}
				}
				break;
			case T__10:
				{
				setState(130);
				((TypeContext)_localctx).t = match(T__10);
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(131);
					match(T__8);
					}
					break;
				}
				}
				break;
			case T__11:
				{
				setState(134);
				((TypeContext)_localctx).t = match(T__11);
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(135);
					match(T__8);
					}
					break;
				}
				}
				break;
			case T__12:
				{
				setState(138);
				((TypeContext)_localctx).t = match(T__12);
				setState(140);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(139);
					match(T__8);
					}
					break;
				}
				}
				break;
			case TYPE:
				{
				setState(142);
				((TypeContext)_localctx).t = match(TYPE);
				setState(144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(143);
					match(T__8);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((TypeContext)_localctx).ast =  new Type((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getCharPositionInLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdListContext extends ParserRuleContext {
		public CmdList ast;
		public CmdContext c;
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdList; }
	}

	public final CmdListContext cmdList() throws RecognitionException {
		CmdListContext _localctx = new CmdListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << ID))) != 0)) {
				{
				{
				setState(150);
				((CmdListContext)_localctx).c = cmd();

				    
				    if(_localctx.ast == null){((CmdListContext)_localctx).ast =  new CmdList(((CmdListContext)_localctx).c.ast.getLine(), ((CmdListContext)_localctx).c.ast.getCol(), ((CmdListContext)_localctx).c.ast); }
				    else{_localctx.ast.addNode(((CmdListContext)_localctx).c.ast);}
				  
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public Node ast;
		public CmdListContext cmdList;
		public ExpContext exp;
		public LvalueContext lvalue;
		public CmdContext cmd;
		public Token f;
		public CmdContext c1;
		public CmdContext c2;
		public ReturnsFunctionContext r;
		public Token ID;
		public ExpsContext exps;
		public LvaluesContext lvalues;
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ReturnsFunctionContext returnsFunction() {
			return getRuleContext(ReturnsFunctionContext.class,0);
		}
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public LvaluesContext lvalues() {
			return getRuleContext(LvaluesContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmd);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(T__1);
				setState(159);
				((CmdContext)_localctx).cmdList = cmdList();
				setState(160);
				match(T__2);
				 ((CmdContext)_localctx).ast =  ((CmdContext)_localctx).cmdList.ast;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(T__13);
				setState(164);
				((CmdContext)_localctx).exp = exp(0);
				setState(165);
				match(T__7);
				((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast.getLine(), ((CmdContext)_localctx).exp.ast.getCol(), ((CmdContext)_localctx).exp.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(T__14);
				setState(169);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(170);
				match(T__7);
				((CmdContext)_localctx).ast =  new Read(((CmdContext)_localctx).lvalue.ast.getLine(), ((CmdContext)_localctx).lvalue.ast.getCol(), ((CmdContext)_localctx).lvalue.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				match(T__15);
				setState(174);
				((CmdContext)_localctx).exp = exp(0);
				setState(175);
				match(T__4);
				setState(176);
				((CmdContext)_localctx).cmd = cmd();
				((CmdContext)_localctx).ast =  new Iterate(((CmdContext)_localctx).exp.ast.getLine(), ((CmdContext)_localctx).exp.ast.getCol(), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).cmd.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(180);
				match(T__16);
				setState(181);
				((CmdContext)_localctx).exp = exp(0);
				setState(182);
				match(T__7);
				((CmdContext)_localctx).ast =  new Attr(((CmdContext)_localctx).lvalue.ast.getLine(), ((CmdContext)_localctx).lvalue.ast.getCol(), ((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				((CmdContext)_localctx).f = match(T__17);
				setState(186);
				match(T__3);
				setState(187);
				((CmdContext)_localctx).exp = exp(0);
				setState(188);
				match(T__4);
				setState(189);
				((CmdContext)_localctx).cmd = cmd();
				((CmdContext)_localctx).ast =  new If((((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getLine():0), (((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getCharPositionInLine():0), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).cmd.ast, null);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(192);
				((CmdContext)_localctx).f = match(T__17);
				setState(193);
				match(T__3);
				setState(194);
				((CmdContext)_localctx).exp = exp(0);
				setState(195);
				match(T__4);
				setState(196);
				((CmdContext)_localctx).c1 = cmd();
				setState(197);
				match(T__18);
				setState(198);
				((CmdContext)_localctx).c2 = cmd();
				((CmdContext)_localctx).ast =  new If((((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getLine():0), (((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getCharPositionInLine():0), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).c1.ast, ((CmdContext)_localctx).c2.ast);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(201);
				match(T__19);
				setState(202);
				((CmdContext)_localctx).r = returnsFunction();
				setState(203);
				match(T__7);
				((CmdContext)_localctx).ast =  new ReturnCMD(((CmdContext)_localctx).r.ast.getLine(), ((CmdContext)_localctx).r.ast.getCol(), ((CmdContext)_localctx).r.ast);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(206);
				((CmdContext)_localctx).ID = match(ID);
				setState(207);
				match(T__3);
				setState(208);
				((CmdContext)_localctx).exps = exps();
				setState(209);
				match(T__4);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(210);
					match(T__20);
					}
				}

				setState(213);
				((CmdContext)_localctx).lvalues = lvalues();
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(214);
					match(T__21);
					}
				}

				setState(217);
				match(T__7);
				((CmdContext)_localctx).ast =  new CallFunction((((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getLine():0), (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getCharPositionInLine():0), new ID((((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getLine():0), (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getCharPositionInLine():0), (((CmdContext)_localctx).ID!=null?((CmdContext)_localctx).ID.getText():null)), ((CmdContext)_localctx).exps.ast, ((CmdContext)_localctx).lvalues.ast);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnsFunctionContext extends ParserRuleContext {
		public ReturnList ast;
		public ReturnElementContext r;
		public List<ReturnElementContext> returnElement() {
			return getRuleContexts(ReturnElementContext.class);
		}
		public ReturnElementContext returnElement(int i) {
			return getRuleContext(ReturnElementContext.class,i);
		}
		public ReturnsFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnsFunction; }
	}

	public final ReturnsFunctionContext returnsFunction() throws RecognitionException {
		ReturnsFunctionContext _localctx = new ReturnsFunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_returnsFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__26) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CHAR))) != 0)) {
				{
				{
				setState(222);
				((ReturnsFunctionContext)_localctx).r = returnElement();

				    if(_localctx.ast == null){((ReturnsFunctionContext)_localctx).ast =  new ReturnList(((ReturnsFunctionContext)_localctx).r.ast.getLine(), ((ReturnsFunctionContext)_localctx).r.ast.getCol(), ((ReturnsFunctionContext)_localctx).r.ast);}
				    else{_localctx.ast.addNode(((ReturnsFunctionContext)_localctx).r.ast);}
				  
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnElementContext extends ParserRuleContext {
		public Return ast;
		public ExpContext e;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ReturnElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnElement; }
	}

	public final ReturnElementContext returnElement() throws RecognitionException {
		ReturnElementContext _localctx = new ReturnElementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			((ReturnElementContext)_localctx).e = exp(0);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(231);
				match(T__8);
				}
			}

			((ReturnElementContext)_localctx).ast =  new Return(((ReturnElementContext)_localctx).e.ast.getLine(), ((ReturnElementContext)_localctx).e.ast.getCol(), ((ReturnElementContext)_localctx).e.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpsContext extends ParserRuleContext {
		public ExprList ast;
		public ExpContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__26) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CHAR))) != 0)) {
				{
				{
				setState(236);
				((ExpsContext)_localctx).e = exp(0);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(237);
					match(T__8);
					}
				}


				      if(_localctx.ast == null){((ExpsContext)_localctx).ast =  new ExprList(((ExpsContext)_localctx).e.ast.getLine(), ((ExpsContext)_localctx).e.ast.getCol(), ((ExpsContext)_localctx).e.ast); }
				      else{_localctx.ast.addNode(((ExpsContext)_localctx).e.ast);}
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public Expr ast;
		public ExpContext a1;
		public RexpContext rexp;
		public ExpContext a2;
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(248);
			((ExpContext)_localctx).rexp = rexp(0);
			((ExpContext)_localctx).ast = ((ExpContext)_localctx).rexp.ast;
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					_localctx.a1 = _prevctx;
					_localctx.a1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(251);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(252);
					match(T__22);
					setState(253);
					((ExpContext)_localctx).a2 = exp(3);
					((ExpContext)_localctx).ast =  new And(((ExpContext)_localctx).a1.ast.getLine(), ((ExpContext)_localctx).a1.ast.getCol(), ((ExpContext)_localctx).a1.ast, ((ExpContext)_localctx).a2.ast);
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RexpContext extends ParserRuleContext {
		public Expr ast;
		public RexpContext le;
		public RexpContext ld;
		public AexpContext ll;
		public AexpContext aexp;
		public Token o;
		public AexpContext rl;
		public AexpContext lg;
		public AexpContext rg;
		public AexpContext re;
		public AexpContext rd;
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public RexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexp; }
	}

	public final RexpContext rexp() throws RecognitionException {
		return rexp(0);
	}

	private RexpContext rexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RexpContext _localctx = new RexpContext(_ctx, _parentState);
		RexpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_rexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(262);
				((RexpContext)_localctx).ll = ((RexpContext)_localctx).aexp = aexp(0);
				setState(263);
				((RexpContext)_localctx).o = match(T__20);
				setState(264);
				((RexpContext)_localctx).rl = ((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast =  new LessThan((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).ll.ast, ((RexpContext)_localctx).rl.ast);
				}
				break;
			case 2:
				{
				setState(267);
				((RexpContext)_localctx).lg = ((RexpContext)_localctx).aexp = aexp(0);
				setState(268);
				((RexpContext)_localctx).o = match(T__21);
				setState(269);
				((RexpContext)_localctx).rg = ((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast =  new GreaterThan((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).lg.ast, ((RexpContext)_localctx).rg.ast);
				}
				break;
			case 3:
				{
				setState(272);
				((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast = ((RexpContext)_localctx).aexp.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new RexpContext(_parentctx, _parentState);
						_localctx.le = _prevctx;
						_localctx.le = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
						((RexpContext)_localctx).o = match(T__23);
						setState(279);
						((RexpContext)_localctx).re = ((RexpContext)_localctx).aexp = aexp(0);
						((RexpContext)_localctx).ast =  new Eq((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).le.ast, ((RexpContext)_localctx).re.ast);
						}
						break;
					case 2:
						{
						_localctx = new RexpContext(_parentctx, _parentState);
						_localctx.ld = _prevctx;
						_localctx.ld = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(282);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(283);
						((RexpContext)_localctx).o = match(T__24);
						setState(284);
						((RexpContext)_localctx).rd = ((RexpContext)_localctx).aexp = aexp(0);
						((RexpContext)_localctx).ast =  new Diff((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).ld.ast, ((RexpContext)_localctx).rd.ast);
						}
						break;
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AexpContext extends ParserRuleContext {
		public Expr ast;
		public AexpContext a1;
		public MexpContext mexp;
		public AexpContext a2;
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
	}

	public final AexpContext aexp() throws RecognitionException {
		return aexp(0);
	}

	private AexpContext aexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpContext _localctx = new AexpContext(_ctx, _parentState);
		AexpContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_aexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(293);
			((AexpContext)_localctx).mexp = mexp(0);
			((AexpContext)_localctx).ast = ((AexpContext)_localctx).mexp.ast;
			}
			_ctx.stop = _input.LT(-1);
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(306);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(296);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(297);
						match(T__25);
						setState(298);
						((AexpContext)_localctx).a2 = aexp(4);
						((AexpContext)_localctx).ast =  new Add(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					case 2:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(301);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(302);
						match(T__26);
						setState(303);
						((AexpContext)_localctx).a2 = aexp(3);
						((AexpContext)_localctx).ast =  new Sub(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MexpContext extends ParserRuleContext {
		public Expr ast;
		public MexpContext a1;
		public SexpContext sexp;
		public MexpContext a2;
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public List<MexpContext> mexp() {
			return getRuleContexts(MexpContext.class);
		}
		public MexpContext mexp(int i) {
			return getRuleContext(MexpContext.class,i);
		}
		public MexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mexp; }
	}

	public final MexpContext mexp() throws RecognitionException {
		return mexp(0);
	}

	private MexpContext mexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MexpContext _localctx = new MexpContext(_ctx, _parentState);
		MexpContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_mexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(312);
			((MexpContext)_localctx).sexp = sexp();
			((MexpContext)_localctx).ast = ((MexpContext)_localctx).sexp.ast;
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(330);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new MexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(315);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(316);
						match(T__27);
						setState(317);
						((MexpContext)_localctx).a2 = mexp(5);
						((MexpContext)_localctx).ast =  new Mul(((MexpContext)_localctx).a1.ast.getLine(), ((MexpContext)_localctx).a1.ast.getCol(), ((MexpContext)_localctx).a1.ast, ((MexpContext)_localctx).a2.ast);
						}
						break;
					case 2:
						{
						_localctx = new MexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(320);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(321);
						match(T__28);
						setState(322);
						((MexpContext)_localctx).a2 = mexp(4);
						((MexpContext)_localctx).ast =  new Div(((MexpContext)_localctx).a1.ast.getLine(), ((MexpContext)_localctx).a1.ast.getCol(), ((MexpContext)_localctx).a1.ast, ((MexpContext)_localctx).a2.ast);
						}
						break;
					case 3:
						{
						_localctx = new MexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(325);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(326);
						match(T__29);
						setState(327);
						((MexpContext)_localctx).a2 = mexp(3);
						((MexpContext)_localctx).ast =  new Rest(((MexpContext)_localctx).a1.ast.getLine(), ((MexpContext)_localctx).a1.ast.getCol(), ((MexpContext)_localctx).a1.ast, ((MexpContext)_localctx).a2.ast);
						}
						break;
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SexpContext extends ParserRuleContext {
		public Expr ast;
		public Token n;
		public SexpContext sexp;
		public Token su;
		public Token b;
		public Token INT;
		public Token FLOAT;
		public Token CHAR;
		public PexpContext pexp;
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(langParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(langParser.CHAR, 0); }
		public PexpContext pexp() {
			return getRuleContext(PexpContext.class,0);
		}
		public SexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexp; }
	}

	public final SexpContext sexp() throws RecognitionException {
		SexpContext _localctx = new SexpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sexp);
		try {
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				((SexpContext)_localctx).n = match(T__30);
				setState(336);
				((SexpContext)_localctx).sexp = sexp();
				((SexpContext)_localctx).ast =  new Neg((((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getLine():0), (((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getCharPositionInLine():0), ((SexpContext)_localctx).sexp.ast);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				((SexpContext)_localctx).su = match(T__26);
				setState(340);
				((SexpContext)_localctx).sexp = sexp();
				((SexpContext)_localctx).ast =  new SubUni((((SexpContext)_localctx).su!=null?((SexpContext)_localctx).su.getLine():0), (((SexpContext)_localctx).su!=null?((SexpContext)_localctx).su.getCharPositionInLine():0), ((SexpContext)_localctx).sexp.ast);
				}
				break;
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__31:
					{
					setState(343);
					((SexpContext)_localctx).b = match(T__31);
					}
					break;
				case T__32:
					{
					setState(344);
					((SexpContext)_localctx).b = match(T__32);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				((SexpContext)_localctx).ast =  new Bool((((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getLine():0), (((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getCharPositionInLine():0), Boolean.parseBoolean((((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getText():null)));
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 4);
				{
				setState(348);
				((SexpContext)_localctx).n = match(T__33);
				((SexpContext)_localctx).ast =  new Null((((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getLine():0), (((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getCharPositionInLine():0));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(350);
				((SexpContext)_localctx).INT = match(INT);
				((SexpContext)_localctx).ast =  new Int((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getLine():0), (((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getText():null)));
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				((SexpContext)_localctx).FLOAT = match(FLOAT);
				((SexpContext)_localctx).ast =  new FloatAst((((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getLine():0), (((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getCharPositionInLine():0), Float.parseFloat((((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getText():null)));
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(354);
				((SexpContext)_localctx).CHAR = match(CHAR);
				((SexpContext)_localctx).ast =  new Char((((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getLine():0), (((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getCharPositionInLine():0), (((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getText():null));
				}
				break;
			case T__3:
			case T__34:
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(356);
				((SexpContext)_localctx).pexp = pexp();
				((SexpContext)_localctx).ast = ((SexpContext)_localctx).pexp.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PexpContext extends ParserRuleContext {
		public Expr ast;
		public LvalueContext lvalue;
		public ExpContext exp;
		public TypeContext type;
		public Token ID;
		public ExpsContext exps;
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public PexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pexp; }
	}

	public final PexpContext pexp() throws RecognitionException {
		PexpContext _localctx = new PexpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_pexp);
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				((PexpContext)_localctx).lvalue = lvalue(0);
				((PexpContext)_localctx).ast = ((PexpContext)_localctx).lvalue.ast;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(T__3);
				setState(365);
				((PexpContext)_localctx).exp = exp(0);
				setState(366);
				match(T__4);
				((PexpContext)_localctx).ast = ((PexpContext)_localctx).exp.ast;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				boolean hasExp = false;
				setState(370);
				match(T__34);
				setState(371);
				((PexpContext)_localctx).type = type();
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(372);
					match(T__35);
					setState(373);
					((PexpContext)_localctx).exp = exp(0);
					setState(374);
					match(T__36);
					hasExp=true;
					}
					break;
				}
				((PexpContext)_localctx).ast =  new New(((PexpContext)_localctx).type.ast.getLine(), ((PexpContext)_localctx).type.ast.getCol(), ((PexpContext)_localctx).type.ast, hasExp? ((PexpContext)_localctx).exp.ast:null);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(381);
				((PexpContext)_localctx).ID = match(ID);
				setState(382);
				match(T__3);
				setState(383);
				((PexpContext)_localctx).exps = exps();
				setState(384);
				match(T__4);
				setState(385);
				match(T__35);
				setState(386);
				((PexpContext)_localctx).exp = exp(0);
				setState(387);
				match(T__36);
				((PexpContext)_localctx).ast =  new CallFunctionVet((((PexpContext)_localctx).ID!=null?((PexpContext)_localctx).ID.getLine():0), (((PexpContext)_localctx).ID!=null?((PexpContext)_localctx).ID.getCharPositionInLine():0), new ID((((PexpContext)_localctx).ID!=null?((PexpContext)_localctx).ID.getLine():0), (((PexpContext)_localctx).ID!=null?((PexpContext)_localctx).ID.getCharPositionInLine():0), (((PexpContext)_localctx).ID!=null?((PexpContext)_localctx).ID.getText():null)), ((PexpContext)_localctx).exps.ast, ((PexpContext)_localctx).exp.ast);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvaluesContext extends ParserRuleContext {
		public LValueList ast;
		public LvalueContext l;
		public List<LvalueContext> lvalue() {
			return getRuleContexts(LvalueContext.class);
		}
		public LvalueContext lvalue(int i) {
			return getRuleContext(LvalueContext.class,i);
		}
		public LvaluesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalues; }
	}

	public final LvaluesContext lvalues() throws RecognitionException {
		LvaluesContext _localctx = new LvaluesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lvalues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(392);
				((LvaluesContext)_localctx).l = lvalue(0);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(393);
					match(T__8);
					}
				}


				      if(_localctx.ast == null){((LvaluesContext)_localctx).ast =  new LValueList(((LvaluesContext)_localctx).l.ast.getLine(), ((LvaluesContext)_localctx).l.ast.getCol(), ((LvaluesContext)_localctx).l.ast); }
				      else{_localctx.ast.addNode(((LvaluesContext)_localctx).l.ast);}
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public LValue ast;
		public LvalueContext l;
		public Token ID;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(404);
			((LvalueContext)_localctx).ID = match(ID);
			((LvalueContext)_localctx).ast =  new LValue((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), new ID((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null)));
			}
			_ctx.stop = _input.LT(-1);
			setState(419);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(417);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(407);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(408);
						match(T__35);
						setState(409);
						exp(0);
						setState(410);
						match(T__36);

						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(413);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(414);
						match(T__37);
						setState(415);
						((LvalueContext)_localctx).ID = match(ID);
						 ((LvalueContext)_localctx).ast =  new LValue(((LvalueContext)_localctx).l.ast.getLine(), ((LvalueContext)_localctx).l.ast.getCol(), ((LvalueContext)_localctx).l.ast);
						}
						break;
					}
					} 
				}
				setState(421);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 17:
			return rexp_sempred((RexpContext)_localctx, predIndex);
		case 18:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 19:
			return mexp_sempred((MexpContext)_localctx, predIndex);
		case 23:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rexp_sempred(RexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mexp_sempred(MexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u01a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\6\3\6\3\6\3\6\3\6\5\6"+
		"S\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\n\3\n\3\n\3"+
		"\n\5\nu\n\n\3\n\3\n\3\13\3\13\3\13\7\13|\n\13\f\13\16\13\177\13\13\3\f"+
		"\3\f\5\f\u0083\n\f\3\f\3\f\5\f\u0087\n\f\3\f\3\f\5\f\u008b\n\f\3\f\3\f"+
		"\5\f\u008f\n\f\3\f\3\f\5\f\u0093\n\f\5\f\u0095\n\f\3\f\3\f\3\r\3\r\3\r"+
		"\7\r\u009c\n\r\f\r\16\r\u009f\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00d6\n\16\3\16\3\16\5\16\u00da\n\16\3\16\3"+
		"\16\3\16\5\16\u00df\n\16\3\17\3\17\3\17\7\17\u00e4\n\17\f\17\16\17\u00e7"+
		"\13\17\3\20\3\20\5\20\u00eb\n\20\3\20\3\20\3\21\3\21\5\21\u00f1\n\21\3"+
		"\21\3\21\7\21\u00f5\n\21\f\21\16\21\u00f8\13\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\7\22\u0103\n\22\f\22\16\22\u0106\13\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0116"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0122\n\23"+
		"\f\23\16\23\u0125\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\7\24\u0135\n\24\f\24\16\24\u0138\13\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\7\25\u014d\n\25\f\25\16\25\u0150\13\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u015c\n\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u016a\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u017c\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u0189\n\27\3\30\3\30\5\30\u018d\n\30\3\30\3\30\7\30\u0191\n\30\f"+
		"\30\16\30\u0194\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u01a4\n\31\f\31\16\31\u01a7\13\31\3\31\2\7\""+
		"$&(\60\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\2\2\u01c9"+
		"\2\62\3\2\2\2\4;\3\2\2\2\6>\3\2\2\2\bJ\3\2\2\2\nM\3\2\2\2\f_\3\2\2\2\16"+
		"b\3\2\2\2\20m\3\2\2\2\22p\3\2\2\2\24}\3\2\2\2\26\u0094\3\2\2\2\30\u009d"+
		"\3\2\2\2\32\u00de\3\2\2\2\34\u00e5\3\2\2\2\36\u00e8\3\2\2\2 \u00f6\3\2"+
		"\2\2\"\u00f9\3\2\2\2$\u0115\3\2\2\2&\u0126\3\2\2\2(\u0139\3\2\2\2*\u0169"+
		"\3\2\2\2,\u0188\3\2\2\2.\u0192\3\2\2\2\60\u0195\3\2\2\2\62\63\5\4\3\2"+
		"\63\64\5\b\5\2\64\65\b\2\1\2\65\3\3\2\2\2\66\67\5\6\4\2\678\b\3\1\28:"+
		"\3\2\2\29\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=;\3\2\2"+
		"\2>?\7\3\2\2?@\7-\2\2@A\7\4\2\2AB\5\f\7\2BC\7\5\2\2CD\b\4\1\2D\7\3\2\2"+
		"\2EF\5\n\6\2FG\b\5\1\2GI\3\2\2\2HE\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2"+
		"\2K\t\3\2\2\2LJ\3\2\2\2MN\7)\2\2NO\7\6\2\2OP\5\20\t\2PR\7\7\2\2QS\7\b"+
		"\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\5\24\13\2UV\7\4\2\2VW\5\30\r\2WX"+
		"\7\5\2\2XY\b\6\1\2Y\13\3\2\2\2Z[\5\16\b\2[\\\b\7\1\2\\^\3\2\2\2]Z\3\2"+
		"\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\r\3\2\2\2a_\3\2\2\2bc\7)\2\2cd\7\t"+
		"\2\2de\5\26\f\2ef\7\n\2\2fg\b\b\1\2g\17\3\2\2\2hi\5\22\n\2ij\b\t\1\2j"+
		"l\3\2\2\2kh\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\21\3\2\2\2om\3\2\2"+
		"\2pq\7)\2\2qr\7\t\2\2rt\5\26\f\2su\7\13\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2"+
		"\2\2vw\b\n\1\2w\23\3\2\2\2xy\5\26\f\2yz\b\13\1\2z|\3\2\2\2{x\3\2\2\2|"+
		"\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\25\3\2\2\2\177}\3\2\2\2\u0080\u0082"+
		"\7\f\2\2\u0081\u0083\7\13\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0095\3\2\2\2\u0084\u0086\7\r\2\2\u0085\u0087\7\13\2\2\u0086\u0085"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0095\3\2\2\2\u0088\u008a\7\16\2\2"+
		"\u0089\u008b\7\13\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0095"+
		"\3\2\2\2\u008c\u008e\7\17\2\2\u008d\u008f\7\13\2\2\u008e\u008d\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u0095\3\2\2\2\u0090\u0092\7-\2\2\u0091\u0093"+
		"\7\13\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2"+
		"\u0094\u0080\3\2\2\2\u0094\u0084\3\2\2\2\u0094\u0088\3\2\2\2\u0094\u008c"+
		"\3\2\2\2\u0094\u0090\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\b\f\1\2\u0097"+
		"\27\3\2\2\2\u0098\u0099\5\32\16\2\u0099\u009a\b\r\1\2\u009a\u009c\3\2"+
		"\2\2\u009b\u0098\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\31\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\4\2"+
		"\2\u00a1\u00a2\5\30\r\2\u00a2\u00a3\7\5\2\2\u00a3\u00a4\b\16\1\2\u00a4"+
		"\u00df\3\2\2\2\u00a5\u00a6\7\20\2\2\u00a6\u00a7\5\"\22\2\u00a7\u00a8\7"+
		"\n\2\2\u00a8\u00a9\b\16\1\2\u00a9\u00df\3\2\2\2\u00aa\u00ab\7\21\2\2\u00ab"+
		"\u00ac\5\60\31\2\u00ac\u00ad\7\n\2\2\u00ad\u00ae\b\16\1\2\u00ae\u00df"+
		"\3\2\2\2\u00af\u00b0\7\22\2\2\u00b0\u00b1\5\"\22\2\u00b1\u00b2\7\7\2\2"+
		"\u00b2\u00b3\5\32\16\2\u00b3\u00b4\b\16\1\2\u00b4\u00df\3\2\2\2\u00b5"+
		"\u00b6\5\60\31\2\u00b6\u00b7\7\23\2\2\u00b7\u00b8\5\"\22\2\u00b8\u00b9"+
		"\7\n\2\2\u00b9\u00ba\b\16\1\2\u00ba\u00df\3\2\2\2\u00bb\u00bc\7\24\2\2"+
		"\u00bc\u00bd\7\6\2\2\u00bd\u00be\5\"\22\2\u00be\u00bf\7\7\2\2\u00bf\u00c0"+
		"\5\32\16\2\u00c0\u00c1\b\16\1\2\u00c1\u00df\3\2\2\2\u00c2\u00c3\7\24\2"+
		"\2\u00c3\u00c4\7\6\2\2\u00c4\u00c5\5\"\22\2\u00c5\u00c6\7\7\2\2\u00c6"+
		"\u00c7\5\32\16\2\u00c7\u00c8\7\25\2\2\u00c8\u00c9\5\32\16\2\u00c9\u00ca"+
		"\b\16\1\2\u00ca\u00df\3\2\2\2\u00cb\u00cc\7\26\2\2\u00cc\u00cd\5\34\17"+
		"\2\u00cd\u00ce\7\n\2\2\u00ce\u00cf\b\16\1\2\u00cf\u00df\3\2\2\2\u00d0"+
		"\u00d1\7)\2\2\u00d1\u00d2\7\6\2\2\u00d2\u00d3\5 \21\2\u00d3\u00d5\7\7"+
		"\2\2\u00d4\u00d6\7\27\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\5.\30\2\u00d8\u00da\7\30\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\n\2\2\u00dc"+
		"\u00dd\b\16\1\2\u00dd\u00df\3\2\2\2\u00de\u00a0\3\2\2\2\u00de\u00a5\3"+
		"\2\2\2\u00de\u00aa\3\2\2\2\u00de\u00af\3\2\2\2\u00de\u00b5\3\2\2\2\u00de"+
		"\u00bb\3\2\2\2\u00de\u00c2\3\2\2\2\u00de\u00cb\3\2\2\2\u00de\u00d0\3\2"+
		"\2\2\u00df\33\3\2\2\2\u00e0\u00e1\5\36\20\2\u00e1\u00e2\b\17\1\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\35\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ea"+
		"\5\"\22\2\u00e9\u00eb\7\13\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2"+
		"\u00eb\u00ec\3\2\2\2\u00ec\u00ed\b\20\1\2\u00ed\37\3\2\2\2\u00ee\u00f0"+
		"\5\"\22\2\u00ef\u00f1\7\13\2\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2"+
		"\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\21\1\2\u00f3\u00f5\3\2\2\2\u00f4\u00ee"+
		"\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"!\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\b\22\1\2\u00fa\u00fb\5$\23\2"+
		"\u00fb\u00fc\b\22\1\2\u00fc\u0104\3\2\2\2\u00fd\u00fe\f\4\2\2\u00fe\u00ff"+
		"\7\31\2\2\u00ff\u0100\5\"\22\5\u0100\u0101\b\22\1\2\u0101\u0103\3\2\2"+
		"\2\u0102\u00fd\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105#\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\b\23\1\2\u0108"+
		"\u0109\5&\24\2\u0109\u010a\7\27\2\2\u010a\u010b\5&\24\2\u010b\u010c\b"+
		"\23\1\2\u010c\u0116\3\2\2\2\u010d\u010e\5&\24\2\u010e\u010f\7\30\2\2\u010f"+
		"\u0110\5&\24\2\u0110\u0111\b\23\1\2\u0111\u0116\3\2\2\2\u0112\u0113\5"+
		"&\24\2\u0113\u0114\b\23\1\2\u0114\u0116\3\2\2\2\u0115\u0107\3\2\2\2\u0115"+
		"\u010d\3\2\2\2\u0115\u0112\3\2\2\2\u0116\u0123\3\2\2\2\u0117\u0118\f\5"+
		"\2\2\u0118\u0119\7\32\2\2\u0119\u011a\5&\24\2\u011a\u011b\b\23\1\2\u011b"+
		"\u0122\3\2\2\2\u011c\u011d\f\4\2\2\u011d\u011e\7\33\2\2\u011e\u011f\5"+
		"&\24\2\u011f\u0120\b\23\1\2\u0120\u0122\3\2\2\2\u0121\u0117\3\2\2\2\u0121"+
		"\u011c\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124%\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\b\24\1\2\u0127\u0128"+
		"\5(\25\2\u0128\u0129\b\24\1\2\u0129\u0136\3\2\2\2\u012a\u012b\f\5\2\2"+
		"\u012b\u012c\7\34\2\2\u012c\u012d\5&\24\6\u012d\u012e\b\24\1\2\u012e\u0135"+
		"\3\2\2\2\u012f\u0130\f\4\2\2\u0130\u0131\7\35\2\2\u0131\u0132\5&\24\5"+
		"\u0132\u0133\b\24\1\2\u0133\u0135\3\2\2\2\u0134\u012a\3\2\2\2\u0134\u012f"+
		"\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\'\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\b\25\1\2\u013a\u013b\5*\26"+
		"\2\u013b\u013c\b\25\1\2\u013c\u014e\3\2\2\2\u013d\u013e\f\6\2\2\u013e"+
		"\u013f\7\36\2\2\u013f\u0140\5(\25\7\u0140\u0141\b\25\1\2\u0141\u014d\3"+
		"\2\2\2\u0142\u0143\f\5\2\2\u0143\u0144\7\37\2\2\u0144\u0145\5(\25\6\u0145"+
		"\u0146\b\25\1\2\u0146\u014d\3\2\2\2\u0147\u0148\f\4\2\2\u0148\u0149\7"+
		" \2\2\u0149\u014a\5(\25\5\u014a\u014b\b\25\1\2\u014b\u014d\3\2\2\2\u014c"+
		"\u013d\3\2\2\2\u014c\u0142\3\2\2\2\u014c\u0147\3\2\2\2\u014d\u0150\3\2"+
		"\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f)\3\2\2\2\u0150\u014e"+
		"\3\2\2\2\u0151\u0152\7!\2\2\u0152\u0153\5*\26\2\u0153\u0154\b\26\1\2\u0154"+
		"\u016a\3\2\2\2\u0155\u0156\7\35\2\2\u0156\u0157\5*\26\2\u0157\u0158\b"+
		"\26\1\2\u0158\u016a\3\2\2\2\u0159\u015c\7\"\2\2\u015a\u015c\7#\2\2\u015b"+
		"\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u016a\b\26"+
		"\1\2\u015e\u015f\7$\2\2\u015f\u016a\b\26\1\2\u0160\u0161\7*\2\2\u0161"+
		"\u016a\b\26\1\2\u0162\u0163\7+\2\2\u0163\u016a\b\26\1\2\u0164\u0165\7"+
		",\2\2\u0165\u016a\b\26\1\2\u0166\u0167\5,\27\2\u0167\u0168\b\26\1\2\u0168"+
		"\u016a\3\2\2\2\u0169\u0151\3\2\2\2\u0169\u0155\3\2\2\2\u0169\u015b\3\2"+
		"\2\2\u0169\u015e\3\2\2\2\u0169\u0160\3\2\2\2\u0169\u0162\3\2\2\2\u0169"+
		"\u0164\3\2\2\2\u0169\u0166\3\2\2\2\u016a+\3\2\2\2\u016b\u016c\5\60\31"+
		"\2\u016c\u016d\b\27\1\2\u016d\u0189\3\2\2\2\u016e\u016f\7\6\2\2\u016f"+
		"\u0170\5\"\22\2\u0170\u0171\7\7\2\2\u0171\u0172\b\27\1\2\u0172\u0189\3"+
		"\2\2\2\u0173\u0174\b\27\1\2\u0174\u0175\7%\2\2\u0175\u017b\5\26\f\2\u0176"+
		"\u0177\7&\2\2\u0177\u0178\5\"\22\2\u0178\u0179\7\'\2\2\u0179\u017a\b\27"+
		"\1\2\u017a\u017c\3\2\2\2\u017b\u0176\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u017e\b\27\1\2\u017e\u0189\3\2\2\2\u017f\u0180\7"+
		")\2\2\u0180\u0181\7\6\2\2\u0181\u0182\5 \21\2\u0182\u0183\7\7\2\2\u0183"+
		"\u0184\7&\2\2\u0184\u0185\5\"\22\2\u0185\u0186\7\'\2\2\u0186\u0187\b\27"+
		"\1\2\u0187\u0189\3\2\2\2\u0188\u016b\3\2\2\2\u0188\u016e\3\2\2\2\u0188"+
		"\u0173\3\2\2\2\u0188\u017f\3\2\2\2\u0189-\3\2\2\2\u018a\u018c\5\60\31"+
		"\2\u018b\u018d\7\13\2\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u018f\b\30\1\2\u018f\u0191\3\2\2\2\u0190\u018a\3"+
		"\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"/\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196\b\31\1\2\u0196\u0197\7)\2\2"+
		"\u0197\u0198\b\31\1\2\u0198\u01a5\3\2\2\2\u0199\u019a\f\4\2\2\u019a\u019b"+
		"\7&\2\2\u019b\u019c\5\"\22\2\u019c\u019d\7\'\2\2\u019d\u019e\b\31\1\2"+
		"\u019e\u01a4\3\2\2\2\u019f\u01a0\f\3\2\2\u01a0\u01a1\7(\2\2\u01a1\u01a2"+
		"\7)\2\2\u01a2\u01a4\b\31\1\2\u01a3\u0199\3\2\2\2\u01a3\u019f\3\2\2\2\u01a4"+
		"\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\61\3\2\2"+
		"\2\u01a7\u01a5\3\2\2\2\';JR_mt}\u0082\u0086\u008a\u008e\u0092\u0094\u009d"+
		"\u00d5\u00d9\u00de\u00e5\u00ea\u00f0\u00f6\u0104\u0115\u0121\u0123\u0134"+
		"\u0136\u014c\u014e\u015b\u0169\u017b\u0188\u018c\u0192\u01a3\u01a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}