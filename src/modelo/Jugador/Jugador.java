package modelo.Jugador;

import modelo.Desgastes.HerramientaRotaException;
import modelo.Direccion.*;
import modelo.Herramientas.Hacha;
import modelo.Herramientas.Herramienta;
import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Interfaces.IMaterialMapa;
import modelo.Mapa.*;
import modelo.Materiales.Madera;
import modelo.Materiales.Material;
import modelo.Materiales.NoSePuedeRecolectarUnMaterialNoDestruidoException;
import modelo.Moldes.MoldeInvalidoException;

import java.util.HashMap;

public class Jugador implements IMapeable {

    private Inventario inventario;
    private Herramienta herramientaEnMano;
    private Mapa mapa;
    private MesaDeCrafteo mesaDeCrafteo;

    public Jugador(Mapa mapajuego) {
        inventario = new Inventario(this);
        herramientaEnMano = crearHachaInicial();
        mesaDeCrafteo = new MesaDeCrafteo();
        mapa = mapajuego;
        this.setPosicion(new Posicion(25, 25));
    }


    private Hacha crearHachaInicial() {
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);
        inventario.agregar(hacha);
        inventario.elegirNuevaHerramientaEnMano(new Posicion(0,0));
        return hacha;
    }

    public  void movete(Direccion direccion){
        try {
            this.mapa.actualizarPosicion(this, direccion);
        }
        catch (PosicionInvalidaException | CasilleroOcupadoException e){
            throw e;
        }
    }

    public void golpearMaterial(IMaterialMapa material, Posicion posicion){
        if (herramientaEnMano == null) throw new NoSePuedeGolpearUnMaterialSinHerramientaEnManoException();  //VER DESPUÉS BIEN EN QUE PAQUETE PONER LA ÚLTIMA EXCEPCIÓN
        try{
            mapa.verificarAdyacenciaConPosicion(posicion);
            herramientaEnMano.golpearMaterial(material);
            recolectarMaterial(material,posicion);
        }catch(NoSePuedeRecolectarUnMaterialNoDestruidoException |
                InventarioLlenoException |
                PosicionNoAdyacenteException e){
            throw e;
        }catch(HerramientaRotaException e){
            inventario.eliminarHerramientaEnMano();
            this.eliminarHerramientaEnManoActual();
            try{
                recolectarMaterial(material,posicion);
            }catch (NoSePuedeRecolectarUnMaterialNoDestruidoException | InventarioLlenoException e2){throw e;}
            throw e;
        }
    }

    public void recolectarMaterial(IMaterialMapa material, Posicion posicion){
        try{
            material.serRecolectado();
            this.mapa.eliminarElemento(posicion);
            this.inventario.agregar((IColeccionable) material);
        }catch(NoSePuedeRecolectarUnMaterialNoDestruidoException | InventarioLlenoException e){
            throw e;
        }
    }

    public HashMap<Posicion,Casillero> getMesaDeCrafteo(){
        return mesaDeCrafteo.getTablero();
    }

    public void ponerMaterialEnMesaDeCrafteo(Material material, Posicion posicion){
        mesaDeCrafteo.agregarMaterial(material, posicion);       //EXCEPCION EN CASO DE ESTAR LLENA?????? //probar que pasa con la interfaz grafica
    }

    public void eliminarMaterialEnMesaDeCrafteo(Posicion posicionMaterialEnMesaDeCrafteo){
        Material materialEliminadoDeMesaDeCrafteo = mesaDeCrafteo.eliminarMaterial(posicionMaterialEnMesaDeCrafteo);
        try {
            inventario.agregar(materialEliminadoDeMesaDeCrafteo);
        }catch (InventarioLlenoException e){
            throw e;
        }
    }

    public void agregarElementoAlInventario(IColeccionable elemento){
        inventario.agregar(elemento);
    }

    public void eliminarElementoDelInventario(Posicion posicionElemento) {
        inventario.eliminar(posicionElemento);
    }

    public HashMap<Posicion, IColeccionable> getInventario() {
        return inventario.getInventario();
    }

    public void seleccionarNuevaHerramientaEnMano(Posicion posicionHerramientaEnInventario){
        herramientaEnMano = inventario.elegirNuevaHerramientaEnMano(posicionHerramientaEnInventario);
    }

    public void eliminarHerramientaEnManoActual(){
        this.herramientaEnMano = null;
    }

    public Herramienta getHerramientaEnMano() {
        return herramientaEnMano;
    }

    public Herramienta crearHerramienta(){
        try{
            Herramienta nuevaHerramienta = mesaDeCrafteo.craftear();
            return nuevaHerramienta;
        }catch (MoldeInvalidoException e){
            throw e;
        }
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
    public String getTipo() {
        return "jugador";  //SACAR DESPUES
    }

    @Override
    public boolean esIgual(IMapeable elemento) {
        return false;
    }

}

