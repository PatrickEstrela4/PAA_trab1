/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_trab1;

import paa_trab1.JFTabela;

import java.io.FileNotFoundException;

/**
 *
 * @author patri
 */
public class PAA_trab1 {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) throws FileNotFoundException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFTabela().setVisible(true);
            }
        });
        
    }
    
}
