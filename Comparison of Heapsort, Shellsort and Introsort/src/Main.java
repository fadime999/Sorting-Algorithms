import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortingClass a = new SortingClass();
		System.out.println("Please enter 1 to see the desired results from the menu or \nenter a random number to see the default values.\n");
		Scanner scan0 = new Scanner(System.in);
		System.out.println("Please enter the number: ");
		int condition0 = scan0.nextInt();
		switch (condition0) {
		case 1:
			System.out.println("If you want to test for 1000 numbers, please enter 1.\n"
					+ "If you want to test for 10000 numbers, please enter 2.\n"
					+ "If you want to test for 100000 numbers, please enter 3.\n");
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Please enter the number: ");
			int n = 0;
			int condition = scan1.nextInt();
			switch (condition) {
			case 1:
				n = 1000; // array size
				break;
			case 2:
				n = 10000; // array size
				break;
			case 3:
				n = 100000; // array size
				break;
			default:
				break;
			}

			int[] arrayToSort = new int[n];
			System.out.println("Please enter 1 for equal integers \n" + "Please enter 2 for -random integers \n"
					+ "Please enter 3 for -increasing integers \n" + "Please enter 4 for -decreasing integers\n");
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Please enter the number: ");
			int key = scan2.nextInt();
			switch (key) {
			case 1:
				// Equal
				int number = 9;
				for (int i = 0; i < n; i++)
					arrayToSort[i] = number;
				break;
			case 2:
				// Random
				for (int i = 0; i < n; i++) {
					Random rnd = new Random();
					arrayToSort[i] = rnd.nextInt(n);// generate numbers in random order
				}
				break;
			case 3:
				// Increasing
				for (int i = 0; i < n; i++)
					arrayToSort[i] = i; // generate numbers in increasing order
				break;
			case 4:
				// Decreasing
				for (int i = n - 1; i > 0; i--) {
					arrayToSort[i] = i; // generate numbers in decreasing order
				}
				break;
			default:
				break;
			}
			System.out.println("\nTo sort the numbers with heapsort, please enter 1\n"
					+ "To sort the numbers with shellsort, please enter 2.\n"
					+ "To sort the numbers with introsort, please enter 3.\n");
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Please enter the number: ");
			int key2 = scan3.nextInt();
			long startTime = 0;
			long estimatedTime = 0;
			switch (key2) {
			case 1:
				startTime = System.nanoTime();
				a.heapSort(arrayToSort); // run one of the sorting methods
				estimatedTime = System.nanoTime() - startTime;
				break;
			case 2:
				startTime = System.nanoTime();
				a.shellSort(arrayToSort); // run one of the sorting methods
				estimatedTime = System.nanoTime() - startTime;
				break;
			case 3:
				startTime = System.nanoTime();
				a.sort(arrayToSort); // run one of the sorting methods
				estimatedTime = System.nanoTime() - startTime;
				break;
			default:
				break;
			}
			System.out.println("Time:" + estimatedTime);
			break;

		default:
			int k=0;
			k = 10000; // array size
			int[] arrayToSortDefault = new int[k];
			for (int i = 0; i <k; i++) {
				Random rnd = new Random();
				arrayToSortDefault[i] = rnd.nextInt(k);// generate numbers in random order
			}
			long startTime0 = 0;
			long estimatedTime0 = 0;
			//HeapSort
			startTime0 = System.nanoTime();
			a.heapSort(arrayToSortDefault); // run one of the sorting methods
			estimatedTime0 = System.nanoTime() - startTime0;
			System.out.println("Heapsort time for random 10000 value:"+estimatedTime0+'\n');
			startTime0 = 0;
			estimatedTime0 = 0;
			//ShellSort
			startTime0 = System.nanoTime();
			a.shellSort(arrayToSortDefault); // run one of the sorting methods
			estimatedTime0 = System.nanoTime() - startTime0;
			System.out.println("ShellSort time for random 10000 value:"+estimatedTime0+'\n');
			startTime0 = 0;
			estimatedTime0 = 0;
			//IntroSort
			startTime0 = System.nanoTime();
			a.sort(arrayToSortDefault); // run one of the sorting methods
			estimatedTime0 = System.nanoTime() - startTime0;
			System.out.println("IntroSort time for random 10000 value:"+estimatedTime0);
		}
	

	}

}
