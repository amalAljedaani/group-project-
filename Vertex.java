
package GraphFramework;

import java.util.LinkedList;


public class Vertex {
    
     public String Label ;
     boolean isVisited = true;
     LinkedList<Edge> adjLists=new LinkedList<Edge>();
    
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
    
    
}
