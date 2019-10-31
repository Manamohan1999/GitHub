import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Finding_The_Missing_Number {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int arraySize=sc.nextInt();
		System.out.println("Enter the consucative elements to the array:");
		int[] A=new int[arraySize];
		for (int i = 0; i < A.length; i++) {
			A[i]=sc.nextInt();
		}
		Find_Missing(A);
		sc.close();
	}

	private static void Find_Missing(int[] A) {
		Arrays.sort(A);
		ArrayList<Integer> al=new ArrayList<>();
		HashSet<Integer> hs=new HashSet<>();
		for(int i : A) {
			al.add(i);
		}
		for (int i = 0; i <al.size()-1; i++) {
			if (!(al.get(i+1)==al.get(i)+1 || al.get(i+1)==al.get(i))) {
				hs.add(al.get(i)+1);
				al.add(i+1, al.get(i)+1);
			}
		}
		System.out.println(hs);
	}
}
