/*  
orderedArray.java
Name : Andi Irham Marhamuddin
Class : TRPL 1B
BP Num : 1911082006

 demonstrates ordered arr class
 to run this program java OrderedApp */

class OrdArray {               //class high aay
    private long[] a;          // Declaration of 'a'z aays
    private int nElems;       // declaration integer nElem
    
    public OrdArray(int max){      //Constructor
        a = new long[max];         //Create Array
        nElems = 0;
    }
    //---------------------------------------------------
    int size()
    {
        return nElems;
    }
    //----------------------------------------------------
    public int find(long searchKey) 
    { 
        int lowerBound = 0; 
        int upperBound = nElems-1; 
        int curIn;
    
    while(true) 
    { 
    curIn = (lowerBound + upperBound ) / 2;
    if(a[curIn]==searchKey) 
        return curIn;    // found it 
    else if(lowerBound > upperBound) 
        return nElems;            // can�t find it 
    else                          // divide range 
        {
        if(a[curIn] < searchKey) 
            lowerBound = curIn + 1; // it�s in upper half 
        else 
            upperBound = curIn - 1; // it�s in lower half 
            }  // end else divide range 
        }  // end while 
    }  // end find() 
    //----------------------------------------------------------
    public void insert(long value)    // put element into array 
    { 
      int j;
      for(j=0; j<nElems; j++)        // find where it goes 
          if(a[j] > value)            // (linear search) 
              break; 
      for(int k=nElems; k>j; k--)    // move bigger ones up 
          a[k] = a[k-1]; a[j] = value;                  // insert it 
          nElems++;                      // increment size 
    }  // end insert() 
//-----------------------------------------------------------
    public boolean delete(long value) 
    { 
    int j = find(value);
    if(j==nElems)                  // can�t find it 
        return false; 
    else                           // found it 
        { 
        for(int k=j; k<nElems; k++) // move bigger ones down 
            a[k] = a[k+1]; 
    nElems--;                   // decrement size 
    return true; 
    } 
}  // end delete() 
//--------------------------------------------------------  
    public void display()             // displays array contents 
    { 
        for(int j=0; j<nElems; j++)       // for each element, 
            System.out.print(a[j] + " ");  // display it 
        System.out.println(""); 
    } 
//----------------------------------------------------------
public long getElem(int index){                     // get return as elem
    return a[index];
}
//----------------------------------------------------------
public OrdArray mergeOrdered(OrdArray arr2){
       int newSz = size()+arr2.size();              //make a new object
       OrdArray arr3 = new OrdArray(newSz);
       
       for (int i = 0; i < size(); i++)                // insert for arr
           arr3.insert(a[i]);
        for (int j = 0; j < arr2.size(); j++)           //insert for arr2
            arr3.insert(arr2.getElem(j));    
        return arr3;      
}
//----------------------------------------------------------
} // end class

public class OrderedApp{
    public static void main(String[] args) {
        int maxSize=100;                 // Maximum array size
        OrdArray arr, arr2;                    // reference to array
        arr = new OrdArray(maxSize);     // create the array
        arr2 = new OrdArray(maxSize);

        arr.insert(77);                 // insert 10 items for object arr
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr2.insert(99);                    // insert 8 items for object arr 2
        arr2.insert(88);
        arr2.insert(22);
        arr2.insert(11);
        arr2.insert(44);
        arr2.insert(00);
        arr2.insert(66);
        arr2.insert(55);

        
        int searchKey = 55;
        if (arr.find(searchKey) != arr.size()) 
            System.out.println("Found "+ searchKey);
        else
            System.out.println("Can't find "+ searchKey);
        arr.display();  // display items

        arr.delete(00);     // delete 3 items
        arr.delete(55);
        arr.delete(99);
        
        arr.display();      // display items again

        System.out.println();
        arr2.display();

        OrdArray arr3 = arr.mergeOrdered(arr2);
        arr3.display();
    }   // end main
}       // end class OrderedApp