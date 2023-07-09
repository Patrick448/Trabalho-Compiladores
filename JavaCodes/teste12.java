import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste12 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _even(Integer _n)
    {
        if((_n == 0)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(true); 
            return arr;
        } else {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(_odd((_n - 1)).get(0)); 
            return arr;
        }

    }

    public static List<Object> _odd(Integer _n)
    {
        if((_n == 0)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(false); 
            return arr;
        } else {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(_even((_n - 1)).get(0)); 
            return arr;
        }

    }

    public static void _main()
    {
        Boolean _r;
        _r = _even(3).get(0);
        if(_r) {
            System.out.print("P");
            System.out.print("A");
            System.out.print("R");
        } else {
            System.out.print("I");
            System.out.print("M");
            System.out.print("P");
            System.out.print("A");
            System.out.print("R");
        }

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