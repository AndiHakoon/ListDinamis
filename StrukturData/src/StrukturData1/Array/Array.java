package StrukturData1.Array;

/**
 * Array soal 2
 */
public class Array {

    public static void main(String[] args) {
        int[] A = {7, 3, 6, 2, 5};
        int[] B = new int[A.length];

        for (int i = 0; i < A.length; i++) {
           if (i== 0 || i<A.length-1) B[i]=A[i]+A[i+1];
           if (i==A.length-1) B[i]=A[i]+A[0];
        }

        System.out.print("A :\t");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+"\t");
        }
        System.out.print("\nB :\t");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]+"\t");
        }
    }
}