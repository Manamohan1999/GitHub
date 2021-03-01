import java.util.Scanner;

/**
 * @author Manamohan Samal
 *
 *Identifiers are tokens which name language entities. Some of the kinds of entities an identifier might denote include variables, types, labels, subroutines, and packages.
A naming convention is a set of rules for choosing the character sequence to be used for identifiers which denote variables, types, functions, and other entities in source code and documentation.
You have two words and you have to make identifier of certain type, based on different choices.
A: camelCase
B: snake_case
C: MACRO_CASE
D:Train-Case
E,F,G,H

: sPeCiAl|cAsE (lower, upper, lower…..|lower,upper,lower,…..)
Input:

    First line will contain T

, the number of test cases. Then the test cases follow:
Each line contains a choice Ch
[A−H] and two space separated strings S1 and S2

Sample Input:

5
A first second
B first second
C first second
D first second
F first second

Sample Output:

firstSecond
first_second
FIRST_SECOND
First-Second
fIrSt|sEcOnD 
 */
public class Identifier_Format {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[T];
		for(int i = 0 ; i<T; i++) {
			String input = sc.nextLine();
			String[] arr1 = input.split(" ");
			String choice = arr1[0];
			String S1 = arr1[1];
			String S2 = arr1[2];
			arr[i] = converToFormat(choice, S1, S2);
		}
		for(String item : arr) {
			System.out.println(item);
		}
		sc.close();
	}

	private static String converToFormat(String choice, String s1, String s2) {
		String res = "";
		switch(choice) {
		case "A":
			s1 = s1.replaceFirst(Character.toString(s1.charAt(0)), Character.toString(s1.charAt(0)).toLowerCase());
			s2 = s2.replaceFirst(Character.toString(s2.charAt(0)), Character.toString(s2.charAt(0)).toUpperCase());
			res = s1 + s2;
			break;
		case "B":
			s1 = s1.replaceFirst(Character.toString(s1.charAt(0)), Character.toString(s1.charAt(0)).toLowerCase());
			s2 = s2.replaceFirst(Character.toString(s2.charAt(0)), Character.toString(s2.charAt(0)).toLowerCase());
			res = s1 + "_" + s2;
			break;
		case "C" :
			s1 = s1.toUpperCase();
			s2 = s2.toUpperCase();
			res = s1 + "_" + s2;
			break;
		case "D":
			s1 = s1.replaceFirst(Character.toString(s1.charAt(0)), Character.toString(s1.charAt(0)).toUpperCase());
			s2 = s2.replaceFirst(Character.toString(s2.charAt(0)), Character.toString(s2.charAt(0)).toUpperCase());
			res = s1 + "-" + s2;
			break;
		case "E":
		case "F":
		case "G":
		case "H":
			char[] ch1 = s1.toCharArray();
			char[] ch2 = s2.toCharArray();
			s1 = ""; s2 = "";
			boolean toggle = false;
			for(int i = 0; i < ch1.length; i++) {
				if(toggle)
					ch1[i] = Character.toString(ch1[i]).toUpperCase().charAt(0);
				else
					ch1[i] = Character.toString(ch1[i]).toLowerCase().charAt(0);
				toggle = !toggle; 
				s1 += ch1[i];
			}
			toggle = false;
			for(int i = 0; i < ch2.length; i++) {
				if(toggle)
					ch2[i] = Character.toString(ch2[i]).toUpperCase().charAt(0);
				else
					ch2[i] = Character.toString(ch2[i]).toLowerCase().charAt(0);
				toggle = !toggle; 
				s2 += ch2[i];
			}
			
			res = s1 + "|" + s2;
			break;
		}
		return res;
	}

}
