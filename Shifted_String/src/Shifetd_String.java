import java.util.Scanner;

public class Shifetd_String {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String:");
		String A=sc.nextLine();
		System.out.println("Enter the shifted String:");
		String B=sc.nextLine();
		Check_String(A,B);
		sc.close();
	}

	private static void Check_String(String A, String B) {
		if (A.length()==B.length()) {
			if (A.equals(B)) {
				System.out.println("true");
				return;
			}
			char[] a=A.toCharArray();
			char[] b=B.toCharArray();
			int i=0;
			int j=0;
			while(i<a.length) {
				if (a[i]==b[0]) {
					j=i;
				}
				i++;
			}
			String subA=A.substring(j, A.length());
			String subB=A.substring(0, j);
			if (subA.concat(subB).equals(B)) {
				System.out.println("true");
				return;
			}
		}else {
			System.out.println("false");
			return;
		}
		
		
		
	}
}
