import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
