import java.util.Scanner;

public class online2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String[] str1 = sc.nextLine().split(" ");
            String[] str2 = sc.nextLine().split(" ");
            String[] str3 = sc.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);
            int[] ints1 = new int[n];
            int[] ints2 = new int[m];
            for (int i = 0; i < n; i++) {
                ints1[i] = Integer.parseInt(str2[i]);
            }
            for (int i = 0; i < m; i++) {
                ints2[i] = Integer.parseInt(str3[i]);
            }

            int[] res = new int[m];
            for (int j = 0; j < m; j++) {
                for (int p = 0; p < n; p++) {
                    if (ints1[p] % ints2[j] == 0) {
                        res[j]++;
                    }
                }
            }
            String s = "";
            for (int k = 0; k < m - 1; k++) {
                s = s + res[k] + " ";
            }
            s = s + res[m - 1];
            System.out.println(s);
            Num--;
        }
    }
}
