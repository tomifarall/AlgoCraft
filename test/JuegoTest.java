import javafx.geometry.Pos;
import modelo.Direccion.*;
import modelo.Herramientas.Hacha;
import modelo.Herramientas.Herramienta;
import modelo.Juego.Juego;
import modelo.Jugador.Inventario;
import modelo.Jugador.Jugador;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import modelo.Materiales.Madera;
import modelo.Materiales.Material;
import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void test01JuegoSeCreaCorrectamente(){
        Juego juego = new Juego();

        Assert.assertNotNull(juego);

    }

    @Test
    public void test02JuegoDeberiaInicializarseConUnJugadorYUnMapa(){
        Juego juego = new Juego();
        Jugador jugador = juego.getJugador();
        Mapa mapa = juego.getMapa();

        Assert.assertNotNull(mapa);
        Assert.assertNotNull(jugador);
    }


    @Test
    public void test03JuegoDeberiaHaceQueElJugadorGolpeeUnMaterial(){
        Juego juego = new Juego();
    }

    @Test
    public void test04JuegoDeberiaHacerQueElJugadorSeMuevaALaDerecha(){
        Juego juego = new Juego();
        //JUGADOR ARRANCA EN POS (25,25) A LA DERECHA HAY MATERIAL, BAJO Y ME MUEVO A DERECHA
        Posicion nuevaPosicion = new Posicion(27,26);
        Direccion direccionDerecha= new DireccionDerecha();
        Direccion direccionAbajo = new DireccionAbajo();
        juego.moverJugador(direccionAbajo);
        juego.moverJugador(direccionAbajo);
        juego.moverJugador(direccionDerecha);

        Posicion posicionJugador = juego.getMapa().getPosicionJugador();

        assert posicionJugador.equals(nuevaPosicion);
    }

    @Test
    public void test05JuegoDeberiaHacerQueElJugadorSeMuevaALaIzquierda(){
        Juego juego = new Juego();
        //JUGADOR ARRANCA EN POS (25,25)
        Posicion nuevaPosicion = new Posicion(25,24);
        Direccion direccionIzquierda= new DireccionIzquierda();
        juego.moverJugador(direccionIzquierda);

        Posicion posicionJugador = juego.getMapa().getPosicionJugador();

        assert posicionJugador.equals(nuevaPosicion);

    }
    @Test
    public void test06JuegoDeberiaHacerQueElJugadorSeMuevaHaciaAbajo(){
        Juego juego = new Juego();
        //JUGADOR ARRANCA EN POS (25,25)
        Posicion nuevaPosicion = new Posicion(26, 25);
        Direccion direccionAbajo = new DireccionAbajo();
        juego.moverJugador(direccionAbajo);

        Posicion posicionJugador = juego.getMapa().getPosicionJugador();

        assert posicionJugador.equals(nuevaPosicion);

    }


    @Test
    public void test07JuegoDeberiaHacerQueElJugadorSeMuevaHaciaArriba(){
        Juego juego = new Juego();
        //JUGADOR ARRANCA EN POS (25,25)
        Posicion nuevaPosicion = new Posicion(24, 25);
        Direccion direccionArriba = new DireccionArriba();
        juego.moverJugador(direccionArriba);

        Posicion posicionJugador = juego.getMapa().getPosicionJugador();

        assert posicionJugador.equals(nuevaPosicion);


    }


    @Test
    public void  test08JuegoDebeEliminarUnElementoDelInventarioDelJugador(){
        Juego juego = new Juego();



    }
    @Test
    public void test09JuegoDebeAgregarUnMaterialALaMesaDeCrafteo(){
        Juego juego = new Juego();
        Material material = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);
    }

    @Test
    public void test10JuegoDebeEliminarUnMaterialDeLaMesaDeCrafteo(){
        Juego juego = new Juego();
        Material material = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);

        juego.eliminarMaterialDeMesaDeCrafteo(posicionEnMesa);



    }

    @Test
    public void test11JuegoPermiteCrearUnHacha(){
        Juego juego = new Juego();
        Madera materialHerraienta = new Madera();
        Material material = new Madera();
        Material material2 = new Madera();
        Material material3 = new Madera();
        Material material4 = new Madera();
        Material material5 = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        Posicion posicionEnMesa2 = new Posicion(0,1);
        Posicion posicionEnMesa3 = new Posicion(1,0);
        Posicion posicionEnMesa4 = new Posicion(1,1);
        Posicion posicionEnMesa5 = new Posicion(2,1);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);
        juego.agregarMaterialAMesaDeCrafteo(material2,posicionEnMesa2);
        juego.agregarMaterialAMesaDeCrafteo(material3,posicionEnMesa3);
        juego.agregarMaterialAMesaDeCrafteo(material4,posicionEnMesa4);
        juego.agregarMaterialAMesaDeCrafteo(material5,posicionEnMesa5);

        Herramienta hachaMadera = new Hacha(materialHerraienta);

        Herramienta hachaMaderaCraft = juego.crearEnCraftingTable();

        //Assert.assertEquals(hachaMadera,hachaMaderaCraft);
    }

    @Test
    public  void test13JuegoPermiteCrearUnPico(){}

    @Test
    public  void test14JuegoPermiteCrearUnPicoFino(){}

    @Test
    public  void test15JuegoPermiteCambiarLaHerramientaEnManoDeJugador(){

    }

}
