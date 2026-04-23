import java.util.ArrayList;
import java.util.Scanner;

class TokoElektronik {
    String namaProduk;
    int nomorSeri;
    double harga;

    void displayInfo() {
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Nomor Seri : " + nomorSeri);
        System.out.println("Harga      : " + harga);
    }
}

class HP extends TokoElektronik {
    double ukuranLayar;
    double penyimpanan;

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inci");
        System.out.println("Penyimpanan : " + penyimpanan + " GB");
    }
}

class Laptop extends TokoElektronik {
    double ramSize;
    String processor;

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Ukuran RAM    : " + ramSize + " GB");
        System.out.println("Tipe Processor: " + processor);
    }
}

class Camera extends TokoElektronik {
    double resolusi;
    String lensType;

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolusi  : " + resolusi + " MP");
        System.out.println("Tipe Lensa: " + lensType);
    }
}

public class TP4_2_H071251081 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<TokoElektronik> daftarProduk = new ArrayList<>();
        int pilihan;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("\n>>> Pilih menu (1-4): ");
            pilihan = input.nextInt();
            input.nextLine(); 

            if (pilihan == 1) {
                System.out.print("Masukkan nama produk: ");
                String nama = input.nextLine();
                System.out.print("Masukkan nomor seri: ");
                int seri = input.nextInt();
                System.out.print("Masukkan harga: ");
                double harga = input.nextDouble();

                System.out.println("Pilih tipe produk:");
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");
                System.out.print("Pilih tipe produk (1-3): ");
                int tipe = input.nextInt();

                if (tipe == 1) {
                    HP hp = new HP();
                    hp.namaProduk = nama;
                    hp.nomorSeri = seri;
                    hp.harga = harga;
                    System.out.print("Screen Size: ");
                    hp.ukuranLayar = input.nextDouble();
                    System.out.print("Storage Capacity (GB): ");
                    hp.penyimpanan = input.nextDouble();
                    daftarProduk.add(hp);
                } else if (tipe == 2) {
                    Laptop lp = new Laptop();
                    lp.namaProduk = nama;
                    lp.nomorSeri = seri;
                    lp.harga = harga;
                    System.out.print("RAM Size (GB): ");
                    lp.ramSize = input.nextDouble();
                    input.nextLine(); 
                    System.out.print("Processor Type: ");
                    lp.processor = input.nextLine();
                    daftarProduk.add(lp);
                } else if (tipe == 3) {
                    Camera cam = new Camera();
                    cam.namaProduk = nama;
                    cam.nomorSeri = seri;
                    cam.harga = harga;
                    System.out.print("Resolution: ");
                    cam.resolusi = input.nextDouble();
                    input.nextLine();
                    System.out.print("Lens Type: ");
                    cam.lensType = input.nextLine();
                    daftarProduk.add(cam);
                }

            } else if (pilihan == 2) {
                if (daftarProduk.isEmpty()) {
                    System.out.println("Belum ada produk yang ditambahkan.");
                } else {
                    System.out.println("\n=== DAFTAR SEMUA PRODUK ===");
                    for (TokoElektronik p : daftarProduk) {
                        p.displayInfo();
                        System.out.println("-------------------------");
                    }
                }
            } else if (pilihan == 3) {
                System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                int cariSeri = input.nextInt();
                boolean ditemukan = false;

                for (int i = 0; i < daftarProduk.size(); i++) {
                    if (daftarProduk.get(i).nomorSeri == cariSeri) {
                        System.out.println("Produk Ditemukan: " + daftarProduk.get(i).namaProduk);
                        System.out.println("Terima kasih telah membeli produk ini!");
                        
                        daftarProduk.remove(i); 
                        ditemukan = true;
                        break; 
                    }
                }

                if (!ditemukan) {
                    System.out.println("Maaf, produk dengan nomor seri " + cariSeri + " tidak tersedia.");
                }
            } else if (pilihan == 4) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }
}