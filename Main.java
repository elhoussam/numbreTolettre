import java.util.Scanner;
import me.elhoussam.nbtolettre.NumbreToLettre;

public class Main {
	public static void main(String argv[]) throws Exception{
		@SuppressWarnings("resource")
		Scanner sc  = new Scanner(System.in);
		NumbreToLettre obj = new NumbreToLettre();
		long a = 1 ;
		while ( a >= 0) {
						
		obj.print("Number : ");
		 a = sc.nextLong() ;
		 obj.Generate( a );
		//sc.close();
		 obj.ToggleColor();
		 obj.print("\n");
		}
		obj.print ("End.\n");
		
	}
	
}
