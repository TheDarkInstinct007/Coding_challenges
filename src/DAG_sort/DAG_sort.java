package DAG_sort;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DAG_sort 
{
	private static Stack<Node> stck;
	
	public static void main(String[] args) 
	{
		//Read the number of rows and columns
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int column = scanner.nextInt();
		 
		//Create empty graph
		NodeGraph graph = new NodeGraph();
		
		//Add nodes and dependencies in the graph
		for(int i=0; i<rows; i++)
		{
			Node from = graph.getNode(scanner.nextInt());
			Node to = graph.getNode(scanner.nextInt());
			from.addDependency(to);
		}	
		
		//Stop reading the input
		scanner.close();
		
		//Initialize the stack
		stck = new Stack<Node>();
		
		//Call the sort function for all non-visited nodes
		for(Node n : graph.getAllNodes())
			if(!n.isVisited())
				tSort(n);
		
		//Print the contents of stack in LIFO order
		while(!stck.isEmpty())
			System.out.print(stck.pop().getValue()+" ");
	}
	
	private static void tSort(Node n)
	{
		//Mark the node as visited
		n.visit();
		
		//Check non-visited dependents of current node and call this function recursively for them
		for(Node d: n.getAllDependents())
		{
			if(!d.isVisited())
				tSort(d);
		}
		
		//Push the current node on stack
		stck.push(n);				
	}
}


class NodeGraph
{
	ArrayList<Node> nodes;
	
	public NodeGraph()
	{
		nodes = new ArrayList<Node>();
	}

	public Node getNode(Integer i) 
	{		
		//Check if the node exists in the graph
		for(Node n : nodes)
		{
			if(n.getValue().equals(i))
				return n;
		}
		
		//If the node does not exist then create a new node and add it to the graph
		Node n = new Node(i);
		nodes.add(n);
		return n;
	}

	public int size() 
	{
		return nodes.size();
	}
	
	public ArrayList<Node> getAllNodes()
	{
		return nodes;
	}
	
}


class Node
{
	Integer value;
	ArrayList<Node> dependents;
	boolean visited;
	
	public Node(Integer integer)
	{		
		value = integer;
		visited = false;
		dependents = new ArrayList<Node>();
	}	
	
	public Integer getValue()
	{
		return value;
	}
	
	public void addDependency(Node n)
	{
		dependents.add(n);
	}
	
	public ArrayList<Node> getAllDependents()
	{
		return dependents;
	}	
	
	public void visit()
	{
		visited = true;
	}
	
	public boolean isVisited()
	{
		return visited;
	}
}