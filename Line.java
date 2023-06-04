/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

/**
 *
 * @author deemf
 */
public class Line extends Edge {

    int length;

    public Line(Vertex source, Vertex destination, int weight, int length) {
        super(source, destination, weight);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void display_info() {
        super.display_info();
        System.out.println(" : line length: " + getLength());
    }

}
