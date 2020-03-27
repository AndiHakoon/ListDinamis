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

// package StrukturData9.Infix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andi
 */
class StackX
{
    private int maxSize;
    private char[] stackArray;
    private int top;
//------------------------------------------------------------------------------
    public StackX(int s)                    // konstruktor
    {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }
//------------------------------------------------------------------------------
    public void push(char j)                // meletak item ke atas tumpukan
    { stackArray[++top] = j;}
//------------------------------------------------------------------------------
    public char pop()                       // mengambil item dari atas tumpukan
    { return stackArray[top--];}
//------------------------------------------------------------------------------
    public char peek()                      // mengintip tumpukan teratas
    { return stackArray[top];}
//------------------------------------------------------------------------------
    public boolean isEmpty()                // true jika tumpukan kosong
    { return (top == -1);}
//------------------------------------------------------------------------------
    public int size()                       // return ukuran array
    { return top+1;}
//------------------------------------------------------------------------------
    public char peekN(int n)                // return item array indeks ke N 
    { return stackArray[n];}
//------------------------------------------------------------------------------
    public void displayStack(String s)
    {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print( peekN(i) );
            System.out.print(' ');
        }
        System.out.println("");
    }
//------------------------------------------------------------------------------    
} // end of class StackX
////////////////////////////////////////////////////////////////////////////////
class InToPost
{
    private StackX theStack;
    private String input;
    private String output = "";
//------------------------------------------------------------------------------
    public InToPost(String in)              // constructor
    {
        input = in;
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }
//------------------------------------------------------------------------------
    public String doTrans()                 // do translation to postfix
    {
        for (int i = 0; i < input.length(); i++) 
        {
            char ch = input.charAt(i);
            theStack.displayStack("For "+ch+" "); // *diagnostic*
            switch(ch)
            {
                case '+':                   // untuk + atau -
                case '-':
                    gotOper(ch, 1);         // pergi ke operasi pop
                    break;                  // (presendens 1)
                case '*':                   // untuk * atau /
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':                   // ini adalah left paren
                    theStack.push(ch);      // push it
                    break;
                case ')':                   // ini adalah right paren
                    gotParen(ch);
                    break;
                default:                    // harus berupa operand
                    output += ch;           // tuliskan ke output
                    break;
            } // end switch
        } // end for
        while (!theStack.isEmpty())         // pop remaining opers 
        {            
            theStack.displayStack("While "); // *diagnostic*
            output += theStack.pop();        //  tuliskan ke output
        }
        theStack.displayStack("End ");       // *diagnostic*
        return output;
    } // end doTrans()
//------------------------------------------------------------------------------
    public void gotOper(char opThis, int prec1)
    {                                       // dapat operator dari input
        while(!theStack.isEmpty())
        {
            char opTop = theStack.pop();
            if (opTop == '(') {             // jika itu adalah '('
                theStack.push(opTop);       // kembalikan ')'
                break;
            }
            else
            {
                int prec2;                  // presedens operator baru
                
                if (opTop == '+' || opTop == '-') // mencari operator prec baru 
                    prec2 = 1;
                else 
                    prec2 = 2;
                if(prec2 < prec1)                  // jika prec operator baru kecil
                {                                  // dari prec sebelumnya
                    theStack.push(opTop);          // simpan yang terbaru - popped up
                    break;
                }
                else                               // prec yang baru tidak lebih kecil
                    output += opTop;               // dari prec yang sebelumnya
            }   // end else (ini merupakan operator)
        } // end while
        theStack.push(opThis);                     // push operator baru
    }   // end gotOp()
//------------------------------------------------------------------------------
    public void gotParen(char ch)
    {                                              // mengambil right paren dari input
        while (!theStack.isEmpty()) {            
            char chx = theStack.pop();
            if (chx == '(')                        // jika keluar '('
                break;                             // selesai
            else                                   // jika keluar operator
                output += chx;                     // keluarkan 
        }   // end while
    }   // end popOps()
//------------------------------------------------------------------------------
} // end class InToPost
////////////////////////////////////////////////////////////////////////////////
class InfixApp
{
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {            
            System.out.println("Enter infix: ");
            System.out.flush();
            input = getString();            // membaca string dari kbd
            if (input.equals(""))           // quit if [enter]
                break;
                                            // membuat penerjemah
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();    // lakukan translasi
            System.out.println("Postfixnya adalah "+ output + '\n');
        } // end while
    } // end main()
//------------------------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//------------------------------------------------------------------------------    
} // end class InfixApp
////////////////////////////////////////////////////////////////////////////////