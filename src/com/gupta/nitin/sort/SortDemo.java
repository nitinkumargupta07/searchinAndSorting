package com.gupta.nitin.sort;

public class SortDemo {
	static int[] arr = { 12, 22, 42, 6, 34, 76, 23, 98, 45 };
	static private int[] tempMergArr;

	public static void main(String[] args) {

		/// bubbleSort(arr);
		/// selectonSort(arr);
		/// insertionSort(arr);
		/// quickSort(arr ,0, arr.length - 1);
		SortDemo sort = new SortDemo();
		sort.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public void sort(int inputArr[]) {
		// this.arr = inputArr;
		int length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the arr
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the arr
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = arr[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				arr[k] = tempMergArr[i];
				i++;
			} else {
				arr[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			arr[k] = tempMergArr[i];
			k++;
			i++;
		}
	}

	public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
		int idx = partition(array, startIdx, endIdx);
		// Recursively call quicksort with left part of the partitioned array
		if (startIdx < idx - 1) {
			recursiveQuickSort(array, startIdx, idx - 1);
		}
		// Recursively call quick sort with right part of the partitioned array
		if (endIdx > idx) {
			recursiveQuickSort(array, idx, endIdx);
		}
	}

	public static int partition(int[] array, int left, int right) {
		int pivot = array[left]; // taking first element as pivot
		while (left <= right) {
			// searching number which is greater than pivot, bottom up
			while (array[left] < pivot) {
				left++;
			}
			// searching number which is less than pivot, top down
			while (array[right] > pivot) {
				right--;
			}
			// swap the values
			if (left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				// increment left index and decrement right index
				left++;
				right--;
			}
		}
		return left;
	}

	/** Quick sort function **/
	public static void quickSort(int arr[], int low, int high) {
		int i = low, j = high;
		int pivot = arr[(low + high) / 2];

		/** partition **/
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				/** swap **/
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
				j--;
			}
		}

		/** recursively sort lower half **/
		if (low < j)
			quickSort(arr, low, j);
		/** recursively sort upper half **/
		if (i < high)
			quickSort(arr, i, high);
	}

	public static void insertionSort(int[] input) {
		int temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
	}

	static void selectonSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted arr
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
