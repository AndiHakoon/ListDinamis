package adt.adtpoint;


/**
 * adtpoin
 */
class point{
    //Definisi ABSTRACT DATA TYPE POINT
    private int X; //absyss
    private int Y; //ordinate
    
    //Constructor pembentuk POINT
    public point(){
        X = 0; Y = 0;
    }
    public point(int x, int y){
        X = x; Y = y; 
    }

    //Getter and Setter
    public int getAbsys(){
        return X;
    }
    public int getOrdinate(){
        return Y;
    }
    public void setAbsys(int X){
        this.X = X;
    }
    public void setOrdinate(int Y){
        this.Y = Y;
    }

    //tulis point
    public void tulisPoint(){
        System.out.print("{"+this.X+","+this.Y+"}\n");
    }

    //Kelompok Operasi
    //penjulmahan
    public point plus(point P2){
        int a, b;
        a = this.X+P2.X;
        b = this.Y+P2.Y;
        return new point(a,b);
    }
    //pengurangan
    public point minus(point P2){
        int a, b;
        a = this.X-P2.X;
        b = this.Y-P2.Y;
        return new point(a,b);
    }
    
    //dot product
    public point dotProduct(point P2){
        int a, b;
        a = this.X*P2.X;
        b = this.Y*P2.Y;
        return new point(a,b);
    }

    //cross product
    public point crossProduct(point P2){
        int a, b;
        a = this.X*P2.Y;
        b = this.Y*P2.X;
        return new point(a,b);
    }

    //operasi relational terhadap POINT
    public boolean EQ(point P2){
        if (this.X==P2.X && this.Y==P2.Y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean NEQ(point P2){
        if (this.X!=P2.X || this.Y!=P2.Y){
            return true;
        } else {
            return false;
        }
    }

    public boolean kurangDari(point P2){
        if ((this.X<P2.X) && (this.Y< P2.Y)) {
            return true;
        } else{
            return false;
        }
    }

    public boolean lebihDari(point P2){
        if ((this.X>P2.X) && (this.Y>P2.Y)) {
            return true;
        } else{
            return false;
        }
    }

    //Kelompok menentukan dimana P berada
    public boolean isOrigin(){
        if (this.X==0 && this.Y==0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOnSbX(){
        if (this.Y==0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOnSbY(){
        if (this.X==0) {
            return true;
        } else {
            return false;
        }
    }

    public int kuadran(){
        if (this.X!=0 || this.Y!=0) {
            if (this.X>0 && this.Y>0) {
                return 1;
            }else if (this.X<0 && this.Y>0) {
                return 2;
            } else if (this.X<0 && this.Y<0) {
                return 3;
            } else { //this.X>0 && this.Y<0
                return 4;
            }
        } else {
            System.out.println("Input anda Salah! (Kuadran = 0)");
            return 0;
        }
    }

    //kelompok operasi lain terhadap point
    public point nextX(){
        return new point(this.X+= 1,this.Y);
    }

    public point nextY(){
        return new point(this.X,this.Y+=1);
    }

    public point plusDelta(int deltaX, int deltaY){
        this.X += deltaX;
        this.Y += deltaY;
        return new point(this.X, this.Y);
    }

    public point mirrorOf(boolean sbX, boolean sbY){
        if (sbX==true) {
            this.X*=-1;
        }
        if (sbY==true) {
            this.Y*=-1;   
        }
        return new point(this.X, this.Y);
    }

    //menghitung jarak titik ke pusat
    //       ____________ 
    // = _  /  x^2 + y^2
    //    \/  
    public double jarakCentral(){
        double b;
        b = (this.X-0)^2 + (this.Y-0);
        return (Math.sqrt(b));
    }

    //panjang vektor
    public double panjang(point P2){
        double b;
        b = (int)((this.X-P2.X)^2 + (this.Y-P2.Y));
        return b;
    }

    //point di geser ke /\X dan /\Y
    public void geser(int deltaX, int deltaY){
        this.X += deltaX;
        this.Y += deltaY;
    }

    // geser ke sumbu X
    // attribut X digeser ke X = 0
    // contoh : {9,9} --> {9,0}
    public void geserKeSbX(){
        this.X = 0;
    }
    
    // geser ke sumbu Y
    // attribut Y point digeser ke Y = 0
    public void geserKeSbY(){
        this.Y = 0;
    }

    //prosedur mirror terhadap sumbu tertentu.
    // garis x = k --> (x',y') = (2k-x,y)
    // garis y = l --> (x',y') = (x,2h-y)
    public void  mirrorOn(int m, boolean sbX, boolean sbY){
        int a, b;
            a = this.X;
            b = this.Y;
        if(sbX ^ sbY == true){
            if(sbX==true){
            a = 2*m-a;
            }else if(sbY==true){
            b = 2*m-b;
            }
            this.X = a;
            this.Y = b;
        } else{
            System.err.println("Gagal, sumbu X atau Y?");
        }
    }
    
    //prosedur putar
    // x' = x.cos(sudut) - y.sin(sudut)
    // y' = x.sin(sudut) - y.sin(sudut)
    public void putar(double sudut){
        //int a, b;
        double deg = Math.toRadians(sudut);
        double a,b;
        a = this.X; b = this.Y;
        a = (int)((a*Math.cos(deg))+(-b*Math.sin(deg)));
        b = (int)((a*Math.sin(deg))+(-b*Math.cos(deg)));     
        System.out.format("{%.0f,%.0f}%n",a,b);
    }
}

public class adtpoin {
    public static void main(String[] args) {
        point P1 = new point(2,3);
        point P2 = new point(4,3);
        
        //Kelompok operasi
        // instansiasi operator
        point plus = P1.plus(P2);
        point minus = P1.minus(P2);
        point dot = P1.dotProduct(P2);
        point cross = P1.crossProduct(P2);
        System.out.print("P1 = ");P1.tulisPoint();
        System.out.print("P2 = ");P2.tulisPoint();
        System.out.print("\nP1 + P2 = ");plus.tulisPoint();
        System.out.print("P1 - P2 = ");minus.tulisPoint();
        System.out.print("P1 . P2 = ");dot.tulisPoint();
        System.out.print("P1 x P2 = ");cross.tulisPoint();

        //instansiasi pembanding
        System.out.println("P1 == P2? "+P1.EQ(P2));
        System.out.println("P1 != P2? "+P1.NEQ(P2));
        System.out.println("P1 > P2 ? "+P1.lebihDari(P2));
        System.out.println("P1 < P2 ? "+P1.kurangDari(P2));

        //menentukan P dimana
        System.out.println("P1 di pusat ? "+P1.isOrigin());
        System.out.println("P2 di pusat ? "+P2.isOrigin());
        System.out.println("P1 di sumbu x ? "+P1.isOnSbX());
        System.out.println("P1 di sumbu y ? "+P1.isOnSbY());
        
        //kelompok lain terhadap type
        //instansiasi operator
        point nextX = P2.nextX();
        point nextY = P1.nextY();
        point plusDelta = P1.plusDelta(9, 8); //digeser sebesar 9,8
        point MirrorOf = P2.mirrorOf(true, true); //dicerminkan terhadap sumbuX
         
        System.out.println("P2 nextX = ");nextX.tulisPoint();
        System.out.println("P1 nextY = ");nextY.tulisPoint();
        System.out.println("\nP1 plus delta (9,8) = ");plusDelta.tulisPoint();
        System.out.println();
        System.out.println("P2 di mirror terhadap sb x dan y ");MirrorOf.tulisPoint();
        
        System.out.println("\nP1 di kuadran "+P1.kuadran());
        System.out.println("P1 Ke pusat = ");System.out.format("%.3f\n",P1.jarakCentral());
        System.out.print("P1 diputar sejauh 180 derajat = ");P1.putar(180);//P1.tulisPoint();
        System.out.println("P1 Mirror dengan x=2 ");P1.mirrorOn(2, true, false);P1.tulisPoint();
        System.out.print("\nP1 digeser ke X ");P1.geserKeSbX();P1.tulisPoint();
        System.out.println();

    }
}