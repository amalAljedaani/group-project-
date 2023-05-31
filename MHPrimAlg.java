
package GraphFramework;

import java.util.*;

public class MHPrimAlg extends MSTAlgorithm{
    public MHPrimAlg(Graph graph) {
        super(graph); // Call the constructor of the superclass
    }

    // Override the method in the superclass to implement Prim's algorithm
    @Override
    public List<Edge> displayResultingMST() {
        MSTResultList = new ArrayList<>(); // Initialize the list to store the resulting MST
        Set<Vertex> visited = new HashSet<>(); // Initialize the set to store the visited vertices
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight)); // Initialize the min-heap to store the edges
        Vertex startVertex = graph.getVertices().get(0); // Choose the starting vertex
        visited.add(startVertex); // Add the starting vertex to the set of visited vertices

        while (visited.size() < graph.getVertices().size()) { // Loop until all vertices have been visited
            List<Edge> outgoingEdges = getOutgoingEdges(visited); // Get all outgoing edges from visited vertices
            for (Edge edge : outgoingEdges) { // Add all outgoing edges to the min-heap
                minHeap.offer(edge);
            }

            Edge minEdge = minHeap.poll(); // Get the minimum-weight edge from the min-heap
            Vertex nextVertex = minEdge.getDestination(); // Get the destination vertex of the minimum-weightedge

            if (!visited.contains(nextVertex)) { // If the destination vertex has not been visited
                visited.add(nextVertex); // Add the destination vertex to the set of visited vertices
                MSTResultList.add(minEdge); // Add the minimum-weight edge to the list of edges in the MST
            }
        }

        return MSTResultList; // Return the list of edges in the MST
    }

    // Helper method to get all outgoing edges from visited vertices
    private List<Edge> getOutgoingEdges(Set<Vertex> visited) {
        List<Edge> outgoingEdges = new ArrayList<>();
        for (Edge edge : graph.getEdges()) { // Loop through all edges in the graph
            Vertex source = edge.getSource();
            Vertex destination = edge.getDestination();
            if (visited.contains(source) && !visited.contains(destination)) { // If the source vertex has been visited and the destination vertex has not been visited
                outgoingEdges.add(edge); // Add the edge to the list of outgoing edges
            }
        }
        return outgoingEdges; // Return the list of outgoing edges
    }
    
    // Getter method to get the list of edges in the MST
    public List<Edge> getMST() {
        return MSTResultList;
    }
    
}

