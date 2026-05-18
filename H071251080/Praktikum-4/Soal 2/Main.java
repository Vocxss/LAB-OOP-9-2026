import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produk> stok = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        stok.add(new Smartphone("Samsung", 123456, 899.99, 6.5, 256));
        stok.add(new Laptop("Dell", 987654, 1299.99, 16, "Intel Core i7"));
        stok.add(new Camera("Canon", 456789, 699.99, 24, "Telephoto"));

        while (true) {
            tampilkanMenu();
            System.out.print(">>> Pilih menu (1-4):  ");
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    tambahProduk(sc);
                    break;
                case 2:
                    tampilkanSemuaProduk();
                    break;
                case 3:
                    beliProduk(sc);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
    }

    static void tambahProduk(Scanner sc) {
        System.out.print("Masukkan nama produk: ");
        String brand = sc.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int seri = sc.nextInt();

        System.out.print("Masukkan harga: ");
        double harga = sc.nextDouble();
        sc.nextLine();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print("Pilih tipe produk (1-3): ");
        int tipe = sc.nextInt();
        sc.nextLine();

        switch (tipe) {
            case 1: {
                System.out.print("Masukkan ukuran layar (inci): ");
                double screen = sc.nextDouble();
                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                int storage = sc.nextInt();
                sc.nextLine();
                stok.add(new Smartphone(brand, seri, harga, screen, storage));
                break;
            }
            case 2: {
                System.out.print("Masukkan ukuran RAM (GB): ");
                int ram = sc.nextInt();
                sc.nextLine();
                System.out.print("Masukkan tipe prosesor: ");
                String proc = sc.nextLine();
                stok.add(new Laptop(brand, seri, harga, ram, proc));
                break;
            }
            case 3: {
                System.out.print("Masukkan resolusi (MP): ");
                int res = sc.nextInt();
                sc.nextLine();
                System.out.print("Masukkan tipe lensa: ");
                String lens = sc.nextLine();
                stok.add(new Camera(brand, seri, harga, res, lens));
                break;
            }
            default:
                System.out.println("Tipe tidak valid!");
        }
    }

    static void tampilkanSemuaProduk() {
        System.out.println("Daftar Produk:");
        for (Produk p : stok) {
            p.displayInfo();
            System.out.println();
        }
    }

    static void beliProduk(Scanner sc) {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int seri = sc.nextInt();
        sc.nextLine();

        boolean ditemukan = false;
        for (Produk p : stok) {
            if (p.seriesNumber == seri) {
                System.out.println("Anda telah membeli produk:");
                p.displayInfo();
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}