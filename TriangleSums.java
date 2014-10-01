import java.util.Scanner;

class TriangleSums {

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
			t1 = getGreatestSum(sumTriangle,row+1,col,len);
			t2 = getGreatestSum(sumTriangle,row+1,col+1,len);
			t = Math.max(t1,t2) + sumTriangle[row][col];
			return t;
		}
	}
}