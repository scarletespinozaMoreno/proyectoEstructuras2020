/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import clases.LecturaEscritura;
import clases.Medico;
import clases.puesto;
import clases.turno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author scarlet Espinoza
 */
public class VentanaAdministarPuesto {
    private BorderPane rootAdministrar;
    private Label titulo,cedula,nombre,apellido,puesto,texto,profesion;
    private TextField fieldtitulo,fieldcedula,fieldnombre,fieldapellido,fieldpuesto,fieldprofesion;
    private Button Buscar,Asignar,Eliminar,Limpiar;
    public VentanaAdministarPuesto() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        rootAdministrar=new BorderPane();
        rootAdministrar.setStyle("-fx-background-color: #FFFFFF;");
        rootAdministrar.setTop(crearTop());
        rootAdministrar.setLeft(crearLeft());
        rootAdministrar.setBottom(crearBottom());
    }
    public Pane crearTop(){
         VBox arriba=new VBox();
         arriba.setPadding(new Insets(25,20,20,20));
        arriba.setAlignment(Pos.CENTER);
         titulo = new Label("Administrar Puesto");
         titulo.setFont(new Font("Arial Black",19));
         titulo.setTextFill(Color.web("#2E86C1"));
         arriba.getChildren().addAll(titulo);
         return arriba;
         
     }
    
    
    public Pane crearLeft(){
          VBox izquierda=new VBox();
          izquierda.setPadding(new Insets(20,90,20,20)); 
          HBox CedulaMedico =new HBox();
          HBox NombreMedico =new HBox();
          HBox ApellidoMedico =new HBox();
          HBox PuestoMedico =new HBox();
           HBox ProfesionMedico =new HBox();
          ProfesionMedico.setSpacing(33);
          ProfesionMedico.setPadding(new Insets(10,10,10,10));
          CedulaMedico.setSpacing(40);
          CedulaMedico.setPadding(new Insets(10,10,10,10));
          NombreMedico.setSpacing(33);
          NombreMedico.setPadding(new Insets(10,10,10,10));
          ApellidoMedico.setSpacing(33);
          ApellidoMedico.setPadding(new Insets(10,10,10,10));
          PuestoMedico.setSpacing(45);
          PuestoMedico.setPadding(new Insets(10,10,10,10));
          CedulaMedico.setAlignment(Pos.CENTER);
          NombreMedico.setAlignment(Pos.CENTER);
          ApellidoMedico.setAlignment(Pos.CENTER);
          PuestoMedico.setAlignment(Pos.CENTER);
          texto= new Label("Ingrese cedula del medico a buscar ");
         cedula=new Label("Cedula:");
         nombre= new Label("Nombre:");
         apellido= new Label("Apellido:");
         puesto= new Label("Puesto:");
         fieldcedula= new TextField();
         fieldnombre= new TextField();
         profesion= new Label("Profesion:");
         fieldprofesion= new TextField();
         texto.setPadding(new Insets(10,10,10,10));
         fieldapellido= new TextField();
         fieldpuesto= new TextField();
         ProfesionMedico.getChildren().addAll(profesion,fieldprofesion);
         CedulaMedico.getChildren().addAll(cedula,fieldcedula);
         NombreMedico.getChildren().addAll(nombre,fieldnombre);
         ApellidoMedico.getChildren().addAll(apellido,fieldapellido);
         PuestoMedico.getChildren().addAll(puesto,fieldpuesto);
         izquierda.getChildren().addAll(texto,CedulaMedico,NombreMedico,ApellidoMedico,ProfesionMedico,PuestoMedico);
         
         return izquierda;
                 
    }
    public Pane crearBottom(){
         HBox botones=new HBox();
         VBox abajo= new VBox();
         Buscar= new Button("Buscar");
         Buscar.setOnAction((e)->{
             try {
                 buttonBuscar();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(VentanaAdministarPuesto.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(VentanaAdministarPuesto.class.getName()).log(Level.SEVERE, null, ex);
             }
          
        });
         
         Limpiar= new Button("Limpiar");
         Limpiar.setOnAction((e)->{
         buttonBorrar();
          
        });
        
         Eliminar= new Button("Eliminar");
         Eliminar.setOnAction((e)->{
          buttonEliminar();
          buttonBorrar();
          
        });
         
         
         Asignar= new Button("Asignar");
         Asignar.setOnAction((e)->{
             try {
                 buttonAsignar();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(VentanaAdministarPuesto.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(VentanaAdministarPuesto.class.getName()).log(Level.SEVERE, null, ex);
             }
          
        });
         botones.getChildren().addAll(Buscar,Asignar,Limpiar,Eliminar);
         abajo.getChildren().addAll(botones);
         botones.setSpacing(20);
         botones.setAlignment(Pos.CENTER);
         abajo.setPadding(new Insets(20,20,20,20));
         abajo.setSpacing(20);
         
         abajo.setAlignment(Pos.CENTER);
         return abajo;
         
         
    }
    
     public void buttonBuscar() throws FileNotFoundException, IOException{
         ArrayList<Medico> medicos =LecturaEscritura.leerDoctor();
          ArrayList<puesto> puestos =LecturaEscritura.leerPuesto();
          
        for(Medico m :medicos){
             System.out.println(m);
             if(m.getCedula().equals(fieldcedula.getText())){
                    fieldnombre.setText(m.getNombre());
                    fieldapellido.setText(m.getApellido());
                    fieldprofesion.setText(m.getProfesion());
              }
          for(puesto p : puestos){
                        if(p.getMedico().getCedula().equals(fieldcedula.getText()))
                            fieldpuesto.setText(p.getNombrePuesto());
                    }           
        }
          
    }
     public void buttonAsignar()throws FileNotFoundException, IOException{
         BufferedWriter output=null;
        FileWriter fw =null;
        turno turnos;
        try{
            File file = new File("src/Archivos/formularioPuesto.txt");
            output = new BufferedWriter(new FileWriter(file.getAbsolutePath(),true));
            output.write(fieldcedula.getText()+","+fieldnombre.getText()+","+fieldapellido.getText()+","+
                        fieldprofesion.getText()+","+fieldpuesto.getText());
            output.newLine();
             
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(output!=null)
                    output.close();
                if(fw!=null)
                    fw.close();
            }catch(IOException e){
                e.getMessage();
            }
            
            /*
         BufferedReader file = new BufferedReader(new FileReader("src/Archivos/formularioPuesto.txt"));
                    String line;String input = "";
                    while((line = file.readLine()) != null){
                    if(line.contains(fieldcedula.getText()))
                    input += line.replace("SinAsignar",fieldpuesto.getText()+"\r\n");
                    else
                    input += line+"\r\n";
                    }
                    FileOutputStream fileOut = new FileOutputStream("src/Archivos/formularioPuesto.txt");
                    fileOut.write(input.getBytes());
                    fileOut.close();
         */
     }
        
     }
     public void buttonEliminar(){
   File inputFile = new File("src/Archivos/formularioPuesto.txt");
   File outputFile = new File("src/Archivos/formularioPuesto2.txt");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

    String currentLine;
    while((currentLine=reader.readLine())!= null){
        System.out.println(currentLine);        
        String[] data =currentLine.split(",");   
                if((data[4].equals(fieldpuesto.getText()))){
                    continue;
                }else{
                writer.write(currentLine + System.getProperty("line.separator"));}
            }
    writer.close();
    reader.close();
    String nombre=outputFile.getName();
        System.out.println(nombre);
    inputFile.delete();
    outputFile.renameTo(new File("src/Archivos/formularioPuesto.txt"));

    } catch (IOException e) {
        e.printStackTrace();
    }  
        }
     
       public void buttonBorrar(){
        fieldcedula.setText("");
        fieldnombre.setText("");
        fieldapellido.setText("");
        fieldpuesto.setText("");
        fieldprofesion.setText("");
        
    }

    public Pane getRootAdministrar() {
        return rootAdministrar;
    }

    public void setRootAdministrar(BorderPane  rootAdministrar) {
        this.rootAdministrar =  rootAdministrar;
    }
}
