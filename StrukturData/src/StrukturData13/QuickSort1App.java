/*
 * Copyright 2020 Andi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package StrukturData13;

/**
 * @author Andi
 * 
 */
class ArrayIns 
{
    private long[] theArray;    // ref to array theArray
    private int nElems;         // number of data items
    //--------------------------------------------------

    public ArrayIns(int max) 
    {
        theArray = new long[max]; // constructor
        nElems = 0;               // number of data items
    }
    //---------------------------------------------------
    public void insert(long value) // displays array contents
    {
        theArray[nElems] = value;   // insert it
        nElems++;                   // increment size
    }
    //---------------------------------------------------
    public void display()       // displays array contents
    {
        System.out.println("A=");
        for (int j = 0; j < nElems; j++) 
            System.out.print(theArray[j] + " "); // display it
            System.out.println();
    }
    //---------------------------------------------------
    public void quickSort()
    {
        recQuickSort(0, nElems-1);
    }
    //--------------------------------------------------
    public void recQuickSort(int left, int right)
    {
        if (right-left <= 0)    // if size <= 1,
            return;             // already sorted
        else
        {
            long pivot = theArray[right];   // rightmost item
                                            // partition range
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition-1); // sort left side
            recQuickSort(partition+1, right); // sort right side
        }
    }// end recQuickSort()
    //--------------------------------------------------
    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left-1;           // left (after++)
        int rightPtr = right;           // right-1 (after--)
        while (true) {            
            while(theArray[++leftPtr] < pivot )
                ; // (nop)
            while(rightPtr > 0 && theArray[--rightPtr] > pivot)
                ; // (nop)
            if (leftPtr >= rightPtr) // if pointers cross,
                break;               // partition odone
            else                     // not crossed, so
                swap(leftPtr, rightPtr); // swap elements
        } // end while(true)
        swap(leftPtr, rightPtr); // restore pivot
        return leftPtr;          // return pivot location
    } // end partitionIt()
    //---------------------------------------------------
    public void swap(int dex1, int dex2)    // swap two elements
    {
        long temp = theArray[dex1];         // A into temp
        theArray[dex1] = theArray[dex2];    // B into A
        theArray[dex2] = temp;              // temp into B
    } // end swap()
    
}

public class QuickSort1App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int maxSize = 16;               // array size
        ArrayIns arr;                   
        arr = new ArrayIns(maxSize);    // create array
        
        for (int j = 0; j < maxSize; j++) {
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display();                  // display items
        arr.quickSort();                // quicksort them
        arr.display();                  // display them again
    }   // end main()
}   // end class QuickSort1App
