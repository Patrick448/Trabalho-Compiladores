import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;

class _Object{
}

class _String{
    public int _x;
    public String _y;
}

class _Integer{
    public int _numerador;
}

public class teste1 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _myFunc(int _num, String _ch)
    {
        int _a;
        int _b;

        _b = (int)1;
        _a = (int)3;
        List<Object> arr = new ArrayList<Object>(); 
        arr.add(_a); 
        arr.add(_b); 
        return arr;
    }

    public static void _main()
    {
        int _var;
        int _x;
        String _i;
        _String _j;
        boolean _k;

        _var = (int)(-50 + 5);
        _j = (_String)new _String();
        _k = (boolean)true;
        _x = (int)(_var + 10);
        _i = (String)"a";
        _j._x = (int)6;
        System.out.print(_i);
        System.out.print(200);
        System.out.print(_k);
        System.out.print(_j._x);
        System.out.print(_x);
    }

    public static void main(String args[]) {
        _main();
    }
}