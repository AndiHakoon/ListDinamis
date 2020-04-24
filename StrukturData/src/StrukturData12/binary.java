
import java.util.Random;

public class binary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int N = 5;
    int A [] = {5,6,77,88,99};//new int[N];
       // for (int i = 0; i < N; i++) {
       //     A[i] = new Random().nextInt(10+1);
       // }
        
        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    int BatasAtas, BatasBawah, Tengah;
    int cari = 5;
    BatasAtas = 0;
    BatasBawah = N - 1;
    Tengah = 0;
    boolean ketemu;
    ketemu = false;
   
    while((BatasAtas <= BatasBawah) && (ketemu == false)){
       
        Tengah = (BatasAtas + BatasBawah) / 2;
        System.out.println("Tengah ="+Tengah);
        if (A[Tengah] == cari){
            ketemu = true;
        } else
            if (A[Tengah] <= cari){
            BatasAtas = Tengah + 1;
                System.out.println("Ba"+BatasAtas);
        } else {
            BatasBawah = Tengah - 1;
                System.out.println("BB"+BatasBawah);
        }
        }
    if (ketemu) {
        System.out.println ("Angka : "+ cari + "Data berada di index nomor " + Tengah);
    } else {
        System.out.println ("Angka :" + cari + "Data tidak ditemukan");
    }}
}