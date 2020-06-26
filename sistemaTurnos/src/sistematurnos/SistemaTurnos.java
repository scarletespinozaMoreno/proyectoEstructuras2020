/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematurnos;

import Modulo1.ventanaAcceder;
import Modulo1.ventanaCrearMedico;
import Modulo1.ventanaMenu;
import Modulo1.ventanaCrearPuesto;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author scarlet Espinoza
 */
public class SistemaTurnos extends Application {

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void start(Stage primaryStage) {
        
        ventanaMenu ventanaInicio= new ventanaMenu();
        ventanaCrearPuesto ventanaPuesto= new ventanaCrearPuesto();
        ventanaCrearMedico ventanaMedico= new ventanaCrearMedico();
        ventanaAcceder ventanaAcceder = new ventanaAcceder();
        
        Scene scVentana1 = new Scene(ventanaInicio.getRoot(),600,600);
        Scene scVentana2 = new Scene(ventanaPuesto.getRoot(),600,600);
        Scene scVentana3 = new Scene(ventanaMedico.getRoot(),600,600);
        //Scene scVentana4 = new Scene(ventanaAcceder.getRoot(), 610, 390);
        
        ventanaInicio.getBtnPuestos().setOnAction(e -> primaryStage.setScene(scVentana2));
        ventanaInicio.getBtnMedico().setOnAction(e -> primaryStage.setScene(scVentana3));
        primaryStage.setScene(scVentana1);
        primaryStage.setTitle("Servicio de atencion medica");
        primaryStage.show();
    }
    
    public static void main(String[] args){
        // TODO code application logic here
        launch(args);
    }
    
}
