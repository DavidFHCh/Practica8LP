package Lexer;

import java.util.*;
import java.util.regex.Pattern;

/**
*	File: AnalLex
*
*	En este archivo es donde se realizara el analisis Lexico.
*	The name of this file was intended to sound funny due to the fact of countless hours and incredible suffering it took to write it.
*/
public class AnalLex{

	private String id;
	private String bool;
	private String num;
	private String op;
	private String fun;
	private String entrada;

	/**
	*	Constructor para obtener los patrones y la cadena a la que se le aplicara el analisis.
	*
	*	@param entrada el codigo a analizar.
	*/
	public AnalLex(String entrada){
		this.entrada = entrada;
		IDPattern idp = new IDPattern();
		BoolPattern bp = new BoolPattern();
		NumPattern np = new NumPattern();
		OPPattern opp = new OPPattern();
		FunPattern funp = new FunPattern();

		id = idp.getPattern();
		bool = bp.getPattern();
		num = np.getPattern();
		op = opp.getPattern();
		fun = funp.getPattern();
	}

	private ArrayList<String> analizador(){
		ArrayList<String> l = new ArrayList<>();
		String entrada2 = entrada.trim();
		int llaves = 0;
		for(int i = 0; i < entrada2.length();i++){
			if(entrada2.charAt(i) =='{'){
				llaves++;
				continue;
			}
			if(entrada2.charAt(i) == '}'){
				llaves--;
				continue;
			}
		}
		if(llaves != 0)
			System.err.println("Llaves desbalanceadas.");
		String[] fichas = entrada2.split("\\{|\\}|\\s");
		for(String f: fichas){
			if(Pattern.matches("\\s*",f))
				continue;
			if(Pattern.matches(fun,f)){
				Lexema lex = new Lexema("<fun> ",f);
				l.add(lex.getLexema());
			}else{				
				if(Pattern.matches(op,f)){
					Lexema lex = new Lexema("<op> ",f);
					l.add(lex.getLexema());
				}else{
					if(Pattern.matches(bool,f)){
						Lexema lex = new Lexema("<boolean> ",f);
						l.add(lex.getLexema());
					}else{
						if(Pattern.matches("empty",f)){
							Lexema lex = new Lexema("<list> ",f);
							l.add(lex.getLexema());
						}else{
							if(Pattern.matches(num,f)){
								Lexema lex = new Lexema("<number> ",f);
								l.add(lex.getLexema());
							}else{
								if(Pattern.matches(id,f)){
									Lexema lex = new Lexema("<id> ",f);
									l.add(lex.getLexema());
								}else{
									System.err.println("Error de Sintaxis.");
								}
							}
						}
					}
				}
			}
		}
		return l;
	}

	/**
	*	Metodo que corre el analizador, para hacer mas facil el uso de este programa.
	*	@return Una lista con los lexemas.
	*/
	public ArrayList<String> run(){
		return analizador();
	}

}