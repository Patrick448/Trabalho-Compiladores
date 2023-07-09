import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;


public class teste11 {

    Scanner input = new Scanner(System.in);
    public static void _main()
    {
        Integer _nlines;
        _nlines = 5;
        int cont1 =0;
        while(cont1 < _nlines){
            Integer _i;
            _i = _nlines;
            int cont0 =0;
            while(cont0 < _i){
                System.out.print("*");
                cont0++;
            }
            _nlines = (_nlines - 1);
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