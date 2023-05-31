// Generated from ./parser/lang.g4 by ANTLR 4.8

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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		ID=32, INT=33, FLOAT=34, CHAR=35, TYPE=36, NEWLINE=37, LINE_COMMENT=38, 
		COMMENT=39, BLANK=40;
	public static final int
		RULE_prog = 0, RULE_dataList = 1, RULE_funcList = 2, RULE_data = 3, RULE_declList = 4, 
		RULE_decl = 5, RULE_func = 6, RULE_params = 7, RULE_param = 8, RULE_type = 9, 
		RULE_cmd = 10, RULE_cmdList = 11, RULE_exp = 12, RULE_rexp = 13, RULE_aexp = 14, 
		RULE_mexp = 15, RULE_sexp = 16, RULE_pexp = 17, RULE_lvalue = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dataList", "funcList", "data", "declList", "decl", "func", "params", 
			"param", "type", "cmd", "cmdList", "exp", "rexp", "aexp", "mexp", "sexp", 
			"pexp", "lvalue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'data'", "'{'", "'}'", "'::'", "';'", "'('", "')'", "':'", "'['", 
			"']'", "'Int'", "'Char'", "'Float'", "'Bool'", "'print'", "'='", "'if'", 
			"'else'", "'&'", "'<'", "'>'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'true'", "'false'", "'null'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "ID", "INT", "FLOAT", 
			"CHAR", "TYPE", "NEWLINE", "LINE_COMMENT", "COMMENT", "BLANK"
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((ProgContext)_localctx).d = dataList();
			setState(39);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDataList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDataList(this);
		}
	}

	public final DataListContext dataList() throws RecognitionException {
		DataListContext _localctx = new DataListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dataList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(42);
				((DataListContext)_localctx).d = data();

				    if(_localctx.ast == null){((DataListContext)_localctx).ast =  new DataList(((DataListContext)_localctx).d.ast.getLine(), ((DataListContext)_localctx).d.ast.getCol(), ((DataListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DataListContext)_localctx).d.ast);}
				  
				}
				}
				setState(49);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterFuncList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitFuncList(this);
		}
	}

	public final FuncListContext funcList() throws RecognitionException {
		FuncListContext _localctx = new FuncListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(50);
				((FuncListContext)_localctx).f = func();

				    if(_localctx.ast == null){((FuncListContext)_localctx).ast =  new FuncList(((FuncListContext)_localctx).f.ast.getLine(), ((FuncListContext)_localctx).f.ast.getCol(), ((FuncListContext)_localctx).f.ast); }
				    else{_localctx.ast.addNode(((FuncListContext)_localctx).f.ast);}
				  
				}
				}
				setState(57);
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
		public Node ast;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitData(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((DataContext)_localctx).kw = match(T__0);
			setState(59);
			((DataContext)_localctx).TYPE = match(TYPE);
			setState(60);
			match(T__1);
			setState(61);
			((DataContext)_localctx).declList = declList();
			setState(62);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDeclList(this);
		}
	}

	public final DeclListContext declList() throws RecognitionException {
		DeclListContext _localctx = new DeclListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(65);
				((DeclListContext)_localctx).d = decl();

				    if(_localctx.ast == null){((DeclListContext)_localctx).ast =  new DeclList(((DeclListContext)_localctx).d.ast.getLine(), ((DeclListContext)_localctx).d.ast.getCol(), ((DeclListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DeclListContext)_localctx).d.ast);}
				  
				}
				}
				setState(72);
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
		public Node ast;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((DeclContext)_localctx).ID = match(ID);
			setState(74);
			match(T__3);
			setState(75);
			((DeclContext)_localctx).type = type(0);
			setState(76);
			match(T__4);
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

	public static class FuncContext extends ParserRuleContext {
		public Func ast;
		public Token ID;
		public ParamsContext params;
		public CmdListContext cmdList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			((FuncContext)_localctx).ID = match(ID);
			setState(80);
			match(T__5);
			setState(81);
			((FuncContext)_localctx).params = params();
			setState(82);
			match(T__6);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(83);
				match(T__7);
				setState(84);
				type(0);
				}
			}

			setState(87);
			match(T__1);
			setState(88);
			((FuncContext)_localctx).cmdList = cmdList();
			setState(89);
			match(T__2);

			    ((FuncContext)_localctx).ast =  new Func((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), new ID((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null)), ((FuncContext)_localctx).params.ast, null, ((FuncContext)_localctx).cmdList.ast);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(92);
				((ParamsContext)_localctx).p = param();

				    if(_localctx.ast == null){((ParamsContext)_localctx).ast =  new ParamsList(((ParamsContext)_localctx).p.ast.getLine(), ((ParamsContext)_localctx).p.ast.getCol(), ((ParamsContext)_localctx).p.ast); }
				    else{_localctx.ast.addNode(((ParamsContext)_localctx).p.ast);}
				    
				  
				}
				}
				setState(99);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			((ParamContext)_localctx).ID = match(ID);
			setState(101);
			match(T__3);
			setState(102);
			((ParamContext)_localctx).t = ((ParamContext)_localctx).type = type(0);

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

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(106);
				((TypeContext)_localctx).t = match(T__10);
				}
				break;
			case T__11:
				{
				setState(107);
				((TypeContext)_localctx).t = match(T__11);
				}
				break;
			case T__12:
				{
				setState(108);
				((TypeContext)_localctx).t = match(T__12);
				}
				break;
			case T__13:
				{
				setState(109);
				((TypeContext)_localctx).t = match(T__13);
				}
				break;
			case ID:
				{
				setState(110);
				((TypeContext)_localctx).t = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((TypeContext)_localctx).ast =  new Type((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getCharPositionInLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getText():null));
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(115);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(116);
					match(T__8);
					setState(117);
					match(T__9);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class CmdContext extends ParserRuleContext {
		public Node ast;
		public ExpContext exp;
		public CmdListContext cmdList;
		public LvalueContext lvalue;
		public Token f;
		public CmdContext cmd;
		public CmdContext c1;
		public CmdContext c2;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
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
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmd);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(T__14);
				setState(124);
				((CmdContext)_localctx).exp = exp(0);
				setState(125);
				match(T__4);
				((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast.getLine(), ((CmdContext)_localctx).exp.ast.getCol(), ((CmdContext)_localctx).exp.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__1);
				setState(129);
				((CmdContext)_localctx).cmdList = cmdList();
				setState(130);
				match(T__2);
				 ((CmdContext)_localctx).ast =  ((CmdContext)_localctx).cmdList.ast;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(134);
				match(T__15);
				setState(135);
				((CmdContext)_localctx).exp = exp(0);
				setState(136);
				match(T__4);
				((CmdContext)_localctx).ast =  new Attr(((CmdContext)_localctx).lvalue.ast.getLine(), ((CmdContext)_localctx).lvalue.ast.getCol(), ((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				((CmdContext)_localctx).f = match(T__16);
				setState(140);
				match(T__5);
				setState(141);
				((CmdContext)_localctx).exp = exp(0);
				setState(142);
				match(T__6);
				setState(143);
				((CmdContext)_localctx).cmd = cmd();
				((CmdContext)_localctx).ast =  new If((((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getLine():0), (((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getCharPositionInLine():0), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).cmd.ast, null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				((CmdContext)_localctx).f = match(T__16);
				setState(147);
				match(T__5);
				setState(148);
				((CmdContext)_localctx).exp = exp(0);
				setState(149);
				match(T__6);
				setState(150);
				((CmdContext)_localctx).c1 = cmd();
				setState(151);
				match(T__17);
				setState(152);
				((CmdContext)_localctx).c2 = cmd();
				((CmdContext)_localctx).ast =  new If((((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getLine():0), (((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getCharPositionInLine():0), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).c1.ast, ((CmdContext)_localctx).c2.ast);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterCmdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitCmdList(this);
		}
	}

	public final CmdListContext cmdList() throws RecognitionException {
		CmdListContext _localctx = new CmdListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__16) | (1L << ID))) != 0)) {
				{
				{
				setState(157);
				((CmdListContext)_localctx).c = cmd();

				    
				    if(_localctx.ast == null){((CmdListContext)_localctx).ast =  new CmdList(((CmdListContext)_localctx).c.ast.getLine(), ((CmdListContext)_localctx).c.ast.getCol(), ((CmdListContext)_localctx).c.ast); }
				    else{_localctx.ast.addNode(((CmdListContext)_localctx).c.ast);}
				  
				}
				}
				setState(164);
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
		public Token INT;
		public Token CHAR;
		public LvalueContext lvalue;
		public RexpContext rexp;
		public ExpContext a2;
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(langParser.CHAR, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(166);
				((ExpContext)_localctx).INT = match(INT);
				((ExpContext)_localctx).ast =  new Int((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getLine():0), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)));
				}
				break;
			case 2:
				{
				setState(168);
				((ExpContext)_localctx).CHAR = match(CHAR);
				((ExpContext)_localctx).ast =  new Char((((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getLine():0), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getCharPositionInLine():0), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getText():null));
				}
				break;
			case 3:
				{
				setState(170);
				((ExpContext)_localctx).lvalue = lvalue(0);
				((ExpContext)_localctx).ast =  ((ExpContext)_localctx).lvalue.ast;
				}
				break;
			case 4:
				{
				setState(173);
				((ExpContext)_localctx).rexp = rexp(0);
				((ExpContext)_localctx).ast = ((ExpContext)_localctx).rexp.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
					setState(178);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(179);
					match(T__18);
					setState(180);
					match(T__18);
					setState(181);
					((ExpContext)_localctx).a2 = exp(6);
					((ExpContext)_localctx).ast =  new And(((ExpContext)_localctx).a1.ast.getLine(), ((ExpContext)_localctx).a1.ast.getCol(), ((ExpContext)_localctx).a1.ast, ((ExpContext)_localctx).a2.ast);
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterRexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitRexp(this);
		}
	}

	public final RexpContext rexp() throws RecognitionException {
		return rexp(0);
	}

	private RexpContext rexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RexpContext _localctx = new RexpContext(_ctx, _parentState);
		RexpContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_rexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(190);
				((RexpContext)_localctx).ll = ((RexpContext)_localctx).aexp = aexp(0);
				setState(191);
				((RexpContext)_localctx).o = match(T__19);
				setState(192);
				((RexpContext)_localctx).rl = ((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast =  new LessThan((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).ll.ast, ((RexpContext)_localctx).rl.ast);
				}
				break;
			case 2:
				{
				setState(195);
				((RexpContext)_localctx).lg = ((RexpContext)_localctx).aexp = aexp(0);
				setState(196);
				((RexpContext)_localctx).o = match(T__20);
				setState(197);
				((RexpContext)_localctx).rg = ((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast =  new GreaterThan((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).lg.ast, ((RexpContext)_localctx).rg.ast);
				}
				break;
			case 3:
				{
				setState(200);
				((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast = ((RexpContext)_localctx).aexp.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new RexpContext(_parentctx, _parentState);
						_localctx.le = _prevctx;
						_localctx.le = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(205);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(206);
						((RexpContext)_localctx).o = match(T__15);
						setState(207);
						match(T__15);
						setState(208);
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
						setState(211);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(212);
						((RexpContext)_localctx).o = match(T__21);
						setState(213);
						match(T__15);
						setState(214);
						((RexpContext)_localctx).rd = ((RexpContext)_localctx).aexp = aexp(0);
						((RexpContext)_localctx).ast =  new Diff((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).ld.ast, ((RexpContext)_localctx).rd.ast);
						}
						break;
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterAexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitAexp(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		return aexp(0);
	}

	private AexpContext aexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpContext _localctx = new AexpContext(_ctx, _parentState);
		AexpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_aexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(223);
			((AexpContext)_localctx).mexp = mexp();
			((AexpContext)_localctx).ast = ((AexpContext)_localctx).mexp.ast;
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(251);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(226);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(227);
						match(T__22);
						setState(228);
						((AexpContext)_localctx).a2 = aexp(7);
						((AexpContext)_localctx).ast =  new Add(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					case 2:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(231);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(232);
						match(T__23);
						setState(233);
						((AexpContext)_localctx).a2 = aexp(6);
						((AexpContext)_localctx).ast =  new Sub(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					case 3:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(236);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(237);
						match(T__24);
						setState(238);
						((AexpContext)_localctx).a2 = aexp(5);
						((AexpContext)_localctx).ast =  new Mul(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					case 4:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(241);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(242);
						match(T__25);
						setState(243);
						((AexpContext)_localctx).a2 = aexp(4);
						((AexpContext)_localctx).ast =  new Div(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					case 5:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(246);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(247);
						match(T__26);
						setState(248);
						((AexpContext)_localctx).a2 = aexp(3);
						((AexpContext)_localctx).ast =  new Rest(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public SexpContext sexp;
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public MexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterMexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitMexp(this);
		}
	}

	public final MexpContext mexp() throws RecognitionException {
		MexpContext _localctx = new MexpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			((MexpContext)_localctx).sexp = sexp();
			((MexpContext)_localctx).ast = ((MexpContext)_localctx).sexp.ast;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterSexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitSexp(this);
		}
	}

	public final SexpContext sexp() throws RecognitionException {
		SexpContext _localctx = new SexpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sexp);
		try {
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				((SexpContext)_localctx).n = match(T__21);
				setState(260);
				((SexpContext)_localctx).sexp = sexp();
				((SexpContext)_localctx).ast =  new Neg((((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getLine():0), (((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getCharPositionInLine():0), ((SexpContext)_localctx).sexp.ast);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				((SexpContext)_localctx).su = match(T__23);
				setState(264);
				((SexpContext)_localctx).sexp = sexp();
				((SexpContext)_localctx).ast =  new SubUni((((SexpContext)_localctx).su!=null?((SexpContext)_localctx).su.getLine():0), (((SexpContext)_localctx).su!=null?((SexpContext)_localctx).su.getCharPositionInLine():0), ((SexpContext)_localctx).sexp.ast);
				}
				break;
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__27:
					{
					setState(267);
					((SexpContext)_localctx).b = match(T__27);
					}
					break;
				case T__28:
					{
					setState(268);
					((SexpContext)_localctx).b = match(T__28);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				((SexpContext)_localctx).ast =  new Bool((((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getLine():0), (((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getCharPositionInLine():0), Boolean.parseBoolean((((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getText():null)));
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 4);
				{
				setState(272);
				((SexpContext)_localctx).n = match(T__29);
				((SexpContext)_localctx).ast =  new Null((((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getLine():0), (((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getCharPositionInLine():0));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				((SexpContext)_localctx).INT = match(INT);
				((SexpContext)_localctx).ast =  new Int((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getLine():0), (((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getText():null)));
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 6);
				{
				setState(276);
				((SexpContext)_localctx).FLOAT = match(FLOAT);
				((SexpContext)_localctx).ast =  new FloatAst((((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getLine():0), (((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getCharPositionInLine():0), Float.parseFloat((((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getText():null)));
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(278);
				((SexpContext)_localctx).CHAR = match(CHAR);
				((SexpContext)_localctx).ast =  new Char((((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getLine():0), (((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getCharPositionInLine():0), (((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getText():null));
				}
				break;
			case T__5:
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(280);
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
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterPexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitPexp(this);
		}
	}

	public final PexpContext pexp() throws RecognitionException {
		PexpContext _localctx = new PexpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pexp);
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				((PexpContext)_localctx).lvalue = lvalue(0);
				((PexpContext)_localctx).ast = ((PexpContext)_localctx).lvalue.ast;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(T__5);
				setState(289);
				((PexpContext)_localctx).exp = exp(0);
				setState(290);
				match(T__6);
				((PexpContext)_localctx).ast = ((PexpContext)_localctx).exp.ast;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitLvalue(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(296);
			((LvalueContext)_localctx).ID = match(ID);
			((LvalueContext)_localctx).ast =  new LValue((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), new ID((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null)));
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(309);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(299);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(300);
						match(T__8);
						setState(301);
						exp(0);
						setState(302);
						match(T__9);

						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(305);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(306);
						match(T__30);
						setState(307);
						((LvalueContext)_localctx).ID = match(ID);

						}
						break;
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		case 9:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 12:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 13:
			return rexp_sempred((RexpContext)_localctx, predIndex);
		case 14:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 18:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean rexp_sempred(RexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u013d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bX\n\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tb\n\t\f\t\16"+
		"\te\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13r\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13y\n\13\f\13\16\13|\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009e\n\f\3\r\3\r\3\r\7"+
		"\r\u00a3\n\r\f\r\16\r\u00a6\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u00b3\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u00bb\n\16\f\16\16\16\u00be\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ce\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00dc\n\17\f\17\16\17\u00df"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\7\20\u00fe\n\20\f\20\16\20\u0101\13\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0110\n\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011e\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0128\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0138\n\24\f\24"+
		"\16\24\u013b\13\24\3\24\2\7\24\32\34\36&\25\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&\2\2\2\u0150\2(\3\2\2\2\4\61\3\2\2\2\69\3\2\2\2\b<\3"+
		"\2\2\2\nH\3\2\2\2\fK\3\2\2\2\16Q\3\2\2\2\20c\3\2\2\2\22f\3\2\2\2\24k\3"+
		"\2\2\2\26\u009d\3\2\2\2\30\u00a4\3\2\2\2\32\u00b2\3\2\2\2\34\u00cd\3\2"+
		"\2\2\36\u00e0\3\2\2\2 \u0102\3\2\2\2\"\u011d\3\2\2\2$\u0127\3\2\2\2&\u0129"+
		"\3\2\2\2()\5\4\3\2)*\5\6\4\2*+\b\2\1\2+\3\3\2\2\2,-\5\b\5\2-.\b\3\1\2"+
		".\60\3\2\2\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3"+
		"\2\2\2\63\61\3\2\2\2\64\65\5\16\b\2\65\66\b\4\1\2\668\3\2\2\2\67\64\3"+
		"\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\7\3\2\2\2;9\3\2\2\2<=\7\3\2\2"+
		"=>\7&\2\2>?\7\4\2\2?@\5\n\6\2@A\7\5\2\2AB\b\5\1\2B\t\3\2\2\2CD\5\f\7\2"+
		"DE\b\6\1\2EG\3\2\2\2FC\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\13\3\2\2"+
		"\2JH\3\2\2\2KL\7\"\2\2LM\7\6\2\2MN\5\24\13\2NO\7\7\2\2OP\b\7\1\2P\r\3"+
		"\2\2\2QR\7\"\2\2RS\7\b\2\2ST\5\20\t\2TW\7\t\2\2UV\7\n\2\2VX\5\24\13\2"+
		"WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\4\2\2Z[\5\30\r\2[\\\7\5\2\2\\]\b\b"+
		"\1\2]\17\3\2\2\2^_\5\22\n\2_`\b\t\1\2`b\3\2\2\2a^\3\2\2\2be\3\2\2\2ca"+
		"\3\2\2\2cd\3\2\2\2d\21\3\2\2\2ec\3\2\2\2fg\7\"\2\2gh\7\6\2\2hi\5\24\13"+
		"\2ij\b\n\1\2j\23\3\2\2\2kq\b\13\1\2lr\7\r\2\2mr\7\16\2\2nr\7\17\2\2or"+
		"\7\20\2\2pr\7\"\2\2ql\3\2\2\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2"+
		"rs\3\2\2\2st\b\13\1\2tz\3\2\2\2uv\f\4\2\2vw\7\13\2\2wy\7\f\2\2xu\3\2\2"+
		"\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\25\3\2\2\2|z\3\2\2\2}~\7\21\2\2~\177"+
		"\5\32\16\2\177\u0080\7\7\2\2\u0080\u0081\b\f\1\2\u0081\u009e\3\2\2\2\u0082"+
		"\u0083\7\4\2\2\u0083\u0084\5\30\r\2\u0084\u0085\7\5\2\2\u0085\u0086\b"+
		"\f\1\2\u0086\u009e\3\2\2\2\u0087\u0088\5&\24\2\u0088\u0089\7\22\2\2\u0089"+
		"\u008a\5\32\16\2\u008a\u008b\7\7\2\2\u008b\u008c\b\f\1\2\u008c\u009e\3"+
		"\2\2\2\u008d\u008e\7\23\2\2\u008e\u008f\7\b\2\2\u008f\u0090\5\32\16\2"+
		"\u0090\u0091\7\t\2\2\u0091\u0092\5\26\f\2\u0092\u0093\b\f\1\2\u0093\u009e"+
		"\3\2\2\2\u0094\u0095\7\23\2\2\u0095\u0096\7\b\2\2\u0096\u0097\5\32\16"+
		"\2\u0097\u0098\7\t\2\2\u0098\u0099\5\26\f\2\u0099\u009a\7\24\2\2\u009a"+
		"\u009b\5\26\f\2\u009b\u009c\b\f\1\2\u009c\u009e\3\2\2\2\u009d}\3\2\2\2"+
		"\u009d\u0082\3\2\2\2\u009d\u0087\3\2\2\2\u009d\u008d\3\2\2\2\u009d\u0094"+
		"\3\2\2\2\u009e\27\3\2\2\2\u009f\u00a0\5\26\f\2\u00a0\u00a1\b\r\1\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8"+
		"\b\16\1\2\u00a8\u00a9\7#\2\2\u00a9\u00b3\b\16\1\2\u00aa\u00ab\7%\2\2\u00ab"+
		"\u00b3\b\16\1\2\u00ac\u00ad\5&\24\2\u00ad\u00ae\b\16\1\2\u00ae\u00b3\3"+
		"\2\2\2\u00af\u00b0\5\34\17\2\u00b0\u00b1\b\16\1\2\u00b1\u00b3\3\2\2\2"+
		"\u00b2\u00a7\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00af"+
		"\3\2\2\2\u00b3\u00bc\3\2\2\2\u00b4\u00b5\f\7\2\2\u00b5\u00b6\7\25\2\2"+
		"\u00b6\u00b7\7\25\2\2\u00b7\u00b8\5\32\16\b\u00b8\u00b9\b\16\1\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b4\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\33\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0"+
		"\b\17\1\2\u00c0\u00c1\5\36\20\2\u00c1\u00c2\7\26\2\2\u00c2\u00c3\5\36"+
		"\20\2\u00c3\u00c4\b\17\1\2\u00c4\u00ce\3\2\2\2\u00c5\u00c6\5\36\20\2\u00c6"+
		"\u00c7\7\27\2\2\u00c7\u00c8\5\36\20\2\u00c8\u00c9\b\17\1\2\u00c9\u00ce"+
		"\3\2\2\2\u00ca\u00cb\5\36\20\2\u00cb\u00cc\b\17\1\2\u00cc\u00ce\3\2\2"+
		"\2\u00cd\u00bf\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00ca\3\2\2\2\u00ce\u00dd"+
		"\3\2\2\2\u00cf\u00d0\f\5\2\2\u00d0\u00d1\7\22\2\2\u00d1\u00d2\7\22\2\2"+
		"\u00d2\u00d3\5\36\20\2\u00d3\u00d4\b\17\1\2\u00d4\u00dc\3\2\2\2\u00d5"+
		"\u00d6\f\4\2\2\u00d6\u00d7\7\30\2\2\u00d7\u00d8\7\22\2\2\u00d8\u00d9\5"+
		"\36\20\2\u00d9\u00da\b\17\1\2\u00da\u00dc\3\2\2\2\u00db\u00cf\3\2\2\2"+
		"\u00db\u00d5\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\35\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\b\20\1\2\u00e1"+
		"\u00e2\5 \21\2\u00e2\u00e3\b\20\1\2\u00e3\u00ff\3\2\2\2\u00e4\u00e5\f"+
		"\b\2\2\u00e5\u00e6\7\31\2\2\u00e6\u00e7\5\36\20\t\u00e7\u00e8\b\20\1\2"+
		"\u00e8\u00fe\3\2\2\2\u00e9\u00ea\f\7\2\2\u00ea\u00eb\7\32\2\2\u00eb\u00ec"+
		"\5\36\20\b\u00ec\u00ed\b\20\1\2\u00ed\u00fe\3\2\2\2\u00ee\u00ef\f\6\2"+
		"\2\u00ef\u00f0\7\33\2\2\u00f0\u00f1\5\36\20\7\u00f1\u00f2\b\20\1\2\u00f2"+
		"\u00fe\3\2\2\2\u00f3\u00f4\f\5\2\2\u00f4\u00f5\7\34\2\2\u00f5\u00f6\5"+
		"\36\20\6\u00f6\u00f7\b\20\1\2\u00f7\u00fe\3\2\2\2\u00f8\u00f9\f\4\2\2"+
		"\u00f9\u00fa\7\35\2\2\u00fa\u00fb\5\36\20\5\u00fb\u00fc\b\20\1\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00e4\3\2\2\2\u00fd\u00e9\3\2\2\2\u00fd\u00ee\3\2"+
		"\2\2\u00fd\u00f3\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\37\3\2\2\2\u0101\u00ff\3\2\2"+
		"\2\u0102\u0103\5\"\22\2\u0103\u0104\b\21\1\2\u0104!\3\2\2\2\u0105\u0106"+
		"\7\30\2\2\u0106\u0107\5\"\22\2\u0107\u0108\b\22\1\2\u0108\u011e\3\2\2"+
		"\2\u0109\u010a\7\32\2\2\u010a\u010b\5\"\22\2\u010b\u010c\b\22\1\2\u010c"+
		"\u011e\3\2\2\2\u010d\u0110\7\36\2\2\u010e\u0110\7\37\2\2\u010f\u010d\3"+
		"\2\2\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u011e\b\22\1\2\u0112"+
		"\u0113\7 \2\2\u0113\u011e\b\22\1\2\u0114\u0115\7#\2\2\u0115\u011e\b\22"+
		"\1\2\u0116\u0117\7$\2\2\u0117\u011e\b\22\1\2\u0118\u0119\7%\2\2\u0119"+
		"\u011e\b\22\1\2\u011a\u011b\5$\23\2\u011b\u011c\b\22\1\2\u011c\u011e\3"+
		"\2\2\2\u011d\u0105\3\2\2\2\u011d\u0109\3\2\2\2\u011d\u010f\3\2\2\2\u011d"+
		"\u0112\3\2\2\2\u011d\u0114\3\2\2\2\u011d\u0116\3\2\2\2\u011d\u0118\3\2"+
		"\2\2\u011d\u011a\3\2\2\2\u011e#\3\2\2\2\u011f\u0120\5&\24\2\u0120\u0121"+
		"\b\23\1\2\u0121\u0128\3\2\2\2\u0122\u0123\7\b\2\2\u0123\u0124\5\32\16"+
		"\2\u0124\u0125\7\t\2\2\u0125\u0126\b\23\1\2\u0126\u0128\3\2\2\2\u0127"+
		"\u011f\3\2\2\2\u0127\u0122\3\2\2\2\u0128%\3\2\2\2\u0129\u012a\b\24\1\2"+
		"\u012a\u012b\7\"\2\2\u012b\u012c\b\24\1\2\u012c\u0139\3\2\2\2\u012d\u012e"+
		"\f\4\2\2\u012e\u012f\7\13\2\2\u012f\u0130\5\32\16\2\u0130\u0131\7\f\2"+
		"\2\u0131\u0132\b\24\1\2\u0132\u0138\3\2\2\2\u0133\u0134\f\3\2\2\u0134"+
		"\u0135\7!\2\2\u0135\u0136\7\"\2\2\u0136\u0138\b\24\1\2\u0137\u012d\3\2"+
		"\2\2\u0137\u0133\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\'\3\2\2\2\u013b\u0139\3\2\2\2\27\619HWcqz\u009d\u00a4"+
		"\u00b2\u00bc\u00cd\u00db\u00dd\u00fd\u00ff\u010f\u011d\u0127\u0137\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}