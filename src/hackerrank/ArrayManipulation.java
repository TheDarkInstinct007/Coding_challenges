package hackerrank;

//Link: https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) 
    {

        int[] diffWithPrev = new int[n+1];
        
        int start, end, val;
        for(int i=0; i<queries.length; i++)
        {
            start=queries[i][0];
            end=queries[i][1];
            val=queries[i][2];
            
            diffWithPrev[start] += val;
            if(end<n)
                diffWithPrev[end+1] -= val;                    
        }
        
        long max=0, curSum=0;
        for(int i : diffWithPrev)
        {
            curSum+=i;
            max = max < curSum ? curSum : max;            
        }
        
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        /*      String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }		*/
    	
    	int n=10;
    	int[][] queries = {{1,5,3},{4,8,7},{6,9,1}};

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
