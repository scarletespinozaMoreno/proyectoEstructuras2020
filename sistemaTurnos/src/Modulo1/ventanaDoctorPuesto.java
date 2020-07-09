/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import clases.Medico;
import clases.puesto;
import java.io.IOException;
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
public class ventanaDoctorPuesto {
    private BorderPane rootDoctor;
    private Label titulo,cedula,apellido,nombre,genero,profesion,puesto,mensaje,cantidadPuesto,texto;
    private TextField fieldNombre,fieldApellido,fieldCedula,fieldGenero,fieldProfesion,fieldPuesto;
    private Button registrar,limpiar;
    int contador =0;
    puesto puestoPaciente;
    
    public ventanaDoctorPuesto() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        rootDoctor=new BorderPane();
        rootDoctor.setStyle("-fx-background-color: #FFFFFF;");
        rootDoctor.setTop(crearTop());
        rootDoctor.setLeft(crearLeft());
        rootDoctor.setBottom(crearBottom());
        rootDoctor.setCenter(crearCenter());
        
 
    }
    public Pane crearCenter(){
        VBox derecha=new VBox();
        texto=new Label("N°Doctores Asignados: ");
        cantidadPuesto=new Label(String.valueOf(PantallaPrincipal.PUESTO_MEDICO.size()));
        cantidadPuesto.setTextFill(Color.BLACK);
        texto.setTextFill(Color.BLACK);
         derecha.setAlignment(Pos.CENTER);
         derecha.setSpacing(20);
         texto.setFont(new Font("Arial Black",15));
         cantidadPuesto.setFont(new Font("Arial Black",15));
        derecha.setPadding(new Insets(28,20,20,20));
        System.out.println(PantallaPrincipal.PUESTO_MEDICO.size());
        
        derecha.getChildren().addAll(texto,cantidadPuesto);
        return derecha;
    }
    public Pane crearBottom(){
         HBox botones=new HBox();
         VBox abajo= new VBox();
         mensaje= new Label("");
         registrar= new Button("Registrar");
         registrar.setOnAction((e)->{
             try {
                 buttonRegistarDoctor();
             } catch (IOException ex) {
                 Logger.getLogger(VentanaFormularioPaciente.class.getName()).log(Level.SEVERE, null, ex);
             } catch (InterruptedException ex) {
                 Logger.getLogger(VentanaFormularioPaciente.class.getName()).log(Level.SEVERE, null, ex);
             }
          
        });
         limpiar= new Button("Limpiar");
         limpiar.setOnAction((e)->{
            buttonBorrar();
          
        });
         
         botones.setSpacing(20);
         botones.setAlignment(Pos.CENTER);
         botones.getChildren().addAll(registrar, limpiar);
         abajo.setPadding(new Insets(20,20,20,20));
         abajo.setSpacing(20);
         abajo.getChildren().addAll(botones,mensaje);
         abajo.setAlignment(Pos.CENTER);
         return abajo;
     }
    
     public void buttonRegistarDoctor() throws IOException, InterruptedException{
        if(fieldNombre.getText().equals("")||fieldApellido.getText().equals("")||fieldGenero.getText().equals("")||fieldProfesion.getText().equals("")||fieldCedula.getText().equals("")||fieldPuesto.getText().equals("")){
            mensaje.setStyle("-fx-text-fill:#2E86C1");
            mensaje.setText("Existen campos en blanco!!!");
            return;
        } else{
           PantallaPrincipal.PUESTO_MEDICO.add(new puesto(new Medico(fieldCedula.getText(),fieldNombre.getText(),fieldApellido.getText(),fieldProfesion.getText()),fieldPuesto.getText()));
            contador++;
            this.cantidadPuesto.setText(String.valueOf(PantallaPrincipal.PUESTO_MEDICO.size()));
            mensaje.setTextFill(Color.RED);
            mensaje.setText("Registro completo");
       }
         
    }
    
    
    
    public void buttonBorrar(){
        fieldNombre.setText("");
        fieldApellido.setText("");
        fieldProfesion.setText("");
        fieldGenero.setText("");
        fieldCedula.setText("");
        fieldPuesto.setText("");
    }
     
    
    
    
    
    public Pane crearTop(){
         VBox arriba=new VBox();
         arriba.setPadding(new Insets(25,20,20,20));
        arriba.setAlignment(Pos.CENTER);
         titulo = new Label("Formulario del doctor");
         titulo.setFont(new Font("Arial Black",19));
         titulo.setTextFill(Color.web("#2E86C1"));
         arriba.getChildren().addAll(titulo);
         return arriba;
         
     }
    
    public Pane crearLeft(){
          VBox izquierda=new VBox();
        
          izquierda.setPadding(new Insets(20,20,20,20)); 
          
          HBox hBoxCedula = new HBox();
          cedula = new Label("Cedula:");
          fieldCedula = new TextField();
          hBoxCedula.getChildren().addAll(cedula,fieldCedula);
          hBoxCedula.setSpacing(33);
          hBoxCedula.setPadding(new Insets(10,10,10,10));
          hBoxCedula.setAlignment(Pos.CENTER);
          
          HBox hBoxNombre = new HBox();
          nombre = new Label("Nombre:");
          fieldNombre = new TextField();
          hBoxNombre.getChildren().addAll(nombre,fieldNombre);
          hBoxNombre.setSpacing(25);
          hBoxNombre.setPadding(new Insets(10,10,10,10));
          hBoxNombre.setAlignment(Pos.CENTER);
           
           
           
          HBox hBoxApellido = new HBox();
          apellido = new Label("Apellidos:");
          fieldApellido = new TextField();
          hBoxApellido.getChildren().addAll(apellido,fieldApellido);
           hBoxApellido.setPadding(new Insets(9,9,9,9));
          hBoxApellido.setSpacing(20);
          hBoxApellido.setAlignment(Pos.CENTER);
          
          HBox hBoxProfesion = new HBox();
          profesion= new Label("Profesion:");
          fieldProfesion = new TextField();
          hBoxProfesion.setPadding(new Insets(9,9,9,9));
          hBoxProfesion.getChildren().addAll(profesion,fieldProfesion);
          hBoxProfesion.setSpacing(20);
          hBoxProfesion.setAlignment(Pos.CENTER);
          
          
          HBox hBoxGenero = new HBox();
          genero = new Label("Género:");
          fieldGenero = new TextField();
          hBoxGenero.setPadding(new Insets(9,9,9,9));
          hBoxGenero.getChildren().addAll(genero,fieldGenero);
          hBoxGenero.setSpacing(33);
          hBoxGenero.setAlignment(Pos.CENTER);
          
          HBox hBoxPuesto = new HBox();
          puesto = new Label("Puesto:");
          fieldPuesto = new TextField();
          hBoxPuesto.setPadding(new Insets(10,10,10,10));
          hBoxPuesto.getChildren().addAll(puesto,fieldPuesto);
          hBoxPuesto.setSpacing(35);
          hBoxPuesto.setAlignment(Pos.CENTER);
          
          
          izquierda.getChildren().addAll(hBoxCedula,hBoxNombre,hBoxApellido,hBoxGenero,hBoxProfesion,hBoxPuesto);
          return izquierda;
          
    }
    public Pane getRootDoctor() {
        return rootDoctor;
    }

    public void setRootDoctor(BorderPane rootDoctor) {
        this.rootDoctor = rootDoctor;
    }
    
}
