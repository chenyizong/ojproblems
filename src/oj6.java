import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class oj6 {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int res = 0;
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(ints);
            int num = Integer.parseInt(sc.nextLine());
            int i=0;
            int j=arr.length-1;
            while(i<j){
                if(ints[i]+ints[j]>num){
                    j--;
                }else if(ints[i]+ints[j]<num){
                    i++;
                }else{
                    res++;
                    i++;
                    j--;
                }
            }
            Num--;
            System.out.println(res);
        }
    }
}
