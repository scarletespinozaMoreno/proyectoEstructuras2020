/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import clases.Medico;
import clases.puesto;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class ventanaEliminarPuesto {

    private BorderPane rootEliminar;
    private final secciones pantallas = new secciones();
    private Label titulo, cedula, nombre, apellido, puesto, texto, profesion, mensaje;
    private TextField fieldtitulo, fieldcedula, fieldnombre, fieldapellido, fieldpuesto, fieldprofesion;
    private Button Buscar, Eliminar;

    public ventanaEliminarPuesto() throws InterruptedException {
        OrganizarVentana();

    }

    public Pane crearTop() {
        VBox arriba = new VBox();
        arriba.setPadding(new Insets(25, 20, 20, 20));
        arriba.setAlignment(Pos.CENTER);
        titulo = new Label("Puestos");
        titulo.setFont(new Font("Arial Black", 19));
        titulo.setTextFill(Color.web("#2E86C1"));
        arriba.getChildren().addAll(titulo);
        return arriba;

    }

    public Pane crearLeft() {
        VBox izquierda = new VBox();
        izquierda.setPadding(new Insets(20, 90, 20, 20));
        HBox CedulaMedico = new HBox();
        HBox NombreMedico = new HBox();
        HBox ApellidoMedico = new HBox();
        HBox PuestoMedico = new HBox();
        HBox ProfesionMedico = new HBox();
        ProfesionMedico.setSpacing(33);
        ProfesionMedico.setPadding(new Insets(10, 10, 10, 10));
        CedulaMedico.setSpacing(40);
        CedulaMedico.setPadding(new Insets(10, 10, 10, 10));
        NombreMedico.setSpacing(33);
        NombreMedico.setPadding(new Insets(10, 10, 10, 10));
        ApellidoMedico.setSpacing(33);
        ApellidoMedico.setPadding(new Insets(10, 10, 10, 10));
        PuestoMedico.setSpacing(45);
        PuestoMedico.setPadding(new Insets(10, 10, 10, 10));
        CedulaMedico.setAlignment(Pos.CENTER);
        NombreMedico.setAlignment(Pos.CENTER);
        ApellidoMedico.setAlignment(Pos.CENTER);
        PuestoMedico.setAlignment(Pos.CENTER);
        texto = new Label("Ingrese puesto a buscar ");
        cedula = new Label("Cedula:");
        nombre = new Label("Nombre:");
        profesion = new Label("Profesion:");
        apellido = new Label("Apellido:");
        puesto = new Label("Puesto:");
        fieldnombre = new TextField();
        fieldcedula = new TextField();
        
        texto.setPadding(new Insets(10, 10, 10, 10));
        fieldapellido = new TextField();
        fieldpuesto = new TextField();
        fieldprofesion = new TextField();
        CedulaMedico.getChildren().addAll(cedula, fieldcedula);
        NombreMedico.getChildren().addAll(nombre, fieldnombre);
        ApellidoMedico.getChildren().addAll(apellido, fieldapellido);
        PuestoMedico.getChildren().addAll(puesto, fieldpuesto);
        ProfesionMedico.getChildren().addAll(profesion, fieldprofesion);
        izquierda.getChildren().addAll(texto, PuestoMedico, CedulaMedico, NombreMedico, ApellidoMedico, ProfesionMedico);

        return izquierda;

    }

    public Pane crearBottom() {
        HBox botones = new HBox();
        VBox abajo = new VBox();
        mensaje = new Label("");
        Buscar = new Button("Buscar");

        Buscar.setOnAction((e) -> {

            buttonBuscar();

        });

        Eliminar = new Button("Eliminar");
        Eliminar.setOnAction((e) -> {
            buttonEliminar();

            
        });

        botones.getChildren().addAll(Buscar, Eliminar);
        abajo.getChildren().addAll(botones, mensaje);
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER);
        abajo.setPadding(new Insets(20, 20, 20, 20));
        abajo.setSpacing(20);

        abajo.setAlignment(Pos.CENTER);
        return abajo;

    }

    public void buttonBuscar() {
        ListIterator<puesto> it = PantallaPrincipal.PUESTO_MEDICO.listIterator();
        while (it.hasNext()) {
            puesto p = it.next();
            if (p.getNombrePuesto().equals(fieldpuesto.getText())) {
                fieldcedula.setText(p.getMedico().getCedula());
                fieldnombre.setText(p.getMedico().getNombre());
                fieldapellido.setText(p.getMedico().getApellido());
                fieldprofesion.setText(p.getMedico().getProfesion());
                fieldcedula.setEditable(false);
                fieldnombre.setEditable(false);
                fieldapellido.setEditable(false);
                fieldprofesion.setEditable(false);
                //Medico m= new Medico(fieldcedula.getText(), fieldnombre.getText(),fieldapellido.getText(),fieldprofesion.getText());
                return;
            }
        }
    }

    public void buttonEliminar() {
        ListIterator<puesto> it = PantallaPrincipal.PUESTO_MEDICO.listIterator();
        while (it.hasNext()) {
            puesto p = it.next();
            if (p.getNombrePuesto().equals(fieldpuesto.getText())) {
                PantallaPrincipal.MEDICO.add(p.getMedico());
                //PantallaPrincipal.PACIENTE.add(p.getPacientes());
                it.remove();
                actualizarPuesto();
                buttonBorrar();
                return;
            }
        }
    }
   public  void actualizarPuesto() {
        PantallaPrincipal.mostrarTurno.setText(String.valueOf(PantallaPrincipal.PACIENTE.peek().getSintoma().getLetra() + PantallaPrincipal.PACIENTE.peek().getTurno().getNumero()));
        puesto p = PantallaPrincipal.PUESTO_MEDICO.poll();
         if (PantallaPrincipal.PUESTO_MEDICO.isEmpty()) {
              PantallaPrincipal.mostrarPuesto.setText("---");
         }else{
                PantallaPrincipal.mostrarPuesto.setText(PantallaPrincipal.PUESTO_MEDICO.peek().getNombrePuesto());
               
      } 
          PantallaPrincipal.PUESTO_MEDICO.offer(p);
          secciones.stagePaciente.close();
         
     }
    public void buttonBorrar() {
        fieldcedula.setText("");
        fieldnombre.setText("");
        fieldapellido.setText("");
        fieldpuesto.setText("");
        fieldprofesion.setText("");
        mensaje.setText("eliminado");

    }

    public void OrganizarVentana() throws InterruptedException {
        rootEliminar = new BorderPane();
        rootEliminar.setStyle("-fx-background-color: #FFFFFF;");
        rootEliminar.setTop(crearTop());
        rootEliminar.setLeft(crearLeft());
        rootEliminar.setBottom(crearBottom());

    }

    public Pane getRootEliminar() {
        return rootEliminar;
    }

    public void setRootAdministrar(BorderPane rootEliminar) {
        this.rootEliminar = rootEliminar;
    }
}
