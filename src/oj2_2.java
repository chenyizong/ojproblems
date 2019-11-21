
import java.util.Arrays;
import java.util.Scanner;

public class oj2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] c = s.split(" ");
            int n = Integer.parseInt(c[0]);
            String[] str = Arrays.copyOfRange(c, 1, c.length);
            Boolean b = output(n, str);
            System.out.println(b);
            Num--;
        }
    }

    public static Boolean output(int n, String[] str) {
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                if (!str[i].equals(str[n - i - 1])) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < (n - 1) / 2; i++) {
                if (!str[i].equals(str[n - i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
