
package PhoneNetworkApp;

import GraphFramework.*;
import java.io.File;
import java.io.FileNotFoundException;

public class PhoneNWDesignApp extends BluePRGraph {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("fileQ1.txt");
        
        BluePRGraph g = new BluePRGraph();
        g.read_from_file(file);

        MSTAlgorithm kruskalAlgorithm = new KruskalAlg(g);

        // Print the edges in Kruskal's minimum spanning tree     
        kruskalAlgorithm.displayResultingMST();

        // Run Prim's algorithm to get the minimum spanning tree
        MSTAlgorithm primAlgorithm = new MHPrimAlg(g);

        // Print the edges in Prim's minimum spanning tree
        primAlgorithm.displayResultingMST();
   
       

        //------------------------------------------------------------------------------------
        BluePRGraph g2 = new BluePRGraph();

        System.out.println("\n\n");
        g2.makeGraph(10000, 25000);
         MSTAlgorithm kruskalAlgorithm1 = new KruskalAlg(g2);

        // Print the edges in Kruskal's minimum spanning tree     
        kruskalAlgorithm1.displayResultingMST();

        // Run Prim's algorithm to get the minimum spanning tree
        MSTAlgorithm primAlgorithm1 = new MHPrimAlg(g2);

        // Print the edges in Prim's minimum spanning tree
        primAlgorithm1.displayResultingMST();
   
       


      
    }

}
