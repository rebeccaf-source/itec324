package itec324;

import java.util.Arrays;

public class Main {

	public static void main(String[] args)
	{
		Heap heap = new Heap();
		
		
		
		//testing build_max_heap
		System.out.println("Testing Build_Max_Heap...");
		int[] sample4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(sample4)); 
		heap.Build_Max_Heap(sample4);
		System.out.println(Arrays.toString(sample4));
		  
		 
		System.out.println("Next one: ");
		int[] sample5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(sample5));
		heap.Build_Max_Heap(sample5);
		System.out.println(Arrays.toString(sample5));
	
		System.out.println("Next one: ");
		int[] sample6 = {4, 6, 2, 1, 8, 4, 3, 6, 10, 8};
		System.out.println(Arrays.toString(sample6));
		heap.Build_Max_Heap(sample6);
		System.out.println(Arrays.toString(sample6));
		
		
		//testing heap_sort  
		System.out.println("\nTesting Heap_Sort...");
		int[] sample7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(sample7)); 
		heap.Heap_Sort(sample7);
		System.out.println(Arrays.toString(sample7));
		  
		 
		System.out.println("Next one: ");
		int[] sample8 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(sample8));
		heap.Heap_Sort(sample8);
		System.out.println(Arrays.toString(sample8));
	
		System.out.println("Next one: ");
		int[] sample9 = {4, 6, 2, 1, 8, 4, 3, 6, 10, 8};
		System.out.println(Arrays.toString(sample9));
		heap.Heap_Sort(sample9);
		System.out.println(Arrays.toString(sample9));
		
		System.out.println("Next one: ");
		int[] sample10 = {60, 20, 40 , 70, 30, 10, 90, 3000, 12, 56};
		System.out.println(Arrays.toString(sample10));
		heap.Heap_Sort(sample10);
		System.out.println(Arrays.toString(sample10));
		
	}
}
