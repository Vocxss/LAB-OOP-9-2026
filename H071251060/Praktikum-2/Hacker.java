public class Hacker {
    String nickname;
    int levelKeahlian;
    SistemOperasi os;

    public Hacker() {
        this.nickname = "Anonymous";
        this.levelKeahlian = 10;
        this.os = new SistemOperasi("Kali Linux", "2024.1");
    }

    public Hacker(String nickname, int level, SistemOperasi os) {
        this.nickname = nickname;
        this.levelKeahlian = level;
        this.os = os;
    }

    public void belajarToolBaru() {
        System.out.println(this.nickname + " sedang mempelajari tool baru di " + this.os.namaOS);
        this.levelKeahlian += 5;
        System.out.println("Level keahlian meningkat! Sekarang: " + this.levelKeahlian);
    }

    public void ujiPenetrasi(Hacker target) {
        System.out.println(this.nickname + " mencoba melakukan uji penetrasi ke sistem " + target.nickname);
        
        if (this.levelKeahlian > target.levelKeahlian) {
            System.out.println("Akses berhasil didapatkan!");
            target.levelKeahlian -= 2;
        } else {
            System.out.println("Akses ditolak! Keamanan target terlalu kuat.");
        }
    }

    public void tampilkanProfil() {
        System.out.println("===== Profil Hacker =====");
        System.out.println("Nickname : " + nickname);
        System.out.println("Level    : " + levelKeahlian);
        System.out.println("OS Utama : " + os.namaOS + " (" + os.versi + ")");
        System.out.println("=========================");
    }
}
