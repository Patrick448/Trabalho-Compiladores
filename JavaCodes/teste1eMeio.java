import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste1eMeio {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        Integer _q;
        Integer _w;
        Integer _z;
        Integer _n;
        _n = 13;
        _q = 5;
        _w = _divMod(_n, _q).get(1);
        _z = ((2 * _w) + 1);
        System.out.print("Z");
        System.out.print(":");
        System.out.print(_z);
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