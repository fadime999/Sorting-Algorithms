
public class SortingClass {
	public void heapSort(int[] arrayToSort) {
		if (arrayToSort.length == 0) 
			return;
		
		int length = arrayToSort.length;

		// Moving from the first element that isn't a leaf towards the root
		for (int i = length / 2 - 1; i >= 0; i--) 
			heapify(arrayToSort, length, i);
		
		for (int i = length - 1; i >= 0; i--) {
			int tmp = arrayToSort[0];
			arrayToSort[0] = arrayToSort[i];
			arrayToSort[i] = tmp;
			heapify(arrayToSort, i, 0);
		}
	}

	public void heapify(int[] array, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < length && array[left] > array[largest]) {
			largest = left;
		}
		if (right < length && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			// Swap
			swap(array, i, largest);
			heapify(array, length, largest);
		}
	}

	private void swap(int[] arrayToSort, int i, int j) {
		int temp = arrayToSort[i];
		arrayToSort[i] = arrayToSort[j];
		arrayToSort[j] = temp;
	}

	private void insertionSort(int[] arrayToSort, int left, int right) {

		for (int i = left; i <= right; i++) {
			int key = arrayToSort[i];
			int j = i;

			// Move elements of arr[0..i-1], that are
			// greater than the key, to one position ahead
			// of their current position
			while (j > left && arrayToSort[j - 1] > key) {
				arrayToSort[j] = arrayToSort[j - 1];
				j--;
			}
			arrayToSort[j] = key;
		}
	}

	// Function for finding the median of the three elements
	private int findPivot(int[] arrayToSort, int a1, int b1, int c1) {
		int max = Math.max(Math.max(arrayToSort[a1], arrayToSort[b1]), arrayToSort[c1]);
		int min = Math.min(Math.min(arrayToSort[a1], arrayToSort[b1]), arrayToSort[c1]);
		int median = max ^ min ^ arrayToSort[a1] ^ arrayToSort[b1] ^ arrayToSort[c1];
		if (median == arrayToSort[a1])
			return a1;
		if (median == arrayToSort[b1])
			return b1;
		return c1;
	}

	private int partition(int[] arrayToSort, int low, int high) {

		// pivot
		int pivot = arrayToSort[high];

		// Index of smaller element
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {

			// If the current element is smaller than or equal to the pivot
			if (arrayToSort[j] <= pivot) {

				// increment index of smaller element
				i++;
				swap(arrayToSort, i, j);
			}
		}
		swap(arrayToSort, i + 1, high);
		return (i + 1);
	}

	// The main function that implements Introsort
	// low --> Starting index,
	// high --> Ending index,
	public void sort(int[] arrayToSort) {
		int maxdepth = (int) (2 * Math.floor(Math.log(arrayToSort.length) / Math.log(2)));
		introSort(arrayToSort, 0, (arrayToSort.length - 1), maxdepth);
	}

	public void introSort(int[] arrayToSort, int fromIndex, int toIndex, int maxdepth) {
		int range_Length = toIndex - fromIndex;
		int n = arrayToSort.length;

		if (range_Length > 16) {
			if (maxdepth == 0) {
				// if the recursion limit is occurred call heap sort
				heapSort(arrayToSort);
				return;
			}

			maxdepth = maxdepth - 1;
			int pivot = findPivot(arrayToSort, fromIndex, fromIndex + ((toIndex - fromIndex) / 2) + 1, toIndex);
			swap(arrayToSort, pivot, toIndex);

			// p is partitioning index, arr[p] is now at right place
			int p = partition(arrayToSort, fromIndex, toIndex);

			// Separately sort elements before partition and after partition
			introSort(arrayToSort, fromIndex, p - 1, maxdepth);
			introSort(arrayToSort, p + 1, toIndex, maxdepth);
		}

		else {
			// if the data set is small, call insertion sort
			insertionSort(arrayToSort, fromIndex, toIndex);
		}

	}

	public void shellSort(int[] arrayToSort) {

		int array_length = arrayToSort.length;
		for (int interval = array_length / 2; interval > 0; interval /= 2) {
			for (int i = interval; i < array_length; i += 1) {
				int temp = arrayToSort[i];
				int j;
				for (j = i; j >= interval && arrayToSort[j - interval] > temp; j -= interval) {
					arrayToSort[j] = arrayToSort[j - interval];
				}
				arrayToSort[j] = temp;
			}
		}
	}

	public void printArray(int[] arrayToSort) {

		for (int i = 0; i < arrayToSort.length; i++) {
			System.out.println(arrayToSort[i] + " ");
			System.out.println();
			// System.out.println(Arrays.toString(array));
		}

	}
}
