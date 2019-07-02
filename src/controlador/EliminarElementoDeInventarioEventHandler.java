package controlador;

import modelo.Juego.Juego;
import modelo.Mapa.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EliminarElementoDeInventarioEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Posicion posicionElemento;
    private AdministradorDeTableros administradorDeTableros;

    public EliminarElementoDeInventarioEventHandler(Juego juego, Posicion posicionElemento,AdministradorDeTableros administradorDeTableros){
       this.juego = juego;
       this.posicionElemento = posicionElemento;
       this.administradorDeTableros = administradorDeTableros;
    }

    @Override
    public void handle(ActionEvent event) {
        juego.eliminarDeInventario(posicionElemento);
        administradorDeTableros.redibujarInventario(juego);
        administradorDeTableros.redibujarTableroHerramientaEnMano(juego);
    }
}
