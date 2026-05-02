package Soal2;

public class Main {
   public static void main(String[] args) {

      System.out.println("===== SmartLamp =====");
      SmartLamp lamp = new SmartLamp("Philips", 10);
      lamp.cekFungsi();
      lamp.infoPower();
      lamp.prosesPerintah("NYALA");
      lamp.prosesPerintah("MATI");

      System.out.println("\n===== SmartCCTV =====");
      SmartCCTV cctv = new SmartCCTV("Hikvision", 15);
      cctv.cekFungsi();
      cctv.infoPower();
      cctv.hubungkanWiFi();

      System.out.println("\n===== SmartSpeaker =====");
      SmartSpeaker speaker = new SmartSpeaker("JBL", 25);
      speaker.cekFungsi();          
      speaker.infoPower();          
      speaker.hubungkanWiFi();       
      speaker.prosesPerintah("Putar lagu");  
   }
}

