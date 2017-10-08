/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Button;
import com.entity.counter;
import com.gui.GUI;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vinhc
 */
public class Controller {
    private JPanel gridPannel;
    private GUI mainGui;
    private int count;
    private long time;
    private JButton [][] listButton;
    private counter cter;


    public Controller(JPanel gridPannel, GUI mainGui) {
        this.count = 0;
        this.time = -1;
        this.gridPannel = gridPannel;
        this.mainGui = mainGui;
        initPannel(3, 3);
    }

    public void initPannel (int x, int y) {
        //init gridPannel
        this.gridPannel.removeAll();
        this.gridPannel.setLayout(new GridLayout(x, y));
        //set ActionListener for "start" button
        mainGui.getjButton1().addActionListener((e) -> {
            start();
        });
        //init listButton and default value
        int z = 1;
        this.listButton = new JButton[x][y];
        for (int i = 0; i < this.listButton.length; i++) {
            for (int j = 0; j < this.listButton[0].length; j++) {
                //create new button and add actionListner to it. 
                //Pass i,j and this controller to it cuz we need it to call moveAround function later.
                this.listButton[i][j] = new JButton();
                this.listButton[i][j].addActionListener(new Button(i, j, this));
                if (i == x-1 && j == y-1) {// if it's the last one then we don't give it ""
                    this.listButton[i][j].setText("");
                }   else this.listButton[i][j].setText(z+"");
                this.gridPannel.add(this.listButton[i][j]);//put button to pannel
                z++;
            }
        }
        this.gridPannel.setSize(240, 227);
    }
    
    //Take x, y as input. moveAround function will check is it possible to move
    //value of button[x][y] to another nearby.
    //This function only work if programs started by check time value.
    public void moveAround(int x, int y) {
        if (time > -1) {
            if (x-1 >= 0 && listButton[x-1][y].getText().trim().isEmpty()) {
                listButton[x-1][y].setText(listButton[x][y].getText());
                listButton[x][y].setText("");
                count++;
            } else if (x+1 < listButton.length && listButton[x+1][y].getText().trim().isEmpty()) {
                listButton[x+1][y].setText(listButton[x][y].getText());
                listButton[x][y].setText("");
                count++;
            } else if (y + 1 < listButton.length && listButton[x][y+1].getText().trim().isEmpty()) {
                listButton[x][y+1].setText(listButton[x][y].getText());
                listButton[x][y].setText("");
                count++;
            } else if (y - 1 >= 0 && listButton[x][y-1].getText().trim().isEmpty()) {
                listButton[x][y-1].setText(listButton[x][y].getText());
                listButton[x][y].setText("");
                count++;
            }
            //update count each time click and whatever player finished the game or not
            setCount();
            check();
        }
    }
    
    public void setCount() {
        mainGui.getjLabel2().setText("Move: " + count);
    }
    
    public boolean check() {
        int z = 1;
        for (int i = 0; i < this.listButton.length; i++) {
            for (int j = 0; j < this.listButton[0].length; j++) {
                if (i == this.listButton.length-1 && j == this.listButton[0].length-1) {
                    if (!this.listButton[i][j].getText().isEmpty()) {
                        return false;
                    }
                }   else if (this.listButton[i][j].getText().compareToIgnoreCase(z+"")!=0) {
                    return false;
                }
                z++;
            }
        }
        //if check is true then display a congratulation dialog contain move and time
       //stop counter
       if (cter != null && cter.isAlive()) {
            cter.setStopped(true);
        }
        JOptionPane.showMessageDialog(null, "You finished game by " + this.count + " move(s)\n in " + this.time + " sec(s)", "congratulation: ", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public void randoness(int x) {//swap randomly
        Random r = new Random();
        for (int i = 0; i < listButton.length; i++) {
            for (int j = 0; j < listButton[0].length; j++) {
                int a = r.nextInt(x);
                int b = r.nextInt(x);
                String tmp =  listButton[i][j].getText();
                listButton[i][j].setText( listButton[a][b].getText());
                 listButton[a][b].setText(tmp);
            }
        }
    }
    //set time to time value and display it in GUI
    public void setTime(long time) {
        this.time = time;
        mainGui.getjLabel1().setText("Time: " + time);
    }
    
    public void start() {
        //check if a counter is running then stop it;
        if (cter != null && cter.isAlive()) {
            cter.setStopped(true);
        }
        //reset and init pannel for newgame
        count = 0;
        setCount();
        cter = new counter(this);
        int tmp  = mainGui.getjComboBox1().getSelectedIndex() + 3;
        initPannel(tmp,tmp);
        randoness(tmp);
        time = 0;
        cter.start();
    }
}
