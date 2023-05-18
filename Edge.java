
package GraphFramework;


public class Edge {
        Vertex source;
        Vertex destination;
        int weight;

        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    public String display_info (){
       return "(--> "+destination.getLabel()+" weight:"+weight+" ) ";
    }
    
}
