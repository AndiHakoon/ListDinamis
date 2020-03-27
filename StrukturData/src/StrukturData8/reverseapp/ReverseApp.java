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

package StrukturData8.reverseapp;

/**
 * @author Andi
 * reverseApp
 */
// reverse.java
// stack used to reverse a string
// to run this program: C>java ReverseApp
import java.io.*;                 // for I/O
////////////////////////////////////////////////////////////////
class StackX
   {
   private int maxSize;
   private char[] stackArray;
   private int top;
//--------------------------------------------------------------
   public StackX(int max)    // konstruktor
      {
      maxSize = max;
      stackArray = new char[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void push(char j)  // meletakkan item ke dalam stack
      {
      stackArray[++top] = j;
      }
//--------------------------------------------------------------
   public char pop()         // mengambil item dari stack
      {
      return stackArray[top--];
      }
//--------------------------------------------------------------
   public char peek()        // mengintip stack tertinggi
      {
      return stackArray[top];
      }
//--------------------------------------------------------------
   public boolean isEmpty()  // true jika stack kosong
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   }  // end class StackX
////////////////////////////////////////////////////////////////
class Reverser
   {
   private String input;                // input string
   private String output;               // output string
//--------------------------------------------------------------
   public Reverser(String in)           // kosntruktor
      { input = in; }
//--------------------------------------------------------------
   public String doRev()                // membalikkan string
      {
      int stackSize = input.length();   // mendapatkan input max dari stackSize
      StackX theStack = new StackX(stackSize);  // membuat stack

      for(int j=0; j<input.length(); j++)
         {
         char ch = input.charAt(j);     // mendapatkan char dari input
         theStack.push(ch);             // push it
         }
      output = "";
      while( !theStack.isEmpty() )
         {
         char ch = theStack.pop();      // pop a char,
         output = output + ch;          // append to output
         }
      return output;
      }  // end doRev()
//--------------------------------------------------------------
   }  // end class Reverser
////////////////////////////////////////////////////////////////
class ReverseApp
   {
   public static void main(String[] args) throws IOException
      {
      String input, output;
      while(true)
         {
         System.out.print("Enter a string: ");
         System.out.flush();
         input = getString();          // membaca string dari kbd
         if( input.equals("") )        // keluar jika ditekan [Enter]
            break;
                                       // make a Reverser
         Reverser theReverser = new Reverser(input);
         output = theReverser.doRev(); // use it
         System.out.println("Reversed: " + output);
         }  // end while
      }  // end main()
//--------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
//--------------------------------------------------------------
   }  // end class ReverseApp
////////////////////////////////////////////////////////////////
