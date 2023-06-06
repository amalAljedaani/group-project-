/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphFramework;
import java.util.*;
public abstract class ShortestPathAlgorithm {
    public Graph graph; // Declare a variable to store the graph
    public List<Edge> DAlgorithm; // Declare a variable to store the resulting MST
    
    public ShortestPathAlgorithm(Graph graph) {
        this.graph = graph; // Assign the graph to the variable
        this.DAlgorithm= new ArrayList<>(); 
    }
   
   public abstract void computeDijkstraAlg(); // Abstract method to display the resulting MST
   
   public abstract void computeDijkstraBasedAlg();
}
