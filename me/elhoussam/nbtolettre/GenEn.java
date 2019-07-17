package me.elhoussam.nbtolettre;

import java.util.Hashtable;

public class GenEn extends NumToLet {
	public GenEn() {
		Hashtable<Integer, String> htbl = new Hashtable<Integer, String>();
		htbl.put(0,"Zero"); htbl.put(1,"One"); htbl.put(2, "Two"); 
		htbl.put(3, "Three"); htbl.put(4, "Four"); htbl.put(5, "Five"); 
		htbl.put(6, "Six"); htbl.put(7, "Seven"); htbl.put(8, "Height"); 
		htbl.put(9, "Nine"); htbl.put(10, "Ten"); htbl.put(11, "Eleven"); 
		htbl.put(12, "Twelve"); htbl.put(13, "Thirteen"); htbl.put(14, "Fourteen"); 
		htbl.put(15, "Fifteen"); htbl.put(16, "Sixteen"); htbl.put(17, "Seventeen"); 
		htbl.put(18, "Dix-Huit"); htbl.put(19, "Nineteen"); htbl.put(20, "Twenty"); 
		htbl.put(30, "Thirty"); htbl.put(40, "Forty"); htbl.put(50, "Fifty"); 
		htbl.put(60, "Sixty"); htbl.put(70, "Seventy");  
		htbl.put(90, "Ninety"); htbl.put(80, "Eighty");  
		String ScNombre [] = {""," Thousand"," Million"," Milliard", " Billion"," Billiard"," Trillion", " Trilliard"}; 
	
		Init(htbl, ScNombre,",");
	}
	/*
	 * function BasicParser : that take short as Input
	 * 				then generate the string that corresponding 
	 * 				to the Input, finally print the letter
	 *
	 * */
	@Override
	protected String BasicParser( short inputNombre ) {
		short innerValue = inputNombre ;
		String innerStr = "";
		// Starting with hundred part of number
		innerStr = innerStr.concat( HundredParser( innerValue ) ) ;
		innerValue%=100;
		// Completing with Tens part of the number
		if (  inputNombre/100 == 0 || innerValue != 0  ) 
			innerStr = innerStr.concat( TensParser( innerValue  ) );
		return innerStr ;	
	}
	/*
	 * function HundredParser : that take integer as Input
	 * 				then generate the string that corresponding 
	 * 				to the Input, finally print the letter
	 *
	 * */
	@Override
	protected String HundredParser(short inputNombre) {
		byte innerVal = (byte)(inputNombre / 100) ;
		String str = "";
		if ( innerVal != 0 ) { 
			str = str.concat( get( innerVal ) );
			str = str.concat(
					((Color)?ColorAnsi[0]:"").concat(" Hundred ").concat(
					(Color)?ColorAnsi[ColorAnsi.length-1]:""));
			
		}
		return str ;
	}
	/*
	 * function TensParser : that take integer as Input
	 * 				then generate the string that corresponding 
	 * 				to the Input, finally print the letter
	 *
	 * */
	@Override
	protected String TensParser(short inputNombre) {
		byte innerVal = (byte) inputNombre, unit ;
		String str = "";
		 // First Sénario
		if ( innerVal >=0 && innerVal <= 20 ) {
			str = str.concat( get( innerVal ) );
		// Second Sénario 
		}else if ( (innerVal>=21 && innerVal<= 99)) {
			unit = (byte) (innerVal % 10) ;
			innerVal = (byte) (innerVal - unit) ;
			str = str.concat( get( innerVal ) );

			if( unit != 0 ) {
				str = str.concat("-");
				str = str.concat( get( unit ) );
			}
		}
		return str ;
	}

}
