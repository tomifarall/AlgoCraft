import modelo.Desgastes.Desgaste;
import modelo.Desgastes.DesgasteLineal;
import modelo.Desgastes.DesgastePorUsos;
import modelo.Desgastes.DesgastePorcentual;
import modelo.Herramientas.Hacha;
import modelo.Herramientas.Pico;
import modelo.Herramientas.PicoFino;
import modelo.Interfaces.IMaterialMapa;
import modelo.Mapa.Posicion;
import modelo.Materiales.*;
import org.junit.Test;
import org.junit.Assert;

public class MaterialTest {

    @Test
    public void test01MaderaComoMaterialDeHachaDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);
        int durabilidad = maderaMapa.getDurabilidad();

        madera.golpearMaterial(hacha, maderaMapa);

        Assert.assertEquals(durabilidad - hacha.getFuerza(), maderaMapa.getDurabilidad());
    }

    @Test
    public void test02MaderaComoMaterialDeHachaNoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);
        int durabilidad = piedraMapa.getDurabilidad();

        madera.golpearMaterial(hacha, piedraMapa);

        Assert.assertEquals(durabilidad, piedraMapa.getDurabilidad());
    }

    @Test
    public void test03MaderaComoMaterialDeHachaNoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);
        int durabilidad = metalMapa.getDurabilidad();

        madera.golpearMaterial(hacha, metalMapa);

        Assert.assertEquals(durabilidad, metalMapa.getDurabilidad());
    }

    @Test
    public void test04MaderaComoMaterialDeHachaNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);
        int durabilidad = diamanteMapa.getDurabilidad();

        madera.golpearMaterial(hacha, diamanteMapa);

        Assert.assertEquals(durabilidad, diamanteMapa.getDurabilidad());
    }

    @Test
    public void test05MaderaComoMaterialDePicoNoDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        Madera madera = new Madera();
        Pico pico = new Pico(madera);
        int durabilidad = maderaMapa.getDurabilidad();

        madera.golpearMaterial(pico, maderaMapa);

        Assert.assertEquals(durabilidad, maderaMapa.getDurabilidad());
    }

    @Test
    public void test06MaderaComoMaterialDePicoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        Madera madera = new Madera();
        Pico pico = new Pico(madera);
        int durabilidad = piedraMapa.getDurabilidad();

        madera.golpearMaterial(pico, piedraMapa);

        Assert.assertEquals(durabilidad - pico.getFuerza(), piedraMapa.getDurabilidad());
    }

    @Test
    public void test07MaderaComoMaterialDePicoNoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        Madera madera = new Madera();
        Pico pico = new Pico(madera);
        int durabilidad = metalMapa.getDurabilidad();

        madera.golpearMaterial(pico, metalMapa);

        Assert.assertEquals(durabilidad, metalMapa.getDurabilidad());
    }

    @Test
    public void test08MaderaComoMaterialDePicoNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        Madera madera = new Madera();
        Pico pico = new Pico(madera);
        int durabilidad = diamanteMapa.getDurabilidad();

        madera.golpearMaterial(pico, diamanteMapa);

        Assert.assertEquals(durabilidad, diamanteMapa.getDurabilidad());
    }

    @Test
    public void test09PiedraComoMaterialDeHachaDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(piedra);
        int durabilidad = maderaMapa.getDurabilidad();

        piedra.golpearMaterial(hacha, maderaMapa);

        Assert.assertEquals(durabilidad - hacha.getFuerza(), maderaMapa.getDurabilidad());
    }

    @Test
    public void test10PiedraComoMaterialDeHachaNoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(piedra);
        int durabilidad = piedraMapa.getDurabilidad();

        piedra.golpearMaterial(hacha, piedraMapa);

        Assert.assertEquals(durabilidad, piedraMapa.getDurabilidad());
    }

    @Test
    public void test11PiedraComoMaterialDeHachaNoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(piedra);
        int durabilidad = metalMapa.getDurabilidad();

        piedra.golpearMaterial(hacha, metalMapa);

        Assert.assertEquals(durabilidad, metalMapa.getDurabilidad());
    }

    @Test
    public void test12PiedraComoMaterialDeHachaNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(piedra);
        int durabilidad = diamanteMapa.getDurabilidad();

        piedra.golpearMaterial(hacha, diamanteMapa);

        Assert.assertEquals(durabilidad, diamanteMapa.getDurabilidad());
    }

    @Test
    public void test13PiedraComoMaterialDePicoNoDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        Piedra piedra = new Piedra();
        Pico pico = new Pico(piedra);
        int durabilidad = maderaMapa.getDurabilidad();

        piedra.golpearMaterial(pico, maderaMapa);

        Assert.assertEquals(durabilidad, maderaMapa.getDurabilidad());
    }

    @Test
    public void test14PiedraComoMaterialDePicoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        Piedra piedra = new Piedra();
        Pico pico = new Pico(piedra);
        int durabilidad = piedraMapa.getDurabilidad();

        piedra.golpearMaterial(pico, piedraMapa);

        Assert.assertEquals(durabilidad - pico.getFuerza(), piedraMapa.getDurabilidad());
    }

    @Test
    public void test15PiedraComoMaterialDePicoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        Piedra piedra = new Piedra();
        Pico pico = new Pico(piedra);
        int durabilidad = metalMapa.getDurabilidad();

        piedra.golpearMaterial(pico, metalMapa);

        Assert.assertEquals(durabilidad - pico.getFuerza(), metalMapa.getDurabilidad());
    }

    @Test
    public void test16PiedraComoMaterialDePicoNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        Piedra piedra = new Piedra();
        Pico pico = new Pico(piedra);
        int durabilidad = diamanteMapa.getDurabilidad();

        piedra.golpearMaterial(pico, diamanteMapa);

        Assert.assertEquals(durabilidad, diamanteMapa.getDurabilidad());
    }

    @Test
    public void test17MetalComoMaterialDeHachaDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        Metal metal = new Metal();
        Hacha hacha = new Hacha(metal);
        int durabilidad = maderaMapa.getDurabilidad();

        metal.golpearMaterial(hacha, maderaMapa);

        Assert.assertEquals(durabilidad - hacha.getFuerza(), maderaMapa.getDurabilidad());
    }

    @Test
    public void test18MetalComoMaterialDeHachaNoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        Metal metal = new Metal();
        Hacha hacha = new Hacha(metal);
        int durabilidad = piedraMapa.getDurabilidad();

        metal.golpearMaterial(hacha, piedraMapa);

        Assert.assertEquals(durabilidad, piedraMapa.getDurabilidad());
    }

    @Test
    public void test19MetalComoMaterialDeHachaNoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        Metal metal = new Metal();
        Hacha hacha = new Hacha(metal);
        int durabilidad = metalMapa.getDurabilidad();

        metal.golpearMaterial(hacha, metalMapa);

        Assert.assertEquals(durabilidad, metalMapa.getDurabilidad());
    }

    @Test
    public void test20MetalComoMaterialDeHachaNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        Metal metal = new Metal();
        Hacha hacha = new Hacha(metal);
        int durabilidad = diamanteMapa.getDurabilidad();

        metal.golpearMaterial(hacha, diamanteMapa);

        Assert.assertEquals(durabilidad, diamanteMapa.getDurabilidad());
    }

    @Test
    public void test21MetalComoMaterialDePicoNoDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        Metal metal = new Metal();
        Pico pico = new Pico(metal);
        int durabilidad = maderaMapa.getDurabilidad();

        metal.golpearMaterial(pico, maderaMapa);

        Assert.assertEquals(durabilidad, maderaMapa.getDurabilidad());
    }

    @Test
    public void test22MetalComoMaterialDePicoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        Metal metal = new Metal();
        Pico pico = new Pico(metal);
        int durabilidad = piedraMapa.getDurabilidad();

        metal.golpearMaterial(pico, piedraMapa);

        Assert.assertEquals(durabilidad - pico.getFuerza(), piedraMapa.getDurabilidad());
    }

    @Test
    public void test23MetalComoMaterialDePicoNoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        Metal metal = new Metal();
        Pico pico = new Pico(metal);
        int durabilidad = metalMapa.getDurabilidad();

        metal.golpearMaterial(pico, metalMapa);

        Assert.assertEquals(durabilidad, metalMapa.getDurabilidad());
    }

    @Test
    public void test24MetalComoMaterialDePicoNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        Metal metal = new Metal();
        Pico pico = new Pico(metal);
        int durabilidad = diamanteMapa.getDurabilidad();

        metal.golpearMaterial(pico, diamanteMapa);

        Assert.assertEquals(durabilidad, diamanteMapa.getDurabilidad());
    }

    @Test
    public void test25MetalYPiedraComoMaterialDePicoFinoNoDebilitaAMadera(){
        IMaterialMapa maderaMapa = new Madera();
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedra);
        int durabilidad = maderaMapa.getDurabilidad();

        metalYPiedra.golpearMaterial(picoFino, maderaMapa);

        Assert.assertEquals(durabilidad, maderaMapa.getDurabilidad());
    }

    @Test
    public void test26MetalYPiedraComoMaterialDePicoFinoNoDebilitaAPiedra(){
        IMaterialMapa piedraMapa = new Piedra();
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedra);
        int durabilidad = piedraMapa.getDurabilidad();

        metalYPiedra.golpearMaterial(picoFino, piedraMapa);

        Assert.assertEquals(durabilidad, piedraMapa.getDurabilidad());
    }

    @Test
    public void test27MetalYPiedraComoMaterialDePicoFinoNoDebilitaAMetal(){
        IMaterialMapa metalMapa = new Metal();
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedra);
        int durabilidad = metalMapa.getDurabilidad();

        metalYPiedra.golpearMaterial(picoFino, metalMapa);

        Assert.assertEquals(durabilidad, metalMapa.getDurabilidad());
    }

    @Test
    public void test28MetalYPiedraComoMaterialDePicoFinoNoDebilitaADiamante(){
        IMaterialMapa diamanteMapa = new Diamante();
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedra);
        int durabilidad = diamanteMapa.getDurabilidad();

        metalYPiedra.golpearMaterial(picoFino, diamanteMapa);

        Assert.assertEquals(durabilidad - picoFino.getFuerza(), diamanteMapa.getDurabilidad());
    }

    @Test
    public void test29MaderaEsGolpeadaPorHachaDeMaderaYSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Madera maderaHerramienta = new Madera();
        Hacha hacha = new Hacha(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(hacha,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad - hacha.getFuerza(), madera.getDurabilidad());
    }

    @Test
    public void test30MaderaEsGolpeadaPorHachaDePiedraYSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Piedra piedraHerramienta = new Piedra();
        Hacha hacha = new Hacha(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,5,1);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(hacha,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad - hacha.getFuerza(), madera.getDurabilidad());
    }

    @Test
    public void test31MaderaEsGolpeadaPorHachaDeMetalYSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Metal metalHerramienta = new Metal();
        Hacha hacha = new Hacha(metalHerramienta);
        Desgaste desgaste = new DesgasteLineal(400,10,1/2f);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(hacha,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad - hacha.getFuerza(), madera.getDurabilidad());
    }

    @Test
    public void test32MaderaEsGolpeadaPorPicoaDeMaderaYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Madera maderaHerramienta = new Madera();
        Pico pico = new Pico(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(pico,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad, madera.getDurabilidad());
    }

    @Test
    public void test33MaderaEsGolpeadaPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Piedra piedraHerramienta = new Piedra();
        Pico pico = new Pico(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,4,1/5f);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(pico,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, madera.getDurabilidad());
    }

    @Test
    public void test34MaderaEsGolpeadaPorPicoDeMetalYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Metal metalHerramienta = new Metal();
        Pico pico = new Pico(metalHerramienta);
        Desgaste desgaste = new DesgastePorUsos(400,10,12);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(pico,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad, madera.getDurabilidad());
    }

    @Test
    public void test35MaderaEsGolpeadaPorPicoFinoYNoSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        MetalYPiedra metalYPiedraHerramienta = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedraHerramienta);
        Desgaste desgaste = new DesgastePorcentual(100,20,0.1f);
        int durabilidad = madera.getDurabilidad();

        madera.serGolpeado(picoFino,metalYPiedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, madera.getDurabilidad());
    }

    @Test
    public void test36PiedraEsGolpeadaPorHachaDeMaderaYNoSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        Madera maderaHerramienta = new Madera();
        Hacha hacha = new Hacha(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(hacha,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad, piedra.getDurabilidad());
    }

    @Test
    public void test37PiedraEsGolpeadaPorHachaDePiedraYNoSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        Piedra piedraHerramienta = new Piedra();
        Hacha hacha = new Hacha(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,5,1);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(hacha,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, piedra.getDurabilidad());
    }

    @Test
    public void test38PiedraEsGolpeadaPorHachaDeMetalYNoSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        Metal metalHerramienta = new Metal();
        Hacha hacha = new Hacha(metalHerramienta);
        Desgaste desgaste = new DesgasteLineal(400,10,1/2f);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(hacha,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad, piedra.getDurabilidad());
    }

    @Test
    public void test39PiedraEsGolpeadaPorPicoaDeMaderaYSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        Madera maderaHerramienta = new Madera();
        Pico pico = new Pico(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(pico,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad - pico.getFuerza(), piedra.getDurabilidad());
    }

    @Test
    public void test40PiedraEsGolpeadaPorPicoDePiedraYSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        Piedra piedraHerramienta = new Piedra();
        Pico pico = new Pico(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,4,1/5f);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(pico,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad - pico.getFuerza(), piedra.getDurabilidad());
    }

    @Test
    public void test41PiedraEsGolpeadaPorPicoDeMetalYSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        Metal metalHerramienta = new Metal();
        Pico pico = new Pico(metalHerramienta);
        Desgaste desgaste = new DesgastePorUsos(400,10,12);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(pico,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad - pico.getFuerza(), piedra.getDurabilidad());
    }

    @Test
    public void test42PiedraEsGolpeadaPorPicoFinoYNoSeReduceSuDurabilidad(){
        Piedra piedra = new Piedra();
        MetalYPiedra metalYPiedraHerramienta = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedraHerramienta);
        Desgaste desgaste = new DesgastePorcentual(100,20,0.1f);
        int durabilidad = piedra.getDurabilidad();

        piedra.serGolpeado(picoFino,metalYPiedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, piedra.getDurabilidad());
    }

    @Test
    public void test43MetalEsGolpeadoPorHachaDeMaderaYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        Madera maderaHerramienta = new Madera();
        Hacha hacha = new Hacha(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(hacha,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad, metal.getDurabilidad());
    }

    @Test
    public void test44MetalEsGolpeadoPorHachaDePiedraYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        Piedra piedraHerramienta = new Piedra();
        Hacha hacha = new Hacha(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,5,1);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(hacha,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, metal.getDurabilidad());
    }

    @Test
    public void test45MetalEsGolpeadoPorHachaDeMetalYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        Metal metalHerramienta = new Metal();
        Hacha hacha = new Hacha(metalHerramienta);
        Desgaste desgaste = new DesgasteLineal(400,10,1/2f);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(hacha,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad, metal.getDurabilidad());
    }

    @Test
    public void test46MetalEsGolpeadoPorPicoaDeMaderaYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        Madera maderaHerramienta = new Madera();
        Pico pico = new Pico(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(pico,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad, metal.getDurabilidad());
    }

    @Test
    public void test47MetalEsGolpeadoPorPicoDePiedraYSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        Piedra piedraHerramienta = new Piedra();
        Pico pico = new Pico(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,4,1/5f);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(pico,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad - pico.getFuerza(), metal.getDurabilidad());
    }

    @Test
    public void test48MetalEsGolpeadoPorPicoDeMetalYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        Metal metalHerramienta = new Metal();
        Pico pico = new Pico(metalHerramienta);
        Desgaste desgaste = new DesgastePorUsos(400,10,12);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(pico,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad, metal.getDurabilidad());
    }

    @Test
    public void test49MetalEsGolpeadoPorPicoFinoYNoSeReduceSuDurabilidad(){
        Metal metal = new Metal();
        MetalYPiedra metalYPiedraHerramienta = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedraHerramienta);
        Desgaste desgaste = new DesgastePorcentual(100,20,0.1f);
        int durabilidad = metal.getDurabilidad();

        metal.serGolpeado(picoFino,metalYPiedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, metal.getDurabilidad());
    }

    @Test
    public void test50DiamanteEsGolpeadoPorHachaDeMaderaYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        Madera maderaHerramienta = new Madera();
        Hacha hacha = new Hacha(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(hacha,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad, diamante.getDurabilidad());
    }

    @Test
    public void test51DiamanteEsGolpeadoPorHachaDePiedraYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        Piedra piedraHerramienta = new Piedra();
        Hacha hacha = new Hacha(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,5,1);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(hacha,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, diamante.getDurabilidad());
    }

    @Test
    public void test52DiamanteEsGolpeadoPorHachaDeMetalYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        Metal metalHerramienta = new Metal();
        Hacha hacha = new Hacha(metalHerramienta);
        Desgaste desgaste = new DesgasteLineal(400,10,1/2f);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(hacha,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad, diamante.getDurabilidad());
    }

    @Test
    public void test53DiamanteEsGolpeadoPorPicoaDeMaderaYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        Madera maderaHerramienta = new Madera();
        Pico pico = new Pico(maderaHerramienta);
        Desgaste desgaste = new DesgasteLineal(100,2,1);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(pico,maderaHerramienta, desgaste);

        Assert.assertEquals(durabilidad, diamante.getDurabilidad());
    }

    @Test
    public void test54DiamanteEsGolpeadoPorPicoDePiedraYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        Piedra piedraHerramienta = new Piedra();
        Pico pico = new Pico(piedraHerramienta);
        Desgaste desgaste = new DesgasteLineal(200,4,1/5f);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(pico,piedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad, diamante.getDurabilidad());
    }

    @Test
    public void test55DiamanteEsGolpeadoPorPicoDeMetalYNoSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        Metal metalHerramienta = new Metal();
        Pico pico = new Pico(metalHerramienta);
        Desgaste desgaste = new DesgastePorUsos(400,10,12);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(pico,metalHerramienta, desgaste);

        Assert.assertEquals(durabilidad, diamante.getDurabilidad());
    }

    @Test
    public void test56DiamanteEsGolpeadoPorPicoFinoYSeReduceSuDurabilidad(){
        Diamante diamante = new Diamante();
        MetalYPiedra metalYPiedraHerramienta = new MetalYPiedra();
        PicoFino picoFino = new PicoFino(metalYPiedraHerramienta);
        Desgaste desgaste = new DesgastePorcentual(100,20,0.1f);
        int durabilidad = diamante.getDurabilidad();

        diamante.serGolpeado(picoFino,metalYPiedraHerramienta, desgaste);

        Assert.assertEquals(durabilidad - picoFino.getFuerza(), diamante.getDurabilidad());
    }

    @Test
    public void test57MaderaSeInicializaConLaDurabilidadEsperada(){
        Madera madera = new Madera();
        int durabilidadEsperada = 10;

        Assert.assertEquals(durabilidadEsperada, madera.getDurabilidad());
    }

    @Test
    public void test58PiedraSeInicializaConLaDurabilidadEsperada(){
        Piedra piedra = new Piedra();
        int durabilidadEsperada = 30;

        Assert.assertEquals(durabilidadEsperada, piedra.getDurabilidad());
    }

    @Test
    public void test59MetalSeInicializaConLaDurabilidadEsperada(){
        Metal metal = new Metal();
        int durabilidadEsperada = 50;

        Assert.assertEquals(durabilidadEsperada, metal.getDurabilidad());
    }

    @Test
    public void test60DiamanteSeInicializaConLaDurabilidadEsperada(){
        Diamante diamante = new Diamante();
        int durabilidadEsperada = 100;

        Assert.assertEquals(durabilidadEsperada, diamante.getDurabilidad());
    }

    @Test
    public void test61MaderaSeDebilitaCorrectamente(){
        Madera madera = new Madera();
        int fuerza = 3;
        int durabilidadInicial = madera.getDurabilidad();

        madera.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - fuerza, madera.getDurabilidad());
        madera.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - 2 * fuerza, madera.getDurabilidad());
    }

    @Test
    public void test62PiedraSeDebilitaCorrectamente(){
        Piedra piedra = new Piedra();
        int fuerza = 3;
        int durabilidadInicial = piedra.getDurabilidad();

        piedra.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - fuerza, piedra.getDurabilidad());
        piedra.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - 2 * fuerza, piedra.getDurabilidad());
    }

    @Test
    public void test63MetalSeDebilitaCorrectamente(){
        Metal metal = new Metal();
        int fuerza = 3;
        int durabilidadInicial = metal.getDurabilidad();

        metal.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - fuerza, metal.getDurabilidad());
        metal.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - 2 * fuerza, metal.getDurabilidad());
    }

    @Test
    public void test64DiamanteSeDebilitaCorrectamente(){
        Diamante diamante = new Diamante();
        int fuerza = 3;
        int durabilidadInicial = diamante.getDurabilidad();

        diamante.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - fuerza, diamante.getDurabilidad());
        diamante.debilitarse(fuerza);
        Assert.assertEquals(durabilidadInicial - 2 * fuerza, diamante.getDurabilidad());
    }

    @Test (expected = NoSePuedeRecolectarUnMaterialNoDestruidoException.class)
    public void test65MaderaConDurabilidadNoPuedeSerRecolectada(){
        Madera madera = new Madera();
        int fuerza = 3;

        for (int i = 0; i < 3; i++) {
            madera.debilitarse(fuerza);
        }

        Assert.assertEquals(1, madera.getDurabilidad());

        madera.serRecolectado();
    }

    @Test ()
    public void test66MaderaDestruidaPuedeSerRecolectada(){
        Madera madera = new Madera();
        int fuerza = 3;

        for (int i = 0; i < 4; i++) {
            madera.debilitarse(fuerza);
        }

        Assert.assertTrue(madera.getDurabilidad() <= 0);
        madera.serRecolectado();
    }

    @Test (expected = NoSePuedeRecolectarUnMaterialNoDestruidoException.class)
    public void test67PiedraConDurabilidadNoPuedeSerRecolectada(){
        Piedra piedra = new Piedra();
        int fuerza = 29;

        piedra.debilitarse(fuerza);

        Assert.assertEquals(1, piedra.getDurabilidad());

        piedra.serRecolectado();
    }

    @Test
    public void test68PiedraDestruidaPuedeSerRecolectada(){
        Piedra piedra = new Piedra();
        int fuerza = 30;

        piedra.debilitarse(fuerza);

        Assert.assertTrue(piedra.getDurabilidad() <= 0);
        piedra.serRecolectado();
    }

    @Test (expected = NoSePuedeRecolectarUnMaterialNoDestruidoException.class)
    public void test69MetalConDurabilidadNoPuedeSerRecolectado(){
        Metal metal = new Metal();
        int fuerza = 49;

        metal.debilitarse(fuerza);

        Assert.assertEquals(1, metal.getDurabilidad());

        metal.serRecolectado();
    }

    @Test
    public void test70MetalDestruidoPuedeSerRecolectado(){
        Metal metal = new Metal();
        int fuerza = 50;

        metal.debilitarse(fuerza);

        Assert.assertTrue(metal.getDurabilidad() <= 0);

        metal.serRecolectado();
    }

    @Test (expected = NoSePuedeRecolectarUnMaterialNoDestruidoException.class)
    public void test71DiamanteConDurabilidadNoPuedeSerRecolectado(){
        Diamante diamante = new Diamante();
        int fuerza = 99;

        diamante.debilitarse(fuerza);

        Assert.assertEquals(1, diamante.getDurabilidad());

        diamante.serRecolectado();
    }

    @Test
    public void test72DiamanteDestruidoPuedeSerRecolectado(){
        Diamante diamante = new Diamante();
        int fuerza = 100;

        diamante.debilitarse(fuerza);

        Assert.assertTrue(diamante.getDurabilidad() <= 0);

        diamante.serRecolectado();
    }

    @Test
    public void test73MaderaSeteaPosicionBien(){
        Madera madera = new Madera();
        Posicion posicion = new Posicion(22,43);

        madera.setPosicion(posicion);

        assert posicion.equals(madera.getPosicion());
    }

    @Test
    public void test74PiedraSeteaPosicionBien(){
        Piedra piedra = new Piedra();
        Posicion posicion = new Posicion(22,43);

        piedra.setPosicion(posicion);

        assert posicion.equals(piedra.getPosicion());
    }

    @Test
    public void test75MetalSeteaPosicionBien(){
        Metal metal = new Metal();
        Posicion posicion = new Posicion(22,43);

        metal.setPosicion(posicion);

        assert posicion.equals(metal.getPosicion());
    }

    @Test
    public void test76DiamanteSeteaPosicionBien(){
        Diamante diamante = new Diamante();
        Posicion posicion = new Posicion(22,43);

        diamante.setPosicion(posicion);

        assert posicion.equals(diamante.getPosicion());
    }

}
