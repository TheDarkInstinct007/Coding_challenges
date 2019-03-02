package amazon;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LowestCommonAncestorInBinarySearchTree {

	public static void main(String[] args) {
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		
		two.left=one;
		two.right=four;
		four.left=three;
		four.right=five;
		five.right=six;
		
		Node lca = findLowestCommonAncestor(two,3,6);
		System.out.println(lca.data);

	}
	
	static Node findLowestCommonAncestor(Node root, int a, int b) {
		
		int low = a < b ? a : b;
		int high = a > b ? a : b;
		
		if(root.data == high  || root.data == low)
			return root;
		else if(root.data > low && root.data < high)
			return root;
		else if(root.data > high)
			return findLowestCommonAncestor(root.left, a, b);
		else
			return findLowestCommonAncestor(root.right, a, b);
	}
	
}
