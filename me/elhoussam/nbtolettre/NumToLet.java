package me.elhoussam.nbtolettre;
public abstract class NumToLet {
	protected Boolean Color = false;
	public void ToggleColor() {
		Color = ! Color ;
	}

	// Print function that simply print str in the console
	public static void print( Object obj ) {
		System.out.print( obj );
	}
	/*
	 * inner class NB : that store the Nombre with it scale 
	 * */
	protected class NB{
		short nb; // short
		String str ;
		public NB(short a/*short*/, String b) {
			this.nb=a; this.str =b;
		}
	}
	/*
	 * Generate Function : start devide the number and store into
	 * 	smaller pieces with it scale int NB's Objects
	 * 
	 * */
	
	public abstract void Generate(long InputNombre);
	
	protected enum BasicNombre {
		Zero( (byte)0,"Zéro"),
		One((byte)1,"Un"),
		Two((byte)0,"Deux"), Three((byte)0,"Trois"), 
		Four((byte)0,"Quatre"), Five((byte)0,"Cinq"),
		Six((byte)0,"Six"), Seven((byte)0,"Sept"), 
		Eight((byte)0,"Huit"), Nine((byte)0,"Neuf"), 
		Ten((byte)0,"Dix"), Eleven((byte)0,"Onze"), 
		Tweleve((byte)0,"Douze"),Thirteen((byte)0,"Treize"), 
		Fourteen((byte)0,"Quatorze"), Fiveteen((byte)0,"Quinze"), 
		Sixteen((byte)0,"Seize"), Seventeen((byte)0,"Dix-Sept"),
		Eightteen((byte)18,"Dix-Huit"), Nineteen((byte)0,"Dix-Neuf"), 
		Twenty((byte)20,"Vingt"), Thirty((byte)30,"Trente"),
		Forty((byte)40,"Quarante"), Fifty((byte)50,"Cinquante"), 
		Sixty((byte)60,"Soixante"), Seventy((byte)80,"Quatre Vingt"),
		Eightty((byte)60,"Soixante"), Ninety((byte)80,"Quatre Vingt");
		private String lettre ;
		static String ScaleNombre[]
				={""," Mille"," Million"," Milliard", //10^3 >- 0, 10^6 >- 1 ,10^9>-2
			 " Billion"," Billiard"," Trillion", " Trilliard"}; 
		 //10^12>-3, 10^15>-4, 10^18>-5, 10^21>-6 
		static String ColorAnsi[]
				= {"\u001B[31m","\u001B[32m","\u001B[33m",
				"\u001B[34m","\u001B[35m","\u001B[36m","\u001B[38m","\u001B[0m" };
			
			BasicNombre(byte nbr, String ltr){
			this.lettre = ltr;
			}
		static String get(byte i) {
				String nbr = "";
				switch( i ) {
				case 0 : nbr =  BasicNombre.Zero.lettre;  break;
				case 1 : nbr =  BasicNombre.One.lettre;  break;
				case 2 : nbr =  BasicNombre.Two .lettre; break;
				case 3 : nbr =  BasicNombre.Three.lettre; break;
				case 4 : nbr =  BasicNombre.Four.lettre; break;
				case 5 : nbr =  BasicNombre.Five.lettre; break;
				case 6 : nbr =  BasicNombre.Six.lettre; break;
				case 7 : nbr =  BasicNombre.Seven.lettre; break;
				case 8 : nbr =  BasicNombre.Eight.lettre; break;
				case 9 : nbr =  BasicNombre.Nine.lettre; break;
				case 10 : nbr =  BasicNombre.Ten.lettre; break;
				case 11 : nbr =  BasicNombre.Eleven.lettre; break;
				case 12 : nbr =  BasicNombre.Tweleve.lettre; break;
				case 13 : nbr =  BasicNombre.Thirteen.lettre; break;
				case 14 : nbr =  BasicNombre.Fourteen.lettre; break;
				case 15 : nbr =  BasicNombre.Fiveteen.lettre; break;
				case 16 : nbr =  BasicNombre.Sixteen.lettre; break;
				case 17 : nbr =  BasicNombre.Seventeen.lettre; break;
				case 18 : nbr =  BasicNombre.Eightteen.lettre; break;
				case 19 : nbr =  BasicNombre.Nineteen.lettre; break;
				case 20 : nbr =  BasicNombre.Twenty.lettre; break;
				case 30 : nbr =  BasicNombre.Thirty.lettre; break;
				case 40 : nbr =  BasicNombre.Forty.lettre; break;
				case 50 : nbr =  BasicNombre.Fifty.lettre; break;
				case 60 : nbr =  BasicNombre.Sixty.lettre; break;
				case 80 : nbr =  BasicNombre.Eightty.lettre ; break;
				
				}
				return nbr;
			}
		}
}
/*
 * int 2 147 483 647 : 2 milliard => 10^9
 * long 9 223 372 036 854 775 807 : 9 Trillion => 10^18
 * */
