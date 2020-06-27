/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author scarlet Espinoza
 */
public class PantallaPrincipal {
    private BorderPane root;
    private Label tiempo;
    static  Label mensaje;
    //private Pane root2 = new Pane();
    private ImageView fondo = new ImageView ( "imagenes/fondoInicio.jpg");
    private Button btnPuestos = new Button ("Puesto");
    private Button btnMedico = new Button ("Medico");
    private Button btnAcceder = new Button ("Acceder");

    public PantallaPrincipal() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        root=new BorderPane();
        root.setTop(crearArriba());
        root.setBottom(crearBajo());
        root.setStyle("-fx-background-color: #FFFFFF;");
        
        
        Thread t1=new Thread(new tiempo());
        t1.start();
    }
    
    public Pane crearArriba(){
        HBox arriba=new HBox();
        arriba.setPadding(new Insets(5,5,5,5));
        arriba.setAlignment(Pos.CENTER_RIGHT);
        tiempo=new Label("");
        tiempo.setFont(new Font("Arial Black",25));
        arriba.getChildren().add(tiempo);
        
        return arriba;
        
    }
    public Pane crearBajo(){
        VBox abajo = new VBox();
        abajo.setAlignment(Pos.CENTER);
        abajo.setPadding(new Insets(5,5,5,5));
        HBox botones=new HBox();
        botones.setAlignment(Pos.CENTER);
        
        botones.setSpacing(30);
        botones.setPadding(new Insets(5,5,5,5));
        
        mensaje=new Label("");
        botones.getChildren().addAll(mensaje);
        abajo.getChildren().add(botones);
        Label mensajer= new Label("Horario de atención de Lunes a Viernes de 10 a 18 Hs/ Sabado y Domingos"
                + " de 9 a 14 hs");
        mensajer.setStyle("-fx-background-color:#2E86C1");
        mensajer.setFont(new Font("Arial Black",14));
        mensajer.setTextFill(Color.web("#FFFFFF"));
        abajo.getChildren().add(mensajer);
        
        return abajo; 
    }
    
    
    public class tiempo implements Runnable{

        @Override
        public void run() {
            
            while (true){
                try {
                LocalDateTime l2=LocalDateTime.now();
                Platform.runLater(()->{
                    
                    tiempo.setText(String.valueOf(l2.getHour())+" : "+String.valueOf(l2.getMinute()));
                    tiempo.setTextFill(Color.web("#2E86C1"));
                });
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
    
     }
    
    
     public Pane getRoot() {
        return root;
    }
    

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public Label getTiempo() {
        return tiempo;
    }

    public void setTiempo(Label tiempo) {
        this.tiempo = tiempo;
    }

    public static Label getMensaje() {
        return mensaje;
    }

    public static void setMensaje(Label mensaje) {
        PantallaPrincipal.mensaje = mensaje;
    }


    
    public ImageView getFondo() {
        return fondo;
    }

    public void setFondo(ImageView fondo) {
        this.fondo = fondo;
    }

    public Button getBtnPuestos() {
        return btnPuestos;
    }

    public void setBtnPuestos(Button btnPuestos) {
        this.btnPuestos = btnPuestos;
    }

    public Button getBtnMedico() {
        return btnMedico;
    }

    public void setBtnMedico(Button btnMedico) {
        this.btnMedico = btnMedico;
    }

    public Button getBtnAcceder() {
        return btnAcceder;
    }

    public void setBtnAcceder(Button btnAcceder) {
        this.btnAcceder = btnAcceder;
    }
    
    
    
}
 