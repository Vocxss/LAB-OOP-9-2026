import java.util.Scanner;

public class TP1_4_H071251081 {
    public static void main(String[] args) {
        Scanner var = new Scanner(System.in);

        System.out.print("Input : ");
        int n = var.nextInt();

        long hasil = hitungFaktorial(n);
        System.out.println("Output : " + hasil);

        var.close();
    }

    public static long hitungFaktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * hitungFaktorial(n - 1);
        }        
    }
}
