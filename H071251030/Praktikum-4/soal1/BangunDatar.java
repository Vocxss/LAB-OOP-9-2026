class BangunDatar {
    String nama;
    int panjang, lebar;

    void Luas() {
        System.out.println("");
    }

    void Keliling() {
        System.out.println("");
    }
}

class Persegi extends BangunDatar {
    Persegi(int sisi_1) {
        this.nama = "Persegi";
        this.panjang = sisi_1;
        this.lebar = sisi_1;
    }

    @Override
    void Luas() {
        System.out.println("Luas: " + (this.panjang * this.lebar));
    }

    @Override
    void Keliling() {
        System.out.println("Keliling: " + (4 * this.panjang));
    }
}

class PersegiPanjang extends BangunDatar {
    PersegiPanjang(int panjang, int lebar) {
        this.nama = "Persegi Panjang";
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    void Luas() {
        System.out.println("Luas: " + (this.panjang * this.lebar));
    }

    @Override
    void Keliling() {
        System.out.println("Keliling: " + (2 * (this.panjang + this.lebar)));
    }
}

class Segitiga extends BangunDatar {
    int alas, tinggi;

    Segitiga(int alas, int tinggi) {
        this.nama = "Segitiga";
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    void Luas() {
        System.out.println("Luas: " + (0.5 * alas * tinggi));
    }

    @Override
    void Keliling() {
        System.out.println("Keliling: " + (3 * alas));
    }
}

class Lingkaran extends BangunDatar {
    int r;

    Lingkaran(int r) {
        this.nama = "Lingkaran";
        this.r = r;
    }

    @Override
    void Luas() {
        System.out.println("Luas: " + (Math.PI * Math.pow(r, 2)));
    }

    @Override
    void Keliling() {
        System.out.println("Keliling: " + (2 * Math.PI * r));
    }
}
