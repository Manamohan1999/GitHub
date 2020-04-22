import java.util.Scanner;
/*
 * Given a list of strings, find the longest common prefix between all strings.

	Here's some examples and some starter code.

	def longest_common_prefix(strs):
  		# Fill this in.
  
	print(longest_common_prefix(['helloworld', 'hellokitty', 'hell']))
		# hell

	print(longest_common_prefix(['daily', 'interview', 'pro']))
		# ''
 */
public class LongestCommonPrefix {
	static String prefix;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the count of strings:");
		int count=sc.nextInt();
		String[] strings=new String[count];
		for(int i=0;i<count;i++) {
			strings[i]=sc.next();
		}
		for(int j=0;;) {
			
		}
	}
}
