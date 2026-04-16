public class Main {
    public static void main(String[] args) {
        SistemOperasi osVan = new SistemOperasi("Parrot OS", "6.0");
        
        Hacker hacker1 = new Hacker("Van", 85, osVan);
        Hacker hacker2 = new Hacker();

        hacker1.tampilkanProfil();
        hacker2.tampilkanProfil();

        hacker1.belajarToolBaru();      
        hacker1.ujiPenetrasi(hacker2);

        hacker1.tampilkanProfil();
        hacker2.tampilkanProfil();
    }
}