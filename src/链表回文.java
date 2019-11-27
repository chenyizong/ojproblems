/**
 * 链表回文
 * Description
 *
 * 判断一个单向链表是否为回文结构。自定义链表数据结构，要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个值为节点个数，后面为每一个节点值
 *
 *
 * Output
 *
 * 是回文则输出true，不是则输出false，一行表示一个链表的结果。
 *
 *
 * Sample Input 1
 *
 * 4
 * 3 1 2 1
 * 4 1 2 2 1
 * 3 3 5 3
 * 6 a b c d c a
 * Sample Output 1
 *
 * true
 * true
 * true
 * false
 */
import java.util.Arrays;
import java.util.Scanner;

public class 链表回文 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] c = s.split(" ");
            int n = Integer.parseInt(c[0]);
            String[] str = Arrays.copyOfRange(c, 1, c.length);
            Boolean b = output(n, str);
            System.out.println(b);
            Num--;
        }
    }

    public static Boolean output(int n, String[] str) {
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                if (!str[i].equals(str[n - i - 1])) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < (n - 1) / 2; i++) {
                if (!str[i].equals(str[n - i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
