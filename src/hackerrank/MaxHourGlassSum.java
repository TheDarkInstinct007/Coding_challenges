package hackerrank;

public class MaxHourGlassSum {

	public static void main(String[] args) {
		
		int[][] arr = {								
				{ 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 },
				{ 0, 0, 1, 2, 4, 0 } 
				};
			
		System.out.println(hourglassSum(arr));

	}
	
    static int hourglassSum(int[][] arr) {
        int maxSum=Integer.MIN_VALUE;
        int sum;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=0; j<arr[0].length-2; j++) {
                sum = calculateSumFor(arr, i, j);
                maxSum = sum > maxSum ? sum : maxSum;
            }
        }
        return maxSum;
    }

    static int calculateSumFor(int[][] arr, int startRow, int startCol) {
        int sum=0;
        sum += arr[startRow][startCol]+arr[startRow][startCol+1]+arr[startRow][startCol+2];
        sum += arr[startRow+1][startCol+1];
        sum += arr[startRow+2][startCol]+arr[startRow+2][startCol+1]+arr[startRow+2][startCol+2];
        return sum;
    }

}
