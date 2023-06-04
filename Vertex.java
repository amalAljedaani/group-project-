
package GraphFramework;

import java.util.LinkedList;


public class Vertex {
    
     public String Label ;
     boolean isVisited;
     LinkedList<Edge> adjLists=new LinkedList<>();
    
    public Vertex (String Label){
        this.Label = Label;
    }

    public   String getLabel() {
        return Label;
    }
    
    public String display_info (){
        return Label;
        
    }
  
   
    public boolean isVisited(String Label) {
        return Label == this.Label;
    }

    public LinkedList<Edge> getAdjLists() {
        return adjLists;
    }
    
    public void displayInfo() {
        System.out.println("Vertex "+Label);
    
}
}
