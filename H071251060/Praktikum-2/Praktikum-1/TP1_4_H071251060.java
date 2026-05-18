import java.util.Scanner;

public class TP1_4_H071251060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Input : ");
        int n = sc.nextInt();
        
        System.out.println("Output : " + hitungFaktorial(n));
    }

    public static int hitungFaktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * hitungFaktorial(n - 1);
        }
    }
}