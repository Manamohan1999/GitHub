import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Manamohan Samal
 *
 *Prateek has asked Ritesh to give his 10-digit mobile number. But, Ritesh wants to encode digits of his mobile number before giving it to Prateek.

Decoding:
(alphabet position(starting with 0)) % 10
e.g.,
'a' decodes to 0, since 'a' is at 0th position and 0%10 = 0.,
'b' decodes to 1, since 'b' is at 1st position and 1%10 = 1.
…..
…..
'k' decodes to 0, since 'k' is at 10th position and 10%10 = 0.
'l' decodes to 1, since 'l' is at 11th position and 11%10 = 1.
'm' decodes to 2, since m is at 12th position and 12%10 = 2.
and so on upto 'z'.

Encoding:
digit is replaced by characters(one at a time) that decodes to this digit.
e.g.:
0 can be replaced by 'a', or by 'k', or by 'u'.
1 can be replaced by 'b', or by 'l', or by 'v'.
6 can be replaced by 'g', or by 'q'.
and so on upto 9.

Before encoding Ritesh wants to find out number of ways he can encode.
Help Ritesh! 

Input:

    First line will contain T

, the number of test cases. Then the test cases follow:
Each line contains a number N
. 

Output:

For each test case, print the number of possible ways to encode the number. 

Sample Input:

1
5432101234 

Sample Output:

59049 
 */
public class Number_Encoding {
	private static Map<Integer, Integer> map = getCount();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] arr = new long[T];
		for(int i = 0; i < T; i++) {
			long N = sc.nextLong();
			arr[i] = waysOfEncoding(N);
		}
		for(long l : arr) {
			System.out.println(l);
		}
		sc.close();
	}
	
	 private static Map<Integer, Integer> getCount() {
		 List<Character> letters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
			
		 Map<Integer, Integer> map = new HashMap<>();
			letters.forEach(e -> {
				int index = letters.indexOf(e);
				int rem = index % 10;
				if(map.get(rem) == null) {
					map.put(rem, 1);
				}else {
					map.put(rem, map.get(rem) + 1);
				}
			});
		return map;
	 }
	 
	 private static long waysOfEncoding(long l) {
		 long totalWays = 1;
		 char[] charArr = String.valueOf(l).toCharArray();
//		 map.forEach((m,n)->System.out.println(m + "  " + n));
		 for(char ch : charArr) {
			 int count = map.get(Integer.valueOf(Character.toString(ch)));
			 totalWays *= count;
		 }
		 return totalWays;
	 }
}
