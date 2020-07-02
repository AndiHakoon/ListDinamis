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

package StrukturData16.directed_graph;

/**
 * @author Andi
 * 
 */
public class TopoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('G'); // 6
        theGraph.addVertex('H'); // 7
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 5); // CF
        theGraph.addEdge(3, 6); // DG
        theGraph.addEdge(4, 6); // EG
        theGraph.addEdge(5, 7); // FH
        theGraph.addEdge(6, 7); // GH
        theGraph.topo(); // do the sort
    }

}

class Vertex
{
    public char label;          // label (e.g. 'A')
    //-----------------------------------------------
    public Vertex(char lab)     // constructor
    {label = lab;}
} // end class vertex
/////////////////////////////////////////////////////////
class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];     // list of vertices
    private int adjMat[][];          // adjacency matrix
    private int nVerts;              // current number of vertices
    private char sortedArray[];
    //--------------------------------------------------
    public Graph()
    {
        vertexList = new Vertex[MAX_VERTS];
    // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency
        {
            for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
            {
                adjMat[j][k] = 0;
            }
        }
        sortedArray = new char[MAX_VERTS]; // sorted vert labels
    } // end constructor
    // -------------------------------------------------------------
    public void addVertex(char lab)
    {
       vertexList[nVerts++] = new Vertex(lab);
    }
    //--------------------------------------------------------------
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
    }
    //--------------------------------------------------------------
    public void displayVertex(int v)
    {
        System.out.println(vertexList[v].label);
    }
    //--------------------------------------------------------------
    public void topo()
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
    //--------------------------------------------------------------
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
    public void deleteVertex(int delVert)
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
    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }
// -------------------------------------------------------------

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
// -------------------------------------------------------------
}           