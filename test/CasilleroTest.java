import modelo.Interfaces.IMapeable;
import modelo.Mapa.Casillero;
import modelo.Mapa.CasilleroOcupadoException;
import modelo.Materiales.Madera;
import modelo.Materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;


public class CasilleroTest {


    @Test
    public void Test01CasilleroSeDeberiaInicializarCorrectamente(){
        Casillero casillero = new Casillero();

        Assert.assertNotNull(casillero);
    }

    @Test
    public  void Test02CasilleroDeberiaInicializarCorrectamenteConOcupanteVacio(){
        Casillero casillero = new Casillero();


        assert  casillero.getOcupante().esVacio();
    }


    @Test
    public void Test03CasilleroDeberiaPoderContenerUnElementoDelMapa(){
        Casillero casillero = new Casillero();
        IMapeable material = new Piedra();
        casillero.ocuparCon(material);
        IMapeable ocupanteCasillero = casillero.getOcupante();
        Assert.assertEquals(ocupanteCasillero,material);
    }

    @Test
    public void Test04CasilleroDeberiaPoderLiberarseDeSuOcupante() {
        Casillero casillero = new Casillero();
        IMapeable material = new Piedra();
        casillero.ocuparCon(material);
        casillero.eliminarOcupante();
        IMapeable ocupanteCasillero = casillero.getOcupante();

        assert ocupanteCasillero.esVacio();

    }

    @Test (expected = CasilleroOcupadoException.class)
    public  void  Test05CasilleroNoDeberiaPoderOcuparseCuandoContieneUnOcupanteQueNoEsVacio(){
        Casillero casillero = new Casillero();
        IMapeable material = new Madera();
        IMapeable material2 = new Piedra();
        casillero.ocuparCon(material);

        casillero.ocuparCon(material2);

    }
}



