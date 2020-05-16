package StrukturData13;

// ShellSortApp.java
// demonstrates shell sort
// to run this program: C>java ShellSortApp
//-------------------------------------------------------------
class ArraySh
{
	private long[] theArray;          // ref to array theArray
	private int nElems;               // number of data items
	//--------------------------------------------------------------
	public ArraySh(int max)           // constructor
	{
		theArray = new long[max];      // create the array
		nElems = 0;                    // no items yet
	}
	//-------------------------------------------------------------
	public void insert(long value)    // put element into array
	{
		theArray[nElems] = value;      // insert it
		nElems++;                      // increment size
	}
	//-------------------------------------------------------------
	public void display()             // displays array contents
	{
		System.out.print("A=");
		for(int j=0; j<nElems; j++)    // for each element,
			System.out.print(theArray[j] + " ");  // display it
		System.out.println("");
	}
	//-------------------------------------------------------------
	public void shellSort()
	{
		int inner, outer;
		long temp;
		int h = 1;                     // find initial value of h
		while(h <= nElems/3)
			h = h*3 + 1;                // (1, 4, 13, 40, 121, ...)
		while(h>0)                     // decreasing h, until h=1
		{
			// h-sort the file
			System.out.println("h = "+h);
			for(outer=h; outer<nElems; outer++)
			{
				temp = theArray[outer];
				inner = outer;
				// one subpass (eg 0, 4, 8)
				while(inner > h-1 && theArray[inner-h] >=  temp)
				{
					theArray[inner] = theArray[inner-h];
					inner -= h;
				}
				theArray[inner] = temp;
				display();
			}  // end for
			h = (h-1) / 3;              // decrease h
			//display();
		}  // end while(h>0)
	}  // end shellSort()
	//--------------------------------------------------------------
}  // end class ArraySh
////////////////////////////////////////////////////////////////
class ShellSortApp
{
	public static void main(String[] args)
	{
		int maxSize = 5;             // array size
		ArraySh arr;
		arr = new ArraySh(maxSize);   // create the array
		for(int j=0; j<maxSize; j++)  // fill array with
		{                          // random numbers
			long n = (int)(java.lang.Math.random()*9);
			arr.insert(n);
		}
		System.out.print("Sebelum pengurutan --> ");
		arr.display();                // display unsorted array
		arr.shellSort();              // shell sort the array
		System.out.print("\nSetelah pengurutan --> ");
		arr.display();                // display sorted array
	}  // end main()
}  // end class ShellSortApp
