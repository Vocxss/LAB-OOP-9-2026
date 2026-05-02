package Soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] Siap diko.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("Nyala")) {
            System.out.println("[" + merk + "] Lampu menyala!");
        } else if (
            perintah.equalsIgnoreCase("Mati")
        ) { System.out.println("[" + merk + "] Lampu mati!");
        } else {
            System.out.println("[" + merk + "] Perintah tidak dikenali: " + perintah);
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] Kamera aktif dan merekam.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("[" + merk + "] Mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] Siap memutar musik dan menerima perintah suara.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("[" + merk + "] Terhubung ke WiFi. Streaming musik dimulai...");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("[" + merk + "] Memproses perintah: \"" + perintah + "\"");
    }
}
