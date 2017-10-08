/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Train;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinhc
 */
public class TrainModel {
     public List<Train> select (String criteria) throws Exception {
        List<Train> trains = new ArrayList<>();
         RouteModel mydude = new RouteModel();
        String query = "select * from TrainCodes " + criteria; 
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while(rs.next()) {
            String trainID = mydude.getName(rs.getInt("RouteID"));
            String trainName = rs.getString("TrainCode");
            trains.add(new Train(trainName, trainID));
        }
        rs.close();
        conn.close();
        return trains; 
    }
     
     public void add (String criteriam, int blabal) throws Exception {
        String query = "insert into TrainCodes values ('"+criteriam+"',"+blabal+")"; 
        Connection conn = new DBContext().getConnection();
        conn.prepareStatement(query).executeUpdate();
        conn.close();
    }
}
