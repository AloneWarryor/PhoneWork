/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.gui.GUI;
import java.awt.Desktop;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Vinhc
 */
public class Controller {    
    private FileSystemView filesystem;
    private DefaultMutableTreeNode root;
    private Desktop desktop;
    private DefaultTreeModel treeModel;
    private GUI gui;
    private File currentFile;
    private JList list;
    private DefaultListModel lst;
    private JPopupMenu rightMenu;
    
    public Controller (GUI gui) {
        //init
        this.list = gui.getjList1();
        lst = new DefaultListModel();
        list.setModel(lst);
        this.gui = gui;
        filesystem = FileSystemView.getFileSystemView();
        desktop = Desktop.getDesktop();
        //init TreeNode and get root dir then put in TreeNode
        try {
            root = new DefaultMutableTreeNode(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ex) {
            root = new DefaultMutableTreeNode("Unknown");
        }
        File [] roots = File.listRoots();
        for (File root1 : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(root1);
            root.add(node);
            File[] node1 = filesystem.getFiles(root1, true);
            for (File file : node1) {
                if (file.isDirectory()) {
                    node.add(new DefaultMutableTreeNode(file));
                }
            }
        }
        //TreeSelectionListener
        TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
                public void valueChanged(TreeSelectionEvent event){
                    //Update selection to JList
                    DefaultMutableTreeNode node =
                        (DefaultMutableTreeNode)event.getPath().getPathComponent(event.getPath().getPathCount() - 1);
                    showChildren(node);
                    showPath(node);
                }
        };
        //TreeWillExpansionListener
        TreeWillExpandListener treeWillExpansionListener = new TreeWillExpandListener() {
            @Override
            public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
                DefaultMutableTreeNode node =
                        (DefaultMutableTreeNode)event.getPath().getPathComponent(event.getPath().getPathCount() - 1);
                    showChildren(node);
            }

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                DefaultMutableTreeNode node =
                        (DefaultMutableTreeNode)event.getPath().getPathComponent(event.getPath().getPathCount() - 1);
                    showChildren(node);
            }
        };
        //config properties for jTree
        treeModel = new DefaultTreeModel(root);
        gui.getjTree1().setModel(treeModel);
        gui.getjTree1().setRootVisible(false);
        gui.getjTree1().setCellRenderer(new FileTreeCellRenderer());
        gui.getjTree1().getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        gui.getjTree1().addTreeSelectionListener(treeSelectionListener);
        gui.getjTree1().addTreeWillExpandListener(treeWillExpansionListener);
        ListSelectionListener listselectionlistener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                File tmp = (File)list.getSelectedValue();
                System.out.println(tmp.getPath());
            }
        };
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setCellRenderer(new MyListCellRenderer());
        list.addListSelectionListener(listselectionlistener);
    }
    private void showChildren(DefaultMutableTreeNode node) {
        gui.getjTree1().setEnabled(false);
        File file = (File) node.getUserObject();
        File[] files = filesystem.getFiles(file, true); //!!
        node.removeAllChildren();
        for (File child : files) {//recusive to load content in all folder (make sure that folder is expanable
            if (child.isDirectory()) {
                DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(child);
                File[] nodeChild = filesystem.getFiles(child, true);
                node.add(node2);
                for (File fileChild : nodeChild) {
                    if (fileChild.isDirectory()) {
                        node2.add(new DefaultMutableTreeNode(fileChild));
                    }
                }
            }
        }
        gui.getjTree1().setEnabled(true);
    }
    private void showPath(DefaultMutableTreeNode node) {
        File file = (File) node.getUserObject();
        File[] files = filesystem.getFiles(file, true); //!!
        lst.removeAllElements();
        for (File file1 : files) {
            lst.addElement(file1);
        }
    }
}
