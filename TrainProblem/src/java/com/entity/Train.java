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
public class Train implements Serializable {
    private String trainCode;
    private String routeID;

    public Train() {
    }

    public Train(String trainCode, String routeID) {
        this.trainCode = trainCode;
        this.routeID = routeID;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }
    
    
}
