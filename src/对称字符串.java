import java.util.Scanner;

public class 对称字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String str = sc.nextLine();
            int l = str.length();
            int res = 0;
            for (int i = 2; i <= l; i += 2) {
                for (int j = 0; j <= l - i; j++) {
                    String tmp = str.substring(j, j + i / 2);
                    String tmp2 = str.substring(j + i / 2, i + j);
                    int sum1 = 0, sum2 = 0;
                    for (int k = 0; k < tmp.length(); k++) {
                        sum1 = sum1 + (int) tmp.charAt(k);
                        sum2 = sum2 + (int) tmp2.charAt(k);
                    }
                    if (sum1 == sum2) {
                        res = i;
                    }
                }
            }
            System.out.println(res);
            Num--;
        }
    }
}
