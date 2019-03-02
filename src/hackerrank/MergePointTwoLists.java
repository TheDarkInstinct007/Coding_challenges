package hackerrank;

//https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

public class MergePointTwoLists {

	public static void main(String[] args) {
		
		SinglyLinkedListNode a1 = new SinglyLinkedListNode(1);
		SinglyLinkedListNode a2 = new SinglyLinkedListNode(2);
		SinglyLinkedListNode b1 = new SinglyLinkedListNode(3);
		SinglyLinkedListNode a3b2 = new SinglyLinkedListNode(4);
		
		a1.next=a2;
		a2.next=a3b2;
		b1.next=a3b2;
		
		System.out.println(findMergeNode(a1,b1));

	}

	
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode shorter, longer;
        int list1Size = findListSize(head1);
        int list2Size = findListSize(head2);
        int sizeDiff = Math.abs(list1Size-list2Size);
        if(list1Size>=list2Size) {
            longer = head1;
            shorter = head2;
        }
        else {
            longer = head2;
            shorter = head1;
        }

        longer = moveForward(longer,sizeDiff);

        SinglyLinkedListNode result = commonNode(longer, shorter);
        return result.data;

    }

    private static int findListSize(SinglyLinkedListNode head) {
        int size =0;
        while(head!=null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private static SinglyLinkedListNode moveForward(SinglyLinkedListNode head, int steps) {
        while(steps>0) {
            head=head.next;
            steps--;
        }
        return head;
    }

    private static SinglyLinkedListNode commonNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        while(head1!=head2) {
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }
	
}
