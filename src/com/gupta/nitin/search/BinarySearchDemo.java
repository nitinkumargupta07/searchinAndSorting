package com.gupta.nitin.search;

//All element is sorted order.
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
		index = recursiveBinarySearch(arr1, 0, arr1.length, 876);
		System.out.println("Found 876 at " + index + " index");

	}
}
