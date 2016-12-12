package Lexer;

/**
* File: IDPattern
*
*/

public class IDPattern extends LexerPatterns{


	/**
	*	Obtiene el Patron para id's.
	*
	*	@return el Patron.
	*/
	public String getPattern(){
		return "^[a-zA-Z0-9]*$";
	}
}