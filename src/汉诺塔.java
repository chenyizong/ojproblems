/**
 * 汉诺塔
 * Description
 *
 * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入的第一行为N。
 *
 *
 * Output
 *
 * 移动步数。
 *
 *
 * Sample Input 1
 *
 * 1
 * 2
 * Sample Output 1
 *
 * 8
 */

import java.util.Scanner;

public class 汉诺塔 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int num = Integer.parseInt(sc.nextLine());
            Num--;
            System.out.println(H(num));
        }
    }

    public static int H(int n) {
        if (n == 1) {
            return 2;
        }else{
            return H(n-1)*3+2;
        }
    }
}
