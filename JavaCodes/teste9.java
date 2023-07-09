import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste9 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _f(Integer _x)
    {
        Integer _y;
        _y = ((2 * _x) + 1);
        if((_y < 10)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(_y); 
            arr.add(1.5); 
            return arr;
        } else {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(_y); 
            arr.add(1.5); 
            return arr;
        }

    }

    public static void _main()
    {
        Integer _h;
        Float _z;
        _z = _f(10).get(1);
        _h = (2 * _f(10).get(0));
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