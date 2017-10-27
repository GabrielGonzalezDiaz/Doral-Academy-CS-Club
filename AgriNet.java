import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//solved
public class AgriNet{
	
	public static int prim(int[][] adjMat, int ind, boolean[] checked, int len, ArrayList<Integer> checkList){
		checked[ind] = true;
		checkList.add(ind);
		int index = -1;
		int min = Integer.MAX_VALUE;
		for(int row : checkList){
			for(int c=0; c < checked.length; c++)
				if(!checked[c] && adjMat[row][c] < min){
					index = c;
					min = adjMat[row][c];
					}
			}
		if(index == -1)
			return len;
		return prim(adjMat,index, checked, len+min, checkList);
		}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()){
			int farms = scan.nextInt();
			int[][] adjMatrix = new int[farms][farms];
			
			for(int r=0; r < farms; r++)
				for(int c=0; c < farms; c++)
					adjMatrix[r][c] = scan.nextInt();
			
			//int len = Integer.MAX_VALUE;
			
			/**for(int i=0; i < farms; i++){
				boolean[] checked = new boolean[farms];
				Arrays.fill(checked, false);
				int curr = prim(adjMatrix, i, checked, 0, new ArrayList<Integer>());
				System.out.println(curr);
				len = Math.min(len, curr);
				}*/
			boolean[] checked = new boolean[farms];
			Arrays.fill(checked, false);
			int len = prim(adjMatrix, 0, checked, 0, new ArrayList<Integer>());
			System.out.println(len);
			
			}
		
		scan.close();

		}

	}


