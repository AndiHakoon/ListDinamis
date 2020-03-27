package StrukturData10.queue;


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
 *
 * @author Andi
 */
class Queue
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
//-------------------------------------------------------------------
    public Queue(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;  
    }
//-------------------------------------------------------------------
    public void insert(long j)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }
//-------------------------------------------------------------------    
    public long remove()
    {
        long temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }
//-------------------------------------------------------------------
    public long peekFront()
    {
        return queArray[front];
    }
//-------------------------------------------------------------------
    public boolean isEmpty()
    {
        return (nItems==0);
    }
//-------------------------------------------------------------------
    public boolean isFull()
    {
        return (nItems==maxSize);
    }
//-------------------------------------------------------------------
    public int size()
    {
        return nItems;
    }
//-------------------------------------------------------------------
    public void looping(int banyak){
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
        System.out.println("Masukkan array sebanyak "+banyak); 
    for (int i = 0; i < banyak; i++) {
        try {
            this.insert(Integer.parseInt(br.readLine()));
        } catch (IOException | NumberFormatException e) {
        }
            System.out.println("error");
        }
    }
//-------------------------------------------------------------------
    public int ArraySize(){
        return maxSize;
    }
//-------------------------------------------------------------------
    public void display()
    {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(queArray[i]+" \t");
        }
        System.out.println("");
    }
}// end class Queue
public class QueueApp {
    public static void main(String[] args) throws IOException {
        Queue theQueue = new Queue(5);
        System.out.println("Panjang Array : "+theQueue.ArraySize());
        int banyak = 0;
        System.out.print("Masukkan banyak array: ");
        banyak = getInt();
        theQueue.looping(banyak);
        theQueue.display();
        
        System.out.print("Dihapus berapa? ");
        banyak = getInt();
        for (int i = 0; i < banyak; i++) {
          theQueue.remove();
        }
        
        System.out.print("Masukkan banyak array: ");
        banyak = getInt();
        theQueue.looping(banyak);
        
        while(!theQueue.isEmpty())
        {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
    
    public static int getInt() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int i =  Integer.parseInt(br.readLine());
        return i;
    }
}
