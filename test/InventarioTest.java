import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Interfaces.IColeccionable;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Jugador.Inventario;
import fiuba.algo3.Jugador.InventarioLlenoException;
import fiuba.algo3.Materiales.*;
import org.junit.Assert;
import org.junit.Test;

public class InventarioTest {

    @Test
    public void test01SeCreaUnInventarioNuevo() {
        Inventario inventario = new Inventario();


        Assert.assertNotEquals(inventario, null);
    }

    @Test
    public void test02CrearUnInventarioNuevoDeberiaEstarVacio() {
        Inventario inventario = new Inventario();

        int ElementosInventario = inventario.getCantidadElementos();


        Assert.assertEquals(ElementosInventario, 0);
    }

    @Test
    public void test03DeberiaPoderAgregarseUnNuevoElementoAlInventario() {
        Inventario inventario = new Inventario();
        IColeccionable elemento = new Madera();
        inventario.agregar(elemento);
        int elementosDeInventario = inventario.getCantidadElementos();

        Assert.assertEquals(elementosDeInventario, 1);
    }

    @Test
    public void test04DeberiaPoderAgregarseUnMaterialYUnaHerramienta() {
        Inventario inventario = new Inventario();
        IColeccionable material = new Madera();
        Metal metal = new Metal();
        IColeccionable hacha = new Hacha(metal);
        inventario.agregar(material);
        inventario.agregar(hacha);
        int elementosDeInventario = inventario.getCantidadElementos();

        Assert.assertEquals(elementosDeInventario, 2);
    }

    @Test(expected = InventarioLlenoException.class)
    public void test05NoDeberiaPoderAgregarseMasDe10ElementosAlInventario() {
        Inventario inventario = new Inventario();
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

        //Esta Deberia Romper
        inventario.agregar(material11);
    }

    @Test
    public void test06DeberiaPoderEliminarseUnElementoDelInventario() {
        Inventario inventario = new Inventario();
        IColeccionable elemento = new Madera();
        inventario.agregar(elemento);
        inventario.eliminar(elemento);

        int elementosDeInventario = inventario.getCantidadElementos();


        Assert.assertEquals(elementosDeInventario, 0);
    }

    @Test
    public void test07DeberiaPoderEliminarseUnElementoDelInventarioLlenoYAsiPoderAgregarOtro() {
        Inventario inventario = new Inventario();
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


        //Elimino y agrego
        inventario.eliminar(material8);

        inventario.agregar(material11);

        int elementosDeInventario = inventario.getCantidadElementos();


        Assert.assertEquals(elementosDeInventario, 10);
    }

}
