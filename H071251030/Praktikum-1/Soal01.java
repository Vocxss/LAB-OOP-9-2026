import java.util.Scanner ;

public class Soal01 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Kalimat: ");
        String kalimat = input.nextLine();

        String[] kata = kalimat.split(" ");

        for(int i=0 ; i<kata.length; i++)  {

            String hurufPertama = kata[i].substring(0,1).toUpperCase();
            String sisa = kata[i].substring(1).toLowerCase();


            System.out.print(hurufPertama + sisa + " ");
        }

    }
}
