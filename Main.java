import java.util.Scanner;
import static me.elhoussam.nbtolettre.NumbreToLettre.*;

public class Main {
	public static void main(String argv[]) throws Exception{
		@SuppressWarnings("resource")
		Scanner sc  = new Scanner(System.in);
		
		long a = 1 ;
		while ( a >= 0) {
						
		print("Hat Ra9mek : ");
		 a = sc.nextLong() ;
		Generate( a );
		//sc.close();
		print("\n");
		}
		print ("End.\n");
		
	}
	
}
