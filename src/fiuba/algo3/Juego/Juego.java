package fiuba.algo3.Juego;

import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Direccion.*;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Jugador.Jugador;
import fiuba.algo3.Mapa.Casillero;
import fiuba.algo3.Mapa.Mapa;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.Material;

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

    public void moverJugadorDerecha() {
        jugador.movete(derecha);
    }

    public void moverJugadorIzquierda() {
        jugador.movete(izquierda);
    }

    public void moverJugadorArriba() {
        jugador.movete(arriba);
    }
    public void moverJugadorAbajo() {
        jugador.movete(abajo);
    }

    public int jugadorGolpearMaterial(Posicion posicion){
        Material material = this.mapa.obtenerMaterialEnPosicion(posicion);
        jugador.golpearMaterial(material, posicion );
        return material.getDurabilidad(); //ME HAGO UN METODO APARTE ?
    }

    public IMapeable obtenerMaterialEnPos(int I, int J){
        Posicion posicion= new Posicion(I,J);
       // IMapeable material = mapa.obtenerMaterialEnPos(posicion);
        return null;
    }

    public HashMap <Posicion, Casillero> getTableroJuego(){
        return  this.mapa.getTablero();
    }
}