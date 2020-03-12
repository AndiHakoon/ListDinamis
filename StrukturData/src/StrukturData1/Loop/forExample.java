package perulangan;

import java.util.Scanner;

/**
 * forExample
 */
public class forExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nilaiAwal= 0, nilaiAkhir=0; 
        System.out.print("Masukkan nilai Awal :");
        nilaiAwal = in.nextInt();
        System.out.print("Masukkan nilai Akhir :");
        nilaiAkhir = in.nextInt();

        for (int i = nilaiAwal; i < nilaiAkhir; i++) {
            if (i%2!=0) {
                System.out.println(i);
            }
        }
        in.close();
    }
}