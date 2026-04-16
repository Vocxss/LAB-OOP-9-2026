public class Main {
    public static void main(String[] args) {

        Produk laptop = new Produk("LP-01", "Laptop Gaming", 15000000, -5);
        
        System.out.println("Nama Produk: " + laptop.getNamaProduk());
        System.out.println("Stok Awal (seharusnya 0): " + laptop.getStok());

        // 2. Coba ubah harga menjadi negatif
        System.out.println("\n--- Mengubah Harga ---");
        laptop.setHarga(-500000); // Harusnya Gagal
        laptop.setHarga(14500000); // Harusnya Berhasil
        System.out.println("Harga saat ini: Rp" + laptop.getHarga());

        // 3. Proses Transaksi
        System.out.println("\n--- Proses Transaksi ---");
        laptop.setStok(10);     // Stok menjadi 10
        System.out.println("Stok setelah ditambah: " + laptop.getStok());

        laptop.beliProduk(15);     // Harusnya Gagal (Stok cuma 10)
        laptop.beliProduk(3);      // Berhasil (Sisa stok 7)

        System.out.println("\nSisa Stok Akhir: " + laptop.getStok());
    }
}