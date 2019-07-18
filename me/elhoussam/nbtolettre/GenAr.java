package me.elhoussam.nbtolettre;

import java.util.Hashtable;

public class GenAr extends NumToLet {
	public GenAr() {
		Hashtable<Integer, String> htbl = new Hashtable<Integer, String>();
		htbl.put(0,"Zéro"); htbl.put(1,"Un"); htbl.put(2, "Deux"); 
		htbl.put(3, "Trois"); htbl.put(4, "Quatre"); htbl.put(5, "Cinq"); 
		htbl.put(6, "Six"); htbl.put(7, "Sept"); htbl.put(8, "Huit"); 
		htbl.put(9, "Neuf"); htbl.put(10, "Dix"); htbl.put(11, "Onze"); 
		htbl.put(12, "Douze"); htbl.put(13, "Treize"); htbl.put(14, "Quatorze"); 
		htbl.put(15, "Quinze"); htbl.put(16, "Seize"); htbl.put(17, "Dix-Sept"); 
		htbl.put(18, "Dix-Huit"); htbl.put(19, "Dix-Neuf"); htbl.put(20, "Vingt"); 
		htbl.put(30, "Trente"); htbl.put(40, "Quarante"); htbl.put(50, "Cinquante"); 
		htbl.put(60, "Soixante"); htbl.put(80, "Quatre Vingt");  
		String ScNombre [] = {"","Mille","Million","Milliard", "Billion","Billiard","Trillion", "Trilliard"}; 
	
		Init(htbl, ScNombre,"et");
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
			if (innerVal != 1) 
				str = str.concat( get( innerVal )+space );
			str = str.concat(
					((Color)?ColorAnsi[0]:"").concat("Cent"+space).concat(
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
		}else if ( (innerVal>=21 && innerVal<= 69) || (innerVal>=80 && innerVal<= 89)) {
			unit = (byte) (innerVal % 10) ;
			innerVal = (byte) (innerVal - unit) ;
			str = str.concat( get( innerVal ) );

			if( unit != 0 ) {
				if ( unit == 1 ) str = str.concat(link+space);
				else str = str.concat("-");
				str = str.concat( get( unit ) );
			}
		// Third Sénario	
		}else if ( (innerVal>=70 && innerVal<= 79) || (innerVal>=90 && innerVal<= 99)) { 
			unit = (byte) ((innerVal % 10 )+10);
			innerVal = (byte) (innerVal - unit) ;
			
			str = str.concat( get( innerVal ) ); 
			if ( unit == 11 ) str = str.concat(link+space);
			else str = str.concat("-");
			str = str.concat( get( unit ) );
			
		}
		return str ;
	}

}
