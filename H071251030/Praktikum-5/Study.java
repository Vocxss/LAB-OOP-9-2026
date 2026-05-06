public class Study {
    static void mesan(String makanan) {
        System.out.println("Memesan: " + makanan);
    }

    static void mesan(String makanan, int jumlah) {
        System.out.println("Memesan: " + jumlah + " porsi " + makanan);
    }

    static void mesan(String makanan, int jumlah, String cat) {
        System.out.println("Memesan: " + jumlah + " porsi " + makanan + " - " + "Catatan: " + cat);
    }

}

class Main {
    public static void main(String[] args) {
        Study.mesan("Nasi Goreng");
        Study.mesan("Mie Ayam", 2);
        Study.mesan("Soto", 3, "Tanpa sambal");
    }
}
