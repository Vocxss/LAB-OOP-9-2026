public class Main {
    public static void main(String[] args) {
    RekeningBank rekening1 = new RekeningBank("12345", "Asep");
    rekening1.getInfo();
    rekening1.setorUang(20000.00);      
        rekening1.getInfo(); 
    rekening1.tarikUang(10000.00);        
    rekening1.getInfo();
}
}
