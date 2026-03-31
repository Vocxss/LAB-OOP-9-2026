import java.util.Scanner;

public class Soal02 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in) ;

        System.out.println("Masukkan tanggal (dd-mm-yy): ");
        String tanggal = input.nextLine();

        String[] bagian = tanggal.split("-");

        String[] namaBulan = {
        "",
        "Januari","Februari","Maret","April","Mei","Juni",
        "Juli","Agustus","September","Oktober","November","Desember"
        };

        int hari  = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]) > 26 ? Integer.parseInt(bagian[2]) + 1900 : Integer.parseInt(bagian[2]) + 2000;

        System.out.println(hari + " " + namaBulan[bulan] + " " + tahun);

    }

}










