/**
 * 深度优先遍历
 * Description
 * <p>
 * 按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行是用例个数，后面每个用例使用多行表示，用例的第一行是图中节点的个数n和起始点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。值之间使用空格隔开。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出深度优先遍历中遇到的最大深度。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 4 a
 * a b c d
 * a 0 1 1 0
 * b 1 0 1 0
 * c 1 1 0 1
 * d 0 0 1 0
 * Sample Output 1
 * <p>
 * 4
 */

import java.util.Scanner;

public class 深度优先遍历 {
    static int n = 0;
    static int[][] G;
    static boolean[] isVisited;
    static int deep = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            n = Integer.parseInt(s1[0]);
            G = new int[n][n];
            isVisited = new boolean[n];
            String start = s1[1];
            String[] data = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                String[] r = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    G[i][j] = Integer.parseInt(r[j + 1]);
                }
            }
            int startNode = 0;
            for (int i = 0; i < data.length; i++) {
                if (start.equals(data[i])) {
                    startNode = i;
                }
            }

            deepSearch(isVisited, startNode);
            System.out.println(deep);

        }
    }

    static void deepSearch(boolean[] isVisited, int i) {
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                deep++;
                deepSearch(isVisited, w);
            }
            w = getNextNeighber(i, w);
        }

    }

    static int getFirstNeighbor(int index) {
        for (int i = 0; i < n; i++) {
            if (G[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    static int getNextNeighber(int v1, int v2) {
        for (int i = v2 + 1; i < n; i++) {
            if (G[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

}
