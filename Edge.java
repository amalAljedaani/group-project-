
package GraphFramework;


public class Edge {
        //initialize variables
        Vertex source;
        Vertex destination;
        int weight;
        
        //constructor to create an edge taking the 2 vertices and their weights 
        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
       
    public String display_info (){
       return "(--> "+destination.getLabel()+" weight:"+weight+" ) ";
    }
    
}
