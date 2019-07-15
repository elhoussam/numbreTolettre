package me.elhoussam.nbtolettre;
public class GenFr extends NumToLet {

	/*
	 * Enum BasicNombre : represente the tiny DB for this App
	 * 			which is contain the basic nombre that used 
	 * 			to construct the other nombres
	 * 
	 * */
	@Override
	public void Generate(long InputNombre){
		long innerVal =  InputNombre ; 
		byte i=0, counter =0;
		String innerStr = "";
		// the 1st part dividing the number and store it in NB 
		while ( innerVal > 0 ) {
			short localvar = (short) (innerVal % 1000) ;
			if ( localvar > 0 ){
				// parsing the differente part of the numbre
				NB o =(new GenFr()).new NB(localvar,
			    	((Color)?BasicNombre.ColorAnsi[i]:"").concat( 
			    	BasicNombre.ScaleNombre[i]).concat(
			    	(Color)?BasicNombre.ColorAnsi[BasicNombre.ColorAnsi.length-1]:"") 
			    	); 
			    // constructing part of the numbre
				String localstr="";
				if ( counter > 0 )
					localstr = " et ";
					innerStr = (BasicParser( o.nb ).toString().concat( o.str )
							+localstr+innerStr);
					counter++;
			}i++;
			innerVal = innerVal / 1000;
		}
		// print the result 
		print( (InputNombre != 0)? innerStr : TensParser( (short) innerVal ) );
	}
	/*
	 * function BasicParser : that take short as Input
	 * 				then generate the string that corresponding 
	 * 				to the Input, finally print the letter
	 *
	 * */
	private String BasicParser( short inputNombre ) {
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
	private String HundredParser(short inputNombre) {
		byte innerVal = (byte)(inputNombre / 100) ;
		String str = "";
		if ( innerVal != 0 ) {
			if (innerVal != 1) 
				str = str.concat( BasicNombre.get( innerVal ) );
			str = str.concat(
					((Color)?BasicNombre.ColorAnsi[0]:"").concat(" Cent ").concat(
					(Color)?BasicNombre.ColorAnsi[BasicNombre.ColorAnsi.length-1]:""));
			
		}
		return str ;
	}
	/*
	 * function TensParser : that take integer as Input
	 * 				then generate the string that corresponding 
	 * 				to the Input, finally print the letter
	 *
	 * */
	private String TensParser(short inputNombre) {
		byte innerVal = (byte) inputNombre, unit ;
		String str = "";
		 // First Sénario
		if ( innerVal >=0 && innerVal <= 20 ) {
			str = str.concat( BasicNombre.get( innerVal ) );
		// Second Sénario 
		}else if ( (innerVal>=21 && innerVal<= 69) || (innerVal>=80 && innerVal<= 89)) {
			unit = (byte) (innerVal % 10) ;
			innerVal = (byte) (innerVal - unit) ;
			str = str.concat( BasicNombre.get( innerVal ) );

			if( unit != 0 ) {
				if ( unit == 1 ) str = str.concat(" et ");
				else str = str.concat("-");
				str = str.concat( BasicNombre.get( unit ) );
			}
		// Third Sénario	
		}else if ( (innerVal>=70 && innerVal<= 79) || (innerVal>=90 && innerVal<= 99)) { 
			unit = (byte) ((innerVal % 10 )+10);
			innerVal = (byte) (innerVal - unit) ;
			
			str = str.concat( BasicNombre.get( innerVal ) ); 
			if ( unit == 11 ) str = str.concat(" et ");
			else str = str.concat("-");
			str = str.concat( BasicNombre.get( unit ) );
			
		}
		return str ;
	}

}
