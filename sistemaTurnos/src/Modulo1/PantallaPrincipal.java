/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo1;

import ListaCircularDoble.ListaCircularDoble;
import clases.LecturaEscritura;
import clases.Medico;
import clases.paciente;
import clases.puesto;
import clases.turno;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
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
    static Label mensaje;
    private Button btnPuestos = new Button("Puesto");
    private Button btnMedico = new Button("Medico");
    private Button btnAcceder = new Button("Acceder");
    private ListIterator<String> iterador;
    private MediaView reproductorVideos;
    static Label mostrarTurno;
    static Label mostrarPuesto;
    private static int turno = 0;
    private final secciones pantallas = new secciones();
    static PriorityQueue<paciente> PACIENTE = new PriorityQueue<>((paciente p1, paciente p2) -> p1.getSintoma().getPrioridad() - p2.getSintoma().getPrioridad());
    static LinkedList<puesto> PUESTO_MEDICO = new LinkedList<>();
    static ArrayList<Medico> MEDICO = new ArrayList<>();

    public PantallaPrincipal() throws InterruptedException {
        OrganizarVentana();
    }

    public static PriorityQueue<paciente> getPACIENTE() {
        return PACIENTE;
    }

    public static ArrayList<Medico> getMEDICO() {
        return MEDICO;
    }

    public static void setMEDICO(ArrayList<Medico> MEDICO) {
        PantallaPrincipal.MEDICO = MEDICO;
    }

    public void OrganizarVentana() throws InterruptedException {

        MEDICO.addAll(LecturaEscritura.leerDoctor());
        PACIENTE.addAll(LecturaEscritura.leerCliente());
        PUESTO_MEDICO.addAll(puesto.asignarPuestos());
        root = new BorderPane();
        root.setTop(crearTop());
        root.setBottom(crearButton());
        root.setCenter(crearCenter());
        root.setLeft(crearLeft());
        root.setStyle("-fx-background-color: #FFFFFF;");

        Thread t1 = new Thread(new tiempo());
        t1.start();
    }

    public Pane crearTop() {
        VBox arriba = new VBox();
        arriba.setPadding(new Insets(7, 7, 7, 7));
        arriba.setAlignment(Pos.CENTER_RIGHT);
        HBox botones = new HBox();
        botones.setAlignment(Pos.CENTER);
        Button crearPaciente = new Button("Crear Paciente");
        Button puestoMedico = new Button("Asignar Puesto-Medico");
        botones.setSpacing(30);
        botones.setPadding(new Insets(10, 10, 10, 10));
        Button atenderTurno = new Button("Atender turno");
        botones.getChildren().addAll(crearPaciente, puestoMedico, atenderTurno);
        crearPaciente.setOnAction((e) -> {
            try {
                pantallas.pantallaPaciente();

            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        puestoMedico.setOnAction((e) -> {
            try {
                pantallas.pantallaMedico();
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        atenderTurno.setOnAction((e) -> {
            try {
                pantallas.pantallaAtencion();
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        tiempo = new Label("");
        tiempo.setFont(new Font("Arial Black", 25));
        arriba.getChildren().add(tiempo);
        arriba.getChildren().add(botones);
        return arriba;

    }

    public Pane crearButton() {
        VBox abajo = new VBox();
        abajo.setAlignment(Pos.CENTER);
        abajo.setPadding(new Insets(10, 10, 10, 10));
        mensaje = new Label(" ");

        Label Mensaje = new Label("Horario de atención de Lunes a Viernes de 10 a 18 Hs/ Sabado y Domingos" + " de 9 a 14 hs");
        Mensaje.setStyle("-fx-background-color:#2E86C1");
        Mensaje.setFont(new Font("Arial Black", 12.7));
        Mensaje.setTextFill(Color.web("#FFFFFF"));
        abajo.getChildren().addAll(mensaje, Mensaje);
        return abajo;
    }

    public Pane crearCenter() {
        HBox derecha = new HBox();
        derecha.setAlignment(Pos.CENTER);
        derecha.setSpacing(15);
        derecha.setPadding(new Insets(20, 20, 20, 20));

        VBox turno = new VBox();
        turno.setSpacing(6);

        HBox cuadro1Titulo = new HBox();
        cuadro1Titulo.setPrefHeight(80);
        cuadro1Titulo.setPrefWidth(120);
        cuadro1Titulo.setAlignment(Pos.CENTER);
        cuadro1Titulo.setStyle("-fx-background-color:#87CEFA");
        Label encabezado1 = new Label("Turno");
        encabezado1.setFont(new Font("Arial Black", 22));
        cuadro1Titulo.getChildren().add(encabezado1);

        HBox cuadro2Turno = new HBox();
        cuadro2Turno.setPrefHeight(80);
        cuadro2Turno.setPrefWidth(120);
        cuadro2Turno.setAlignment(Pos.CENTER);
        cuadro2Turno.setStyle("-fx-background-color:#87CEFA");

        //
        mostrarTurno = new Label("");
        if (!PACIENTE.isEmpty()) {
            mostrarTurno.setText(PACIENTE.peek().getSintoma().getLetra()
                    + String.valueOf(PACIENTE.peek().getTurno().getNumero()));
        }

        cuadro2Turno.getChildren().add(mostrarTurno);
        turno.getChildren().addAll(cuadro1Titulo, cuadro2Turno);

        VBox puesto = new VBox();
        puesto.setSpacing(5);

        HBox cuadro3Titulo = new HBox();
        cuadro3Titulo.setPrefHeight(80);
        cuadro3Titulo.setPrefWidth(120);
        cuadro3Titulo.setAlignment(Pos.CENTER);
        cuadro3Titulo.setStyle("-fx-background-color:#2E86C1");
        HBox cuadro4Puesto = new HBox();
        cuadro4Puesto.setPrefHeight(80);
        cuadro4Puesto.setPrefWidth(120);
        cuadro4Puesto.setAlignment(Pos.CENTER);
        cuadro4Puesto.setStyle("-fx-background-color:#2E86C1");

        Label encabezado2 = new Label("Puesto");
        encabezado2.setFont(new Font("Arial Black", 22));

        cuadro3Titulo.getChildren().add(encabezado2);

        mostrarPuesto = new Label("");
        puesto p = PUESTO_MEDICO.peek();

        mostrarPuesto.setText(p.getNombrePuesto());
        cuadro4Puesto.getChildren().add(mostrarPuesto);
        puesto.getChildren().addAll(cuadro3Titulo, cuadro4Puesto);
        derecha.getChildren().addAll(turno, puesto);

        return derecha;
    }

    public Pane crearLeft() {
        VBox izquierda = new VBox();
        izquierda.setStyle("-fx-background-color:#2E86C1");
        izquierda.setAlignment(Pos.CENTER);
        izquierda.setPadding(new Insets(20, 20, 20, 20));
        ListaCircularDoble<String> lista = LecturaEscritura.leerVideos();
        iterador = lista.listIterator(0);
        reproductorVideos = this.crearMediaView(iterador);
        reproductorVideos.setFitHeight(300);
        reproductorVideos.setFitWidth(300);
        reproductorVideos.setStyle("-fx-background-color: #FFFFFF;");
        HBox botones = new HBox();
        botones.setAlignment(Pos.CENTER);
        botones.setPadding(new Insets(5, 5, 5, 5));
        botones.setSpacing(20);
        /*
        Button siguiente=new Button(">>");
        siguiente.setOnAction((e)->{
            reproductorVideos.getMediaPlayer().stop();
            File f=new File(iterador.next());
            MediaPlayer sig=new MediaPlayer(new Media(f.toURI().toString()));
            
            reproductorVideos.setMediaPlayer(sig);
            sig.play();
           
        });
        
        Button anterior=new Button("<<");
        anterior.setOnAction(z->{
            reproductorVideos.getMediaPlayer().stop();
            File f=new File(iterador.previous());
            MediaPlayer ant=new MediaPlayer(new Media(f.toURI().toString()));
            ant.play();
            reproductorVideos.setMediaPlayer(ant);
        });
        botones.getChildren().addAll(anterior,siguiente);
         */
        izquierda.getChildren().addAll(reproductorVideos, botones);

        return izquierda;
    }

    public static int generarTurno() {
        return ++turno;
    }

    public class tiempo implements Runnable {

        @Override
        public void run() {

            while (true) {
                try {
                    LocalDateTime hora = LocalDateTime.now();
                    Platform.runLater(() -> {

                        tiempo.setText(String.valueOf(hora.getHour()) + " : " + String.valueOf(hora.getMinute()) + " : " + String.valueOf(hora.getSecond()));
                        tiempo.setTextFill(Color.web("#2E86C1"));
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public MediaView crearMediaView(ListIterator<String> direcciones) {
        MediaView mediaView = new MediaView();
        iniciarlizarMediaPlayer(mediaView, direcciones);
        return mediaView;
    }

    private void iniciarlizarMediaPlayer(final MediaView mediaView, final ListIterator<String> direcciones) {
        if (direcciones.hasNext()) {
            File f = new File(direcciones.next());
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> {
                iniciarlizarMediaPlayer(mediaView, direcciones);
            });
            mediaView.setOnMouseClicked(e -> {
                if (mediaView.getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaView.getMediaPlayer().pause();
                } else if (mediaView.getMediaPlayer().getStatus() == MediaPlayer.Status.PAUSED) {

                    mediaView.getMediaPlayer().play();
                }
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
