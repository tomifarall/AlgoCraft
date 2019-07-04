package modelo.Mapa;

import modelo.Direccion.Direccion;

public class Posicion {

    private int posicionI;
    private int posicionJ;

    public  Posicion(int i , int j){
        this.posicionI = i;
        this.posicionJ = j;
    }

    public int getPosicionI(){
        return this.posicionI;
    }

    public int getPosicionJ(){
        return this.posicionJ;
    }

    public Posicion obtenerPosicionSiguiente(Direccion direccion) {
        return direccion.posicionSiguiente(this);
    }

    @Override
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Posicion)) {
            return false;
        }
        if (objeto == this) {
            return true;
        }
        Posicion otraPosicion = (Posicion) objeto;

        return ((this.getPosicionI() == otraPosicion.getPosicionI() )&& (this.getPosicionJ() == otraPosicion.getPosicionJ()));
    }

    @Override
        public int hashCode() {
            return (this.posicionI + this.posicionJ)*(this.posicionJ*this.posicionI) ;
    }
}



