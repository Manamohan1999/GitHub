

import java.util.Scanner;
/*
Someone just won the Code Jam lottery, and we owe them N jamcoins!
However, when we tried to print out an oversized check, we encountered a problem.
The value of N, which is an integer, includes at least one digit that is a 4... and
the 4 key on the keyboard of our oversized check printer is broken.

Fortunately, we have a workaround:
we will send our winner two checks for positive integer amounts A and B,
such that neither A nor B contains any digit that is a 4, and A + B = N.
Please help us find any pair of values A and B that satisfy these conditions.
 */

public class Dividing_JAMCOINS {
    private static int num;
    private static boolean baby;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an Integer :");
        num=sc.nextInt();

        Find_for_4(num);
        sc.close();

    }

    private static void Find_for_4(int num){
        String s1=String.valueOf(num);
        String[] s2=new String[s1.length()];
        for (int i=0;i<s1.length();i++){
            s2[i]=String.valueOf(s1.charAt(i));
        }
        String dummy;
        String s3="";
        for (int i=0;i<s2.length;i++){
            dummy=s2[i];
            if (dummy.equals("4")){
                s2[i]=String.valueOf(Integer.parseInt(dummy)-1);
                baby=true;
            }
            s3=s3.concat(s2[i]);
        }
        if (baby){
            int newNum1=Integer.parseInt(s3);
            int newNum2=num-newNum1;
            System.out.println("Num 1:"+newNum1);
            System.out.println("Num 2:"+newNum2);
        }else{
            System.out.println("Num:"+num);
        }
    }
}
