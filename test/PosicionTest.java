import fiuba.algo3.Direccion.*;
import org.junit.Test;
import fiuba.algo3.Mapa.Posicion;

public class PosicionTest {

    @Test
    public void test01PosicionesConigualesCoordenadasSonIguales(){
        Posicion posicion1 = new Posicion( 50,50);
        Posicion posicion2 = new Posicion(50,50);

        assert posicion1.equals(posicion2);
    }

    @Test
    public void test02AunaPosicionLePuedoPreguntarSuPosicionIySuPosicionJ(){
        Posicion posicion1 = new Posicion( 50,50);
        int i = posicion1.getPosicionI();
        int j = posicion1.getPosicionJ();


        assert j ==50;
        assert i == 50;
    }

    @Test
    public void test02AUnaPosicionSeLeDeberiaPoderCalcularSuSiguienteALaDerecha(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicionSiguiente = new Posicion(50,51);
        Direccion direccion = new DireccionDerecha();

        posicion = posicion.obtenerPosicionSiguiente(direccion);

        assert posicion.equals(posicionSiguiente);
    }
    @Test
    public void test03AUnaPosicionSeLeDeberiaPoderCalcularSuSiguienteALaIzquierda(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicionSiguiente = new Posicion(50,49);
        Direccion direccion = new DireccionIzquierda();

        posicion = posicion.obtenerPosicionSiguiente(direccion);

        assert posicion.equals(posicionSiguiente);
    }
    @Test
    public void test04AUnaPosicionSeLeDeberiaPoderCalcularSuSiguientehaciaArriba(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicionSiguiente = new Posicion(49,50);
        Direccion direccion = new DireccionArriba();

        posicion = posicion.obtenerPosicionSiguiente(direccion);

        assert posicion.equals(posicionSiguiente);
    }
    @Test
    public void test05AUnaPosicionSeLeDeberiaPoderCalcularSuSiguienteHaciaAbajo(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicionSiguiente = new Posicion(51,50);
        Direccion direccion = new DireccionAbajo();

        posicion = posicion.obtenerPosicionSiguiente(direccion);

        assert posicion.equals(posicionSiguiente);
    }
    @Test
    public void test06SeVerificaQueElcalculoDeLasPosicionesSiguienteEsCorrecto(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicionFinal = new Posicion(50,50);
        Direccion direccionArriba = new DireccionArriba();
        Direccion direccionAbajo = new DireccionAbajo();
        Direccion direccionIzquierda = new DireccionIzquierda();
        Direccion direccionDerecha = new DireccionDerecha();

        posicion = posicion.obtenerPosicionSiguiente(direccionArriba);
        posicion = posicion.obtenerPosicionSiguiente(direccionIzquierda);
        posicion = posicion.obtenerPosicionSiguiente(direccionIzquierda);
        posicion = posicion.obtenerPosicionSiguiente(direccionDerecha);
        posicion = posicion.obtenerPosicionSiguiente(direccionAbajo);
        posicion = posicion.obtenerPosicionSiguiente(direccionArriba);
        posicion = posicion.obtenerPosicionSiguiente(direccionDerecha);
        posicion = posicion.obtenerPosicionSiguiente(direccionAbajo);

        assert posicion.equals(posicionFinal);
    }
    @Test
    public void test07(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicionFinal = new Posicion(51,49);
        Direccion direccionArriba = new DireccionArriba();
        Direccion direccionAbajo = new DireccionAbajo();
        Direccion direccionIzquierda = new DireccionIzquierda();
        Direccion direccionDerecha = new DireccionDerecha();

        posicion = posicion.obtenerPosicionSiguiente(direccionArriba);
        posicion = posicion.obtenerPosicionSiguiente(direccionIzquierda);
        posicion = posicion.obtenerPosicionSiguiente(direccionIzquierda);
        posicion = posicion.obtenerPosicionSiguiente(direccionDerecha);
        posicion = posicion.obtenerPosicionSiguiente(direccionAbajo);
        posicion = posicion.obtenerPosicionSiguiente(direccionAbajo);

        assert posicion.equals(posicionFinal);
    }
}
