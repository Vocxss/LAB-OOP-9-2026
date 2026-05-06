import java.util.Scanner;

public class TP1_3_H071251060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan password: ");
        String pass = sc.nextLine();

        boolean panjangCukup = pass.length() >= 8;
        boolean besar = false;
        boolean kecil = false;
        boolean angka = false;


        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);

            if (Character.isUpperCase(c)) {
                besar = true;
            }
            else if (Character.isLowerCase(c)) {
                kecil = true;
            }
            else if (Character.isDigit(c)) {
                angka = true;
            }
        }

        if (panjangCukup && besar && kecil && angka) {
            System.out.println("Output : Password valid");
        } else {
            System.out.println("Output : Password tidak valid");
        }
    }
}