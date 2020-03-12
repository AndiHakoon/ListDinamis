package StrukturData2.adt.adetejam;
/**
 *
 * Nama : Adio Ihsan
 * BP   : 1911081023
 */
import java.util.Scanner;
public class adtjamDio 
{
    private int hour;
    private int minute;
    private int second;
    
    static Scanner sc = new Scanner(System.in);
    
    //Cek Apakah format jam sudah sesuai
   public static boolean IsValid (int hour,int minute ,int second)
    {
        return !(hour > 23 || hour < 0 || minute > 59 ||
                minute < 0 || second > 59 || second< 0);
    }
   
   // Constructor jam
   public adtjamDio(int hour,int minute,int second)
   {
      if(IsValid(hour,minute,second))
      { 
          this.hour = hour;this.minute=minute;this.second=second;
      }
      else
      { 
          this.hour = 0; this.minute=0 ;this.second=0;
      }
   }
   public adtjamDio(){};
   
    // Selektor Get and Set
   
   public  int getHour()
   {
       return this.hour;
   }
   
   public int getMinute()
   {
       return this.minute;
   }
   public int getSecond()
   {
       return this.second;
   }
   
   public void setHour(int hour)
   {
       this.hour = hour;
   }
   public void setMinute(int minute)
   {
       this.minute = minute;
   }
   public void setSecond(int second)
   {
       this.second = second;
   }
   
   // end getter setter
   
   //Baca dan Tulis jam
   
   public String BacaJam()
   {
       return (this.getHour()+" : "+this.getMinute()+" : "+this.getSecond());
   }
   
   public void TulisJam(int jam,int menit,int detik)
   {
      if(IsValid(jam,menit,detik))
      { 
          this.hour = jam;this.minute=menit;this.second=detik;
      }
      else
      {
          System.err.println("Jam Tidak Valid !");
      }
   }
   
   // end Baca dan Tulis jam
   
   //Kelompok KOnversi Terhadap Type
   
   public int JamToDetik ()
   {
       return this.hour*3600+this.minute*60+this.second;
   }
   
   public adtjamDio DetikToJam(int second)
   {
       int newHour,newMinute,newSecond;
       newHour = second/3600;
       newMinute = (second%3600)/60;
       newSecond = (second%3600)%60;
       if(newHour>23) newHour = (newHour%23)-1;
       
      return new adtjamDio(newHour,newMinute,newSecond);
   }

  //End Kelompok konversi Terhadap Type
   
   //Kelompok operasi terhadap Type
   public boolean JEQ(adtjamDio J)
   {
       return (this.JamToDetik()==J.JamToDetik());
   }
   public boolean JNEQ(adtjamDio J)
   {
       return !(this.JamToDetik()==J.JamToDetik());
   }
   public boolean JLT(adtjamDio J)
   {
       return (this.JamToDetik()< J.JamToDetik());
   }
   public boolean JGT(adtjamDio J)
   {
       return (this.JamToDetik()>J.JamToDetik());
   }
   // end kelompok operator terhadap type
   
   //Operarator aritmatika
   
   public adtjamDio JPlus(adtjamDio J)
   {
       int secTotal = this.JamToDetik()+J.JamToDetik();
       return DetikToJam(secTotal);
   }
   
   public adtjamDio JMinus(adtjamDio J)
   {
      if((this.JamToDetik()-J.JamToDetik())< 0 )
      {
      return DetikToJam(-(this.JamToDetik()-J.JamToDetik()));
      }
      else
      return DetikToJam(this.JamToDetik()-J.JamToDetik());
//       if(this.JamToDetik()>= J.JamToDetik())
//       {
//           return DetikToJam(this.JamToDetik()-J.JamToDetik());
//       }
//       else
//       {
//           System.err.println("Tidak bisa mengurangkan, Jam pengurang lebih kecil ! ");
//           return new adtjamDio(0,0,0);
//       }
   }
   
   public adtjamDio NextDetik ()
   {
       return DetikToJam((this.JamToDetik()+1));
   }
   
   public adtjamDio NextNDetik(int N)
   {
       return DetikToJam((this.JamToDetik()+N));
   }
   
   public adtjamDio PrevDetik ()
   {
       return DetikToJam((this.JamToDetik()-1));
   }
   
   public adtjamDio PrevNDetik(int N)
   {
       return DetikToJam((this.JamToDetik()-N));
   }

   public int Durasi (adtjamDio JAk)
   {
       return this.JamToDetik()-JAk.JamToDetik();
   }
    //end Operator aritmatik
   
    //fungsi tambahan 

   public static void view(adtjamDio jam1,adtjamDio jam2)
   {
        System.out.println("=============================");
        System.out.println("jam pertama : "+jam1.BacaJam());
        System.out.println("jam kedua   : "+jam2.BacaJam());
        System.out.println("=============================");
   }
   
   public static int[] menu()
   {
       int[] select = new int[2];
       System.out.println("-------------Menu-------------");
       System.out.println("1.Ubah Jam");
       System.out.println("2.Konversi Jam");
       System.out.println("3.Operasi Perbandingan Jam");
       System.out.println("4.Operasi Aritmatika Jam");
       System.out.print("Masukan pilihan : ");
       select[1] = sc.nextInt();
       System.out.print("Lakukan operasi pada jam ?  1 / 2 : ");
       select[0] = sc.nextInt();
       String jam = (select[0]==1) ? "Pertama" : "Kedua ";
       System.out.println();
       System.out.println("-----Operasi Pada Jam "+jam+"------");
       return select;
   }
   
   public static boolean operasi(adtjamDio jam1 ,adtjamDio jam2)
   {
        int[] selection;
        boolean ulang;
        String check;
        selection = menu();
        
        switch(selection[1])
        {
            case 1 :
               int hh,mm,ss;
               System.out.print("Masukan Jam (HH): " );
               hh = sc.nextInt();
               System.out.print("Masukan Menit (HH): " );
               mm = sc.nextInt();
               System.out.print("Masukan detik (HH): " );
               ss = sc.nextInt();
               if(selection[0]==1)jam1.TulisJam(hh, mm, ss);
               else jam2.TulisJam(hh, mm, ss);
               view(jam1,jam2);
            break;
            case 2 :
               view(jam1,jam2);
               if(selection[0]==1)System.out.println("Jam pertama ke detik : "+jam1.JamToDetik());
               else System.out.println("Jam kedua ke detik   : "+jam2.JamToDetik());
            break;
            case 3 :
                view(jam1,jam2);
                String banding = (selection[0]==1) ? "Pertama" : "Kedua ";
                boolean sama = (selection[0]==1) ? jam1.JEQ(jam2) : jam2.JEQ(jam1);
                boolean tsama = (selection[0]==1) ? jam1.JNEQ(jam2) : jam2.JNEQ(jam1);
                boolean kecil = (selection[0]==1) ? jam1.JLT(jam2) : jam2.JLT(jam1);
                boolean besar = (selection[0]==1) ? jam1.JGT(jam2) : jam2.JGT(jam1);
                String pbanding = !(selection[0]==1) ? "Pertama" : "Kedua ";
                System.out.println("Jam "+banding+ (sama ? " SAMA " : " TIDAK SAMA ") + "dengan jam "+ pbanding);
                System.out.println("Jam "+banding+ (tsama ? " BERBEDA " : " TIDAK BERBEDA ") + "dengan jam "+ pbanding);
                System.out.println("Jam "+banding+ (kecil ? " KECIL " : " TIDAK KECIL ") + "dari jam "+ pbanding);
                System.out.println("Jam "+banding+ (besar ? " BESAR " : " TIDAK BESAR ") + "dari jam "+ pbanding);
            break;
            case 4 :
                 view(jam1,jam2);
                 adtjamDio tambah = jam1.JPlus(jam2);
                 adtjamDio kurang = (selection[0]==1 ) ? jam1.JMinus(jam2) : jam2.JMinus(jam1);
                 adtjamDio tdetik = (selection[0]==1 ) ? jam1.NextDetik() : jam2.NextDetik();
                 adtjamDio tNdetik = (selection[0]==1 ) ? jam1.NextNDetik(5) : jam2.NextNDetik(5);
                 adtjamDio mdetik = (selection[0]==1 ) ? jam1.PrevDetik() : jam2.PrevDetik();
                 adtjamDio mNdetik = (selection[0]==1 ) ? jam1.PrevNDetik(5) : jam2.PrevNDetik(5);
                 int durasi = (selection[0]==1 ) ? jam1.Durasi(jam2) : jam2.Durasi(jam1);
                System.out.println("Hasil Penambahan Jam    : "+tambah.BacaJam());
                System.out.println("Hasil Pengurangan Jam   : "+kurang.BacaJam());
                System.out.println("Hasil Jam + 1 detik     : "+tdetik.BacaJam());
                System.out.println("Hasil Jam + 5 detik     : "+tNdetik.BacaJam());
                System.out.println("Hasil Jam - 1 detik     : "+mdetik.BacaJam());
                System.out.println("Hasil Jam - 5 detik     : "+mNdetik.BacaJam());
                System.out.println("Perbadan Durasi Jam     : "+durasi);
            break;
            default:
                System.err.println("Pilihan Tidak Tersedia");
            break;       
        }
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Y untuk kembali ke menu utama ");
        System.out.println("X untuk Keluar");
        System.out.print("Masukan Pilihan  : ");
        check = sc.next();
        ulang = check.equalsIgnoreCase("Y");
        System.out.println();
        System.out.println();
        System.out.println();
        return ulang;
   }
   

    public static void main(String[] args) 
    {
        
        adtjamDio jam1 = new adtjamDio(20,15,30);
        adtjamDio jam2 = new adtjamDio(20,17,30);
        boolean ulang = true;
        while(ulang)
        {
            System.out.println("====Contoh Program adtjamDio====");
            view(jam1,jam2);
            ulang = operasi(jam1,jam2);
        }
        System.out.println("Program Berakhir");
    }   
}
