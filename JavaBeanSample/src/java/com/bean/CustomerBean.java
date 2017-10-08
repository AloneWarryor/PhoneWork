/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.Customer;
import com.entity.DBContext;
import com.entity.Order;
import com.entity.OrderT;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vinhc
 */
public class CustomerBean {

    public CustomerBean() {
    }
    
    private String id = "";
    private int pid = 0;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public List<Customer> getCustomers () throws Exception {
        List<Customer> customers = new ArrayList<>();
        String query = "select * from CustomerTBL "; 
        try (Connection conn = new DBContext().getConnection()) {
            ResultSet rs = conn.prepareStatement(query).executeQuery();
            while(rs.next()) {
                String id = rs.getString("CustomerID");
                String name = rs.getString("CustomerName");
                customers.add(new Customer(id, name));
            }
            rs.close();
        }
        return customers; 
    }
    
    public List<Order> getOrders() throws Exception {
        List<Order> order = new ArrayList<>();
        String query = "select * from OrderTBL where CustomerID='"+id+"'"; 
        try (Connection conn = new DBContext().getConnection()) {
            ResultSet rs = conn.prepareStatement(query).executeQuery();
            while(rs.next()) {
                int orderID = rs.getInt("OrderID");
                Date orderDate = rs.getDate("OrderDate");
                String customerID = rs.getString("CustomerID");
                String payment = rs.getString("payment");
                order.add(new Order(orderID, orderDate, customerID, payment));
            }
            rs.close();
        }
        return order; 
    }
    public List<OrderT> getOrdersPD() throws Exception {
        List<OrderT> order = new ArrayList<>();
        String query = "select * from OrderLineTBL where OrderID="+pid; 
        try (Connection conn = new DBContext().getConnection()) {
            ResultSet rs = conn.prepareStatement(query).executeQuery();
            while(rs.next()) {
                int myid = rs.getInt("OrderID");
                int pdid = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("Unitprice");
                order.add(new OrderT(myid, pdid, quantity, price));
            }
            rs.close();
        }
        return order; 
    }
}
