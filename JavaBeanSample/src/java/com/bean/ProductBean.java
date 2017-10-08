/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.Product;
import com.entity.DBContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinhc
 */
public class ProductBean {

    private int page, pageSize;
    
    public ProductBean() {
        page = 0;
        pageSize = 5;
    }

    public ProductBean(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getTotalPage () throws Exception {
        return 1 + getTotalRow()/ pageSize;
    }
    
    public int getTotalRow() throws Exception {
        int rows = 0;
        String query = "SELECT COUNT(*) from ProductTBL "; 
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        if(rs.next()) rows = rs.getInt(1);
        rs.close();
        conn.close();
        return rows;
    }
    
    public List<Product> getProducts () throws Exception {
        if (page == 0) {
            page = 1;
        }
        if (pageSize == 0) {
            pageSize = 0;
        }
        int from = (page - 1) * pageSize + 1;
        int to = page * pageSize;
        List<Product> products = new ArrayList<>();
        String query = "{call GetProducts(?,?)}"; 
        Connection conn = new DBContext().getConnection();
        CallableStatement cs = conn.prepareCall(query);
        cs.setInt(1, from);
        cs.setInt(2, to);
        ResultSet rs = cs.executeQuery();
        while(rs.next()) {
            int productID = rs.getInt("productID");
            String productName = rs.getString("productName");
            double unitPrice = rs.getDouble("unitPrice");
            products.add(new Product(productID, productName, unitPrice));
        }
        rs.close();
        conn.close();
        return products; 
    }
}
