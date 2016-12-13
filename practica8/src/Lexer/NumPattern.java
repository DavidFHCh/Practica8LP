package Lexer;

/**
* File: NumPattern
*
*/

public class NumPattern extends LexerPatterns{


	/**
	*	Obtiene el Patron para numeros.
	*
	*	@return el Patron.
	*/
	public String getPattern(){
		return "(\\+|-)?([0-9]+)";
	}
}