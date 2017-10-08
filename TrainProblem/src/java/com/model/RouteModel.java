/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Route;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinhc
 */
public class RouteModel {
    //get information of routes
    
    public List<Route> select (String criteria) throws Exception {
        List<Route> routes = new ArrayList<>();
        String query = "select * from Routes " + criteria; 
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while(rs.next()) {
            int routeID = rs.getInt("RouteID");
            String routeName = rs.getString("RouteName");
            routes.add(new Route(routeID, routeName));
        }
        rs.close();
        conn.close();
        return routes; 
    }
            
    
    //add a new Route
    public boolean addRoute(Route r) throws Exception{
        String query = "insert Routes values ("+r.getRouteID()+","+r.getRouteName()+")"; 
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        return true;
    }
    
    //remove a Route
    public boolean removeRoute(Route r) throws Exception{
        String query = "delete from Routes where RouteID = "+r.getRouteID()+" and RouteName = "+r.getRouteName(); 
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        return true;
    }
    //update information of a Route
    public boolean updateRoute(Route r) throws Exception{
        String query = "update from Routes set RouteID = "+r.getRouteID()+" RouteName = "+r.getRouteName(); 
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        return true;
    }
    
    public String getName(int id) throws Exception{
        String query = "select * form Routes where RouteID = " + id;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();        
        rs.next();
        String tmp = rs.getString("RouteName");
        return tmp;
    }
}
