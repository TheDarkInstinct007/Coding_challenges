package RotatedSortedArray;

import java.util.Scanner;

public class RotateSortedArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the length array : ");

		int len = scanner.nextInt();
		int[] arr = new int[len];

		System.out.print("Enter the array rotated at any one pivot point : ");
		for(int i=0; i<len; i++)
			arr[i]=scanner.nextInt();

		for(int i=0; i<len-1; i++)
		{
			if(arr[i]>arr[i+1])
			{
				System.out.print("Smallest number is : " + arr[i+1]);
				break;
			}
		}

	}

}
