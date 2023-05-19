/* 
* Autores: 
*	Lívia Pereira Ozório 		-  	201835011 
*	Patrick Canto de Carvalho 	- 	201935026
*
*/
public class Token {
    public int l, c;
    public TOKEN_TYPE t;
    public String lexeme;
    public Object info;
    
    public Token(TOKEN_TYPE t, String lex, Object o ,int l, int c){
          this.t = t;
          lexeme = lex;
          info =  o;
          this.l = l;
          this.c = c;
    }
    
    public Token(TOKEN_TYPE t, String lex,int l, int c){
          this.t = t;
          lexeme = lex;
          info =  null;
          this.l = l;
          this.c = c;
    }
    
    public Token(TOKEN_TYPE t,Object o,int l, int c){
          this.t = t;
          lexeme = "";
          info =  o;
          this.l = l;
          this.c = c;
    }
    
    public Token(TOKEN_TYPE t ,int l, int c){
          this.t = t;
          lexeme = "";
          info =  null;
          this.l = l;
          this.c = c;
    }

    @Override
    public String toString(){
       return "["+t+"("+l+","+ c+ ") \"" + lexeme + "\" : <" + (info == null ? "" : info.toString()) + ">]";
    }
}

 
