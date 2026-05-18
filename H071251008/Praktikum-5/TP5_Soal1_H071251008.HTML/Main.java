package Soal1;

public class Main {
    public static void main(String[] args) {

        KaryawanTetap kt = new KaryawanTetap("Andi", "KT-0001", 5000000, 50000);

        for (int i = 0; i < 5; i++) {
            kt.absen();
        }
        
        System.out.println("Nama: " + kt.getNama());
        System.out.println("Jumlah Kehadiran: " + kt.getJumlahKehadiran() + " hari");
        System.out.printf("Gaji Normal: Rp%,.0f%n", + kt.hitungGaji());
        System.out.printf("Gaji + Bonus Kinerja: Rp%,.0f%n", kt.hitungGaji(1500000));
        
        System.out.println("------------------------------------");

        KaryawanKontrak kk = new KaryawanKontrak("Budi", "KK-0001", 150000);

        for (int i = 0; i < 21; i++) {
            kk.absen();
        }
        
        System.out.println("Nama: " + kk.getNama());
        System.out.println("Jumlah Kehadiran: " + kk.getJumlahKehadiran() + " hari");
        System.out.printf("Gaji: Rp%,.0f%n", + kk.hitungGaji());
    }
}