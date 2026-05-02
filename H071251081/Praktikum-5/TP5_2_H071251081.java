abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println("Perangkat " + merk + " sedang menyedot daya listrik sebesar " + dayaListrik + " watt.");
    }
}

interface InteraksiInternet {
    void hubungkanWIFI();
}

interface KontrolSuara {
    void prosesPerintah(String perintah);
}

class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi : Smart Lamp");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu Berpijar");
        } else {
            System.out.println("Perintah lampu tidak dikenal.");
        }
    }
}

class smartCCTV extends PerangkatElektronik implements InteraksiInternet {
    smartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi : Smart CCTV");
    }

    @Override
    public void hubungkanWIFI() {
        System.out.println("Mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements KontrolSuara, InteraksiInternet {
    SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi : Audio dan Asisten Virtual");
    }

    @Override
    public void hubungkanWIFI() {
        System.out.println("Speaker terhubung ke Spotify");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Speaker memproses perintah suara: " + perintah);
        if (perintah.equalsIgnoreCase("PUTAR MUSIK")) {
            System.out.println("Memutar musik...");
        }
    }
}

public class TP5_2_H071251081 {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 10);
        lampu.cekFungsi();
        lampu.infoPower();
        lampu.prosesPerintah("NYALA");

        System.out.println();

        smartCCTV cctv = new smartCCTV("Nest Cam", 5);
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWIFI();

        System.out.println();

        SmartSpeaker speaker = new SmartSpeaker("JBL", 15);
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.prosesPerintah("PUTAR MUSIK");
        speaker.hubungkanWIFI();
    }
}