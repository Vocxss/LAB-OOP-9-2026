import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int jumlah = 30;

    static void Separator() {
        for (int i = 0; i <= jumlah; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner input= new Scanner(System.in);

        while (true) {
            Separator();
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.println();
            System.out.println("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); 
            Separator();
            switch (pilihan) {
                case 1:
                    System.out.println("Nama Produk: ");
                    String nama = input.nextLine();
                    System.out.println("Series Number: ");
                    int seriesNumber = input.nextInt();
                    System.out.println("Harga: ");
                    double harga = input.nextDouble();
                    System.out.println("Stock: ");
                    int stock = input.nextInt();
                    input.nextLine(); 
                    System.out.println("Pilih tipe produk: ");
                    System.out.println("1. Phone");
                    System.out.println("2. Camera");
                    System.out.println("3. Laptop");
                    System.out.println("Pilih tipe: ");
                    int tipe = input.nextInt();
                    input.nextLine(); 
                    if (tipe == 1) {
                        System.out.println("Screen Size: ");
                        double screenSize = input.nextDouble();
                        System.out.println("Memory: ");
                        int memory = input.nextInt();
                        products.add(new Phone(nama, seriesNumber, harga, stock, screenSize, memory));
                    } else if (tipe == 2) {
                        System.out.println("Resolution: ");
                        int resolution = input.nextInt();
                        input.nextLine(); 
                        System.out.println("Tipe lensa: ");
                        String lens = input.nextLine();
                        products.add(new Camera(nama, seriesNumber, harga, stock, resolution, lens));
                    } else if (tipe == 3) {
                        System.out.println("Processor: ");
                        String processor = input.nextLine();
                        System.out.println("RAM: ");
                        int ram = input.nextInt();
                        products.add(new Laptop(nama, seriesNumber, harga, stock, processor, ram));
                    } 
                    System.out.println("Produk berhasil ditambah :)");
                    break;
                case 2:
                    System.out.println("Daftar Produk: ");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println("Produk " + (i+1));
                        products.get(i).getInfo();
                    }
                    break;
                case 3:
                    Separator();
                    System.out.println("Beli Produk");
                    System.out.println("Masukkan nomor produk: ");
                    String nomor = input.nextLine();
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getSeriesNumber().equals(nomor)) {
                            if (products.get(i).getStock() > 0) {
                                products.get(i).setStock(products.get(i).getStock() - 1);
                                System.out.println("Produk " + products.get(i).getBrand() + " berhasil dibeli!");
                            } else {
                                System.out.println("Out of stock :(");
                            }
                        } else {
                            System.out.println("Produk tidak ditemukan");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Terima gaji :)");
                    input.close();
                    return;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        }
    }
}
