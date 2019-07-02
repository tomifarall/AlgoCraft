package controlador;

import vista.aplicacion.ContenedorMapaJuego;
import modelo.Juego.Juego;
import modelo.Jugador.InventarioLlenoException;
import modelo.Moldes.MoldeInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private ContenedorMapaJuego contenedorMapaJuego;
    private AdministradorDeTableros administradorDeTableros;

    public BotonCrearEventHandler(Juego juego, ContenedorMapaJuego contenedorMapaJuego,AdministradorDeTableros administradorDeTableros){
        this.juego = juego;
        this.contenedorMapaJuego = contenedorMapaJuego;
        this.administradorDeTableros = administradorDeTableros;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.crearEnCraftingTable();
            administradorDeTableros.redibujarTableroCraftingTable(juego);
            administradorDeTableros.redibujarInventario(juego);
        }catch (MoldeInvalidoException e){
            contenedorMapaJuego.actualizarVentanaDeMensajes("No se puede crear una herramienta, molde de craft incorrecto");
        }catch(InventarioLlenoException e){
            contenedorMapaJuego.actualizarVentanaDeMensajes("El inventario está lleno, perdiste la herramienta creada");
            administradorDeTableros.redibujarTableroCraftingTable(juego);
        }
    }
}
