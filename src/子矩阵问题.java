/**
 * 子矩阵问题
 * Description
 *
 * 给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
 *
 *
 * Input
 *
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为矩阵行数n和列数m，下面的n行每一行是用空格隔开的0或1。
 *
 *
 * Output
 *
 * 输出一个数值。
 *
 *
 * Sample Input 1
 *
 * 1
 * 3 4
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * Sample Output 1
 *
 * 6
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 子矩阵问题 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int max = 0;
            String rc = sc.nextLine();
            String[] t = rc.split(" ");
            int r = Integer.parseInt(t[0]);
            int c = Integer.parseInt(t[1]);
            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++) {
                String temp = sc.nextLine();
                String[] rowi = temp.split(" ");
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = Integer.parseInt(rowi[j]);
                }
            }

            int[] h = new int[c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == 0) {
                        h[j] = matrix[i][j];
                    } else {
                        if (matrix[i][j] == 0) {
                            h[j] = 0;
                        } else {
                            h[j] = matrix[i - 1][j] + 1;
                            matrix[i][j] = matrix[i - 1][j] + 1;
                        }
                    }
                }
                max = Math.max(max, LargestRectangleArea(h));
            }
            Num--;
            System.out.println(max);

        }
    }

    public static int LargestRectangleArea(int[] h){
        Stack<Integer> stack = new Stack<>();
        int i=1;
        int max = h[0];
        stack.push(0);

        while(i<h.length||(i==h.length&&!stack.isEmpty())){
            if(i!=h.length&&(stack.isEmpty()||h[i]>=h[stack.peek()])){
                stack.push(i);
                i++;
            }else {
                int top = h[stack.pop()];
                int currmax = !stack.isEmpty()?top*(i-stack.peek()-1):top*i;
                max = Math.max(currmax,max);
            }
        }

        return max;
    }



}
