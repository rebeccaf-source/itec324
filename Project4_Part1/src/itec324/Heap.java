package itec324;

import java.util.Arrays;

public class Heap {
	//the size of the heap --> array length - 1
	private int heap_size;

	/**
	 * Builds the heap to the proper specifications, with the largest on top
	 * @param array the array that is being built
	 */
	public void Build_Max_Heap(int[] array)
	{
		heap_size = array.length - 1;
		
		for(int i = (int) (Math.floor((array.length - 1)/ 2)); i >= 0; i--)
		{
			Max_Heapify(array, i);
		}
	}
	/**
	 * This method sorts the array from smallest to largest
	 * @param array the array that is being sorted
	 */
	public void Heap_Sort(int[] array)
	{
		Build_Max_Heap(array);
		for(int i = array.length - 1; i >= 0; i--)
		{
			swap(array, 0, i);
			heap_size--;
			Max_Heapify(array, 0);
		}
	}
	/**
	 * It takes an index and moves it as neccesary, up if bigger and down if smaller
	 * @param array the array the is being shifted
	 * @param index the index that is being changed, if necessary
	 */
	public void Max_Heapify(int[] array, int index)
	{
		int largest = 0;
		int left = (2 * index) + 1;
		int right = (2 * index) + 2; 
			if ( left <= heap_size && array[left] > array[index]) {
				largest = left;
			} else {
				largest = index;
			}
			// check right index
			if (right <= heap_size && array[right] > array[largest]) {
				largest = right;
			}
			//System.out.println("Largest is " + array[largest]);
			if (largest != index) {
				swap(array, index, largest);
				Max_Heapify(array, largest);
			}
	}
	/**
	 * this a helper method that swaps the two positions in an array
	 * @param array the array where the indexes are being swapped
	 * @param one first index being switched
	 * @param two the index that the first one is switching with
	 */
	private void swap(int[]array, int one, int two)
	{
		int newOne = array[two];
		int newTwo = array[one];

		array[one] = newOne;
		array[two] = newTwo;
		
	}
}
