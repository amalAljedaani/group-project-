
package GraphFramework;


public class Edge implements Comparable<Edge>{
    Vertex source; // Declare an instance variable to store the source vertex of the edge
    Vertex destination; // Declare an instance variable to store the destination vertex of the edge
        Vertex parent;
    int weight; // Declare an instance variable to store the weight of the edge
    
    // Constructor to create a new edge with the specified source vertex, destination vertex, and weight
    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source; // Set the source vertex of the edge
        this.destination = destination; // Set the destination vertex of the edge
        this.weight = weight; // Set the weight of the edge
    }

    // Getter method to retrieve the source vertex of the edge
    public Vertex getSource() {
        return source;
    }

    // Setter method to set the source vertex of the edge
    public void setSource(Vertex source) {
        this.source = source;
    }

    // Getter method to retrieve the destination vertex of the edge
    public Vertex getDestination() {
        return destination;
    }

    // Setter method to set the destination vertex of the edge
    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    // Getter method to retrieve the weight of the edge
    public int getWeight() {
        return weight;
    }

    // Setter method to set the weight of the edge
public void setWeight(int weight) {
        this.weight = weight;
    }
        
    // Method to display information about the edge
   public void display_info (){
             System.out.print( source.display_info()+" - "+destination.display_info());
    }
   
   // used in prim class to compare edges weight
   @Override
        public int compareTo(Edge other) {
            return Integer.compare(weight, other.weight);
        }

    
}
