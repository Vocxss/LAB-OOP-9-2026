
abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    protected int jumlahKehadiran; 

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absensi() {
        jumlahKehadiran++;
    }   
    
    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * jumlahKehadiran);
    }

    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}

class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * jumlahKehadiran;
        if (jumlahKehadiran > 20) {
            totalGaji += 500000;
        }
        return totalGaji; 
    }
}

public class TP5_1_H071251081 { 
    public static void main(String[] args) {
        KaryawanTetap karyawan1 = new KaryawanTetap("Lily", "AD001", 5000000, 500000);
        
        for (int i = 0; i < 5; i++) {
            karyawan1.absensi();
        }

        System.out.println("----Karyawan Tetap----");
        System.out.println("Nama: " + karyawan1.getNama());
        System.out.println("ID Karyawan: " + karyawan1.getIdKaryawan());
        System.out.println("Total Gaji include Bonus: Rp." + karyawan1.hitungGaji(1000000));
        
        KaryawanKontrak karyawan2 = new KaryawanKontrak("Jek", "AD002", 150000);
        for (int i = 0; i < 22; i++) {
            karyawan2.absensi();
        }
        System.out.println("\n----Karyawan Kontrak----");
        System.out.println("Nama: " + karyawan2.getNama());
        System.out.println("ID Karyawan: " + karyawan2.getIdKaryawan());
        System.out.println("Total Gaji: Rp." + karyawan2.hitungGaji());
    }
}