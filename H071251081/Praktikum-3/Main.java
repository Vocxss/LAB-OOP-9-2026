import java.util.Scanner;

// Kelas DompetDigital sesuai spesifikasi [cite: 9]
class DompetDigital {
    // 1. Persyaratan Atribut [cite: 10, 11, 12]
    private double saldo;          // Private: Data kritis [cite: 10]
    private String pin;            // Private: Data sangat rahasia [cite: 10, 19]
    protected String idNasabah;    // Protected: Identitas akun [cite: 11]
    String statusAkun;             // Default: Pengaturan internal package [cite: 12]

    // 2. Constructor [cite: 15]
    public DompetDigital(String idNasabah, String pinAwal) {
        this.idNasabah = idNasabah;
        this.pin = pinAwal;
        this.saldo = 0; // Saldo awal otomatis 0 [cite: 16]
        this.statusAkun = "AKTIF";
    }

    // 3. Getter (Hanya untuk yang aman) [cite: 18]
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    // 4. Setter PIN dengan validasi [cite: 22, 23, 24, 25]
    public void setPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            if (pinBaru.length() == 6) {
                this.pin = pinBaru;
                catatLog("PIN berhasil diperbarui.");
            } else {
                catatLog("Gagal: PIN baru harus 6 karakter.");
            }
        } else {
            catatLog("Gagal: PIN lama salah.");
        }
    }

    // 5. Metode Transaksi [cite: 26]
    public void setorTunai(double jumlah) {
        if (jumlah > 0) { // Tidak boleh negatif [cite: 27]
            this.saldo += jumlah;
            catatLog("Setor berhasil: Rp" + jumlah);
        } else {
            catatLog("Setor gagal: Nominal ilegal.");
        }
    }

    public void tarikTunai(double jumlah, String inputPin) {
        // Verifikasi PIN dan kecukupan saldo [cite: 28]
        if (!this.pin.equals(inputPin)) {
            catatLog("Tarik gagal: PIN salah.");
        } else if (jumlah > saldo) {
            catatLog("Tarik gagal: Saldo tidak cukup.");
        } else if (jumlah <= 0) {
            catatLog("Tarik gagal: Nominal tidak valid.");
        } else {
            this.saldo -= jumlah;
            catatLog("Tarik berhasil: Rp" + jumlah);
        }
    }

    // 6. Method Internal (Data Hiding) [cite: 29, 30]
    private void catatLog(String pesan) {
        System.out.println("[LOG SISTEM]: " + pesan);
    }
}

// Kelas Utama dengan Menu Interaktif [cite: 31]
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inisialisasi awal [cite: 32]
        DompetDigital dompet = new DompetDigital("ADF-2026", "150306");

        int pilihan;
        do {
            System.out.println("\n=== MENU E-WALLET (Fintech) ===");
            System.out.println("1. Informasi Akun (Getter)");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Ubah PIN (Setter)");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("ID Nasabah: " + dompet.getIdNasabah());
                    System.out.println("Saldo Saat Ini: Rp" + dompet.getSaldo());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah setor: ");
                    double jumlahSetor = scanner.nextDouble();
                    dompet.setorTunai(jumlahSetor);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah tarik: ");
                    double jumlahTarik = scanner.nextDouble();
                    System.out.print("Masukkan PIN: ");
                    String pinTarik = scanner.next();
                    dompet.tarikTunai(jumlahTarik, pinTarik);
                    break;
                case 4:
                    System.out.print("Masukkan PIN lama: ");
                    String pLama = scanner.next();
                    System.out.print("Masukkan PIN baru (6 digit): ");
                    String pBaru = scanner.next();
                    dompet.setPin(pLama, pBaru);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}