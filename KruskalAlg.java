
package GraphFramework;

import java.util.*;


public class KruskalAlg extends MSTAlgorithm{

    private Graph graph;
    private List<Edge> mst;

    public KruskalAlg(Graph graph) {
        super(graph);
        this.graph = graph;
        this.mst = new ArrayList<>();
        kruskal();
    }

    private void kruskal() {
        DisjointSet disjointSet = new DisjointSet(graph.getVertices());
        List<Edge> sortedEdges = new ArrayList<>(graph.getEdges());
        Collections.sort(sortedEdges, Comparator.comparing(Edge::getWeight));
        for (Edge edge : sortedEdges) {
            Vertex u = edge.getSource();
            Vertex v = edge.getDestination();
            if (!disjointSet.find(u).equals(disjointSet.find(v))) {
                disjointSet.union(u, v);
                mst.add(edge);
            }
        }
    }

    public List<Edge> getMST() {
        return mst;
    }
    
    @Override
    public List<Edge> displayResultingMST() {
        return mst;
    }
    
}

class DisjointSet {
    private Map<Vertex, Vertex> parent;
    private Map<Vertex, Integer> rank;

    public DisjointSet(List<Vertex> vertices) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for (Vertex vertex : vertices) {
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    public Vertex find(Vertex vertex) {
        if (!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    public void union(Vertex u, Vertex v) {
        Vertex rootU = find(u);
        Vertex rootV = find(v);
        if (rootU.equals(rootV)) {
            return;
        }
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
    
