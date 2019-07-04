
import modelo.Direccion.Direccion;
import modelo.Direccion.DireccionIzquierda;
import modelo.Interfaces.IMapeable;
import modelo.Jugador.Jugador;
import modelo.Mapa.Casillero;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import modelo.Mapa.PosicionNoAdyacenteException;
import modelo.Materiales.Vacio;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class MapaTest {

    @Test
    public void Test01MapaSePuedeCrearCorrectamente(){
        Mapa mapa = Mapa.getMapa();

        Assert.assertNotNull(mapa);
    }



    @Test
    public void Test02MapaDeberiaDevolverLaPosicionDelJugador(){

        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posJugador = new Posicion(25,25);

        assert posJugador.equals(mapa.getPosicionJugador());



    }

    @Test
    public  void Test03MapaDeberiaSerCapazDeSetearLaPosicionDelJugador(){
        Mapa mapa = Mapa.getMapa();
        Posicion posicionNueva = new Posicion(25,20);
        Jugador jugador = new Jugador(mapa);
        mapa.setPosicionJugadorCreado(posicionNueva,jugador);
    }

    @Test
    public void Test04MapaDeberiaSerCapazDeActualizarLaPosicionDelJugadorAUnaDeSusAdyacentes(){
        Mapa mapa = Mapa.getMapa();
        Posicion posicionNueva = new Posicion(25,24);
        Jugador jugador = new Jugador(mapa);
        Direccion direccionIzquierda = new DireccionIzquierda();
        mapa.actualizarPosicion(jugador,direccionIzquierda);

        assert mapa.getPosicionJugador().equals(posicionNueva);
    }

    @Test
    public void Test06MapaDeberiaSerCapazDeDevolverUnMaterialDeUnaPosicion(){
        Mapa mapa = Mapa.getMapa();
        Posicion posicionElemento = new Posicion(26,20); //Posicion de una Madera
        HashMap<Posicion, Casillero> tablero = mapa.getTableroMapa();
        Casillero casilleroElementoEliminado = tablero.get(posicionElemento);
        IMapeable material = casilleroElementoEliminado.getOcupante();


        assert  material.esIgual((mapa.obtenerMaterialEnPosicion(posicionElemento)));


    }
    @Test
    public  void  Test06MapaDeberiaSerCapazDeEliminarUnElemtento(){
        Mapa mapa = Mapa.getMapa();
        Posicion posicionElemento = new Posicion(26,20); //Posicion de una Madera
        mapa.eliminarElemento(posicionElemento);
        HashMap<Posicion, Casillero> tablero = mapa.getTableroMapa();
        Casillero casilleroElementoEliminado = tablero.get(posicionElemento);


        assert  new Vacio().esIgual(casilleroElementoEliminado.getOcupante());
    }


    @Test
    public void Test07MapaDeberiaSaberSiLaPosicionDadaEsAdyacenteALaPosicionDelJugador(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicionDada = new Posicion(26,25);
        mapa.verificarAdyacenciaConPosicion(posicionDada);
    }

    @Test  (expected = PosicionNoAdyacenteException.class)
    public void  Test08MapaDeberiaLanzarUnaExcepcionSiLaPosicionDadaNoEsAdyacenteALaPosDelJugador(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicionDada = new Posicion(30,30);
        mapa.verificarAdyacenciaConPosicion(posicionDada);

    }
}
