package amazon_onsite_practice;

//Find length of the largest region in Boolean Matrix
//https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/

public class LargestRegionInMatrix
{
	public static void main(String[] args)
	{
		int[][] mat = {
				{0, 0, 1, 1, 0},
                   		{1, 0, 1, 1, 0},
                   		{0, 1, 0, 0, 0},
                  		{0, 0, 0, 0, 1}
				};

		System.out.println(getMaxArea(mat));
	}

	public static long getMaxArea(int[][] mat)
	{
		if(mat==null || mat.length==0)
			return 0;

		long maxArea = 0, area;
		boolean visited[][] = new boolean[mat.length][mat[0].length];

		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[0].length; j++)
			{
				if(mat[i][j]==1 && !visited[i][j])
				{
					visited[i][j] = true;
					area = getArea(i,j,visited, mat);
					maxArea = area > maxArea ? area : maxArea;
				}
			}
		}
		return maxArea;
	}

	public static long getArea(int i, int j, boolean[][] visited, int[][] mat)
	{
		long totArea = 1;
		//Insted of writing 8 if else blocks, do this
		int[] rowOffetsToCheck = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] colOffetsToCheck = {-1, 0, 1, -1, 1, -1, 0, 1};
		int curI, curJ;

		for(int k=0; k<8; k++)
		{
			curI = i + rowOffetsToCheck[k];
			curJ = j + colOffetsToCheck[k];
			if(isValid(curI, curJ, visited, mat))
			{
				visited[curI][curJ] = true;
				totArea += getArea(curI, curJ, visited, mat);
			}
		}

		return totArea;
	}

	public static boolean isValid(int i, int j, boolean[][] visited, int[][] mat)
	{
		return (i>=0 && i<visited.length && j>=0 && j<mat[0].length && !visited[i][j] && mat[i][j]==1);
	}
}
		
		