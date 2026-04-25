import java.util.Scanner;

class Bangun {
    String nama;
}

class BangunDatar extends Bangun {
    double keliling;
    double luas;
}    
class BangunRuang extends Bangun {
    double volume;
    double luasPermukaan;
}

class Lingkaran extends BangunDatar {
    double jariJari;
    
    void hitungLingkaran() {
        this.keliling = 2 * Math.PI * jariJari;
        this.luas = Math.PI * jariJari * jariJari;
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang;
    double lebar;
    
    void hitungPersegiPanjang() {
        this.keliling = 2 * (panjang + lebar);
        this.luas = panjang * lebar;
    }
}

class Persegi extends BangunDatar {
    double sisi;
    
    void hitungPersegi() {
        this.keliling = 4 * sisi;
        this.luas = sisi * sisi;
    }
}

class Trapesium extends BangunDatar {
    double sisiAtas;
    double sisiBawah;
    double sisiMiring1;
    double sisiMiring2;
    double tinggi;
    
    void hitungTrapesium() {
        this.keliling = sisiAtas + sisiBawah + sisiMiring1 + sisiMiring2;
        this.luas = ((sisiAtas + sisiBawah) / 2) * tinggi;
    }
}

class Kubus extends BangunRuang {
    double sisi;
    
    void hitungKubus() {
        this.volume = Math.pow(sisi, 3);
        this.luasPermukaan = 6 * Math.pow(sisi, 2);
    }
}

class Balok extends BangunRuang {
    double panjang;
    double lebar;
    double tinggi;
    
    void hitungBalok() {
        this.volume = panjang * lebar * tinggi;
        this.luasPermukaan = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }
}

class Tabung extends BangunRuang {
    double jariJari;
    double tinggi;
    
    void hitungTabung() {
        this.volume = Math.PI * Math.pow(jariJari, 2) * tinggi;
        this.luasPermukaan = 2 * Math.PI * jariJari * (jariJari + tinggi);
    }
}

class Bola extends BangunRuang {
    double jariJari;
    
    void hitungBola() {
        this.volume = (4 / 3) * Math.PI * Math.pow(jariJari, 3);
        this.luasPermukaan = 4 * Math.PI * Math.pow(jariJari, 2);
    }
}

public class TP4_1_H071251081 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("=== Bangun Datar ===");
            System.out.println("1. Lingkaran");
            System.out.println("2. Persegi Panjang"); 
            System.out.println("3. Persegi");
            System.out.println("4. Trapesium");
            System.out.println("=== Bangun Ruang ===");
            System.out.println("5. Kubus");
            System.out.println("6. Balok");
            System.out.println("7. Tabung");
            System.out.println("8. Bola");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    Lingkaran lingkaran = new Lingkaran();
                    System.out.print("Masukkan jari-jari: ");
                    lingkaran.jariJari = input.nextDouble();
                    lingkaran.hitungLingkaran();
                    System.out.println("Keliling Lingkaran: " + lingkaran.keliling);
                    System.out.println("Luas Lingkaran: " + lingkaran.luas);
                    break;
                case 2:
                    PersegiPanjang persegiPanjang = new PersegiPanjang();
                    System.out.print("Masukkan panjang: ");
                    persegiPanjang.panjang = input.nextDouble();
                    System.out.print("Masukkan lebar: ");
                    persegiPanjang.lebar = input.nextDouble();
                    persegiPanjang.hitungPersegiPanjang();
                    System.out.println("Keliling Persegi Panjang: " + persegiPanjang.keliling);
                    System.out.println("Luas Persegi Panjang: " + persegiPanjang.luas);
                    break;
                case 3:
                    Persegi persegi = new Persegi();
                    System.out.print("Masukkan sisi: ");
                    persegi.sisi = input.nextDouble();
                    persegi.hitungPersegi();
                    System.out.println("Keliling Persegi: " + persegi.keliling);
                    System.out.println("Luas Persegi: " + persegi.luas);
                    break;
                case 4:
                    Trapesium trapesium = new Trapesium();
                    System.out.print("Masukkan sisi atas: ");
                    trapesium.sisiAtas = input.nextDouble();
                    System.out.print("Masukkan sisi bawah: ");
                    trapesium.sisiBawah = input.nextDouble();
                    System.out.print("Masukkan sisi miring 1: ");
                    trapesium.sisiMiring1 = input.nextDouble();
                    System.out.print("Masukkan sisi miring 2: ");
                    trapesium.sisiMiring2 = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    trapesium.tinggi = input.nextDouble();
                    trapesium.hitungTrapesium();
                    System.out.println("Keliling Trapesium: " + trapesium.keliling);
                    System.out.println("Luas Trapesium: " + trapesium.luas);
                    break;
                case 5:
                    Kubus kubus = new Kubus();
                    System.out.print("Masukkan sisi: ");
                    kubus.sisi = input.nextDouble();
                    kubus.hitungKubus();
                    System.out.println("Volume Kubus : " + kubus.volume);
                    System.out.println("Luas Permukaan Kubus: " + kubus.luasPermukaan);
                    break;
                case 6:
                    Balok balok = new Balok();
                    System.out.print("Masukkan panjang: ");
                    balok.panjang = input.nextDouble();
                    System.out.print("Masukkan lebar: ");
                    balok.lebar = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    balok.tinggi = input.nextDouble();
                    balok.hitungBalok();
                    System.out.println("Volume Balok: " + balok.volume);
                    System.out.println("Luas Permukaan Balok: " + balok.luasPermukaan);
                    break;
                case 7:
                    Tabung tabung = new Tabung();
                    System.out.print("Masukkan jari-jari: ");
                    tabung.jariJari = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    tabung.tinggi = input.nextDouble();
                    tabung.hitungTabung();
                    System.out.println("Volume Tabung: " + tabung.volume);
                    System.out.println("Luas Permukaan Tabung: " + tabung.luasPermukaan);
                    break;
                case 8:
                    Bola bola = new Bola();
                    System.out.print("Masukkan jari-jari: ");
                    bola.jariJari = input.nextDouble();
                    bola.hitungBola();
                    System.out.println("Volume Bola: " + bola.volume);
                    System.out.println("Luas Permukaan Bola: " + bola.luasPermukaan);
                    break;
            } 
        } while (pilihan != 0); //


    }
}