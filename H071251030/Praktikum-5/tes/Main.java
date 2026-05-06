package tes;
public class Main {
    public static void main(String[] args) {
        Transfer tf = new Transfer();
        Tunai tn = new Tunai();
        tf.bayar(10000);
        tn.bayar(1000);

        tf.bayar(10000, "bri");
        tn.bayar(1000, "adalah pokoknya");
    }
}
