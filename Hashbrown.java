import java.util.HashMap;
import java.util.Scanner;


public class Hashbrown {

	public static void main(String[] args) {
		
		HashMap<String, Integer> APCSA_Scores = new HashMap<String, Integer>();
		
		APCSA_Scores.put("Pedro",5);
		APCSA_Scores.put("Gabriel",5);
		APCSA_Scores.put("Evan",5);
		APCSA_Scores.put("Prof",6);
		APCSA_Scores.put("Goober",1);
		APCSA_Scores.put("Chris Bosh",3);
		APCSA_Scores.put("Sam Koski",2);
		
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
		if(APCSA_Scores.containsKey("pEdRo"))
			System.out.println("pEdRo took the test");
		else
			System.out.println("pEdRo did NOT show up for the test");
			
		scan.nextLine();
		
		if(APCSA_Scores.get("Gabriel") >= 3)
			System.out.println("Gabriel passed!");
		else
			System.out.println("Gabriel is a goober!");
		
		scan.nextLine();
		
		for(String k : APCSA_Scores.keySet())
			System.out.println(k + " got a: " + APCSA_Scores.get(k));
		
		scan.nextLine();
		
		if(APCSA_Scores.get("Koski") >= 3)
			System.out.println("Koski passed!");
		else
			System.out.println("Koski is a goober!");
		
		}

	}
