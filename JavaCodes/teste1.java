import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste1 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        Integer _q;
        Integer _res;
        Integer _quo;
        Integer _n;
        _n = 13;
        _q = 5;
        List<Object> arr = new ArrayList<Object>(); 
        arr = _divMod(_n, _q);
         _quo = (Integer)arr.get(0);
         _res = (Integer)arr.get(0);
        System.out.print("Q");
        System.out.print(":");
        System.out.print(_quo);
        System.out.print("\n");
        System.out.print("R");
        System.out.print(":");
        System.out.print(_res);
        System.out.print("\n");
    }

    public static List<Object> _divMod(Integer _n, Integer _q)
    {
        List<Object> arr = new ArrayList<Object>(); 
        arr.add((_n / _q)); 
        arr.add((_n % _q)); 
        return arr;
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