import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste8 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _fat(Integer _n)
    {
        if((_n == 0)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(1); 
            return arr;
        } 
        List<Object> arr = new ArrayList<Object>(); 
        arr.add((_n * _fat((_n - 1)).get(0))); 
        return arr;
    }

    public static List<Object> _spook(Integer _n)
    {
        if((_n == 1)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add((2 * _n)); 
            return arr;
        } 
        if((_n == 2)) {
            List<Object> arr = new ArrayList<Object>(); 
            arr.add(((2 * _n) + 1)); 
            return arr;
        } 
        List<Object> arr = new ArrayList<Object>(); 
        arr.add((_n - 1)); 
        return arr;
    }

    public static void _main()
    {
        Integer _k;
        _k = _fat(6).get(0);
        _k = _spook(2).get(0);
        System.out.print(_k);
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