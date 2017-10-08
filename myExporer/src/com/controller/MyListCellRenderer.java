/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Dx2
 */
public class MyListCellRenderer extends DefaultListCellRenderer{
    private FileSystemView fileSystemView;

    private JLabel label;

    MyListCellRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        File file = (File)value;
        label.setIcon(fileSystemView.getSystemIcon(file));
        label.setText(fileSystemView.getSystemDisplayName(file));
        label.setToolTipText(file.getPath());

        if (isSelected) {
            label.setBackground(Color.GRAY);
        } else {
            label.setBackground(Color.WHITE);
        }

        return label;
    }

    
}
