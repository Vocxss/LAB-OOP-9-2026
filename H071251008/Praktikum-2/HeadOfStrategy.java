class HeadOfStrategy {
    String namaStrategist;
    String tim;
    String engineMapping; 
    DriverF1 driver; 

    // 1. Constructor Default
    public HeadOfStrategy() {
        this.namaStrategist = "Analyst";
        this.tim = "Unknown";
        this.engineMapping = "Standard";
        this.driver = new DriverF1("TBC", 320.0, new BanF1("Hard", 10));
    }
    // 2. Constructor Parameter
    public HeadOfStrategy(String nama, String tim, DriverF1 driver) {
        this.namaStrategist = nama;
        this.tim = tim;
        this.engineMapping = "Standard";
        this.driver = driver;
    }

    // Behaviour 1
    public void eksekusiUndercut(String tipeBaru) {
        System.out.println("\n[STRATEGI MCLAREN] " + namaStrategist + " (McLaren): \"" + driver.nama + ", box now for " + tipeBaru + ". Push for the undercut!\"");
        
        // Direct Access: Langsung mengubah isi objek di dalam objek
        this.driver.ban = new BanF1(tipeBaru, 0); 
        this.driver.baseSpeed += 12.0;           
        
        System.out.println("Hasil: " + driver.nama + " keluar dengan ban segar. Out-lap sangat kencang!");
    }
    // Behaviour 2
    public void responMultiMapping(HeadOfStrategy lawan) {
        System.out.println("\n[STRATEGI FERRARI] " + this.namaStrategist + " (" + this.tim + "): \"" + this.driver.nama + ", switch to SOC 1. We need to break the tow! Push now!\"");
        this.engineMapping = "SOC 1 - Deployment Max";
        this.driver.baseSpeed += 8.0; 
        
        // Efek Dirty Air: Mengurangi speed objek lawan secara langsung
        lawan.driver.baseSpeed -= 5.0; 
        System.out.println("Hasil: Ferrari menghasilkan turbulensi! " + lawan.driver.nama + " kehilangan downforce.");
    }
    // Behaviour 3
    public void instruksiTeamOrders(HeadOfStrategy rekanSetim) {
        System.out.println("\n[STRATEGI MCLAREN] " + this.namaStrategist + " ke " + this.driver.nama + ": \"" + this.driver.nama + ", it's Randeep. Swap positions with " + rekanSetim.driver.nama + ".\"");
        
        // Logika: Bertukar kecepatan agar posisi berubah
        this.driver.baseSpeed -= 15.0;
        rekanSetim.driver.baseSpeed += 15.0;
        
        System.out.println("Hasil: " + this.driver.nama + " melambat untuk memberikan jalan kepada " + rekanSetim.driver.nama + ".");
    }

    public void cetakDashboard() {
        System.out.println(">>> DASHBOARD " + tim + " <<<");
        System.out.println("Strategist : " + namaStrategist);
        System.out.println("Driver     : " + driver.nama);
        System.out.println("Ban        : " + driver.ban.tipe + " (Usia: " + driver.ban.usiaLap + " lap)");
        System.out.println("Engine Map : " + engineMapping);
        System.out.println("Top Speed  : " + driver.baseSpeed + " km/h");
        System.out.println("-----------------------------------");
    }
}