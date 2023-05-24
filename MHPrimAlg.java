
package GraphFramework;

import java.util.*;


public class MHPrimAlg extends MSTAlgorithm{
    private Graph graph;
   // private List<Edge> mst;

    public MHPrimAlg(Graph graph) {
        super(graph);
        this.graph = graph;
      //  this.mst = new ArrayList<>();
        prim();
    }

    private void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        Set<Vertex> visited = new HashSet<>();
        Vertex start = graph.getVertices().get(0);
        visited.add(start);
        pq.addAll(getEdgesFrom(start));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            Vertex u = edge.getSource();
            Vertex v = edge.getDestination();
            if (!visited.contains(v)) {
                visited.add(v);
                MSTResultList.add(edge);
                pq.addAll(getEdgesFrom(v));
            }
        }
    }

    private List<Edge> getEdgesFrom(Vertex vertex) {
        List<Edge> edgesFrom = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            if (edge.getSource().equals(vertex) || edge.getDestination().equals(vertex)) {
                edgesFrom.add(edge);
            }
        }
        return edgesFrom;
    }

    public List<Edge> getMST() {
        return MSTResultList;
    }

    @Override
    public void displayResultingMST() {
        int cost=0;
      for(Edge e: MSTResultList){
          System.out.println( e.display_info());
          cost+=e.getWeight();
      }
        System.out.println("total cost is: "+cost);
      
    }
    
   
    
}

