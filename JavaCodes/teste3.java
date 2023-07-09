import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste3 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        ArrayList<Integer> _x;
        Integer _i;
        Integer _k;
        _k = 4;
        _x = initialize(_k,new ArrayList<Integer>(_k));
        _x.get(0) = 0;
        _x.get(3) = 15;
        System.out.print(_x.get(3));
        System.out.print("\n");
        _i = 0;
        int cont0 =0;
        while(cont0 < _k){
            if(((_i % 2) == 0)) {
                _x.get(_i) = (2 * _i);
            } else {
                _x.get(_i) = ((2 * _i) + 1);
            }

            _i = (_i + 1);
            cont0++;
        }
        _i = 0;
        System.out.print("{");
        if((0 < _k)) {
            System.out.print(_x.get(0));
            int cont1 =0;
            while(cont1 < (_k - 1)){
                System.out.print(",");
                System.out.print(_x.get((_i + 1)));
                _i = (_i + 1);
                cont1++;
            }
        } 
        System.out.print("}");
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