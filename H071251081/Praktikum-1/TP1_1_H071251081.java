import java.util.Scanner;

public class TP1_1_H071251081 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan Judul Film :");
        System.out.print("> ");
        String kalimat = input.nextLine();
        String hasil = formatKapital(kalimat);

        System.out.println("\nOutput:");
        System.out.println(hasil);
        
        input.close();
    }
    
    public static String formatKapital(String teks) {
        if (teks.isEmpty()) {
            return teks;
        }

        String[] kumpulanKata = teks.split(" ");
        String hasilFinal = "";

        for (String kata : kumpulanKata) {
            if (!kata.isEmpty()) {
                String hurufPertama = kata.substring( 0, 1).toUpperCase();
                String sisaHuruf = kata.substring(1).toLowerCase();

                hasilFinal = hasilFinal + hurufPertama + sisaHuruf + " ";
            }
        }
        
        return hasilFinal.trim();
    }
}