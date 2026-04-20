public class soalbaru {
    public static void main(String[] args) {
        ACSmart ac = new ACSmart("Panasonic") ;
        System.out.println("MERK : " + ac.getMerk()) ; 
        ac.nyalakan();
        ac.matikan();
    }
}
   

class ACSmart {
    private String merk;
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    private boolean statusMenyala;
    public boolean isStatusMenyala() {
        return statusMenyala;
    }

    public void setStatusMenyala(boolean statusMenyala) {
        this.statusMenyala = statusMenyala;
    }

    public void nyalakan() {
        if (! statusMenyala) {
            statusMenyala = true;
        System.out.println("SUDAH DINYALAKAN");
        } else {
        System.out.println("MEMANG SUDAH MENYALA");
        }
    }

    public void matikan() {
        if (statusMenyala) {
            statusMenyala = false;
        System.out.println("LAMPU MATI");
        } else {
        System.out.println("Lampu menyala kak");}
    }

    private int suhu;

    public int getSuhu() {
        return suhu;
    }

    public void setSuhu(int suhu) {
        this.suhu = suhu;
    }

    public ACSmart (String merk) {
        this.merk = merk;
        this.statusMenyala = false;
        this.suhu = 24;
    }

    
}

 

