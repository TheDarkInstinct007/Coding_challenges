package Temp;
import java.util.LinkedList;

import tree.Node;

/*	Results:
 * int = Passed by value
 * Integer = Passed by value		(Wrapper classes are immutable)
 * String = Passed by value			(Values are stored in String pool)
 * int[] = Passed by reference
 * ArrayList<int> = Passed by reference	
 * Node = Passed by reference
 * Any custom object = 	Passed by reference
 * 
 * Conclusion:
 * Java is pass by value.
 * Java is NOT pass by reference. In Java, references are passed by value.
 * All wrapper classes (e.g. Integer, Float, etc.) are immutable. They replicate the behavior of primitives.
 * Strings are stored in string pool.
 * */

class CustomObject
{
	private int data;
	
	public CustomObject(int data)
	{
		this.data = data;
	}
	
	public void setData(int data)
	{
		this.data=data;
	}
	
	public String toString()
	{
		return String.valueOf(data);
	}
	
}

public class CheckPassByRefernce {

	public static void main(String[] args) {
			
			CustomObject co = new CustomObject(1);
			Integer i = new Integer(1);
			System.out.println("Value in i=" + i + " Value in custom object=" + co);
			changeValue(i, co);
			System.out.println("Value in i=" + i + " Value in custom object=" + co);
	}
	
	public static void changeValue(Integer x, CustomObject y)
	{
		x=5;
		y.setData(5);
	}

}