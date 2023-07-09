import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste0 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        Integer _nlines;
        Integer _i;
        _nlines = 5;
        _i = _nlines;
        int cont1 =0;
        while(cont1 < _nlines){
            int cont0 =0;
            while(cont0 < _i){
                System.out.print("*");
                cont0++;
            }
            _i = (_i - 1);
            System.out.print("\n");
            cont1++;
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