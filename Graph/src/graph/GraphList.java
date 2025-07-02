/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author DELL
 */
public class GraphList {

    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list to represent the graph

    public GraphList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int start, int end) {
        adjacencyList[start].add(end); // Add edge from start to end
        adjacencyList[end].add(start); // Add edge from end to start (for undirected graph)
    }
    // Method to remove an edge between two vertices

    public void removeEdge(int start, int end) {
        adjacencyList[start].remove(Integer.valueOf(end)); // Remove edge from start to end
        adjacencyList[end].remove(Integer.valueOf(start)); // Remove edge from end to start (for undirected graph)
    }

    // Method to print the adjacency list representation of the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " -> ");
            }
            System.out.println("null");
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices]; // Array to track visited vertices
        LinkedList<Integer> queue = new LinkedList<>(); // Queue for BFS
        queue.add(start); // Enqueue the starting vertex
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex
            System.out.print(vertex + " ");
            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(); // Print a new line after BFS traversal
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices]; // Array to track visited vertices
        Stack<Integer> stack = new Stack<>(); // Stack for DFS
        stack.push(start);
        while (!stack.isEmpty()) {
            int vertex = stack.pop(); // Pop a vertex from the stack
            if (visited[vertex] == false) {
                System.out.println(vertex + " ");
                visited[vertex] = true; // Mark the vertex as visited
            }
            for (int neighbor : adjacencyList[vertex]) {
                if (visited[neighbor] == false) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        System.out.println(); // Print a new line after DFS traversal
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(5); // Create a graph with 5 vertices
        graph.addEdge(0, 1); // Add an edge between vertex 0 and 1  
        graph.addEdge(1, 2); // Add an edge between vertex 1 and 2
        graph.addEdge(2, 3); // Add an edge between vertex 2 and 3
        graph.addEdge(3, 4); // Add an edge between vertex 3 and 4
        graph.printGraph(); // Print the adjacency list representation of the graph
        graph.removeEdge(1, 2); // Remove the edge between vertex 1 and 2
        System.out.println("After removing edge 1-2:");
        graph.printGraph(); // Print the adjacency list after removing the edge
        System.out.println("BFS starting from vertex 0:");
        graph.bfs(0); // Perform BFS starting from vertex 0
        System.out.println("DFS starting from vertex 0:");
        graph.dfs(0); // Perform DFS starting from vertex 0
    }

}
