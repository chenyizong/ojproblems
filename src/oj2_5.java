import java.util.Arrays;
import java.util.Scanner;

public class oj2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            int n = Integer.parseInt(s2[0]);
            String[] s3 = Arrays.copyOfRange(s2, 1, s2.length);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(s3[i]);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    if(ints[j]>ints[j+1]){
                        int tmp;
                        tmp = ints[j];
                        ints[j] = ints[j+1];
                        ints[j+1] = tmp;
                    }
                }
            }

            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + ints[p] + " ";
            }
            res = res + ints[n - 1];
            System.out.println(res);
        }
    }
}
