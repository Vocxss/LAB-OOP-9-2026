class DompetDigital {
    protected String id;
    String name;
    String email;
    private int saldo;
    private String PIN;
    
    public DompetDigital(String name, String email, String PIN) {
        this.id = "IDN" + (int) (Math.random() * 1000000);
        this.name = name;
        this.email = email;
        this.saldo = 0;
        this.PIN = PIN.length() ==  6 ? PIN : "000000";
    }

    private boolean cekPIN(String PIN) {
        if (PIN.equals(this.PIN)) {
            return true;
        } else {
            return false;
        }
    }

    public void setPINBaru(String newPIN, String oldPIN) {
        if (!cekPIN(oldPIN)) {
            System.out.println("PIN lama yang dimasukkan salah");
        }
        else if (newPIN.length() != 6) {
            System.out.println("PIN baru harus terdiri dari 6 digit");
        } else {
            this.PIN = newPIN;
            System.out.println("PIN berhasil diubah");
        }
    }
    
    private void catatLog(String pesan) {
        System.out.println("Log: " + pesan);
    }

    public void getInfoAkun() {
        System.out.println("Nama: " + name);
        System.out.println("Email: " + email);
        System.out.println("Saldo sekarang: " + saldo);
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setName(String name, String PIN) {
        this.name = cekPIN(PIN) ? name : this.name;
    }

    public String getName() {
       return this.name;
    }

    public void setor(int jumlah, String PIN) {
        if (cekPIN(PIN)) {
            if (jumlah > 0) {
                this.saldo += jumlah;
                catatLog("Setoran sebesar " + jumlah + " berhasil");
            } else {
                System.out.println("Jumlah setoran tidak boleh negatif");
            }
        } else {
            System.out.println("PIN salah");
        }
    }

    public void tarik(int jumlah, String PIN) {
        if (cekPIN(PIN)) {
            if (jumlah > 0 && jumlah <= saldo) {
                this.saldo -= jumlah;
                catatLog("Penarikan sebesar " + jumlah + " berhasil");
            } else {
                System.out.println("Jumlah penarikan tidak boleh negatif atau lebih besar dari saldo");
            }
        } else {
            System.out.println("PIN salah");
        }
    }

    public void transfer(int jumlah, String PIN) {
        if (cekPIN(PIN)) {
            if (jumlah > 0 && jumlah <= saldo) {
                this.saldo -= jumlah;
                catatLog("Transfer sebesar " + jumlah + " berhasil");
            } else {
                System.out.println("Jumlah transfer tidak boleh negatif atau lebih besar dari saldo");
            }
        } else {
            System.out.println("PIN salah");
        }
    }

}