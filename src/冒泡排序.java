/**
 * 冒泡排序
 * Description
 *
 * 实现冒泡排序。
 *
 *
 * Input
 *
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 *
 * Output
 *
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 *
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * Sample Output 1
 *
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */

import java.util.Arrays;

import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            int n = Integer.parseInt(s2[0]);
            String[] s3 = Arrays.copyOfRange(s2, 1, s2.length);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(s3[i]);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    if(ints[j]>ints[j+1]){
                        int tmp;
                        tmp = ints[j];
                        ints[j] = ints[j+1];
                        ints[j+1] = tmp;
                    }
                }
            }

            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + ints[p] + " ";
            }
            res = res + ints[n - 1];
            System.out.println(res);
        }
    }
}
