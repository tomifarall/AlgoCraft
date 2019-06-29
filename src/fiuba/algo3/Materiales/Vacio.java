package fiuba.algo3.Materiales;


import fiuba.algo3.Interfaces.IColeccionable;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Mapa.Posicion;

public class Vacio  implements IColeccionable, IMapeable {

    @Override
    public Posicion getPosicion() {
        return null;
    }

    @Override
    public void setPosicion(Posicion posicion) {

    }

    @Override
    public boolean esVacio() {
        return true;
    }

    @Override
    public boolean esIgual(IMapeable elemento) {
        return elemento.esVacio();
    }
}
