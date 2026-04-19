import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean isDone = false;
        while (isDone == false) {
            System.out.println("1. TAMBAH PRODUK");
            System.out.println("2. TAMPILKAN SEMUA PRODUK");
            System.out.println("3. BELI PRODUK");
            System.out.println("4. KELUAR");
            System.out.print("Masukkan pilihan: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Pilih Tipe Produk: ");
                    System.out.println("1. Phone");
                    System.out.println("2. Camera");
                    System.out.println("3. Laptop");
                    System.out.print("Pilihan : ");
                    int tipeProduk = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan Brand : ");
                    String brand = input.nextLine();
                    System.out.print("Masukkan Series Number : ");
                    int seriesNumber = input.nextInt();
                    System.out.print("Masukkan Price : ");
                    double price = input.nextDouble();
                    System.out.print("Masukkan Stock : ");
                    int stock = input.nextInt();
                    input.nextLine();
                    if (tipeProduk == 1) {
                        System.out.print("Masukkan Screen Size : ");
                        double screenSize = input.nextDouble();
                        System.out.print("Masukkan Memory : ");
                        int memory = input.nextInt();
                        products.add(new Phone(brand, seriesNumber, price, stock, screenSize, memory));
                    } else if (tipeProduk == 2) {
                        System.out.print("Masukkan Resolution : ");
                        int resolution = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan Lens Type : ");
                        String lensType = input.nextLine();
                        products.add(new Camera(brand, seriesNumber, price, stock, resolution, lensType));
                    } else if (tipeProduk == 3) {
                        System.out.print("Masukkan Processor : ");
                        String processor = input.nextLine();
                        System.out.print("Masukkan Ram : ");
                        int ram = input.nextInt();
                        products.add(new Laptop(brand, seriesNumber, price, stock, processor, ram));
                    } else {
                        System.out.println("Tipe Produk tidak ditemukan");
                    }

                    break;

                case 2:
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println("No. " + (i + 1));
                        products.get(i).getInfo();
                    }
                    System.out.println("--------------------------------");
                    break;

                case 3:
                    System.out.print("Masukkan Nomor Series Produk yang Ingin Dibeli: ");
                    String seriesChoice = input.next();

                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getSeriesNumber().equals(seriesChoice)) {
                            if (products.get(i).getStock() == 0) {
                                System.out.println("Stock Habis");
                            } else {
                                products.get(i).setStock(products.get(i).getStock() - 1);
                                System.out.println("Produk Berhasil Dibeli");
                            }
                            break;
                        } else {
                            System.out.println("Produk dengan series number tidak ada");
                        }
                    }

                    break;

                default:
                    System.out.println("Tq");
                    isDone = true;
                    break;
            }
        }
        input.close();
    }
}
