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

package StrukturData8.BracketsApp;

/**
 * @author Andi
 * 
 */
import java.io.*;                 // for I/O
////////////////////////////////////////////////////////////////
class StackX
   {
   private int maxSize;
   private char[] stackArray;
   private int top;
//--------------------------------------------------------------
   public StackX(int s)       // konstruktor
      {
      maxSize = s;
      stackArray = new char[maxSize];
      top = -1;
      }
//--------------------------------------------------------------
   public void push(char j)  // letakkan item di atas stack
      {
      stackArray[++top] = j;
      }
//--------------------------------------------------------------
   public char pop()         // mengambil item dari stack
      {
      return stackArray[top--];
      }
//--------------------------------------------------------------
   public char peek()        // mengintip stack teratas
      {
      return stackArray[top];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true jika stack kosong
      {
      return (top == -1);
      }
//--------------------------------------------------------------
   }  // end class StackX
////////////////////////////////////////////////////////////////
class BracketChecker
   {
   private String input;                   // input string
//--------------------------------------------------------------
   public BracketChecker(String in)        // konstruktor
      { input = in; }
//--------------------------------------------------------------
   public void check()
      {
      int stackSize = input.length();      // mendapatkan panjang maksimal dari stack.
      StackX theStack = new StackX(stackSize);  // membuat stack

      for(int j=0; j<input.length(); j++)  // mendapatkan char dalam giliran
         {
         char ch = input.charAt(j);        // dapatkan char
         switch(ch)
            {
            case '{':                      // membuka simbol
            case '[':
            case '(':
               theStack.push(ch);          // push them
               break;

            case '}':                      // simbol penutup
            case ']':
            case ')':
               if( !theStack.isEmpty() )   // jika stack tidak kosong,
                  {
                  char chx = theStack.pop();  // pop and check
                  if( (ch=='}' && chx!='{') ||
                      (ch==']' && chx!='[') ||
                      (ch==')' && chx!='(') )
                     System.out.println("Error: "+ch+" at "+j);
                  }
               else                        // kosong sebelum waktunya
                  System.out.println("Error: "+ch+" at "+j);
               break;
            default:    // tidak ada aksi pada karakter lain
               break;
            }  // end switch
         }  // end for
      // di titik ini, semua karakter diproses.
      if( !theStack.isEmpty() )
         System.out.println("Error: missing right delimiter");
      }  // end check()
//--------------------------------------------------------------
   }  // end class BracketChecker
////////////////////////////////////////////////////////////////
class BracketsApp
   {
   public static void main(String[] args) throws IOException
      {
      String input;
      while(true)
         {
         System.out.print(
                      "Enter string containing delimiters: ");
         System.out.flush();
         input = getString();     // read a string from kbd
         if( input.equals("") )   // quit if [Enter]
            break;
                                  // make a BracketChecker
         BracketChecker theChecker = new BracketChecker(input);
         theChecker.check();      // check brackets
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
   }  // end class BracketsApp
////////////////////////////////////////////////////////////////

