/**
 * 插入排序
 * Description
 *
 * 实现插入排序。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入的每一行代表一个数组，其中的值用空格隔开，第一个值表示数组的长度。
 *
 *
 * Output
 *
 * 输出排序的数组，用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 *
 * 1
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * Sample Output 1
 *
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */

import java.util.Arrays;
import java.util.Scanner;

public class 插入排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            int n = Integer.parseInt(s2[0]);
            String[] s3 = Arrays.copyOfRange(s2, 1, s2.length);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(s3[i]);
            }
            int tmp, j;
            for (int i = 1; i < n; i++) {
                tmp = ints[i];
                for (j = i - 1; j >= 0; j--) {
                    if (tmp > ints[j]) {
                        break;
                    } else {
                        ints[j + 1] = ints[j];
                    }
                }
                ints[j + 1] = tmp;
            }
            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + ints[p] + " ";
            }
            res = res + ints[n - 1];
            System.out.println(res);
            Num--;
        }
    }
}
