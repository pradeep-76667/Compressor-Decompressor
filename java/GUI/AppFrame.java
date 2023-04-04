/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com_decomp.compressor;
import com_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author welcome
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        compressButton = new JButton("Select files to compress");
        compressButton.setBounds(40,150,200,50);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select files to decompress");
        decompressButton.setBounds(40,150,200,50);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible(true);
        
    }    
    
    
@Override
    public void actionPerformed (ActionEvent e){
       if(e.getSource()== compressButton){
           JFileChooser filechooser = new JFileChooser();
           int response = filechooser.showSaveDialog(null);
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               try{
                   compressor.method(file);
               }
               catch(IOException ee){
                   JOptionPane.showMessageDialog(null,ee.toString());
               }
           }
       } 
       if(e.getSource()== decompressButton){
           JFileChooser filechooser = new JFileChooser();
           int response = filechooser.showSaveDialog(null);
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               try{
                   decompressor.method(file);
               }
               catch(IOException ee){
                   JOptionPane.showMessageDialog(null,ee.toString());
               }
           }
       } 
    } 
  }
