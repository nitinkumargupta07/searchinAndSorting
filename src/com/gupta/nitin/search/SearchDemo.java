package com.gupta.nitin.search;

/**
 * A binary search or half-interval search algorithm finds the position of a
 * specified value (the input "key") within a sorted array. In each step, the
 * algorithm compares the input key value with the key value of the middle
 * element of the array. If the keys match, then a matching element has been
 * found so its index, or position, is returned. Otherwise, if the sought key is
 * less than the middle element's key, then the algorithm repeats its action on
 * the sub-array to the left of the middle element or, if the input key is
 * greater, on the sub-array to the right. If the remaining array to be searched
 * is reduced to zero, then the key cannot be found in the array and a special
 * "Not found" indication is returned.
 * 
 * Every iteration eliminates half of the remaining possibilities. This makes
 * binary searches very efficient - even for large collections.
 * 
 * Binary search requires a sorted collection. Also, binary searching can only
 * be applied to a collection that allows random access (indexing).
 * 
 * Worst case performance: O(log n)
 * 
 * Best case performance: O(1)
 * 
 * @author nitin
 *
 */
public class SearchDemo {
	static int[] array = { 1, 2, 4, 6, 8, 12, 15, 34, 55, 77 };
	static int[] arrayLinear = { 111, 21, 13, 41, 68, 8, 12, 15, 34, 55, 77 };
	public static void main(String[] args) {
		
		System.out.println("12 find in position " + recursiveBinarySearch(array, 0, array.length - 1, 12));
		System.out.println("20 find in position " + recursiveBinarySearch(array, 0, array.length - 1, 20));
		System.out.println("12 find in position " + iterativeBinarySearch(array, 12));
		System.out.println("12 find in position " + iterativeBinarySearch(array, 13));
		System.out.println("21 position -->> " + resursiveLinearSearch(arrayLinear, 0, arrayLinear.length - 1, 115));
		System.out.println("16 position -->> " + resursiveLinearSearch(arrayLinear, 0, arrayLinear.length - 1, 16));
		System.out.println("16 position -->> " + jumpSearch(array,15));
		linerSearch(arrayLinear, 13);
	}
	
	static int interpolationSearch(int x) {
		int lo = 0, hi = (array.length - 1);
		// Since array is sorted, an element present
		// in array must be in range defined by corner
		while (lo <= hi && x >= array[lo] && x <= array[hi]) {
			// Probing the position with keeping
			// uniform distribution in mind.
			int pos = lo + (((hi - lo) / (array[hi] - array[lo])) * (x - array[lo]));

			// Condition of target found
			if (array[pos] == x)
				return pos;

			// If x is larger, x is in upper part
			if (array[pos] < x)
				lo = pos + 1;

			// If x is smaller, x is in the lower part
			else
				hi = pos - 1;
		}
		return -1;
	}
	
	public static int jumpSearch(int[] array, int x) {
		int n = array.length;
		// Finding block size to be jumped
		int step = (int) Math.floor(Math.sqrt(n));

		// Finding the block where element is
		// present (if it is present)
		int prev = 0;
		while (array[Math.min(step, n) - 1] < x) {
			prev = step;
			step += (int) Math.floor(Math.sqrt(n));
			if (prev >= n)
				return -1;
		}

		// Doing a linear search for x in block
		// beginning with prev.
		while (array[prev] < x) {
			prev++;

			// If we reached next block or end of
			// array, element is not present.
			if (prev == Math.min(step, n))
				return -1;
		}

		// If element is found
		if (array[prev] == x)
			return prev;

		return -1;
	}

	private static int resursiveLinearSearch(int[] array2, int i, int j, int key) {
		int position = -1;
		if (i < j) {

			if (array2[i] == key) {
				position = i;
				return position;
			} else {
				i++;
				return resursiveLinearSearch(array2, i, j, key);
			}
		}

		return position;
	}

	private static int linerSearch(int[] arr, int searchKey) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[i] == searchKey) {
				return i;
			}
		}
		return -1;
	}

	private static int iterativeBinarySearch(int[] array, int key) {
		int begin = 0;
		int end = array.length - 1;
		int mid = 0;
		while (begin <= end) {
			mid = (begin + end) / 2;
			if (array[mid] == key) {
				mid = mid;
				break;
			}
			if (array[mid] > key) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		if (begin > end) {
			return -1;
		} else {
			return mid;
		}

	}

	private static int recursiveBinarySearch(int[] array, int begin, int end, int searchKey) {
		if (begin <= end) {
			int mid = (begin + end) / 2;
			if (array[mid] > searchKey) {
				return recursiveBinarySearch(array, begin, mid - 1, searchKey);
			} else if (array[mid] == searchKey) {
				return mid;
			} else {
				return recursiveBinarySearch(array, mid + 1, end, searchKey);
			}

		}
		return -1;
	}
}
