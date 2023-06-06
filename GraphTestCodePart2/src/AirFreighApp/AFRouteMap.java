/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AirFreighApp;
import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
import java.util.List;

public class AFRouteMap extends Graph  {
    Graph graph;
    @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
    
     return new Route(source, destination, weight, weight); 
   
    }

    @Override
     public Vertex createVertex(String label) {
        return new Location(label); 
    }
     
    
}
