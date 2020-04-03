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

package StrukturData10.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Andi_Irham
 * @author Hakkan_Syukri
 * 
 */

class Queues
{
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;
//-------------------------------------------------------------------
    public Queues(int s)
    {
        maxSize = s;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;  
    }
//-------------------------------------------------------------------
    public void insert(String j)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }
//-------------------------------------------------------------------    
    public String remove()
    {
        String temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        System.out.println(queArray[front]+" keluar Antrian !");
        return temp;
    }
//-------------------------------------------------------------------
    public void removeloop(int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.println("Satu per satu keluar antrian");
            this.remove();
            this.display();
        }
    }
//-------------------------------------------------------------------
    public String peekFront()
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
    public void looping(int banyak) throws IOException{
    int i=0;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    System.out.println("Masukkan array sebanyak "+banyak+"\t");
    while(!this.isFull()) {
            if (i<banyak) {
            System.out.print("Isi ke-"+(i+1)+" : ");
            this.insert(br.readLine());
            i++;
            }else{
                System.err.println("Full");
            }    
        }
    }
//-------------------------------------------------------------------
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

public class QueueStringApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int p, n;
        System.out.print("Panjang Array : "); p = in.nextInt();
        Queues queue = new Queues(p);
        System.out.println("Masukkan Array sebanyak ");n = in.nextInt();
        queue.looping(n);
        
        
    }

}
