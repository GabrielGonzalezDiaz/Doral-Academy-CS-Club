import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

class TNode {
	HashSet< TNode > connections = new HashSet< TNode >();
	String name;
	boolean visited = false;
	
	public TNode( String n ) {
		name = n;
		}
	
	public String toString() {
		return name + " ";
		}
	
	}

public class TopologicaSort {

	public static ArrayList< TNode > DFS(TNode n) {
		Stack <TNode> stack = new Stack< TNode >();
		ArrayList< TNode > list = new ArrayList< TNode >();
		stack.push(n);
		loop : while(stack.size() > 0) {
			TNode k = stack.peek();
			k.visited = true;
			for( TNode l : k.connections) {
				if(!l.visited) {
					stack.push(l);
					continue loop;
					}
				}
			list.add(stack.pop());
			//System.out.println("POPPED!");
			}
		return list;
		}
	
	public static ArrayList< TNode > TopSort(ArrayList< TNode > list) {
		
		ArrayList< TNode > sorted = new ArrayList< TNode >();
		
		for(TNode n : list) {
			if(!n.visited) {
				ArrayList< TNode > dfs = DFS(n);
				for(TNode k : dfs) {
					sorted.add(k);
					}
				}
			}
		
		return sorted;
		
		}
	
	public static void connect(TNode a, TNode b) {
		a.connections.add(b);
		}
	
	public static void main( String[] args ) {
		
		TNode a = new TNode("A");
		TNode b = new TNode("B");
		TNode c = new TNode("C");
		TNode d = new TNode("D");
		TNode e = new TNode("E");
		TNode f = new TNode("F");
		TNode g = new TNode("G");
		TNode h = new TNode("H");
		TNode i = new TNode("I");
		TNode j = new TNode("J");
		TNode k = new TNode("K");
		TNode l = new TNode("L");
		TNode m = new TNode("M");
		
		
		connect(c,a);
		connect(c,b);
		connect(b,d);
		connect(a,d);
		connect(d,g);
		connect(e,a);
		connect(e,d);
		connect(d,h);
		connect(g,i);
		connect(e,f);
		connect(f,k);
		connect(f,j);
		connect(h,j);
		connect(h,i);
		connect(k,j);
		connect(j,m);
		connect(i,l);
		connect(j,l);
		
		ArrayList< TNode > list = new ArrayList< TNode >();
		
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);
		list.add(h);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		
		ArrayList<TNode> sorted = TopSort(list);
		Collections.reverse(sorted);
		System.out.println(sorted);
		

		}

	}
