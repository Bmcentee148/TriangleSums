import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class TriangleSums {

	private static int[][] cache;
	//private static int testCount = 0;
	public static void main(String [] args) {
		Scanner usrInput = new Scanner(System.in);
		int numLines;
		int[][] triangle;
		int numTestCases = usrInput.nextInt();
		int [] solutions = new int [numTestCases];
		for(int i = 0; i < numTestCases; i++) {
			numLines = usrInput.nextInt();
			usrInput.nextLine();
			triangle = new int[numLines][numLines];
			cache = initCache(numLines);
			for(int row = 0; row < numLines; row++) {
				for(int col = 0; col <= row; col++) {
					triangle[row][col] = usrInput.nextInt();
				}
			}
			solutions[i] = getGreatestSum(triangle); 
		}
		for(int i = 0; i < solutions.length; i++) {
			System.out.println(solutions[i]);
		}
		//System.out.println(testCount);
	}

	public static int getGreatestSum(int[][] sumTriangle) {
		return getGreatestSum(sumTriangle,0,0,sumTriangle.length);
	}

	public static int getGreatestSum(int[][] sumTriangle,int row, int col,int len){
		int t1, t2, t;

		if(row == len) {
			return 0;
		}
		else if(cache[row][col]!= -1){
			//testCount++;
			return cache[row][col];
		}
		else{
			t1 = getGreatestSum(sumTriangle,row+1,col,len);
			t2 = getGreatestSum(sumTriangle,row+1,col+1,len);
			t = Math.max(t1,t2) + sumTriangle[row][col];
			cache[row][col] = t;
			return t;
		}
	}

	private static int[][] initCache(int len) {
		//The grid we need will always be a square
		int [][] r_cache = new int[len][len];
		for(int i = 0; i< len; i++) {
			for(int j = 0; j < len; j++) {
				r_cache[i][j] = -1; //to signify its empty
			}
		}
		return r_cache;
	}//end initCache

}