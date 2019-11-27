
/**
 * 棋盘覆盖问题
 * Description
 * <p>
 * 棋盘覆盖问题：给定一个大小为2^n2^n个小方格的棋盘，其中有一个位置已经被填充，现在要用一个L型（22个小方格组成的大方格中去掉其中一个小方格）形状去覆盖剩下的小方格。求出覆盖方案，即哪些坐标下的小方格使用同一个L型格子覆盖。注意：坐标从0开始。左上方的第一个格子坐标为(0,0)，第一行第二个坐标为(0,1)，第二行第一个为(1,0)，以此类推。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为测试用例个数，后面每一个用例有两行，第一行为n值和特殊的格子的坐标（用空格隔开），第二行为需要查找其属于同一个L型格子的格子坐标。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出每一行为一个用例的解，先按照行值从小到大、再按照列值从小到大的顺序输出每一个用例的两个坐标；用逗号隔开。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 1 1 1
 * 0 0
 * Sample Output 1
 * <p>
 * 0 1,1 0
 */
import java.util.Scanner;

public class 棋盘覆盖问题 {
    static int index = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int missed_x = Integer.parseInt(s[1]);
            int missed_y = Integer.parseInt(s[2]);
            String[] s2 = sc.nextLine().split(" ");
            int target_x = Integer.parseInt(s2[0]);
            int target_y = Integer.parseInt(s2[1]);
            int l = (int) Math.pow(2, n);
            int[][] m = new int[l][l];
            tromino(m, 0, 0, index, missed_x, missed_y, l);
            int target_num = m[target_x][target_y];
            String res = "";
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    if (i != target_x || j != target_y) {
                        if (m[i][j] == target_num) {
                            res = res + i + " " + j + ",";
                        }
                    }
                }
            }
            System.out.println(res.substring(0, res.length() - 1));
        }
    }

    static void tromino(int[][] m, int start_x, int start_y, int index1, int missed_x, int missed_y, int l) {
        if (l == 1) {
            return;
        }
        //在第一象限
        else if (missed_x <= (start_x + l / 2 - 1) && missed_y <= (start_y + l / 2 - 1)) {
            m[start_x + l / 2][start_y + l / 2 - 1] = index1;
            m[start_x + l / 2][start_y + l / 2] = index1;
            m[start_x + l / 2 - 1][start_y + l / 2] = index1;
            index++;
            tromino(m, start_x + l / 2, start_y, index, start_x + l / 2, start_y + l / 2 - 1, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y + l / 2, index, start_x + l / 2, start_y + l / 2, l / 2);
            index++;
            tromino(m, start_x, start_y + l / 2, index, start_x + l / 2 - 1, start_y + l / 2, l / 2);
            index++;
            tromino(m, start_x, start_y, index, missed_x, missed_y, l / 2);
        }
        //在第二象限
        else if (missed_x > (start_x + l / 2 - 1) && missed_y <= (start_y + l / 2 - 1)) {
            m[start_x + l / 2 - 1][start_y + l / 2 - 1] = index1;
            m[start_x + l / 2 - 1][start_y + l / 2] = index1;
            m[start_x + l / 2][start_y + l / 2] = index1;
            index++;
            tromino(m, start_x, start_y, index, start_x + l / 2 - 1, start_y + l / 2 - 1, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y + l / 2, index, start_x + l / 2, start_y + l / 2, l / 2);
            index++;
            tromino(m, start_x, start_y + l / 2, index, start_x + l / 2 - 1, start_y + l / 2, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y, index, missed_x, missed_y, l / 2);
        }
        //在第三象限
        else if (missed_x > (start_x + l / 2 - 1) && missed_y > (start_y + l / 2 - 1)) {
            m[start_x + l / 2 - 1][start_y + l / 2 - 1] = index1;
            m[start_x + l / 2 - 1][start_y + l / 2] = index1;
            m[start_x + l / 2][start_y + l / 2 - 1] = index1;
            index++;
            tromino(m, start_x, start_y, index, start_x + l / 2 - 1, start_y + l / 2 - 1, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y + l / 2, index, missed_x, missed_y, l / 2);
            index++;
            tromino(m, start_x, start_y + l / 2, index, start_x + l / 2 - 1, start_y + l / 2, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y, index, start_x + l / 2, start_y + l / 2 - 1, l / 2);
        }
        //在第四象限
        else if (missed_x <= (start_x + l / 2 - 1) && missed_y > (start_y + l / 2 - 1)) {
            m[start_x + l / 2 - 1][start_y + l / 2 - 1] = index1;
            m[start_x + l / 2][start_y + l / 2] = index1;
            m[start_x + l / 2][start_y + l / 2 - 1] = index1;
            index++;
            tromino(m, start_x, start_y, index, start_x + l / 2 - 1, start_y + l / 2 - 1, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y + l / 2, index, start_x + l / 2, start_y + l / 2, l / 2);
            index++;
            tromino(m, start_x, start_y + l / 2, index, missed_x, missed_y, l / 2);
            index++;
            tromino(m, start_x + l / 2, start_y, index, start_x + l / 2, start_y + l / 2 - 1, l / 2);
        }
    }
}
