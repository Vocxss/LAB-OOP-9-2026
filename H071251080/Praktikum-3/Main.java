package Soal;

public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital("TDR-3000", 123456);

        System.out.println("--- INFO AKUN ---");
        System.out.println("ID Nasabah  : " + dompet.getIdNasabah());
        System.out.println("Status Akun : " + dompet.getStatusAkun());
        System.out.printf ("Saldo Awal  : Rp ", dompet.getSaldo());
        System.out.println();

        System.out.println("\n--- UBAH PIN ---");
        dompet.setPinBaru(123456, 987654);
        System.out.println();

        System.out.println("--- SETOR TUNAI ---");
        dompet.setorTunai(150);
        System.out.println();

        System.out.println("--- TARIK TUNAI ---");
        dompet.tarikTunai(100, 987654);
        System.out.println();

        System.out.println("--- SALDO AKHIR ---");
        System.out.printf("Sisa Saldo  : Rp ", dompet.getSaldo());
        System.out.println();
    }
}