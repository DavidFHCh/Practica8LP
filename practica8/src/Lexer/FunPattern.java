package Lexer;

/**
* File: FunPattern
*
*/

public class FunPattern extends LexerPatterns{


	/**
	*	Obtiene el Patron para funciones con identificadores unicos.
	*
	*	@return el Patron.
	*/
	public String getPattern(){
		return "with|rec|fun|if";
	}
}