import modelo.Herramientas.Herramienta;
import modelo.Jugador.*;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import modelo.Materiales.Madera;
import modelo.Materiales.Material;
import org.junit.Assert;
import org.junit.Test;




public class JugadorTest {
    @Test
    public void Test01JugadorSeInicializaCorrectamente(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);

        Assert.assertNotNull(jugador);
    }

    @Test
    public void test02JugadorDeberiaInicializarseConUnHachaDeMadera(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Herramienta hacha = jugador.getHerramientaEnMano();

        Material madera = new Madera();
        int durabilidadMadera = madera.getDurabilidad();

        hacha.golpearMaterial(madera);

        Assert.assertEquals(durabilidadMadera-2, madera.getDurabilidad());
    }

    @Test
    public void test03JugadorPoderMoverseALaDerecha(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Direccion arriba = new DireccionArriba();
        Direccion derecha = new DireccionDerecha();

        for (int i= 0 ; i<2; i++){
            jugador.movete(arriba);
        }
        jugador.movete(derecha);

        Posicion posicionEsperada = new Posicion(23 ,26);


       assert posicionEsperada.equals(mapa.getPosicionJugador());
    }

    @Test
    public void test04JugadorPoderMoverseALaIzquierda(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Direccion izquierda = new DireccionIzquierda();

        jugador.movete(izquierda);

        Posicion posicionEsperada = new Posicion(25 ,24);


        assert posicionEsperada.equals(mapa.getPosicionJugador());
    }

    @Test
    public void test05JugadorPoderMoversehaciaArriba(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Direccion arriba = new DireccionArriba();

        jugador.movete(arriba);

        Posicion posicionEsperada = new Posicion(24 ,25);


        assert posicionEsperada.equals(mapa.getPosicionJugador());
    }

    @Test
    public void test06JugadorPoderMoversehaciaAbajo() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Direccion abajo = new DireccionAbajo();

        jugador.movete(abajo);

        Posicion posicionEsperada = new Posicion(26, 25);


        assert posicionEsperada.equals(mapa.getPosicionJugador());
    }




}
