import java.util.Scanner;

class Bangun{
    double hitungLuas(){
        return 0;
    }
}

class BangunRuang extends Bangun{
    double hitungVolume(){
        return 0;
    }
}

class BangunDatar extends Bangun{
    double hitungKeliling(){
        return 0;
    }
}

// ----------------------------------
// BANGUN RUANG
// ----------------------------------

class Kubus extends BangunRuang{
    double sisiK;
    Kubus(double sisi){
        this.sisiK = sisi;
    }
    double hitungLuas(){
        return 6 * (sisiK * sisiK); // L = 6.(s*s)
    }
    double hitungVolume(){
        return sisiK * sisiK * sisiK; // V = s^3
    }
}

class Balok extends BangunRuang{
    double panjangB;
    double lebarB;
    double tinggiB;

    Balok (double panjang, double lebar, double tinggi){
        this.panjangB = panjang;
        this.lebarB = lebar;
        this.tinggiB = tinggi;
    }
    double hitungLuas(){
        return 2 * (panjangB*lebarB + panjangB*tinggiB + lebarB*tinggiB); // L = 2.(pl.pt.lt)
    }
    double hitungVolume(){
        return panjangB * lebarB * tinggiB; // V = p.l.t
    }
}

class Bola extends BangunRuang{
    double radiusB;

    Bola (double radius){
        this.radiusB = radius;
    }
    double hitungLuas(){
        return 4 * 3.14 * (radiusB * radiusB); // 4.pi.r^2
    }
    double hitungVolume(){
        return (4.0/3.0) * 3.14 * (radiusB * radiusB * radiusB); // 4/3.pi/r^3
    }
}

class Tabung extends BangunRuang{
    double radiusTB;
    double tinggiTB;

    Tabung (double radius, double tinggi){
        this.radiusTB = radius;
        this.tinggiTB = tinggi;
    }
    double hitungLuas(){
        return 2 * 3.14 * radiusTB * (radiusTB + tinggiTB); // 2.pi.r.(r+t)
    }
    double hitungVolume(){
        return 3.14 * (radiusTB * radiusTB) * tinggiTB; // pi..r^2.t
    }
}

// --------------------------------------------------
// BANGUN DATAR
// --------------------------------------------------

class Persegi extends BangunDatar{
    double sisiP;

    Persegi (double sisi){
        this.sisiP = sisi;
    }
    double hitungLuas(){
        return sisiP * sisiP; // s^s
    }
    double hitungKeliling(){
        return 4 * sisiP; // 4^s
    }
}

class PersegiPanjang extends BangunDatar{
    double panjangPP;
    double lebarPP;

    PersegiPanjang (double panjang, double lebar){
        this.panjangPP = panjang;
        this.lebarPP = lebar;
    }
    double hitungLuas(){
        return panjangPP * lebarPP; // p.l
    }
    double hitungKeliling(){
        return 2 * (panjangPP + lebarPP); // 2.(p.l)
    }
}

class Lingkaran extends BangunDatar{
    double radiusL;
    Lingkaran (double radius){
        this.radiusL = radius;
    }
    double hitungLuas(){
        return 3.14 * (radiusL * radiusL); // pi.r^2
    }
    double hitungKeliling(){
        return 2 * 3.14 * radiusL; // 2.pi.r
    }
}

class Trapesium extends BangunDatar{
    double sisiT1, sisiT2, sisiT3, sisiT4, tinggiT;
    Trapesium (double sisi1, double sisi2, double sisi3, double sisi4, double tinggi){
        this.sisiT1 = sisi1;
        this.sisiT2 = sisi2;
        this.sisiT3 = sisi3;
        this.sisiT4 = sisi4;
        this.tinggiT = tinggi;
    }
    double hitungLuas(){
        return 0.5 * (sisiT1 + sisiT2) * tinggiT;
    }
    double hitungKeliling(){
        return sisiT1 + sisiT2 + sisiT3 + sisiT4;
    }
}

public class BangunDaRu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n===== BANGUN RUANG =====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println("===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");


        System.out.print("\nPILIHAN : ");
        int pilihan = input.nextInt();

        switch (pilihan) {

            // -- Bangun Datar --

            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double sisiK = input.nextDouble();
                Kubus kubus = new Kubus(sisiK);
                System.out.println("Luas Permukaan: " + kubus.hitungLuas());
                System.out.println("Volume: " + kubus.hitungVolume());
                break;            
            
            case 2:
                System.out.print("Masukkan panjang balok: ");
                double panjangB = input.nextDouble();
                System.out.print("Masukkan lebar balok: ");
                double lebarB = input.nextDouble();
                System.out.print("Masukkan tinggi balok: ");
                double tinggiB = input.nextDouble();
                Balok balok = new Balok(panjangB, lebarB, tinggiB);
                System.out.println("Luas Permukaan: " + balok.hitungLuas());
                System.out.println("Volume: " + balok.hitungVolume());
                break;

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double radiusB = input.nextDouble();
                Bola bola = new Bola(radiusB);
                System.out.println("Luas Permukaan: " + bola.hitungLuas());
                System.out.println("Volume: " + bola.hitungVolume());
                break;

            case 4:
                System.out.print("Masukkan jari-jari tabung: ");
                double radiusTb = input.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tinggiTb = input.nextDouble();
                Tabung tabung = new Tabung(radiusTb, tinggiTb);
                System.out.println("Luas Permukaan: " + tabung.hitungLuas());
                System.out.println("Volume: " + tabung.hitungVolume());
                break;
            
            // -- Bangun Ruang --

            case 5:
                System.out.print("Masukkan sisi persegi: ");
                double sisiP = input.nextDouble();
                Persegi persegi = new Persegi(sisiP);
                System.out.println("Luas: " + persegi.hitungLuas());
                System.out.println("Keliling: " + persegi.hitungKeliling());
                break;

            case 6:
                System.out.print("Masukkan panjang persegi: ");
                double panjangPP = input.nextDouble();
                System.out.print("Masukkan lebar persegi: ");
                double lebarPP = input.nextDouble();
                PersegiPanjang perpan = new PersegiPanjang(panjangPP, lebarPP);
                System.out.println("Luas: " + perpan.hitungLuas());
                System.out.println("Keliling: " + perpan.hitungKeliling());
                break;

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double radiusL = input.nextDouble();
                Lingkaran lingkaran = new Lingkaran(radiusL);
                System.out.println("Luas: " + lingkaran.hitungLuas());
                System.out.println("Keliling: " + lingkaran.hitungKeliling());
                break;
            
            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double sisi1T = input.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double sisi2T = input.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double sisi3T = input.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double sisi4T = input.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tinggiT = input.nextDouble();
                Trapesium trapesium = new Trapesium(sisi1T, sisi2T, sisi3T, sisi4T, tinggiT);
                System.out.println("Luas: " + trapesium.hitungLuas());
                System.out.println("Keliling: " + trapesium.hitungKeliling());
                break;

            default:
                System.out.println("Angka tidak valid");
                break;
        }

        
    }
    
}
