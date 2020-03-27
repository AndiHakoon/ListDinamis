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

package StrukturData8.StackApp;
/**
 * @author Andi
 * Demonstrates stacks
 */
class StackX
{
    private int maxSize;        // ukuran dari tumpukan (stack) array
    private long[] stackArray;  // ukuran array;
    private int top;            // array teratas
//-------------------------------------------------------------------
    public StackX(int s)        // constructor
    {
        maxSize = s;            // menyetel ukuran array
        stackArray = new long[maxSize]; // membuat array
        top = -1;               // tidak ada item
    }
//-------------------------------------------------------------------
    public void push(long j)    // memasukkan item ke tumpukan
    {
        stackArray[++top] = j;  // increment top, insert item
    }
//-------------------------------------------------------------------
    public long pop()           // mengambil item dari tumpukan teratas
    {
        return stackArray[top--]; // akses item, decrement top
    }
//-------------------------------------------------------------------
    public long peek()          // mengintip stack teratas
    {
        return stackArray[top];
    }
//-------------------------------------------------------------------
    public boolean isEmpty()    // true jika stack kosong
    {
        return (top == -1);
    }
//-------------------------------------------------------------------    
} // end class StackX
/////////////////////////////////////////////////////////////////////
public class StackApp 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackX theStack = new StackX(10);   // buat stack baru
        theStack.push(20);                  // push item ke stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        
        while(!theStack.isEmpty() )         // sampai tumpukan kosong,
        {                                   // hapus item dari tumpukan
            long value = theStack.pop();
            System.out.println(value);      // tampilkan
            System.out.println(" ");
        } // end while
        System.out.println("");
    } // end main()
} // end class StackApp
////////////////////////////////////////////////////////////////////////////////