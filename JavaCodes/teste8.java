import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste8 {

    Scanner input = new Scanner(System.in);
    public static List<Object> _myFunc(int _num, String _ch)
    {
        int _a;
        int _b;

        _b = (int)1;
        _a = (int)3;
        List<Object> arr = new ArrayList<Object>(); 
        arr.add(0); 
        arr.add(1); 
        return arr;
    }

    public static void _main()
    {
        int _a;
        int _var;
        int _x;
        int _z;

        _var = (int)(-50 + 5);
        _x = (int)(_var + 10);
        List<Object> arr = new ArrayList<Object>(); 
        arr = _myFunc(_x, "a");
         _z = (int)arr.get(0);
         _a = (int)arr.get(0);
        _a = (int)_myFunc(_x, "a").get(0);
    }

    public static void main(String args[]) {
        _main();
    }
}