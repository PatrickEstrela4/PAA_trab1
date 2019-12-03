/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_trab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author patri
 */
public class Arquivos {

    private String string;

    public Arquivos() {
        this.string = "";
    }

    public String abrirArquivo() throws FileNotFoundException {
        //public void abrirArquivo() throws FileNotFoundException {

        int matriz[][] = null;

        JFileChooser fc = new JFileChooser();

        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            Scanner elem = new Scanner(fc.getSelectedFile());

            while (elem.hasNext()) {
                string = string + elem.next();

            }

        }

        return string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    
}
