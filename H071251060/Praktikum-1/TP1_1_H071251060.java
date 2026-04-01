import java.util.Scanner;


public class TP1_1_H071251060{
    public static void main(String[] args){

        Scanner x = new Scanner(System.in);
        System.out.println("Masukkan  kata");
        String judul = x.nextLine();

        String[] kata = judul.split(" ");
        String hasil = "";
        for (String k : kata) {
            if (k.length() > 0) {
                String kapital = k.substring(0, 1).toUpperCase() + k.substring(1).toLowerCase();
                hasil = hasil + kapital + " ";
            }
        }
        
        System.out.println(hasil);

    }    
}