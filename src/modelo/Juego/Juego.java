package modelo.Juego;

import modelo.Desgastes.HerramientaRotaException;
import modelo.Direccion.*;
import modelo.Herramientas.Herramienta;
import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Jugador.InventarioLlenoException;
import modelo.Jugador.Jugador;
import modelo.Jugador.NoSePuedeGolpearUnMaterialSinHerramientaEnManoException;
import modelo.Mapa.*;
import modelo.Materiales.Material;
import modelo.Materiales.NoSePuedeRecolectarUnMaterialNoDestruidoException;
import modelo.Moldes.MoldeInvalidoException;

import java.util.HashMap;

public class Juego {

    Mapa mapa;
    Jugador jugador;
    Direccion derecha;
    Direccion izquierda;
    Direccion arriba;
    Direccion abajo;


    public Juego() {
        mapa = Mapa.getMapa();
        jugador = new Jugador(mapa);
        derecha = new DireccionDerecha();
        izquierda = new DireccionIzquierda();
        arriba = new DireccionArriba();
        abajo = new DireccionAbajo();
    }

    //GETTERS QUE CAPAZ SE PUEDAN SACAR
    public Jugador getJugador(){ return jugador;}


    public void agregarMaterialAMesaDeCrafteo(Material material, Posicion posicion){
        jugador.ponerMaterialEnMesaDeCrafteo(material,posicion);
    }

    public HashMap<Posicion,IColeccionable> getInventarioJugador(){
        return jugador.getInventario();
    }

    public Mapa getMapa(){return mapa;}

    public HashMap<Posicion, Casillero> getMapaJuego(){ return mapa.getTableroMapa();}

    public HashMap<Posicion,Casillero> getMesaDeCrafteoJugador(){
        return jugador.getMesaDeCrafteo();
    }

    public void moverJugador(Direccion direccionMovimiento){
        try {
            jugador.movete(direccionMovimiento);
        }
        catch (PosicionInvalidaException | CasilleroOcupadoException e){
            throw e;
        }
    }

    public void jugadorGolpearMaterial(Posicion posicion){
        Material material = this.mapa.obtenerMaterialEnPosicion(posicion);
        try {
            jugador.golpearMaterial(material, posicion);
        }catch (NoSePuedeRecolectarUnMaterialNoDestruidoException |
                InventarioLlenoException |
                NoSePuedeGolpearUnMaterialSinHerramientaEnManoException |
                HerramientaRotaException |
                PosicionNoAdyacenteException e){
            throw e;
        }
    }

    public IMapeable obtenerMaterialEnPosicion(int I, int J){
        Posicion posicion = new Posicion(I,J);
       // IMapeable material = mapa.obtenerMaterialEnPosicion(posicion);
        return null;
    }

    public void eliminarDeInventario(Posicion posicionMaterial) {
        jugador.eliminarElementoDelInventario(posicionMaterial);
    }

    public void elegirNuevaHerramientaEnMano(Posicion posicionHerramientaEnInventario){
        jugador.seleccionarNuevaHerramientaEnMano(posicionHerramientaEnInventario);
    }

    public void eliminarMaterialDeMesaDeCrafteo(Posicion posicionElementoEnMesaDeCrafteo){
        try {
            jugador.eliminarMaterialEnMesaDeCrafteo(posicionElementoEnMesaDeCrafteo);
        }catch(InventarioLlenoException e){
            throw e;
        }
    }

    public Herramienta crearEnCraftingTable(){
        try{
            Herramienta nuevaHerramienta = jugador.crearHerramienta();
            jugador.agregarElementoAlInventario(nuevaHerramienta);
            return nuevaHerramienta;
        }catch (MoldeInvalidoException | InventarioLlenoException e){
            throw e;
        }
    }

}