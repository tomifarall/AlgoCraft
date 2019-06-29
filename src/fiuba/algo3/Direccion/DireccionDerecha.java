package fiuba.algo3.Direccion;

import fiuba.algo3.Mapa.Posicion;

public class DireccionDerecha extends Direccion {
    @Override
    public Posicion posSiguiente(Posicion posicion) {
        int nuevaI = posicion.getPosicionI();
        int nuevaJ = posicion.getPosicionJ()+1;
        Posicion posicionSiguiente = new Posicion(nuevaI , nuevaJ);
        return  posicionSiguiente;
    }
}
