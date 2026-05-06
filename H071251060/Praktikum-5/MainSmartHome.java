abstract class PerangkatElektronik {
    String merek;
    int dayaListrik;

    PerangkatElektronik(String merek, int daya) {
        this.merek = merek;
        this.dayaListrik = daya; 
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println(merek + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}

interface InteraksiInternet {
    void hubungkanWiFi();
}

interface KontrolSuara {
    void prosesPerintah(String perintah);
}

class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    SmartLamp(String merek, int daya) {
        super(merek, daya);
    }
    
    void cekFungsi() {
        System.out.println("Fungsi: Penerangan pintar.");
    }

    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }

}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    SmartCCTV(String merek, int daya) { super(merek, daya); }

    void cekFungsi() {
        System.out.println("Fungsi: Keamanan lingkungan.");
    }

    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    SmartSpeaker(String merek, int daya) { super(merek, daya); }

    void cekFungsi() { System.out.println("Fungsi: Hiburan dan asisten suara."); }

    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung ke internet.");
    }

    public void prosesPerintah(String perintah) {
        System.out.println("Memproses suara: " + perintah);
    }
}

public class MainSmartHome {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 15);
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 10);
        SmartSpeaker speaker = new SmartSpeaker("Google Home", 25);

        System.out.println("--- Demo Smart Speaker ---");
        speaker.infoPower(); 
        speaker.hubungkanWiFi(); 
        speaker.prosesPerintah("Putar musik"); 
        
        System.out.println("\n--- Demo Lampu ---");
        lampu.prosesPerintah("NYALA");


 
    }
}