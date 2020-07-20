/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import static Modulo1.PantallaPrincipal.PUESTO_MEDICO;
import static Modulo1.PantallaPrincipal.mostrarPuesto;
import clases.paciente;
import clases.puesto;
import clases.turno;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class ventanaAtencion {

    private BorderPane rootAtencion;
    private Label titulo, diagnostico, receta, nom, ape, e, nomdoctor, apedoctor;
    private static Label mensajeError;
    static TextField fieldNombre, fieldApellido, fieldEdad, fieldNombreMedico, fieldApellidoMedico;
    private TextArea areaDiagnostico, areaReceta;
    private Button atender;

    public ventanaAtencion() throws InterruptedException {
        OrganizarVentana();

    }

    public void OrganizarVentana() throws InterruptedException {
        rootAtencion = new BorderPane();
        rootAtencion.setStyle("-fx-background-color: #FFFFFF;");
        rootAtencion.setTop(crearTop());
        rootAtencion.setCenter(crearCenter());
        rootAtencion.setBottom(crearBottom());
        /*
        while(!PUESTO_MEDICO.isEmpty()){
                 puesto p = PUESTO_MEDICO.pop();
                 System.out.println(p.getNombrePuesto());
             }
        
         */

    }

    public Pane crearTop() {
        VBox arriba = new VBox();
        arriba.setPadding(new Insets(25, 20, 20, 20));
        arriba.setAlignment(Pos.CENTER);
        titulo = new Label("Atencion paciente");
        titulo.setFont(new Font("Arial Black", 19));
        titulo.setTextFill(Color.web("#2E86C1"));
        titulo.setPadding(new Insets(13, 13, 13, 13));

        HBox hBoxNombre = new HBox();
        nom = new Label("Nombre:");
        fieldNombre = new TextField();
        nomdoctor = new Label("Nombre Medico:");
        fieldNombreMedico = new TextField();
        hBoxNombre.getChildren().addAll(nom, fieldNombre, nomdoctor, fieldNombreMedico);
        hBoxNombre.setSpacing(20);
        hBoxNombre.setPadding(new Insets(9, 9, 9, 9));
        hBoxNombre.setAlignment(Pos.TOP_LEFT);

        HBox hBoxApellido = new HBox();
        ape = new Label("Apellido:");
        fieldApellido = new TextField();
        apedoctor = new Label("Apellido Medico:");
        fieldApellidoMedico = new TextField();
        hBoxApellido.getChildren().addAll(ape, fieldApellido, apedoctor, fieldApellidoMedico);
        hBoxApellido.setPadding(new Insets(10, 10, 10, 10));
        hBoxApellido.setSpacing(20);
        hBoxApellido.setAlignment(Pos.TOP_LEFT);

        HBox hBoxEdad = new HBox();
        e = new Label("Edad:");
        fieldEdad = new TextField();
        hBoxEdad.setPadding(new Insets(17, 17, 17, 17));
        hBoxEdad.getChildren().addAll(e, fieldEdad);
        hBoxEdad.setSpacing(35);
        hBoxEdad.setAlignment(Pos.TOP_LEFT);

        fieldNombre.setText(PantallaPrincipal.PACIENTE.peek().getNombre());
        fieldApellido.setText(PantallaPrincipal.PACIENTE.peek().getApellido());
        fieldEdad.setText(String.valueOf(PantallaPrincipal.PACIENTE.peek().getEdad()));
        //
        puesto p = PUESTO_MEDICO.peek();
        fieldNombreMedico.setText(String.valueOf(p.getMedico().getNombre()));
        fieldApellidoMedico.setText(String.valueOf(p.getNombrePuesto()));

        fieldNombre.setEditable(false);
        fieldApellido.setEditable(false);
        fieldEdad.setEditable(false);
        fieldNombreMedico.setEditable(false);
        fieldApellidoMedico.setEditable(false);
        arriba.getChildren().addAll(titulo, hBoxNombre, hBoxApellido, hBoxEdad);
        return arriba;

    }

    public Pane crearCenter() {
        HBox contenedor = new HBox();
        contenedor.setPadding(new Insets(10, 10, 10, 10));
        VBox area1 = new VBox();
        areaDiagnostico = new TextArea();
        areaDiagnostico.setMaxHeight(300);
        areaDiagnostico.setMaxWidth(300);

        diagnostico = new Label("Diagnostico");
        area1.getChildren().addAll(diagnostico, areaDiagnostico);

        VBox area2 = new VBox();
        areaReceta = new TextArea();
        areaReceta.setMaxHeight(200);
        areaReceta.setMaxWidth(300);
        receta = new Label("Receta");
        area2.getChildren().addAll(receta, areaReceta);
        contenedor.setSpacing(30);
        contenedor.getChildren().addAll(area1, area2);

        return contenedor;
    }

    public Pane crearBottom() {
        HBox b = new HBox();
        mensajeError = new Label("");
        atender = new Button("Atender");
        atender.setOnAction((ActionEvent e) -> {
            try {
                buttonAtenderPaciente();
            } catch (InterruptedException ex) {
                Logger.getLogger(ventanaAtencion.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        b.setPadding(new Insets(10, 10, 10, 10));
        b.setAlignment(Pos.TOP_RIGHT);
        b.setSpacing(25);
        b.getChildren().addAll(mensajeError, atender);
        return b;

    }

    public void buttonAtenderPaciente() throws InterruptedException {
        secciones pantalla = new secciones();

        if (areaDiagnostico.getText().isEmpty() || areaReceta.getText().isEmpty()) {
            mensajeError.setText("Debe dar un diagnostico y su receta correspondiente");
        } else if (!PantallaPrincipal.PACIENTE.isEmpty()) {
            // se extrae el turno que sera atendido
            paciente t = PantallaPrincipal.PACIENTE.poll();
            PUESTO_MEDICO.peek().setPaciente(t);
            t.setDiagnostico(diagnostico.getText());
            if (PantallaPrincipal.PACIENTE.isEmpty()) {
                PantallaPrincipal.mensaje.setText("Turnos Atendidos");
                PantallaPrincipal.mostrarTurno.setText("---");
                secciones.stagePaciente.close();
                //pantalla.pantallaPaciente();

            } else actualizarTurno();
        }
    }

    public static void actualizarTurno() {
        PantallaPrincipal.mostrarTurno.setText(String.valueOf(PantallaPrincipal.PACIENTE.peek().getSintoma().getLetra() + PantallaPrincipal.PACIENTE.peek().getTurno().getNumero()));
        puesto p = PantallaPrincipal.PUESTO_MEDICO.poll();
        if (PantallaPrincipal.PUESTO_MEDICO.isEmpty()) {
              PantallaPrincipal.mostrarPuesto.setText(p.getNombrePuesto());
         }else{
                PantallaPrincipal.mostrarPuesto.setText(PantallaPrincipal.PUESTO_MEDICO.peek().getNombrePuesto());
               
      } 
        mensajeError.setTextFill(Color.GREEN);
        PantallaPrincipal.PUESTO_MEDICO.offer(p);
        secciones.stagePaciente.close();
    }

    public Pane getRootAtencion() {
        return rootAtencion;
    }

    public void setRootAtencion(BorderPane rootAtencion) {
        this.rootAtencion = rootAtencion;
    }

}
