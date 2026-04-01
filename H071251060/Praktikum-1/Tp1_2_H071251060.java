import java.util.Scanner;

public class TP1_2_H071251060 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        
        System.out.println("Input :");
        String input = x.nextLine();
        
        String[] bagian = input.split("-");
        String hari = bagian[0];
        String bulan = bagian[1];
        String tahun = bagian[2];

        String namabulan = "";
        switch (bulan) {
            case "01": namabulan = "Januari"; break;
            case "02": namabulan = "Februari"; break;
            case "03": namabulan = "Maret"; break;
            case "04": namabulan = "April"; break;
            case "05": namabulan = "Mei"; break;
            case "06": namabulan = "Juni"; break;
            case "07": namabulan = "Juli"; break;
            case "08": namabulan = "Agustus"; break;
            case "09": namabulan = "September"; break;
            case "10": namabulan = "Oktober"; break;
            case "11": namabulan = "November"; break;
            case "12": namabulan = "Desember"; break;
        }

        int angkaTahun = Integer.parseInt(tahun);
        if (angkaTahun <= 50) {
            tahun = "20" + tahun;
        } else {
            tahun = "19" + tahun;
        }

        int angkaHari = Integer.parseInt(hari);

        System.out.println(angkaHari + " " + namabulan + " " + tahun);
    }
}