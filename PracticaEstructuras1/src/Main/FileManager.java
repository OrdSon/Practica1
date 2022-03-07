/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author ordson
 */
public class FileManager {

    public String readFile(String ruta) {

        File archivo = new File(ruta);
        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();

            while (linea != null) {
                contenido += linea + "\n";
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return contenido;
    }
    
    public String getContentFromArray(Apuesta[] apuestas){
        StringBuilder contenido = new StringBuilder("");
        for (Apuesta apuesta : apuestas) {
            if (apuesta != null && apuesta.isRechazo() == false) {
                contenido.append(apuesta.toString()+"\n");
            }
        }
        return contenido.toString();
    }
    
    public String getBadContentFromArray(Apuesta[] apuestas){
        StringBuilder contenido = new StringBuilder("");
        for (Apuesta apuesta : apuestas) {
            if (apuesta != null && apuesta.isRechazo() == true) {
                contenido.append(apuesta.toString()+"\n");
            }
        }
        return contenido.toString();
    }

    public void exportFile(String nombre, String contenido) {

        File archivo = new File(nombre);
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(archivo, true));
            pw.println(contenido);
            pw.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }
}
