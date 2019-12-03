/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_trab1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;

/**
 *
 * @author patri
 */
public class NewClass {
    
    
    public void abrirArquivo() throws FileNotFoundException, IOException {
        //public void abrirArquivo() throws FileNotFoundException {

        int matriz[][] = null;

        JFileChooser fc = new JFileChooser();

        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            Scanner elem = new Scanner(fc.getSelectedFile());

            Files.readAllLines(fc.getSelectedFile().toPath()).stream().collect(Collectors.joining("\n"));

        }

        //return string;
    }
    
}
