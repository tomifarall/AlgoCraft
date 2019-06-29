import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Mapa.Casillero;
import fiuba.algo3.Mapa.CoordenadasInvalidasException;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.Piedra;
import fiuba.algo3.Materiales.Vacio;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class CasilleroTest {


    @Test
    public void Test01CasilleroSeDeberiaInicializarCorrectamente(){
        Casillero casillero = new Casillero();

        Assert.assertNotEquals(casillero,null);
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
        casillero.removeOcupante();
        IMapeable ocupanteCasillero = casillero.getOcupante();

        assert ocupanteCasillero.esVacio();

    }
}



