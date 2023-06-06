/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import AirFreighApp.*;
import java.util.*;

/**
 *
 * @author deemf
 */

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    private Location v;
    private Route e;
    private Vertex sourceVertex;
    private List<Edge> edges=new ArrayList<>();

    public SingleSourceSPAlg(Graph graph, Vertex sourceVertex) {
        super(graph);
        this.sourceVertex = sourceVertex;
       
    }

    @Override
    public void computeDijkstraBasedAlg(){
        //Used in DBAllSourcesAl
    }
    @Override
    public void computeDijkstraAlg() {
         for (int i = 0; i < graph.verticess.size(); i++) {
            edges.addAll(graph.verticess.get(i).getAdjLists());
        }
        
        // Print the source vertex label and the start of the routes output
        System.out.println("The starting point location is " + sourceVertex.getLabel());
        System.out.println("The routes from location " + sourceVertex.getLabel() + " to the rest of the locations are:");

        // Initialize variables
        Map<Vertex, Integer> distances = new HashMap<>();
        Map<Vertex, Vertex> predecessors = new HashMap<>();
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Initialize
        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
            predecessors.put(vertex, null);
        }
        distances.put(sourceVertex, 0);
        minHeap.offer(sourceVertex);

        // Compute shortest paths using Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            Vertex current = minHeap.poll();

            for (Edge edge : graph.getAllEdges(current)) {
                Vertex neighbor = edge.getDestination();
                int distance = distances.get(current) + edge.getWeight();

                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    predecessors.put(neighbor, current);
                    minHeap.offer(neighbor);
                }
            }
        }

        // Display
        boolean pathsFound = false; // This is to check if any paths exist from the source

        for (Vertex destination : graph.getVertices()) {
            if (!destination.equals(sourceVertex) && distances.get(destination) != Integer.MAX_VALUE) {
                if (!pathsFound) {
                    pathsFound = true;
                }

                // Print the path info for the current destination vertex
                System.out.print("loc. " + sourceVertex.getLabel() + ":");
                Vertex current = destination;
                List<Vertex> path = new ArrayList<>();

                while (current != null) {
                    path.add(current);
                    current = predecessors.get(current);
                }

                Collections.reverse(path);

               int routeLength = 0;
                for (int i = 1; i < path.size(); i++) {
                    Vertex vertex = path.get(i);
                    Edge edge = graph.getEdges(vertex,edges);
                    routeLength += edge.getWeight();
                    vertex.displayInfo();
                    edge.display_info();
                    System.out.print(vertex.getLabel() + ":");

                    e=(Route) edge;
                    v=(Location) vertex;
                    if (i != path.size() - 1) {
                        System.out.print("");
                    }
                }
                v.displayInfo();
                System.out.print(e.getLength());
                System.out.println(" --- route length: " + routeLength);
            }
        }

        // Print a message if no paths detected
        if (!pathsFound) {
            System.out.println("No paths detected");
        }

        System.out.println();
    }
}

