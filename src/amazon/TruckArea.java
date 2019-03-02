package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Find the distance a truck has to travel to reach the destination from source.
// https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/

public class TruckArea {

	public static void main(String[] args) {

		List<List<Integer>> area = new ArrayList<List<Integer>>();
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(0);
		a.add(0);
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(0);
		b.add(0);
				
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(9);
		c.add(1);

		area.add(a);
		area.add(b);
		area.add(c);
		
		for(List<Integer> l : area)
		{
			for(Integer i : l)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		System.out.println(minimumDistance(3,3,area));

	}
	
    static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>(); 
        ArrayList<Integer> src = new ArrayList<Integer>();
        src.add(0);
        src.add(0);
        src.add(0);	//distance
        q.add(src);
        
        int row, column, value, disance;
        
        while (!q.isEmpty()) 
        { 
        	ArrayList<Integer> item = q.remove(); 
        	
        	row = item.get(0);
        	column = item.get(1);
        	disance = item.get(2);
        	value = area.get(row).get(column);
        	
        	if(value==9)
        		return disance;
        	
        	//area.get(row).set(column, 2);
        	
        	if(row-1 >=0 && area.get(row-1).get(column)!=0)
        	{
                src = new ArrayList<Integer>();
                src.add(row-1);
                src.add(column);
                src.add(disance+1);	//distance
                q.add(src);
        	}
        	
        	if(row+1 < area.size() && area.get(row+1).get(column)!=0)
        	{
                src = new ArrayList<Integer>();
                src.add(row+1);
                src.add(column);
                src.add(disance+1);	//distance
                q.add(src);
        	}
        	
        	if(column-1 >=0 && area.get(row).get(column-1)!=0)
        	{
                src = new ArrayList<Integer>();
                src.add(row);
                src.add(column-1);
                src.add(disance+1);	//distance
                q.add(src);
        	}
        	
        	if(column+1 < numColumns && area.get(row).get(column+1)!=0)
        	{
                src = new ArrayList<Integer>();
                src.add(row);
                src.add(column+1);
                src.add(disance+1);	//distance
                q.add(src);
        	}
        		

        }
                
        return -1;
    	
    	
    }

}
