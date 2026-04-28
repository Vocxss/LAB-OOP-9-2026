abstract class Karyawan {
    private String nama, idKaryawan;
    private int jumlahKehadiran;

    Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    void absen() {
        this.jumlahKehadiran ++;
    }

    String getNama() {
        return nama;
    }

    int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan {
    double gajiPokok, tunjanganMakan;

    KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    double hitungGaji() {
        double totalGaji =  gajiPokok + (tunjanganMakan * getJumlahKehadiran()); 
        return totalGaji;  
    }

    double hitungGaji(double bonusKinerja) {
        double totalGaji =  gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return totalGaji + bonusKinerja;  
    }
}

class KaryawanKontrak extends Karyawan {
    double upahPerHari;

    KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    double hitungGaji() {
        double gajiAwal = upahPerHari * getJumlahKehadiran();
        double totalGaji =  getJumlahKehadiran() > 20 ? gajiAwal + 500000 : gajiAwal ;
        return totalGaji;
    }
}

class Main {
    public static void main(String[] args) {
        String randomId1 = String.valueOf(Math.random() * 100000);
        KaryawanTetap karyawanTetap1 = new KaryawanTetap("asep", randomId1, 10000, 10);
        
        String randomId2 = String.valueOf(Math.random() * 100000);
        KaryawanKontrak karyawanKontrak1 = new KaryawanKontrak("asep", randomId2, 10000);
        
        for (int i = 0; i < 5; i++) {
            karyawanTetap1.absen();
            karyawanKontrak1.absen();

        }
        
        System.out.println("Total gaji " + karyawanTetap1.getNama() + " karyawan tetap 1: " + karyawanTetap1.hitungGaji(50000));
        
        System.out.println("Total gaji " + karyawanKontrak1.getNama() + " karyawan kontrak 1: " + karyawanKontrak1.hitungGaji());

    }
}



