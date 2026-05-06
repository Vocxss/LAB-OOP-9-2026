package adalah;

public class Main {
    public static void main(String[] args) {
        Pegawai[] pegawai = new Pegawai[2];
        pegawai[0] = new Dokter();
        pegawai[1] = new Guru();
        
        for (int i = 0; i < pegawai.length; i++) {
            pegawai[i].bekerja();
        }
    }
}
