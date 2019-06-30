package fiuba.algo3.Jugador;

import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Direccion.*;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Interfaces.IColeccionable;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Mapa.*;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.NoSePuedeRecolectarUnMaterialNoDestruidoException;

public class Jugador implements IMapeable {

    private Inventario inventario;
    private Herramienta herramientaEnMano;
    private Mapa mapa;
    private Posicion posicionHerramientaEnMano;

    public Jugador(Mapa mapajuego) {
        inventario = new Inventario();
        herramientaEnMano = crearHachaInicial();
        mapa = mapajuego;
        this.setPosicion(new Posicion(25,25));
    }

    private Hacha crearHachaInicial() {
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);
        this.inventario.agregar(hacha);
        return hacha;
    }

    public  void movete(Direccion direccion){
        try {
            this.mapa.actualizarPosicion(this, direccion);
        }
        catch (PosicionInvalidaException e){}

    }
    @Override
    public Posicion getPosicion() {
        return mapa.getPosicionJugador();
    }

    @Override
    public void setPosicion(Posicion posicion) {
        this.mapa.setPosicionJugadorCreado(posicion,this);

    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public boolean esIgual(IMapeable elemento) {
        return false;
    }

    public void golpearMaterial(IMaterialMapa material, Posicion posicion){
        try {
            mapa.verificarAdyacenciaConPos(posicion);
            this.herramientaEnMano.golpearMaterial(material);
            recolectarMaterial(material,posicion);
        }catch (PosicionNoAdyacente e){ throw e;
        }catch(NoSePuedeRecolectarUnMaterialNoDestruidoException e){
        }catch (NoSePuedeUsarSinDurabilidadException e){
            this.inventario.eliminar(herramientaEnMano);
        }
    }

    public void recolectarMaterial(IMaterialMapa material, Posicion posicion){
        try{
            material.serRecolectado();
        }catch(NoSePuedeRecolectarUnMaterialNoDestruidoException e){
            throw e;
        }
        IColeccionable materialMapa = (IColeccionable) this.mapa.eliminarElemento(posicion);
        this.inventario.agregar(materialMapa);
    }

    public int getCantidadElementosInventario(){
        return inventario.getCantidadElementos();
    }

    public void setHerramientaEnMano(Posicion posicion){
        try {
            this.herramientaEnMano = (Herramienta) this.inventario.getElemento(posicion);
        }catch(PosicionInvalidaException e){}
    }


}
