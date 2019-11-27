/**
 * 链表区间逆序
 * Description
 *
 * 将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个表示链表长度，中间为节点值，最后代表K。
 *
 *
 * Output
 *
 * 输出的每一行为新的链表，节点值用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 *
 * 2
 * 8 1 2 3 4 5 6 7 8 3
 * 8 a b c d e f g h 4
 * Sample Output 1
 *
 * 3 2 1 6 5 4 7 8
 * d c b a h g f e
 */

import java.util.Arrays;
import java.util.Scanner;

public class 链表区间逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int num = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[str.length - 1]);
            String[] strings = Arrays.copyOfRange(str, 1, str.length - 1);
            int K_num = num / K;
            int K_num2 = num % K;
            String[] tmp;
            String[] res = new String[num];
            int curr = 0;
            for (int i = 0; i < K_num; i++) {
                tmp = Arrays.copyOfRange(strings, i * K, i * K + K);
                for (int q = tmp.length - 1; q >= 0; q--) {
                    res[curr] = tmp[q];
                    curr++;
                }
            }
            for (int j = num - K_num2; j < num; j++) {
                res[curr] = strings[j];
                curr++;
            }
            String res2 = "";
            for (int p = 0; p < res.length - 1; p++) {
                res2 = res2 + res[p] + " ";
            }
            res2 = res2 + res[res.length - 1];
            System.out.println(res2);
            Num--;
        }
    }
}
