import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class TriangleSums {
	//private static int[][] cellTable;
	//private static Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
	private static int[][] cacheTable;
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
			//cellTable = generateKeyTable(numLines,numLines);
			cacheTable = initCache(numLines,numLines);
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

	}

	public static int getGreatestSum(int[][] sumTriangle) {
		return getGreatestSum(sumTriangle,0,0,sumTriangle.length);
	}

	public static int getGreatestSum(int[][] sumTriangle,int row, int col,int len){
		int t1, t2, t;

		if(row == len) {
			return 0;
		}
		else{
			if(cacheTable[row+1][col] != -1){
				t1 = cacheTable[row+1][col];
			}
			else{
			t1 = getGreatestSum(sumTriangle,row+1,col,len);
			}
			if(cacheTable[row+1][col+1] != -1){
				t2 = cacheTable[row+1][col+1];
			}
			else{
				t2 = getGreatestSum(sumTriangle,row+1,col+1,len);
			}
			t = Math.max(t1,t2) + sumTriangle[row][col];
			cacheTable[row][col] = t;
			return t;
		}
	}

	// public static int[][] generateKeyTable(int row,int col) {
	// 	int[][] keyTable = new int[row][col];
	// 	int currKey = 1
	// 	for(int i = 0; i< row; i++) {
	// 		for(int j = 0; j < col; j++) {
	// 			keyTable[i][j] = currKey;
	// 			currKey++;
	// 		}
	// 	}
	// 	return keyTable;
	// }

	public static int[][] initCache(int row,int col) {
		int[][] cache = new int[row][col];
		for(int i = 0; i< row; i++) {
			for(int j = 0; j < col; j++) {
				cache[i][j] = -1;
			}
		}
		return cache;
	}
}