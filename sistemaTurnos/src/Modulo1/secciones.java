/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import static Modulo1.ventanaFormularioPaciente.combSintomas;
import clases.LecturaEscritura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author scarlet Espinoza
 */
public class secciones {
    static Stage stageRegistrar, stagePuesto,stagePaciente;
    

    public secciones() {
    }
    public void pantallaPaciente() throws InterruptedException{
        
        stageRegistrar = new Stage();
        stageRegistrar.setTitle("Registro Pacientes");
        ventanaFormularioPaciente ventanaPaciente = new  ventanaFormularioPaciente();
        //combSintomas.getItems().addAll(LecturaEscritura.cargarSintomas());
        stageRegistrar.setScene(new Scene(ventanaPaciente.getRootPaciente()));
        stageRegistrar.setWidth(480);
        stageRegistrar.setHeight(450);
        stageRegistrar.show();
    }
    
    public void pantallaMedico() throws InterruptedException{
        stagePuesto = new Stage();
        stagePuesto.setTitle("Registrar Puesto");
        ventanaDoctorPuesto ventanaDoctor = new ventanaDoctorPuesto();
        stagePuesto.setScene(new Scene(ventanaDoctor.getRootDoctor()));
        stagePuesto.setHeight(500);
        stagePuesto.setWidth(500);
        stagePuesto.show();
    }
    
    
    public void pantallaAtencion() throws InterruptedException{
        stagePaciente=new Stage();
        stagePaciente.setTitle("Atencion");
        ventanaAtencion ventanaA = new ventanaAtencion();
        stagePaciente.setScene(new Scene(ventanaA.getRootAtencion()));
        stagePaciente.setHeight(500);
        stagePaciente.setWidth(650);
        stagePaciente.show();
    }
}
