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
package StrukturData16.undirected_graf;

/**
 * @author Andi
 * BP : 1911082006
 * UAS Struktur Data
 * Materi : Graf
 */
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
        
        theGraph.addEdge(0, 2);// AC
        theGraph.addEdge(1, 0);// BA
        theGraph.addEdge(1, 4);// BE
        theGraph.addEdge(3, 4);// DE
        theGraph.addEdge(4, 2);// EC
        theGraph.display();
        theGraph.dfs();
        theGraph.topo();
    }
}

class StackX
{
    private int maxSize;            // ukuran dari tumpukan (stack) array
    private int[] stackArray;       // ukuran array;
    private int top;                // array teratas
//-------------------------------------------------------------------
    public StackX(int s)            // constructor
    {
        maxSize = s;            // menyetel ukuran array
        stackArray = new int[maxSize]; // membuat array
        top = -1;               // tidak ada item
    }
//-------------------------------------------------------------------
    public void push(int j)         // memasukkan item ke tumpukan
    {stackArray[++top] = j;}        // increment top, insert item
//-------------------------------------------------------------------
    public int pop()                // mengambil item dari tumpukan teratas
    { return stackArray[top--];}    // akses item, decrement top
//-------------------------------------------------------------------
    public int peek()               // mengintip stack teratas
    {return stackArray[top];}
//-------------------------------------------------------------------
    public boolean isEmpty()        // true jika stack kosong
    {return (top == -1);}
//-------------------------------------------------------------------
    public void display()
    {while(!isEmpty()) System.out.println(pop()+" ");}
//-------------------------------------------------------------------    
} // end class StackX
////////////////////////////////////////////////////////////////

class Queue {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //-------------------------------------------------------------------
    public Queue(int s)                 // constructor
    {
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //-------------------------------------------------------------------
    public void insert(int j)           // adding queue
    {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }
    //-------------------------------------------------------------------    
    public int remove()                 // remove queue list
    {
        int temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }
    //-------------------------------------------------------------------
    public int peekFront()              // peek front
    {return queArray[front];}
    //-------------------------------------------------------------------
    public boolean isEmpty()            // is queue empty?
    {return (nItems == 0);}
    //-------------------------------------------------------------------
    public boolean isFull()             // is queue full?
    {return (nItems == maxSize);}
    //-------------------------------------------------------------------
    public int size()                   // getting queue size 
    {return nItems;}
} //end class queue
////////////////////////////////////////////////////////////////

class Vertex                            // Class Vertex 
{
    public char label; // label (e.g. ‘A’)
    public boolean wasVisited;
// -------------------------------------------------------------
    public Vertex(char lab)             // constructor
    {
        label = lab;
        wasVisited = false;
    }
// -------------------------------------------------------------
} // end class Vertex

//////////////////////////////////////////////////////////////////////

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    private Queue theQueue;
    private char sortedArray[];

    public Graph()                              // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX(MAX_VERTS);
        theQueue = new Queue(MAX_VERTS);
        sortedArray = new char[MAX_VERTS]; // sorted vert labels
    }
    //--------------------------------------------------------------------------
    public void addVertex(char label)           // adding Vertex
    {
        vertexList[nVerts++] = new Vertex(label);
    }
    //--------------------------------------------------------------------------
    public void addEdge(int start, int end)     // adding Edge
    {
        adjMat[start][end] = 1;
        // adjMat[end][start] = 1; this make a un-directed graf
    }
    //--------------------------------------------------------------------------
    public void display()                       // displaying matrices
    {
        System.out.println("Matrices:");
        for (int row = 0; row < nVerts; row++) {
            if(row == 0) System.out.print("x ");
            System.out.print(vertexList[row].label+" ");
        }
        System.out.println();
        for (int row = 0; row < nVerts; row++) {
            System.out.print(vertexList[row].label+" ");
            for (int col = 0; col < nVerts; col++) {
                System.out.print(adjMat[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println("");
        
        System.out.println("Adjecency: ");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < nVerts; col++) {                            // ubah col < row menjadi col < nverts untuk membuat simetri
                if (adjMat[row][col] == 1) {
                    System.out.println(
                    "row: "+row+", "+vertexList[row].label +
                            " --> " +
                            vertexList[col].label+" "+"Col: "+col+".");
                }
            }
        }
        System.out.println("");
    }
    //--------------------------------------------------------------------------
    public void dfs()                           // Depth-field Sorting
    {
        System.out.println("Connectivity table");
        for (int row = 0; row < nVerts; row++) {
            System.out.print(vertexList[row].label+" ");
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col]==1) {
                    System.out.print(vertexList[col].label+" ");
                    getAdjUnvisitedVertex(col);
                }
            }
            resetFlags();
            System.out.println("");
        }
        System.out.println("");
    }
    //--------------------------------------------------------------------------
    public void bfs()                           // Breath-first Sorting
    { 
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
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        System.out.println("");
        resetFlags();
    }
    //--------------------------------------------------------------------------
    public void mst()                           // Minimum Spanning Tree
    {
    System.out.println("Minimum spanning" +
                       " tree: ");
    vertexList[0].wasVisited = true;
    theStack.push(0);
    while (!theStack.isEmpty()) {
        int currentVertex = theStack.peek();        
        int v = getAdjUnvisitedVertex(
                            currentVertex);
        if (v == -1) {
            theStack.pop();
        } else {
            vertexList[v].wasVisited = true;            
            theStack.push(v);
     
            displayVertex(currentVertex);
            System.out.print(" -- ");
            displayVertex(v);
            System.out.println("");
       }
    }
    resetFlags();
    } 
    //--------------------------------------------------------------------------
    public void displayVertex(int v)            // Show Vertex Labels
    {
        System.out.print(vertexList[v].label+" ");
    }
    //--------------------------------------------------------------------------
    public int getAdjUnvisitedVertex(int v)     // getting Unvisited Vetex
    {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }
    //--------------------------------------------------------------------------
    public void resetFlags()                    // Resetting Flags
    {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }
    //--------------------------------------------------------------------------
    public void topo()                          // Topological Sorting
    {
        int orig_nVerts = nVerts; // mengingat berapa banyak verticle
        
        while(nVerts > 0) // while verticles remain,
        {
            // get a vertex with no succesors, or -1
            int currentVertex = noSuccessors();
            if (currentVertex == -1)        // must be a cycle 
            {
                System.out.println("Error: Graph has cycles");
                return;
            }
            // insert vertex label in sorted array (start at end)
            sortedArray[nVerts-1] = vertexList[currentVertex].label;
            
            deleteVertex(currentVertex); // delete vertex
        } // end while
        
        // vertices all gone; display sorted array
        System.out.println("Topological sorted order: ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.println(sortedArray[i]);
        }
    }
    //--------------------------------------------------------------------------
     public int noSuccessors()           // return vert with no successors
    {                                   // (or -1 if no susch verts)
        boolean isEdge;     // edge from row to column in adjMat
        
        for (int row = 0; row < nVerts; row++)  // for each vertex, 
        {
            isEdge =false;                      // check edges
            for (int col = 0; col < nVerts; col++) 
            {
                if (adjMat[row][col] > 0)       // if edge to 
                {                               // another,
                    isEdge = true;
                    break;                      // this vertex
                }                               // has a successor
            }                                   // trye another
            if (!isEdge)                        // if no edges,
            return row;                         //    has no successors
        }
        return -1;                              // no such vertex
    } // end noSuccessors()
    //--------------------------------------------------------------
    public void deleteVertex(int delVert)       // Delete Vertex
    {
        if (delVert != nVerts-1)                // if no last vertex, 
        {
            for (int j = delVert; j < nVerts-1; j++) 
                vertexList[j] = vertexList[j+1];
                                        // delete from adjMat
            for (int row = delVert; row < nVerts-1; row++) 
                moveRowUp(row, nVerts);
                                        // delete col from adjMat
            for (int col = delVert; col < nVerts; col++)
                moveColLeft(col, nVerts-1);
        }
        nVerts--;                       // one less vertex
    } //end deleteVertex
    //-------------------------------------------------------------
    private void moveRowUp(int row, int length) // Moving Row index up
    {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }
    //-------------------------------------------------------------
    private void moveColLeft(int col, int length)   // Moving Column Index up
    {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
    //-------------------------------------------------------------
}//end class Graph