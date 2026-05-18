package Soal1;

public class BangunDatar {

    public double luas() { return 0; }
    public double keliling() { return 0; }

    public static class Persegi extends BangunDatar {
        double s;
        public Persegi(double s){ 
            this.s = s; 
        }
        public double luas(){ 
            return s*s; 
        }
        public double keliling(){ 
            return 4*s; 
        }
    }

    public static class PersegiPanjang extends BangunDatar {
        double p,l;
        public PersegiPanjang(double p,double l){
            this.p=p; 
            this.l=l;
        }
        public double luas(){ 
            return p*l; 
        }
        public double keliling(){ 
            return 2*(p+l); 
        }
    }

    public static class Segitiga extends BangunDatar {
        double a,b,c,t;
        public Segitiga(double a,double b,double c,double t){
            this.a=a; 
            this.b=b; 
            this.c=c; 
            this.t=t;
        }
        public double luas(){ 
            return 0.5*a*t; 
        }
        public double keliling(){ 
            return a+b+c; 
        }
    }

    public static class Lingkaran extends BangunDatar {
        double r;
        public Lingkaran(double r){ 
            this.r=r; 
        }
        public double luas(){ 
            return Math.PI*r*r; 
        }
        public double keliling(){ 
            return 2*Math.PI*r; 
        }
    }

    public static class JajarGenjang extends BangunDatar {
        double a,t,sm;
        public JajarGenjang(double a,double t,double sm){
            this.a=a; 
            this.t=t; 
            this.sm=sm;
        }
        public double luas(){ 
            return a*t; 
        }
        public double keliling(){ 
            return 2*(a+sm); 
        }
    }

    public static class BelahKetupat extends BangunDatar {
        double d1,d2,s;
        public BelahKetupat(double d1,double d2,double s){
            this.d1=d1; 
            this.d2=d2; 
            this.s=s;
        }
        public double luas(){
            return 0.5*d1*d2; 
        }
        public double keliling(){
            return 4*s; 
        }
    }
}