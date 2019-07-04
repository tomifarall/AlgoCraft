package vista.aplicacion;

import controlador.BotonCambioDeEscenaEventHandler;
import controlador.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorMenuJuego extends VBox {
    Stage stage;

    public ContenedorMenuJuego(Stage stage, Scene proximaEscena) {

        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(70);
        this.setPadding(new Insets(25));
        this.inicializarMusicaDeFondo();
        this.inicializarMensajesYFondoDePantalla();
        this.generarBotonJugar(proximaEscena);
        this.generarBotonInstrucciones(proximaEscena);
        this.generarBotonSalir();
    }

    private void inicializarMusicaDeFondo(){
        String musicFile = "src\\vista\\sonidos\\cancioninicio.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    private void inicializarMensajesYFondoDePantalla(){
        Image imagenLogo = new Image("vista\\imagenes\\AlgoCraft.png");
        Label labelImagen = new Label();
        labelImagen.setGraphic(new ImageView(imagenLogo));
        labelImagen.setAlignment(Pos.TOP_CENTER);
        Image imagen = new Image("vista\\imagenes\\fondominecraft.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        Label mensajeInicio = new Label();
        ImageView imagenMensajeInicio = new ImageView("vista\\imagenes\\mensajeinicio.png");
        imagenMensajeInicio.setFitHeight(40);
        imagenMensajeInicio.setFitWidth(1200);
        mensajeInicio.setGraphic(imagenMensajeInicio);
        this.getChildren().addAll(labelImagen,mensajeInicio);
    }

    private void generarBotonJugar(Scene proximaEscena){
        Image imagenBotonJugar = new Image("vista\\imagenes\\pico.jpg");
        ImageView imageViewJugar = new ImageView(imagenBotonJugar);
        imageViewJugar.setFitHeight(40);
        imageViewJugar.setFitWidth(40);
        Button botonJugar = new Button("Jugar.");
        botonJugar.setGraphic(imageViewJugar);
        botonJugar.setAlignment(Pos.CENTER);
        botonJugar.setMinSize(190,45);
        BotonCambioDeEscenaEventHandler botonJugarHandler = new BotonCambioDeEscenaEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
        this.getChildren().add(botonJugar);
    }

    private void generarBotonInstrucciones(Scene proximaEscena){
        Button botonInstrucciones = new Button("Instrucciones del juego.");
        ContenedorInstruccionesDelJuego contenedorInstruccionesDelJuego= new ContenedorInstruccionesDelJuego(stage,proximaEscena);
        Scene escenaInstrucciones = new Scene(contenedorInstruccionesDelJuego,640,480);
        BotonCambioDeEscenaEventHandler eventHandlerInstrucciones = new BotonCambioDeEscenaEventHandler(stage,escenaInstrucciones);
        Image imagenInstrucciones = new Image("vista\\imagenes\\imageninstrucciones.png");
        ImageView imageviewInstrucciones = new ImageView(imagenInstrucciones);
        imageviewInstrucciones.setFitWidth(40);
        imageviewInstrucciones.setFitHeight(40);
        botonInstrucciones.setGraphic(imageviewInstrucciones);
        botonInstrucciones.setMinSize(190,45);
        botonInstrucciones.setOnAction(eventHandlerInstrucciones);
        this.getChildren().add(botonInstrucciones);
    }

    private void generarBotonSalir(){
        Button botonSalida = new Button("Salir.");
        BotonSalirEventHandler eventHandlerSalida = new BotonSalirEventHandler(botonSalida);
        botonSalida.setOnAction(eventHandlerSalida);
        Image imagenBotonSalida = new Image("vista\\imagenes\\imagensalida.png");
        ImageView imageviewSalida = new ImageView(imagenBotonSalida);
        imageviewSalida.setFitHeight(40);
        imageviewSalida.setFitWidth(40);
        botonSalida.setGraphic(imageviewSalida);
        botonSalida.setMinSize(190,45);
        this.getChildren().add(botonSalida);
    }
}
