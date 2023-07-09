import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste10 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _fibonacci(Integer _n)
    {
        if((_n < 1)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(_n); 
            return arr;
        } 
        if((_n == 1)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(_n); 
            return arr;
        } 
        List<Object> arr = new ArrayList<Object>(); 
        arr.add((_fibonacci((_n - 1)).get(0) + _fibonacci((_n - 2)).get(0))); 
        return arr;
    }

    public static void _main()
    {
        Integer _v;
        _v = _fibonacci(5).get(0);
        System.out.print(_v);
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