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
class ArrayIns
{
    private long[] a;                   // ref to array a
    private int nElems;                 // number of data items
//-------------------------------------------------------------
    public ArrayIns(int max)            // constructor
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
        for (int i = 0; i < nElems; i++) { // for each element,
            System.out.print(a[i]+" ");  // display it
        }
        System.out.println("");
    }
//-------------------------------------------------------------  
    public void insertionSort()
    {
        System.out.println("elems = "+nElems);
        int in, out;
        
        for (out = 0; out < nElems; out++) // out is dividing line 
        {
            System.out.println("Out = "+out);
        long temp = a[out];                // remove marked item
        in = out;                          // start shifts at out
            while (in>0 && a[in-1] >= temp) // until one is smaller,
            {                
            a[in] = a[in-1];                // shift item to right
            --in;                           // go left one position
            a[in] = temp;                   // insrt marked item
            } // end while
        } // end for
    
    } // end class ArrayIns
//---------------------------------------------------------        
} // end class ArrayIns
///////////////////////////////////////////////////////////
public class InsertSortApp 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    int maxSize = 100;                  // array size
    ArrayIns arr;                       // reference to array
    arr = new ArrayIns(maxSize);        // create the array
    
//    arr.insert(77);                     // insert 10 items
//    arr.insert(99);                     
//    arr.insert(44);
//    arr.insert(55);
//    arr.insert(22);
//    arr.insert(88);
//    arr.insert(11);
//    arr.insert(00);
//    arr.insert(66);
//    arr.insert(33);
//    
arr.insert(34);
arr.insert(8);
arr.insert(64);
arr.insert(51);
arr.insert(32);
arr.insert(21);

    arr.display();                      // display items
    arr.insertionSort();                // insertion sort them
    arr.display();                      // display them again
    } // end main() 
} // end class InsertSortApp
///////////////////////////////////////////////////////////////
