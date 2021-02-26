import java.util.Arrays;
import java.util.Scanner;

public class HeadTailSequence {
	static int[] c = new int[8];

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String s= sc.nextLine();
		for(int i=0,j=i+3;i<=s.length()-3;i++,j++) {
			String sub = s.substring(i, j);
			System.out.println(sub);
			if(sub.equals("TTT")) {
				c[0] ++;
			}else if(sub.equals("TTH")) {
				c[1] ++;
			}else if(sub.equals("THT")) {
				c[2] ++;
			}else if(sub.equals("THH")) {
				c[3] ++;
			}else if(sub.equals("HTT")) {
				c[4] ++;
			}else if(sub.equals("HTH")) {
				c[5] ++;
			}else if(sub.equals("HHT")) {
				c[6] ++;
			}else if(sub.equals("HHH")) {
				c[7] ++;
			}
		}
		System.out.println(Arrays.toString(c));
		sc.close();
	}

}

