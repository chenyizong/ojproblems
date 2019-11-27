/**
 * 广度优先遍历图
 * Description
 * <p>
 * 按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为测试用例个数，后面每一个用例用多行表示，用例第一行是节点个数n和开始顶点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。值之间使用空格隔开。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出遍历顺序，用空格隔开
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
 * a b c d
 */

import java.util.LinkedList;
import java.util.Scanner;

public class 广度优先遍历 {
    static int n = 0;
    static int[][] G;
    static boolean[] isVisited;
    static String broad = "";
    static String[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            n = Integer.parseInt(s1[0]);
            G = new int[n][n];
            isVisited = new boolean[n];
            String start = s1[1];
            data = sc.nextLine().split(" ");
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

            broadSearch(isVisited, startNode);
            broad = start + " " + broad;
            broad = broad.substring(0, broad.length() - 1);
            System.out.println(broad);

        }
    }

    static void broadSearch(boolean[] isVisited, int i) {
        int u, w;
        LinkedList queue = new LinkedList();
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = ((Integer) queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    queue.addLast(w);
                    String tmp = data[w];
                    broad = broad + tmp + " ";
                }
                w = getNextNeighber(u, w);
            }
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
