/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;

/**
 *
 * @author Vinhc
 */
public class Route implements Serializable{
    
    private int routeID;
    private String routeName;
    
    public Route() {
    }

    public Route(int routeID, String routeName) {
        this.routeID = routeID;
        this.routeName = routeName;
    }
    
    

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    
    
    
}
