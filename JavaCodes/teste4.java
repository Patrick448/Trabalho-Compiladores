import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;

class _Ponto{
    public Float _x;
    public Float _y;
}

public class teste4 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        _Ponto _p;
        _p = new _Ponto();
        _p._x = 10.0;
        _p._y = 10.0;
        System.out.print("(");
        System.out.print(_p._x);
        System.out.print(",");
        System.out.print(" ");
        System.out.print(_p._y);
        System.out.print(")");
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