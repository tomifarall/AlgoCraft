package modelo.Interfaces;

import modelo.Mapa.Posicion;

public interface IMapeable {

    Posicion getPosicion();

    void setPosicion(Posicion posicion);

    String getTipo();

    boolean esIgual(IMapeable elemento);

    boolean esVacio();
}
