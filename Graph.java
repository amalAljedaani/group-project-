
package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    //initialize variables 
    private int verticesno;
    private int edgesno ;
    private  boolean isDigrap; 
    List <Vertex> verticess=new ArrayList<Vertex>(); //create a list of vertices
    
    
    public void addEdge(Vertex source, Vertex destination, int weight) { //method created to add new edges

       source.adjLists.add(new Edge(source, destination, weight) ); //assigns the target vertex to the adjacent list of the source
       
        if(isDigrap == false) { // undirected (add the source vertex to the adjacent list of the target vertex)
            destination.adjLists.add(new Edge(destination,source, weight) ); 
            edgesno += 2; // add two edges sence theres no direction 
        }
        else {
            edgesno++; //if the graph is directed then add 1 edge only 
        }
        
       
    }
    
    public void printGraph() {


        for (int i = 0; i < verticess.size(); i++) { // for the number of vertices do the next 
            
            System.out.print(verticess.get(i).getLabel()+": "); // print the current vertex
            for (int j = 0; j < verticess.get(i).adjLists.size(); j++) { // for the whole adjaceny list of the current vertex do the following 
              
                System.out.print(verticess.get(i).adjLists.get(j).display_info()); // print all connected vertices 
            }
            System.out.println(""); 
        }
        
        System.out.println("edges number:"+edgesno+" vertices number:"+verticesno); //print the number of edges  
    }


    public  void read_from_file (File file) throws FileNotFoundException{ // method to read vertices and their edges from a giver file 
        //initialize variables
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
                
                if(verticess.isEmpty()){ //if the list of vertices is empty, then add the current vertex 
                  verticess.add(new Vertex(label));
                  index1=SearchVertex(label,verticess); 
                }else{
                  //confirm wheather the vertex already exists in the list or not   
                  find=SearchVertex(label,verticess);
                     
                     if(find>=0){ 
                       //this vertex exists in the list, no need to create new vertex
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
