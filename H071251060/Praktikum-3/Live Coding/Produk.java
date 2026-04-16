public class Produk {
    
    private String kodeProduk;
    private String namaProduk;
    private double harga;
    private int stok;


    public Produk(String kodeProduk, String namaProduk, double harga, int stok) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        
        if (harga < 0) {
            this.harga = 0;
        }
        else {
            this.harga = harga;
        }

        if (stok < 0) {
            this.stok = 0;
        }
        else {
            this.stok = stok;
        }
    }


    public String getNamaProduk() {
        return namaProduk;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }
    public double getHarga() {
        return harga;
    }
    public int getStok() {
        return stok;
    }

    public void setHarga(double hargaBaru) {
        if (hargaBaru < 0) {
            System.out.println("Gagal: Harga tidak boleh negatif");
        }
        else {
            this.harga = hargaBaru;
        }
    }


    public void setStok(int stokBaru) {
        if (stokBaru < 0) {
            System.out.println("Gagal: stok harus lebih dari 0");
        }
        else {
            this.stok = stokBaru;
        }
    }

    public void beliProduk(int jumlah) {
        if (jumlah > 0) {
            if ((stok > 0) && (stok >= jumlah)) {

                this.stok -= jumlah;
                System.out.println("Pembelian berhasil");
            }
            else {
                System.out.println("Stok tidak mencukupi");
            }
        }
        else {
            System.out.println("Jumlah pembelia harus lebih dari 0");
        }
    }

}