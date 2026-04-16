public class Main {
    public static void main(String[] args) {
        DompetDigital dompet = new DompetDigital("Ningen", "johndoe@gmail.com", "123456");

        // 1. Tampilkan info akun via Getter
        System.out.println("=== Info Akun ===");
        System.out.println("Nama: " + dompet.getName());
        System.out.println("Saldo: " + dompet.getSaldo());

        // 2. Ubah PIN - PIN lama SALAH (harus ditolak)
        System.out.println("\n=== Ubah PIN (PIN lama salah) ===");
        dompet.setPINBaru("654321", "000000");

        // 3. Ubah PIN - syarat benar (harus berhasil)
        System.out.println("\n=== Ubah PIN (benar) ===");
        dompet.setPINBaru("654321", "123456");

        // 4. Setor tunai valid
        System.out.println("\n=== Setor Tunai (valid) ===");
        dompet.setor(500000, "123456");

        // 5. Setor tunai negatif (harus ditolak)
        System.out.println("\n=== Setor Tunai (negatif) ===");
        dompet.setor(-50000, "123456");

        // 6. Tarik tunai - PIN lama/salah (harus ditolak)
        System.out.println("\n=== Tarik Tunai (PIN lama) ===");
        dompet.tarik(100000, "123456");

        // 7. Tarik tunai - PIN baru/benar (harus berhasil)
        System.out.println("\n=== Tarik Tunai (PIN benar) ===");
        dompet.tarik(100000, "654321");

        // 8. Tampilkan saldo akhir
        System.out.println("\n=== Saldo Akhir ===");
        System.out.println("Saldo: " + dompet.getSaldo());
    }
}
