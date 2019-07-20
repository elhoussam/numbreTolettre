
import me.elhoussam.nbtolettre.NumToLet;

import static me.elhoussam.nbtolettre.NumToLet.*;
import me.elhoussam.nbtolettre.GenAr;

public class Main {
	public static void main(String argv[]) throws Exception{
		NumToLet obj ;
		long a = 1 ;
		boolean bool = false ;
		while ( true ) {
		
		a = NumToLet.ScanInput();
		//obj= new GenEn(); 	print("En : "); obj.Generate( a ); print("\n");
		//obj= new GenFr(); 	print("FR : ");	obj.Generate( a ); print("\n");
		obj= new GenAr(); 	print("Ar : ");	String aa = obj.Generate( a ); print("\n");

		print( aa.getBytes() );
		bool = ToggleColor();
		
		}
		
	}
	
}
