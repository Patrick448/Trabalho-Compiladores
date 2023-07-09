import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste2 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        String _x;
        _x = " ";
        System.out.print(">");
        read _x;
        System.out.print(_x);
        System.out.print("\n");
    }

     public static <T> ArrayList<T> initialize(int n, ArrayList<T> a){
             for(int j=0; j<n; j++){
                a.add(null);
            }
            return a;
        }

    public static void main(String args[]) {
        _main();
    }
}