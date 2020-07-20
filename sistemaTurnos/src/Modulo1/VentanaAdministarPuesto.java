/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;


import static Modulo1.PantallaPrincipal.PUESTO_MEDICO;
import clases.LecturaEscritura;
import clases.Medico;
import clases.puesto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
    private Label titulo,cedula,nombre,apellido,puesto,texto,profesion,mensaje;
    private TextField fieldtitulo,fieldcedula,fieldnombre,fieldapellido,fieldpuesto,fieldprofesion;
    private Button Buscar,Asignar,Eliminar,Limpiar;
    int num =0;
    private final secciones pantallas = new secciones();

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
          mensaje= new Label("");
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
        
         Eliminar= new Button("Puestos");
         Eliminar.setOnAction((e)->{
          try {
                pantallas.pantallaEliminarPuesto();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
          
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
         abajo.getChildren().addAll(botones,mensaje);
         botones.setSpacing(20);
         botones.setAlignment(Pos.CENTER);
         abajo.setPadding(new Insets(20,20,20,20));
         abajo.setSpacing(20);
         
         abajo.setAlignment(Pos.CENTER);
         return abajo;
         
         
    }
    
     public void buttonBuscar() throws FileNotFoundException, IOException{
         
          
        for(Medico m :PantallaPrincipal.MEDICO){
             System.out.println(m);
             if(m.getCedula().equals(fieldcedula.getText())){
                    fieldnombre.setText(m.getNombre());
                    fieldapellido.setText(m.getApellido());
                    fieldprofesion.setText(m.getProfesion());
                    return;
              }
         }  
        
        fieldnombre.setText("");
        fieldapellido.setText("");
        fieldprofesion.setText(" ");
        mensaje.setTextFill(Color.GREEN);
        mensaje.setText("Medico ya esta Asignado");
    }
     public void buttonAsignar()throws FileNotFoundException, IOException{
          Medico m = new Medico(fieldcedula.getText(),fieldnombre.getText(),fieldapellido.getText(),fieldprofesion.getText());
          eliminarMedico(PantallaPrincipal.MEDICO, m);
          puesto p =new puesto(new Medico(fieldcedula.getText(),fieldnombre.getText(),fieldapellido.getText(),fieldprofesion.getText()),fieldpuesto.getText());
               if(!listaContienePuesto(PantallaPrincipal.PUESTO_MEDICO, p)){
                     
                      PantallaPrincipal.PUESTO_MEDICO.add(new puesto(new Medico(fieldcedula.getText(),fieldnombre.getText(),fieldapellido.getText(),fieldprofesion.getText()),fieldpuesto.getText()));
                     mensaje.setTextFill(Color.GREEN);
                     mensaje.setText("Medico Asignado");
                    }
               
                }
     
     private void eliminarMedico(ArrayList<Medico> medicos,Medico m){
         ListIterator<Medico> it= medicos.listIterator();
          while(it.hasNext()){
                      Medico medico= it.next();
                      System.out.println("hola");
                    if(medico.getCedula().equals(m.getCedula())){
                        it.remove();
                        System.out.println("entro");
                       
                    }
                }
                
         
     }
    private boolean listaContienePuesto(LinkedList<puesto> puestos,puesto p){
                ListIterator<puesto> it= puestos.listIterator();
                while(it.hasNext()){
                      puesto puesto= it.next();
                    if(puesto.getNombrePuesto().equals(p.getNombrePuesto())){
                        mensaje.setTextFill(Color.GREEN);
                        mensaje.setText("Doctor ya existente");
                        return true;
                    }
                }
                return false;
       }
     
       public void buttonBorrar(){
        fieldcedula.setText("");
        fieldnombre.setText("");
        fieldapellido.setText("");
        fieldpuesto.setText("");
        fieldprofesion.setText("");
        mensaje.setText(" ");
        
    }
    
        
    

    public Pane getRootAdministrar() {
        return rootAdministrar;
    }

    public void setRootAdministrar(BorderPane  rootAdministrar) {
        this.rootAdministrar =  rootAdministrar;
    }
}
