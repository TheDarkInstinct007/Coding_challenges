package Temp;

public class SumList
{
	public static void main(String[] args)
	{
		Node a1 = new Node(6);
		Node a2 = new Node(2);
		Node a3 = new Node(5);
		a1.next=a2;
		a2.next=a3;

		Node b1 = new Node(6);
		Node b2 = new Node(2);
		Node b3 = new Node(5);
		b1.next=b2;
		b2.next=b3;

		Node result = addLists(a1,b1);
		while(result!=null)
		{
			System.out.println(result.data);
			result = result.next;
		}
	}

	static Node addLists(Node a, Node b)
	{
		Node sum = new Node(0);
		int carry = addListsSum(a, b, sum);
		if(carry>0)
		{
			sum.data=carry;
			return sum;
		}
		return sum.next;
	}
		
	static int addListsSum(Node a, Node b, Node sum)
	{
		if(a.next==null)
		{
			Node n = new Node((a.data+b.data)%10);
			sum.next = n;
			return (a.data+b.data)/10;
		}
		int carry = addListsSum(a.next, b.next, sum);
		Node n = new Node((a.data+b.data+carry)%10);
		n.next = sum.next;
		sum.next = n;
		carry = (a.data+b.data+carry)/10;
 		return carry;			 
	}
}