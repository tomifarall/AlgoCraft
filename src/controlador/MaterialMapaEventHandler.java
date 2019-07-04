package controlador;

import vista.aplicacion.ContenedorMapaJuego;
import modelo.Herramientas.HerramientaRotaException;
import modelo.Juego.Juego;
import modelo.Jugador.InventarioLlenoException;
import modelo.Jugador.NoSePuedeGolpearUnMaterialSinHerramientaEnManoException;
import modelo.Mapa.Posicion;
import modelo.Mapa.PosicionNoAdyacenteException;
import modelo.Materiales.Material;
import modelo.Materiales.NoSePuedeRecolectarUnMaterialNoDestruidoException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;


public class MaterialMapaEventHandler implements EventHandler<MouseEvent> {

    private ContenedorMapaJuego contenedorMapaJuego;
    private AdministradorDeTableros administradorDeTableros;
    private int posicionIMaterial;
    private int posicionJMaterial;
    private Juego juego;

    public MaterialMapaEventHandler(ContenedorMapaJuego contenedorMapaJuego, AdministradorDeTableros administradorDeTableros, int indiceI, int indiceJ, Juego juego) {
        this.contenedorMapaJuego = contenedorMapaJuego;
        this.administradorDeTableros = administradorDeTableros;
        this.posicionIMaterial = indiceI;
        this.posicionJMaterial = indiceJ;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent event) {
        String musicFile = "src\\vista\\sonidos\\sonidogolpe.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        Posicion posicionMaterial = new Posicion(posicionIMaterial, posicionJMaterial);
        Material material = juego.getMapa().obtenerMaterialEnPosicion(posicionMaterial);
        try {
            juego.jugadorGolpearMaterial(posicionMaterial);
            mediaPlayer.play();
            contenedorMapaJuego.actualizarVentanaDeMensajes("Adquiriste un nuevo material");
            contenedorMapaJuego.actualizarVentanaDurabilidadHerramientaEnMano("Durabilidad restante de herramienta en mano:" + juego.getJugador().getHerramientaEnMano().getDurabilidad());
        }catch(NoSePuedeRecolectarUnMaterialNoDestruidoException e) {
            mediaPlayer.play();
            contenedorMapaJuego.actualizarVentanaDeMensajes("Golpeaste al material, durabilidad restante:" + material.getDurabilidad());
            contenedorMapaJuego.actualizarVentanaDurabilidadHerramientaEnMano("Durabilidad restante de herramienta en mano:" + juego.getJugador().getHerramientaEnMano().getDurabilidad());
        }catch (InventarioLlenoException e){
            mediaPlayer.play();
            contenedorMapaJuego.actualizarVentanaDeMensajes("Insuficiente espacio en inventario para recolectar el material");
            contenedorMapaJuego.actualizarVentanaDurabilidadHerramientaEnMano("Durabilidad restante de herramienta en mano:" + juego.getJugador().getHerramientaEnMano().getDurabilidad());
        }catch(NoSePuedeGolpearUnMaterialSinHerramientaEnManoException e){
            contenedorMapaJuego.actualizarVentanaDeMensajes("Necesitás una herramienta en mano para golpear un material");
        }catch(HerramientaRotaException e){
            String musicFile2 = "src\\vista\\sonidos\\sonidoherramientarota.mp3";
            Media sound2 = new Media(new File(musicFile2).toURI().toString());
            MediaPlayer mediaPlayer2 = new MediaPlayer(sound2);
            mediaPlayer.play();
            mediaPlayer2.play();
            contenedorMapaJuego.actualizarVentanaDeMensajes("Se rompió la herramienta");
            administradorDeTableros.redibujarTableroHerramientaEnMano(juego);
            contenedorMapaJuego.actualizarVentanaDurabilidadHerramientaEnMano("No hay herramienta en mano");
        }catch(PosicionNoAdyacenteException e){
            contenedorMapaJuego.actualizarVentanaDeMensajes("El material está muy lejos para golpearlo");
        }
        administradorDeTableros.redibujarMapa(juego,posicionMaterial);
        administradorDeTableros.redibujarInventario(juego);
    }
}
