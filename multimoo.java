import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class node implements Comparable< node >{
	int id;
	int area;
	HashSet< String > inside = new HashSet< String >();
	HashSet< node > adj = new HashSet< node >();
	public node( int i, int a ) {
		id = i;
		area = a;
		}
	
	public String toString() {
		return "Map " + id + " Area: " + area;
		}

	
	public int compareTo( node o ) {
		return -( area - o.area );
		}
	
	}

public class multimoo {

	static int largest = 0;
	static int curr = 0;
	static int[] R = { 1, 0, -1 , 0 };
	static int[] C = { 0, 1, 0 , -1 };
	static int size;
	static boolean[][] visited;
	
	
	static HashMap<String, node> cellToNodes = new HashMap<String, node>();;
	
	public static boolean inBound(int r, int c, int s) {
		return r > -1 && c > -1 && r < s && c < s;
		}
	
	public static void flood(int[][] map, int r, int c, int n, node k) {
		if(map[r][c] == n) {
			cellToNodes.put(r + " " + c, k);
			k.inside.add(r + " " + c);
			visited[r][c] = true;
			curr++;
			for(int i=0; i < 4; i++)
				if(inBound(r + R[i], c + C[i], map.length) && !visited[r+R[i]][c+C[i]])
					flood(map,r+R[i],c+C[i], n,k);
			}
		}
	
	public static void connect(node a, node b) {
		a.adj.add(b);
		b.adj.add(a);
		}
	
	public static void main(String[] args) throws IOException {

		File infile = new File("multimoo.in");
		Scanner scan = new Scanner(infile);

		File outfile = new File("multimoo.out");
		PrintWriter write = null;
		try
			{
			write = new PrintWriter(outfile);
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		
		size = scan.nextInt();
		
	
		
		HashMap<Integer, Integer> cells = new HashMap<Integer, Integer>();
		
		int[][] map = new int[size][size];
		for(int r=0; r < size; r++) {
			for(int c=0; c < size; c++) {
				int n = scan.nextInt();
				if(cells.containsKey(n))
					cells.put(n, cells.get(n)+1);
				else
					cells.put(n, 1);
				map[r][c] = n;
				}
			}
		
		visited = new boolean[size][size];
		
		
		
		ArrayList<node> nodes = new ArrayList<node>();
		
		for(int r=0; r < size; r++) {
			for(int c=0; c < size; c++) {
				if(!visited[r][c]) {
					visited[r][c] = true;
					node n = new node(map[r][c], curr);
					flood(map,r,c,map[r][c], n);
					largest = Math.max(largest, curr);
					n.area = curr;
					nodes.add(n);
					curr = 0;
					}
				}
			}
		
		for(node n : nodes) {
			for(String s : n.inside) {
				String[] ind = s.split(" ");
				int r = Integer.valueOf(ind[0]);
				int c = Integer.valueOf(ind[1]);
				for(int i=0; i < 4; i++)
					if(inBound(r + R[i], c + C[i], map.length) && map[r][c] != map[r+R[i]][c+C[i]])
						connect(n, cellToNodes.get((r+R[i]) + " " + (c+C[i])));
				
				}	
			}
		
		
	
		
		int Dlargest = 0;
		Collections.sort(nodes);
		
		for(int i=0; i < nodes.size(); i++)
			loop : for(node y : nodes.get(i).adj) {
				node x = nodes.get(i);
				if(Dlargest >= cells.get(x.id) + cells.get(y.id))
					continue loop;
				int currA = 0;
				ArrayList<node> q = new ArrayList<node>();
				HashSet<node> visited = new HashSet<node>();
				q.add(x);
				visited.add(x);
				while(!q.isEmpty()) {
					node n = q.remove(0);
					currA += n.area;
					for(node o : n.adj)
						if(!visited.contains(o) && (o.id == x.id || o.id == y.id)) {
							visited.add(o);
							q.add(o);
							}
					}
				Dlargest = Math.max(Dlargest, currA);
				}

		
		write.println(largest);
		write.println(Dlargest);
		
		
		write.close();
		scan.close();
		}	

	}
