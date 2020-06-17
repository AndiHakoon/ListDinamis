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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andi
 */
public class GraphTest {
    
    public GraphTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addVertex method, of class Graph.
     */
    @Test
    public void testAddVertex() {
        System.out.println("addVertex");
        char label = ' ';
        Graph instance = new Graph();
        instance.addVertex(label);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEdge method, of class Graph.
     */
    @Test
    public void testAddEdge() {
        System.out.println("addEdge");
        int start = 0;
        int end = 0;
        Graph instance = new Graph();
        instance.addEdge(start, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of display method, of class Graph.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        Graph instance = new Graph();
        instance.display();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dfs method, of class Graph.
     */
    @Test
    public void testDfs() {
        System.out.println("dfs");
        Graph instance = new Graph();
        instance.dfs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bfs method, of class Graph.
     */
    @Test
    public void testBfs() {
        System.out.println("bfs");
        Graph instance = new Graph();
        instance.bfs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayVertex method, of class Graph.
     */
    @Test
    public void testDisplayVertex() {
        System.out.println("displayVertex");
        int v = 0;
        Graph instance = new Graph();
        instance.displayVertex(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdjUnvisitedVertex method, of class Graph.
     */
    @Test
    public void testGetAdjUnvisitedVertex() {
        System.out.println("getAdjUnvisitedVertex");
        int v = 0;
        Graph instance = new Graph();
        int expResult = 0;
        int result = instance.getAdjUnvisitedVertex(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetFlags method, of class Graph.
     */
    @Test
    public void testResetFlags() {
        System.out.println("resetFlags");
        Graph instance = new Graph();
        instance.resetFlags();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
