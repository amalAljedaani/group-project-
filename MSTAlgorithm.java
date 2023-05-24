
package GraphFramework;


import java.util.*;
public abstract class MSTAlgorithm {
    public Graph graph;
    public List<Edge> MSTResultList; 

    public MSTAlgorithm(Graph graph) {
        this.graph = graph;
        this.MSTResultList= new ArrayList<>();
    }
   
   public abstract List<Edge> displayResultingMST();
   
   
}

