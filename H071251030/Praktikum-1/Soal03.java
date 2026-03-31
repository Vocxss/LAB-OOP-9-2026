import java.util.Scanner;

public class Soal03 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan password: ");
        String password = input.nextLine();

        boolean adaBesar = false;
        boolean adaKecil = false;
        boolean adaAngka = false;

        if(password.length() >=8 ) {

            for(int i=0; i<password.length(); i++ ) {

                char c = password.charAt(i);

                if(Character.isUpperCase(c))
                adaBesar = true;
                
                if(Character.isLowerCase(c))
                adaKecil = true;

                if(Character.isDigit(c))
                adaAngka = true;

            }

            if(adaBesar && adaKecil && adaAngka)
            System.out.println("Password Valid");
            else
            System.out.println("Password Tidak Valid");
            

        } else {
            System.out.println("Password Tidak Valid"); 
        
        }

    }





















}












