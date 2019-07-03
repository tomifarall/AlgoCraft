package modelo.Mapa;

import modelo.Interfaces.IMapeable;
import modelo.Materiales.Vacio;

public class Casillero {

    private IMapeable ocupante;
    private Posicion posicion;

    public  Casillero(){
        this.ocupante = new Vacio();
    }

    public  Posicion getPosicion(){
        return  this.posicion;
    }

    public void ocuparCon(IMapeable ocupante) {
        if (this.ocupante != null && !this.ocupante.esVacio()) {
            throw new CasilleroOcupadoException();
        } else {
            this.ocupante = ocupante;
        }
    }

    public IMapeable removeOcupante(){
        if (this.ocupante.esVacio()){
            throw new NoSePuedeEliminarUnElementoVacioException();
        }
        IMapeable ocupanteActual = this.ocupante;
        this.ocupante = new Vacio();
        return ocupanteActual;
    }

    public IMapeable getOcupante(){
        return ocupante;
    }

}
