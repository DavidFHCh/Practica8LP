package Lexer;

/**
* File: BoolPattern
*
*/

public class BoolPattern extends LexerPatterns{


	/**
	*	Obtiene el Patron para Booleanos.
	*
	*	@return el Patron.
	*/
	public String getPattern(){
		return "true|false";
	}
}