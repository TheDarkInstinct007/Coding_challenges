package tree;

import java.util.*;

public class PrintVerticalTree {

	public static void main(String[] args) {
		
		Node six = new Node(6);
		six.setRight(new Node(8));
		
		Node seven = new Node(7);
		seven.setRight(new Node(9));
		
		Node three = new Node(3);
		three.setLeft(six);
		three.setRight(seven);
		
		Node two = new Node(2);
		two.setLeft(new Node(4));
		two.setRight(new Node(5));
		
		Node one = new Node(1);
		one.setLeft(two);
		one.setRight(three);
		
		verticalOrder(one);		

	}
	
	public static void verticalOrder(Node node)
	{
		//Find horizontal range, i.e. min and max distance
		int[] minMax = new int[2];
		findMinMax(node, minMax, 0);
		
		int horizontalDistance = Math.abs(minMax[0]) + minMax[1] + 1;
		ArrayList<LinkedList<Node>> listArr = new ArrayList<LinkedList<Node>>();
		for(int i=0; i<horizontalDistance; i++)
			listArr.add(new LinkedList<Node>());
		
		fillListValues(node, listArr, Math.abs(minMax[0]));
		
		for(LinkedList<Node> list : listArr )
		{
			for(Node n : list)
			{
				System.out.print(n.getData() + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public static void findMinMax(Node node, int[] minMax, int curVal)
	{
		if(node==null)
			return;
		
		minMax[0] = curVal < minMax[0] ? curVal : minMax[0];
		minMax[1] = curVal > minMax[1] ? curVal : minMax[1];
		
		findMinMax(node.getLeft(), minMax, curVal-1);
		findMinMax(node.getRight(), minMax, curVal+1);
				
	}
	
	public static void fillListValues(Node node, ArrayList<LinkedList<Node>> listArr, int curVal) 
	{
		if(node==null)
			return;
		
		listArr.get(curVal).add(node);
		
		fillListValues(node.getLeft(), listArr, curVal-1);
		fillListValues(node.getRight(), listArr, curVal+1);
		
	}

}
