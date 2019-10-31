import java.util.Arrays;
import java.util.Scanner;

public class Longest_Cosecutive_Sequence {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of the array:");
		int arraySize=sc.nextInt();
		System.out.println("enter the elements in the array:");
		int[] A=new int[arraySize];
		for (int i = 0; i < A.length; i++) {
			A[i]=sc.nextInt();
		}
		System.out.println("Entered succesfully....");
		int longest_Sequence=Find_Longest_Cosecutive(A);
		System.out.println("The longest consecutive sequence is: "+longest_Sequence);
		sc.close();
	}

	private static int Find_Longest_Cosecutive(int[] A) {
		Arrays.sort(A);
		int count=0;
		int longest_Sequence=0;
		for (int i = 0; i < A.length-1; i++) {
			count=0;
			while(A[i]+1==A[i+1]) {
				count++;
			}
			if(count>longest_Sequence) {
				longest_Sequence=count;
			}
		}
		return longest_Sequence;
	}
}
