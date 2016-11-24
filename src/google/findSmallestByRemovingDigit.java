package google;
import java.util.Scanner;

public class findSmallestByRemovingDigit {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number :");
		long val = scanner.nextLong();
		System.out.println("Smallest number is : "+smallestNum(val));
	}
	
	private static long smallestNum(long x)
	{
		StringBuilder strnum = new StringBuilder(String.valueOf(x));		
		
		for(int i=0; i<strnum.length()-1; i++)
		{
			if(strnum.charAt(i)>strnum.charAt(i+1))
				return Integer.parseInt(strnum.deleteCharAt(i+1).toString());
		}
		
		return( strnum.charAt(strnum.length()-1) > strnum.charAt(strnum.length()-2) ? Integer.parseInt(strnum.deleteCharAt(strnum.length()-2).toString()) : Integer.parseInt(strnum.deleteCharAt(strnum.length()-1).toString()));
	}
}
