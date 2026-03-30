import java.util.Scanner;

public class TP1_2_H071251081 {
public static void main(String[] args) {
        Scanner var = new Scanner(System.in);

        System.out.print("Input (dd-mm-yy): ");
        String inputTanggal = var.nextLine();
        String[] bagian = inputTanggal.split("-");

        int tgl = Integer.parseInt(bagian[0]); 
        String bulanAngka = bagian[1];
        String thnPendek = bagian[2];

        String namaBulan = "";
        switch (bulanAngka) {
            case "01": namaBulan = "Januari"; break;
            case "02": namaBulan = "Februari"; break;
            case "03": namaBulan = "Maret"; break;
            case "04": namaBulan = "April"; break;
            case "05": namaBulan = "Mei"; break;
            case "06": namaBulan = "Juni"; break;
            case "07": namaBulan = "Juli"; break;
            case "08": namaBulan = "Agustus"; break;
            case "09": namaBulan = "September"; break;
            case "10": namaBulan = "Oktober"; break;
            case "11": namaBulan = "November"; break;
            case "12": namaBulan = "Desember"; break;
            default: namaBulan = "Bulan Tidak Valid";
        }

        int thnAngka = Integer.parseInt(thnPendek);
        String tahunLengkap;
        if (thnAngka <= 26) {
            tahunLengkap = "20" + thnPendek;
        } else {
            tahunLengkap = "19" + thnPendek;
        }

        System.out.println("Output:");
        System.out.println(tgl + " " + namaBulan + " " + tahunLengkap);

        var.close();
    }    
}
