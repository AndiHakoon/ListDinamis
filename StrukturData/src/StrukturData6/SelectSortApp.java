/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StrukturData6;

/**
 *
 * @author Andi
 */
class ArraySel
{
    private long[] a;                   // ref to array a
    private int nElems;                 // number of data items
//-------------------------------------------------------------
    public ArraySel(int max)            // constructor
    {
        a = new long[max];              // create the array
        nElems = 0;                     // no items yet
    }
//-------------------------------------------------------------
    public void insert(long value)      // put element into array
    {
        a[nElems] = value;              // insert it
        nElems++;                       // increment size
    }
//-------------------------------------------------------------
    public void display()               // displays array contents
    {
        for (int i = 0; i < nElems; i++) {  // for each element,
            System.out.print(a[i]+" ");   // display it
        }
        System.out.println("");
    }
//-------------------------------------------------------------
    public void selectionSort()
    {
        int out, in, min;
        
        for (out=0; out < nElems-1; out++) // outer loop
        {
            System.out.print("out = "+out+"\n");
            min = out;                     // minimum
            for (in = out+1; in < nElems; in++){ // inner loop
                if(a[in] < a[min]){              // if min greater,
                    min = in;}                   // we have a new min
                System.out.print("in = "+in+"\t");
            }
            swap(out, min);                      // swap them
            for (int i = 0; i < nElems; i++) {
             System.out.print(a[i]+" ");   
            }
        } // end for(out)
        System.out.println();
    } // end selectionSort();
//-------------------------------------------------------------
    public void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//-------------------------------------------------------------    
} // end class ArraySel
public class SelectSortApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int maxSize = 100;              // array size
        ArraySel arr;                   // reference to array
        arr = new ArraySel(maxSize);     // create the array
        
       arr.insert(1);//arr.insert(77);                 // insert 10 items
       arr.insert(7);// arr.insert(99);
       arr.insert(3); //arr.insert(44);
       arr.insert(6);// arr.insert(55);
       arr.insert(2);// arr.insert(22);
       arr.insert(4);// arr.insert(88);
       arr.insert(9);// arr.insert(11);
       // arr.insert(00);
       // arr.insert(66);
       // arr.insert(33);
        
        arr.display();                  // display items
        arr.selectionSort();            // selection sort them
        arr.display();                  // display them again
    } // end main()
} // end class SelectSortApp
