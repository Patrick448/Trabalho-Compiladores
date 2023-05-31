<<<<<<< HEAD
// Generated from ./parser/lang.g4 by ANTLR 4.8
=======
// Generated from parser/lang.g4 by ANTLR 4.8
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917

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
<<<<<<< HEAD
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, ID=33, INT=34, FLOAT=35, CHAR=36, TYPE=37, NEWLINE=38, LINE_COMMENT=39, 
		COMMENT=40, BLANK=41;
	public static final int
		RULE_prog = 0, RULE_dataList = 1, RULE_funcList = 2, RULE_data = 3, RULE_declList = 4, 
		RULE_decl = 5, RULE_func = 6, RULE_type = 7, RULE_cmd = 8, RULE_cmdList = 9, 
		RULE_exp = 10, RULE_rexp = 11, RULE_aexp = 12, RULE_mexp = 13, RULE_sexp = 14, 
		RULE_pexp = 15, RULE_lvalue = 16, RULE_params = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dataList", "funcList", "data", "declList", "decl", "func", "type", 
			"cmd", "cmdList", "exp", "rexp", "aexp", "mexp", "sexp", "pexp", "lvalue", 
			"params"
=======
		T__24=25, T__25=26, T__26=27, T__27=28, ID=29, INT=30, FLOAT=31, CHAR=32, 
		TYPE=33, NEWLINE=34, LINE_COMMENT=35, COMMENT=36, BLANK=37;
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
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'data'", "'{'", "'}'", "'::'", "';'", "'('", "')'", "':'", "'['", 
<<<<<<< HEAD
			"']'", "'Int'", "'Char'", "'Float'", "'Bool'", "'print'", "'='", "'if'", 
			"'else'", "'&'", "'<'", "'>'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'true'", "'false'", "'null'", "'.'", "','"
=======
			"']'", "'Int'", "'Char'", "'Float'", "'Bool'", "'print'", "'='", "'&'", 
			"'<'", "'>'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'true'", "'false'", 
			"'.'"
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
<<<<<<< HEAD
			null, null, null, null, null, null, null, null, null, "ID", "INT", "FLOAT", 
			"CHAR", "TYPE", "NEWLINE", "LINE_COMMENT", "COMMENT", "BLANK"
=======
			null, null, null, null, null, "ID", "INT", "FLOAT", "CHAR", "TYPE", "NEWLINE", 
			"LINE_COMMENT", "COMMENT", "BLANK"
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(36);
			((ProgContext)_localctx).d = dataList();
			setState(37);
=======
			setState(38);
			((ProgContext)_localctx).d = dataList();
			setState(39);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(45);
=======
			setState(47);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
<<<<<<< HEAD
				setState(40);
=======
				setState(42);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((DataListContext)_localctx).d = data();

				    if(_localctx.ast == null){((DataListContext)_localctx).ast =  new DataList(((DataListContext)_localctx).d.ast.getLine(), ((DataListContext)_localctx).d.ast.getCol(), ((DataListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DataListContext)_localctx).d.ast);}
				  
				}
				}
<<<<<<< HEAD
				setState(47);
=======
				setState(49);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(53);
=======
			setState(55);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
<<<<<<< HEAD
				setState(48);
=======
				setState(50);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((FuncListContext)_localctx).f = func();

				    if(_localctx.ast == null){((FuncListContext)_localctx).ast =  new FuncList(((FuncListContext)_localctx).f.ast.getLine(), ((FuncListContext)_localctx).f.ast.getCol(), ((FuncListContext)_localctx).f.ast); }
				    else{_localctx.ast.addNode(((FuncListContext)_localctx).f.ast);}
				  
				}
				}
<<<<<<< HEAD
				setState(55);
=======
				setState(57);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		public Token TYPE;
		public DeclListContext declList;
		public TerminalNode TYPE() { return getToken(langParser.TYPE, 0); }
=======
		public Token ID;
		public DeclListContext declList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(56);
			((DataContext)_localctx).kw = match(T__0);
			setState(57);
			((DataContext)_localctx).TYPE = match(TYPE);
			setState(58);
			match(T__1);
			setState(59);
			((DataContext)_localctx).declList = declList();
			setState(60);
			match(T__2);
			 ((DataContext)_localctx).ast =  new Data((((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getLine():0), (((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getCharPositionInLine():0), new Type((((DataContext)_localctx).TYPE!=null?((DataContext)_localctx).TYPE.getLine():0), (((DataContext)_localctx).TYPE!=null?((DataContext)_localctx).TYPE.getCharPositionInLine():0), (((DataContext)_localctx).TYPE!=null?((DataContext)_localctx).TYPE.getText():null)), ((DataContext)_localctx).declList.ast);
=======
			setState(58);
			((DataContext)_localctx).kw = match(T__0);
			setState(59);
			((DataContext)_localctx).ID = match(ID);
			setState(60);
			match(T__1);
			setState(61);
			((DataContext)_localctx).declList = declList();
			setState(62);
			match(T__2);
			 ((DataContext)_localctx).ast =  new Data((((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getLine():0), (((DataContext)_localctx).kw!=null?((DataContext)_localctx).kw.getCharPositionInLine():0), new ID((((DataContext)_localctx).ID!=null?((DataContext)_localctx).ID.getLine():0), (((DataContext)_localctx).ID!=null?((DataContext)_localctx).ID.getCharPositionInLine():0), (((DataContext)_localctx).ID!=null?((DataContext)_localctx).ID.getText():null)), ((DataContext)_localctx).declList.ast);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(68);
=======
			setState(70);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
<<<<<<< HEAD
				setState(63);
=======
				setState(65);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((DeclListContext)_localctx).d = decl();

				    if(_localctx.ast == null){((DeclListContext)_localctx).ast =  new DeclList(((DeclListContext)_localctx).d.ast.getLine(), ((DeclListContext)_localctx).d.ast.getCol(), ((DeclListContext)_localctx).d.ast); }
				    else{_localctx.ast.addNode(((DeclListContext)_localctx).d.ast);}
				  
				}
				}
<<<<<<< HEAD
				setState(70);
=======
				setState(72);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(71);
			((DeclContext)_localctx).ID = match(ID);
			setState(72);
			match(T__3);
			setState(73);
			((DeclContext)_localctx).type = type(0);
			setState(74);
=======
			setState(73);
			((DeclContext)_localctx).ID = match(ID);
			setState(74);
			match(T__3);
			setState(75);
			((DeclContext)_localctx).type = type(0);
			setState(76);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		public CmdListContext cmdList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
=======
		public ParamsContext params;
		public CmdListContext cmdList;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
			setState(77);
			((FuncContext)_localctx).ID = match(ID);
			setState(78);
			match(T__5);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(79);
				params();
				}
			}

=======
			setState(79);
			((FuncContext)_localctx).ID = match(ID);
			setState(80);
			match(T__5);
			setState(81);
			((FuncContext)_localctx).params = params();
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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

<<<<<<< HEAD
			    ((FuncContext)_localctx).ast =  new Func((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), new ID((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getCharPositionInLine():0), (((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null)), null, null, ((FuncContext)_localctx).cmdList.ast);
=======
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
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		public Node ast;
=======
		public Type ast;
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
=======
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< HEAD
			setState(98);
=======
			setState(111);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
<<<<<<< HEAD
				setState(93);
=======
				setState(106);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((TypeContext)_localctx).t = match(T__10);
				}
				break;
			case T__11:
				{
<<<<<<< HEAD
				setState(94);
=======
				setState(107);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((TypeContext)_localctx).t = match(T__11);
				}
				break;
			case T__12:
				{
<<<<<<< HEAD
				setState(95);
=======
				setState(108);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((TypeContext)_localctx).t = match(T__12);
				}
				break;
			case T__13:
				{
<<<<<<< HEAD
				setState(96);
=======
				setState(109);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((TypeContext)_localctx).t = match(T__13);
				}
				break;
			case ID:
				{
<<<<<<< HEAD
				setState(97);
=======
				setState(110);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((TypeContext)_localctx).t = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((TypeContext)_localctx).ast =  new Type((((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getCharPositionInLine():0), (((TypeContext)_localctx).t!=null?((TypeContext)_localctx).t.getText():null));
			}
			_ctx.stop = _input.LT(-1);
<<<<<<< HEAD
			setState(107);
=======
			setState(120);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
					setState(102);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(103);
					match(T__8);
					setState(104);
=======
					setState(115);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(116);
					match(T__8);
					setState(117);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
					match(T__9);
					}
					} 
				}
<<<<<<< HEAD
				setState(109);
=======
				setState(122);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		public Token f;
		public CmdContext cmd;
		public CmdContext c1;
		public CmdContext c2;
=======
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CmdListContext cmdList() {
			return getRuleContext(CmdListContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
<<<<<<< HEAD
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
=======
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		enterRule(_localctx, 16, RULE_cmd);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(T__14);
				setState(111);
				((CmdContext)_localctx).exp = exp(0);
				setState(112);
=======
		enterRule(_localctx, 20, RULE_cmd);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(T__14);
				setState(124);
				((CmdContext)_localctx).exp = exp(0);
				setState(125);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				match(T__4);
				((CmdContext)_localctx).ast =  new Print(((CmdContext)_localctx).exp.ast.getLine(), ((CmdContext)_localctx).exp.ast.getCol(), ((CmdContext)_localctx).exp.ast);
				}
				break;
<<<<<<< HEAD
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(T__1);
				setState(116);
				((CmdContext)_localctx).cmdList = cmdList();
				setState(117);
=======
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__1);
				setState(129);
				((CmdContext)_localctx).cmdList = cmdList();
				setState(130);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				match(T__2);
				 ((CmdContext)_localctx).ast =  ((CmdContext)_localctx).cmdList.ast;
				}
				break;
<<<<<<< HEAD
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				((CmdContext)_localctx).lvalue = lvalue(0);
				setState(121);
				match(T__15);
				setState(122);
				((CmdContext)_localctx).exp = exp(0);
				setState(123);
				match(T__4);
				((CmdContext)_localctx).ast =  new Attr(((CmdContext)_localctx).lvalue.ast.getLine(), ((CmdContext)_localctx).lvalue.ast.getCol(), ((CmdContext)_localctx).lvalue.ast, ((CmdContext)_localctx).exp.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				((CmdContext)_localctx).f = match(T__16);
				setState(127);
				match(T__5);
				setState(128);
				((CmdContext)_localctx).exp = exp(0);
				setState(129);
				match(T__6);
				setState(130);
				((CmdContext)_localctx).cmd = cmd();
				((CmdContext)_localctx).ast =  new If((((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getLine():0), (((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getCharPositionInLine():0), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).cmd.ast, null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				((CmdContext)_localctx).f = match(T__16);
				setState(134);
				match(T__5);
				setState(135);
				((CmdContext)_localctx).exp = exp(0);
				setState(136);
				match(T__6);
				setState(137);
				((CmdContext)_localctx).c1 = cmd();
				setState(138);
				match(T__17);
				setState(139);
				((CmdContext)_localctx).c2 = cmd();
				((CmdContext)_localctx).ast =  new If((((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getLine():0), (((CmdContext)_localctx).f!=null?((CmdContext)_localctx).f.getCharPositionInLine():0), ((CmdContext)_localctx).exp.ast, ((CmdContext)_localctx).c1.ast, ((CmdContext)_localctx).c2.ast);
				}
				break;
=======
			case ID:
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
			default:
				throw new NoViableAltException(this);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		enterRule(_localctx, 18, RULE_cmdList);
=======
		enterRule(_localctx, 22, RULE_cmdList);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << T__16) | (1L << ID))) != 0)) {
				{
				{
				setState(144);
=======
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__14) | (1L << ID))) != 0)) {
				{
				{
				setState(141);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((CmdListContext)_localctx).c = cmd();

				    
				    if(_localctx.ast == null){((CmdListContext)_localctx).ast =  new CmdList(((CmdListContext)_localctx).c.ast.getLine(), ((CmdListContext)_localctx).c.ast.getCol(), ((CmdListContext)_localctx).c.ast); }
				    else{_localctx.ast.addNode(((CmdListContext)_localctx).c.ast);}
				  
				}
				}
<<<<<<< HEAD
				setState(151);
=======
				setState(148);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_exp, _p);
=======
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_exp, _p);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(163);
=======
			setState(160);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
<<<<<<< HEAD
				setState(153);
=======
				setState(150);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((ExpContext)_localctx).INT = match(INT);
				((ExpContext)_localctx).ast =  new Int((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getLine():0), (((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)));
				}
				break;
			case 2:
				{
<<<<<<< HEAD
				setState(155);
=======
				setState(152);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((ExpContext)_localctx).CHAR = match(CHAR);
				((ExpContext)_localctx).ast =  new Char((((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getLine():0), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getCharPositionInLine():0), (((ExpContext)_localctx).CHAR!=null?((ExpContext)_localctx).CHAR.getText():null));
				}
				break;
			case 3:
				{
<<<<<<< HEAD
				setState(157);
=======
				setState(154);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((ExpContext)_localctx).lvalue = lvalue(0);
				((ExpContext)_localctx).ast =  ((ExpContext)_localctx).lvalue.ast;
				}
				break;
			case 4:
				{
<<<<<<< HEAD
				setState(160);
=======
				setState(157);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((ExpContext)_localctx).rexp = rexp(0);
				((ExpContext)_localctx).ast = ((ExpContext)_localctx).rexp.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
<<<<<<< HEAD
			setState(173);
=======
			setState(170);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
					setState(165);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(166);
					match(T__18);
					setState(167);
					match(T__18);
					setState(168);
=======
					setState(162);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(163);
					match(T__16);
					setState(164);
					match(T__16);
					setState(165);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
					((ExpContext)_localctx).a2 = exp(6);
					((ExpContext)_localctx).ast =  new And(((ExpContext)_localctx).a1.ast.getLine(), ((ExpContext)_localctx).a1.ast.getCol(), ((ExpContext)_localctx).a1.ast, ((ExpContext)_localctx).a2.ast);
					}
					} 
				}
<<<<<<< HEAD
				setState(175);
=======
				setState(172);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_rexp, _p);
=======
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_rexp, _p);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(190);
=======
			setState(187);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
<<<<<<< HEAD
				setState(177);
				((RexpContext)_localctx).ll = ((RexpContext)_localctx).aexp = aexp(0);
				setState(178);
				((RexpContext)_localctx).o = match(T__19);
				setState(179);
=======
				setState(174);
				((RexpContext)_localctx).ll = ((RexpContext)_localctx).aexp = aexp(0);
				setState(175);
				((RexpContext)_localctx).o = match(T__17);
				setState(176);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((RexpContext)_localctx).rl = ((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast =  new LessThan((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).ll.ast, ((RexpContext)_localctx).rl.ast);
				}
				break;
			case 2:
				{
<<<<<<< HEAD
				setState(182);
				((RexpContext)_localctx).lg = ((RexpContext)_localctx).aexp = aexp(0);
				setState(183);
				((RexpContext)_localctx).o = match(T__20);
				setState(184);
=======
				setState(179);
				((RexpContext)_localctx).lg = ((RexpContext)_localctx).aexp = aexp(0);
				setState(180);
				((RexpContext)_localctx).o = match(T__18);
				setState(181);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((RexpContext)_localctx).rg = ((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast =  new GreaterThan((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).lg.ast, ((RexpContext)_localctx).rg.ast);
				}
				break;
			case 3:
				{
<<<<<<< HEAD
				setState(187);
=======
				setState(184);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((RexpContext)_localctx).aexp = aexp(0);
				((RexpContext)_localctx).ast = ((RexpContext)_localctx).aexp.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
<<<<<<< HEAD
			setState(206);
=======
			setState(203);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
<<<<<<< HEAD
					setState(204);
=======
					setState(201);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new RexpContext(_parentctx, _parentState);
						_localctx.le = _prevctx;
						_localctx.le = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
<<<<<<< HEAD
						setState(192);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(193);
						((RexpContext)_localctx).o = match(T__15);
						setState(194);
						match(T__15);
						setState(195);
=======
						setState(189);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(190);
						((RexpContext)_localctx).o = match(T__15);
						setState(191);
						match(T__15);
						setState(192);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
						setState(198);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(199);
						((RexpContext)_localctx).o = match(T__21);
						setState(200);
						match(T__15);
						setState(201);
=======
						setState(195);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(196);
						((RexpContext)_localctx).o = match(T__19);
						setState(197);
						match(T__15);
						setState(198);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
						((RexpContext)_localctx).rd = ((RexpContext)_localctx).aexp = aexp(0);
						((RexpContext)_localctx).ast =  new Diff((((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getLine():0), (((RexpContext)_localctx).o!=null?((RexpContext)_localctx).o.getCharPositionInLine():0), ((RexpContext)_localctx).ld.ast, ((RexpContext)_localctx).rd.ast);
						}
						break;
					}
					} 
				}
<<<<<<< HEAD
				setState(208);
=======
				setState(205);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_aexp, _p);
=======
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_aexp, _p);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< HEAD
			setState(210);
=======
			setState(207);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			((AexpContext)_localctx).mexp = mexp();
			((AexpContext)_localctx).ast = ((AexpContext)_localctx).mexp.ast;
			}
			_ctx.stop = _input.LT(-1);
<<<<<<< HEAD
			setState(240);
=======
			setState(237);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
<<<<<<< HEAD
					setState(238);
=======
					setState(235);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						_localctx.a1 = _prevctx;
						_localctx.a1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
<<<<<<< HEAD
						setState(213);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(214);
						match(T__22);
						setState(215);
=======
						setState(210);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(211);
						match(T__20);
						setState(212);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
						setState(218);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(219);
						match(T__23);
						setState(220);
=======
						setState(215);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(216);
						match(T__21);
						setState(217);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
						setState(223);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(224);
						match(T__24);
						setState(225);
=======
						setState(220);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(221);
						match(T__22);
						setState(222);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
						setState(228);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						match(T__25);
						setState(230);
=======
						setState(225);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(226);
						match(T__23);
						setState(227);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
						setState(233);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(234);
						match(T__26);
						setState(235);
=======
						setState(230);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(231);
						match(T__24);
						setState(232);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
						((AexpContext)_localctx).a2 = aexp(3);
						((AexpContext)_localctx).ast =  new Rest(((AexpContext)_localctx).a1.ast.getLine(), ((AexpContext)_localctx).a1.ast.getCol(), ((AexpContext)_localctx).a1.ast, ((AexpContext)_localctx).a2.ast);
						}
						break;
					}
					} 
				}
<<<<<<< HEAD
				setState(242);
=======
				setState(239);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		enterRule(_localctx, 26, RULE_mexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
=======
		enterRule(_localctx, 30, RULE_mexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		enterRule(_localctx, 28, RULE_sexp);
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				((SexpContext)_localctx).n = match(T__21);
				setState(247);
=======
		enterRule(_localctx, 32, RULE_sexp);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				((SexpContext)_localctx).n = match(T__19);
				setState(244);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((SexpContext)_localctx).sexp = sexp();
				((SexpContext)_localctx).ast =  new Neg((((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getLine():0), (((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getCharPositionInLine():0), ((SexpContext)_localctx).sexp.ast);
				}
				break;
<<<<<<< HEAD
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				((SexpContext)_localctx).su = match(T__23);
				setState(251);
=======
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				((SexpContext)_localctx).su = match(T__21);
				setState(248);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((SexpContext)_localctx).sexp = sexp();
				((SexpContext)_localctx).ast =  new SubUni((((SexpContext)_localctx).su!=null?((SexpContext)_localctx).su.getLine():0), (((SexpContext)_localctx).su!=null?((SexpContext)_localctx).su.getCharPositionInLine():0), ((SexpContext)_localctx).sexp.ast);
				}
				break;
<<<<<<< HEAD
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__27:
					{
					setState(254);
					((SexpContext)_localctx).b = match(T__27);
					}
					break;
				case T__28:
					{
					setState(255);
					((SexpContext)_localctx).b = match(T__28);
=======
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
					{
					setState(251);
					((SexpContext)_localctx).b = match(T__25);
					}
					break;
				case T__26:
					{
					setState(252);
					((SexpContext)_localctx).b = match(T__26);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				((SexpContext)_localctx).ast =  new Bool((((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getLine():0), (((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getCharPositionInLine():0), Boolean.parseBoolean((((SexpContext)_localctx).b!=null?((SexpContext)_localctx).b.getText():null)));
				}
				break;
<<<<<<< HEAD
			case T__29:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				((SexpContext)_localctx).n = match(T__29);
				((SexpContext)_localctx).ast =  new Null((((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getLine():0), (((SexpContext)_localctx).n!=null?((SexpContext)_localctx).n.getCharPositionInLine():0));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(261);
=======
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((SexpContext)_localctx).INT = match(INT);
				((SexpContext)_localctx).ast =  new Int((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getLine():0), (((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((SexpContext)_localctx).INT!=null?((SexpContext)_localctx).INT.getText():null)));
				}
				break;
			case FLOAT:
<<<<<<< HEAD
				enterOuterAlt(_localctx, 6);
				{
				setState(263);
=======
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((SexpContext)_localctx).FLOAT = match(FLOAT);
				((SexpContext)_localctx).ast =  new FloatAst((((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getLine():0), (((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getCharPositionInLine():0), Float.parseFloat((((SexpContext)_localctx).FLOAT!=null?((SexpContext)_localctx).FLOAT.getText():null)));
				}
				break;
			case CHAR:
<<<<<<< HEAD
				enterOuterAlt(_localctx, 7);
				{
				setState(265);
=======
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
				((SexpContext)_localctx).CHAR = match(CHAR);
				((SexpContext)_localctx).ast =  new Char((((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getLine():0), (((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getCharPositionInLine():0), (((SexpContext)_localctx).CHAR!=null?((SexpContext)_localctx).CHAR.getText():null));
				}
				break;
<<<<<<< HEAD
			case T__5:
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(267);
=======
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(262);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		public ExpContext exp;
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
=======
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		enterRule(_localctx, 30, RULE_pexp);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				((PexpContext)_localctx).lvalue = lvalue(0);
				((PexpContext)_localctx).ast = ((PexpContext)_localctx).lvalue.ast;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(T__5);
				setState(276);
				((PexpContext)_localctx).exp = exp(0);
				setState(277);
				match(T__6);
				((PexpContext)_localctx).ast = ((PexpContext)_localctx).exp.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
=======
		enterRule(_localctx, 34, RULE_pexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			((PexpContext)_localctx).lvalue = lvalue(0);
			((PexpContext)_localctx).ast = ((PexpContext)_localctx).lvalue.ast;
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lvalue, _p);
=======
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_lvalue, _p);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< HEAD
			setState(283);
=======
			setState(271);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			((LvalueContext)_localctx).ID = match(ID);
			((LvalueContext)_localctx).ast =  new LValue((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), new ID((((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getCharPositionInLine():0), (((LvalueContext)_localctx).ID!=null?((LvalueContext)_localctx).ID.getText():null)));
			}
			_ctx.stop = _input.LT(-1);
<<<<<<< HEAD
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
=======
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
<<<<<<< HEAD
					setState(296);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
=======
					setState(284);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
<<<<<<< HEAD
						setState(286);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(287);
						match(T__8);
						setState(288);
						exp(0);
						setState(289);
=======
						setState(274);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(275);
						match(T__8);
						setState(276);
						exp(0);
						setState(277);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
						match(T__9);

						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
<<<<<<< HEAD
						setState(292);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(293);
						match(T__30);
						setState(294);
=======
						setState(280);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(281);
						match(T__27);
						setState(282);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
						((LvalueContext)_localctx).ID = match(ID);

						}
						break;
					}
					} 
				}
<<<<<<< HEAD
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
=======
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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

<<<<<<< HEAD
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
			setState(301);
			match(ID);
			setState(302);
			match(T__3);
			setState(303);
			match(TYPE);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31) {
				{
				{
				setState(304);
				match(T__31);
				setState(305);
				match(ID);
				setState(306);
				match(T__3);
				setState(307);
				match(TYPE);
				}
				}
				setState(312);
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
		case 7:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 10:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 11:
			return rexp_sempred((RexpContext)_localctx, predIndex);
		case 12:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 16:
=======
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
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
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
<<<<<<< HEAD
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u013e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3"+
		"\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\7\6E\n\6\f\6\16\6H\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bS\n"+
		"\b\3\b\3\b\3\b\5\bX\n\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\te\n\t\3\t\3\t\3\t\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0091\n\n\3\13\3\13\3\13"+
		"\7\13\u0096\n\13\f\13\16\13\u0099\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00a6\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ae\n\f\f\f"+
		"\16\f\u00b1\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00c1\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00cf"+
		"\n\r\f\r\16\r\u00d2\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00f1\n\16\f\16\16\16\u00f4\13\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0103\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u0111\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u011b\n"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u012b\n\22\f\22\16\22\u012e\13\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\7\23\u0137\n\23\f\23\16\23\u013a\13\23\3\23\3\23\3\23\2\7\20"+
		"\26\30\32\"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\2\u0153"+
		"\2&\3\2\2\2\4/\3\2\2\2\6\67\3\2\2\2\b:\3\2\2\2\nF\3\2\2\2\fI\3\2\2\2\16"+
		"O\3\2\2\2\20^\3\2\2\2\22\u0090\3\2\2\2\24\u0097\3\2\2\2\26\u00a5\3\2\2"+
		"\2\30\u00c0\3\2\2\2\32\u00d3\3\2\2\2\34\u00f5\3\2\2\2\36\u0110\3\2\2\2"+
		" \u011a\3\2\2\2\"\u011c\3\2\2\2$\u012f\3\2\2\2&\'\5\4\3\2\'(\5\6\4\2("+
		")\b\2\1\2)\3\3\2\2\2*+\5\b\5\2+,\b\3\1\2,.\3\2\2\2-*\3\2\2\2.\61\3\2\2"+
		"\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\5\16\b\2\63\64"+
		"\b\4\1\2\64\66\3\2\2\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2"+
		"\2\28\7\3\2\2\29\67\3\2\2\2:;\7\3\2\2;<\7\'\2\2<=\7\4\2\2=>\5\n\6\2>?"+
		"\7\5\2\2?@\b\5\1\2@\t\3\2\2\2AB\5\f\7\2BC\b\6\1\2CE\3\2\2\2DA\3\2\2\2"+
		"EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\13\3\2\2\2HF\3\2\2\2IJ\7#\2\2JK\7\6\2"+
		"\2KL\5\20\t\2LM\7\7\2\2MN\b\7\1\2N\r\3\2\2\2OP\7#\2\2PR\7\b\2\2QS\5$\23"+
		"\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TW\7\t\2\2UV\7\n\2\2VX\5\20\t\2WU\3\2"+
		"\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\4\2\2Z[\5\24\13\2[\\\7\5\2\2\\]\b\b\1\2]"+
		"\17\3\2\2\2^d\b\t\1\2_e\7\r\2\2`e\7\16\2\2ae\7\17\2\2be\7\20\2\2ce\7#"+
		"\2\2d_\3\2\2\2d`\3\2\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2ef\3\2\2\2fg\b\t"+
		"\1\2gm\3\2\2\2hi\f\4\2\2ij\7\13\2\2jl\7\f\2\2kh\3\2\2\2lo\3\2\2\2mk\3"+
		"\2\2\2mn\3\2\2\2n\21\3\2\2\2om\3\2\2\2pq\7\21\2\2qr\5\26\f\2rs\7\7\2\2"+
		"st\b\n\1\2t\u0091\3\2\2\2uv\7\4\2\2vw\5\24\13\2wx\7\5\2\2xy\b\n\1\2y\u0091"+
		"\3\2\2\2z{\5\"\22\2{|\7\22\2\2|}\5\26\f\2}~\7\7\2\2~\177\b\n\1\2\177\u0091"+
		"\3\2\2\2\u0080\u0081\7\23\2\2\u0081\u0082\7\b\2\2\u0082\u0083\5\26\f\2"+
		"\u0083\u0084\7\t\2\2\u0084\u0085\5\22\n\2\u0085\u0086\b\n\1\2\u0086\u0091"+
		"\3\2\2\2\u0087\u0088\7\23\2\2\u0088\u0089\7\b\2\2\u0089\u008a\5\26\f\2"+
		"\u008a\u008b\7\t\2\2\u008b\u008c\5\22\n\2\u008c\u008d\7\24\2\2\u008d\u008e"+
		"\5\22\n\2\u008e\u008f\b\n\1\2\u008f\u0091\3\2\2\2\u0090p\3\2\2\2\u0090"+
		"u\3\2\2\2\u0090z\3\2\2\2\u0090\u0080\3\2\2\2\u0090\u0087\3\2\2\2\u0091"+
		"\23\3\2\2\2\u0092\u0093\5\22\n\2\u0093\u0094\b\13\1\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\25\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\b\f\1"+
		"\2\u009b\u009c\7$\2\2\u009c\u00a6\b\f\1\2\u009d\u009e\7&\2\2\u009e\u00a6"+
		"\b\f\1\2\u009f\u00a0\5\"\22\2\u00a0\u00a1\b\f\1\2\u00a1\u00a6\3\2\2\2"+
		"\u00a2\u00a3\5\30\r\2\u00a3\u00a4\b\f\1\2\u00a4\u00a6\3\2\2\2\u00a5\u009a"+
		"\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a6"+
		"\u00af\3\2\2\2\u00a7\u00a8\f\7\2\2\u00a8\u00a9\7\25\2\2\u00a9\u00aa\7"+
		"\25\2\2\u00aa\u00ab\5\26\f\b\u00ab\u00ac\b\f\1\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00a7\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\27\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\b\r\1\2\u00b3\u00b4"+
		"\5\32\16\2\u00b4\u00b5\7\26\2\2\u00b5\u00b6\5\32\16\2\u00b6\u00b7\b\r"+
		"\1\2\u00b7\u00c1\3\2\2\2\u00b8\u00b9\5\32\16\2\u00b9\u00ba\7\27\2\2\u00ba"+
		"\u00bb\5\32\16\2\u00bb\u00bc\b\r\1\2\u00bc\u00c1\3\2\2\2\u00bd\u00be\5"+
		"\32\16\2\u00be\u00bf\b\r\1\2\u00bf\u00c1\3\2\2\2\u00c0\u00b2\3\2\2\2\u00c0"+
		"\u00b8\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00d0\3\2\2\2\u00c2\u00c3\f\5"+
		"\2\2\u00c3\u00c4\7\22\2\2\u00c4\u00c5\7\22\2\2\u00c5\u00c6\5\32\16\2\u00c6"+
		"\u00c7\b\r\1\2\u00c7\u00cf\3\2\2\2\u00c8\u00c9\f\4\2\2\u00c9\u00ca\7\30"+
		"\2\2\u00ca\u00cb\7\22\2\2\u00cb\u00cc\5\32\16\2\u00cc\u00cd\b\r\1\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00c8\3\2\2\2\u00cf\u00d2\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\31\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d3\u00d4\b\16\1\2\u00d4\u00d5\5\34\17\2\u00d5\u00d6\b\16\1"+
		"\2\u00d6\u00f2\3\2\2\2\u00d7\u00d8\f\b\2\2\u00d8\u00d9\7\31\2\2\u00d9"+
		"\u00da\5\32\16\t\u00da\u00db\b\16\1\2\u00db\u00f1\3\2\2\2\u00dc\u00dd"+
		"\f\7\2\2\u00dd\u00de\7\32\2\2\u00de\u00df\5\32\16\b\u00df\u00e0\b\16\1"+
		"\2\u00e0\u00f1\3\2\2\2\u00e1\u00e2\f\6\2\2\u00e2\u00e3\7\33\2\2\u00e3"+
		"\u00e4\5\32\16\7\u00e4\u00e5\b\16\1\2\u00e5\u00f1\3\2\2\2\u00e6\u00e7"+
		"\f\5\2\2\u00e7\u00e8\7\34\2\2\u00e8\u00e9\5\32\16\6\u00e9\u00ea\b\16\1"+
		"\2\u00ea\u00f1\3\2\2\2\u00eb\u00ec\f\4\2\2\u00ec\u00ed\7\35\2\2\u00ed"+
		"\u00ee\5\32\16\5\u00ee\u00ef\b\16\1\2\u00ef\u00f1\3\2\2\2\u00f0\u00d7"+
		"\3\2\2\2\u00f0\u00dc\3\2\2\2\u00f0\u00e1\3\2\2\2\u00f0\u00e6\3\2\2\2\u00f0"+
		"\u00eb\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\33\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\5\36\20\2\u00f6"+
		"\u00f7\b\17\1\2\u00f7\35\3\2\2\2\u00f8\u00f9\7\30\2\2\u00f9\u00fa\5\36"+
		"\20\2\u00fa\u00fb\b\20\1\2\u00fb\u0111\3\2\2\2\u00fc\u00fd\7\32\2\2\u00fd"+
		"\u00fe\5\36\20\2\u00fe\u00ff\b\20\1\2\u00ff\u0111\3\2\2\2\u0100\u0103"+
		"\7\36\2\2\u0101\u0103\7\37\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2"+
		"\u0103\u0104\3\2\2\2\u0104\u0111\b\20\1\2\u0105\u0106\7 \2\2\u0106\u0111"+
		"\b\20\1\2\u0107\u0108\7$\2\2\u0108\u0111\b\20\1\2\u0109\u010a\7%\2\2\u010a"+
		"\u0111\b\20\1\2\u010b\u010c\7&\2\2\u010c\u0111\b\20\1\2\u010d\u010e\5"+
		" \21\2\u010e\u010f\b\20\1\2\u010f\u0111\3\2\2\2\u0110\u00f8\3\2\2\2\u0110"+
		"\u00fc\3\2\2\2\u0110\u0102\3\2\2\2\u0110\u0105\3\2\2\2\u0110\u0107\3\2"+
		"\2\2\u0110\u0109\3\2\2\2\u0110\u010b\3\2\2\2\u0110\u010d\3\2\2\2\u0111"+
		"\37\3\2\2\2\u0112\u0113\5\"\22\2\u0113\u0114\b\21\1\2\u0114\u011b\3\2"+
		"\2\2\u0115\u0116\7\b\2\2\u0116\u0117\5\26\f\2\u0117\u0118\7\t\2\2\u0118"+
		"\u0119\b\21\1\2\u0119\u011b\3\2\2\2\u011a\u0112\3\2\2\2\u011a\u0115\3"+
		"\2\2\2\u011b!\3\2\2\2\u011c\u011d\b\22\1\2\u011d\u011e\7#\2\2\u011e\u011f"+
		"\b\22\1\2\u011f\u012c\3\2\2\2\u0120\u0121\f\4\2\2\u0121\u0122\7\13\2\2"+
		"\u0122\u0123\5\26\f\2\u0123\u0124\7\f\2\2\u0124\u0125\b\22\1\2\u0125\u012b"+
		"\3\2\2\2\u0126\u0127\f\3\2\2\u0127\u0128\7!\2\2\u0128\u0129\7#\2\2\u0129"+
		"\u012b\b\22\1\2\u012a\u0120\3\2\2\2\u012a\u0126\3\2\2\2\u012b\u012e\3"+
		"\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d#\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012f\u0130\7#\2\2\u0130\u0131\7\6\2\2\u0131\u0138\7\'\2\2\u0132"+
		"\u0133\7\"\2\2\u0133\u0134\7#\2\2\u0134\u0135\7\6\2\2\u0135\u0137\7\'"+
		"\2\2\u0136\u0132\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\b\23"+
		"\1\2\u013c%\3\2\2\2\30/\67FRWdm\u0090\u0097\u00a5\u00af\u00c0\u00ce\u00d0"+
		"\u00f0\u00f2\u0102\u0110\u011a\u012a\u012c\u0138";
=======
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0124\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\bX\n\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tb\n\t\f\t\16"+
		"\te\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13r\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13y\n\13\f\13\16\13|\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\r\3\r"+
		"\3\r\7\r\u0093\n\r\f\r\16\r\u0096\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u00a3\n\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u00ab\n\16\f\16\16\16\u00ae\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00be\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00cc\n\17\f\17\16"+
		"\17\u00cf\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00ee\n\20\f\20\16\20\u00f1\13\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0100\n\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u010c\n\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u011f\n\24\f\24\16\24\u0122\13\24\3\24\2\7\24\32\34\36"+
		"&\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\2\2\u0133\2(\3\2\2"+
		"\2\4\61\3\2\2\2\69\3\2\2\2\b<\3\2\2\2\nH\3\2\2\2\fK\3\2\2\2\16Q\3\2\2"+
		"\2\20c\3\2\2\2\22f\3\2\2\2\24k\3\2\2\2\26\u008d\3\2\2\2\30\u0094\3\2\2"+
		"\2\32\u00a2\3\2\2\2\34\u00bd\3\2\2\2\36\u00d0\3\2\2\2 \u00f2\3\2\2\2\""+
		"\u010b\3\2\2\2$\u010d\3\2\2\2&\u0110\3\2\2\2()\5\4\3\2)*\5\6\4\2*+\b\2"+
		"\1\2+\3\3\2\2\2,-\5\b\5\2-.\b\3\1\2.\60\3\2\2\2/,\3\2\2\2\60\63\3\2\2"+
		"\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\61\3\2\2\2\64\65\5\16\b\2"+
		"\65\66\b\4\1\2\668\3\2\2\2\67\64\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2"+
		"\2:\7\3\2\2\2;9\3\2\2\2<=\7\3\2\2=>\7\37\2\2>?\7\4\2\2?@\5\n\6\2@A\7\5"+
		"\2\2AB\b\5\1\2B\t\3\2\2\2CD\5\f\7\2DE\b\6\1\2EG\3\2\2\2FC\3\2\2\2GJ\3"+
		"\2\2\2HF\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JH\3\2\2\2KL\7\37\2\2LM\7\6\2\2"+
		"MN\5\24\13\2NO\7\7\2\2OP\b\7\1\2P\r\3\2\2\2QR\7\37\2\2RS\7\b\2\2ST\5\20"+
		"\t\2TW\7\t\2\2UV\7\n\2\2VX\5\24\13\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7"+
		"\4\2\2Z[\5\30\r\2[\\\7\5\2\2\\]\b\b\1\2]\17\3\2\2\2^_\5\22\n\2_`\b\t\1"+
		"\2`b\3\2\2\2a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\21\3\2\2\2ec\3\2"+
		"\2\2fg\7\37\2\2gh\7\6\2\2hi\5\24\13\2ij\b\n\1\2j\23\3\2\2\2kq\b\13\1\2"+
		"lr\7\r\2\2mr\7\16\2\2nr\7\17\2\2or\7\20\2\2pr\7\37\2\2ql\3\2\2\2qm\3\2"+
		"\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2rs\3\2\2\2st\b\13\1\2tz\3\2\2\2uv\f"+
		"\4\2\2vw\7\13\2\2wy\7\f\2\2xu\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\25"+
		"\3\2\2\2|z\3\2\2\2}~\7\21\2\2~\177\5\32\16\2\177\u0080\7\7\2\2\u0080\u0081"+
		"\b\f\1\2\u0081\u008e\3\2\2\2\u0082\u0083\7\4\2\2\u0083\u0084\5\30\r\2"+
		"\u0084\u0085\7\5\2\2\u0085\u0086\b\f\1\2\u0086\u008e\3\2\2\2\u0087\u0088"+
		"\5&\24\2\u0088\u0089\7\22\2\2\u0089\u008a\5\32\16\2\u008a\u008b\7\7\2"+
		"\2\u008b\u008c\b\f\1\2\u008c\u008e\3\2\2\2\u008d}\3\2\2\2\u008d\u0082"+
		"\3\2\2\2\u008d\u0087\3\2\2\2\u008e\27\3\2\2\2\u008f\u0090\5\26\f\2\u0090"+
		"\u0091\b\r\1\2\u0091\u0093\3\2\2\2\u0092\u008f\3\2\2\2\u0093\u0096\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\31\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u0098\b\16\1\2\u0098\u0099\7 \2\2\u0099\u00a3\b\16\1\2"+
		"\u009a\u009b\7\"\2\2\u009b\u00a3\b\16\1\2\u009c\u009d\5&\24\2\u009d\u009e"+
		"\b\16\1\2\u009e\u00a3\3\2\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\b\16\1"+
		"\2\u00a1\u00a3\3\2\2\2\u00a2\u0097\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u009c"+
		"\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3\u00ac\3\2\2\2\u00a4\u00a5\f\7\2\2\u00a5"+
		"\u00a6\7\23\2\2\u00a6\u00a7\7\23\2\2\u00a7\u00a8\5\32\16\b\u00a8\u00a9"+
		"\b\16\1\2\u00a9\u00ab\3\2\2\2\u00aa\u00a4\3\2\2\2\u00ab\u00ae\3\2\2\2"+
		"\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b0\b\17\1\2\u00b0\u00b1\5\36\20\2\u00b1\u00b2\7\24\2"+
		"\2\u00b2\u00b3\5\36\20\2\u00b3\u00b4\b\17\1\2\u00b4\u00be\3\2\2\2\u00b5"+
		"\u00b6\5\36\20\2\u00b6\u00b7\7\25\2\2\u00b7\u00b8\5\36\20\2\u00b8\u00b9"+
		"\b\17\1\2\u00b9\u00be\3\2\2\2\u00ba\u00bb\5\36\20\2\u00bb\u00bc\b\17\1"+
		"\2\u00bc\u00be\3\2\2\2\u00bd\u00af\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00ba"+
		"\3\2\2\2\u00be\u00cd\3\2\2\2\u00bf\u00c0\f\5\2\2\u00c0\u00c1\7\22\2\2"+
		"\u00c1\u00c2\7\22\2\2\u00c2\u00c3\5\36\20\2\u00c3\u00c4\b\17\1\2\u00c4"+
		"\u00cc\3\2\2\2\u00c5\u00c6\f\4\2\2\u00c6\u00c7\7\26\2\2\u00c7\u00c8\7"+
		"\22\2\2\u00c8\u00c9\5\36\20\2\u00c9\u00ca\b\17\1\2\u00ca\u00cc\3\2\2\2"+
		"\u00cb\u00bf\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\35\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d1\b\20\1\2\u00d1\u00d2\5 \21\2\u00d2\u00d3\b\20\1\2\u00d3\u00ef\3"+
		"\2\2\2\u00d4\u00d5\f\b\2\2\u00d5\u00d6\7\27\2\2\u00d6\u00d7\5\36\20\t"+
		"\u00d7\u00d8\b\20\1\2\u00d8\u00ee\3\2\2\2\u00d9\u00da\f\7\2\2\u00da\u00db"+
		"\7\30\2\2\u00db\u00dc\5\36\20\b\u00dc\u00dd\b\20\1\2\u00dd\u00ee\3\2\2"+
		"\2\u00de\u00df\f\6\2\2\u00df\u00e0\7\31\2\2\u00e0\u00e1\5\36\20\7\u00e1"+
		"\u00e2\b\20\1\2\u00e2\u00ee\3\2\2\2\u00e3\u00e4\f\5\2\2\u00e4\u00e5\7"+
		"\32\2\2\u00e5\u00e6\5\36\20\6\u00e6\u00e7\b\20\1\2\u00e7\u00ee\3\2\2\2"+
		"\u00e8\u00e9\f\4\2\2\u00e9\u00ea\7\33\2\2\u00ea\u00eb\5\36\20\5\u00eb"+
		"\u00ec\b\20\1\2\u00ec\u00ee\3\2\2\2\u00ed\u00d4\3\2\2\2\u00ed\u00d9\3"+
		"\2\2\2\u00ed\u00de\3\2\2\2\u00ed\u00e3\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ee"+
		"\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\37\3\2\2"+
		"\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3\5\"\22\2\u00f3\u00f4\b\21\1\2\u00f4"+
		"!\3\2\2\2\u00f5\u00f6\7\26\2\2\u00f6\u00f7\5\"\22\2\u00f7\u00f8\b\22\1"+
		"\2\u00f8\u010c\3\2\2\2\u00f9\u00fa\7\30\2\2\u00fa\u00fb\5\"\22\2\u00fb"+
		"\u00fc\b\22\1\2\u00fc\u010c\3\2\2\2\u00fd\u0100\7\34\2\2\u00fe\u0100\7"+
		"\35\2\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u010c\b\22\1\2\u0102\u0103\7 \2\2\u0103\u010c\b\22\1\2\u0104\u0105\7"+
		"!\2\2\u0105\u010c\b\22\1\2\u0106\u0107\7\"\2\2\u0107\u010c\b\22\1\2\u0108"+
		"\u0109\5$\23\2\u0109\u010a\b\22\1\2\u010a\u010c\3\2\2\2\u010b\u00f5\3"+
		"\2\2\2\u010b\u00f9\3\2\2\2\u010b\u00ff\3\2\2\2\u010b\u0102\3\2\2\2\u010b"+
		"\u0104\3\2\2\2\u010b\u0106\3\2\2\2\u010b\u0108\3\2\2\2\u010c#\3\2\2\2"+
		"\u010d\u010e\5&\24\2\u010e\u010f\b\23\1\2\u010f%\3\2\2\2\u0110\u0111\b"+
		"\24\1\2\u0111\u0112\7\37\2\2\u0112\u0113\b\24\1\2\u0113\u0120\3\2\2\2"+
		"\u0114\u0115\f\4\2\2\u0115\u0116\7\13\2\2\u0116\u0117\5\32\16\2\u0117"+
		"\u0118\7\f\2\2\u0118\u0119\b\24\1\2\u0119\u011f\3\2\2\2\u011a\u011b\f"+
		"\3\2\2\u011b\u011c\7\36\2\2\u011c\u011d\7\37\2\2\u011d\u011f\b\24\1\2"+
		"\u011e\u0114\3\2\2\2\u011e\u011a\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\'\3\2\2\2\u0122\u0120\3\2\2\2\26\61"+
		"9HWcqz\u008d\u0094\u00a2\u00ac\u00bd\u00cb\u00cd\u00ed\u00ef\u00ff\u010b"+
		"\u011e\u0120";
>>>>>>> 6ee27e5080320d995b54e797ba7192aa38053917
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}