package tes;

public class Tunai extends Bayar {
    @Override
      void bayar(double jumlah) {
        System.out.println("Bayar tunai sejumlah Rp" + jumlah);
    }

      void bayar(double jumlah, String keterangan) {
        System.out.println("Bayar tunai sejumlah Rp" + jumlah + " - " + keterangan);
    }
}