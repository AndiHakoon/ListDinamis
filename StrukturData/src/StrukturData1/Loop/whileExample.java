package perulangan;

import java.util.Scanner;

/**
 * whileExample
 */
public class whileExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nilaiAwal= 0, nilaiAkhir=0, i; 
        System.out.print("Masukkan nilai Awal :");
        nilaiAwal = in.nextInt();
        i = nilaiAwal;
        System.out.print("Masukkan nilai Akhir :");
        nilaiAkhir = in.nextInt();

        if (nilaiAwal<nilaiAkhir) {
        while (i<nilaiAkhir) {
            if (i%2!=0) {
                System.out.println(i);
            }
            i++;
        }
        }else{
            System.out.println("input Anda Salah! (nilaiAkhir>nilaiAwal)");
        }
        in.close();
    }
}