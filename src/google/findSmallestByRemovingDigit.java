package google;
import java.util.Scanner;

public class findSmallestByRemovingDigit {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number :");
		int val = scanner.nextInt();

		System.out.println("Smallest number using method1 is : "+method1(val));
		System.out.println("Smallest number using method2 is : "+method2(val));
	}
	
	private static int method1(int x)
	{
		int min=Integer.MAX_VALUE;
		StringBuilder strnum = new StringBuilder(String.valueOf(x));		
		
		for(int i=0; i<strnum.length()-1; i++)
		{			
			if(strnum.charAt(i) > strnum.charAt(i+1))
				min = Math.min(min, Integer.parseInt(strnum.deleteCharAt(i+1).toString()));
			else
				min = Math.min(min, Integer.parseInt(strnum.deleteCharAt(i).toString()));
			
			strnum = new StringBuilder(String.valueOf(x));
		}		
		return min;
	}
	
    public static int method2(int x){
    	   
    	if(x>=10 && x<1000000000){
    		StringBuffer sb= new StringBuffer(""+x);
    		int n=sb.length();
    		for(int i=0;i<n-2;i++){
    			if(sb.charAt(i)>sb.charAt(i+1) && sb.charAt(i+1)>sb.charAt(i+2))
    				return Integer.parseInt(sb.replace(i, i+2, sb.charAt(i)+"").toString());
    		}
    		int maxNumber= sb.charAt(n-1)>sb.charAt(n-2)?Integer.parseInt(sb.charAt(n-1)+""):Integer.parseInt(sb.charAt(n-2)+"");
    		return Integer.parseInt(sb.replace(n-2, n+1, maxNumber+"").toString());
    	}else{
    		System.out.println("value of \"x\" is out of range ");
    		return x;
    	}
    		
    }

}


