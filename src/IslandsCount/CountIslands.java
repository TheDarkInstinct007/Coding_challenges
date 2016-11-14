package IslandsCount;

import java.util.Scanner;
import java.util.Stack;

public class CountIslands {

	static int[][] region;
	static boolean[][] visited;
	static int count, maxI, maxJ;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of rows : ");
		maxI= scanner.nextInt();
		
		System.out.print("Enter number of columns : ");
		maxJ= scanner.nextInt();
				
		region = new int[maxI][maxJ];
		visited = new boolean[maxI][maxJ];
		
		System.out.println("Enter the data : ");
		for(int i=0; i<maxI; i++)
			for(int j=0; j<maxJ; j++)
				region[i][j]=scanner.nextInt();

		count=0;

		for(int i=0;i<maxI;i++)
		{
			for(int j=0;j<maxI;j++)
			{
				if(region[i][j]==1 && visited[i][j]==false)
				{					
					visit(i,j);
					count += 1;
				}
			}
		}
		
		System.out.println("Number of islands : " + count);

	}

	private static void visit(int i, int j)
	{
		visited[i][j]=true;

		if(i!=0 && region[i-1][j]==1 && visited[i-1][j]==false)
		{
			visit(i-1,j);
		}

		if(j<maxJ-1 && region[i][j+1]==1 && visited[i][j+1]==false)
		{
			visit(i,j+1);
		}

		if(i<maxI-1 && region[i+1][j]==1 && visited[i+1][j]==false)
		{
			visit(i+1,j);
		}

		if(j!=0 && region[i][j-1]==1 && visited[i][j-1]==false)
		{
			visit(i,j-1);
		}
		
	}

}
