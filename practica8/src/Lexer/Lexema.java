package Lexer;

public class Lexema{

	private String lexema;

	public Lexema(String tipo,String contenido){
		lexema = tipo + contenido;
	}

	public String getLexema(){
		return lexema;
	}
}