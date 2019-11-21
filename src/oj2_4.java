import java.util.Arrays;
import java.util.Scanner;

public class oj2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            int n = Integer.parseInt(s2[0]);
            String[] s3 = Arrays.copyOfRange(s2, 1, s2.length);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(s3[i]);
            }
            int tmp, j;
            for (int i = 1; i < n; i++) {
                tmp = ints[i];
                for (j = i - 1; j >= 0; j--) {
                    if (tmp > ints[j]) {
                        break;
                    } else {
                        ints[j + 1] = ints[j];
                    }
                }
                ints[j + 1] = tmp;
            }
            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + ints[p] + " ";
            }
            res = res + ints[n - 1];
            System.out.println(res);
            Num--;
        }
    }
}
