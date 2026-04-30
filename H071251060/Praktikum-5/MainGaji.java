// 1. Abstract Class Karyawan
abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    protected int jumlahKehadiran;

    Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        this.jumlahKehadiran += 1;
    }

    public String getNama() {
        return nama;
    }

    public abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan {
    double gajiPokok;
    double tunjanganMakan;

    KaryawanTetap(String nama, String id, double gaji, double tunjangan) {
        super(nama, id);
        this.gajiPokok = gaji;
        this.tunjanganMakan = tunjangan;
    }

    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * jumlahKehadiran);
    }

    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}

class KaryawanKontrak extends Karyawan {
    double upahPerHari;

    KaryawanKontrak(String nama, String id, double upah) {
        super(nama, id);
        this.upahPerHari = upah;
    }

    public double hitungGaji() {
        double total = upahPerHari * jumlahKehadiran;
        if (jumlahKehadiran > 20) {
            total += 500000;
        }
        return total;
    }
}

public class MainGaji {
    public static void main(String[] args) {
        KaryawanTetap kt = new KaryawanTetap("Andi", "T-01", 3000000, 50000);
        kt.absen();
        kt.absen();
        kt.absen();
        System.out.println("Gaji " + kt.getNama() + " (dengan bonus): Rp" + kt.hitungGaji(1000000));

        KaryawanKontrak kk = new KaryawanKontrak("Budi", "K-01", 150000);
        for (int i = 0; i < 22; i++) {
            kk.absen();
        }
        System.out.println("Gaji " + kk.getNama() + " (kehadiran > 20): Rp" + kk.hitungGaji());
    }
}