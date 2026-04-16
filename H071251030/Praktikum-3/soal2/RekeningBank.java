class RekeningBank {
    private String nomorRekening;
    private String namePemilik;
    private Double saldo;
    
    public RekeningBank(String nomorRekening, String namaPemilik) {
        this.namePemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = 0.0;
    }

    public void getInfo() {
        System.out.println("Nama: " + namePemilik);
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Saldo sekarang: " + saldo);    }

    public void setorUang(Double jumlahSaldo) {
        if (jumlahSaldo > 0) {
            this.saldo += jumlahSaldo;
        } else {
            System.out.println("Jumlah tidak boleh negatif");
        }
    }

    public void tarikUang(Double jumlahSaldo) {
        if (jumlahSaldo > 0) {
            this.saldo -= jumlahSaldo; 
        } else {
            System.out.println("Jumlah tidak boleh");
        }
    }
}
