/**
 * 管道网络
 * Description
 *
 * Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap. Find the efficient way for the construction of the network of pipes.
 *
 *
 * Input
 *
 * The first line contains an integer T denoting the number of test cases. For each test case, the first line contains two integer n & p denoting the number of houses and number of pipes respectively. Next, p lines contain 3 integer inputs a, b & d, d denoting the diameter of the pipe from the house a to house b.Constraints:1<=T<=50，1<=n<=20，1<=p<=50，1<=a, b<=20，1<=d<=100
 *
 *
 * Output
 *
 * For each test case, the output is the number of pairs of tanks and taps installed i.e n followed by n lines that contain three integers: house number of tank, house number of tap and the minimum diameter of pipe between them.
 *
 *
 * Sample Input 1
 *
 * 1
 * 9 6
 * 7 4 98
 * 5 9 72
 * 4 6 10
 * 2 8 22
 * 9 7 17
 * 3 1 66
 * Sample Output 1
 *
 * 3
 * 2 8 22
 * 3 1 66
 * 5 6 10
 */

import java.util.Scanner;
import java.util.TreeMap;


public class 管道网络 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int h = in.nextInt();
            int p = in.nextInt();
            TreeMap<Integer, PipeLine> pipes = new TreeMap<>();
            int count = 0;
            for (int i = 0; i < p; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int d = in.nextInt();
                if (pipes.containsKey(a) && pipes.containsKey(b)) {
                    PipeLine pipe1 = pipes.get(a);
                    PipeLine pipe2 = pipes.get(b);
                    pipe1.next = pipe2;
                    pipe2.prev = pipe1;
                    pipe1.diameter = Math.min(pipe1.diameter, Math.min(pipe2.diameter, d));
                } else if (pipes.containsKey(a)) {
                    PipeLine pipe2 = new PipeLine(b);
                    pipe2.value = b;
                    pipe2.diameter = d;
                    PipeLine pipe1 = pipes.get(a);
                    pipe1.next = pipe2;
                    pipe2.prev = pipe1;
                    pipes.put(b, pipe2);
                } else if (pipes.containsKey(b)) {
                    PipeLine pipe1 = new PipeLine(a);
                    PipeLine pipe2 = pipes.get(b);
                    pipe1.value = a;
                    pipe1.diameter = d;
                    pipe1.next = pipe2;
                    pipe2.prev = pipe1;
                    pipes.put(a, pipe1);
                } else {
                    PipeLine pipe1 = new PipeLine(a);
                    PipeLine pipe2 = new PipeLine(b);
                    pipe1.value = a;
                    pipe1.diameter = d;
                    pipe2.value = b;
                    pipe2.diameter = d;
                    pipe1.next = pipe2;
                    pipe2.prev = pipe1;
                    count++;
                    pipes.put(a, pipe1);
                    pipes.put(b, pipe2);
                }
            }
            count = 0;
            for (int tmp : pipes.keySet()) {
                if (pipes.get(tmp).prev != null) continue;
                count++;
            }
            System.out.println(count);
            for (int tmp : pipes.keySet()) {
                if (pipes.get(tmp).prev != null) continue;
                PipeLine curr = pipes.get(tmp);
                System.out.print(curr.value + " ");
                int min = curr.diameter;
                while (curr != null) {
                    int d = curr.diameter;
                    if (d < min) {
                        min = d;
                    }
                    if (curr.next == null) System.out.print(curr.value + " ");
                    curr = curr.next;
                }
                System.out.println(min);
            }
        }
    }
}
class PipeLine {
    PipeLine next;
    PipeLine prev;
    int value;
    int diameter;
    PipeLine() {
        this.next = null;
        this.prev = null;
    }
    PipeLine(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}

