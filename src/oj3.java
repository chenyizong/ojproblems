import java.util.Arrays;
import java.util.Scanner;

public class oj3 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        int res = 0;
        while (Num > 0) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int l = arr.length;
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            int w = Integer.parseInt(sc.nextLine());
            int j, max;
            for (int i = w - 1; i < l; i++) {
                j = i - (w - 1);
                int[] temp = Arrays.copyOfRange(ints, j, i + 1);
                max = max(temp);
                res = res + max;
            }
            Num--;
            System.out.println(res);
            res = 0;
        }
    }

    public static int max(int[] ints) {
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        return max;
    }
}
