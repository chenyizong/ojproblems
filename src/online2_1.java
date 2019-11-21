import java.util.Scanner;

public class online2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            int n = s.length();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = (int) s.charAt(i) - 48;
            }
            int sum1 = 0;
            int sum2 = 0;
            int max = 0;
            for (int j = 2; j < n; j = j + 2) {
                for (int k = 0; k < n - j + 1; k++) {
                    for (int p = k; p < k + j / 2; p++) {
                        sum1 = sum1 + ints[p];
                    }
                    for (int q = k + j / 2; q < k + j; q++) {
                        sum2 = sum2 + ints[q];
                    }
                    if (sum1 == sum2) {
                        max = Math.max(max,j);
                        sum1 = 0;
                        sum2 = 0;
                    } else {
                        sum1 = 0;
                        sum2 = 0;
                    }
                }
            }
            System.out.println(max);
            Num--;
        }
    }
}
