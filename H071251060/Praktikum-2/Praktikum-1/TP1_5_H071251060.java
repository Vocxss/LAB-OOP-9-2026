import java.util.Scanner;

public class TP1_5_H071251060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

            try {
                System.out.println("Input :");
                int cari = sc.nextInt();

                boolean ketemu = false;
                
                for (int baris = 0; baris < nums.length; baris++) {
                    for (int kolom = 0; kolom < nums[baris].length; kolom++) {
                        
                        if (nums[baris][kolom] == cari) {
                            System.out.println("Found " + cari + " at [" + (baris + 1) + "][" + (kolom + 1) + "]");
                            ketemu = true;
                            break;
                        }
                    }
                }

                if (!ketemu) {
                    System.out.println("Angka tidak ditemukan.");
                }

            } catch (Exception e) {
            System.out.println("Error: Masukkan angka bos!");
        } 
    }
}