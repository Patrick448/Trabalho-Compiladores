// Generated from parser/lang.g4 by ANTLR 4.8

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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, ID=24, INT=25, 
		FLOAT=26, TYPE=27, NEWLINE=28, LINE_COMMENT=29, COMMENT=30, BLANK=31;
	public static final int
		RULE_prog = 0, RULE_dataList = 1, RULE_funcList = 2, RULE_data = 3, RULE_declList = 4, 
		RULE_decl = 5, RULE_type = 6, RULE_cmd = 7, RULE_cmdList = 8, RULE_func = 9, 
		RULE_exp = 10, RULE_rexp = 11, RULE_aexp = 12, RULE_mexp = 13, RULE_sexp = 14, 
		RULE_pexp = 15, RULE_lvalue = 16, RULE_params = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dataList", "funcList", "data", "declList", "decl", "type", "cmd", 
			"cmdList", "func", "exp", "rexp", "aexp", "mexp", "sexp", "pexp", "lvalue", 
			"params"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'data'", "'{'", "'}'", "'::'", "';'", "'['", "']'", "'Int'", "'Char'", 
			"'Float'", "'Bool'", "'print'", "'='", "'('", "')'", "':'", "'+'", "'!'", 
			"'-'", "'true'", "'false'", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "INT", "FLOAT", "TYPE", "NEWLINE", "LINE_COMMENT", "COMMENT", "BLANK"
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
			setState(36);
			((ProgContext)_localctx).d = dataList();
			setState(37);
			((ProgContext)_localctx).f = funcList();
			((ProgContext)_localctx).ast =  new Prog(((ProgContext)_localctx).d.ast.getLine(), ((ProgContext)_localctx).d.ast.getCol(), ((ProgContext)_localctx).d.ast, ((ProgContext)_localctx).f.ast);
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(40);
				((DataListContext)_localctx).d = data();

				    if(_localctx.ast == null){((DataListContext)_localctx).ast =  new DataList(((DataListContext)_localctx).d.ast.getLine(), ((DataListContext)_localctx).d.ast.getCol(), ((DataListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DataListContext)_localctx).d.ast);}
				  
				}
				}
				setState(47);
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(48);
				((FuncListContext)_localctx).f = func();

				    if(_localctx.ast == null){((FuncListContext)_localctx).ast =  new FuncList(((FuncListContext)_localctx).f.ast.getLine(), ((FuncListContext)_localctx).f.ast.getCol(), ((FuncListContext)_localctx).f.ast); }
				    else{_localctx.ast.addNode(((FuncListContext)_localctx).f.ast);}
				  
				}
				}
				setState(55);
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
		public Token ID;
		public DeclListContext declList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
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
			setState(56);
			((DataContext)_localctx).kw = match(T__0);
			setState(57);
			((DataContext)_localctx).ID = match(ID);
			setState(58);
			match(T__1);
			setState(59);
			((DataContext)_localctx).declList = declList();
			setState(60);
			match(T__2);
			 ((DataContext)_localctx).ast =  new Data((((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getLine():0), (((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getCharPositionInLine():0), new ID((((DataContext)_localctx).ID!=null?((DataContext)_localctx).ID.getLine():0), (((DataContext)_localctx).ID!=null?((DataContext)_localctx).ID.getCharPositionInLine():0), (((DataContext)_localctx).ID!=null?((DataContext)_localctx).ID.getText():null)), ((DataContext)_localctx).declList.ast);
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
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(63);
				((DeclListContext)_localctx).d = decl();

				    if(_localctx.ast == null){((DeclListContext)_localctx).ast =  new DeclList(((DeclListContext)_localctx).d.ast.getLine(), ((DeclListContext)_localctx).d.ast.getCol(), ((DeclListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DeclListContext)_localctx).d.ast);}
				  
				}
				}
				setState(70);
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
			setState(71);
			((DeclContext)_localctx).ID = match(ID);
			setState(72);
			match(T__3);
			setState(73);
			((DeclContext)_localctx).type = type(0);
			setState(74);
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

	public static class TypeContext extends ParserRuleContext {
		public Node ast;
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(78);
				((TypeContext)_localctx).t = match(T__7);
				}
				break;
			case T__8:
				{
				setState(79);
				((TypeContext)_localctx).t = match(T__8);
				}
				break;
			case T__9:
				{
				setState(80);
				((TypeContext)_localctx).t = match(T__9);
				}
				break;
			case T__10:
				{
				setState(81);
				((TypeContext)_localctx).t = match(T__10);
				}
				break;
			case ID:
				{
				setState(82);
				((TypeContext)_localctx).t = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((TypeContext)_localctx).ast =  new Type((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getCharPositionInLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getText():null));
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(87);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(88);
					match(T__5);
					setState(89);
					match(T__6);
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
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
		enterRule(_localctx, 14, RULE_cmd);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(T__11);
				setState(96);
				((CmdContext)_localctx).exp = exp();
				setState(97);
				match(T__4);
				((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast.getLine(), ((CmdContext)_localctx).exp.ast.getCol(), ((CmdContext)_localctx).exp.ast);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(T__1);
				setState(101);
				((CmdContext)_localctx).cmdList = cmdList();
				setState(102);
				match(T__2);
				 ((CmdContext)_localctx).ast =  ((CmdContext)_localctx).cmdList.ast;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(106);
				match(T__12);
				setState(107);
				((CmdContext)_localctx).exp = exp();
				setState(108);
				match(T__4);
				((CmdContext)_localctx).ast =  new Attr(((CmdContext)_localctx).lvalue.ast.getLine(), ((CmdContext)_localctx).lvalue.ast.getCol(), ((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast);
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
		enterRule(_localctx, 16, RULE_cmdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << ID))) != 0)) {
				{
				{
				setState(113);
				((CmdListContext)_localctx).c = cmd();

				    
				    if(_localctx.ast == null){((CmdListContext)_localctx).ast =  new CmdList(((CmdListContext)_localctx).c.ast.getLine(), ((CmdListContext)_localctx).c.ast.getCol(), ((CmdListContext)_localctx).c.ast); }
				    else{_localctx.ast.addNode(((CmdListContext)_localctx).c.ast);}
				  
				}
				}
				setState(120);
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
		public CmdListContext cmdList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
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
		enterRule(_localctx, 18, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			((FuncContext)_localctx).ID = match(ID);
			setState(122);
			match(T__13);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(123);
				params();
				}
			}

			setState(126);
			match(T__14);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(127);
				match(T__15);
				setState(128);
				type(0);
				}
			}

			setState(131);
			match(T__1);
			setState(132);
			((FuncContext)_localctx).cmdList = cmdList();
			setState(133);
			match(T__2);

			    ((FuncContext)_localctx).ast =  new Func((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), new ID((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null)), null, null, ((FuncContext)_localctx).cmdList.ast);
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
		public Token INT;
		public LvalueContext lvalue;
		public RexpContext rexp;
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
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
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exp);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((ExpContext)_localctx).INT = match(INT);
				((ExpContext)_localctx).ast =  new Num((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getLine():0), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				((ExpContext)_localctx).lvalue = lvalue(0);
				((ExpContext)_localctx).ast =  ((ExpContext)_localctx).lvalue.ast;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				((ExpContext)_localctx).rexp = rexp();
				((ExpContext)_localctx).ast = ((ExpContext)_localctx).rexp.ast;
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

	public static class RexpContext extends ParserRuleContext {
		public Expr ast;
		public AexpContext aexp;
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
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
		RexpContext _localctx = new RexpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((RexpContext)_localctx).aexp = aexp(0);
			((RexpContext)_localctx).ast = ((RexpContext)_localctx).aexp.ast;
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_aexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(150);
			((AexpContext)_localctx).mexp = mexp();
			((AexpContext)_localctx).ast = ((AexpContext)_localctx).mexp.ast;
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AexpContext(_parentctx, _parentState);
					_localctx.a1 = _prevctx;
					_localctx.a1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_aexp);
					setState(153);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(154);
					match(T__16);
					setState(155);
					((AexpContext)_localctx).a2 = aexp(3);
					((AexpContext)_localctx).ast =  new Add(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
					}
					} 
				}
				setState(162);
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
		enterRule(_localctx, 26, RULE_mexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
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
		public Token INT;
		public PexpContext pexp;
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(langParser.FLOAT, 0); }
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
		enterRule(_localctx, 28, RULE_sexp);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__17);
				setState(167);
				sexp();

				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(T__18);
				setState(171);
				sexp();

				}
				break;
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				((SexpContext)_localctx).INT = match(INT);
				((SexpContext)_localctx).ast =  new Num((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getLine():0), (((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getText():null)));
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				match(FLOAT);

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
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
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
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
		enterRule(_localctx, 30, RULE_pexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			((PexpContext)_localctx).lvalue = lvalue(0);
			((PexpContext)_localctx).ast = ((PexpContext)_localctx).lvalue.ast;
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(189);
			((LvalueContext)_localctx).ID = match(ID);
			((LvalueContext)_localctx).ast =  new LValue((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), new ID((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null)));
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(192);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(193);
						match(T__5);
						setState(194);
						exp();
						setState(195);
						match(T__6);

						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(198);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(199);
						match(T__21);
						setState(200);
						((LvalueContext)_localctx).ID = match(ID);

						}
						break;
					}
					} 
				}
				setState(206);
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

	public static class ParamsContext extends ParserRuleContext {
		public Node ast;
		public List<TerminalNode> ID() { return getTokens(langParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(langParser.ID, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(langParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(langParser.TYPE, i);
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
		enterRule(_localctx, 34, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(ID);
			setState(208);
			match(T__3);
			setState(209);
			match(TYPE);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(210);
				match(T__22);
				setState(211);
				match(ID);
				setState(212);
				match(T__3);
				setState(213);
				match(TYPE);
				}
				}
				setState(218);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 12:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 16:
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
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00e0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3"+
		"\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\7\6E\n\6\f\6\16\6H\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bV\n\b\3\b\3\b\3\b\3\b\3\b\7\b]\n\b\f\b\16\b`\13\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tr\n\t\3\n\3\n"+
		"\3\n\7\nw\n\n\f\n\16\nz\13\n\3\13\3\13\3\13\5\13\177\n\13\3\13\3\13\3"+
		"\13\5\13\u0084\n\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0093\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u00a1\n\16\f\16\16\16\u00a4\13\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00ba\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00cd\n\22\f\22\16\22\u00d0"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00d9\n\23\f\23\16\23\u00dc"+
		"\13\23\3\23\3\23\3\23\2\5\16\32\"\24\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$\2\3\3\2\26\27\2\u00e5\2&\3\2\2\2\4/\3\2\2\2\6\67\3\2\2\2\b"+
		":\3\2\2\2\nF\3\2\2\2\fI\3\2\2\2\16O\3\2\2\2\20q\3\2\2\2\22x\3\2\2\2\24"+
		"{\3\2\2\2\26\u0092\3\2\2\2\30\u0094\3\2\2\2\32\u0097\3\2\2\2\34\u00a5"+
		"\3\2\2\2\36\u00b9\3\2\2\2 \u00bb\3\2\2\2\"\u00be\3\2\2\2$\u00d1\3\2\2"+
		"\2&\'\5\4\3\2\'(\5\6\4\2()\b\2\1\2)\3\3\2\2\2*+\5\b\5\2+,\b\3\1\2,.\3"+
		"\2\2\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3"+
		"\2\2\2\62\63\5\24\13\2\63\64\b\4\1\2\64\66\3\2\2\2\65\62\3\2\2\2\669\3"+
		"\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2\29\67\3\2\2\2:;\7\3\2\2;<\7"+
		"\32\2\2<=\7\4\2\2=>\5\n\6\2>?\7\5\2\2?@\b\5\1\2@\t\3\2\2\2AB\5\f\7\2B"+
		"C\b\6\1\2CE\3\2\2\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\13\3\2\2"+
		"\2HF\3\2\2\2IJ\7\32\2\2JK\7\6\2\2KL\5\16\b\2LM\7\7\2\2MN\b\7\1\2N\r\3"+
		"\2\2\2OU\b\b\1\2PV\7\n\2\2QV\7\13\2\2RV\7\f\2\2SV\7\r\2\2TV\7\32\2\2U"+
		"P\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2VW\3\2\2\2WX\b\b\1\2"+
		"X^\3\2\2\2YZ\f\4\2\2Z[\7\b\2\2[]\7\t\2\2\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2"+
		"\2^_\3\2\2\2_\17\3\2\2\2`^\3\2\2\2ab\7\16\2\2bc\5\26\f\2cd\7\7\2\2de\b"+
		"\t\1\2er\3\2\2\2fg\7\4\2\2gh\5\22\n\2hi\7\5\2\2ij\b\t\1\2jr\3\2\2\2kl"+
		"\5\"\22\2lm\7\17\2\2mn\5\26\f\2no\7\7\2\2op\b\t\1\2pr\3\2\2\2qa\3\2\2"+
		"\2qf\3\2\2\2qk\3\2\2\2r\21\3\2\2\2st\5\20\t\2tu\b\n\1\2uw\3\2\2\2vs\3"+
		"\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\23\3\2\2\2zx\3\2\2\2{|\7\32\2\2"+
		"|~\7\20\2\2}\177\5$\23\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0083\7\21\2\2\u0081\u0082\7\22\2\2\u0082\u0084\5\16\b\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7\4\2\2\u0086"+
		"\u0087\5\22\n\2\u0087\u0088\7\5\2\2\u0088\u0089\b\13\1\2\u0089\25\3\2"+
		"\2\2\u008a\u008b\7\33\2\2\u008b\u0093\b\f\1\2\u008c\u008d\5\"\22\2\u008d"+
		"\u008e\b\f\1\2\u008e\u0093\3\2\2\2\u008f\u0090\5\30\r\2\u0090\u0091\b"+
		"\f\1\2\u0091\u0093\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008c\3\2\2\2\u0092"+
		"\u008f\3\2\2\2\u0093\27\3\2\2\2\u0094\u0095\5\32\16\2\u0095\u0096\b\r"+
		"\1\2\u0096\31\3\2\2\2\u0097\u0098\b\16\1\2\u0098\u0099\5\34\17\2\u0099"+
		"\u009a\b\16\1\2\u009a\u00a2\3\2\2\2\u009b\u009c\f\4\2\2\u009c\u009d\7"+
		"\23\2\2\u009d\u009e\5\32\16\5\u009e\u009f\b\16\1\2\u009f\u00a1\3\2\2\2"+
		"\u00a0\u009b\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\33\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\5\36\20\2\u00a6"+
		"\u00a7\b\17\1\2\u00a7\35\3\2\2\2\u00a8\u00a9\7\24\2\2\u00a9\u00aa\5\36"+
		"\20\2\u00aa\u00ab\b\20\1\2\u00ab\u00ba\3\2\2\2\u00ac\u00ad\7\25\2\2\u00ad"+
		"\u00ae\5\36\20\2\u00ae\u00af\b\20\1\2\u00af\u00ba\3\2\2\2\u00b0\u00b1"+
		"\t\2\2\2\u00b1\u00ba\b\20\1\2\u00b2\u00b3\7\33\2\2\u00b3\u00ba\b\20\1"+
		"\2\u00b4\u00b5\7\34\2\2\u00b5\u00ba\b\20\1\2\u00b6\u00b7\5 \21\2\u00b7"+
		"\u00b8\b\20\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00a8\3\2\2\2\u00b9\u00ac\3"+
		"\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9"+
		"\u00b6\3\2\2\2\u00ba\37\3\2\2\2\u00bb\u00bc\5\"\22\2\u00bc\u00bd\b\21"+
		"\1\2\u00bd!\3\2\2\2\u00be\u00bf\b\22\1\2\u00bf\u00c0\7\32\2\2\u00c0\u00c1"+
		"\b\22\1\2\u00c1\u00ce\3\2\2\2\u00c2\u00c3\f\4\2\2\u00c3\u00c4\7\b\2\2"+
		"\u00c4\u00c5\5\26\f\2\u00c5\u00c6\7\t\2\2\u00c6\u00c7\b\22\1\2\u00c7\u00cd"+
		"\3\2\2\2\u00c8\u00c9\f\3\2\2\u00c9\u00ca\7\30\2\2\u00ca\u00cb\7\32\2\2"+
		"\u00cb\u00cd\b\22\1\2\u00cc\u00c2\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd\u00d0"+
		"\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf#\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d2\7\32\2\2\u00d2\u00d3\7\6\2\2\u00d3\u00da\7"+
		"\35\2\2\u00d4\u00d5\7\31\2\2\u00d5\u00d6\7\32\2\2\u00d6\u00d7\7\6\2\2"+
		"\u00d7\u00d9\7\35\2\2\u00d8\u00d4\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00de\b\23\1\2\u00de%\3\2\2\2\21/\67FU^qx~\u0083\u0092\u00a2\u00b9\u00cc"+
		"\u00ce\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}