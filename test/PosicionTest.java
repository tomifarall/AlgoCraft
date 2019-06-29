import fiuba.algo3.Mapa.Posicion;
import org.junit.Test;

public class PosicionTest {

    @Test
    public void test01Posicion(){
        Posicion posicion = new Posicion( 50,50);
        Posicion posicion2 = new Posicion(50,50);

        assert posicion.equals(posicion2);

    }
}
