/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author scarlet Espinoza
 */
public class secciones {
    static Stage stageRegistrar, stageMedico,stagePaciente,stagePuesto,stageEliminar;
    

    public secciones() {
    }
    public void pantallaPaciente() throws InterruptedException{
        
        stageRegistrar = new Stage();
        stageRegistrar.setTitle("Registro Pacientes");
        VentanaFormularioPaciente ventanaPaciente = new  VentanaFormularioPaciente();
        stageRegistrar.setScene(new Scene(ventanaPaciente.getRootPaciente()));
        stageRegistrar.setWidth(490);
        stageRegistrar.setHeight(450);
        stageRegistrar.show();
    }
    
    public void pantallaMedico() throws InterruptedException{
        stageMedico = new Stage();
        stageMedico.setTitle("Registrar Medico");
        ventanaDoctorPuesto ventanaDoctor = new ventanaDoctorPuesto();
        stageMedico.setScene(new Scene(ventanaDoctor.getRootDoctor()));
        stageMedico.setHeight(450);
        stageMedico.setWidth(460);
        stageMedico.show();
    }
     public void pantallaPuesto() throws InterruptedException{
        stagePuesto = new Stage();
        stagePuesto.setTitle("asignar Puesto");
        VentanaAdministarPuesto ventanaPuesto = new VentanaAdministarPuesto();
        stagePuesto.setScene(new Scene(ventanaPuesto.getRootAdministrar()));
        stagePuesto.setHeight(500);
        stagePuesto.setWidth(400);
        stagePuesto.show();
    }
    
    
    public void pantallaAtencion() throws InterruptedException{
        stagePaciente=new Stage();
        stagePaciente.setTitle("Atencion");
        ventanaAtencion ventanaA = new ventanaAtencion();
        stagePaciente.setScene(new Scene(ventanaA.getRootAtencion()));
        stagePaciente.setHeight(500);
        stagePaciente.setWidth(730);
        stagePaciente.show();
    }
    
    public void pantallaEliminarPuesto() throws InterruptedException{
        stageEliminar = new Stage();
        stageEliminar.setTitle("eliminar Puesto");
        ventanaEliminarPuesto ventanaeliminarPuesto = new ventanaEliminarPuesto();
        stageEliminar.setScene(new Scene(ventanaeliminarPuesto.getRootEliminar()));
        stageEliminar.setHeight(500);
        stageEliminar.setWidth(400);
        stageEliminar.show();
    }
}
