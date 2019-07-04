package modelo.Jugador;

import modelo.Mapa.Posicion;

public class DireccionArriba extends Direccion {

    @Override
    public Posicion posicionSiguiente(Posicion posicion) {
        int nuevaI = posicion.getPosicionI() -1;
        int nuevaJ = posicion.getPosicionJ();
        Posicion posicionSiguiente = new Posicion(nuevaI , nuevaJ);
        return  posicionSiguiente;
    }
}
