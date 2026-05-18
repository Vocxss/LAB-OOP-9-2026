package Soal1;

public class BangunRuang {

    public double volume(){ 
        return 0; 
    }
    public double luasPermukaan(){
        return 0; 
    }

    // ===== SUBCLASS =====
    public static class Kubus extends BangunRuang {
        double s;
        public Kubus(double s){ 
            this.s=s; 
        }
        public double volume(){ 
            return s*s*s; 
        }
        public double luasPermukaan(){ 
            return 6*s*s; 
        }
    }

    public static class Balok extends BangunRuang {
        double p,l,t;
        public Balok(double p,double l,double t){
            this.p=p; 
            this.l=l; 
            this.t=t;
        }
        public double volume(){ 
            return p*l*t; 
        }
        public double luasPermukaan(){ 
            return 2*(p*l+p*t+l*t); 
        }
    }

    public static class Prisma extends BangunRuang {
        double luasAlas, tinggi;
        public Prisma(double luasAlas,double tinggi){
            this.luasAlas=luasAlas; 
            this.tinggi=tinggi;
        }
        public double volume(){ 
            return luasAlas*tinggi; 
        }
    }

    public static class Tabung extends BangunRuang {
        double r,t;
        public Tabung(double r,double t){ 
            this.r=r; this.t=t; 
        }
        public double volume(){ 
            return Math.PI*r*r*t; 
        }
        public double luasPermukaan(){ 
            return 2*Math.PI*r*(r+t); 
        }
    }

    public static class Kerucut extends BangunRuang {
        double r,t,s;
        public Kerucut(double r,double t,double s){
            this.r=r; this.t=t; this.s=s;
        }
        public double volume(){ 
            return (1.0/3)*Math.PI*r*r*t; 
        }
        public double luasPermukaan(){ 
            return Math.PI*r*(r+s); 
        }
    }

    public static class Bola extends BangunRuang {
        double r;
        public Bola(double r){ 
            this.r=r; 
        }
        public double volume(){ 
            return (4.0/3.0)*Math.PI*r*r*r; 
        }
        public double luasPermukaan(){ 
            return 4*Math.PI*r*r; 
        }
    }
}