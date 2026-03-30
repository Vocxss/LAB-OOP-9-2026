import java.util.Scanner;

public class TP1_3_H071251081 {
    public static void main(String[] args) {
        Scanner var = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = var.nextLine();

        boolean panjangCukup = password.length() >= 8;
        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (int i = 0; i < password.length(); i++) {
            char karakter = password.charAt(i);

            if (Character.isUpperCase(karakter)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(karakter)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(karakter)) {
                adaAngka = true;
            }
        }

        if (panjangCukup && adaHurufBesar && adaHurufKecil && adaAngka) {
            System.out.println("Output : Password valid");
        } else {
            System.out.println("Output : Password tidak valid");
        }

        var.close();
    }
}
