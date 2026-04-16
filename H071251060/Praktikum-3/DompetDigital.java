

public class DompetDigital {
    private double saldo;          
    private String pin;            
    protected String namaPemilik;  
    String tipe;               

    public DompetDigital(String id, String pinAwal) {
        this.namaPemilik = id;
        this.pin = pinAwal;
        this.saldo = 0; 
        this.tipe = "Pribadi";
        notif("Akun baru berhasil dibuat.");
    }

    private void notif(String pesan) {
        System.out.println("Notifikasi: " + pesan);
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPin(String pinLama, String pinBaru) {
        if (pinLama.equals(this.pin)) {
            if (pinBaru.length() == 6) {
                this.pin = pinBaru;
                notif("Perubahan PIN berhasil.");
            } else {
                System.out.println("Gagal: PIN baru harus 6 karakter!");
            }
        } else {
            System.out.println("Gagal: PIN lama tidak sesuai!");
        }
    }

    public void setorTunai(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            notif("Setor tunai berhasil sebesar " + jumlah);
        } else {
            System.out.println("Gagal: Jumlah setor tidak boleh negatif!");
        }
    }

    public void tarikTunai(double jumlah, String pinInput) {
        if (pinInput.equals(this.pin)) {
            if (this.saldo >= jumlah) {
                this.saldo -= jumlah;
                notif("Tarik tunai berhasil sebesar " + jumlah);
            } else {
                System.out.println("Gagal: Saldo tidak mencukupi!");
            }
        } else {
            System.out.println("Gagal: PIN yang Anda masukkan salah!");
        }
    }
}