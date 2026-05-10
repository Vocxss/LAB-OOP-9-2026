class Bangun {
    public void hitungLuas() {}
}

class BangunRuang extends Bangun {
    public void hitungVolume() {}
}

class BangunDatar extends Bangun {
    public void hitungKeliling() {}
}

class Kubus extends BangunRuang {
    double sisi;
    Kubus(double sisi) {
        this.sisi = sisi;
    }
    
    public void hitungLuas() {
        System.out.println("Luas Kubus: " + (6 * sisi * sisi));
    }
    public void hitungVolume() {
        System.out.println("Volume Kubus: " + (sisi * sisi * sisi));
    }
}

class Balok extends BangunRuang {
    double p, l, t;
    Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    public void hitungLuas() {
        System.out.println("Luas Balok: " + (2 * (p * l + p * t + l * t)));
    }
    public void hitungVolume() {
        System.out.println("Volume Balok: " + (p * l * t));
    }
}

class Bola extends BangunRuang {
    double r;
    double pi = 3.14;
    Bola(double r) {
        this.r = r;
    }

    public void hitungLuas() {
        System.out.println("Luas Bola: " + (4 * pi * r * r));
    }
    public void hitungVolume() {
        System.out.println("Volume Bola: " + ((4.0 / 3) * pi * r * r * r));
    }
}

class Tabung extends BangunRuang {
    double r, t;
    double pi = 3.14;

    Tabung(double r, double t) {
        this.r = r;
        this.t = t;
    }

    public void hitungLuas() {
        System.out.println("Luas Tabung: " + (2 * pi * r * (r + t)));
    }
    public void hitungVolume() {
        System.out.println("Volume Tabung: " + (pi * r * r * t));
    }
}

class Persegi extends BangunDatar {
    double sisi;
    Persegi(double sisi) {
        this.sisi = sisi;
    }

    public void hitungLuas() {
        System.out.println("Luas Persegi: " + (sisi * sisi));
    }
    public void hitungKeliling() {
        System.out.println("Keliling Persegi: " + (4 * sisi));
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;
    PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    public void hitungLuas() {
        System.out.println("Luas Persegi Panjang: " + (p * l));
    }
    public void hitungKeliling() {
        System.out.println("Keliling Persegi Panjang: " + (2 * (p + l)));
    }
}

class Lingkaran extends BangunDatar {
    double r;
    double pi = 3.14;

    Lingkaran(double r) {
        this.r = r;
    }

    public void hitungLuas() {
        System.out.println("Luas Lingkaran: " + (pi * r * r));
    }
    public void hitungKeliling() {
        System.out.println("Keliling Lingkaran: " + (2 * pi * r));
    }
}

class Trapesium extends BangunDatar {
    double a, b, c, d, tinggi;
    Trapesium(double a, double b, double c, double d, double tinggi) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.tinggi = tinggi;
    }
    
    public void hitungLuas() {
        System.out.println("Luas trapesium: " + (0.5 * (a + b) * tinggi));
    }
    public void hitungKeliling() {
        System.out.println("Keliling trapesium: " + (a + b + c + d));
    }
}

