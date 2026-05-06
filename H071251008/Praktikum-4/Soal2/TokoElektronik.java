package Soal2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TokoElektronik {

    static Scanner scanner = new Scanner(System.in);
    static List<Product> stok = new ArrayList<>();

    // Validasi Input
    static String inputStringTidakKosong(String prompt) {
        while (true) {
            System.out.print(prompt);
            String nilai = scanner.nextLine().trim();
            if (nilai.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silakan coba lagi.");
            } else {
                return nilai;
            }
        }
    }

    static int angkaPositif(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int nilai = Integer.parseInt(input);
                if (nilai <= 0) {
                    System.out.println("Nilai harus berupa bilangan bulat positif (> 0). Silakan coba lagi.");
                } else {
                    return nilai;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan bilangan bulat. Silakan coba lagi.");
            }
        }
    }

    static double inputDoublePositif(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double nilai = Double.parseDouble(input);
                if (nilai <= 0) {
                    System.out.println("Nilai harus berupa angka positif (> 0). Silakan coba lagi.");
                } else {
                    return nilai;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka. Silakan coba lagi.");
            }
        }
    }

    static int inputNomorSeriUnik(String prompt) {
        while (true) {
            int serial = angkaPositif(prompt);
            boolean sudahAda = false;
            for (Product p : stok) {
                if (p.getSeriesNumber() == serial) {
                    sudahAda = true;
                    break;
                }
            }
            if (sudahAda) {
                System.out.println("Nomor seri " + serial + " sudah digunakan. Masukkan nomor seri lain.");
            } else {
                return serial;
            }
        }
    }

    static int inputPilihanMenu(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int nilai = Integer.parseInt(input);
                if (nilai < min || nilai > max) {
                    System.out.println("Pilihan tidak valid. Masukkan angka " + min + "-" + max + ".");
                } else {
                    return nilai;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan  angka " + min + "-" + max + ".");
            }
        }
    }

    static void tambahProduk() {
        System.out.println("----------------------------------------");
        String brand = inputStringTidakKosong("Masukkan nama produk: ");
        int seriesNumber = inputNomorSeriUnik("Masukkan nomor seri: ");
        double price = inputDoublePositif("Masukkan harga (Rp): ");

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        int tipe = inputPilihanMenu("Pilih tipe produk (1-3): ", 1, 3);

        if (tipe == 1) {
            double screenSize = inputDoublePositif("Masukkan ukuran layar (inci): ");
            int storageCapacity = angkaPositif("Masukkan kapasitas penyimpanan (GB): ");
            stok.add(new Smartphone(brand, seriesNumber, price, screenSize, storageCapacity));

        } else if (tipe == 2) {
            int ramSize = angkaPositif("Masukkan ukuran RAM (GB): ");
            String processorType = inputStringTidakKosong("Masukkan tipe prosesor: ");
            stok.add(new Laptop(brand, seriesNumber, price, ramSize, processorType));

        } else if (tipe == 3) {
            int resolution = angkaPositif("Masukkan resolusi (MP): ");
            String lensType = inputStringTidakKosong("Masukkan tipe lensa: ");
            stok.add(new Camera(brand, seriesNumber, price, resolution, lensType));
        }

        System.out.println("Produk '" + brand + "' berhasil ditambahkan ke stok.");
        System.out.println("----------------------------------------");
    }

    static void tampilkanSemuaProduk() {
        System.out.println("----------------------------------------");
        if (stok.isEmpty()) {
            System.out.println("Stok kosong, belum ada produk.");
        } else {
            System.out.println("Daftar Produk:");
            for (Product p : stok) {
                p.displayInfo();
                System.out.println();
            }
        }
        System.out.println("----------------------------------------");
    }

    static void beliProduk() {
        System.out.println("----------------------------------------");
        int serial = angkaPositif("Masukkan nomor seri produk yang ingin dibeli: ");

        for (Product p : stok) {
            if (p.getSeriesNumber() == serial) {
                System.out.println("Anda telah membeli produk:");
                p.displayInfo();
                System.out.println("----------------------------------------");
                return;
            }
        }

        System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        System.out.println("----------------------------------------");
    }

    // ============================================================
    // Main Program
    // ============================================================

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            String pilihan = scanner.nextLine().trim();

            if (pilihan.equals("1")) {
                tambahProduk();
            } else if (pilihan.equals("2")) {
                tampilkanSemuaProduk();
            } else if (pilihan.equals("3")) {
                beliProduk();
            } else if (pilihan.equals("4")) {
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Masukkan angka 1-4.");
            }
        }

        scanner.close();
    }
}