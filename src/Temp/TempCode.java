package Temp;
import java.util.LinkedList;

import tree.Node;

/*	Result:
 * int = Passed by value
 * Integer = Passed by value
 * String = Passed by value
 * int[] = Passed by reference
 * ArrayList<int> = Passed by reference	
 * Node = Passed by reference	*/

public class TempCode {

	public static void main(String[] args) {
			
			Integer[] i = new Integer[1];
			i[0]=2;
			System.out.println(i[0]);
			changeValue(i[0]);
			System.out.println(i[0]);		
	}
	
	public static void changeValue(Integer x)
	{
		x=5;
	}

}