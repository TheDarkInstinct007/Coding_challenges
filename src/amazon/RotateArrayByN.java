package amazon;

// https://leetcode.com/problems/rotate-array/

public class RotateArrayByN {

	public static void main(String[] args) {
		
		int[] arr = {0,1,2,3,4};
		
		int k = 3;
		
		rotate(arr, k);
		
		for(int x : arr)
			System.out.println(x);

	}
	
	private static void rotate(int[] nums, int k) {
		
		k = k % (nums.length - 1);
		
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);		
	}

	public static void reverse(int[] arr, int start, int end) {
		int temp;
		while(start<end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
}
