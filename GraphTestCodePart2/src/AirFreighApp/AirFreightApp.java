/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AirFreighApp;

import GraphFramework.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("fileQ2.txt");

        AFRouteMap g = new AFRouteMap();
        g.read_from_file(file);
        
        Scanner n= new Scanner(System.in);
       

       System.out.println("---------------------------Single Source------------------------------");
       System.out.print("Enter source label: ");
       String lab= n.next();
       boolean check=false;
       
        for (int i = 0; i < g.getNumVertices(); i++) {
            if(lab.equalsIgnoreCase(g.getVertices().get(i).Label)){
                check=true;
                SingleSourceSPAlg singleSourceSPAlg = new SingleSourceSPAlg(g,g.getVertices().get(i));
               // Run Dijkstra's algorithm to find and display the shortest paths from a single source
               singleSourceSPAlg.computeDijkstraAlg();
               break;
            }
        }
       
        if(check==false){
            System.out.println("No Vertex with label "+ lab+ " exists");
        }
       
        
        System.out.println("---------------------------All Sources-------------------------------");
        // Run Dijkstra's algorithm to find and display the shortest paths for all sources
        DBAllSourceSPAlg dBAllSourceSPAlg = new DBAllSourceSPAlg(g);
        dBAllSourceSPAlg.computeDijkstraBasedAlg();

        
        System.out.println("---------------------------Random Graph-------------------------------");
        // Time Start
        long start = System.currentTimeMillis();
        //random graph
        AFRouteMap g2 = new AFRouteMap();
        g2.makeGraph(20, 30);
        
        DBAllSourceSPAlg RandomGraph = new DBAllSourceSPAlg(g2);

        
        RandomGraph.computeDijkstraBasedAlg();
        
        
        
        //time calculations
        long end = System.currentTimeMillis();
        long executeTime = end - start;
        System.out.println("===============Dijkstra==========================");
        System.out.println("executuon time is: " + executeTime);
        System.out.println("=========================================");
        
        
        
    }
}
