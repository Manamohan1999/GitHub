import java.math.BigInteger;
import java.util.Scanner;

public class Java_Primarility_Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=sc.nextInt();
		boolean prime=test_For_Prime(num);
		if (prime) 
			System.out.println("prime");
		else
			System.out.println("not prime");
		sc.close();
	}

	private static boolean test_For_Prime(int num) {
		BigInteger bigint=BigInteger.valueOf(num);
		return bigint.isProbablePrime(num);
	}
}
