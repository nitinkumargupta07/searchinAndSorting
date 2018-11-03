package com.gupta.nitin.sort;

public class SortDemo {
	static int[] arr = { 12, 22, 42, 6, 34, 76, 23, 98, 45 };
	static private int[] tempMergArr;

	public static void main(String[] args) {

		bubbleSort(arr);
		selectonSort(arr);
		bubbleSort(arr, arr.length);
		insertionSort(arr);
		quickSort(arr, 0, arr.length - 1);
		SortDemo sort = new SortDemo();
		sort.mergesort(arr);
		mergeSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void mergeSort(int[] arrayLinear2, int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(arrayLinear2, begin, mid);
			mergeSort(arrayLinear2, mid + 1, end);
			merge(arrayLinear2, begin, mid, end);
		}
	}

	private static void merge(int[] array, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];
		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}

	}

	private static void insertionSortRecursive(int[] array, int n) {
		if (n <= 1)
			return;
		insertionSortRecursive(array, n - 1);
		int last = array[n - 1];
		int j = n - 2;
		while (j >= 0 && array[j] > last) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = last;

	}

	public void mergesort(int inputArr[]) {
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

	static void bubbleSort(int array[], int n) {
		if (n == 1)
			return;
		for (int i = 0; i < n - 1; i++)
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		bubbleSort(array, n - 1);
	}

}
