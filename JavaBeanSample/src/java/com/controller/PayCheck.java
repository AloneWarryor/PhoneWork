/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.biz.Cart;
import com.biz.CartItem;
import com.entity.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinhc
 */
@WebServlet(name = "PayCheck", urlPatterns = {"/PayCheck"})
public class PayCheck extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (!request.getParameter("btnConfirm").trim().isEmpty()) {
                Connection conn = new DBContext().getConnection();
                String id = request.getParameter("Customer");
                String payCheck = request.getParameter("txtPayMethod");
                Cart cart = (Cart)request.getSession().getAttribute("Cart");
                List<CartItem> cartItems = cart.getItems();
                String sqlQuerry = "Insert into [dbo].[OrderTBL] ([OrderDate], [CustomerID], [payment]) Values (GETDATE(),'" + id + "',N'" + payCheck + "');";
                PreparedStatement statement  = conn.prepareStatement(sqlQuerry, Statement.RETURN_GENERATED_KEYS);
                int affectedRow = statement.executeUpdate();
                if (affectedRow == 0) {
                    out.print("Error in action with Database!");
                    throw new Exception();
                }
                ResultSet rs = statement.getGeneratedKeys();
                rs.next();
                long idT = rs.getLong(1);
                rs.close();
                out.print("<p>You ordered");
                out.print("<table border=\"1\" cellspaceing=\"0\">");
                out.print("<tr>\n<th>Product ID</th><th>Product Name</th><th>Unit Price</th>\n<th>Quantity</th><th>Amount</th>\n</tr>");
                for (CartItem cartItem : cartItems) {
                    out.print(" <tr>    \n" +
"                    <td>"+cartItem.getId()+"</td><td>:"+cartItem.getName()+"</td><td>"+cartItem.getPrice()+"</td>\n" +
"                    <td>"+cartItem.getQuantity()+"</td><td>"+cartItem.getAmount()+"</td>\n" +
"                </tr>");
                    conn.prepareStatement("insert [dbo].[OrderlineTBL] ([OrderID], [ProductID], [Quantity], [UnitPrice]) values (" + idT + "," + cartItem.getId() + "," + cartItem.getQuantity()+ "," + cartItem.getPrice()+ ")").executeUpdate();
                }
                rs = conn.prepareStatement("Select * from [dbo].[OrderTBL] where OrderID=" + idT).executeQuery();
                rs.next();
                DateFormat df = new SimpleDateFormat();
                out.print("</table><p>Order ID: "+  idT + "<p>Time: " + df.format(rs.getDate("OrderDate")));
            }
        } catch (Exception ex) {
            Logger.getLogger(PayCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
