package Soal;

public class DompetDigital {

    private double saldo;
    private int pin;
    protected String idNasabah;
    String statusAkun; 
    
    public DompetDigital(String idNasabah, int pin) {
        this.idNasabah  = idNasabah;
        this.pin        = pin;
        this.saldo      = 0;
        this.statusAkun = "AKTIF";
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public String getStatusAkun() {
        return statusAkun;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPinBaru(int pinLama, int pinBaru) {
        if (this.pin != pinLama) {
            System.out.println("PIN lama salah.");
            logTransaksi("GAGAL", "Percobaan ubah PIN = PIN lama tidak cocok.");
            return;
        }

        if (String.valueOf(pinBaru).length() != 6) {
            System.out.println("PIN harus tepat 6 karakter.");
            logTransaksi("GAGAL", "Percobaan ubah PIN = PIN baru tidak 6 karakter.");
            return;
        }

        this.pin = pinBaru;
        System.out.println("PIN berhasil diperbarui.");
        logTransaksi("BERHASIL", "PIN berhasil diubah.");
    }

    public void setorTunai(double nominal) {
        if (nominal <= 0) {
            System.out.println("Nominal tidak valid.");
            logTransaksi("GAGAL", "Setor tunai ditolak = nominal: " + nominal);
            return;
        }

        saldo += nominal;
        System.out.println("+ Rp " + nominal + " | Saldo sekarang: Rp " + saldo);
        logTransaksi("BERHASIL", "Setor tunai Rp " + nominal + " | Saldo: Rp " + saldo);
    }


    public void tarikTunai(double nominal, int pinMasuk) {
        if (this.pin != pinMasuk) {
            System.out.println("PIN salah. Transaksi ditolak.");
            logTransaksi("GAGAL", "Tarik tunai ditolak = PIN tidak cocok.");
            return;
        }

        if (nominal <= 0) {
            System.out.println("Nominal tidak valid.");
            logTransaksi("GAGAL", "Tarik tunai ditolak = nominal: " + nominal);
            return;
        }

        if (nominal > saldo) {
            System.out.println("Saldo tidak cukup. Saldo: Rp " + saldo + ", Diminta: Rp " + nominal);
            logTransaksi("GAGAL", "Tarik tunai ditolak = saldo tidak cukup.");
            return;
        }

        saldo -= nominal;
        System.out.println("- Rp " + nominal + " | Saldo sekarang: Rp " + saldo);
        logTransaksi("BERHASIL", "Tarik tunai Rp " + nominal + " | Saldo: Rp " + saldo);
    }

    private void logTransaksi(String status, String pesan) {
        System.out.println(" [LOG | " + status + "] " + pesan);
    }
}