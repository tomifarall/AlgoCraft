import modelo.Direccion.*;
import modelo.Herramientas.Herramienta;
import modelo.Juego.Juego;
import modelo.Jugador.Jugador;
import modelo.Mapa.Casillero;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import modelo.Materiales.*;
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
        Direccion izquierda = new DireccionIzquierda();
        for (int i = 0; i<4; i++) {
            juego.moverJugador(izquierda);
        }
        Posicion posicionMadera = new Posicion(26,21);
        Material materialGolpeado = juego.getMapa().obtenerMaterialEnPosicion(posicionMadera);
        int durabilidadMaterial = materialGolpeado.getDurabilidad();

        try {
            juego.jugadorGolpearMaterial(posicionMadera);
        }catch (NoSePuedeRecolectarUnMaterialNoDestruidoException e) {}


        Assert.assertEquals( durabilidadMaterial -2 , materialGolpeado.getDurabilidad());

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
        Casillero casillero = juego.getMesaDeCrafteoJugador().get(posicionEnMesa);
        Assert.assertTrue(!casillero.getOcupante().esVacio());
    }

    @Test
    public void test10JuegoDebeEliminarUnMaterialDeLaMesaDeCrafteo(){
        Juego juego = new Juego();
        Material material = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);

        juego.eliminarMaterialDeMesaDeCrafteo(posicionEnMesa);

        Casillero casillero = juego.getMesaDeCrafteoJugador().get(posicionEnMesa);
        Assert.assertTrue(casillero.getOcupante().esVacio());



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

        Herramienta hachaMaderaCraft = juego.crearEnCraftingTable();
        int fuerza = hachaMaderaCraft.getFuerza();

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaMaderaCraft.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );
    }

    @Test
    public  void test13JuegoPermiteCrearUnPico(){
        Juego juego = new Juego();
        Material material = new Piedra();
        Material material2 = new Piedra();
        Material material3 = new Piedra();
        Material material4 = new Madera();
        Material material5 = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        Posicion posicionEnMesa2 = new Posicion(0,1);
        Posicion posicionEnMesa3 = new Posicion(0,2);
        Posicion posicionEnMesa4 = new Posicion(1,1);
        Posicion posicionEnMesa5 = new Posicion(2,1);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);
        juego.agregarMaterialAMesaDeCrafteo(material2,posicionEnMesa2);
        juego.agregarMaterialAMesaDeCrafteo(material3,posicionEnMesa3);
        juego.agregarMaterialAMesaDeCrafteo(material4,posicionEnMesa4);
        juego.agregarMaterialAMesaDeCrafteo(material5,posicionEnMesa5);

        Herramienta picoPiedraCraft = juego.crearEnCraftingTable();
        int fuerza = picoPiedraCraft.getFuerza();

        Material materialAGolpear = new Metal();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoPiedraCraft.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );
    }

    @Test
    public  void test14JuegoPermiteCrearUnPicoFino(){
        Juego juego = new Juego();
        Material material = new Metal();
        Material material2 = new Metal();
        Material material3 = new Metal();
        Material material4 = new Piedra();
        Material material5 = new Madera();
        Material material6 = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        Posicion posicionEnMesa2 = new Posicion(0,1);
        Posicion posicionEnMesa3 = new Posicion(0,2);
        Posicion posicionEnMesa4 = new Posicion(1,0);
        Posicion posicionEnMesa5 = new Posicion(1,1);
        Posicion posicionEnMesa6 = new Posicion(2,1);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);
        juego.agregarMaterialAMesaDeCrafteo(material2,posicionEnMesa2);
        juego.agregarMaterialAMesaDeCrafteo(material3,posicionEnMesa3);
        juego.agregarMaterialAMesaDeCrafteo(material4,posicionEnMesa4);
        juego.agregarMaterialAMesaDeCrafteo(material5,posicionEnMesa5);
        juego.agregarMaterialAMesaDeCrafteo(material6, posicionEnMesa6);

        Herramienta picoFinoCraft = juego.crearEnCraftingTable();
        int fuerza = picoFinoCraft.getFuerza();

        Material materialAGolpear = new Diamante();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoFinoCraft.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }

    @Test
    public  void test15JuegoPermiteCambiarLaHerramientaEnManoDeJugador(){
        Juego juego = new Juego();
        //Creo Pico Fino y se almacena en el inventario
        Material material = new Metal();
        Material material2 = new Metal();
        Material material3 = new Metal();
        Material material4 = new Piedra();
        Material material5 = new Madera();
        Material material6 = new Madera();
        Posicion posicionEnMesa = new Posicion(0,0);
        Posicion posicionEnMesa2 = new Posicion(0,1);
        Posicion posicionEnMesa3 = new Posicion(0,2);
        Posicion posicionEnMesa4 = new Posicion(1,0);
        Posicion posicionEnMesa5 = new Posicion(1,1);
        Posicion posicionEnMesa6 = new Posicion(2,1);
        juego.agregarMaterialAMesaDeCrafteo(material,posicionEnMesa);
        juego.agregarMaterialAMesaDeCrafteo(material2,posicionEnMesa2);
        juego.agregarMaterialAMesaDeCrafteo(material3,posicionEnMesa3);
        juego.agregarMaterialAMesaDeCrafteo(material4,posicionEnMesa4);
        juego.agregarMaterialAMesaDeCrafteo(material5,posicionEnMesa5);
        juego.agregarMaterialAMesaDeCrafteo(material6, posicionEnMesa6);
        juego.crearEnCraftingTable();
        Posicion posicionPicoFino = new Posicion(0,1);
        juego.elegirNuevaHerramientaEnMano(posicionPicoFino);

        //Muevo AL jugador hasta una posicion adyacente a un Diamante
        Direccion derecha = new DireccionDerecha();
        Direccion arriba = new DireccionArriba();
        for ( int i = 0; i<10; i++){
            juego.moverJugador(arriba);
        }
        juego.moverJugador(derecha);
        Posicion posicionDiamanteEnMapa = new Posicion(15,27);
        Material materialAGolpear = juego.getMapa().obtenerMaterialEnPosicion(posicionDiamanteEnMapa);
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();

        int fuerzaPicoFino = 20;

        juego.getJugador().getHerramientaEnMano().golpearMaterial(materialAGolpear);

        Assert.assertEquals(durabilidadMaterialAGolpear - fuerzaPicoFino, materialAGolpear.getDurabilidad() );
    }

}
