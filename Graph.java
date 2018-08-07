import java.util.ArrayList;
import java.util.Scanner;

class Cow {
	int id;
	ArrayList<Cow> friends = new ArrayList<Cow>();
	
	public Cow(int id) {
		this.id = id;
		}
	
	}

public class Graph {

	public static void connect(Cow[] arr, int a, int b) {
		arr[a].friends.add(arr[b]);
		arr[b].friends.add(arr[a]);
		}
	
	public static boolean checkConnections(Cow[] cows, int a, int b) {
		if(cows[a].friends.contains(cows[b]))
			return false;
		ArrayList<Cow> q = new ArrayList<Cow>();
		ArrayList<Cow> visited = new ArrayList<Cow>();
		q.add(cows[a]);
		visited.add(cows[a]);
		while(!q.isEmpty()) {
			Cow curr = q.remove(0);
			visited.add(curr);
			if(curr.id == cows[b].id)
				return true;
			for(Cow c : curr.friends) {
				if(!visited.contains(c)) {
					q.add(c);
					visited.add(c);
					}
				}
			}
		return false;
		}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		Cow[] cows = new Cow[n];
		
		for(int i=0; i < n; i++)
			cows[i] = new Cow(i);
		
		int connections = scan.nextInt();
		while(connections --> 0) 
			connect(cows, scan.nextInt(), scan.nextInt());
		
		int checks = scan.nextInt();
			
		while(checks --> 0) {
			if(checkConnections(cows, scan.nextInt(), scan.nextInt()))
				System.out.println("Ya like Jazz?");
			else
				System.out.println("No new Friends");
			}
		
		scan.close();

	}

}
