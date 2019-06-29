package fiuba.algo3.Mapa;

import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Materiales.Vacio;

public class Casillero {

    private IMapeable ocupante;


    public  Casillero(){
        this.ocupante = new Vacio();

    }

    public void ocuparCon(IMapeable ocupante) {
        if (!this.ocupante.esVacio()) {
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
