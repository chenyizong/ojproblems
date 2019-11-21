import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class oj5 {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int res = 0;
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            String interval = sc.nextLine();
            String[] t = interval.split(" ");
            int start = Integer.parseInt(t[0]);
            int end = Integer.parseInt(t[1]);
            int num = Integer.parseInt(sc.nextLine());
            int[] temp = Arrays.copyOfRange(ints, start - 1, end);
            Arrays.sort(temp);
            res = temp[num - 1];
            Num--;
            System.out.println(res);
        }
    }
}
