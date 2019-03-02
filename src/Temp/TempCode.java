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
			
		LinkedList<Integer> t = new LinkedList<Integer>();
		t.add(0);
		t.add(1);
		changeValue(t);
		t.add(4);
		
		for(Integer i : t)
			System.out.println(i);
		

	}
	
	public static void changeValue(LinkedList<Integer> x)
	{
		x.add(5);
	}

}