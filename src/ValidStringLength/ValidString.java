package ValidStringLength;

import java.util.Scanner;
import java.util.Stack;

public class ValidString {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = scanner.next();
		int length=0;
		
		Stack<Character> stck = new Stack<Character>();
				
		if(str!=null && str.length()!=0)
		{
			char[] charArr = str.toCharArray();
			
			for(char c : charArr)
			{
				if(c==')' && !stck.isEmpty() && stck.peek().equals('('))
				{
					stck.pop();
					length+=2;					
				}
				else
				{
					stck.push(c);
				}
			}
			System.out.println("Length is : "+ length);
		}

	}

}
