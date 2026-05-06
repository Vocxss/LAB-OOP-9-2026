package Soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Bangun Datar");
            System.out.println("2. Bangun Ruang");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            menu = in.nextInt();

            if (menu == 1) {
                menuDatar(in);
            } 
            else if (menu == 2) {
                menuRuang(in);
            }

        } while (menu != 3);

        System.out.println("Program selesai.");
        in.close();
    }

    // ===== VALIDASI SIMPLE =====
    static double inputPositif(Scanner in, String pesan) {
        double nilai;
        System.out.print(pesan);
        while (!in.hasNextDouble() || (nilai = in.nextDouble()) <= 0) {
            System.out.println("Input harus angka > 0!");
            in.nextLine();
            System.out.print(pesan);
        }
        return nilai;
    }

    static int inputMenu(Scanner in, String pesan, int min, int max) {
        int nilai;
        System.out.print(pesan);
        while (!in.hasNextInt() || (nilai = in.nextInt()) < min || nilai > max) {
            System.out.println("Pilih angka " + min + " - " + max);
            in.nextLine();
            System.out.print(pesan);
        }
        return nilai;
    }

    // ===== MENU BANGUN DATAR =====
    static void menuDatar(Scanner in) {
        System.out.println("\n=== BANGUN DATAR ===");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga");
        System.out.println("4. Lingkaran");
        System.out.println("5. Jajar Genjang");
        System.out.println("6. Belah Ketupat");

        int pilihan = inputMenu(in, "Pilih: ", 1, 6);

        System.out.println("\n--- HASIL PERHITUNGAN ---");

        switch (pilihan) {
            case 1:
                double s = inputPositif(in, "Sisi: ");
                BangunDatar.Persegi persegi = new BangunDatar.Persegi(s);
                System.out.printf("Luas = %.2f\n", persegi.luas());
                System.out.printf("Keliling = %.2f\n", persegi.keliling());
                break;

            case 2:
                double p = inputPositif(in, "Panjang: ");
                double l = inputPositif(in, "Lebar: ");
                BangunDatar.PersegiPanjang pp = new BangunDatar.PersegiPanjang(p, l);
                System.out.printf("Luas = %.2f\n", pp.luas());
                System.out.printf("Keliling = %.2f\n", pp.keliling());
                break;

            case 3:
                double a = inputPositif(in, "Sisi a: ");
                double b = inputPositif(in, "Sisi b: ");
                double c = inputPositif(in, "Sisi c: ");
                double t = inputPositif(in, "Tinggi: ");
                BangunDatar.Segitiga segitiga = new BangunDatar.Segitiga(a, b, c, t);
                System.out.printf("Luas = %.2f\n", segitiga.luas());
                System.out.printf("Keliling = %.2f\n", segitiga.keliling());
                break;

            case 4:
                double r = inputPositif(in, "Jari-jari: ");
                BangunDatar.Lingkaran lingkaran = new BangunDatar.Lingkaran(r);
                System.out.printf("Luas = %.2f\n", lingkaran.luas());
                System.out.printf("Keliling = %.2f\n", lingkaran.keliling());
                break;

            case 5:
                double alas = inputPositif(in, "Alas: ");
                double tinggi = inputPositif(in, "Tinggi: ");
                double sm = inputPositif(in, "Sisi miring: ");
                BangunDatar.JajarGenjang jg = new BangunDatar.JajarGenjang(alas, tinggi, sm);
                System.out.printf("Luas = %.2f\n", jg.luas());
                System.out.printf("Keliling = %.2f\n", jg.keliling());
                break;

            case 6:
                double d1 = inputPositif(in, "Diagonal 1: ");
                double d2 = inputPositif(in, "Diagonal 2: ");
                double sisi = inputPositif(in, "Sisi: ");
                BangunDatar.BelahKetupat bk = new BangunDatar.BelahKetupat(d1, d2, sisi);
                System.out.printf("Luas = %.2f\n", bk.luas());
                System.out.printf("Keliling = %.2f\n", bk.keliling());
                break;
        }

        System.out.println("---------------------------");
    }

    // ===== MENU BANGUN RUANG =====
    static void menuRuang(Scanner in) {
        System.out.println("\n=== BANGUN RUANG ===");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Prisma");
        System.out.println("4. Tabung");
        System.out.println("5. Kerucut");
        System.out.println("6. Bola");

        int pilihan = inputMenu(in, "Pilih: ", 1, 6);

        System.out.println("\n--- HASIL PERHITUNGAN ---");

        switch (pilihan) {
            case 1:
                double s = inputPositif(in, "Sisi: ");
                BangunRuang.Kubus kubus = new BangunRuang.Kubus(s);
                System.out.printf("Volume = %.2f\n", kubus.volume());
                System.out.printf("Luas Permukaan = %.2f\n", kubus.luasPermukaan());
                break;

            case 2:
                double p = inputPositif(in, "Panjang: ");
                double l = inputPositif(in, "Lebar: ");
                double t = inputPositif(in, "Tinggi: ");
                BangunRuang.Balok balok = new BangunRuang.Balok(p, l, t);
                System.out.printf("Volume = %.2f\n", balok.volume());
                System.out.printf("Luas Permukaan = %.2f\n", balok.luasPermukaan());
                break;

            case 3:
                double la = inputPositif(in, "Luas alas: ");
                double tPrisma = inputPositif(in, "Tinggi: ");
                BangunRuang.Prisma prisma = new BangunRuang.Prisma(la, tPrisma);
                System.out.printf("Volume = %.2f\n", prisma.volume());
                break;

            case 4:
                double r = inputPositif(in, "Jari-jari: ");
                double tTabung = inputPositif(in, "Tinggi: ");
                BangunRuang.Tabung tabung = new BangunRuang.Tabung(r, tTabung);
                System.out.printf("Volume = %.2f\n", tabung.volume());
                System.out.printf("Luas Permukaan = %.2f\n", tabung.luasPermukaan());
                break;

            case 5:
                double rK = inputPositif(in, "Jari-jari: ");
                double tK = inputPositif(in, "Tinggi: ");
                double sK = inputPositif(in, "Garis pelukis: ");
                BangunRuang.Kerucut kerucut = new BangunRuang.Kerucut(rK, tK, sK);
                System.out.printf("Volume = %.2f\n", kerucut.volume());
                System.out.printf("Luas Permukaan = %.2f\n", kerucut.luasPermukaan());
                break;

            case 6:
                double rB = inputPositif(in, "Jari-jari: ");
                BangunRuang.Bola bola = new BangunRuang.Bola(rB);
                System.out.printf("Volume = %.2f\n", bola.volume());
                System.out.printf("Luas Permukaan = %.2f\n", bola.luasPermukaan());
                break;
        }

        System.out.println("---------------------------");
    }
}