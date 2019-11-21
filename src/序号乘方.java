import java.util.Scanner;

public class 序号乘方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while(Num>0){
            long power = Long.parseLong(sc.nextLine());
            long T = 1;
            while (power>=T*T){
                power=power-T*T;
                T++;
            }
            System.out.println(T-1);
            Num--;
        }
    }
}
