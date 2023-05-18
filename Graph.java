
package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    private int verticesno;
    private int edgesno ;
    private  boolean isDigrap;
    List <Vertex> verticess=new ArrayList<Vertex>(); 
    
    
    public void addEdge(Vertex source, Vertex destination, int weight) { 

       source.adjLists.add(new Edge(source, destination, weight) );
       
        if(isDigrap == false) { // undirected (add the source vertex to the adjacent list of the target vertex)
            destination.adjLists.add(new Edge(destination,source, weight) ); // directed (assigns the target vertex to the adjacent list of the source vertex)
            edgesno += 2;
        }
        else {
            edgesno++;
        }
        
       
    }
    
    public void printGraph() {


        for (int i = 0; i < verticess.size(); i++) {
            
            System.out.print(verticess.get(i).getLabel()+": ");
            for (int j = 0; j < verticess.get(i).adjLists.size(); j++) {
              
                System.out.print(verticess.get(i).adjLists.get(j).display_info());
            }
            System.out.println("");
        }
        
        System.out.println("edges number:"+edgesno+" vertices number:"+verticesno);
    }


    public  void read_from_file (File file) throws FileNotFoundException{
        Scanner myReader = new Scanner(file);
        int  Enum=0; 
        String label;
        
        // graph type 
        if(myReader.next().equalsIgnoreCase("digraph")){
            // 0 >> undirected (directed=false)
            if(myReader.nextInt()==0){
              isDigrap=false;
            }else{
             // 1>> directed (directed=true)
                isDigrap=true;
            }
        }
      ////////////////////////////////////
        // vertices number, edges number 
        verticesno=myReader.nextInt();
        Enum=myReader.nextInt();
        
      ////////////////////////////////////
        // read edges, add or find vertex 
        while(myReader.hasNext()){
            // for the index, -1 >> this index dose not have vlaue 
            int find,index1=-1, index2=-1;
            
            // to read 2 vertex 
            for (int i = 0; i < 2; i++) {
                label=myReader.next();
                
                if(verticess.isEmpty()){
                  verticess.add(new Vertex(label));
                  index1=SearchVertex(label,verticess);
                }else{
                  find=SearchVertex(label,verticess);
                     
                     if(find>=0){
                       //this vertex is exist in the list, no need to create new vertex
                       // find the index of this vertex then assign it to the index 
                         if(index1 == -1){index1=find;}
                         else{index2=find;}
                     }else{
                      // this vertex dose not exist in the list, create new vertex and assign the index 
                         verticess.add(new Vertex(label));
                         if(index1 == -1){index1=SearchVertex(label,verticess);}
                         else{index2=SearchVertex(label,verticess);}
                     }
                }
            }
            
            System.out.println(index1+" "+index2);
            
            // read weight of the edge 
            int weight=myReader.nextInt();
            
            // call method addEdge 
            addEdge(verticess.get(index1),verticess.get(index2),weight);        
          
            
        }// end while 
            }
    
    public int SearchVertex(String label, List<Vertex> vertices){
        for(Vertex ver: vertices){
          if(ver.getLabel().equalsIgnoreCase(label)){
             return verticess.indexOf(ver);
          }
        }
    // vertex dose not exist in the list
    return -1;
    }
         
}