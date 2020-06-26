/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematurnos;

import Modulo1.ventanaMenu;
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
        ventanaMenu ventanaAdministrar= new ventanaMenu();
        Scene scVentana1 = new Scene(ventanaAdministrar.getRoot(),600,600);
        primaryStage.setScene(scVentana1);
        primaryStage.setTitle("Servicio de atencion medica");
        primaryStage.show();
    }
    
    public static void main(String[] args){
        // TODO code application logic here
        launch(args);
    }
    
}
