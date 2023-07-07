import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;

class _Racional{
    public int _numerador;
    public int _denominador;
}

public class teste3 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _f(_Racional _r)
    {
        int _res;

        _res = (_r._numerador / _r._denominador);
        List<Object> arr = new ArrayList<Object>(); 
        arr.add(_res); 
        return arr;
    }

    public static void _main()
    {
        _Racional _r;

        _r = new _Racional();
        _r._numerador = 1;
        _r._denominador = 2;
        System.out.print(_f(_r).get(0));
    }

    public static void main(String args[]) {
        _main();
    }
}