import modelo.Herramientas.Hacha;
import modelo.Herramientas.Herramienta;
import modelo.Herramientas.Pico;
import modelo.Herramientas.PicoFino;
import modelo.Jugador.MesaDeCrafteo;
import modelo.Jugador.PosicionVaciaEnLaMesaDeCrafteoException;
import modelo.Mapa.Posicion;
import modelo.Materiales.*;
import modelo.Moldes.MoldeInvalidoException;
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
    public  void test01Hachademadera(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material madera3 = new Madera();
        Material madera4 = new Madera();
        Material madera5 = new Madera();
        Herramienta hacha = new Hacha(new Madera());

        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(madera3, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera4, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera5, new Posicion(2,1));

        Herramienta hachaCrafteada = mesaDeCrafteo.craftear();
        int fuerza = hacha.getFuerza();

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaCrafteada.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }

    @Test
    public  void test02Hachadepiedra(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material piedra1 = new Piedra();
        Material piedra2 = new Piedra();
        Material piedra3 = new Piedra();
        Herramienta hacha = new Hacha(new Piedra());

        mesaDeCrafteo.agregarMaterial(piedra1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(piedra2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(piedra3, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(2,1));

        Herramienta hachaCrafteada = mesaDeCrafteo.craftear();
        int fuerza = hacha.getFuerza();

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaCrafteada.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }

    @Test
    public  void test03Hachademetal(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material metal1 = new Metal();
        Material metal2 = new Metal();
        Material metal3 = new Metal();
        Herramienta hacha = new Hacha(new Metal());

        mesaDeCrafteo.agregarMaterial(metal1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(metal2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(metal3, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(2,1));

        Herramienta hachaCrafteada = mesaDeCrafteo.craftear();
        int fuerza = hacha.getFuerza();

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaCrafteada.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }

    @Test
    public  void test05Picodemadera(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material madera3 = new Madera();
        Material madera4 = new Madera();
        Material madera5 = new Madera();
        Herramienta pico = new Pico(new Madera());

        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(madera3, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(madera4, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera5, new Posicion(2,1));

        Herramienta picoCrafteado = mesaDeCrafteo.craftear();
        int fuerza = pico.getFuerza();

        Material materialAGolpear = new Piedra();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoCrafteado.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }


    @Test
    public  void test04Picodepiedra(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material piedra1 = new Piedra();
        Material piedra2 = new Piedra();
        Material piedra3 = new Piedra();
        Herramienta pico = new Pico(new Piedra());

        mesaDeCrafteo.agregarMaterial(piedra1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(piedra2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(piedra3, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(2,1));

        Herramienta picoCrafteado = mesaDeCrafteo.craftear();
        int fuerza = pico.getFuerza();

        Material materialAGolpear = new Piedra();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoCrafteado.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }



    @Test
    public  void test06Picodemetal(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material metal1 = new Metal();
        Material metal2 = new Metal();
        Material metal3 = new Metal();
        Herramienta pico = new Pico(new Metal());

        mesaDeCrafteo.agregarMaterial(metal1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(metal2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(metal3, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(2,1));

        Herramienta picoCrafteado = mesaDeCrafteo.craftear();
        int fuerza = pico.getFuerza();

        Material materialAGolpear = new Piedra();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoCrafteado.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }

    @Test
    public  void test07Picofino(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();
        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material metal1 = new Metal();
        Material metal2 = new Metal();
        Material metal3 = new Metal();
        Material piedra1 = new Piedra();
        Herramienta pico = new PicoFino(new MetalYPiedra());

        mesaDeCrafteo.agregarMaterial(metal1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(metal2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(metal3, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(piedra1, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(2,1));

        Herramienta picoCrafteado = mesaDeCrafteo.craftear();
        int fuerza = pico.getFuerza();

        Material materialAGolpear = new Diamante();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoCrafteado.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - fuerza, materialAGolpear.getDurabilidad() );

    }

    @Test (expected = MoldeInvalidoException.class)
    public void test08todasLasPosicionesAunqueSeaMoldeInvalido(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();

        Material madera1 = new Madera();
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(1,2));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(2,0));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(2,1));
        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(2,2));

        Herramienta herramienta = mesaDeCrafteo.craftear();
    }

    @Test(expected = PosicionVaciaEnLaMesaDeCrafteoException.class)
    public void test09nosepuedeeliminarmaterialdeposicionvacia(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();

        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material madera3 = new Madera();
        Material madera4 = new Madera();
        Material madera5 = new Madera();
        Material madera6 = new Madera();
        Material madera7 = new Madera();
        Material madera8 = new Madera();
        Material madera9 = new Madera();


        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(madera3, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(madera4, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera5, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera6, new Posicion(1,2));
        mesaDeCrafteo.agregarMaterial(madera7, new Posicion(2,0));
        mesaDeCrafteo.agregarMaterial(madera8, new Posicion(2,1));
        mesaDeCrafteo.agregarMaterial(madera9, new Posicion(2,2));

        mesaDeCrafteo.eliminarMaterial(new Posicion(1,1));
        mesaDeCrafteo.eliminarMaterial(new Posicion(1,1));
    }

    @Test(expected = MoldeInvalidoException.class)
    public void test10LlenoYEliminoTodasLasPosiciones(){
        MesaDeCrafteo mesaDeCrafteo = new MesaDeCrafteo();

        Material madera1 = new Madera();
        Material madera2 = new Madera();
        Material madera3 = new Madera();
        Material madera4 = new Madera();
        Material madera5 = new Madera();
        Material madera6 = new Madera();
        Material madera7 = new Madera();
        Material madera8 = new Madera();
        Material madera9 = new Madera();


        mesaDeCrafteo.agregarMaterial(madera1, new Posicion(0,0));
        mesaDeCrafteo.agregarMaterial(madera2, new Posicion(0,1));
        mesaDeCrafteo.agregarMaterial(madera3, new Posicion(0,2));
        mesaDeCrafteo.agregarMaterial(madera4, new Posicion(1,0));
        mesaDeCrafteo.agregarMaterial(madera5, new Posicion(1,1));
        mesaDeCrafteo.agregarMaterial(madera6, new Posicion(1,2));
        mesaDeCrafteo.agregarMaterial(madera7, new Posicion(2,0));
        mesaDeCrafteo.agregarMaterial(madera8, new Posicion(2,1));
        mesaDeCrafteo.agregarMaterial(madera9, new Posicion(2,2));

        mesaDeCrafteo.eliminarMaterial(new Posicion(0,0));
        mesaDeCrafteo.eliminarMaterial(new Posicion(0,1));
        mesaDeCrafteo.eliminarMaterial(new Posicion(0,2));
        mesaDeCrafteo.eliminarMaterial(new Posicion(1,0));
        mesaDeCrafteo.eliminarMaterial(new Posicion(1,1));
        mesaDeCrafteo.eliminarMaterial(new Posicion(1,2));
        mesaDeCrafteo.eliminarMaterial(new Posicion(2,0));
        mesaDeCrafteo.eliminarMaterial(new Posicion(2,1));
        mesaDeCrafteo.eliminarMaterial(new Posicion(2,2));

        Herramienta herramienta = mesaDeCrafteo.craftear();
    }
}