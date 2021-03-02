import java.util.Scanner;
import java.util.Arrays;

public class Recursive_Bubble_Sort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int N = sc.nextInt();

		int[] arr = new int[N];
		for(int i =0; i < N; i++){
			arr[i] = sc.nextInt();
		}

		//display the result
		System.out.println("Sorted Array:" + Arrays.toString(sortArray(arr, N)));

		//close the stream
		sc.close();
	}

	private static int[] sortArray(int[] arr, int n){
		if(n == 1){
			return arr;
		}
		for(int i = 0; i < n-1; i++){
			if(arr[i] > arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}

		sortArray(arr, n-1);
		return arr;
	}
}