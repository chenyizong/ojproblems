/**
 * /**
 *  * Description
 *  *
 *  * Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively.
 *  * In i-th step, A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A), where | denotes concatenation.
 *  *
 *  * Constraints:1<=Q<=10^5, 1<=POS<=10^12
 *  *
 *  *
 *  * Input
 *  *
 *  * 输入第一行为查询次数，后面为每次查询的具体字符位置。
 *  *
 *  *
 *  * Output
 *  *
 *  * 输出每一次查询位置上的字符。
 *  *
 *  */

import java.util.Scanner;

public class 无限递归字符串查询 {
    public static final String A = "12345";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            long index = Long.parseLong(sc.nextLine());
            long step = 0;
            long l = 5 + step;
            while (index > l) {
                step += 1;
                l = l * 2 + step;
            }
            System.out.println(search(index, l, step));
            Num--;
        }
    }

    static char search(long index, long l, long step) {
        long left, right;
        if (l % 2 == 0) {
            left = l / 2;
            right = l / 2 + 1;
        } else {
            left = l / 2 + 1;
            right = l / 2 + 1;
        }
        if (index <= 5) {
            return A.charAt((int) (index - 1));
        }else if (index <= (right + (step - 1) / 2) && index >= (left - (step - 1) / 2)) {
            return '$';
        }else if (index > (right + (step - 1) / 2)) {
            index = l - index + 1;
        }
        long l2 = (l - step) / 2;
        return search(index, l2, step - 1);
    }
}
