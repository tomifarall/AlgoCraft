import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Jugador.MesaDeCrafteo;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import org.junit.Assert;
import org.junit.Test;

public class MesaDeCrafteoTest {

    //CREARLA
    //AGREGAR A TODAS LAS POSICIONES
    //AGREGAR A VARIAS POSICIONES
    //ELIMINAR DE TODAS LAS POSICONES
    //QUE NO SE PUEDA ELIMINAR DE UNO QUE NO TIENE NADA
    //COMPARAR CONTRA TODOS LOS MOLDES  (CRAFTEAR)

    @Test
    public  void test01(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material madera3 = new Madera();
        Material madera4 = new Madera();
        Material madera5 = new Madera();

        mesaDeCrafteo.agregarMaterial(madera1, 1);
        mesaDeCrafteo.agregarMaterial(madera1, 2);
        mesaDeCrafteo.agregarMaterial(madera1, 4);
        mesaDeCrafteo.agregarMaterial(madera1, 5);
        mesaDeCrafteo.agregarMaterial(madera1, 8);

        Herramienta hacha = mesaDeCrafteo.craftear();

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hacha.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 2, materialAGolpear.getDurabilidad() );

    }
}
