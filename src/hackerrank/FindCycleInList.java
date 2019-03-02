package hackerrank;

import java.util.HashMap;

public class FindCycleInList {

	public static void main(String[] args) {

		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);

		one.next=two;
		two.next=three;
		three.next=four;
		four.next=two;
		
		System.out.println(hasCycle(one));
		
	}
	
	private static boolean hasCycle(Node head) {
	    HashMap<Node, Boolean> map = new HashMap<>();
	    
	    while(head!=null) {
	        if(map.get(head)==null) {
	            map.put(head,true);
	        }else
	            return true;
	        head=head.next;
	    }
	    
	    return false;
	}

	/* Alternate approach: One slow and one fast pointer. If list has a cycle, they will meet
	
	boolean hasCycle(Node head) {
    
    if(head==null)
        return false;
    else{
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null && fast!=slow){
            slow=slow.next;
            fast=fast.next.next;
        	}
        if( fast!=null && fast==slow)
            return true;
        return false;
    	}     

	}	*/
	
}
