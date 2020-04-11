/**
 *
 * @author Hakkan Syukri 1911082017
 * @author Andi Irham M 1911082006
 */

import java.util.Scanner;
class NilaiMatkul{                                                   // Deklarasi class NilaiMatkul
    String nim;                                                      // Deklarasi tipe data String pada nim
    String nama;                                                     // Deklarasi tipe data String pada nama
    String nilai;                                                    // Deklarasi tipe data String pada nilai
    
    NilaiMatkul(){                                                   // Konstruktor untuk kelas NilaiMatkul
    }
    // Getter - Setter //
    public void setNim(String nim) {                                 // Setter nim
        this.nim = nim;                                              // Set this.nim dengan nilai nim
    }
    
    public String getNim() {                                         // Getter nim
        return nim;                                                  // Mengembalikan nilai nim
    }

    public void setNama(String nama) {                               // Setter nama
        this.nama = nama;                                            // Set this.nama dengan nilai nama
    }
    
    public String getNama() {                                        // Getter nama
        return nama;                                                 // Mengembalikan nilai nama
    }

    public String getNilai() {                                       // Getter nilai
        return nilai;                                                // Mengembalikan nilai "nilai"
    }

    public void setNilai(String nilai) {                             // Setter nilai
        this.nilai = nilai;                                          // Set this.nilai dengan nilai 'nilai'
    }       
}                                                                    // akhir class NilaiMatkul

class Elemen{                                                        // Deklarasi class Elemen
    NilaiMatkul kontainer;                                           // Deklarasi objek NilaiMatkul dengan nama kontainer
    Elemen next;                                                     // Deklarasi objek Elemen dengan nama next
    
    Elemen(){                                                        // Konstruktor untuk kelas Elemen
        kontainer = new NilaiMatkul();                               // Kontainer diisi dengan objek NilaiMatkul() yang baru
    }

    //getter-setter//
    public NilaiMatkul getKontainer() {                              // Getter kontainer
        return kontainer;                                            // Mengembalikan nilai kontainer
    }

    public void setNext(Elemen next) {                               // Setter next
        this.next = next;                                            // Set this.next dengan nilai next
    }    
    
    public Elemen getNext() {                                        // Getter next
        return next;                                                 // Mengembalikan nilai next
    }        
}                                                                    // Akhir class Elemen

class List{                                                          // Deklarasi class List
    private Elemen first;                                            // Deklarasi objek private Elemen dengan nama first;
    
    List() {                                                         // Konstruktor untuk kelas List
    }
    //getter-setter//
    public Elemen getFirst() {                                       // Getter first
        return first;                                                // Mengembalikan first
    }

    public void setFirst(Elemen first) {                             // Setter first
        this.first = first;                                          // Set this.first dengan nilai first
    }
    
    void createList(){                                               // Method membuat List
        first = null;                                                // Set first menjadi kosong / null
    }
    
    int countElement(){                                              // Method menghitung elemen
        int hasil = 0;                                               // hasil diset 0
        Elemen bantu;                                                // Deklarasi objek Elemen dengan nama bantu
        
        if(first != null)                                            // Jika first tidak kosong
        {
            bantu = first;                                           // Bantu diisi dengan nilai dari first 
            while(bantu != null){                                    // Ketika bantu tidak kosong
                hasil = hasil+1;                                     // hasil akan ditambah satu
                bantu = bantu.getNext();                             // Memanggil fungsi dari kelas Elemen.getNext();
          }
        }
        return hasil;                                                // Mengembalikan hasil
    }
    
    void addFirst(String nim, String nama, String nilai){            // Method addFirst (nilai Awal)
        Elemen baru;                                                 // Deklarasi objek Elemen dengan nama 'baru';
        baru = new Elemen();                                         // 'baru' diisi dengan nilai objek elemen baru
        baru.getKontainer().setNim(nim);                             // Memanggil fungsi Elemen.getKontainer yang didalamnya terdapat fungsi NilaiMatkul.setNim(); untuk mengisi nim.
        baru.getKontainer().setNama(nama);                           // Memanggil fungsi Elemen.getKontainer yang didalamnya terdapat fungsi NilaiMatkul.setNama(); untuk mengisi nama.
        baru.getKontainer().setNilai(nilai);                         // Memanggil fungsi Elemen.getKontainer yang didalamnya terdapat fungsi NilaiMatkul.setNilai(); untuk mengisi nama.
        
        if(first==null){                                             // Jika first kosong
            //list kosong
            baru.setNext(null);                                      // Data selanjutnya dikosongkan (Elemen.setNext dengan nilai null)
        }
        else{                                                        // first != null
            //list tidak kosong
            baru.setNext(first);                                     // Nilai "baru" diisi ke elemen pertama
        }
        first = baru;                                                // elemen pertama (first) diisi dengan baru
        baru = null;                                                 // "baru" dibuat kosong
    }
    
    void addAfter(Elemen prev, String nim, String nama, String nilai){  // Menambahkan elemen setelahnya 
        Elemen baru;                                                    // Deklarasi objek Elemen dengan nilai baru
        if(prev != null){                                               // jika elemen sebelumnya tidak kosong
            baru = new Elemen();                                        // elemem diisi dengan elemen "baru"
            baru.getKontainer().setNim(nim);                            // set nim baru
            baru.getKontainer().setNama(nama);                          // set nama baru
            baru.getKontainer().setNilai(nilai);                        // set nilai baru
            
            if(prev.next == null){                                      // jika elemen sebelumnya kosong
                baru.setNext(null);                                     // elemen "baru" diset nol
            }
            else{                                                       // jika tidak kosong
                baru.setNext(prev.getNext());                           // nilai "baru" diisi nilai elemen sebelumnya
            }
            prev.setNext(baru);                                         // nilai elemen selanjutnya diisi dengan elemen "baru"
            baru = null;                                                // elemen "baru" diset kosong
        }
    }
    
    void addLast(String nim, String nama, String nilai){             // Penambahan di elmen akhir
        Elemen last;                                                 // Deklarasi objek elemen dengan nama last sebagai elemen terakhir
        if(first == null){                                           // Jika elemen pertama (first) kosong
            //list kosong
            addFirst(nim, nama, nilai);                              // isi nilai elemen awal (memanggil addFirst)
        }
        else{                                                        // elemen pertama (first) tidak kosong
            //list kosong
            //cari elemen terakhir
            last = first;                                            // elemen last diisi dengan first
            while(last.getNext() != null){                           // selagi elemen last tidak kosong
                last = last.getNext();                               // element last diisi dengan last selanjutnya
            }
            addAfter(last, nim, nama, nilai);                        // isi elemen last dengan addAfter
        }
    }
    
    void delFirst(){                                                 // Hapus elemen awal (first)
        Elemen hapus;                                                // Deklarasi objek Elemen dengan nama "hapus"
        if(first != null){                                           // Jika elemen first tidak kosong
            hapus = first;                                           // elemen hapus diisi dengan elemen first
            if(countElement()==1){                                   // Jika isi elemen hanya 1
                first = null;                                        // elemen first dikosongkan
            }
            else{                                                    // Jika lebih dari satu
                first = first.getNext();                             // Elemen first diisi dengan elemen first selanjutnya
            }
                                                                     // kosongkan elemen hapus yang berisi element first sebelumnya.
            hapus.setNext(null);
        }
        else{                                                        // jika elemen first kosong
            System.out.println("List kosong, tidak bisa dihapus");   // error message
        }
    }
    
    void delAfter(Elemen prev){                                      // method delete after 
        Elemen hapus;                                                // deklarasi objek elemen dengan nama hapus
        if(prev != null){                                            // jika elemen sebelumnya tidak kosong
            hapus = prev.getNext();                                  // elemen hapus diisi dengan elemen sebelumnya.
            if(hapus != null){                                       // jika elemen hapus tidak kosong
                prev.setNext(null);                                  // elemen sebelumnya diisi kosong
            }
            else{                                                    // jika elemen hapus kosong
                prev.setNext(hapus.getNext());                       // elemen sebelumnya diisi dengan elemen hapus
            }
            //pengosongan elemen
            hapus.setNext(null);                                     // elemen hapus dikosongkan
        }
    }

    void delLast(){                                                  // method prosedur delet last
    Elemen last, before_last;                                        // Deklarasi objek Elemen dengan nama last dan before_last
        if(first != null){                                           // Jika elemen first tidak kosong
            if(countElement()==1){                                   // dan jika count elemen bernilai 1
            //list isi hanya satu
                delFirst();                                          // hapus elemen pertama
            }else{ //mencari elemen terakhir                         // jika elemen first kosong
                last = first;                                        // elemen last diisi elemen first
                before_last = null;                                  // elemen sebelum last dikosongkan

        while(last.getNext()!= null){                                // selagi last masih ada
            before_last = last;                                      // elemen sebelum last diisi dengan elemen last 
            last = last.getNext();                                   // element last diisi dengan elemen last yang baru
            }
            //elemen sebelum menjadi elemen terakhir
        delAfter(before_last);                                       // element before last dikosongkan
            }
        }
    }
            
    void printElement(){                                             // method menampilkan elemen
    Elemen bantu;                                                    // Deklarasi objek Elemen dengan nama bantu
    int i;                                                           // Deklarasi variabel integer i
        if(first != null){                                           // jika first tidak kosong 
            bantu = first;                                           // elemen bantu diisi elemen first
            i=1;                                                     // i bernilai 1
        while(bantu != null){                                        // selagi elemen bantu tidak kosong
            System.out.println("Elemen ke : " +i);                              
            System.out.println("Nim : " + bantu.getKontainer().getNim());       // tampilkan nim
            System.out.println("Nama : " + bantu.getKontainer().getNama());     // tampilkan nama
            System.out.println("Nilai : " + bantu.getKontainer().getNilai());   // tampilkan nilai
            System.out.println("----------------------");       
            bantu = bantu.getNext();                                            // buka elemen selanjutnya
            i=i+1;                                                              // increment i
            }
        }else{                                                                  // jika first kosong
            //list kosong       
        System.out.println("List Kosong. Data tidak ada");
        }
    }
            
    void delAll(){                                                   // method menghapus semua elemen
    int i;                                                           // Deklarasi variabel integer i
    if(countElement()!=0){                                           // jika count elemen berisi
        for(i=countElement();i>=1;i--){                              // pengulangan loop mundur
        //elemen dihapus daru belakang
        delLast();                                                   // hapus dari belakang
        }
    }
    }
}
            
public class CobaListDinamis {                                       // Main class CobaListDinamis
    public static void main(String[] args) {                         // Main Method
    Scanner in = new Scanner(System.in);                             // Deklarasi Scanner
    List L1 = new List();                                            // Deklarasi List dengan nama L1
    String katacari;                                                 // Deklarasi String katacari
    Elemen bantu;                                                    // Deklarasi Elemen bantu
    int i;                                                           // Deklarasi integer i
            
    L1.createList();                                                 // membuat list
    System.out.println("===Insert===");
    L1.addFirst("136","Nana","A");                                   // isi nim, nama dan nilai
    L1.addAfter(L1.getFirst(),"135","Iza","A");                      // menambah setelah "Nana"
    L1.addLast("137","Rara","A");                                    // menambah elemen terakhir dengan nama "Rara" 
    L1.addFirst("131","Koko","B");                                   // menambah elemen first dengan nama Koko
    L1.printElement();                                               // menampilkan semua elemen
    System.out.println("===================");
            
            
    System.out.print("Masukkan nim yang akan dicari :");
    katacari = in.nextLine();                                       // mencari nim
            
    bantu = L1.getFirst();                                          // bantu diisi dengan getfirst
    i=1;                                                            // i diisi 1
        while((bantu != null)&&(!bantu.kontainer.getNim().equals(katacari)) ){  // selama bantu tidak kosong DAN katacari belum ketemu
        bantu = bantu.getNext();                                                // bantu dicari
        i=i+1;                                                                  // iterasi increment
        }
        if (bantu == null){                                         // jika bantu kosong
        System.out.println("Data tidak ditemukan");
        }
        else{
            System.out.println("===Hasil Pencarian===");
            System.out.println(" Elemen ke: "+i);                       // print elemen i
            System.out.println(" NIM = "+bantu.kontainer.getNim());     // prin NIM elemen i
            System.out.println(" Nama = "+bantu.kontainer.getNama());   // print nama elemen i
            System.out.println(" Nilai = "+bantu.kontainer.getNilai()); // print nilai elemen i
        }
            
    System.out.println("\n===Delete===");
    L1.delFirst();                                                   // delete awal
    L1.delAfter(L1.getFirst());                                      // delet setelah awal
    L1.delLast();                                                    // delete terahir
    L1.printElement();                                               // print kembali semua element
    System.out.println("===================");
    }
}