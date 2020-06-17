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

package StrukturData16;

/**
 * @author Andi
 * 
 */
class StackX
{
private final int SIZE = 20;
private int[] st;
private int top;
// -------------------------------------------------------------
public StackX() // constructor
    {
        st = new int[SIZE]; // make array
        top = -1;
    }
// -------------------------------------------------------------

    public void push(int j) // put item on stack
    {
        st[++top] = j;
    }
// -------------------------------------------------------------

    public int pop() // take item off stack
    {
        return st[top--];
    }
// -------------------------------------------------------------

    public int peek() // peek at top of stack
    {
        return st[top];
    }
// -------------------------------------------------------------

    public boolean isEmpty() // true if nothing on stack
    {
        return (top == -1);
    }
// -------------------------------------------------------------
} // end class StackX

class Queue
{
private final int SIZE = 20;
private int[] queArray;
private int front;
private int rear;
// -------------------------------------------------------------
public Queue() // constructor
    {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }
// -------------------------------------------------------------

    public void insert(int j) // put item at rear of queue
    {
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }
// -------------------------------------------------------------

    public int remove() // take item from front of queue
    {
        int temp = queArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }
// -------------------------------------------------------------

    public boolean isEmpty() // true if queue is empty
    {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
// -------------------------------------------------------------
} // end class Queue
////////////////////////////////////////////////////////////////
class Vertex {

    public char label; // label (e.g. ‘A’)
    public boolean wasVisited;
// -------------------------------------------------------------

    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
    }
// -------------------------------------------------------------
} // end class Vertex

////////////////////////////////////////////////////////////////
class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
    }
    
    public void addVertex(char label){
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    
    public void display() {
        System.out.println("Adjecency: ");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < row; col++) {
                if (adjMat[row][col] == 1) {
                    System.out.println(
                    "row: "+row+", "+vertexList[row].label +
                            " -- " +
                            vertexList[col].label+" "+"Col: "+col+".");
                }
            }
        }
        System.out.println("");
    }
    
    public void dfs() {
        System.out.println("Visit by using" + 
                " DFS algorithm:");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {            
            int v = getAdjUnvisitedVertex(
                    theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        System.out.println("");
    }
    
    public void bfs() {
        System.out.println("Visit by using"
                + " BFS algorithm: ");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2
                    = getAdjUnvisitedVertex(v1))
                    != -1) {
                vertexList[v2].wasVisited
                        = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        System.out.println("");
        resetFlags();
    }

    
    public void displayVertex(int v){
        System.out.print(vertexList[v].label+" ");
    }
    
    public int getAdjUnvisitedVertex(int v){
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 &&
                vertexList[i].wasVisited == false) 
            {
                return i;
            }
        }
        return -1;
    }
    
    public void resetFlags() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}//end class Graph

public class GraphApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph theGraph = new Graph();
        theGraph.addVertex('A');// 0
        theGraph.addVertex('B');// 1
        theGraph.addVertex('C');// 2
        theGraph.addVertex('D');// 3
        theGraph.addVertex('E');// 4
        
        theGraph.addEdge(0, 1);// AB
        theGraph.addEdge(1, 2);// BC
        theGraph.addEdge(0, 3);// AD
        theGraph.addEdge(3, 4);// DE
        
        theGraph.addEdge(4, 3);// ED
        theGraph.addEdge(2, 3);// CD
        theGraph.display();
        
        theGraph.dfs();
        theGraph.bfs();
        
    }

}
