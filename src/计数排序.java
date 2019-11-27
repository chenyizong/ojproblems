/**
 * 计数排序
 * Description
 *
 * 实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。
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

public class 计数排序 {
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
            int[] b = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ints[i] > ints[j]) {
                        count++;
                    }
                }
                while (b[count] != 0) {
                    count++;
                }
                b[count] = ints[i];
                count = 0;
            }

            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + b[p] + " ";
            }
            res = res + b[n - 1];
            System.out.println(res);
        }
    }
}
