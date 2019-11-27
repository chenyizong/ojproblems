/**
 * 数学公式
 * Description
 *
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 *
 *
 * Input
 *
 * The first line of input consists number of the test cases. The following T lines consist of 3 numbers each separated by a space and in the following order:A B C'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5
 *
 *
 * Output
 *
 * In each separate line print the modular exponent of the given numbers in the test case.
 *
 *
 * Sample Input 1
 *
 * 3
 * 3 2 4
 * 10 9 6
 * 450 768 517
 * Sample Output 1
 *
 * 1
 * 4
 * 34
 */

import java.util.Scanner;

public class 数学公式 {
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
