import modelo.Herramientas.Herramienta;
import modelo.Materiales.Diamante;
import modelo.Materiales.Madera;
import modelo.Materiales.Material;
import modelo.Materiales.Piedra;
import modelo.Jugador.*;
import org.junit.Assert;
import org.junit.Test;


public class MoldeTest {

    @Test
    public void test01EsPosibleInicializarTodosLosMoldes(){
        Molde moldeHachaMadera= new MoldeHachaDeMadera();
        Molde moldeHachaPiedra= new MoldeHachaDePiedra();
        Molde moldeHachaMetal = new MoldeHachaDeMetal();
        Molde moldePicoMadera = new MoldePicoDeMadera();
        Molde moldePicoPiedra = new MoldePicoDePiedra();
        Molde moldePicoMetal = new MoldePicoDeMetal();
        Molde moldePicoFino = new MoldePicoFino();

        Assert.assertNotNull(moldeHachaMadera);
        Assert.assertNotNull(moldeHachaPiedra);
        Assert.assertNotNull(moldeHachaMetal);
        Assert.assertNotNull(moldePicoMadera);
        Assert.assertNotNull(moldePicoPiedra);
        Assert.assertNotNull(moldePicoMetal);
        Assert.assertNotNull(moldePicoFino);
    }

    @Test
    public void test02MoldeHachaDeMaderaDeberiaDevolverUnHachaDeMaderaSiEsCreado(){
        Molde moldeHachaMadera= new MoldeHachaDeMadera();
        Herramienta hachaDeMadera = moldeHachaMadera.create();

        //Pruebo Comportamiento de Hacha de madera

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaDeMadera.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 2, materialAGolpear.getDurabilidad() );



    }
    @Test
    public void test03MoldeHachaDePiedraDeberiaDevolverUnHachaDePiedraSiEsCreado(){
        Molde moldeHachaPiedra= new MoldeHachaDePiedra();
        Herramienta hachaDePiedra = moldeHachaPiedra.create();

        //Pruebo Comportamiento de Hacha de Piedra

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaDePiedra.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 5, materialAGolpear.getDurabilidad() );
    }
    @Test
    public void test04MoldeHachaDeMetalDeberiaDevolverUnHachaDeMetalSiEsCreado(){
        Molde moldeHachaMetal = new MoldeHachaDeMetal();
        Herramienta hachaDeMetal = moldeHachaMetal.create();

        //Pruebo Comportamiento de Hacha de metal

        Material materialAGolpear = new Madera();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        hachaDeMetal.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 10, materialAGolpear.getDurabilidad() );
    }
    @Test
    public void test05MoldePicoDeMaderaDeberiaDevolverUnPicoDeMaderaSiEsCreado(){
        Molde moldePicoMadera = new MoldePicoDeMadera();
        Herramienta picoDeMadera = moldePicoMadera.create();

        //Pruebo Comportamiento de Pico de madera

        Material materialAGolpear = new Piedra();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoDeMadera.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 2, materialAGolpear.getDurabilidad() );
    }
    @Test
    public void test06MoldePicoDePiedraDeberiaDevolverUnPicoDePiedraSiEsCreado(){
        Molde moldePicoPiedra = new MoldePicoDePiedra();
        Herramienta picoDePiedra = moldePicoPiedra.create();

        //Pruebo Comportamiento de Pico de Piedra

        Material materialAGolpear = new Piedra();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoDePiedra.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 4, materialAGolpear.getDurabilidad() );
    }
    @Test
    public void test07MoldePicoDeMetalDeberiaDevolverUnPicoDeMetalSiEsCreado(){
        Molde moldePicoMetal = new MoldePicoDeMetal();
        Herramienta picoDeMetal = moldePicoMetal.create();

        //Pruebo Comportamiento de Pico de metal

        Material materialAGolpear = new Piedra();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoDeMetal.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 12, materialAGolpear.getDurabilidad() );
    }
    @Test
    public void test08MoldePicoFinoDeberiaDevolverUnPicoFinoSiEsCreado(){
        Molde moldePicoFino = new MoldePicoFino();
        Herramienta picoFino = moldePicoFino.create();

        //Pruebo Comportamiento de Pico Fino

        Material materialAGolpear = new Diamante();
        int durabilidadMaterialAGolpear = materialAGolpear.getDurabilidad();
        picoFino.golpearMaterial(materialAGolpear);


        Assert.assertEquals(durabilidadMaterialAGolpear - 20, materialAGolpear.getDurabilidad() );
    }

}
