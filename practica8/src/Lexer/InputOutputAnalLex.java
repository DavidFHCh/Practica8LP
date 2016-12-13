package Lexer;

import java.io.*;
import java.util.*;

/**
*	File: InputOutputAnalLex
*
*	En este archivo es donde se manejara la entrada y la salida.
*/

public class InputOutputAnalLex{

	public static void main(String[] args){
		BufferedReader br = null;
		BufferedReader br2 = null;
		FileReader fr = null;
		System.out.println("Analizador Lexico.");
		boolean continuo = true;
		try{
			while(continuo){
				System.out.println("¿Como se va a presentar el codigo? \n 1)Terminal. \n 2)Archivo. \n 3)Cerrar.");
				br = new BufferedReader(new InputStreamReader(System.in));

				String input = br.readLine();
				String entrada = "";

				switch(input){
					case "1":
						System.out.println("Cuando termine de introducir codigo, de salto de linea y escriba la palabra \"FIN\",sin comillas. \n Introduzca el codigo: \n > ");
						input = "";

						do{
							input = br.readLine();
							if(!input.equals("FIN"))
								entrada += input;
						}while(!input.equals("FIN"));

						//Aqui llamo al coso lexico.
						AnalLex al1 = new AnalLex(entrada);
						ArrayList<String> salida1 = al1.run();

						for(String s: salida1)
							System.out.println(s);
						break;
					case "2":
						System.out.println("Por favor introduce la direccion absoluta del archivo: \n");
						input = br.readLine();
						File file = new File(input);
						fr = new FileReader(file);
						br2 = new BufferedReader(fr);
						while((input = br2.readLine()) != null){
							entrada += input;		
						}

						//Aqui llamo al lexico.
						AnalLex al = new AnalLex(entrada);
						ArrayList<String> salida = al.run();

						for(String s: salida)
							System.out.println(s);
						break;
					case "3":
						continuo = false;
						break;
					default:
						System.out.println("Intenta Otra Vez.");
				}
			}
		}catch(Exception e){
			System.err.println("Error al leer Archivo.");
			e.printStackTrace();

		}
	}
}