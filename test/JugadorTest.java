import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Jugador.Jugador;
import fiuba.algo3.Mapa.Mapa;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.*;
import org.junit.Assert;
import org.junit.Test;




public class JugadorTest {
    @Test
    public void Test01JugadorSeInicializaCorrectamente(){
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);


        Assert.assertNotEquals(jugador,null);
    }

}
