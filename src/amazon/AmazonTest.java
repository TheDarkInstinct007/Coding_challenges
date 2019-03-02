package amazon;

import java.util.ArrayList;
import java.util.List;

// Find the closest K destinations from the source(0,0) given a list of N destinations.

public class AmazonTest {

	public static void main(String[] args) {
		
		List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(4);
				
		List<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(-1);

		allLocations.add(a);
		allLocations.add(b);
		allLocations.add(c);
		
		List<List<Integer>> result = ClosestXdestinations(3, allLocations, 2);
		
		for(List<Integer> l : result)
		{
			for(Integer i : l)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
	
	static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries)
	{
		int curSum;
		
		for(int i=0; i<allLocations.size(); i++)
		{			
			curSum = Math.abs(allLocations.get(i).get(0)) + Math.abs(allLocations.get(i).get(1));
			allLocations.get(i).add(curSum);
		}
		
		
		//Selection sort
		
        int n = allLocations.size(); 
        int tempX, tempY, tempSum;
        
        
        for (int i = 0; i < numDeliveries; i++) 		//Not sure if -1 is required
        {  
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
            	if(allLocations.get(j).get(2) < allLocations.get(min_idx).get(2))
                    min_idx = j; 
            
            tempX=allLocations.get(min_idx).get(0);
            tempY=allLocations.get(min_idx).get(1);
            tempSum=allLocations.get(min_idx).get(2);
            
            allLocations.get(min_idx).set(0, allLocations.get(i).get(0));
            allLocations.get(min_idx).set(1, allLocations.get(i).get(1));
            allLocations.get(min_idx).set(2, allLocations.get(i).get(2));
            
            allLocations.get(i).set(0, tempX);
            allLocations.get(i).set(1, tempY);
            allLocations.get(i).set(2, tempSum);            
            
        } 
		
        List<Integer> temp;
        List<List<Integer>> result = new ArrayList<List<Integer>>();		
		for(int i=0; i<numDeliveries; i++)
		{
			temp = new ArrayList<Integer>();
			temp.add(allLocations.get(i).get(0));
			temp.add(allLocations.get(i).get(1));
			result.add(temp);
		}
		
		return result;
	}

}
