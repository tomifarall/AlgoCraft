import modelo.Interfaces.IMaterialMapa;
import modelo.Jugador.Jugador;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import modelo.Materiales.*;
import org.junit.Assert;
import org.junit.Test;




public class JugadorTest {
    @Test
    public void Test01JugadorSeInicializaCorrectamente(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);

        Assert.assertNotNull(jugador);
    }

}
