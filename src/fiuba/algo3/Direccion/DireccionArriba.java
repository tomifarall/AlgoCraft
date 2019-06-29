package fiuba.algo3.Direccion;

import fiuba.algo3.Mapa.Posicion;

public class DireccionArriba extends Direccion {

    @Override
    public Posicion posSiguiente(Posicion posicion) {
        int nuevaI = posicion.getPosicionI() -1;
        int nuevaJ = posicion.getPosicionJ();
        Posicion posicionSiguiente = new Posicion(nuevaI , nuevaJ);
        return  posicionSiguiente;
    }
}
