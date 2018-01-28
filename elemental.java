import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Node {
	String val;
	HashSet<Node> adj = new HashSet<Node>();
	
	public Node(String s){
		val = s;
		}
	}

public class elemental {

	static boolean combinatioFound = false;
	
	public static void DFS(String curr, String goal, Node s){
		curr += s.val;
		if(curr.equals(goal)){	
			combinatioFound = true;;
			return;
			}
		for(Node n : s.adj){
			if(goal.contains(curr + n.val))
				DFS(curr, goal, n);
			}
		}
	
	public static boolean canCons(String s, ArrayList<Node> nodes){
		for(Node n : nodes){
			DFS("", s, n);
			if(combinatioFound){
				combinatioFound = false;
				return true;
				}
			}
		return false;
		}
	
	public static void main(String[] args) throws IOException {

		File infile = new File("elemental.in");
		Scanner scan = new Scanner(infile);
		
		int counter = 1;
		boolean first = true;
		while(true){
			int atoms = scan.nextInt();
			if(atoms == 0)
				break;
			scan.nextLine();
			
			ArrayList<Node> nodes = new ArrayList<Node>();
			
			for(int i=0; i < atoms; i++)
				nodes.add(new Node(scan.next()));
			
			scan.nextLine();
			
			
			String s = scan.nextLine();
			String[] sen = s.split(" ");
			
			for(Node n : nodes){
				for(Node j : nodes){
					if(s.contains(n.val + j.val))
						n.adj.add(j);
					}
				}
			boolean elem = true;
			
			for(int i=0; i < sen.length; i++){
				if(!canCons(sen[i], nodes)){
					elem = false;
					break;
					}
				}
			
			if(first)
				first = false;
			else
				System.out.println();
			
			if(elem)
				System.out.println("Phrase #" + counter + ": Elemental");
			else
				System.out.println("Phrase #" + counter + ": Not Elemental");
			counter++;
			
			}
		
		scan.close();
		
		}
	
	}
