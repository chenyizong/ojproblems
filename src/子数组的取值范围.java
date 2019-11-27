/**
 * 子数组的取值范围
 * Description
 *
 * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 *
 *
 * Input
 *
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为数组，每一个数用空格隔开，第二行为num。
 *
 *
 * Output
 *
 * 输出一个值。
 *
 *
 * Sample Input 1
 *
 * 1
 * 3 6 4 3 2
 * 2
 * Sample Output 1
 *
 * 6
 */

import java.util.Arrays;
import java.util.Scanner;

public class 子数组的取值范围 {
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
