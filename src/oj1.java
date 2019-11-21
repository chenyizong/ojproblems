import java.util.Arrays;
import java.util.Scanner;

public class oj1 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (Num > 0) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int l = arr.length;
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            int num = Integer.parseInt(sc.nextLine());
            for (int k = 0; k < l - 1; k++) {
                int end = k + 2;
                while (end < l + 1) {
                    int[] temp = Arrays.copyOfRange(ints, k, end);
                    int min = min(temp);
                    int max = max(temp);
//                    System.out.println("min:" + min + ";max:" + max);
                    if (max - min > num) {
                        count++;
                    }
                    end++;
                }
            }

            Num--;
            System.out.println(count);
            count = 0;
        }

    }

    public static int min(int[] ints) {
        int min = 100;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < min) {
                min = ints[i];
            }
        }
        return min;
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
