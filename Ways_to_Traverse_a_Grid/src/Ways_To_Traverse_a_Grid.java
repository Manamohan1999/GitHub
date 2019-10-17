import java.util.Scanner;

public class Ways_To_Traverse_a_Grid {
    private static int row;
    private static int column;
    private static int count;
    private static void Num_Ways(int i, int j){
        if (i!=row || j!=column) {
            if (i<row) {
                Num_Ways(i+1, j);
            }
            if (j<column) {
                Num_Ways(i, j+1);
            }
            return;
        }
        count++;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Grid Size:");
        System.out.println("Row:");
        row=sc.nextInt();
        System.out.println("Column:");
        column=sc.nextInt();
        Num_Ways(1,1);
        System.out.println("Total number of ways to go from top-left to bottom-right is:"+count);
        sc.close();
    }
}