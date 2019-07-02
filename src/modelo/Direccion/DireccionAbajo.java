package modelo.Direccion;

import modelo.Mapa.Posicion;

public class DireccionAbajo extends Direccion {
    @Override
    public Posicion posicionSiguiente(Posicion posicion) {
        int nuevaI = posicion.getPosicionI() + 1;
        int nuevaJ = posicion.getPosicionJ();
        Posicion posicionSiguiente = new Posicion(nuevaI , nuevaJ);
        return  posicionSiguiente;
    }
}
