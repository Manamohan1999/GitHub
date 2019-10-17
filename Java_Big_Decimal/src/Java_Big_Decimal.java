
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
class Java_Big_Decimal{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        double d1=Double.parseDouble(s[0]);
        BigDecimal bd=BigDecimal.valueOf(d1);
        BigInteger bi=bd.toBigIntegerExact();



        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}