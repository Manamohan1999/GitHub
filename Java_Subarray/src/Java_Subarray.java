import java.util.Scanner;

public class Java_Subarray {
/*
 * Hacker rank java sub array
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length");
		int length = sc.nextInt();
		System.out.println("Enter array");
		int[] elements = new int[length];
		for(int len = 0; len<length; len++) {
			elements[len] = sc.nextInt();
		}
		
		 int count =0;
		 for(int i = 1; i <= elements.length; i++ ) {
			 for(int l = 0; l < elements.length; l++) {
				 int sum = 0;
				 for(int j = l, k = j + i ; j < k && k<elements.length;j++, k++) {
					 sum += elements[j];
				 }
				 if(sum < 0) {
					 count ++;
				 }
			 }
		 }
		 System.out.println(count);
	}

}
