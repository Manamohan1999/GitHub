import java.util.Scanner;
import java.util.Arrays;

public class Bubble_Sort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int N = sc.nextInt();

		int[] arr = new int[N];
		for(int i =0; i < N; i++){
			arr[i] = sc.nextInt();
		}

		//display the result
		System.out.println("Sorted Array:" + Arrays.toString(sortArray(arr)));

		//close the stream
		sc.close();
	}

	private static int[] sortArray(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n-1; i++){
			boolean swapped = false;

			for(int j = 0; j < n-1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

					swapped = true;
				}
			}

			if(swapped == false){
				break;
			}
		}
		return arr;
	}
}