
package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

public class BluePRGraph extends Graph{

    @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
    
     return new Line(source, destination, weight, weight*5); 
   
    }

    @Override
     public Vertex createVertex(String label) {
        return new Office(label); 
    }
    
}
