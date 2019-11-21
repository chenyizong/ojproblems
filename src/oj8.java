import java.util.Arrays;
import java.util.Scanner;

public class oj8 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String astr = sc.nextLine();
            String[] arr = astr.split(" ");
            int n = arr.length;
            int[] a = new int[2*n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            String bstr = sc.nextLine();
            String[] barr = bstr.split(" ");
            int j=0;
            for (int i = n; i < (2 * n); i++) {
                a[i] = Integer.parseInt(barr[j]);
                j++;
            }
            int sum = 0;
            for (int i = 0; i < 2 * n; i++) {
                sum = sum + a[i];
            }
            Double mid = sum/2.0;



            System.out.println(new Double(f(mid,a,0,n)*2).intValue());
            Num--;
        }
    }
    public static Double f(Double mid,int[] a,int index,int count){
        if(count==0){
            return mid;
        }
        if(index==a.length){
            return Double.MAX_VALUE;
        }
        if(a[index]>mid){
            return f(mid,a,index+1,count);
        }else {
            return Math.min(f(mid-a[index],a,index+1,count-1),f(mid,a,index+1,count));
        }

    }


}
