public class MMain {
    public static void main(String[] args) {
        
        DompetDigital Van = new DompetDigital("Van", "111222");

        System.out.println("Pemilik: " + Van.getNamaPemilik());

        Van.setPin("112234", "11223");
        Van.setPin("111222", "112233");

        Van.setorTunai(20000);
        Van.setorTunai(-5000);

        Van.tarikTunai(5000, "112233");
        Van.tarikTunai(0, "123123");

        System.out.println("Sisa saldo: " + Van.getSaldo());
    }


}