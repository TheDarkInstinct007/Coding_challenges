package google;

import java.util.Scanner;

public class findLagestByRemovingDigit {

	public static void main(String[] args) 
	{
		Scanner scaner = new Scanner(System.in);
		System.out.print("Enter the number : ");
		long  i = scaner.nextLong();
		scaner.close();
		
		boolean removed = false;
		StringBuilder strnum= new StringBuilder(String.valueOf(i)); 

		for(int j=1; j<strnum.length()-1; j++)
		{
			if(strnum.charAt(j)==strnum.charAt(j-1))
			{
				if(strnum.charAt(j)<strnum.charAt(j+1))
				{
					strnum.deleteCharAt(j);
					removed=true;
					break;
				}				
			}			
		}

		if(removed==false)
		{
			for(int j=strnum.length()-1; j>0; j--)
			{
				if(strnum.charAt(j)==strnum.charAt(j-1))
				{
					strnum.deleteCharAt(j);
					removed=true;
					break;
				}				
			}
		}

		if(removed==false)
			System.out.println("The number does not have groups");
		else
			System.out.print("Largest number is : " + strnum);

	}
}
