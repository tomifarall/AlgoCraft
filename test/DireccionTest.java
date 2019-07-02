import modelo.Mapa.*;
import modelo.Direccion.*;
import org.junit.Test;

public class DireccionTest {
    @Test
    public void test01DireccionDaLaPosicionCorrectaALaDerecha(){
        Posicion posicionInicial = new Posicion(48,48);
        Posicion posicionFinal = new Posicion(48,49);
        Direccion direccion  = new DireccionDerecha();

        assert( posicionFinal.equals(direccion.posicionSiguiente(posicionInicial)));
    }
    @Test
    public void test02DireccionDaLaPosicionCorrectaALaIzquierda(){
        Posicion posicionInicial = new Posicion(48,48);
        Posicion posicionFinal = new Posicion(48,47);
        Direccion direccion  = new DireccionIzquierda();

        assert( posicionFinal.equals(direccion.posicionSiguiente(posicionInicial)));
    }
    @Test
    public void test03DireccionDaLaPosicionCorrectaHaciaArriba(){
        Posicion posicionInicial = new Posicion(48,48);
        Posicion posicionFinal = new Posicion(47,48);
        Direccion direccion  = new DireccionArriba();

        assert( posicionFinal.equals(direccion.posicionSiguiente(posicionInicial)));
    }
    @Test
    public void test04DireccionDaLaPosicionCorrectaHaciaAbajo(){
        Posicion posicionInicial = new Posicion(48,48);
        Posicion posicionFinal = new Posicion(49,48);
        Direccion direccion  = new DireccionAbajo();

        assert( posicionFinal.equals(direccion.posicionSiguiente(posicionInicial)));
    }
}
