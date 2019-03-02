package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightHouses {

	public static void main(String[] args) {

		int[] states = {1,0,0,0,0,1,0,0};
		List<Integer> list = cellCompete(states,1);
		for(Integer i: list)
			System.out.println(i);

	}
	
	public static List<Integer> cellCompete(int[] states, int days)
    {

        if(states==null)
            return null;

        int[] origValues = new int[states.length];
        
        System.arraycopy( states, 0, origValues, 0, states.length );
        
        for(int d=0; d<days; d++) 
        {
        	if(origValues[1]==0)
				states[0] = 0;
			else
			    states[0] = 1;
			
			if(origValues[states.length-2]==0)
				states[states.length-1] = 0;
			else
			    states[states.length-1] = 1;
			
			for(int x=1; x<=states.length-2; x++)
			{
				if(origValues[x-1]==origValues[x+1])
					states[x]=0;
				else
					states[x]=1;
			}
			
			System.arraycopy( states, 0, origValues, 0, states.length );
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int a: states)
        	result.add((Integer)a);
        
        return result;
        
    }

}
