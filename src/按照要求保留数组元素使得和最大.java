import java.lang.*;
import java.util.*;

class 按照要求保留数组元素使得和最大 {
    public static void main(String[] args) {
        int i;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            ArrayList<Integer> li = new ArrayList<>();
            for (i = 0; i < n; i++) {
                li.add(in.nextInt());
            }

            int sum = 0;
            check(li, n, sum);
        }
    }

    static void check(ArrayList<Integer> li, int n, int sum) {
        if (li.size() == 0) {
            System.out.println(sum);
            return;
        } else {
            Collections.sort(li);
            int num = li.get(li.size() - 1);
            sum = sum + num;
            li.remove(li.size() - 1);
            if (li.size() == 0) {
                System.out.println(sum);
                return;
            }
            if (li.contains(num - 1)) {
                li.remove(Integer.valueOf(num - 1));
            }
            n = li.size();
            check(li, n, sum);
        }
    }
}