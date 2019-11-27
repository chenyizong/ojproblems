/**
 * 区间第k最小
 * Description
 *
 * 找到给定数组的给定区间内的第K小的数值。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个数用空格隔开；第二行是区间（第几个数到第几个数，两头均包含），两个值用空格隔开；第三行为K值。
 *
 *
 * Output
 *
 * 结果。
 *
 *
 * Sample Input 1
 *
 * 1
 * 1 2 3 4 5 6 7
 * 3 5
 * 2
 * Sample Output 1
 *
 * 4
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 区间第k最小 {

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
