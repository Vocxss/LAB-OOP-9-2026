package Soal1;

public class KaryawanKontrak extends Karyawan{
   private double upahPerHari;
   private static final double bonusFlat = 500000;

   public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();
        if (getJumlahKehadiran()>20){
            totalGaji += bonusFlat;
        }return totalGaji;
        }
    }

