package controlador;

import modelo.Jugador.DireccionDerecha;
import modelo.Jugador.DireccionIzquierda;
import modelo.Jugador.DireccionAbajo;
import modelo.Jugador.DireccionArriba;
import modelo.Jugador.Direccion;
import vista.aplicacion.ContenedorMapaJuego;
import modelo.Juego.Juego;
import modelo.Mapa.CasilleroOcupadoException;
import modelo.Mapa.Posicion;
import modelo.Mapa.PosicionInvalidaException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import static javafx.scene.input.KeyCode.*;

public class MovimientosMapaEventHandler implements EventHandler<KeyEvent> {

    private ContenedorMapaJuego contenedorMapaJuego;
    private AdministradorDeTableros administradorDeTableros;
    private Juego juego;

    public MovimientosMapaEventHandler(ContenedorMapaJuego contenedorMapaJuego, AdministradorDeTableros administradorDeTableros, Juego juego){
        this.contenedorMapaJuego = contenedorMapaJuego;
        this.administradorDeTableros = administradorDeTableros;
        this.juego = juego;
    }

    @Override
    public void handle(KeyEvent event){
        if (event.getCode().equals(UP) | event.getCode().equals(W)) this.moverJugadorHacia(new DireccionArriba());
        if (event.getCode().equals(DOWN) | event.getCode().equals(S)) this.moverJugadorHacia(new DireccionAbajo());
        if (event.getCode().equals(RIGHT) | event.getCode().equals(D)) this.moverJugadorHacia(new DireccionDerecha());
        if (event.getCode().equals(LEFT) | event.getCode().equals(A)) this.moverJugadorHacia(new DireccionIzquierda());
    }

    public void moverJugadorHacia(Direccion direccion){
        String musicFile = "src\\vista\\sonidos\\sonidocaminar.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        Posicion posicionJugador = juego.getJugador().getPosicion();
        try{
            juego.moverJugador(direccion);
            mediaPlayer.play();
            Posicion nuevaPosicionJugador = juego.getJugador().getPosicion();
            administradorDeTableros.redibujarMapa(juego, posicionJugador, nuevaPosicionJugador);
            contenedorMapaJuego.actualizarVentanaDeMensajes("");
        }catch (PosicionInvalidaException | CasilleroOcupadoException e){ contenedorMapaJuego.actualizarVentanaDeMensajes("No es posible moverse hacia esa dirección");   }
    }

}
