grammar lang;

@parser::header
{
    package parser;

    import ast.*;
}

@lexer::header
{
    package parser;
}

/* Regras da gramática */



prog returns [Prog ast]:
  d=dataList f=funcList {

  if($d.ast != null){
     $ast = new Prog($d.ast.getLine(), $d.ast.getCol(), $d.ast, $f.ast);
    }
  else if($f.ast != null){
    $ast = new Prog($f.ast.getLine(), $f.ast.getCol(), $d.ast, $f.ast);
    }
  else{
    $ast = new Prog(0, 0, $d.ast, $f.ast);
  }
  }
;

dataList returns [DataList ast]:
  (d=data {
    if($ast == null){$ast = new DataList($d.ast.getLine(), $d.ast.getCol(), $d.ast); }
    else{$ast.addNode($d.ast);}
  })*
;

funcList returns [FuncList ast]:
  (f=func {
    if($ast == null){$ast = new FuncList($f.ast.getLine(), $f.ast.getCol(), $f.ast); }
    else{$ast.addNode($f.ast);}
  })*
;

data returns [Node ast]:
  kw='data' ID '{' declList '}' { $ast = new Data($kw.line, $kw.pos, new ID($ID.line, $ID.pos, $ID.text), $declList.ast);}
  ;

declList returns [DeclList ast]:
   (d=decl {
    if($ast == null){$ast = new DeclList($d.ast.getLine(), $d.ast.getCol(), $d.ast); }
    else{$ast.addNode($d.ast);}
  })*
  ;

decl returns [Node ast]:
  ID '::' type ';' {$ast = new Decl($ID.line, $ID.pos, new ID($ID.line, $ID.pos, $ID.text), $type.ast);}
  ;

func returns [Func ast]:
  ID '(' params? ')'(':'type)?'{'cmdList'}'{
    $ast = new Func($ID.line, $ID.pos, new ID($ID.line, $ID.pos, $ID.text), null, null, $cmdList.ast);}
;

type returns [Node ast]:
  type '['']'
  |
  ( t='Int' | t='Char' | t='Float' | t='Bool' | t=ID) {$ast = new Type($t.line, $t.pos, $t.text);}
;


cmd returns [Node ast]:
 'print' exp ';' {$ast = new Print($exp.ast.getLine(), $exp.ast.getCol(), $exp.ast);}
 |
 '{' cmdList '}' { $ast = $cmdList.ast;}
 |
 lvalue '=' exp ';' {$ast = new Attr($lvalue.ast.getLine(), $lvalue.ast.getCol(), $lvalue.ast, $exp.ast);}
;

cmdList returns [CmdList ast]:
  (c=cmd {
    
    if($ast == null){$ast = new CmdList($c.ast.getLine(), $c.ast.getCol(), $c.ast); }
    else{$ast.addNode($c.ast);}
  })*
;



exp returns [Expr ast]:
  a1=exp '&''&' a2=exp {$ast = new And($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);} 
  |
  INT {$ast = new Int($INT.line, $INT.pos, Integer.parseInt($INT.text));}
  |
  CHAR {$ast = new Char($CHAR.line, $CHAR.pos, $CHAR.text);}
  |
  lvalue {$ast = $lvalue.ast;}
  |
  rexp{$ast=$rexp.ast;}
;

rexp returns [Expr ast]:
  ll=aexp o='<' rl=aexp {$ast = new LessThan($o.line, $o.pos, $ll.ast, $rl.ast);} 
  |
  lg=aexp o='>' rg=aexp {$ast = new GreaterThan($o.line, $o.pos, $lg.ast, $rg.ast);} 
  |
  le=rexp o='=''=' re=aexp {$ast = new Eq($o.line, $o.pos, $le.ast, $re.ast);} 
  | 
  ld=rexp o='!''=' rd=aexp {$ast = new Diff($o.line, $o.pos, $ld.ast, $rd.ast);} 
  |
  aexp{$ast=$aexp.ast;}
;

aexp returns [Expr ast]:
  a1=aexp '+' a2=aexp{$ast = new Add($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);}
  |
  a1=aexp '-' a2=aexp{$ast = new Sub($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);}
  |
  a1=aexp '*' a2=aexp{$ast = new Mul($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);}
  |
  a1=aexp '/' a2=aexp{$ast = new Div($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);}
  |
  a1=aexp '%' a2=aexp{$ast = new Rest($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);}
  |
  mexp{$ast=$mexp.ast;}  
;

mexp returns [Expr ast]:
  sexp{$ast=$sexp.ast;}
;

sexp returns [Expr ast]:
  n='!' sexp {$ast = new Neg($n.line, $n.pos, $sexp.ast);}
  |
  su='-' sexp {$ast = new SubUni($su.line, $su.pos, $sexp.ast);}
  | 
  (b='true' | b='false'){$ast = new Bool($b.line, $b.pos, Boolean.parseBoolean($b.text));}
  |
  INT {$ast = new Int($INT.line, $INT.pos, Integer.parseInt($INT.text));}
  |
  FLOAT {$ast = new FloatAst($FLOAT.line, $FLOAT.pos, Float.parseFloat($FLOAT.text));}
  |
  CHAR {$ast = new Char($CHAR.line, $CHAR.pos, $CHAR.text);}
  | 
  pexp {$ast=$pexp.ast;}
;

pexp returns [Expr ast]:
  lvalue{$ast=$lvalue.ast;}
;


lvalue returns [LValue ast]:
  ID {$ast = new LValue($ID.line, $ID.pos, new ID($ID.line, $ID.pos, $ID.text));}
  |
  l=lvalue '[' exp ']' {}
  |
  l=lvalue '.' ID {}
;

params returns[Node ast]:
ID '::' TYPE (',' ID '::' TYPE)* {}
;




ID : [a-z] ([a-z]|[A-Z]|[0-9]|'_')*;
INT : [0-9]+;
FLOAT : [0-9]+ '.' [0-9]+ | '.' [0-9];
CHAR : ('\'' '\\n' '\'') 
    | ('\'' '\\t' '\'') 
    | ('\'' '\\b' '\'') 
    | ('\'' '\\r' '\'') 
    | ('\'' '\\\\' '\'') 
    | ('\'' '\\' '\'') 
    | ('\'' [\u0000-\uFFFE] '\'')
    ;
TYPE: [A-Z]([a-z]|[A-Z]|[0-9]|'_')*;
NEWLINE: '\r'? '\n' -> skip;
LINE_COMMENT: '--' ~('\r' | '\n')* NEWLINE -> skip;
COMMENT: '{-' (.)* '-}' -> skip;
BLANK: (' ' | '\f' | '\t') -> skip;