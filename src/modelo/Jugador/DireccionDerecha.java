package modelo.Jugador;

import modelo.Mapa.Posicion;

public class DireccionDerecha extends Direccion {
    @Override
    public Posicion posicionSiguiente(Posicion posicion) {
        int nuevaI = posicion.getPosicionI();
        int nuevaJ = posicion.getPosicionJ()+1;
        Posicion posicionSiguiente = new Posicion(nuevaI , nuevaJ);
        return  posicionSiguiente;
    }
}
