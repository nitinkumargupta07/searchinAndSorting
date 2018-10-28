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
public class BinarySearchDemo {

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, start, mid, key);

			} else if (key > sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, mid + 1, end, key);

			} else {
				return mid;
			}
		}
		return -(start + 1);
	}

	private int iterativeBinarySearch(int[] inputArr, int key) {
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			} else if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return -1;

	}

	public static void main(String[] args) {
		BinarySearchDemo demo = new BinarySearchDemo();
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
		System.out.println("Key 14's position: " + demo.iterativeBinarySearch(arr, 14));
		int[] arr12 = { 6, 34, 78, 123, 432, 900 };
		System.out.println("Key 432's position: " + demo.iterativeBinarySearch(arr12, 432));

		int[] arr1 = { 2, 45, 234, 567, 876, 900, 976, 999 };
		int index = recursiveBinarySearch(arr1, 0, arr1.length, 45);
		System.out.println("Found 45 at " + index + " index");
		index = recursiveBinarySearch(arr1, 0, arr1.length, 999);
		System.out.println("Found 999 at " + index + " index");
		index = recursiveBinarySearch(arr1, 0, arr1.length, 890);
		System.out.println("Found 876 at " + index + " index");

	}
}
