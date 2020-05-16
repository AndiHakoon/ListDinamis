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

class ArrayPar
{
    private long[] theArray;        // ref to array theArray
    private int nElems;             // number of data items
    //---------------------------------------------
    public ArrayPar(int max){              // constructor
        theArray = new long[max];   // create the array
        nElems = 0;                 // no items yet
    }
    //--------------------------------------------
    public void insert(long value)  // put element into array
    {
        theArray[nElems] = value;  // insert it
        nElems++;                   // increment size
    }
    //-------------------------------------------
    public int size()               // return number of items
    { return nElems;}
    //-------------------------------------------
    public void display()           // displays array contents
    {
        System.out.println("A=");
        for (int i = 0; i < nElems; i++) // for each element
            System.out.println(theArray[i]+" "); // display it!
            System.out.println();
    }
    //----------------------------------------------
    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left - 1;         // right of first elem
        int rightPtr = right + 1;       // left of pivot
        while (true) 
        {
            while (leftPtr < right &&
                theArray[++leftPtr] < pivot)  // finding bigger item
                ; // nop
            while (rightPtr > left &&            
                theArray[--rightPtr] > pivot) // finding smaller item
                ; // nop
            
            if(leftPtr >= rightPtr)         // if pointers cross,
            break;                          // partition done
            else                            // not crossed, so
            swap(leftPtr, rightPtr);        // swap elements
        }   // end while(true)
        return leftPtr;                 // return partition;
    } // end partitionIt()
    //-------------------------------------------------
    public void swap(int dex1, int dex2)
    {
        long temp;  
        temp = theArray[dex1];              // A into temp
        theArray[dex1] = theArray[dex2];    // B into A
        theArray[dex2] = temp;              // temp into B
    }   // end swap()
    //-------------------------------------------------
}   // end class ArrayPar
public class PartitionApp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int maxSize = 16;                  // array size
        ArrayPar arr;                      // reference to array
        arr = new ArrayPar(maxSize);       // create the array

        for (int i = 0; i < maxSize; i++)  // fill array with 
        {                                  // random numbers 
            long n = (int)(java.lang.Math.random()*199);
            arr.insert(n);
        }
        arr.display();                     // display unsorted array

        long pivot = 99;                   // pivot value
        System.out.print("Pivot is " + pivot);
        int size = arr.size();
                                           // partition array
        int partDex = arr.partitionIt(0, size-1, pivot);

        System.out.println(", Partition is at index " + partDex);
        arr.display();                     // display partitioned array
    } // end main()

}
