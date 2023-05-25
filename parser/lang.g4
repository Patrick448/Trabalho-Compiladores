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
  d=dataList f=funcList {$ast = new Prog($d.ast.getLine(), $d.ast.getCol(), $d.ast, $f.ast);}
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

func returns [Func ast]:
  ID '(' params? ')'(':'type)?'{'cmdList'}'{
    $ast = new Func($ID.line, $ID.pos, new ID($ID.line, $ID.pos, $ID.text), null, null, $cmdList.ast);}
;

exp returns [Expr ast]:
  INT {$ast = new Num($INT.line, $INT.pos, Integer.parseInt($INT.text));}
  |
  lvalue {$ast = $lvalue.ast;}
  |
  rexp{$ast=$rexp.ast;}
;

rexp returns [Expr ast]:
  aexp{$ast=$aexp.ast;}
;

aexp returns [Expr ast]:
  a1=aexp '+' a2=aexp{$ast = new Add($a1.ast.getLine(), $a1.ast.getCol(), $a1.ast, $a2.ast);}
  |
  mexp{$ast=$mexp.ast;}  
;

mexp returns [Expr ast]:
  sexp{$ast=$sexp.ast;}
;

sexp returns [Expr ast]:
  '!' sexp {}
  |
  '-' sexp {}
  | 
  ('true' | 'false'){}
  |
  INT {$ast = new Num($INT.line, $INT.pos, Integer.parseInt($INT.text));}
  |
  FLOAT {}
  /*
  |
  CHAR {}*/

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



/* 
stmt returns [Node ast]:
 ID '=' expr {$ast = new Attr($ID.line, $ID.pos, new ID($ID.line, $ID.pos, $ID.text), $expr.ast);}
|
 expr op='?' '[' s1=stmt ']' ':' '[' s2=stmt ']' {$ast = new If($op.line, $op.pos, $expr.ast, $s1.ast, $s2.ast);}
|
 expr op='?' '[' s1=stmt ']' {$ast = new If($op.line, $op.pos, $expr.ast, $s1.ast);}
|
 expr {$ast = new Print($expr.ast.getLine(), $expr.ast.getCol(), $expr.ast);}
;

expr returns [Expr ast]:
 term op='+' e=expr {$ast = new Add($op.line, $op.pos, $term.ast, $e.ast);}
|
 term {$ast = $term.ast;}
;

term returns [Expr ast]:
 factor op='*' e=term {$ast = new Mul($op.line, $op.pos, $factor.ast, $e.ast);}
|
 factor {$ast = $factor.ast;}
;

factor returns [Expr ast]:
 ID {$ast = new ID($ID.line, $ID.pos, $ID.text);}
|
 INT {$ast = new Num($INT.line, $INT.pos, Integer.parseInt($INT.text));}
;
*/

///---------------------------------------

ID : [a-z] ([a-z]|[A-Z]|[0-9]|'_')*;
INT : [0-9]+;
FLOAT : [0-9]+ '.' [0-9]+ | '.' [0-9];
//CHAR : '\''[^'\''\\]'\'' | '\'''\\r''\'' | '\'''\\n''\'' | '\'''\\t''\'' | '\'''\\\\''\'' | '\'''\\\'''\'';
TYPE: [A-Z]([a-z]|[A-Z]|[0-9]|'_')*;
NEWLINE: '\r'? '\n' -> skip;
LINE_COMMENT: '--' ~('\r' | '\n')* NEWLINE -> skip;
COMMENT: '{-' (.)* '-}' -> skip;
BLANK: (' ' | '\f' | '\t') -> skip;