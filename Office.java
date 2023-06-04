/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhoneNetworkApp;

import GraphFramework.Vertex;

/**
 *
 * @author deemf
 */
public class Office extends Vertex {

    public Office(String Label) {
        super(Label);
    }

    @Override
    public String display_info() {
        return "Office No." + super.display_info(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
