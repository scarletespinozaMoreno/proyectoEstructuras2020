/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;


import ListaCircularDoble.ListaCircularDoble;
import clases.LecturaEscritura;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
    private Button btnPuestos = new Button ("Puesto");
    private Button btnMedico = new Button ("Medico");
    private Button btnAcceder = new Button ("Acceder");
    private ListIterator<String> iterador;
    private MediaView reproductorVideos;
    public PantallaPrincipal() throws InterruptedException {
        OrganizarVentana();
    }
    
    
    

    public void OrganizarVentana() throws InterruptedException{
        root=new BorderPane();
        root.setTop(crearTop());
        root.setBottom(crearButton());
        root.setCenter(crearCenter());
        root.setLeft(crearLeft());
        root.setStyle("-fx-background-color: #FFFFFF;");
        
        
        Thread t1=new Thread(new tiempo());
        t1.start();
    }
    
    public Pane crearTop(){
        VBox arriba=new VBox();
        arriba.setPadding(new Insets(7,7,7,7));
        arriba.setAlignment(Pos.CENTER_RIGHT);
        HBox botones=new HBox();
        botones.setAlignment(Pos.CENTER);
        Button crearPaciente=new Button("Crear Paciente");
        Button puestoMedico=new Button("Asignar Puesto-Medico");
        botones.setSpacing(30);
        botones.setPadding(new Insets(10,10,10,10));
        Button atenderTurno=new Button("Atender turno");
        botones.getChildren().addAll(crearPaciente,puestoMedico,atenderTurno);
        tiempo=new Label("");
        tiempo.setFont(new Font("Arial Black",25));
        arriba.getChildren().add(tiempo);
        arriba.getChildren().add(botones);
        return arriba;
        
       }
    
    public Pane crearButton(){
        HBox abajo = new HBox();
        abajo.setAlignment(Pos.CENTER);
        abajo.setPadding(new Insets(10,10,10,10));
        Label vacio = new Label("  ");
        
        Label Mensaje= new Label("Horario de atención de Lunes a Viernes de 10 a 18 Hs/ Sabado y Domingos" + " de 9 a 14 hs");
        Mensaje.setStyle("-fx-background-color:#2E86C1");
        Mensaje.setFont(new Font("Arial Black",13.5));
        Mensaje.setTextFill(Color.web("#FFFFFF"));
        abajo.getChildren().add(Mensaje);
        return abajo; 
    }
    
     public Pane crearCenter(){
        HBox derecha=new HBox();
        
         return derecha;
     }
     
     
    public Pane crearLeft(){
        VBox izquierda=new VBox();
        izquierda.setStyle("-fx-background-color:#2E86C1");
        izquierda.setAlignment(Pos.CENTER);
        izquierda.setPadding(new Insets(20,2,20,20));
        ListaCircularDoble<String> lista=LecturaEscritura.leerVideos();
        iterador=lista.listIterator(0);
        reproductorVideos=this.crearMediaView(iterador);
        reproductorVideos.setFitHeight(300);
        reproductorVideos.setFitWidth(300);
        reproductorVideos.setStyle("-fx-background-color: #FFFFFF;");
        izquierda.getChildren().addAll(reproductorVideos);
        
         return izquierda;
     }
       
        
     
    public class tiempo implements Runnable{

        @Override
        public void run() {
            
            while (true){
                try {
                LocalDateTime hora=LocalDateTime.now();
                Platform.runLater(()->{
                    
                    tiempo.setText(String.valueOf(hora.getHour())+" : "+String.valueOf(hora.getMinute())+" : "+String.valueOf(hora.getSecond()));
                    tiempo.setTextFill(Color.web("#2E86C1"));
                });
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
    
     }
    
    public MediaView crearMediaView(ListIterator<String> direcciones){
        MediaView mediaView = new MediaView();
        iniciarlizarMediaPlayer(mediaView, direcciones);
        return mediaView;
     }
    
    private void iniciarlizarMediaPlayer(final MediaView mediaView, final ListIterator<String>direcciones){
        if (direcciones.hasNext()){
            File f=new File(direcciones.next());
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> {
                iniciarlizarMediaPlayer(mediaView, direcciones);
            });
            mediaView.setMediaPlayer(mediaPlayer);

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
 