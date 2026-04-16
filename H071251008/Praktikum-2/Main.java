public class Main {
    public static void main(String[] args) {
        // Inisialisasi Driver
        DriverF1 oscar = new DriverF1("Oscar Piastri", 330.0, new BanF1("Hard", 18));
        DriverF1 lando = new DriverF1("Lando Norris", 332.0, new BanF1("Hard", 18));
        DriverF1 charles = new DriverF1("Charles Leclerc", 335.0, new BanF1("Hard", 18));

        // Inisialisasi Strategist
        HeadOfStrategy mclarenOscar = new HeadOfStrategy("Randeep Singh", "McLaren", oscar);
        HeadOfStrategy mclarenLando = new HeadOfStrategy("Will Joseph", "McLaren", lando);
        HeadOfStrategy ferrari = new HeadOfStrategy("Bryan Bozzi", "Ferrari", charles);

        System.out.println("SITUASI BALAPAN - LAP 20/50");
        mclarenOscar.cetakDashboard();
        ferrari.cetakDashboard();

        // 1. McLaren melakukan Undercut
        mclarenOscar.eksekusiUndercut("Medium");

        // 2. Ferrari membalas dengan Multi-Mapping
        ferrari.responMultiMapping(mclarenOscar);
        
        // 3. McLaren mengeluarkan Team Orders (Oscar membantu Lando)
        mclarenOscar.instruksiTeamOrders(mclarenLando);

        System.out.println("\nKONDISI AKHIR:");
        mclarenOscar.cetakDashboard();
        mclarenLando.cetakDashboard();
        ferrari.cetakDashboard();
    }
}