package bfsPackage;

import java.util.LinkedList;
import java.util.Queue;

public class TestBFS {

	public static void main(String[] args) {
		
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		TreeNode l8 = new TreeNode(8);
		TreeNode l9 = new TreeNode(9);
		
		l1.setLeft(l2);
		l1.setRight(l3);
		l2.setLeft(l4);
		l2.setRight(l5);
		l3.setRight(l6);
		l5.setLeft(l7);
		l5.setRight(l8);
		l6.setLeft(l9);
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(l1);
		
		int s;
		TreeNode n;
		while(queue.size()!=0)
		{
			s=queue.size();
			while(s!=0)
			{
				n = queue.remove();
				System.out.print(" " + n.getVal());
				
				if(n.getLeft()!=null)
					queue.add(n.getLeft());
				if(n.getRight()!=null)
					queue.add(n.getRight());
				s--;
			}
			System.out.println();
		}
	}
}
