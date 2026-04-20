class BangunRuang {
    String nama;
    int panjang, lebar, tinggi;

    void LuasPermukaan() {
        System.out.println("");
    }

    void Volume() {
        System.out.println("");
    }
}

class Kubus extends BangunRuang {
    Kubus(int sisi) {
        this.nama = "Kubus";
        this.panjang = sisi;
    }

    @Override
    void LuasPermukaan() {
        System.out.println("Luas Permukaan: " + (6 * panjang));
    }

    void Volume() {
        System.out.println("Volume: " + (Math.pow(panjang, 3)));
    }
}

class Balok extends BangunRuang {
    Balok(int panjang, int lebar, int tinggi) {
        this.nama = "Balok";
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    @Override
    void LuasPermukaan() {
        System.out.println("Luas Permukaan: " + ((2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi)))));
    }

    void Volume() {
        System.out.println("Volume: " + (panjang * lebar * tinggi));
    }
}

class Bola extends BangunRuang {
    int r;

    Bola(int r) {
        this.nama = "Bola";
        this.r = r;
    }

    @Override
    void LuasPermukaan() {
        System.out.println("Luas Permukaan: " + (4 * Math.PI * r * r));
    }

    void Volume() {
        System.out.println("Volume: " + ((4 / 3) * Math.PI * r * r * r));
    }
}
