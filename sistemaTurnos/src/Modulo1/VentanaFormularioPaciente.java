/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import java.util.List;
import clases.LecturaEscritura;
import clases.paciente;
import clases.puesto;
import clases.sintoma;
import clases.turno;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VentanaFormularioPaciente {

    private BorderPane rootPaciente;
    private Label titulo, nom, ape, e, ge, mensaje;
    private TextField fieldNombre, fieldApellido, fieldEdad, fieldGenero;
    private Button registrar, limpiar;
    static ComboBox combSintomas;
    int num = 0;

    public VentanaFormularioPaciente() throws InterruptedException {
        OrganizarVentana();

    }

    public void OrganizarVentana() throws InterruptedException {
        rootPaciente = new BorderPane();
        rootPaciente.setStyle("-fx-background-color: #FFFFFF;");
        rootPaciente.setTop(crearTop());
        rootPaciente.setLeft(crearLeft());
        rootPaciente.setCenter(crearCenter());
        rootPaciente.setBottom(crearBottom());

    }

    public Pane crearBottom() {
        HBox botones = new HBox();
        VBox abajo = new VBox();
        mensaje = new Label("");
        registrar = new Button("Registrar");
        registrar.setOnAction((e) -> {
            try {
                buttonAceptar();
            } catch (IOException ex) {
                Logger.getLogger(VentanaFormularioPaciente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(VentanaFormularioPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        limpiar = new Button("Limpiar");
        limpiar.setOnAction((e) -> {
            buttonBorrar();

        });

        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(registrar, limpiar);
        abajo.setPadding(new Insets(20, 20, 20, 20));
        abajo.setSpacing(20);
        abajo.getChildren().addAll(botones, mensaje);
        abajo.setAlignment(Pos.CENTER);
        return abajo;
    }

    public void buttonAceptar() throws IOException, InterruptedException {
        if (fieldNombre.getText().equals("") || fieldApellido.getText().equals("") || fieldGenero.getText().equals("") || fieldEdad.getText().equals("")) {
            mensaje.setStyle("-fx-text-fill:#2E86C1");
            mensaje.setText("Campos Obligatorios!!");
            return;
        }
        paciente paciente;
        paciente = new paciente(fieldNombre.getText(), fieldApellido.getText(),
                fieldGenero.getText(), Integer.valueOf(fieldEdad.getText()), (sintoma) combSintomas.getValue());
        PantallaPrincipal.PACIENTE.offer(paciente);
        if (PantallaPrincipal.PACIENTE.size() == 1) {
            ventanaAtencion.actualizarTurno();
        }

    }

    public void buttonBorrar() {
        fieldNombre.setText("");
        fieldApellido.setText("");
        fieldEdad.setText("");
        fieldGenero.setText("");

    }

    public Pane crearTop() {
        VBox arriba = new VBox();
        arriba.setPadding(new Insets(25, 20, 20, 20));
        arriba.setAlignment(Pos.CENTER);
        titulo = new Label("Formulario del paciente");
        titulo.setFont(new Font("Arial Black", 19));
        titulo.setTextFill(Color.web("#2E86C1"));
        arriba.getChildren().addAll(titulo);
        return arriba;

    }

    public Pane crearCenter() {
        VBox derecha = new VBox();
        derecha.setPadding(new Insets(28, 20, 20, 20));
        List<sintoma> lista = LecturaEscritura.cargarSintomas();
        combSintomas = new ComboBox(FXCollections.observableList(lista));
        combSintomas.setStyle("-fx-background-color:#87CEFA");
        derecha.getChildren().addAll(combSintomas);
        return derecha;
    }

    public Pane crearLeft() {

        VBox izquierda = new VBox();
        izquierda.setPadding(new Insets(20, 20, 20, 20));
        HBox hBoxNombre = new HBox();
        nom = new Label("Nombres:");
        fieldNombre = new TextField();
        hBoxNombre.getChildren().addAll(nom, fieldNombre);
        hBoxNombre.setSpacing(15);
        hBoxNombre.setPadding(new Insets(10, 10, 10, 10));
        hBoxNombre.setAlignment(Pos.CENTER);

        HBox hBoxApellido = new HBox();
        ape = new Label("Apellidos:");
        fieldApellido = new TextField();
        hBoxApellido.getChildren().addAll(ape, fieldApellido);
        hBoxApellido.setPadding(new Insets(9, 9, 9, 9));
        hBoxApellido.setSpacing(10);
        hBoxApellido.setAlignment(Pos.CENTER);

        HBox hBoxEdad = new HBox();
        e = new Label("Edad:");
        fieldEdad = new TextField();
        hBoxEdad.setPadding(new Insets(9, 9, 9, 9));
        hBoxEdad.getChildren().addAll(e, fieldEdad);
        hBoxEdad.setSpacing(35);
        hBoxEdad.setAlignment(Pos.CENTER);

        HBox hBoxGenero = new HBox();
        ge = new Label("Género:");
        fieldGenero = new TextField();
        hBoxGenero.setPadding(new Insets(9, 9, 9, 9));
        hBoxGenero.getChildren().addAll(ge, fieldGenero);
        hBoxGenero.setSpacing(25);
        hBoxGenero.setAlignment(Pos.CENTER);

        izquierda.getChildren().addAll(hBoxNombre, hBoxApellido, hBoxEdad, hBoxGenero);
        return izquierda;

    }

    public Pane getRootPaciente() {
        return rootPaciente;
    }

    public void setRootPaciente(BorderPane rootPaciente) {
        this.rootPaciente = rootPaciente;
    }

}
