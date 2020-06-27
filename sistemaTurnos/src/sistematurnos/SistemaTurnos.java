/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematurnos;

import Modulo1.ventanaAtencion;
import Modulo1.VentanaFormularioDoctor;
import Modulo1.PantallaPrincipal;
import Modulo1.ventanaPuesto;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author scarlet Espinoza
 */
public class SistemaTurnos extends Application {

    @Override
    public void start(Stage ventana) throws InterruptedException {
        //ventana principal
        
        ventana=new Stage();
        ventana.setTitle("Sistema de turnos");
        PantallaPrincipal Pantalla=new PantallaPrincipal();
        Scene sc=new Scene(Pantalla.getRoot());
        ventana.setScene(sc);
        ventana.setWidth(700);
        ventana.setHeight(580);
        ventana.show();
        
        ventana.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
