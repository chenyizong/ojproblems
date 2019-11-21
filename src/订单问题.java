import java.util.Scanner;

/**
 * Description
 * <p>
 * Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. The amount of tips may differ when handled by different waiters, if Rahul takes the ith order, he would be tipped Ai rupees and if Ankit takes this order, the tip would be Bi rupees.In order to maximize the total tip value they decided to distribute the order among themselves. One order will be handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money after processing all the orders.
 * <p>
 * <p>
 * Input
 * <p>
 * • The first line contains one integer, number of test cases.
 * <p>
 * • The second line contains three integers N, X, Y.
 * <p>
 * • The third line contains N integers. The ith integer represents Ai.
 * <p>
 * • The fourth line contains N integers. The ith integer represents Bi.
 * <p>
 * <p>
 * Output
 * <p>
 * Print a single integer representing the maximum tip money they would receive.
 */


public class 订单问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            int n = (int)s.charAt(0)-'0';
            int X = (int)s.charAt(2)-'0';
            int Y = (int)s.charAt(4)-'0';
            String[] str = sc.nextLine().split(" ");
            String[] str2 = sc.nextLine().split(" ");
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
                b[i] = Integer.parseInt(str2[i]);
            }
            int res = count(a, b, 0, 0, X, Y, 0, 0, n);
            System.out.println(res);
            Num--;
        }
    }

    static int count(int[] A, int[] B, int i, int result, int RA, int RB, int CA, int CB, int size) {
        if(i==size){
            return result;
        }
        if (CA == RA) {
            result = count(A, B, i + 1, result + B[i], RA, RB, CA, CB + 1, size);
        } else {
            if (CB == RB) {
                result = count(A, B, i + 1, result + A[i], RA, RB, CA + 1, CB, size);
            } else {

                int temp1 = count(A, B, i + 1, result + B[i], RA, RB, CA, CB + 1, size);
                int temp2 = count(A, B, i + 1, result + A[i], RA, RB, CA + 1, CB, size);
                result = Math.max(temp1, temp2);

            }
        }
        return result;
    }

}
