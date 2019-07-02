package controlador;

import vista.aplicacion.ContenedorMapaJuego;
import modelo.Juego.Juego;
import modelo.Mapa.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;

public class HerramientaInventarioEventHandler implements EventHandler<MouseEvent> {

    private ImageView herramientaInventario;
    private AdministradorDeTableros administradorDeTableros;
    private Posicion posicionHerramienta;
    private Juego juego;
    private ContenedorMapaJuego contenedorMapaJuego;

    public HerramientaInventarioEventHandler(ImageView herramientaInventario, AdministradorDeTableros administradorDeTableros, Posicion posicionHerramienta, Juego juego, ContenedorMapaJuego contenedorMapaJuego) {
        this.herramientaInventario = herramientaInventario;
        this.administradorDeTableros = administradorDeTableros;
        this.posicionHerramienta = posicionHerramienta;
        this.juego = juego;
        this.contenedorMapaJuego = contenedorMapaJuego;
    }

    @Override
    public void handle(MouseEvent event) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem modificarHerramientaEnMano = new MenuItem("Elegir como herramienta en mano");
        modificarHerramientaEnMano.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evento) {
                juego.elegirNuevaHerramientaEnMano(posicionHerramienta);
                administradorDeTableros.redibujarTableroHerramientaEnMano(juego);
                administradorDeTableros.redibujarTableroHerramientaEnMano(juego);
                contenedorMapaJuego.actualizarVentanaDurabilidadHerramientaEnMano("Durabilidad de herramienta en mano:" + juego.getJugador().getHerramientaEnMano().getDurabilidad());
            }
        });
        MenuItem eliminarDeInventario = new MenuItem("Eliminar elemento de inventario");
        EliminarElementoDeInventarioEventHandler eliminarDeInventarioEventHandler = new EliminarElementoDeInventarioEventHandler(juego,posicionHerramienta,administradorDeTableros);
        eliminarDeInventario.setOnAction(eliminarDeInventarioEventHandler);
        contextMenu.getItems().addAll(modificarHerramientaEnMano,eliminarDeInventario);
        herramientaInventario.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent evento2) {
                contextMenu.show(herramientaInventario, evento2.getScreenX(), evento2.getScreenY());
            }
        });

    }
}


