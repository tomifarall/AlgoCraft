package fiuba.algo3.Interfaces;
import fiuba.algo3.Mapa.Posicion;

public interface IMapeable {

    Posicion getPosicion();

    void setPosicion(Posicion posicion);

    boolean esVacio();

    boolean esIgual(IMapeable elemento);
}
