import java.util.Scanner;
import java.util.Arrays;

public class Insertion_Sort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int N = sc.nextInt();
		int[] arr = new int[N];
		System.out.println("Enter elements to  the array:");
		for(int i =0; i < N; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(sortArray(arr)));
		sc.close();
	}

	private static int[] sortArray(int[] arr){
		int n = arr.length;
		for(int i =1; i < n; i++){
			int item = arr[i];
			int j = i - 1;

			while(j >= 0 && arr[j] > item){
				arr[j+1] = arr[j];
				j--;
			}
			arr[++j] = item;
		}
		return arr;
	}
}