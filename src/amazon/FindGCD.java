package amazon;

public class FindGCD {

	public static void main(String[] args) {
		
		int[] arr = {2,4,6,10,8};
		
		System.out.println(generalizedGCD(5,arr));

	}
	
    public static int generalizedGCD(int num, int[] arr)
    {
        if(arr.length==1)
    		return arr[0];
    	
    	int gcd = findGcd(arr[0],arr[1]);
    	
    	for(int i=2; i<arr.length;i++)
    	{
    		gcd = findGcd(arr[i],gcd);
    	}
    	
    	return gcd;
    }
    
    public static int findGcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return findGcd(b%a, a); 
    } 

}
