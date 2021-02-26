import java.util.Scanner;

/**
 * @author Manamohan Samal
 * Ritesh is fond of playing with strings, he always curious to know to find strings property, This time he has three strings S1, S2, S3 and he wants to find , if it is possible to make S2 and S3 equivalent to S1 by Re-arranging characters of S2 and/or S3 any number of times.
For Example:
S1 = "ritesh"
S2 = "irtesh"
S3 = "irtehs"
By performing below rearrangements, it is possible to make S2 and S3 equivalent to S1:
S2 -> S1 (by rearranging first two characters('i', 'r'))
S3 -> S1 (by rearranging first two characters('i', 'r') and last two characters('s', 'h')).

Input:
------
    First line will contain T

, the number of test cases. Then the test cases follow:
Each line contains three space separated strings S1
, S2 and S3.

Output:
-------
For each test case, print "Possible", if it is possible to make S2
and S3 equivalent to S1 by rearranging. else, print "Not Possible" .
 *
 */
public class IdenticalWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		String[] res = new String[T];
		for(int i = 0; i < T; i++) {
			//take the input
			String S1 = sc.next();
			String S2 = sc.next();
			String S3 = sc.next();
			
			//check for identical possibility
			 res[i] = checkIdentical(S1, S2, S3);
		}
		for(String item : res) {
			System.out.println(item);
		}
		//close the input stream
		 sc.close();
	}
	
	public static String checkIdentical(String s1, String s2, String s3) {
		if(s2.equals(s1) && s3.equals(s1)) {
			return "Possible";
		}else if(s1.length() != s2.length() || s1.length() != s3.length()){
			return "Not Possible";
		}else {
			char[] arr1 = s2.toCharArray();
			for(int j = 0; j < arr1.length; j++) {
				char ch = s1.charAt(j);
				if(arr1[j] == ch){
					continue;
				}else {
					boolean flag = false;
					for(int k = j + 1; k < arr1.length; k++) {
						if(arr1[k] == ch) {
							flag = true;
							char temp = arr1[j];
							arr1[j] = ch;
							arr1[k] = temp;
							break;
						}else {
							continue;
						}
					}
					if(flag == true) {
						continue;
					}else {
						return "Not Possible";
					}
				}
			}
			//check for 2nd string
			char[] arr2 = s3.toCharArray();
			for(int j = 0; j < arr2.length; j++) {
				char ch = s1.charAt(j);
				if(arr2[j] == ch){
					continue;
				}else {
					boolean flag = false;
					for(int k = j + 1; k < arr2.length; k++) {
						if(arr2[k] == ch) {
							flag = true;
							char temp = arr2[j];
							arr2[j] = ch;
							arr2[k] = temp;
							break;
						}else {
							continue;
						}
					}
					if(flag == true) {
						continue;
					}else {
						return "Not Possible";
					}
				}
			}
			return "Possible";
		}
	}

}
