
import static me.elhoussam.nbtolettre.NumToLet.print;

import me.elhoussam.nbtolettre.GenAr;
import me.elhoussam.nbtolettre.GenEn;
import me.elhoussam.nbtolettre.GenFr;
import me.elhoussam.nbtolettre.NumToLet;

public class Main {
	public static void main(String argv[]) throws Exception{
		NumToLet obj ;
		long a = 1 ;
		boolean bool = false ;
		while ( true ) {
		String aa = "";
		a = NumToLet.ScanInput();
		obj= new GenEn(); 	print("En : ");  aa =obj.Generate( a ); print("\n");
		obj= new GenFr(); 	print("FR : ");	aa =obj.Generate( a ); print("\n");
		obj= new GenAr(); 	print("Ar : ");	aa = obj.Generate( a ); print("\n");
		aa = aa.trim() ;
		
		
		}
		
	}
	
}
