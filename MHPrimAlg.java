
package GraphFramework;

import java.util.*;


public class MHPrimAlg extends MSTAlgorithm{
    public MHPrimAlg(Graph graph) {
        super(graph);
    }

    
    @Override
    public List<Edge> displayResultingMST() {
        MSTResultList = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        Vertex startVertex = graph.getVertices().get(0);
        visited.add(startVertex);

        while (visited.size() < graph.getVertices().size()) {
            List<Edge> outgoingEdges = getOutgoingEdges(visited);
            for (Edge edge : outgoingEdges) {
                minHeap.offer(edge);
            }

            Edge minEdge = minHeap.poll();
            Vertex nextVertex = minEdge.getDestination();

            if (!visited.contains(nextVertex)) {
                visited.add(nextVertex);
                MSTResultList.add(minEdge);
            }
        }

        return MSTResultList;
    }

    private List<Edge> getOutgoingEdges(Set<Vertex> visited) {
        List<Edge> outgoingEdges = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            Vertex source = edge.getSource();
            Vertex destination = edge.getDestination();
            if (visited.contains(source) && !visited.contains(destination)) {
                outgoingEdges.add(edge);
            }
        }
        return outgoingEdges;
    }
    
    public List<Edge> getMST() {
        return MSTResultList;
    }
    
}


