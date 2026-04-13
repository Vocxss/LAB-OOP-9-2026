class PerangkatElektronik {
    String namaPerangkat;
    int konsumsiDaya; 

    public PerangkatElektronik(String nama, int daya) {
        this.namaPerangkat = nama;
        this.konsumsiDaya = daya;
    }

    public void tampilkanInfo() {
        System.out.println(namaPerangkat + " dengan konsumsi daya " + konsumsiDaya + "W");
    }
}
