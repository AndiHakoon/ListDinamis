
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

/**
 * @author Andi
 * 
 */

//////////////////////////////////////////////////////////
class Link
{
    private int iData;          // (could be other items)
    public Link next;           // data item
    //----------------------------------------------------
    public Link(int it)         // constructor
    { iData = it;}
    //----------------------------------------------------
    public int getKey()
    {return iData;}
    //----------------------------------------------------
    public void displayLink()   // display this link
    { System.out.println(iData + " ");}
} // end class Link
//////////////////////////////////////////////////////////
class SortedList
{
    private Link first;         // ref to first list item
    //----------------------------------------------------
    public void SortedList()    // constructor
    { first = null; }
    //----------------------------------------------------
    public void insert(Link theLink) // insert link, in order
    {
        int key = theLink.getKey();
        Link previous = null;       // start at first
        Link current = first;
                                    // until end of list,
        while ( current != null && key > current.getKey() )
        {                           // or current > key,
        previous = current;
        current = current.next;     // go to next item
        }
        if (previous==null)         // if beginning of list
            first = theLink;        // first--> new link
        else                        // not at beginning,
            previous.next = theLink; // prev --> new Link
        theLink.next = current;     // new Link --> current
    }   // end insert()
    //----------------------------------------------------
    public void delete(int key)     // delete link
    {                               // (assumes non-empty list)
        Link previous = null;       // start at first
        Link current = first;
                                    // until end of list,
        while ( current != null && key != current.getKey() ) 
        {            
            previous = current;
            current = current.next; // go to next link
        }
                                    // disconnect link
        if (previous == null)       // if beginning of list
            first = first.next;     // delete fist link
        else 
            previous.next = current.next; // delete current link
    } // end delete()
    //----------------------------------------------------
    public Link find(int key)       // find link
    {
        Link current = first;       // start at first
                                    // until end of list,
        while (current != null && current.getKey() <= key) 
        {                           // or key too small,            
            if(current.getKey() == key) // is this the link?
            return current;             // found it, return link
            current = current.next;     // go to next item
        }
        return null; // didn’t find it
    } // end find()
    //----------------------------------------------------
    public void displayList()
{
System.out.print("List (first-->last): ");
Link current = first; // start at beginning of list
while(current != null) // until end of list,
{
current.displayLink(); // print data
current = current.next; // move to next link
}
System.out.println();
}
 
}// end class SortedList
//////////////////////////////////////////////////////////
class HashTable
{
    private SortedList[] hashArray; // array of lists
    private int arraySize;          
    //----------------------------------------------------
    public HashTable(int size)      // constructor
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];  // create array
        for (int j = 0; j < arraySize; j++)     // fill array
            hashArray[j] = new SortedList();    // with lists
    }
    //----------------------------------------------------
    public void displayTable()
    {
        for (int j = 0; j < arraySize; j++)     // for each cell, 
        {
            System.out.print(j + ". ");         // display cell number
            hashArray[j].displayList();         // display list
        }
    }
    //----------------------------------------------------
    public int hashFunc(int key)                // hash function
    { return key % arraySize; }
    //----------------------------------------------------
    public void insert(Link theLink)            // insert a link
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);            // hash the key
        hashArray[hashVal].insert(theLink);     // insert at hashVal
    }   // end insert()
    //----------------------------------------------------
    public void delete(int key)                 // delete a link
    {
        int hashVal = hashFunc(key);            // hash the key
        hashArray[hashVal].delete(key);         // delete link
    }   // end delete()
    //----------------------------------------------------
    public Link find(int key)                   // find link
    {
        int hashVal = hashFunc(key);            // hash the key
        Link theLink = hashArray[hashVal].find(key); // get link
        return theLink;                     // return link
    }
    //----------------------------------------------------
}   // end class HashTable
//////////////////////////////////////////////////////////
public class hashChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;
                                // getsizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
                                // make table
        HashTable theHashTable = new HashTable(size);
        for (int j = 0; j < n; j++) // insert data 
        {
        aKey = (int)(java.lang.Math.random() * 
                keysPerCell * size);
        aDataItem = new Link(aKey);
        theHashTable.insert(aDataItem);
        }
        while (true) 
        {            
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 's':
                theHashTable.displayTable();
                break;
                case 'i':
                System.out.print("Enter key value to insert: ");
                aKey = getInt();
                aDataItem = new Link(aKey);
                theHashTable.insert(aDataItem);
                break;
                case 'd':
                System.out.print("Enter key value to delete: ");
                aKey = getInt();
                theHashTable.delete(aKey);
                break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null)
                        System.out.println("Found "+aKey);
                    else
                        System.out.println("Couldn't find "+aKey);
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }   // end switch
        }   // end while
    }   // end main()
    //----------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //----------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //----------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
    //----------------------------------------------------
}// end class HashChainApp
//////////////////////////////////////////////////////////
