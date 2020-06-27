/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ListaCircularDoble.ListaCircularDoble;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scarlet Espinoza
 */
public class LecturaEscritura {
    
    public static ListaCircularDoble<String> leerVideos(){
        ListaCircularDoble<String> video=new ListaCircularDoble();
        try(BufferedReader br = new BufferedReader(new FileReader("src/recursos/videos.txt"))){
            String linea;
            while((linea=br.readLine())!=null){
                video.addLast(linea);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaEscritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaEscritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return video;
    }
    
}
