import java.util.Arrays;
import java.util.Scanner;

public class oj2_6 {
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
            int[] b = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ints[i] > ints[j]) {
                        count++;
                    }
                }
                while (b[count] != 0) {
                    count++;
                }
                b[count] = ints[i];
                count = 0;
            }

            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + b[p] + " ";
            }
            res = res + b[n - 1];
            System.out.println(res);
        }
    }
}
