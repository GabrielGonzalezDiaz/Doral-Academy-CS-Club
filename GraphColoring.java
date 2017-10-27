import java.util.Arrays;

public class GraphColoring {

	static int[] colors;
	static int[][] adjMatrix;
	static int maxColors;
	
	public static boolean isSafe(int k, int c){
		for(int i=0; i < adjMatrix.length; i++){
			if(adjMatrix[k][i] == 1 && c == colors[i])
				return false;
			}
		return true;
		}
	
	public static void graphColor(int k){
		for(int c=0; c < maxColors; c++){
			if(isSafe(k,c)){
				colors[k] = c;
				if(k == colors.length-1)
					return;
				else
					graphColor(k+1);
				}
			}
		}
	
	public static void main(String[] args) {
		

		maxColors = 5;
		
		adjMatrix = new int[][]{
					{0,1,0,0,1,0,1,0,0,0},
					{1,0,1,0,0,0,0,1,0,0},
					{0,1,0,1,0,0,0,0,1,0},
					{0,0,1,0,1,0,0,0,0,1},
					{1,0,0,1,0,1,0,0,0,0},
					{0,0,0,0,1,0,1,1,1,1},
					{1,0,0,0,0,1,0,1,1,1},
					{0,1,0,0,0,1,1,0,1,1},
					{0,0,1,0,0,1,1,1,0,1},
					{0,0,0,1,0,1,1,1,1,0}
					};
					
		colors = new int[adjMatrix.length];
		
		Arrays.fill(colors, -1);
					
		graphColor(0);
		
		if(colors[colors.length-1] != -1)
			for(int i=0; i < colors.length; i++)
				System.out.print(colors[i] + " ");	
		else 
			System.out.print("Can't color graph");
		
		
	}

}
