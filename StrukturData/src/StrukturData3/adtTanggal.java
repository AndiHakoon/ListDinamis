/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata3;

import java.util.Scanner;

/**
 *  subjek Tugas Pratikum StrukDat TRPL 1B;
 * @author Andi
 */
class tanggal{
    // *** Definisi dan Spesifikasi Tanggal ***
    private int DD, MM, YY;
    
    // *** Definisi dan Spesifikasi Selektor ***
    // *** Selektor GET ***
    public int getDD() {
        return DD;
    }
    public int getMM() {
        return MM;
    }
    public int getYY() {
        return YY;
    }
    public void setDD(int DD) {
        this.DD = DD;
    }
    public void setMM(int MM) {
        this.MM = MM;
    }
    public void setYY(int YY) {
        this.YY = YY;
    }
    public boolean isValid(final int DD, final int MM, final int YY){
        if(DD>=1 && DD<=31 && (MM==1 || MM==3 || MM==5 || MM==7 || MM==10 || MM==12) && YY>=11)
            return true;
        else if(DD>=1 && DD<=30 && (MM==4 || MM==6 || MM==9 || MM==11) && YY>=11)
            return true;
        else if(DD>=1 && DD<=29 && IsKabisat(YY) && MM==2)
            return true;
        else return DD>=1 && DD<=28 && MM==2 && IsKabisat(YY)==false;
    }
    
    // *** Definisi dan Spesifikasi Konstruktor ***
    tanggal MakeTanggal(int D, int M, int Y){
        return new tanggal(D,M,Y);
    }
    public tanggal(){
        DD = 0; MM = 0; YY = 0;
    }
    public tanggal(int D, int M, int Y){
        if (isValid(D, M, Y)) {
            DD = D;MM = M;YY = Y;
        } else {
            System.err.println("ERROR, TANGGAL RESETED TO 00-00-00");
            DD = 0;MM = 0;YY = 0;
        }
    }
    
    // *** Definisi dan Spesifikasi Operator BACA / TULIS ***
    public void BacaTANGGAL(){
        Scanner in = new Scanner(System.in);
        int a,b,c;
        System.out.print("Masukkan Hari  =");a=in.nextInt(); 
        System.out.print("Masukkan Bulan =");b=in.nextInt(); 
        System.out.print("Masukkan Tahun =");c=in.nextInt();
        MakeTanggal(a,b,c);
    }
    public void TulisTANGGAL(){
        System.out.println(this.getDD()+"-"+this.getMM()+"-"+this.getYY());
    }
    
    // *** Definisi dan Spesifikasi Operator / Fungsi lain terhadap TANGGAL ***
    public tanggal PrevDay(){
        if(isValid(DD, MM, YY))
        {
            if(DD==1 && (MM==5 || MM==7 || MM==8 || MM==10 || MM==12))
            {
                DD=30;
                MM-=1;       
            }
            else if(DD==1 && (MM==2 || MM==4 || MM==6 || MM==9 || MM==11))
            {
                DD=31;
                MM-=1;
            }
            else if(DD==1 && MM==3 && IsKabisat(YY))
            {
                DD=29;
                MM=2;
            }
            else if(DD==1 && MM==3 && IsKabisat(YY)==false)
            {
                DD=28;
                MM=2;
            }
            else if (DD==1 && MM==1) 
            {
                DD=31;
                MM=12;
                YY-=1;
            }
            else 
                DD-=1;
            }
                return new tanggal(DD,MM,YY);
    }
    public tanggal NextDay(){
            if(isValid(DD, MM, YY))
        {
            if(DD==31 && (MM==1 || MM==3 || MM==5 || MM==7 || MM==8 || MM==10))
            {
                this.DD=1;
                this.MM+=1;       
            }
            else if(DD==30 && (MM==4 || MM==6 || MM==9 || MM==11))
            {
                this.DD=1;
                this.MM+=1;
            }
            else if(DD==29 && MM==2 && IsKabisat(YY))
            {
                this.DD=1;
                this.MM=3;
            }
            else if(DD==29 && MM==2 && IsKabisat(YY)==false)
            {
                this.DD=1;
                this.MM=3;
            }
            else if (DD==31 && MM==12) 
            {
                this.DD=1;
                this.MM=1;
            }
            else 
                this.DD+=1;
            }
                return new tanggal(DD,MM,YY);
    }
    public tanggal NextNday(int N){
        int H;
        H = this.HariKe()+N;
        return DayOfYear(H, this.getYY());
    }
    public tanggal PrevNday(int N){
        int H;
        H = this.HariKe()+N;
        return DayOfYear(H, this.getYY());
    }
    public int HariKe(){
        int i, x=0, sum, sum1=0, sum2=0, sum3=0, sum4=0;
        for (i=1;i<this.MM;i++) {
            if (i==1||i==3||i==5||i==7||i==8||i==10||i==12) 
                x++;
        }
            sum1=x*31;
            x=0;
        for (i = 1; i < this.MM; i++) {
            if (i==1||i==3||i==5|i==7||i==8||i==10||i==12)
            x++;
        }
        sum2=x*30;
        x=0;
        for (i = 0; i < this.MM; i++) {
            if (i==2 && IsKabisat(this.YY)==true) {
                x++;
            }
        }
        sum3=x*29;
        x=0;
        for (i = 0; i < this.MM; i++) {
            if (i==2 && IsKabisat(this.YY)==false) {
                x++;
            }
        }
        sum4=x*28;
        sum=this.DD+sum1+sum2+sum3+sum4;
        return sum;
    }
    public tanggal DayOfYear(int H, int Y){
        if (H>=1 && H<=366 && IsKabisat(this.YY))
        {
        if(H<=31){this.DD=H; this.MM=1;}
        else if (H>60 && H<=91 ) {this.DD=H-60; this.MM=3; this.YY=Y;}
        else if (H>91 && H<=121) {this.DD=H-91; this.MM=4; this.YY=Y;}
        else if (H>121&& H<=152) {this.DD=H-121; this.MM=5; this.YY=Y;}
        else if (H>152&& H<=182) {this.DD=H-152; this.MM=6; this.YY=Y;}
        else if (H>182&& H<=213) {this.DD=H-182; this.MM=7; this.YY=Y;}
        else if (H>213&& H<=244) {this.DD=H-213; this.MM=8; this.YY=Y;}
        else if (H>244&& H<=274) {this.DD=H-244; this.MM=9; this.YY=Y;}
        else if (H>274&& H<=305) {this.DD=H-274; this.MM=10;this.YY=Y;}
        else if (H>305&& H<=335) {this.DD=H-305; this.MM=11;this.YY=Y;}
        else {this.DD=H-335; this.MM=12; this.YY=Y;}
        }
        
        if(H>=1&&H<=365&&IsKabisat(this.YY)==false)
        {
         if(H<=31) {this.DD=H; this.MM=1; }
         else if (H>31&&H<=59) {this.DD=H-31; this.MM=2; this.YY=Y;}
         else if (H>59&&H<=90) {this.DD=H-59; this.MM=3; this.YY=Y;}
         else if (H>90&&H<=120) {this.DD=H-90; this.MM=4; this.YY=Y;}
         else if (H>120&&H<=151) {this.DD=H-120; this.MM=5; this.YY=Y;}
         else if (H>151&&H<=181) {this.DD=H-151; this.MM=6;this.YY=Y; }
         else if (H>181&&H<=212) {this.DD=H-181; this.MM=7;this.YY=Y; }
         else if (H>212&&H<=243) {this.DD=H-212; this.MM=8;this.YY=Y; }
         else if (H>243&&H<=273) {this.DD=H-243; this.MM=9; this.YY=Y;}
         else if (H>273&&H<=304) {this.DD=H-273; this.MM=10;this.YY=Y; }
         else if (H>304&&H<=334) {this.DD=H-304; this.MM=11;this.YY=Y; }
         else {this.DD=H-334; this.MM=12; this.YY=Y;}
    }
     return new tanggal(DD,MM,YY);
    }
    
    // *** Definisi dan Spesifikasi Predikat ***
    public boolean IsEqD(tanggal T2){
        return(this.DD==T2.DD && this.MM==T2.MM && this.YY==T2.YY);
    }
    public boolean IsBefore(tanggal T2){
        if(this.YY<T2.YY) return true;
        else if(this.YY==T2.YY && this.MM<T2.MM) return true;
        else if(this.YY==T2.YY && this.MM==T2.MM && this.DD<T2.DD) return true;
        else return false;
    }
    public boolean IsAfter(tanggal T2){
        if(this.YY>T2.YY) return true;
        else if(this.YY==T2.YY && this.MM>T2.MM) return true;
        else return this.YY==T2.YY && this.MM==T2.MM && this.DD>T2.DD;
    }
    public boolean IsKabisat(int Y){
        if(Y%100==0)
        {
            return Y%400==0;
        }
        else return Y%4==0;
    }
    public boolean IsKabisat(){
        if(this.YY%100==0)
        {
            return this.YY%400==0;
        }
        else return this.YY%4==0;
    }
}

public class adtTanggal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tanggal t1 = new tanggal(12,12,2020);
        tanggal t2 = new tanggal(23, 10, 2022);
        
        System.out.print("Tanggal pertama : ");t1.TulisTANGGAL();
        System.out.print("Tanggal kedua : ");t2.TulisTANGGAL();
        
        System.out.print("t1 NextDay     = ");t1.NextDay();t1.TulisTANGGAL();
        System.out.print("t2 Next 10 day = ");t2.NextNday(10);t2.TulisTANGGAL();
        System.out.print("t2 PrevDay     = ");t2.PrevDay();t2.TulisTANGGAL();
        System.out.print("t1 Prev 15 day = ");t1.PrevNday(15);t1.TulisTANGGAL();
        
        System.out.print("t1 ini adalah hari ke berapa dari 1 Januari = ");System.out.println(t1.HariKe());
        
        System.out.println("t1 == t2?"+t1.IsEqD(t2));
        System.out.println("t1 < t2? "+t1.IsBefore(t2));
        System.out.println("t1 > t2? "+t1.IsAfter(t2));
        System.out.println("t1 adalah kabisat? "+t1.IsKabisat());
        
        
    } 
}
