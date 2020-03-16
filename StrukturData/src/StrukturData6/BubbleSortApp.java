/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StrukturData6;

/**
 * @author Andi
 * bubblesort.java
 * class TRPL 1B
 * BP number 1911082006
 * @version  1.0.0
 */
/////////////////////////////////////////////////////

class ArrayBub
{
    private long[] a;               // ref to array a
    private int nElems;             // number of data items
//-------------------------------------------------------------
    public ArrayBub(int max)        // constructor
    {
        a = new long[max];          // create the array
        nElems = 0;                 // no items yet
    }
//-------------------------------------------------------------
    public void insert(long value)  // put element into array
    {
        a[nElems] = value;          // insert it  
        nElems++;                   // increment size
    }
//------------------------------------------------------------ 
    public void display() // display array contents
    {
        for (int i = 0; i < nElems; i++) {  // for each element,
            System.out.println(a[i]+" ");   // display it
            System.out.println("");    
        }
    }
//-------------------------------------------------------------
    public void bubbleSort()
    {
        int out, in;
        for(out=nElems-1;out>1;out--)   // outer loop (backward)
            for(in=0;in<out;in++)       // inner loop (forward)
                if(a[in]>a[in+1])       // out of order?
                    swap(in, in+1);     // swap them
    } // end bubbleSort()
//-------------------------------------------------------------
    public void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//-------------------------------------------------------------
} // end class ArrayBub

public class BubbleSortApp {
    public static void main(String[] args) 
    {    
        int maxSize = 100;              // array size
        ArrayBub arr;                   // reference to array
        arr = new ArrayBub(maxSize);    // create the array
        
        arr.insert(77);                  // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        
        arr.display();                  // bubble sort them
        arr.bubbleSort();               // bubble sort them
        arr.display();                  // display them again
    } // end main()
} // end class BubbleSortApp
