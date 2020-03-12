package StrukturData1.Array;

import java.util.Random;
import java.util.Scanner;

/**
 * Array2
 */
public class Array2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Baris = "); int baris = in.nextInt();
        System.out.print("Masukkan Kolom = "); int kolom = in.nextInt();
        int A[][] = new int[baris][kolom];
        int max=0, imax=0, jmax=0, min=100, imin=0, jmin=0; 

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {

                //pengisian rand
                A[i][j]=new Random().nextInt(100+1);

                if (A[i][j]<min) {
                    imin = i+1;
                    jmin = j+1;
                    min = A[i][j];
                }
                if (A[i][j]>=max) {
                    imax = i+1;
                    jmax = j+1;
                    max = A[i][j];
                }
            }
        }

        //menampilkan Array 
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }

        //menampilkan max min
        System.out.println("Nilai terbesar = "+max+" di baris "+imax+", dan kolom "+jmax);
        System.out.println("Nilai terkecil = "+min+" di baris "+imin+", dan kolom "+jmin);
        in.close();
    }
}