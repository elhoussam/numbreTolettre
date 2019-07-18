package me.elhoussam.nbtolettre;

import java.util.Hashtable;
import java.util.Scanner;

public abstract class NumToLet {
	static Boolean Color = false;
	static String space = " ";
	protected String link;
	protected Hashtable<Integer, String> BasicNumber = null; 
	protected String ScaleNombre[]		= null ;
	static String ColorAnsi[]= {"\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[38m","\u001B[0m" };
	@SuppressWarnings("unchecked")
	protected void Init( Hashtable<Integer, String> ht, String scalenombre[], String Link) {
		BasicNumber = (Hashtable<Integer, String>) ht.clone();
		ScaleNombre = scalenombre.clone() ;
		link = Link.toString();
	}	
	public static Long ScanInput() {
		Scanner sc  = new Scanner(System.in);
		Long a = 0L ; Boolean checker= false ;
		while( !checker ) {
			try{print("# Number : "); a = sc.nextLong() ; 
			checker=(a<0)?false:true;
			print((!checker)?ColorAnsi[0]+"\tshould be greater then or equal zero\n"+ColorAnsi[ColorAnsi.length-1]:"" );
			}catch(Exception e ){ sc.next(); print(ColorAnsi[3]+"\tthis number is too long\n"+ColorAnsi[ColorAnsi.length-1]);	}
		}
		return a;
	}
	protected String get(byte i) {
		String s = BasicNumber.get((int) i );
		return s ;
	}
	
	public static void ToggleColor() {
		Color = ! Color ;
	}
	// Print function that simply print str in the console
	public static void print( Object obj ) {
		System.out.print( obj );
	}
	/*
	 * inner class NB : that store the Nombre with it scale 
	 * */
	class NB{
		short nb; // number under 999 
		String str ; // scale hundred million, milliard .....
		public NB(short a/*short*/, String b) {
			this.nb=a; this.str =b;
		}

	}
	/*
	 * Generate Function : start devide the number and store into
	 * 	smaller pieces with it scale int NB's Objects
	 * 
	 * */
	public void Generate(long InputNombre){
		long innerVal =  InputNombre ; 
		byte i=0, counter =0;
		String innerStr = "";
		// the 1st part dividing the number and store it in NB 
		while ( innerVal > 0 ) {
			short localvar = (short) (innerVal % 1000) ;
			if ( localvar > 0 ){
				// parsing the differente part of the numbre
				NB o = new NB(localvar,
			    	((Color)?ColorAnsi[i]:"").concat( 
			    	ScaleNombre[i]).concat(
			    	(Color)?ColorAnsi[ColorAnsi.length-1]:"") 
			    	); 
			    // constructing part of the numbre
				String localstr="";
				if ( counter > 0 )
					localstr = this.link ; // if en => and , fr => et
					innerStr = (
							((o.nb==1 && o.str.contains(ScaleNombre[1]))?"":BasicParser(o.nb)+space ) // to prevent the one hundred, On Thousand
							.concat( o.str )+space +localstr+space+innerStr);
					counter++;
			}i++;
			innerVal = innerVal / 1000;
		}
		// print the result 
		print( (InputNombre != 0)? innerStr : TensParser( (short) innerVal ) );
	}
	protected abstract String BasicParser( short inputNombre );
	protected abstract String TensParser(short inputNombre);
	protected abstract String HundredParser(short inputNombre);	
}
/*
 * int 2 147 483 647 : 2 milliard => 10^9
 * long 9 223 372 036 854 775 807 : 9 Trillion => 10^18
 * */
