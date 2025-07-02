/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

/**
 *
 * @author DELL
 */
public class GraphMatrix {

    private int vertices; // Number of vertices
    private int[][] adjacencyMatrix; // Adjacency matrix to represent the graph

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices]; // Initialize the adjacency matrix
    }

    // Method to add an edge between two vertices
    public void addEdge(int start, int end) {
        this.adjacencyMatrix[start][end] = 1; // Set the edge from start to end
        this.adjacencyMatrix[end][start] = 1; // Set the edge from end to start (for undirected graph)
    }

    // Method to remove an edge between two vertices
    public void removeEdge(int start, int end) {
        this.adjacencyMatrix[start][end] = 0; // Remove the edge from start to end
        this.adjacencyMatrix[end][start] = 0; // Remove the edge from end to start (for undirected graph)
    }

    public void printMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     GraphMatrix graph = new GraphMatrix(5); // Create a graph with 5 vertices
    //     graph.addEdge(0, 1); // Add an edge between vertex 0 and 1
    //     graph.addEdge(1, 2); // Add an edge between vertex 1 and 2
    //     graph.addEdge(2, 3); // Add an edge between vertex 2 and 3
    //     graph.addEdge(3, 4);
    //     graph.printMatrix();
    // }
}
