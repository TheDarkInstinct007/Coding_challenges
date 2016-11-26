package myGoogleTest;

public class TreeTest {

	public static void main(String[] args) {
		
		Tree t13 = new Tree(13,null,null);
		Tree t21 = new Tree(21,null,null);		
		
		Tree t23 = new Tree(23,null,null);
		Tree t22 = new Tree(22,t21,t23);
		Tree t4 = new Tree(4,null,null);
		Tree t12 = new Tree(12,t4,t13);
		Tree t19 = new Tree(19,t12,t22);
				
		System.out.println(solution(13, 14, t19));		
		
	}
	
	public static int traverse(int A, int B, Tree root, int maxlen)
	{				
		int len = calculateLenth(A,B,root,0);
		if(len > maxlen)
			maxlen= len;
		
		if(root.l!=null)
		{
			len = traverse(A,B,root.l,maxlen);
			if(len > maxlen)
				maxlen= len;
		}
		if(root.r!=null)
		{
			len = traverse(A,B,root.r,maxlen);
			if(len > maxlen)
				maxlen= len;
		}
		
		return maxlen;
	}
	
	public static int solution(int A, int B, Tree T) 
	{
		return traverse(A,B,T,0);
	}
	
	public static int calculateLenth(int A, int B, Tree root, int len)
	{	
		if(root.x < A || root.x > B)
			return -1;		
		else 
		{
			len=len+1;
			if(root.l!=null)
			{
				int l = calculateLenth(A,B,root.l,len);
				if(l==-1)
					len=-1;
				else
					len = l;
			}
			if(root.r!=null)
			{
				int l = calculateLenth(A,B,root.r,len);
				if(l==-1)
					len=-1;
				else
					len = l;
			}
		    return len;					
		}		
	}
	
}
