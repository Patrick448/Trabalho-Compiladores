
import parser.*;
import ast.*;
import visitors.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class LangCompiler {

	public static void writeToFile(String filename, String content) {
		try {
			File myObj = new File(filename);
			if (myObj.createNewFile()) {
				//System.out.println("File created: " + myObj.getName());
			} else {
				//System.out.println("File already exists.");
			}

			FileWriter myWriter = new FileWriter(filename);
			myWriter.write(content);
			myWriter.close();

		} catch (IOException e) {
			//System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public static void main(String args[]) throws Exception {

		if(args.length<3)
		{
			System.out.println("O sistema espera 2 argumetos obrigatorios sendo:");
			System.out.println("O 1º: Arquivo a ser executado");
			System.out.println("O 2º: Qual o metodo de compilação ou interpretação quer usar");
			System.out.println("\t -i : intepretador");
			System.out.println("\t -s : codigo em Java");
			System.out.println("\t -j : cogido em Jasmin");
		}
		if(args.length >=3 && args[2].equals("-v"))
			System.out.println("\nFile: " + args[0]);

		// Create a ANTLR CharStream from a file
		CharStream stream = CharStreams.fromFileName(args[0]);
		// create a lexer that feeds off of stream
		langLexer lex = new langLexer(stream);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lex);
		// create a parser that feeds off the tokens buffer
		langParser parser = new langParser(tokens);
		// tell ANTLR to does not automatically build an AST
		parser.setBuildParseTree(false);

		Node ast = null;
		try
		{
			ast = parser.prog().ast;
		}
		catch(Exception e){
			//System.out.println(e);
			System.exit(0);
	  	}
		if (ast != null) {
			writeToFile("ast.dot", ast.dotString());
			ScopeVisitor scope = new ScopeVisitor();
			((Prog)ast).accept(scope);
			String analise = scope.getStack().pop();
			if(!analise.equals("Error"))
			{
				if(args[1] == "-i")
				{
					ast.tryInterpret(null, null, null, null, scope);
				}
				if(args[1] == "-s")
				{
					JavaGenVisitor javaVisitor = new JavaGenVisitor();
					ast.accept(javaVisitor);
				}
				if(args[1] == "-j")
				{
					JasminGenVisitor jasminVisitor = new JasminGenVisitor();
					ast.accept(jasminVisitor);
				}
			}
		}
	}	
}
