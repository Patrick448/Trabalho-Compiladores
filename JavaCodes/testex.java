import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;

class _Teste{
    public _Teste _numerador;
    public Integer _denominador;
}

public class testex {

    Scanner input = new Scanner(System.in);
    public static List<Object> _func(String _c)
    {
        Integer _x;
        _x = 2;
        List<Object> arr = new ArrayList<Object>(); 
        arr.add(_x); 
        return arr;
    }

    public static List<Object> _otherFunc()
    {
        List<Object> arr = new ArrayList<Object>(); 
        arr.add(1); 
        arr.add(0.5); 
        return arr;
    }

    public static void _main()
    {
        ArrayList<Integer> _a;
        _Teste _t;
        System.out.print("a");
        System.out.print(true);
        System.out.print(1);
        System.out.print(5.55);
        System.out.print((1 + 2));
        System.out.print((1 * 2));
        System.out.print((1 / 2));
        System.out.print((1 - 2));
        System.out.print((1 + -2));
        System.out.print((1 > 2));
        System.out.print((1 < 2));
        System.out.print((1 != 2));
        System.out.print((1 == 2));
        System.out.print((false == !true));
        _a = initialize(5,new ArrayList<Integer>(5));
        System.out.print(_a.get(0));
        _t = new _Teste();
        _t._denominador = 10;
        if((1 < 2)) {
            System.out.print(_t._denominador);
        } 
        int cont0 =0;
        while(cont0 < 5){
            System.out.print("u");
            cont0++;
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