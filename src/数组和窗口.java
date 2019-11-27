/**
 * 数组和窗口
 * Description
 *
 * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个元素使用空格隔开；第二行为窗口大小。
 *
 *
 * Output
 *
 * 输出每个测试用例结果。
 *
 *
 * Sample Input 1
 *
 * 1
 * 4 3 5 4 3 3 6 7
 * 3
 * Sample Output 1
 *
 * 32
 */

import java.util.Arrays;
import java.util.Scanner;

public class 数组和窗口 {
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
