package controlador;

import modelo.Juego.Juego;
import modelo.Mapa.Posicion;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

public class MaterialInventarioEventHandler implements EventHandler<MouseEvent> {

    private Juego juego;
    private Posicion posicionMaterial;
    private AdministradorDeTableros administradorDeTableros;
    private ImageView imageviewMaterial;

    public MaterialInventarioEventHandler(Juego juego, Posicion posicionMaterial,AdministradorDeTableros administradorDeTableros,ImageView imageviewMaterial) {
        this.juego = juego;
        this.posicionMaterial = posicionMaterial;
        this.administradorDeTableros = administradorDeTableros;
        this.imageviewMaterial = imageviewMaterial;
    }

    @Override
    public void handle(MouseEvent event) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem eliminarDeInventario = new MenuItem("Eliminar elemento de inventario");
        EliminarElementoDeInventarioEventHandler eliminarDeInventarioEventHandler = new EliminarElementoDeInventarioEventHandler(juego,posicionMaterial,administradorDeTableros);
        eliminarDeInventario.setOnAction(eliminarDeInventarioEventHandler);
        contextMenu.getItems().addAll(eliminarDeInventario);
        imageviewMaterial.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent evento2) {
                contextMenu.show(imageviewMaterial, evento2.getScreenX(), evento2.getScreenY());
            }
        });
    }

}
