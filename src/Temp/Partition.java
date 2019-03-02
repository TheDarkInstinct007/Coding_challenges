package Temp;

//Partition a linked list using pivot
class Node
{
	public int data;
	public Node next;
	
	public Node(int data)
	{
		this.data=data;
	}
}

public class Partition 
{
		public static void main(String[] args)
		{
			Node a = new Node(4);
			Node b = new Node(1);
			Node c = new Node(5);
			Node d = new Node(1);
			Node e = new Node(2);

			a.next=b;
			b.next=c;
			c.next=d;
			d.next=e;
			
			a = partition(a,3);

			while(a!=null)
			{
				System.out.println(a.data);
				a=a.next;
			}
		}

		static Node partition(Node head, int k)
		{
			if(head==null || head.next==null)
				return head;

			Node c = head;
			int smallCount=0;
			while(c!=null)
			{
				if(c.data<k)
					smallCount++;
				c=c.next;
			}

			Node r = head;
			while(smallCount > 1)
			{
				r = r.next;
				smallCount--;
			}

			Node d = new Node(0);
			d.next = head;
			Node temp;
			while(r.next!=null)
			{
				System.out.println("R is at "+r.data);
				System.out.println("D is at "+d.data);
				while(d.next.data<k)
					d=d.next;
				while(r.next!=null && r.next.data>=k)
					r=r.next;
				
				if(r.next!=null)
				{
					if(d.next==head)
						head=r.next;
					
					temp = r.next;
					r.next = d.next;
					d.next = temp;

					temp = r.next.next;
					if(r.next.next!=null)
						r.next.next = d.next.next;
					d.next.next = temp;
				}
			}
			return head;
		}
	}
