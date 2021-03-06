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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    
    
    public static  List<sintoma> cargarSintomas(){
        List<sintoma> lista = new LinkedList<>();
        String filename ="src/Archivos/sintomas.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String linea=null;
            while((linea=br.readLine())!=null){
                String[] info =linea.split("\\|");
                lista.add(new sintoma(info[0],Integer.valueOf(info[1]),info[2]));
            }
            //return lista;
        } catch (IOException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     public static LinkedList<paciente> leerCliente(){
        String filename ="src/Archivos/formularioPaciente.txt";
        LinkedList<paciente> pacientes = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String linea;
            while((linea=br.readLine())!=null){
                
                String[] data =linea.split(",");
                pacientes.add(new paciente(data[0],data[1],data[2],Integer.parseInt(data[3]),data[4],Integer.valueOf(data[5]),data[6]));
            }
        } catch (IOException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
    public static ArrayList<Medico> leerDoctor(){
        String filename ="src/Archivos/doctores.txt";
        ArrayList<Medico> medicos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String linea;
            while((linea=br.readLine())!=null){
                
                String[] data =linea.split(",");
                medicos.add(new Medico(data[0],data[1],data[2],data[3]));
                
            }
        } catch (IOException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
}
