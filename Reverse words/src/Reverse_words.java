import java.util.Scanner;

/*Given a list of words in a string,
 *  reverse the words in-place (ie don't create a new string and reverse the words). 
 *  Since Java strings are not mutable, you can assume the input will be a mutable sequence (like list).
 */
public class Reverse_words {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string:");
		String input=sc.nextLine();
		String output=reverseTheWords(input);
		System.out.println("The reverse of the input String is:");
		System.out.println(output);
		sc.close();
	}
	public static String reverseTheWords(String input) {
		String temp[]=input.split(" ");
		String output="";
		for (int i = temp.length-1; i>=0; i--) {
			output=output+" "+temp[i];
		}
		return output.trim();
	}
}
