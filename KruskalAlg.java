
package GraphFramework;

import java.util.*;


public class KruskalAlg extends MSTAlgorithm {

    private Graph graph;
    private List<Edge> mst;

    // Constructor
    public KruskalAlg(Graph graph) {
        super(graph);
        this.graph = graph;
        this.mst = new ArrayList<>();
        kruskal(); // Call Kruskal's algorithm to compute the MST
    }

    // Kruskal's algorithm implementation
    private void kruskal() {
        // Initialize disjoint set data structure for vertices
        DisjointSet disjointSet = new DisjointSet(graph.getVertices());
        
        // Create a list of all edges and sort them by weight
        List<Edge> sortedEdges = new ArrayList<>(graph.getEdges());
        Collections.sort(sortedEdges, Comparator.comparing(Edge::getWeight));

        // Iterate through sorted edges and perform union-find operations
        for (Edge edge : sortedEdges) {
            Vertex u = edge.getSource();
            Vertex v = edge.getDestination();
            // If the vertices are not in the same set, union them and add the edge to the MST
            if (!disjointSet.find(u).equals(disjointSet.find(v))) {
                disjointSet.union(u, v);
                mst.add(edge);
            }
        }
    }

    // Getter for the MST
    public List<Edge> getMST() {
        return mst;
    }

    // Display the resulting MST (Required by the MSTAlgorithm abstract class)
    @Override
    public List<Edge> displayResultingMST() {
        return mst;
    }

}

// DisjointSet class for union-find operations
class DisjointSet {
    private Map<Vertex, Vertex> parent; // Map to store the parent of each vertex
    private Map<Vertex, Integer> rank; // Map to store the rank of each vertex

    // Constructor
    public DisjointSet(List<Vertex> vertices) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        // Initialize each vertex as its own parent with rank 0
        for (Vertex vertex : vertices) {
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    // Find operation with path compression
    public Vertex find(Vertex vertex) {
        // If the vertex is not its own parent, find the root and compress the path
        if (!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    // Union operation with rank-based merging
    public void union(Vertex u, Vertex v) {
        Vertex rootU = find(u); // Find the root of the set containing u
        Vertex rootV = find(v); // Find the root of the set containing v

        // If the roots are already the same, return (already in the same set)
        if (rootU.equals(rootV)) {
            return;
        }

        // Merge the sets based on rank
        if (rank.get(rootU) < rank.get(rootV)) {
            parent.put(rootU, rootV);
        } else if (rank.get(rootU) > rank.get(rootV)) {
            parent.put(rootV, rootU);
        } else {
            parent.put(rootV, rootU);
            rank.put(rootU, rank.get(rootU) + 1);
        }
    }
}
    
