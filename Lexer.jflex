
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
%%

%unicode
%line
%column
%class  Lexer
%function nextToken
%type Token

%{
    
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int ntk;
    
    public int readedTokens(){
       return ntk;
    }

    private Token symbol(TOKEN_TYPE t) {
        ntk++;
        return new Token(t, yyline+1, yycolumn+1);
        
    }

    private Token symbol(TOKEN_TYPE t, String s) {
        ntk++;
        return new Token(t, s, yyline+1, yycolumn+1);
        
    }
    private Token symbol(TOKEN_TYPE t, Object value) {
        ntk++;
        return new Token(t, value, yyline+1, yycolumn+1);
    }
%}

%init{
    ntk = 0; // Isto é copiado direto no construtor do lexer. 
%init}

  
  /* Agora vamos definir algumas macros */
  FimDeLinha  = \r|\n|\r\n
  Brancos     = {FimDeLinha} | [ \t\f]
  type        = [:uppercase:] [[:letter:]|[:digit:]|_]*
  identificador = [:lowercase:] [[:letter:]|[:digit:]|_]*
  int      = [:digit:] [:digit:]*
  float    = [:digit:][:digit:]*\.[:digit:][:digit:]* | \.[:digit:][:digit:]*
  char     = '(.)' | '\\r' | '\\n' | '\\t' | '\\\\' | '\\''
  LineComment = -- (.)* {FimDeLinha}
  Comment  = \{- (.)* -\}
  
%state COMMENT

%%

<YYINITIAL>{
    "true"          { return symbol(TOKEN_TYPE.TRUE);}
    "false"         { return symbol(TOKEN_TYPE.FALSE);}
    "null"          { return symbol(TOKEN_TYPE.NULL);}
    "ID"            { return symbol(TOKEN_TYPE.ID);}
    "DATA"          { return symbol(TOKEN_TYPE.DATA);}
    "Int"           { return symbol(TOKEN_TYPE.INT);}
    "Char"          { return symbol(TOKEN_TYPE.CHAR);}
    "Bool"          { return symbol(TOKEN_TYPE.BOOL);}
    "Float"         { return symbol(TOKEN_TYPE.FLOAT);}
    "if"            { return symbol(TOKEN_TYPE.IF);}
    "else"          { return symbol(TOKEN_TYPE.ELSE);}
    "iterate"       { return symbol(TOKEN_TYPE.ITERATE);}
    "read"          { return symbol(TOKEN_TYPE.READ);}
    "print"         { return symbol(TOKEN_TYPE.PRINT);}
    "new"           { return symbol(TOKEN_TYPE.NEW);}
    {identificador} { return symbol(TOKEN_TYPE.ID_VALUE, yytext());   }
    {int}           { return symbol(TOKEN_TYPE.INT_VALUE, Integer.parseInt(yytext()) );  }
    {float}         { return symbol(TOKEN_TYPE.FLOAT_VALUE, Float.parseFloat(yytext()) );  }
    {type}          { return symbol(TOKEN_TYPE.TYPE, yytext());}
    {char}          { return symbol(TOKEN_TYPE.CHAR_VALUE, yytext());}
    "="             { return symbol(TOKEN_TYPE.EQ);  }
    ";"             { return symbol(TOKEN_TYPE.SEMI); }
    "*"             { return symbol(TOKEN_TYPE.TIMES); }
    "+"             { return symbol(TOKEN_TYPE.PLUS); }
    "{"             { return symbol(TOKEN_TYPE.BRACES_OPEN);}
    "}"             { return symbol(TOKEN_TYPE.BRACES_CLOSE);}
    "("             { return symbol(TOKEN_TYPE.PARENTHESES_OPEN);}
    ")"             { return symbol(TOKEN_TYPE.PARENTHESES_CLOSE);}
    "["             { return symbol(TOKEN_TYPE.BRACKETS_OPEN);}
    "]"             { return symbol(TOKEN_TYPE.BRACKETS_CLOSE);}
    ">"             { return symbol(TOKEN_TYPE.MORE_THAN);}
    ":"             { return symbol(TOKEN_TYPE.COLON);}
    "::"            { return symbol(TOKEN_TYPE.TWO_COLON);}
    "."             { return symbol(TOKEN_TYPE.PERIOD);}
    ","             { return symbol(TOKEN_TYPE.COMMA);}
    "<"             { return symbol(TOKEN_TYPE.LESS_THAN);}
    "=="            { return symbol(TOKEN_TYPE.EQ_LOGIC);}
    "!="            { return symbol(TOKEN_TYPE.DIFFERENT);}
    "-"             { return symbol(TOKEN_TYPE.SUBTRACTION);}
    "/"             { return symbol(TOKEN_TYPE.DIVISION);}
    "%"             { return symbol(TOKEN_TYPE.REST);}
    "&&"            { return symbol(TOKEN_TYPE.AND);}
    "!"             { return symbol(TOKEN_TYPE.NEGATION);}
    {Brancos}       { }
    {LineComment}   { }
    {Comment}       { }
}


[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }



