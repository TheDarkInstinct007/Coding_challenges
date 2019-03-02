package hackerrank;

//https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

import javax.xml.soap.Node;

public class ReverseDoublyLinkedList {

	public static void main(String[] args) {

		DoublyLinkedListNode node = new DoublyLinkedListNode(1);
		DoublyLinkedListNode two = new DoublyLinkedListNode(2);
		DoublyLinkedListNode three = new DoublyLinkedListNode(3);
		DoublyLinkedListNode four = new DoublyLinkedListNode(4);
		
		node.next=two;
		two.next=three;
		three.next=four;
		
		four.prev=three;
		three.prev=two;
		two.prev=node;		
		
		node=reverse(node);
		
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}		
	}
	
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    	
    	if(head==null || head.next==null)
    		return head;
    	
    	while(head!=null) {
    		exchangeLinks(head);		
    		if(head.prev==null)
    			break;
    		else
    			head=head.prev;
    	}    	
    	return head;
    }
    
    static void exchangeLinks(DoublyLinkedListNode a) {
    	DoublyLinkedListNode b;
    	b=a.next;
    	a.next=a.prev;
    	a.prev=b;    	
    }

}
