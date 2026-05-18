import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("-------------------------");
            System.out.println("  ==== BANGUN RUANG ====");
            System.out.println("1. KUBUS");
            System.out.println("2. BALOK");
            System.out.println("3. BOLA");
            System.out.println("4. TABUNG");
            System.out.println();
            System.out.println("  ==== BANGUN DATAR ====");
            System.out.println("5. PERSEGI");
            System.out.println("6. PERSEGI PANJANG");
            System.out.println("7. LINGKARAN");
            System.out.println("8. TRAPESIUM");
            System.out.println("9. KELUAR");
            System.out.println("-------------------------");
            System.out.print("Pilihan: ");
            pilihan = inp.nextInt();
            System.out.println("-------------------------");

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan sisi kubus: ");
                    double sikub = inp.nextDouble();
                    Kubus kubus = new Kubus(sikub);
                    kubus.hitungLuas();
                    kubus.hitungVolume();
                    break;
                case 2:
                    System.out.print("Masukkan panjang balok: ");
                    double pabal = inp.nextDouble();
                    System.out.print("Masukkan lebar balok: ");
                    double lebal = inp.nextDouble();
                    System.out.print("Masukkan tinggi balok: ");
                    double tibal = inp.nextDouble();
                    Balok balok = new Balok(pabal, lebal, tibal);
                    balok.hitungLuas();
                    balok.hitungVolume();
                    break;
                case 3:
                    System.out.print("Masukkan jari-jari bola: ");
                    double jarbol = inp.nextDouble();
                    Bola bola = new Bola(jarbol);
                    bola.hitungLuas();
                    bola.hitungVolume();
                    break;
                case 4:
                    System.out.print("Masukkan jari-jari tabung: ");
                    double jartub = inp.nextDouble();
                    System.out.print("Masukkan tinggi tabung: ");
                    double tingtub = inp.nextDouble();
                    Tabung tabung = new Tabung(jartub, tingtub);
                    tabung.hitungLuas();
                    tabung.hitungVolume();
                    break;
                case 5:
                    System.out.print("Masukkan sisi persegi: ");
                    double siper = inp.nextDouble();
                    Persegi persegi = new Persegi(siper);
                    persegi.hitungLuas();
                    persegi.hitungKeliling();
                    break;
                case 6:
                    System.out.print("Masukkan panjang: ");
                    double paper = inp.nextDouble();
                    System.out.print("Masukkan lebar: ");
                    double leper = inp.nextDouble();
                    PersegiPanjang persegiPanjang = new PersegiPanjang(paper, leper);
                    persegiPanjang.hitungLuas();
                    persegiPanjang.hitungKeliling();
                    break;
                case 7:
                    System.out.print("Masukkan jari-jari lingkaran: ");
                    double jarling = inp.nextDouble();
                    Lingkaran lingkaran = new Lingkaran(jarling);
                    lingkaran.hitungLuas();
                    lingkaran.hitungKeliling();
                    break;
                case 8:
                    System.out.print("Masukkan sisi 1 trapesium: ");
                    double siwan = inp.nextDouble();
                    System.out.print("Masukkan sisi 2 trapesium: ");
                    double situ = inp.nextDouble();
                    System.out.print("Masukkan sisi 3 trapesium: ");
                    double sitri = inp.nextDouble();
                    System.out.print("Masukkan sisi 4 trapesium: ");
                    double sifor = inp.nextDouble();
                    System.out.print("Masukkan tinggi trapesium: ");
                    double tingtra = inp.nextDouble();
                    Trapesium trapesium = new Trapesium(siwan, situ, sitri, sifor, tingtra);
                    trapesium.hitungLuas();
                    trapesium.hitungKeliling();
                    break;
                case 9:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println("-------------------------");
        } while (pilihan != 9);

        inp.close();
    }
}