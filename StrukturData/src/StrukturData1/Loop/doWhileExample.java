package perulangan;

import java.util.Scanner;

/**
 * doWhileExample
 */
public class doWhileExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nilaiAwal= 0, nilaiAkhir=0, i=0; 
        System.out.print("Masukkan nilai Awal :");
        nilaiAwal = in.nextInt();
        i = nilaiAwal;
        System.out.print("Masukkan nilai Akhir :");
        nilaiAkhir = in.nextInt();

        do {
            if (i%2!=0) {
                System.out.println(i);
            }
            i++;
        } while (i<nilaiAkhir);

        in.close();
    }
}