import java.util.Scanner;
import java.util.Stack;

public class Valid_Paratheses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String input = sc.next();
		boolean isValid = checkParantheses(input);
		if(isValid)
			System.out.println("The input string is valid");
		else
			System.out.println("The input string is not valid");
		sc.close();
	}
	public static boolean checkParantheses(String input) {
		try {
			char[] arr = input.toCharArray();
			Stack<Character> stack = new Stack<>();
			for(char item : arr) {
				if(item == '(') {
					stack.push(item);
				}else if(item == ')') {
					stack.pop();
				}
			}
			if(stack.empty()) 
				return true;
			else
				return false;
		}catch(Exception ex) {
			return false;
		}
		
	}
}
