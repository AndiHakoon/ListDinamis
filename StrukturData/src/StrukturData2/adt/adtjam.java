package adt;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 * Nama : Andi Irham Marhamuddin
 * Kelas : TRPL 1B
 * BP : 1911082006
 * Project : adtjam
 *
 *  Don't make copy without permission
 */

//deklarasi kelas jam 
class jam{
    //declarasi attribut
    private int HH; //Hour
    private int MM; //Minute
    private int SS; //Second

    //Validator
    public boolean isValid(final int hh, final int mm, final int ss) {
        if ((hh >= 0 && hh <= 23) && (mm >= 0 && mm <= 59) && (ss >= 0 && ss <= 59)) {
            return true;
        } else
            return false;
    }
    
    // membangun constructor : Membentuk komponen jam

    //membaca Jam 
    public jam(){
        HH = 0; MM = 0; SS=0;
    }
    public jam(final int hh, final int mm, final int ss) {
        if (isValid(hh, mm, ss)) {
            HH = hh;
            MM = mm;
            SS = ss;
        } else {
            System.err.println("Invalid Input. Hour reseted to 00:00:00");
            HH = 0;
            MM = 0;
            SS = 0;
        }
    }

    // getter and setter
    // Readonly method
    public int getHour() {
        return HH;
    }

    public int getMinute() {
        return MM;
    }

    public int getSecond() {
        return SS;
    }

    // Writeonly method
    public void setHour(final int HH) {
        this.HH = HH;
    }

    public void setMinute(final int MM) {
        this.MM = MM;
    }

    public void setSecond(final int SS) {
        this.SS = SS;
    }

    // Menampilkan Jam
    public void printJam() {
        System.out.print(HH + " : " + MM + " : " + SS + "\n");
    }

    // Konversi nilai jam
    public int jamToDetik() {
        int konv;
        konv = (HH * 3600) + (MM * 60) + SS;
        return konv;
    }

    public void detikToJam(final int ss) {
        HH = (ss / 3600) % 24;
        MM = (ss % 3600) / 60;
        SS = (ss % 3600) % 60;
    }

    // Perbandingan nilai jam
    public boolean isEquals(final jam J2) {
        if (this.HH == J2.HH && this.MM == J2.MM && this.SS == J2.SS) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNEquals(final jam J2) {
        final boolean x = (this.HH != J2.HH || this.MM != J2.MM || this.SS != J2.SS);
        if (x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean JLT(final jam J2) {
        int d1, d2;
        d1 = this.jamToDetik(); // memanggil method konversi detik
        d2 = J2.jamToDetik(); // memanggil method konversi detik
        if (d1 < d2) {
            return true;
        } else
            return false;
    }

    public boolean JGT(final jam J2) {
        int d1, d2;
        d1 = this.jamToDetik(); // memanggil method konversi detik
        d2 = J2.jamToDetik(); // memanggil method konversi detik
        if (d1 > d2) {
            return true;
        } else
            return false;
    }

    public void jPlus(final jam J3, final jam J2) {
        int a, b, c;

        a = this.jamToDetik();
        b = J2.jamToDetik();
        c = a + b;
        J3.detikToJam(c);
    }

    public void jMinus(final jam J3, final jam J2) {
        int a, b, c;
        a = this.jamToDetik();
        b = J2.jamToDetik();
        if (a <= b) {
            c = -(a - b);
        } else {
            c = 0;
        }
        J3.detikToJam(c);
    }

    public void nextDetik() {
        int a;
        a = this.jamToDetik() + 1;
        this.detikToJam(a);
    }

    public void nextDetik(final int N) {
        int a;
        a = this.jamToDetik() + N;
        this.detikToJam(a);
    }

    public void prevDetik() {
        int a;
        a = this.jamToDetik() - 1;
        this.detikToJam(a);
    }

    public void prevDetik(final int N) {
        int a;
        a = this.jamToDetik() - N;
        this.detikToJam(a);
    }

    public int durasi(final jam jAw, final jam jAk) {
        return jAk.jamToDetik() - jAw.jamToDetik();
    }
}

// Main Class
public class adtjam {
    //membuat input method
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    // Membuat pemmimpan objek dengan ArrayList()
    ArrayList<jam> tampung;

    public adtjam() {
        // instansiasi
        tampung = new ArrayList<jam>();
    }

    public void isiData(final int hh, final int mm, final int ss) {
        tampung.add(new jam(hh, mm, ss));
    }

    public void showData() {
        for (final jam Jam : tampung) {
            System.out.println(
                    " = Jam : Menit : detik --> " + Jam.getHour() + ":" + Jam.getMinute() + ":" + Jam.getSecond());
        }
    }

    static void menu(){
        int a=0, i=0;
        System.out.println(
            "\n++++++++++++++++++++++++++++++++++ \n"+
            "\n|            ADT JAM             |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n| Menu :                         |\n"+
            "\n|------                          |\n"+
            "\n| 1. Lihat/Konversi Jam          |\n"+
            "\n| 2. Konversi Jam                |\n"+
            "\n| 3. Operasi Matematika pada jam |\n"+
            "\n| 4. Keluar                      |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"
            );
            try {
                System.out.println("Masukkan pilian Anda.");
                i = Integer.parseInt(in.readLine());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }    
            while (a != 1) {
            switch (i) {
                case 1:
                    editJam();
                    break;
                
                case 2:
                    konvJam();
                    break;
                
                case 3:
                    opJam();
                    break;

                default:
                    System.out.println("input anda salah, coba lagi");
                    a++;
                }
            }
    }
    static void editJam(){
        int i=0;
        System.out.println(
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n|         Baca/Tulis Jam         |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n| Menu :                         |\n"+
            "\n|------                          |\n"+
            "\n| 1. Tambah Jam                  |\n"+
            "\n| 2. Baca Jam                    |\n"+
            "\n| 3. kembali                     |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"
            );

            try {
                System.out.println("Masukkan pilian Anda.");
                i = Integer.parseInt(in.readLine());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
    
            switch (i) {
                case 1:
    
                    break;
                
                case 2:
    
                    break;
                case 3:
                    menu();
                default:
                    System.err.println("Input anda salah");
                    editJam();
            }
    }

    static void konvJam(){
        int i=0;
        System.out.println(
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n|         Baca/Tulis Jam         |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n| Menu :                         |\n"+
            "\n|------                          |\n"+
            "\n| 1. Tambah Jam                  |\n"+
            "\n| 2. Baca Jam                    |\n"+
            "\n| 3. kembali                     |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"
            );

            try {
                System.out.println("Masukkan pilian Anda.");
                i = Integer.parseInt(in.readLine());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
    
            switch (i) {
                case 1:
    
                    break;
                
                case 2:
    
                    break;
                case 3:
                    menu();
                default:
                    System.err.println("Input anda salah");
                    editJam();
            }
    }
    static void opJam(){
        int i=0;
        System.out.println(
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n|         Baca/Tulis Jam         |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"+
            "\n| Menu :                         |\n"+
            "\n|------                          |\n"+
            "\n| 1. Tambah Jam                  |\n"+
            "\n| 2. Baca Jam                    |\n"+
            "\n| 3. kembali                     |\n"+
            "\n++++++++++++++++++++++++++++++++++\n"
            );

            try {
                System.out.println("Masukkan pilian Anda.");
                i = Integer.parseInt(in.readLine());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
    
            switch (i) {
                case 1:
    
                    break;
                
                case 2:
    
                    break;
                case 3:
                    menu();
                default:
                    System.err.println("Input anda salah");
                    editJam();
            }
    }
    // deklarasi main program
    public static void main(final String[] args) {
       // menu();
        adtjam adtJ = new adtjam();
 
        adtJ.isiData(11,59,50);
        adtJ.isiData(2,02,30);
 
        adtJ.showData();
        //Mambuat Objek dari jam
        //jam J1 = new jam(9,00,0);
        //jam J2 = new jam(3,00,00);
        //jam J3 = new jam();


        /*
        //Print
        System.out.println("Jam J1 = ");J1.printJam();
        System.out.println("Jam J2 = ");J2.printJam();
        
        // Manipulasi Objek
        System.out.println("getHour J1 = ");System.out.println(J1.getHour());
        System.out.println("gethour J2 = ");System.out.println(J2.getHour());
        
        //J1.setHour(1); //Menyetel jam ke 10
        //System.out.println("Jam J1 (baru) = ");J1.printJam();
        //J1.detikToJam(36600); //Mengubah detik ke jam (perintah mengubah isi dari objek)
        //System.out.print("Jam J1 (36600) = ");J1.printJam();
        System.out.print("Konversi J2 ke detik = ");System.out.println(J2.jamToDetik());
        
        //perbandingan objek
        System.out.print("J1 == J2? ");System.out.println(J1.isEquals(J2)); 
        System.out.print("J1 != J2? ");System.out.println(J1.isNEquals(J2));  
        System.out.print("J1 > J2? ");System.out.println(J1.JLT(J2));
        System.out.print("J1 < J2? ");System.out.println(J1.JGT(J2));
        
        //opoerasi aritamatika objek
        System.out.println("J1 + J2 =");J1.jPlus(J3, J2); J3.printJam();
        System.out.println("J1 - J2 = ");J1.jMinus(J3, J2); J3.printJam();
        System.out.println("J2 + 5 second = ");J2.nextDetik(5); J2.printJam();
        System.out.println("J2 - 1 sec = ");J2.prevDetik();J2.printJam();
        System.out.print("Durasi J1 ke J2 ");System.out.println((J2.durasi(J1, J2)+" detik"));
        */
    }
}