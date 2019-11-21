
import java.util.Scanner;

/**
 * 描述
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that
 * prints all occurrences of pat[] in txt[]. You may assume that n > m.
 * <p>
 * <p>
 * 输入
 * 输入第一行是用例个数，后面一行表示一个用例；用例包括两部分，第一部分为给定文本，第二部分为搜索串，两部分使用","隔开。
 * <p>
 * <p>
 * 输出
 * 每一个用例输出一行，每行按照找到的位置先后顺序排列，使用空格隔开。
 * <p>
 * <p>
 * 输入样例 1
 * 2
 * THIS IS A TEST TEXT,TEST
 * AABAACAADAABAABA,AABA
 * <p>
 * 输出样例 1
 * 10
 * 0 9 12
 */
public class online2_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s = sc.nextLine();
            String[] str = s.split(",");
            String txt = str[0];
            int txt_l = txt.length();
            String serc = str[1];
            int serc_l = serc.length();
            int tmp;
            String res = "";
            for (int i = 0; i < txt_l-serc_l+1; i++) {
                tmp = i;
                for (int j = 0; j < serc_l; j++) {
                    if (txt.charAt(tmp) == serc.charAt(j)) {
                        tmp++;
                    } else {
                        tmp = 0;
                        break;
                    }
                }
                if (tmp != 0) {
                    res = res + i + " ";
                }
            }
            System.out.println(res.substring(0,res.length()-1));
            Num--;
        }
    }
}