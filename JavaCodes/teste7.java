import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste7 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        ArrayList<ArrayList<Integer>> _x;
        Integer _i;
        Integer _z;
        Integer _k;
        _k = 5;
        _x = initialize(_k,new ArrayList<Integer>(_k));
        _i = 0;
        int cont0 =0;
        while(cont0 < _k){
            _x.get(_i) = initialize(_k,new ArrayList<Integer>(_k));
            _i = (_i + 1);
            cont0++;
        }
        _i = 0;
        int cont1 =0;
        while(cont1 < _k){
            _x.get(_i).get(_i) = ((2 * _i) + 1);
            _i = (_i + 1);
            cont1++;
        }
        _z = _x.get(3).get(3);
        System.out.print(_k);
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