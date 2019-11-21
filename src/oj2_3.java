import java.util.Arrays;
import java.util.Scanner;

public class oj2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int num = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[str.length - 1]);
            String[] strings = Arrays.copyOfRange(str, 1, str.length - 1);
            int K_num = num / K;
            int K_num2 = num % K;
            String[] tmp;
            String[] res = new String[num];
            int curr = 0;
            for (int i = 0; i < K_num; i++) {
                tmp = Arrays.copyOfRange(strings, i * K, i * K + K);
                for (int q = tmp.length - 1; q >= 0; q--) {
                    res[curr] = tmp[q];
                    curr++;
                }
            }
            for (int j = num - K_num2; j < num; j++) {
                res[curr] = strings[j];
                curr++;
            }
            String res2 = "";
            for (int p = 0; p < res.length - 1; p++) {
                res2 = res2 + res[p] + " ";
            }
            res2 = res2 + res[res.length - 1];
            System.out.println(res2);
            Num--;
        }
    }
}
