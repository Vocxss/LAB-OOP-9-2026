import java.util.Scanner;

public class TP1_5_H071251081 {
    public static void main(String[] args) {
        Scanner var = new Scanner(System.in);
        int[][] nums = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        };
        try {
            System.out.println("Input :");
            int cari = var.nextInt();

            boolean ditemukan = false;

            search:
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        
                        break search; 
                    }
                }
            }

            if (!ditemukan) {
                System.out.println("Angka tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Error: Input harus berupa angka!");
        } finally {
            var.close();
        }
    }
}
