
package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;


public class GraphTESTcode {

    
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("fileQ1.txt");
        Graph g=new Graph();
        g.read_from_file(file);
        g.printGraph();
       

    }
    
}
