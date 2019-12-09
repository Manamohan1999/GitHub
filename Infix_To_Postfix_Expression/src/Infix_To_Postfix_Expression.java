import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
/*
 * this class converts a infix expression to its eqivalent postfix expression
 * using the polis notation 
 */
public class Infix_To_Postfix_Expression {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter an expression:");
		String exp=sc.nextLine();
		String postExp=covertToPostfix(exp);
		System.out.println("The equivalent postfix expression is: "+postExp);
		sc.close();
	}

	private static String covertToPostfix(String exp) {
		String temp=exp.concat(")");
		StringBuilder postexp=new StringBuilder("");
		Stack<String> sc=new Stack<>();
		sc.push("(");
		HashMap<String,Integer> hs=new HashMap<>();
		hs.put("+", 1);
		hs.put("-", 1);
		hs.put("*", 2);
		hs.put("/", 3);
		for (int i = 0; i < temp.length(); i++) {
			String str=String.valueOf(temp.charAt(i));
			if (str.equals("(")) {
				sc.push(str);
			}else if(hs.containsKey(str)) {
				while(hs.containsKey(sc.peek())){
					if(hs.get(sc.peek())>=hs.get(str))
						postexp.append(sc.pop());
				}
				sc.push(str);
			}else if(str.equals(")")) {
				while(!sc.peek().equals("(")) {
					postexp.append(sc.pop());
				}
				sc.pop();
			}else {
				postexp.append(str);
			}
		}
		return postexp.toString();
	}
}
