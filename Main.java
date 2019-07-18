import me.elhoussam.nbtolettre.GenFr;
import me.elhoussam.nbtolettre.GenEn;
import me.elhoussam.nbtolettre.NumToLet;
import static me.elhoussam.nbtolettre.NumToLet.*;

public class Main {
	public static void main(String argv[]) throws Exception{
		NumToLet obj ;
		long a = 1 ;
		while ( a >= 0) {
		
		a = NumToLet.ScanInput();
		obj= new GenEn(); 	print("En : "); obj.Generate( a ); print("\n");
		obj= new GenFr(); 	print("FR : ");	obj.Generate( a ); print("\n");
		//sc.close();
		ToggleColor();
		print("\n");
		}
		print ("End.\n");
		
	}
	
}
