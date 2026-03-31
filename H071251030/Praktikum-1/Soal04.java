import java.util.Scanner;

public class Soal04 {

    static double faktorial(int n){

        if(n == 1) return 1;

        return n * faktorial(n-1);
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int n = input.nextInt();

        System.out.println("Hasil: " + faktorial(n));
        input.close();
    }
}