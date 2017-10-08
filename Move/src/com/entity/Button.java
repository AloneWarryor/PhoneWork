/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Vinhc
 */
public class Button implements ActionListener{
    private int x;
    private int y;
    private Controller con;

    public Button(int x, int y, Controller con) {
        this.x = x;
        this.y = y;
        this.con = con;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(x + ":" + y); // for debug purpose
        con.moveAround(x, y);//pass x, y to move function and try to move value of this button
        return;
    }
    
}
