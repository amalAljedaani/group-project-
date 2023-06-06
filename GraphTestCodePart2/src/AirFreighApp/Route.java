
package AirFreighApp;
import GraphFramework.Edge;
import GraphFramework.Vertex;
public class Route extends Edge{
    int length;
    public Route(Vertex source, Vertex destination, int weight, int length) {
        super(source, destination, weight);
        this.length=length;
    }
     public int getLength() {
        return length;
    }
    
    @Override
    public void display_info() {
        System.out.print(getLength()+" - loc.");    }
}
