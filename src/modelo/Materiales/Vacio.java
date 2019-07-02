package modelo.Materiales;


import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Mapa.Posicion;

public class Vacio  implements IColeccionable, IMapeable {

    @Override
    public String getTipo(){ return "vacio";}

    @Override
    public Posicion getPosicion() {
        return null;
    }

    @Override
    public void setPosicion(Posicion posicion) {   //VER DESPUESSS
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
