import java.util.Scanner;

public class Main {
    static int jumlah = 20;

    static void Separator() {
        for (int i = 0; i <= jumlah; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Separator();
        System.out.println("BANGUN DATAR");
        System.out.println("1. PERSEGI");
        System.out.println("2. PERSEGI PANJANG");
        System.out.println("3. SEGITIGA");
        System.out.println("4. LINGKARAN");
        Separator();
        System.out.println("BANGUN RUANG");
        System.out.println("5. KUBUS");
        System.out.println("6. BALOK");
        System.out.println("7. BOLA");
        Separator();
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                System.out.println("PERSEGI");
                System.out.println("Masukkan sisi: ");
                int sisi = input.nextInt();
                Persegi persegi = new Persegi(sisi);
                persegi.Luas();
                persegi.Keliling();
                break;
            case 2:
                System.out.println("PERSEGI PANJANG");
                System.out.println("Masukkan panjang: ");
                int panjang = input.nextInt();
                System.out.println("Masukkan lebar: ");
                int lebar = input.nextInt();
                PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
                persegiPanjang.Luas();
                persegiPanjang.Keliling();
                break;
            case 3:
                System.out.println("SEGITIGA");
                System.out.println("Masukkan alas: ");
                int alas = input.nextInt();
                System.out.println("Masukkan tinggi: ");
                int tinggi = input.nextInt();
                Segitiga segitiga = new Segitiga(alas, tinggi);
                segitiga.Luas();
                segitiga.Keliling();
                break;
            case 4:
                System.out.println("LINGKARAN");
                System.out.println("Masukkan jari-jari: ");
                int r = input.nextInt();
                Lingkaran lingkaran = new Lingkaran(r);
                lingkaran.Luas();
                lingkaran.Keliling();
                break;
            case 5:
                System.out.println("KUBUS");
                System.out.println("Masukkan sisi: ");
                int sisi2 = input.nextInt();
                Kubus kubus = new Kubus(sisi2);
                kubus.LuasPermukaan();
                kubus.Volume();
                break;
            case 6:
                System.out.println("BALOK");
                System.out.println("Masukkan panjang: ");
                int panjang2 = input.nextInt();
                System.out.println("Masukkan lebar: ");
                int lebar2 = input.nextInt();
                System.out.println("Masukkan tinggi: ");
                int tinggi2 = input.nextInt();
                Balok balok = new Balok(panjang2, lebar2, tinggi2);
                balok.LuasPermukaan();
                balok.Volume();
                break;
            case 7:
                System.out.println("BOLA");
                System.out.println("Masukkan jari-jari: ");
                int r2 = input.nextInt();
                Bola bola = new Bola(r2);
                bola.LuasPermukaan();
                bola.Volume();
                break;
            default:
                System.out.println("Pilihan tidak ada");
                break;
        }

        input.close();
    }
}
