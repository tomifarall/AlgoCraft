package modelo.Jugador;

import modelo.Herramientas.Herramienta;
import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Mapa.Posicion;
import modelo.Materiales.Material;

import java.util.HashMap;

public class Inventario {

    private HashMap<Posicion,IColeccionable> elementosAlmacenados;
    private int cantidadDeEspacios;
    private Jugador jugador;
    private Posicion posicionHerramientaEnMano;
    private int cantidadDeElementosAlmacenados;

    public Inventario(Jugador jugador){
        this.elementosAlmacenados = new HashMap<>();
        this.cantidadDeEspacios = 15;
        this.jugador = jugador;
        this.cantidadDeElementosAlmacenados = 0;
    }

    public HashMap<Posicion,IColeccionable> getInventario(){
        return elementosAlmacenados;
    }

    public void agregar(IColeccionable elemento){
        if (this.cantidadDeElementosAlmacenados >= this.cantidadDeEspacios){
            throw new InventarioLlenoException();
        }
        Posicion nuevaPosicionElemento = this.obtenerPrimeraPosicionVacia();   //NO SIGUE ESTO SI SE TIRA LA EXCEPCION????
        elementosAlmacenados.put(nuevaPosicionElemento,elemento);
        this.cantidadDeElementosAlmacenados++;
    }

    public Posicion obtenerPrimeraPosicionVacia(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<5; j++){
                Posicion posicionTablero = new Posicion(i,j);
                Object coleccionable = elementosAlmacenados.get(posicionTablero);
                if (coleccionable == null) return posicionTablero;
            }
        }
        throw new InventarioLlenoException();
    }

    public Herramienta elegirNuevaHerramientaEnMano(Posicion posicion){
        posicionHerramientaEnMano = posicion;
        return (Herramienta)elementosAlmacenados.get(posicion);
    }

    public void eliminar(Posicion posicionElemento){
        elementosAlmacenados.replace(posicionElemento,null);
        if (posicionElemento.equals(posicionHerramientaEnMano)){
            jugador.eliminarHerramientaEnManoActual();
            posicionHerramientaEnMano = null;
        }
        this.cantidadDeElementosAlmacenados--;

    }

    public void eliminarHerramientaEnMano(){
        this.eliminar(posicionHerramientaEnMano);
    }

}
