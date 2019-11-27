import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 拓扑排序解的个数
 * Description
 * <p>
 * 给定有向无环图中所有边，计算图的拓扑排序解的个数。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。
 * <p>
 * <p>
 * Output
 * <p>
 * 输出拓扑排序解的个数。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * a c,b c,c d,d e,d f,e g,f g
 * Sample Output 1
 * <p>
 * 4
 */
public class 拓扑排序解的个数 {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num-- > 0) {
            String[] s = sc.nextLine().split(",");
            int side = s.length;
            search(s, side);
            System.out.println(res);


        }
    }

    static void search(String[] s, int side) {
        if (side == 0) {
            res++;
        } else {
            List<Character> chars = new ArrayList<>();
            HashMap<Character, Integer> after = new HashMap<>();
            HashMap<Character, Integer> before = new HashMap<>();
            for (int i = 0; i < side; i++) {
                String[] tmp = s[i].split(" ");
                char start = tmp[0].charAt(0);
                char end = tmp[1].charAt(0);

                if (!after.containsKey(start)) {
                    after.put(start, 1);
                } else {
                    after.put(start, after.get(start).intValue() + 1);
                }
                if (!before.containsKey(before)) {
                    before.put(end, 1);
                } else {
                    before.put(end, before.get(end).intValue() + 1);
                }

                if (!chars.contains(start)) {
                    chars.add(start);
                }
                if (!chars.contains(end)) {
                    chars.add(end);
                }
            }
            for (char i = 0; i < chars.size(); i++) {
                if (!before.containsKey(chars.get(i))) {
                    List<String> list = new ArrayList<>();
                    for (int j = 0; j < side; j++) {
                        if (s[j].charAt(0) != chars.get(i)) {
                            list.add(s[j]);
                        }
                    }
                    String[] str = new String[list.size()];
                    for (int k = 0; k < list.size(); k++) {
                        str[k] = list.get(k);
                    }
                    search(str, str.length);
                }
            }
        }
    }
}
