import java.util.Scanner;

public class Blocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i< N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//do the logical part of the program
		lastRemaining(N, arr);
		System.out.println(arr[0]);
	}
	
	public static void lastRemaining(int n, int[] arr) {
		if(n == 1) {
			return;
		}else {
			int counter = 0;
			for(int i = 1 ;i < n; i++) {
				if(i % 2 == 1) {
					arr[counter++] = arr[i];
				}
			}
			lastRemaining(n/2, arr);
		}
	}

}
