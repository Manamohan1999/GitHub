import java.util.Scanner;
/*
 * Given a positive integer n, find all primes less than n.

Here's an example and some starter code:

def find_primes(n):
  # Fill this in.

print(find_primes(14))
# [2, 3, 5, 7, 11, 13]
 */
public class Find_Primes {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int input=sc.nextInt();
		findPrimes(input);
		sc.close();
	}
	
	public static void findPrimes(int input) {
		for (int i = 2; i <= input; i++) {
			if(checkPrime(i)) 
				System.out.print(i+" ");
		}
	}
	public static boolean checkPrime(int input) {
		int count=0;
		for (int j = 1; j <= input; j++) {
			if (input%j==0) {
				count++;
			}
		}
		if(count==2)
			return true;
		else
			return false;
	}
}
