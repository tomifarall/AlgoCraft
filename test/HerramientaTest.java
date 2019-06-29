import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;
import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Materiales.*;
import org.junit.Assert;
import org.junit.Test;

public class HerramientaTest {

    @Test
    public void Test01HachaDeMaderaDeberiaCrearseConLaDurabilidadEsperada() {
        Madera madera = new Madera();
        Herramienta hacha = new Hacha(madera);
        int resultado = hacha.getDurabilidad();

        Assert.assertEquals(100, resultado);
    }

    @Test
    public void Test02HachaDeMaderaDeberiaCrearseConLaFuerzaEsperada() {
        Madera madera = new Madera();
        Herramienta hacha = new Hacha(madera);
        int resultado = hacha.getFuerza();

        Assert.assertEquals(2, resultado);
    }


    @Test
    public void Test03PicoDeMaderaDeberiaCrearseConLaDurabilidadEsperada() {
        Madera madera = new Madera();
        Herramienta pico = new Pico(madera);
        int resultado = pico.getDurabilidad();

        Assert.assertEquals(100, resultado);
    }

    @Test
    public void Test04PicoDeMaderaDeberiaCrearseConLaFuerzaEsperada() {
        Madera madera = new Madera();
        Herramienta pico = new Pico(madera);
        int resultado = pico.getFuerza();

        Assert.assertEquals(2, resultado);
    }

    @Test
    public void Test05HachaDeMetalDeberiaCrearseConLaDurabilidadEsperada() {
        Metal metal = new Metal();
        Herramienta hacha = new Hacha(metal);
        int resultado = hacha.getDurabilidad();

        Assert.assertEquals(400, resultado);
    }

    @Test
    public void Test06HachaDeMetalDeberiaCrearseConLaFuerzaEsperada() {
        Metal metal = new Metal();
        Herramienta hacha = new Hacha(metal);
        int resultado = hacha.getFuerza();

        Assert.assertEquals(10, resultado);
    }

    @Test
    public void Test07PicoDeMetalDeberiaCrearseConLaDurabilidadEsperada() {
        Metal metal = new Metal();
        Herramienta pico = new Pico(metal);
        int resultado = pico.getDurabilidad();

        Assert.assertEquals(400, resultado);
    }

    @Test
    public void Test08PicoDeMetalDeberiaCrearseConLaFuerzaEsperada() {
        Metal metal = new Metal();
        Herramienta pico = new Pico(metal);
        int resultado = pico.getFuerza();

        Assert.assertEquals(12, resultado);
    }

    @Test
    public void Test09HachadeMaderaDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta hacha = new Hacha(madera);
        int durabilidadHacha = hacha.getDurabilidad();
        int fuerzaHacha = hacha.getFuerza();

        //Uso el Hacha contra cada material y por cada uso deberia restarse a su durabilidad su fuerza.

        hacha.golpearMaterial(madera);
        hacha.golpearMaterial(piedra);
        hacha.golpearMaterial(metal);
        hacha.golpearMaterial(diamante);


        Assert.assertEquals((durabilidadHacha - 4 * fuerzaHacha), hacha.getDurabilidad());
    }

    @Test
    public void Test10HachaDePiedraDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta hacha = new Hacha(piedra);
        int durabilidadHacha = hacha.getDurabilidad();
        int fuerzaHacha = hacha.getFuerza();

        //Uso el Hacha contra cada material y por cada uso deberia restarse a su durabilidad su fuerza.

        hacha.golpearMaterial(madera);
        hacha.golpearMaterial(piedra);
        hacha.golpearMaterial(metal);
        hacha.golpearMaterial(diamante);


        Assert.assertEquals((durabilidadHacha - 4 * fuerzaHacha), hacha.getDurabilidad());
    }

    @Test
    public void Test11HachadeMetalDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta hacha = new Hacha(metal);
        int durabilidadHacha = hacha.getDurabilidad();
        int fuerzaHacha = hacha.getFuerza();


        //Uso el Hacha contra cada material y por cada uso deberia restarse a su durabilidad su fuerza/2.

        hacha.golpearMaterial(madera);
        hacha.golpearMaterial(piedra);
        hacha.golpearMaterial(metal);
        hacha.golpearMaterial(diamante);


        Assert.assertEquals((durabilidadHacha - 4 * (fuerzaHacha / 2)), hacha.getDurabilidad());
    }

    @Test
    public void Test12PicodeMaderaDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta pico = new Pico(madera);
        int durabilidadPico = pico.getDurabilidad();
        int fuerzaPico = pico.getFuerza();

        //Uso el pico contra cada material y por cada uso deberia restarse a su durabilidad su fuerza.

        pico.golpearMaterial(madera);
        pico.golpearMaterial(piedra);
        pico.golpearMaterial(metal);
        pico.golpearMaterial(diamante);


        Assert.assertEquals((durabilidadPico - 4 * fuerzaPico), pico.getDurabilidad());
    }

    @Test
    public void Test13PicoDePiedraDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta pico = new Pico(piedra);
        int durabilidadPico = pico.getDurabilidad();
        int fuerzaPico = pico.getFuerza();

        //Uso el Pico contra cada material y por cada uso deberia restarse a su durabilidad su fuerza sobre 1.5.

        pico.golpearMaterial(madera);
        pico.golpearMaterial(piedra);
        pico.golpearMaterial(metal);
        pico.golpearMaterial(diamante);


        Assert.assertEquals((durabilidadPico - 4 *(int)(fuerzaPico / 1.5)), pico.getDurabilidad());
    }

    @Test
    public void Test14PicoDeMetalDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta pico = new Pico(metal);
        int durabilidadPico = pico.getDurabilidad();

        //Uso el Pico contra cada material y por cada uso no deberia cambiar su durabilidad.

        pico.golpearMaterial(madera);
        pico.golpearMaterial(piedra);
        pico.golpearMaterial(metal);
        pico.golpearMaterial(diamante);


        Assert.assertEquals(durabilidadPico, pico.getDurabilidad());
    }

    @Test
    public void Test15PicoDeMetalDeberiaRomperseCuandoSeUsa10Veces() {
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Diamante diamante = new Diamante();
        Herramienta pico = new Pico(metal);


        //Uso el Pico contra cada material y por cada uso no deberia cambiar su durabilidad.
        for (int i = 0; i < 2; i++) {
            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);
            pico.golpearMaterial(piedra);
            pico.golpearMaterial(metal);
            pico.golpearMaterial(diamante);
        }

        Assert.assertEquals(0, pico.getDurabilidad());

    }


    @Test
    public void Test16PicoFinoDeberiaDebilitarseCorrectamenteCuandoSeUsaContraDiamante(){

        Material diamante = new Diamante();
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        Herramienta picoFino = new PicoFino(metalYPiedra);
        int durabilidadPicoFino = picoFino.getDurabilidad();

        //Uso el PicoFino contra el Diamante y por cada uso deberia restarse a su durabilidad su durabilidad sobre 10.
        int durabilidadEsperada = durabilidadPicoFino;
        durabilidadEsperada -= (0.1*durabilidadEsperada);

        picoFino.golpearMaterial(diamante);
        durabilidadEsperada -= (0.1*durabilidadEsperada);

        picoFino.golpearMaterial(diamante);
        durabilidadEsperada -= (0.1*durabilidadEsperada);
        picoFino.golpearMaterial(diamante);
        durabilidadEsperada -= (0.1*durabilidadEsperada);
        picoFino.golpearMaterial(diamante);


        Assert.assertEquals(durabilidadEsperada, picoFino.getDurabilidad());
    }

    @Test
    public void Test17PicoFinoNoDeberiaDebilitarseCuandoSeUsaContraMaterialesQueNoSeanDiamante() {

        IMaterialMapa madera = new Madera();
        IMaterialMapa piedra = new Piedra();
        IMaterialMapa metal = new Metal();
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        Herramienta picoFino = new PicoFino(metalYPiedra);
        int durabilidadPicoFino = picoFino.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            picoFino.golpearMaterial(madera);
            picoFino.golpearMaterial(piedra);
            picoFino.golpearMaterial(metal);
        }

        Assert.assertEquals(durabilidadPicoFino, picoFino.getDurabilidad());

    }

}

