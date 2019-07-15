package me.elhoussam.nbtolettre;
import java.util.Scanner;
import java.util.Vector;

public class NumbreToLettre {
	/*
	 * Enum BasicNombre : represente the tiny DB for this App
	 * 			which is contain the basic nombre that used 
	 * 			to construct the other nombres
	 * 
	 * */
	enum BasicNombre {
		Zéro((byte)0,"Zéro"),
		Un((byte)1,"Un"),
		Deux((byte)0,"Deux"), Trois((byte)0,"Trois"), 
		Quatre((byte)0,"Quatre"), Cinq((byte)0,"Cinq"),
		Six((byte)0,"Six"), Sept((byte)0,"Sept"), 
		Huit((byte)0,"Huit"), Neuf((byte)0,"Neuf"), 
		Dix((byte)0,"Dix"), Onze((byte)0,"Onze"), 
		Douze((byte)0,"Douze"),Treize((byte)0,"Treize"), 
		Quatorze((byte)0,"Quatorze"), Quinze((byte)0,"Quinze"), 
		Seize((byte)0,"Seize"), DixSept((byte)0,"Dix-Sept"),
		DixHuit((byte)18,"Dix-Huit"), DixNeuf((byte)0,"Dix-Neuf"), 
		Vingt((byte)20,"Vingt"), Trente((byte)30,"Trente"),
		Quarante((byte)40,"Quarante"), Cinquante((byte)50,"Cinquante"), 
		Soixante((byte)60,"Soixante"), QuatreVingt((byte)80,"Quatre Vingt");
		private byte nb;
		private String lettre ;
			
			BasicNombre(byte nbr, String ltr){
			this.nb = nbr;
			this.lettre = ltr;
			}
			static String get(byte i) {
				String nbr = "";
				switch( i ) {
				case 0 : nbr =  BasicNombre.Zéro.lettre;  break;
				case 1 : nbr =  BasicNombre.Un.lettre;  break;
				case 2 : nbr =  BasicNombre.Deux.lettre; break;
				case 3 : nbr =  BasicNombre.Trois.lettre; break;
				case 4 : nbr =  BasicNombre.Quatre.lettre; break;
				case 5 : nbr =  BasicNombre.Cinq.lettre; break;
				case 6 : nbr =  BasicNombre.Six.lettre; break;
				case 7 : nbr =  BasicNombre.Sept.lettre; break;
				case 8 : nbr =  BasicNombre.Huit.lettre; break;
				case 9 : nbr =  BasicNombre.Neuf.lettre; break;
				case 10 : nbr =  BasicNombre.Dix.lettre; break;
				case 11 : nbr =  BasicNombre.Onze.lettre; break;
				case 12 : nbr =  BasicNombre.Douze.lettre; break;
				case 13 : nbr =  BasicNombre.Treize.lettre; break;
				case 14 : nbr =  BasicNombre.Quatorze.lettre; break;
				case 15 : nbr =  BasicNombre.Quinze.lettre; break;
				case 16 : nbr =  BasicNombre.Seize.lettre; break;
				case 17 : nbr =  BasicNombre.DixSept.lettre; break;
				case 18 : nbr =  BasicNombre.DixHuit.lettre; break;
				case 19 : nbr =  BasicNombre.DixNeuf.lettre; break;
				case 20 : nbr =  BasicNombre.Vingt.lettre; break;
				case 30 : nbr =  BasicNombre.Trente.lettre; break;
				case 40 : nbr =  BasicNombre.Quarante.lettre; break;
				case 50 : nbr =  BasicNombre.Cinquante.lettre; break;
				case 60 : nbr =  BasicNombre.Soixante.lettre; break;
				case 80 : nbr =  BasicNombre.QuatreVingt.lettre; break;
				
				}
				return nbr;
			}
			static String ScaleNombre[]
					={""," Mille"," Million"," Milliard", //10^3 >- 0, 10^6 >- 1 ,10^9>-2
				 " Billion"," Billiard"," Trillion", " Trilliard"}; 
			 //10^12>-3, 10^15>-4, 10^18>-5, 10^21>-6 
			static String ColorAnsi[]
					= {"\u001B[31m","\u001B[32m","\u001B[33m",
					"\u001B[34m","\u001B[35m","\u001B[36m","\u001B[38m","\u001B[0m" };
		}
	// Print function that simply print str in the console
	public static void print( Object obj ) {
		System.out.print( obj );
	}
	/*
	 * inner class NB : that store the Nombre with it scale 
	 * */
	public class NB{
		short nb; // short
		String str ;
		public NB(short a/*short*/, String b) {
			this.nb=a; this.str =b;
		}
	}
	/*
	 * Generate Function : start devide the number and store into
	 * 	smaller pieces with it scale int NB's Objects
	 * */
	public static void Generate(long InputNombre){
		long innerVal =  InputNombre ; 
		byte i=0 ;
		String innerStr = "";
		Vector<NB> numVec = new Vector<NB>(); 
		// the 1st part dividing the number and store it in numVec 
		while ( innerVal > 0 ) {
			short localvar = (short) (innerVal % 1000) ;
			if ( localvar > 0 ){
				numVec.add(
			    		(new NumbreToLettre()).new NB(localvar,
			    				BasicNombre.ColorAnsi[i] + BasicNombre.ScaleNombre[i]+
			    				BasicNombre.ColorAnsi[BasicNombre.ColorAnsi.length-1])
			    		);
			}i++;
			innerVal = innerVal / 1000;
		}
		// the 2nd part construction the str from the numVec
		for (NB o : numVec) {
			String localstr="";
			if ( numVec.indexOf(o) != 0 )
				localstr = " et ";
				innerStr = (BasicParser( o.nb ).toString().concat( o.str )
						+localstr+innerStr);		
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
	public static String BasicParser( short inputNombre ) {
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
	static String HundredParser(short inputNombre) {
		byte innerVal = (byte)(inputNombre / 100) ;
		String str = "";
		if ( innerVal != 0 ) {
			if (innerVal != 1) 
				str = str.concat( BasicNombre.get( innerVal ) );
			str = str.concat(BasicNombre.ColorAnsi[0]+" Cent "+BasicNombre.ColorAnsi[BasicNombre.ColorAnsi.length-1]);
			
		}
		return str ;
	}
	/*
	 * function TensParser : that take integer as Input
	 * 				then generate the string that corresponding 
	 * 				to the Input, finally print the letter
	 *
	 * */
	static String TensParser(short inputNombre) {
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
/*
 * int 2 147 483 647 : 2 milliard => 10^9
 * long 9 223 372 036 854 775 807 : 9 Trillion => 10^18
 * */
