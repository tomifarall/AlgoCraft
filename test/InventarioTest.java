
import modelo.Herramientas.Hacha;
import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Jugador.Inventario;
import modelo.Jugador.InventarioLlenoException;
import modelo.Jugador.Jugador;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import modelo.Materiales.*;
import org.junit.Assert;
import org.junit.Test;

public class InventarioTest {

    @Test
    public void test01SeCreaUnInventarioNuevo() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);


        Assert.assertNotEquals(inventario, null);
    }

    @Test
    public void test02CrearUnInventarioNuevoDeberiaEstarVacio() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);

        int ElementosInventario = inventario.getCantidadElementos();


        Assert.assertEquals(ElementosInventario, 0);
    }

    @Test
    public void test03DeberiaPoderAgregarseUnNuevoElementoAlInventario() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);
        IColeccionable elemento = new Madera();
        inventario.agregar(elemento);
        int elementosDeInventario = inventario.getCantidadElementos();

        Assert.assertEquals(elementosDeInventario, 1);
    }

    @Test
    public void test04DeberiaPoderAgregarseUnMaterialYUnaHerramienta() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);
        IColeccionable material = new Madera();
        Metal metal = new Metal();
        IColeccionable hacha = new Hacha(metal);
        inventario.agregar(material);
        inventario.agregar(hacha);
        int elementosDeInventario = inventario.getCantidadElementos();

        Assert.assertEquals(elementosDeInventario, 2);
    }

    @Test(expected = InventarioLlenoException.class)
    public void test05NoDeberiaPoderAgregarseMasDe15ElementosAlInventario() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);
        IColeccionable material = new Madera();
        IColeccionable material2 = new Metal();
        IColeccionable material3 = new Piedra();
        IColeccionable material4 = new Diamante();
        IColeccionable material5 = new Madera();
        IColeccionable material6 = new Piedra();
        IColeccionable material7 = new Metal();
        IColeccionable material8 = new Diamante();
        IColeccionable material9 = new Madera();
        IColeccionable material10= new Piedra();
        IColeccionable material11= new Metal();
        IColeccionable material12= new Metal();
        IColeccionable material13= new Metal();
        IColeccionable material14= new Metal();
        IColeccionable material15= new Metal();
        IColeccionable material16= new Madera();

        inventario.agregar(material);
        inventario.agregar(material2);
        inventario.agregar(material3);
        inventario.agregar(material4);
        inventario.agregar(material5);
        inventario.agregar(material6);
        inventario.agregar(material7);
        inventario.agregar(material8);
        inventario.agregar(material9);
        inventario.agregar(material10);
        inventario.agregar(material11);
        inventario.agregar(material12);
        inventario.agregar(material13);
        inventario.agregar(material14);
        inventario.agregar(material15);

        //Esta Deberia Romper
        inventario.agregar(material16);
    }

    @Test
    public void test06DeberiaPoderEliminarseUnElementoDelInventario() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);
        IColeccionable elemento = new Madera();

        inventario.agregar(elemento);
        inventario.eliminar(new Posicion(0,0));

        int elementosDeInventario = inventario.getCantidadElementos();


        Assert.assertEquals(0,elementosDeInventario);
    }

    @Test
    public void test07DeberiaPoderEliminarseUnElementoDelInventarioLlenoYAsiPoderAgregarOtro() {
        Mapa mapa = Mapa.getMapa();
        Jugador jugador = new Jugador(mapa);
        Inventario inventario = new Inventario(jugador);
        IColeccionable material = new Madera();
        IColeccionable material2 = new Metal();
        IColeccionable material3 = new Piedra();
        IColeccionable material4 = new Diamante();
        IColeccionable material5 = new Madera();
        IColeccionable material6 = new Piedra();
        IColeccionable material7 = new Metal();
        IColeccionable material8 = new Diamante();
        IColeccionable material9 = new Madera();
        IColeccionable material10= new Piedra();
        IColeccionable material11= new Metal();
        IColeccionable material12= new Madera();
        IColeccionable material13= new Metal();
        IColeccionable material14= new Diamante();
        IColeccionable material15= new Piedra();
        IColeccionable material16= new Metal();



        inventario.agregar(material);
        inventario.agregar(material2);
        inventario.agregar(material3);
        inventario.agregar(material4);
        inventario.agregar(material5);
        inventario.agregar(material6);
        inventario.agregar(material7);
        inventario.agregar(material8);
        inventario.agregar(material9);
        inventario.agregar(material10);
        inventario.agregar(material11);
        inventario.agregar(material12);
        inventario.agregar(material13);
        inventario.agregar(material14);
        inventario.agregar(material15);



        //Elimino y agrego
        inventario.eliminar(new Posicion(1,2));

        inventario.agregar(material16);

        int elementosDeInventario = inventario.getCantidadElementos();


        Assert.assertEquals(elementosDeInventario, 15);
    }

}
