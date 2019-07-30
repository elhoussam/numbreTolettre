package me.elhoussam.nbtolettre;

import java.util.Hashtable;
import java.util.Vector;

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
		htbl.put(60, "ستون"); htbl.put(70, "سبعون");  
		htbl.put(90, "تسعون"); htbl.put(80, "ثمانون");  
		String ScNombre [] = {"","آلف","مليون","مليار", "بليون","بليار","ترليون", "ترليار"}; 
	
		Init(htbl, ScNombre,"و");
	}
	/*
	 * 
	 * */
	protected String Constructor(Vector<NB> InputVec) {
		//print("GenAr : Constructor\n");
		String mystr = "";
		for(byte i=0; i < InputVec.size() ; i++) {
			String localstr="";
			NB o = InputVec.get(i) ;
			if ( !o.str.equals("") ) {
				localstr = this.link ; // if en => and , fr => et
				if( o.nb == 2 ) o.str = o.str.concat("ان");
				else if( o.nb == 10 ) {
					//o.str = ()	"" , 
					String arr [] = {"","آلاف","ملايين","ملايير", "بلايين","بلايير","ترليونات", "ترليارات"};
					// this.setScale(arr  ) ;
					byte localIndex = (IndexOf(ScaleNombre,o.str));
					
					o.str =(localIndex!=-1)?arr[ localIndex ]:o.str;
						
					 // this statment does not affect the result because 
					 // the o.str aready has value from the last scale
				}
			}	
			mystr =	 (!mystr.isEmpty())?(localstr+space).concat(mystr):"";
			mystr =	 ((o.str)+space).concat(mystr) ;
			mystr = (( !o.str.equals("") && (o.nb == 1 || o.nb == 2 ))?
					"":BasicParser(o.nb)+space ).concat(mystr) ; // to prevent the one hundred, On Thousand
			
		}
		return mystr;
	}
	private byte IndexOf( String arr[],String val) {
		String local = val; // insert code here
		byte index = -1;
				for (byte i=0;i<arr.length;i++) {
				    if (arr[i].equals(local)) {
				        index = i;
				        break;
				    }
				}
		return index ;
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
			innerStr = innerStr.concat(TensParser( innerValue  ) );
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
			if (innerVal != 1 && innerVal !=2) // innerVal > 2 
				str = str.concat( get( innerVal )+space );
			
			String localstr = "مئتان";	// handler of 200
			if(innerVal != 2) localstr =  "مائة";
			str = str.concat(
					((Color)?ColorAnsi[0]:"")
					.concat(localstr+space)
					.concat((inputNombre%100>0)?link+space:"" ) 
					.concat((Color)?ColorAnsi[ColorAnsi.length-1]:""));
			
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
			str = str.concat( get( innerVal )+space );
		// Second Sénario 
		}else if ( (innerVal>=21 && innerVal<= 99)) {
			unit = (byte) (innerVal % 10) ;
			innerVal = (byte) (innerVal - unit) ;
			if( unit != 0 ) {
				str = str.concat( get( unit )+space );

				str = str.concat(link+space);
			}
			str = str.concat( get( innerVal )+space );

		}
		return str ;
	}
	
	public static boolean ToggleColor() {
		//Color = ! Color ;
		print("Toggle Color is not support with arabic generator\n");
		return Color ;
	}

}
