
package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
     int verticesno;
     int edgesno ;
      boolean isDigrap;
    List <Vertex> verticess=new ArrayList<>(); 
    List <Edge> edges=new ArrayList<>();
    
    public Vertex createVertex(String label){ 
        return null;
    }
    public Edge createEdge(Vertex source, Vertex destination, int weight){
        return null;
    }
    
    public void makeGraph(int vertexNum, int edgeNum){
        boolean isConnected;
        int weight;
        Random random= new Random(); // Create a random number generator
        verticesno= vertexNum; // Set the number of vertices
        isDigrap= false; // By default, assume the graph is directed

        // Loop through each vertex and add it to the list of vertices
        for(int i=0; i<vertexNum; i++){
            verticess.add(createVertex("O"+i)); // Create a new vertex with a label of the form "O<i>" and add it to the list of vertices
           // System.out.println(verticess.get(i).Label); // Print the label of the vertex
        }

        // Create edges(cont.) between adjacent vertices
        for (int i = 0; i < vertexNum-1; i++) {
            weight= random.nextInt(30)+1; // Generate a random weight between 1 and 30
            addEdge(verticess.get(i),verticess.get(i+1),weight); // Add an edge between each vertex and its neighbor
        }

        int remaining= edgeNum-(vertexNum-1);

        // Create additional edges between randomly selected vertices
        for (int i = 0; i < remaining; i++) {
            Vertex source= verticess.get(random.nextInt(vertexNum));
            Vertex target= verticess.get(random.nextInt(vertexNum));

            isConnected= isConnected(source,target); // Check if an edge already exists between the selected vertices

            weight = random.nextInt(30)+1; // Generate a random weight between 1 and 30

            if(source!= target && isConnected==false){ // If the selected vertices are not the same and an edge does not already exist between them
                addEdge(source, target,weight); // Add an edge between the selected vertices
            }
            else
                i--; // If an edge already exists or the selected vertices are the same, try again with different vertices
        }
    }
    
    public void addEdge(Vertex source, Vertex destination, int weight) { 

       //source.adjLists.add(new Edge(source, destination, weight) );
       
        source.adjLists.add(createEdge(source, destination, weight) );
       
        if(isDigrap == false) { // undirected (add the source vertex to the adjacent list of the target vertex)
            // destination.adjLists.add(new Edge(destination,source, weight) ); // directed (assigns the target vertex to the adjacent list of the source vertex)
            
             destination.adjLists.add(createEdge(destination, source, weight) ); // directed (assigns the target vertex to the adjacent list of the source vertex)
             
            edgesno += 2;
        }
        else {
            edgesno++;
        }
        
        //  edges.add(new Edge(source, destination, weight));      
     // edges.add( createEdge(source,destination,weight));
    }
    
//    public void printGraph() {
//
//
//        for (int i = 0; i < verticess.size(); i++) {
//            
//            System.out.print(verticess.get(i).getLabel()+": ");
//            for (int j = 0; j < verticess.get(i).adjLists.size(); j++) {              
//                System.out.print(verticess.get(i).adjLists.get(j).display_info());
//            }
//            System.out.println("");
//        }
//        
//        System.out.println("edges number:"+edgesno+" vertices number:"+verticesno);
//    }


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
                    
                 // verticess.add(new Vertex(label));
                   verticess.add(createVertex(label));
                   
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
                      
                       // verticess.add(new Vertex(label));                        
                         verticess.add(createVertex(label));
                         
                         if(index1 == -1){index1=SearchVertex(label,verticess);}
                         else{index2=SearchVertex(label,verticess);}
                     }
                }
            }
            
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
    // vertex does not exist in the list
    return -1;
    }
    
//    public List<Vertex> getVertices() {
//        return verticess;
//    }
//
//    public List<Edge> getEdges() {
//       return edges;  
//    }
    
//    public List<Edge> getEdges(Vertex vertex) {
//        List<Edge> vertexEdges = new ArrayList<>();
//        for (Edge edge : edges) {
//            if (edge.getSource().equals(vertex) || edge.getDestination().equals(vertex)) {
//                vertexEdges.add(edge);
//            }
//        }
//        return vertexEdges;
//    }

//    public Edge getEdges(Vertex vertex, Vertex v) {
//        for (Edge edge : edges) {
//            if (edge.getSource().equals(vertex) && edge.getDestination().equals(v)) {
//                return edge;
//            }
//        }
//        return null;
//    }
   
   
    
    public boolean isConnected(Vertex source, Vertex target){
        
        for (int i = 0; i < verticess.size(); i++) {
            edges.addAll(verticess.get(i).adjLists);
        }
        for(Edge edge : edges){
            if((edge.getSource()== source && edge.getDestination()== target) || 
                    edge.getSource()== target && edge.getDestination()== source){
                return true;
            }
        }
        return false;
    }
    
//    public int getNumVertices(){
//        return verticesno;
//    }
}