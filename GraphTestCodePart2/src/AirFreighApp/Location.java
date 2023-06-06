/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreighApp;
import GraphFramework.Vertex;
public class Location extends Vertex {
    private String city;
    public Location(String city) {
        super(city);
    }

    public String getCity() {
        return city;
    }
    
    @Override
    public void displayInfo() {
        System.out.print(" city ");
}
}