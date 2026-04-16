public class Main {
    public static void main(String[] args) {
        // Membuat objek perangkat
        PerangkatElektronik ac = new PerangkatElektronik("Air Conditioner", 350);

        // Menggunakan Constructor Berparameter
        SmartHub hubKamar = new SmartHub("Kamar Tidur", true, ac);

        // Menggunakan Constructor Default
        SmartHub hubTamu = new SmartHub();

        // Menampilkan status awal
        hubKamar.cekStatusSistem();
        hubTamu.cekStatusSistem();

        System.out.println("\n--- Melakukan Sinkronisasi ---");
        // Interaksi antar objek SmartHub
        hubTamu.sinkronisasi(hubKamar);

        // Menampilkan status setelah sinkronisasi
        hubTamu.cekStatusSistem();
    }
}
