
package GraphFramework;


import java.util.*;
public abstract class MSTAlgorithm {
    public Graph graph; // Declare a variable to store the graph
    public List<Edge> MSTResultList; // Declare a variable to store the resulting MST

    // Consturctor
    public MSTAlgorithm(Graph graph) {
        this.graph = graph; // Assign the graph to the variable
        this.MSTResultList= new ArrayList<>(); // Initialize the list to store the MST
    }
   
   public abstract void displayResultingMST(); // Abstract method to display the resulting MST
   
   public void kruskal(){
       
   }
   public void primeMH_FindMST(){
       
   }
   
   public void displayCost(){
       
   }
}
