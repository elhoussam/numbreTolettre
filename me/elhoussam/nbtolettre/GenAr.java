package me.elhoussam.nbtolettre;

import java.util.Hashtable;

public class GenAr extends NumToLet {
	public GenAr() {
		Hashtable<Integer, String> htbl = new Hashtable<Integer, String>();
		htbl.put(0,"صفر"); htbl.put(1,"واحد"); htbl.put(2, "اثنين"); 
		htbl.put(3, "ثلاثة"); htbl.put(4, "اربعة"); htbl.put(5, "خمسة"); 
		htbl.put(6, "ستة"); htbl.put(7, "سبعة"); htbl.put(8, "ثمانية"); 
		htbl.put(9, "تسعة"); htbl.put(10, "عشرة"); htbl.put(11, "احد عشر"); 
		htbl.put(12, "اثنتي عشر"); htbl.put(13, "ثلاثة عشر"); htbl.put(14, "اربعة عشر"); 
		htbl.put(15, "خمسة عشر"); htbl.put(16, "ستة عشر"); htbl.put(17, "سبعة عشر"); 
		htbl.put(18, "ثمانية عشر"); htbl.put(19, "تسعة عشر"); htbl.put(20, "عشرون"); 
		htbl.put(30, "ثلاثون"); htbl.put(40, "اربعون"); htbl.put(50, "خمسون"); 
		htbl.put(60, "ستون"); htbl.put(80, "ثمانون");  
		String ScNombre [] = {"","آلف","مليون","مليار", "بليون","بليار","ترليون", "ترليار"}; 
	
		Init(htbl, ScNombre,"و");
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
					((Color)?ColorAnsi[0]:"").concat("مائة"+space).concat(
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
			else str = str.concat(link+space);
			str = str.concat( get( unit ) );
			
		}
		return str ;
	}

}
