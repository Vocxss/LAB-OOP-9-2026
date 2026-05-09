package tes;


public class Transfer extends Bayar {
    @Override
      void bayar(double jumlah) {
        System.out.println("Transfer sejumlah Rp" + jumlah);
    }

      void bayar(double jumlah, String namaBank) {
        System.out.println("Transfer sejumlah Rp" + jumlah + " via " + namaBank);
    }
}

