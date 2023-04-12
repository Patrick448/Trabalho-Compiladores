java -jar jflex-full-1.8.2.jar Analisador_Lexico.jflex
javac Lexer.java
javac Token.java
javac Teste.java
jar cmvf MANIFEST.MF Teste.jar Lexer.class Token.class Teste.class TOKEN_TYPE.class

