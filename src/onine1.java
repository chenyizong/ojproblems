import java.util.Scanner;

public class onine1 {
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
            int a = ints[0];
            int b = ints[1];
            int c = ints[2];

            System.out.println(f(a, b, c));

            Num--;
        }
    }

    public static int f(int a, int b, int c) {
        int res = 0;
        if (b == 1) {
            return a % c;
        }
        if (b % 2 == 0) {
            res = (f(a, b / 2, c) * f(a, b / 2, c)) % c;
        } else {
            res = (f(a, b - 1, c) * a % c) % c;
        }
        return res;
    }

}
