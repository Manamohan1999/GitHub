import java.util.Scanner;
/*
 * Given a non-negative integer n, convert n to base 2 in string form. Do not use any built in base 2 conversion functions like bin.

 *Here's an example and some starter code:

 *def base_2(n):
   # Fill this in.

 *print(base_2(123))
   # 1111011

 *In the above example, 2^6 + 2^5 + 2^4 + 2^3 + 2^1 + 2^0 = 123.
 */

public class Convert_to_Base_Two {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a non negative Integer:");
		int input=sc.nextInt();
		String output=getBinary(input);
		System.out.println(output);
		sc.close();
	}
	public static String getBinary(int input) {
		String output="";
		int rem;
		while(input>0) {
			rem=input%2;
			output += rem;
			input = input/2;
		}
		StringBuilder sb=new StringBuilder(output);
		return sb.reverse().toString();
	}
}
