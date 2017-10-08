/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinhc
 */
public class counter extends Thread {
    long timeS;
    Controller con;
    boolean stopped = false;

    public counter(Controller con) {
        this.con = con;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
    
    @Override
    public void run() {
        timeS = System.currentTimeMillis();//init current time
        while (!stopped) {//running as long as stopped is false
            con.setTime((System.currentTimeMillis() - timeS)/1000);//update time to GUI
            try {
                sleep(1000);//update time after sleep for 1s
            } catch (InterruptedException ex) {
                Logger.getLogger(counter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
