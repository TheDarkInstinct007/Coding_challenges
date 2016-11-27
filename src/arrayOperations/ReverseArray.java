package arrayOperations;

public class ReverseArray {

	public static void main(String[] args) {
		
		int[] input = {11,9,7,5,3,1,-1};
		
		int temp, head=0, tail = input.length-1;
		
		while(head < tail)
		{
			temp = input[head];
			input[head] = input[tail];
			input[tail] = temp;
			
			head++;
			tail--;
		}
		
		for(int i :input)
			System.out.print(i+" ");

	}

}
