import fiuba.algo3.Direccion.*;
import fiuba.algo3.Jugador.Jugador;
import fiuba.algo3.Mapa.*;
import org.junit.Test;


public class MovimientoTest {
    @Test
    public void test01Jugadorsemuevealaderechayseactualizasuposicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(23, 26);
        Direccion arriba = new DireccionArriba();
        Direccion derecha = new DireccionDerecha();

        jugador.movete(arriba);
        jugador.movete(arriba);
        jugador.movete(derecha);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test02JugadorSeMueveALaIzquierdaYSeActualizaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(25, 24);
        Direccion izquierda = new DireccionIzquierda();

        jugador.movete(izquierda);


        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test03JugadorSeMueveArribaYSeActualizaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(24, 25);
        Direccion arriba = new DireccionArriba();

        jugador.movete(arriba);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test04JugadorSeMueveAbajoYSeActualizaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(26, 25);
        Direccion abajo = new DireccionAbajo();

        jugador.movete(abajo);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test05JugadorSeMueveAbajoEIzquierdaYSeActualizaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(26, 23);
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();

        jugador.movete(abajo);
        jugador.movete(izquierda);
        jugador.movete(izquierda);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test06JugadorSeMueveDosVecesParaCadaLadoYVuelveASuPosicionOriginal() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(25, 25);
        Direccion derecha = new DireccionDerecha();
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();
        Direccion arriba = new DireccionArriba();

        jugador.movete(abajo);
        jugador.movete(izquierda);
        jugador.movete(derecha);
        jugador.movete(arriba);
        jugador.movete(izquierda);
        jugador.movete(abajo);
        jugador.movete(arriba);
        jugador.movete(derecha);

        assert posicion.equals(jugador.getPosicion());
    }


    @Test()
    public void test07JugadorTrataDeCruzarElBordeIzquierdoDelMapaYNoCambiaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(26, 0);
        Direccion izquierda = new DireccionIzquierda();
        Direccion abajo = new DireccionAbajo();

        for (int i = 0; i < 11; i++) {
            jugador.movete(izquierda);
        }
        jugador.movete(abajo);
        for (int i = 0; i < 19; i++) {
            jugador.movete(izquierda);
        }


        jugador.movete(izquierda);
        assert posicion.equals(jugador.getPosicion());
    }

    @Test()
    public void test08JugadorTrataDeCruzarElBordeDerechoDelMapaYNoCambiaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(22, 50);
        Direccion derecha = new DireccionDerecha();
        Direccion arriba = new DireccionArriba();

        jugador.movete(arriba);
        jugador.movete(arriba);
        jugador.movete(arriba);
        for (int i = 0; i < 28; i++) {
            jugador.movete(derecha);
        }

        jugador.movete(derecha);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test()
    public void test09JugadorTrataDeCruzarElBordeInferiorDelMapaYNoCambiaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(50, 25);
        Direccion abajo = new DireccionAbajo();

        for (int i = 0; i < 27; i++) {
            jugador.movete(abajo);
        }

        jugador.movete(abajo);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test()
    public void test10JugadorTrataDeCruzarElBordeSuperiorDelMapaYNoCambiaSuPosicion() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(0, 25);
        Direccion arriba = new DireccionArriba();

        for (int i = 0; i < 28; i++) {
            jugador.movete(arriba);
        }

        jugador.movete(arriba);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test11JugadorSePuedeMoverPorElBordeIzquierdoDelMapa() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(27, 1);
        Direccion izquierda = new DireccionIzquierda();
        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecha = new DireccionDerecha();

        for (int i = 0; i < 11; i++) {
            jugador.movete(izquierda);
        }
        jugador.movete(abajo);
        for (int i = 0; i < 18; i++) {
            jugador.movete(izquierda);
        }

        jugador.movete(arriba);
        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(derecha);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test12JugadorSePuedeMoverPorElBordeDerechoDelMapa() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(23, 49);
        Direccion derecha = new DireccionDerecha();
        Direccion abajo = new DireccionAbajo();
        Direccion arriba = new DireccionArriba();
        Direccion izquierda = new DireccionIzquierda();

        jugador.movete(arriba);
        jugador.movete(arriba);
        jugador.movete(arriba);
        for (int i = 0; i < 29; i++) {
            jugador.movete(derecha);
        }
        jugador.movete(arriba);
        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(izquierda);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test13JugadorSePuedeMoverPorElBordeInferiorDelMapa() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(49, 24);
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();
        Direccion derecha = new DireccionDerecha();
        Direccion arriba = new DireccionArriba();

        for (int i = 0; i < 27; i++) {
            jugador.movete(abajo);
        }

        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(derecha);
        jugador.movete(arriba);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test14JugadorSepuedeMoverporElBordeSuperiorDelMapa() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(1, 26);
        Direccion arriba = new DireccionArriba();
        Direccion derecha = new DireccionDerecha();
        Direccion izquierda = new DireccionIzquierda();
        Direccion abajo = new DireccionAbajo();

        for (int i = 0; i < 33; i++) {
            jugador.movete(arriba);
        }
        jugador.movete(izquierda);
        jugador.movete(derecha);
        jugador.movete(derecha);
        jugador.movete(abajo);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test15JugadorRodeaUnMaterial() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(25, 25);
        Direccion arriba = new DireccionArriba();
        Direccion derecha = new DireccionDerecha();
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();

        jugador.movete(arriba);
        jugador.movete(arriba);
        jugador.movete(derecha);
        jugador.movete(derecha);
        jugador.movete(derecha);
        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(arriba);
        jugador.movete(arriba);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test16JugadorTrataDeAtravesarUnMaterialYSuPosicionNoCambia() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(27, 22);
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();

        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test17JugadorTrataDeAtravesarUnMaterialYLuegoSeAleja() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(27, 23);
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();
        Direccion derecha = new DireccionDerecha();

        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(derecha);

        assert posicion.equals(jugador.getPosicion());
    }

    @Test
    public void test18JugadorTrataDeAtravesarUnMaterialYLuegoSeMuevePorElBordeDelMaterial() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Posicion posicion = new Posicion(28, 22);
        Direccion abajo = new DireccionAbajo();
        Direccion izquierda = new DireccionIzquierda();
        Direccion arriba = new DireccionArriba();

        jugador.movete(abajo);
        jugador.movete(abajo);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(izquierda);
        jugador.movete(arriba);
        jugador.movete(abajo);
        jugador.movete(abajo);

        assert posicion.equals(jugador.getPosicion());
    }
}
