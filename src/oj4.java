import java.util.Arrays;
import java.util.Scanner;

public class oj4 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int num = Integer.parseInt(sc.nextLine());
            Num--;
            System.out.println(H(num));
        }
    }

    public static int H(int n) {
        if (n == 1) {
            return 2;
        }else{
            return H(n-1)*3+2;
        }
    }
}
