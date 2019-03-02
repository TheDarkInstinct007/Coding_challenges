package hackerrank;

//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

public class insertNodeInSortedLinkedList {
	
	public static void main(String[] args) {

		DoublyLinkedListNode node = new DoublyLinkedListNode(1);
		node.next = new DoublyLinkedListNode(3);
		node.next.next = new DoublyLinkedListNode(4);
		node.next.next.next = new DoublyLinkedListNode(10);

		node = sortedInsert(node,5);
		
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}			
	}
	
	
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode cur = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if(head.data>=data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }        

        while(cur.next!=null && cur.next.data<=data) {
            cur = cur.next;
        }
        
        if(cur.next==null) {
            cur.next = newNode;
            newNode.prev = cur;
        }
        else {
        	
        	cur.next.prev = newNode;
        	newNode.next = cur.next;
        	newNode.prev = cur;
        	cur.next = newNode;
        }

        return head;
    }

}
