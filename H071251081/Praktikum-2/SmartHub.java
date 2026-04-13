public class SmartHub {
    // --- ATRIBUT ---
    public String labelRuangan;
    public boolean modeHematEnergi;
    public PerangkatElektronik perangkatUtama; // Atribut bertipe objek 

    // --- CONSTRUCTOR ---
    
    // 1. Constructor Default [cite: 14]
    public SmartHub() {
        this.labelRuangan = "Default Room";
        this.modeHematEnergi = false;
        this.perangkatUtama = new PerangkatElektronik("Smart Light", 10);
    }

    // 2. Constructor dengan Parameter [cite: 15]
    public SmartHub(String label, boolean hemat, PerangkatElektronik perangkat) {
        this.labelRuangan = label;
        this.modeHematEnergi = hemat;
        this.perangkatUtama = perangkat;
    }

    // --- BEHAVIOR / METHOD ---

    // Method 1: Interaksi antar objek dari class yang sama 
    public void sinkronisasi(SmartHub targetHub) {
        this.modeHematEnergi = targetHub.modeHematEnergi;
        System.out.println("Sistem di [" + this.labelRuangan + "] kini mengikuti pengaturan dari [" + targetHub.labelRuangan + "]");
    }

    // Method 2: Berinteraksi langsung dengan atribut objek 
    public void cekStatusSistem() {
        System.out.println("=== Status Smart Hub: " + labelRuangan + " ===");
        System.out.println("Mode Hemat: " + (modeHematEnergi ? "Aktif" : "Non-Aktif"));
        System.out.print("Perangkat Terhubung: ");
        perangkatUtama.tampilkanInfo(); // Interaksi dengan atribut objek
    }
}