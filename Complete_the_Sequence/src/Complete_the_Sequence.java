import java.util.Scanner;

/**
 * @author Manamohan Samal
 *
 *You have given the following sequence:
	1,2,3,4,6,9,13,19,...
	Can you complete the sequence till Nth term ? 
	
	Input:

    First line will contain T

, the number of test cases. Then the test cases follow:
Each line contains a number N
.

Output:

For each test case, print the Nth
term of the given sequence.

Sample Input:

3
4
8
9 

Sample Output:

4
19
28 
 */
public class Complete_the_Sequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		long[] res = new long[T];
		
		//get the inputs for each test case
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			res[i] = getSequence(N);
		}
		
		//display the result
		for(long item : res) {
			System.out.println(item);
		}
		
		//close the input stream
		sc.close();
	}

	private static long getSequence(int n) {
		long[] initial = {1, 2, 3};
		if(n > initial.length) {
			long first = initial[0];
			long second = initial[1];
			long current = initial[2];
			 
			long res = 0;
			for(int i = 4; i <= n; i++) {
				res = current + first;
				first = second;
				second = current;
				current = res;
				if(i == n) {
					break;
				}else {
					continue;
				}
			}
			return res;
		}else {
			return initial[n-1];
		}
	}

}
