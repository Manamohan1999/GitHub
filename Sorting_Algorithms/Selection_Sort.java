import java.util.Scanner;
import java.util.Arrays;
public class Selection_Sort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i =0; i<N; i++){
			arr[i] = sc.nextInt();
		}
		//display the outtput array
		System.out.println(Arrays.toString(sortArray(arr)));
		//close the stream
		sc.close();
	}

	private static int[] sortArray(int[] arr){
		int n = arr.length;
		for(int i = 0; i<n-1; i++){

			int min_idx = i;
			for(int j = i+1; j< n; j++){
				if(arr[j] < arr[min_idx])
					min_idx = j;
			}

			int temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;
		}
		return arr;
	}
}