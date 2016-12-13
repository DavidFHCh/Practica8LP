package Lexer;

/**
* File: OPPattern
*
*/

public class OPPattern extends LexerPatterns{


	/**
	*	Obtiene el Patron para operaciones.
	*
	*	@return el Patron.
	*/
	public String getPattern(){
		return "\\+|-|\\*|/|%|min|max|pow|number?|and|or|not|<|>|<=|>=|=|!=|zero?|head|tail|empty?|list?|cons";
	}
}