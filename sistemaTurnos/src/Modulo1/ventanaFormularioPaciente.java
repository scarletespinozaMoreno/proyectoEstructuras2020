/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import clases.LecturaEscritura;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class ventanaFormularioPaciente {
    private BorderPane rootPaciente;
    private Label titulo,nom,ape,e,ge;
    private TextField fieldNombre,fieldApellido,fieldEdad,fieldGenero;
    private Button registrar;
    public static ComboBox combSintomas;

   
    
    public ventanaFormularioPaciente() throws InterruptedException {
        OrganizarVentana();
        
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        rootPaciente=new BorderPane();
        rootPaciente.setStyle("-fx-background-color: #FFFFFF;");
        rootPaciente.setTop(crearTop());
        rootPaciente.setLeft(crearLeft());
        //rootPaciente.setCenter(combSintomas);
        rootPaciente.setBottom(crearBottom());
        
 
    }
     public Pane crearBottom(){
         VBox abajo=new VBox();
         registrar= new Button("Registrar");
         abajo.setPadding(new Insets(20,20,20,20));
         abajo.getChildren().addAll(registrar);
         abajo.setAlignment(Pos.CENTER);
         return abajo;
     }
     public Pane crearTop(){
         VBox arriba=new VBox();
         arriba.setPadding(new Insets(20,20,20,20));
        arriba.setAlignment(Pos.CENTER);
         titulo = new Label("Formulario del paciente");
         titulo.setFont(new Font("Arial Black",19));
         titulo.setTextFill(Color.web("#2E86C1"));
         arriba.getChildren().addAll(titulo);
         return arriba;
         
     }
     public Pane crearCenter(){
         VBox derecha=new VBox();
          derecha.setPadding(new Insets(20,20,20,20));
         
         derecha.getChildren().addAll(combSintomas);
         return derecha;
     }
     public Pane crearLeft(){
         
          VBox izquierda=new VBox();
           izquierda.setPadding(new Insets(20,20,20,20));
          HBox hBoxNombre = new HBox();
          nom = new Label("Nombres:");
          fieldNombre = new TextField();
          hBoxNombre.getChildren().addAll(nom,fieldNombre);
          hBoxNombre.setSpacing(15);
          hBoxNombre.setPadding(new Insets(10,10,10,10));
          hBoxNombre.setAlignment(Pos.CENTER);
          
          HBox hBoxApellido = new HBox();
          ape = new Label("Apellidos:");
          fieldApellido = new TextField();
          hBoxApellido.getChildren().addAll(ape,fieldApellido);
           hBoxApellido.setPadding(new Insets(9,9,9,9));
          hBoxApellido.setSpacing(10);
          hBoxApellido.setAlignment(Pos.CENTER);
          
          HBox hBoxEdad = new HBox();
          e = new Label("Edad:");
          fieldEdad = new TextField();
          hBoxEdad.setPadding(new Insets(9,9,9,9));
          hBoxEdad.getChildren().addAll(e,fieldEdad);
          hBoxEdad.setSpacing(35);
          hBoxEdad.setAlignment(Pos.CENTER);
          
          
           HBox hBoxGenero = new HBox();
          ge = new Label("Género:");
          fieldGenero = new TextField();
          hBoxGenero.setPadding(new Insets(9,9,9,9));
          hBoxGenero.getChildren().addAll(ge,fieldGenero);
          hBoxGenero.setSpacing(25);
          hBoxGenero.setAlignment(Pos.CENTER);
          
          
          
          izquierda.getChildren().addAll(hBoxNombre,hBoxApellido,hBoxEdad,hBoxGenero);
          return izquierda;
          
     }
     public Pane getRootPaciente() {
        return rootPaciente;
    }

    public void setRootPaciente(BorderPane rootPaciente) {
        this.rootPaciente = rootPaciente;
    }

    public ComboBox getCombSintomas() {
        return combSintomas;
    }

    public void setCombSintomas(ComboBox combSintomas) {
        this.combSintomas = combSintomas;
    }
    
    
}
