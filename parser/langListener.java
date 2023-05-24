// Generated from parser/lang.g4 by ANTLR 4.8

    package parser;

    import ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link langParser}.
 */
public interface langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(langParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(langParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#dataList}.
	 * @param ctx the parse tree
	 */
	void enterDataList(langParser.DataListContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#dataList}.
	 * @param ctx the parse tree
	 */
	void exitDataList(langParser.DataListContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#funcList}.
	 * @param ctx the parse tree
	 */
	void enterFuncList(langParser.FuncListContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#funcList}.
	 * @param ctx the parse tree
	 */
	void exitFuncList(langParser.FuncListContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(langParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(langParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#declList}.
	 * @param ctx the parse tree
	 */
	void enterDeclList(langParser.DeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#declList}.
	 * @param ctx the parse tree
	 */
	void exitDeclList(langParser.DeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(langParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(langParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(langParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(langParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(langParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(langParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#cmdList}.
	 * @param ctx the parse tree
	 */
	void enterCmdList(langParser.CmdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#cmdList}.
	 * @param ctx the parse tree
	 */
	void exitCmdList(langParser.CmdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(langParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(langParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(langParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(langParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(langParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(langParser.ExpContext ctx);
}