package StrukturData7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Program : DataArrayApp.java
 * Terdapat tiga kelas, kelas Mahasiswa, DataArray, dan Data Array App.
 * record yang disimpan adalah data 
 * @author Andi
 * NOBP : 1911082006
 * Kelas : TRPL 1B
 * Nomor Absen Genap
 */

class Mahasiswa{
    private long nobp;
    private String nama;
    private String asal;
    
    public Mahasiswa(long nobp, String nama, String asal){
        this.nobp = nobp;
        this.nama = nama;
        this.asal = asal;
    }
    
    public void displayMhs(){
        System.out.println("No BP : "+nobp+"\tNama : "+nama+
                "\tAsal : "+asal);
    }
    
    public long getNoBP(){
        return nobp;
    }
    
    public String getnama(){
        return nama;
    }
    
    public String getasal(){
        return asal;
    }

    public void setNobp(long nobp) {
        this.nobp = nobp;
    }
    
}

class DataArray{
    private Mahasiswa[] mhs; // membuat array untuk class Mahasiswa
    private int nElement;
    
    public DataArray(int max){
        mhs = new Mahasiswa[max];
        nElement = 0;
    }
    
    public Mahasiswa find (long searchnobp) // linear Searching
    {
        int i;
        for (i = 0; i < nElement; i++) {
            if (mhs[i].getNoBP()==searchnobp) 
                break;
                //endif
        }
        if (i==nElement) //tidak ketemu
            return null;
         else 
            return mhs[i];
    }
    
    public void insert(long noBp, String nama, String asal)
    {
        mhs[nElement] = new Mahasiswa(noBp, nama, asal);
        nElement++;
    }
    
    public boolean delete(long searchnobp) // hapus element
    {
        int i, j;
        for (i = 0; i < nElement; i++) {
            if(mhs[i].getNoBP()==searchnobp)
                break;
            // endif
        }
        if (i==nElement) // nobp yang akan dihapus tidak ada
            return false;
        else // ada
        {
            for (j = i; j < nElement; j++) {
                mhs[j] = mhs[j+1];
            }
            nElement--;
            return true;
        }
    }
    
    public void BubbleSort(){ //untuk no bp
        int batas, i, n=0;                                  // declaration of variable
        for (batas = nElement-1; batas > 0; batas--) { // outer loop
            for (i = 0; i < batas; i++) {              // inner loop
                n++;
                if (mhs[i].getNoBP() > mhs[i+1].getNoBP()) {                
                    swap(i,i+1);
                }
            }
        }
    }
    
    public void InsertionSort(){ //untuk nobp
        int i, j;
        
        for (i= 1; i < nElement; i++) 
        {
            Mahasiswa key = new Mahasiswa(mhs[i].getNoBP(), mhs[i].getnama(),
                                          mhs[i].getasal());
            j = i - 1;
            
            while (j >= 0 && (mhs[j].getNoBP() > key.getNoBP()) ) {
                mhs[j+1] = mhs[j];
                j--;
            }
            mhs[j+1]=key;
        }
    }
    
    public void SelectionSort(){ // untuk nama
        int awal, i, min;
        
        for (awal = 0; awal < nElement; awal++) {
            min = awal;
            for (i = awal+1; i < nElement; i++) {
                if (mhs[i].getnama().compareTo(mhs[min].getnama())<0) {
                    min = i;
                }
            }
            swap(awal, min);
        }
    }
    
    public void swap(int one, int two)
    {
        Mahasiswa temp = new Mahasiswa(mhs[one].getNoBP(), mhs[one].getnama(), mhs[one].getasal());
        mhs[one] = mhs[two];
        mhs[two] = temp;
    }
    
    public void display()
    {
        int i;
        for (i = 0; i < nElement; i++) {
            mhs[i].displayMhs();
        }
    }
}
public class DataArrayApp {
    public static void main(String[] args) {
        int maxsize = 100;
        DataArray arr;
        arr = new DataArray(maxsize);
        arr.insert(121, "Andi", "Padang");
        arr.insert(128, "Kurnia", "Padang");
        arr.insert(123, "Dila", "Palembang");
        arr.insert(124, "Fauzan", "Pekanbaru");
        arr.insert(126, "Anita", "Payakumbuh");
        arr.insert(127, "Rani", "Padang");
        arr.insert(125, "Rian", "Solok");
        arr.insert(129, "Yusuf", "Solok");
        arr.insert(122, "Budi", "Bukittinggi");
        
        System.out.println("Before : ");
        arr.display();
        
        System.out.println("BubbleSort");
        arr.BubbleSort();
        arr.display();
        
        System.out.println("SelectionSort");
        arr.SelectionSort();
        arr.display();
        
        System.out.println("InsertionSort");
        arr.InsertionSort();
        arr.display();

//        long searchkey = 126;
//        System.out.println("Mencari nobp "+searchkey);
//        Mahasiswa mhs = arr.find(searchkey);
//        if (mhs!=null) {
//            System.out.println("Ketemu -->");
//            mhs.displayMhs();
//        }
//        else 
//            System.out.println(searchkey+" didn't exist");
//        //endif
        
//        searchkey = 124;
//        System.out.println("Menghapus nobp "+searchkey);
//        arr.delete(searchkey);
//        arr.display();
    }
}
