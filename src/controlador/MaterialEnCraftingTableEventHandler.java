package controlador;

import vista.aplicacion.ContenedorMapaJuego;
import modelo.Juego.Juego;
import modelo.Jugador.InventarioLlenoException;
import modelo.Mapa.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class MaterialEnCraftingTableEventHandler implements EventHandler<MouseEvent> {

    private ContenedorMapaJuego contenedorMapaJuego;
    private AdministradorDeTableros administradorDeTableros;
    private GridPane tableroCraftingTable;
    private ImageView imageviewMaterial;
    private Juego juego;

    public MaterialEnCraftingTableEventHandler(ContenedorMapaJuego contenedorMapaJuego, AdministradorDeTableros administradorDeTableros, GridPane tableroCraftingTable, ImageView imageviewMaterial, Juego juego){
        this.contenedorMapaJuego = contenedorMapaJuego;
        this.administradorDeTableros = administradorDeTableros;
        this.tableroCraftingTable = tableroCraftingTable;
        this.imageviewMaterial = imageviewMaterial;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent event) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem eliminarDeCraftingTable = new MenuItem("Eliminar material de mesa de crafteo");
        eliminarDeCraftingTable.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evento) {
                Posicion posicionMaterial = administradorDeTableros.obtenerCoordenadasDeElementoEnGridPane(tableroCraftingTable,imageviewMaterial);
                try {
                    juego.eliminarMaterialDeMesaDeCrafteo(posicionMaterial);
                    administradorDeTableros.redibujarInventario(juego);
                }catch (InventarioLlenoException e){
                    contenedorMapaJuego.actualizarVentanaDeMensajes("El inventario está lleno, perdiste el material eliminado");
                }
                administradorDeTableros.redibujarTableroCraftingTable(juego);
            }
        });
        contextMenu.getItems().addAll(eliminarDeCraftingTable);
        imageviewMaterial.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent evento2) {
                contextMenu.show(imageviewMaterial, evento2.getScreenX(), evento2.getScreenY());
            }
        });

    }
}
