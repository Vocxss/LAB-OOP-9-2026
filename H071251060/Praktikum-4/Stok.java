import java.util.Scanner;

// 1. Kelas Induk
class Produk {
    String merek;
    int nomorSeri;
    double harga;

    Produk(String merek, int nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }
}

// 2. Kelas Anak: Smartphone
class Smartphone extends Produk {
    double ukuranLayar;
    int kapasitasPenyimpanan;

    Smartphone(String merek, int nomorSeri, double harga, double ukuranLayar, int kapasitasPenyimpanan) {
        super(merek, nomorSeri, harga); // Mengirim data ke constructor Produk
        this.ukuranLayar = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    void tampilkanSmartphone() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Ukuran Layar: " + ukuranLayar + " inci");
        System.out.println("Kapasitas Penyimpanan: " + kapasitasPenyimpanan + "GB");
    }
}

// 3. Kelas Anak: Laptop
class Laptop extends Produk {
    int ukuranRam;
    String jenisProsesor;

    Laptop(String merek, int nomorSeri, double harga, int ukuranRam, String jenisProsesor) {
        super(merek, nomorSeri, harga);
        this.ukuranRam = ukuranRam;
        this.jenisProsesor = jenisProsesor;
    }

    void tampilkanLaptop() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Jenis Prosesor: " + jenisProsesor);
        System.out.println("Ukuran RAM: " + ukuranRam + "GB");
    }
}

// 4. Kelas Anak: Kamera
class Kamera extends Produk {
    int resolusi;
    String jenisLensa;

    Kamera(String merek, int nomorSeri, double harga, int resolusi, String jenisLensa) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.jenisLensa = jenisLensa;
    }

    void tampilkanKamera() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Resolusi: " + resolusi + "MP");
        System.out.println("Jenis Lensa: " + jenisLensa);
    }
}

public class Stok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Smartphone[] daftarHp = new Smartphone[50];
        Laptop[] daftarLaptop = new Laptop[50];
        Kamera[] daftarKamera = new Kamera[50];
        
        int jumlahHp = 0;
        int jumlahLaptop = 0;
        int jumlahKamera = 0;

        while (true) {
            System.out.println("=== MENU TOKO ANDI ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk (Hapus)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int menu = input.nextInt();

            if (menu == 1) {
                input.nextLine();
                System.out.println("Masukkan merek: ");
                String mrk = input.nextLine();
                System.out.print("Masukkan nomor seri: ");
                int seri = input.nextInt();
                System.out.print("Masukkan harga: ");
                double hrg = input.nextDouble();
                
                System.out.println("Tipe Produk:\n1. Smartphone\n2. Laptop\n3. Kamera");
                System.out.print("Pilih tipe (1-3): ");
                int tipe = input.nextInt();

                if (tipe == 1) {
                    System.out.print("Ukuran layar (inci): ");
                    double layar = input.nextDouble();
                    System.out.print("Kapasitas simpan (GB): ");
                    int simpan = input.nextInt();
                    daftarHp[jumlahHp++] = new Smartphone(mrk, seri, hrg, layar, simpan);
                }
                else if (tipe == 2) {
                    input.nextLine();
                    System.out.print("Ukuran RAM (GB): ");
                    int ram = input.nextInt();
                    System.out.print("Jenis Prosesor: ");
                    String pro = input.nextLine();
                    daftarLaptop[jumlahLaptop++] = new Laptop(mrk, seri, hrg, ram, pro);
                }
                else if (tipe == 3) {
                    input.nextLine();
                    System.out.print("Resolusi (MP): ");
                    int res = input.nextInt();
                    System.out.print("Jenis Lensa: ");
                    String lens = input.nextLine();
                    daftarKamera[jumlahKamera++] = new Kamera(mrk, seri, hrg, res, lens);
                }
            } 
            else if (menu == 2) {
                System.out.println("--- DAFTAR STOK BARANG ---");
                for (int i = 0; i < jumlahHp; i++) { 
                    daftarHp[i].tampilkanSmartphone(); System.out.println("-----------------"); 
                }
                for (int i = 0; i < jumlahLaptop; i++) { 
                    daftarLaptop[i].tampilkanLaptop(); System.out.println("-----------------"); 
                }
                for (int i = 0; i < jumlahKamera; i++) { 
                    daftarKamera[i].tampilkanKamera(); System.out.println("-----------------"); 
                }
            } 
           else if (menu == 3) {
                System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                int cari = input.nextInt();
                boolean ketemu = false;

                for (int i = 0; i < jumlahHp; i++) {
                    if (daftarHp[i].nomorSeri == cari) {
                        System.out.println("Berhasil membeli: " + daftarHp[i].merek);
                        for (int j = i; j < jumlahHp - 1; j++) daftarHp[j] = daftarHp[j+1];
                        jumlahHp--;
                        ketemu = true;
                        break;
                    }
                } 
                if (!ketemu) {
                    for (int i = 0; i < jumlahLaptop; i++) {
                        if (daftarLaptop[i].nomorSeri == cari) {
                            System.out.println("Berhasil membeli: " + daftarLaptop[i].merek);
                            for (int j = i; j < jumlahLaptop - 1; j++) daftarLaptop[j] = daftarLaptop[j+1];
                            jumlahLaptop--; ketemu = true;
                            break;
                        }
                    }
                }

                if (!ketemu) {
                    for (int i = 0; i < jumlahKamera; i++) {
                        if (daftarKamera[i].nomorSeri == cari) {
                            System.out.println("Berhasil membeli: " + daftarKamera[i].merek);
                            for (int j = i; j < jumlahKamera - 1; j++) daftarKamera[j] = daftarKamera[j+1];
                            jumlahKamera--; ketemu = true;
                            break;
                        }
                    }
                }
                if (!ketemu) System.out.println("Nomor seri tidak ditemukan!");
            } 
            else if (menu == 4) {
                System.out.println("Keluar dari program...");
                break;
            }
        }
    }
}