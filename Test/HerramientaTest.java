import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;
import fiuba.algo3.Materiales.*;
import org.junit.Assert;
import org.junit.Test;

public class HerramientaTest {

	@Test
	public void Test01HachaDeMaderaDeberiaCrearseConLaDurabilidadEsperada(){
        Herramienta hacha = new Hacha();
        int resultado = hacha.getDurabilidad();

        Assert.assertEquals( 100 , resultado);
	}

    @Test
    public  void Test02HachaDeMaderaDeberiaCrearseConLaFuerzaEsperada(){
	    Herramienta hacha = new Hacha();
	    int resultado = hacha.getFuerza();

	    Assert.assertEquals( 2 , resultado);
    }


    @Test
    public void Test03PicoDeMaderaDeberiaCrearseConLaDurabilidadEsperada(){
        Herramienta pico = new Pico();
        int resultado = pico.getDurabilidad();

        Assert.assertEquals( 100 , resultado);
    }

    @Test
    public  void Test04PicoDeMaderaDeberiaCrearseConLaFuerzaEsperada(){
        Herramienta pico = new Pico();
        int resultado = pico.getFuerza();

        Assert.assertEquals( 2 , resultado);
    }

    @Test
    public void Test05HachaDeMetalDeberiaCrearseConLaDurabilidadEsperada(){
        Herramienta hacha = new Hacha();
        int resultado = hacha.getDurabilidad();

        Assert.assertEquals( 400 , resultado);
    }

    @Test
    public  void Test06HachaDeMetalDeberiaCrearseConLaFuerzaEsperada(){
        Herramienta hacha = new Hacha();
        int resultado = hacha.getFuerza();

        Assert.assertEquals( 10 , resultado);
    }
    @Test
    public void Test07PicoDeMetalDeberiaCrearseConLaDurabilidadEsperada(){
        Herramienta hacha = new Hacha();
        int resultado = hacha.getDurabilidad();

        Assert.assertEquals( 400 , resultado);
    }

    @Test
    public  void Test08PicoDeMetalDeberiaCrearseConLaFuerzaEsperada(){
        Herramienta hacha = new Hacha();
        int resultado = hacha.getFuerza();

        Assert.assertEquals( 12 , resultado);
    }

    @Test
    public void Test09HachadeMaderaDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales(){
	    Material madera = new Madera();
	    Material piedra = new Piedra();
	    Material metal = new Metal();
	    Material diamante = new Diamante();
	    Herramienta hacha = new Hacha();
	    int durabilidadHacha = hacha.getDurabilidad();
	    int fuerzaHacha = hacha.getFuerza();

	    //Uso el Hacha contra cada material y por cada uso deberia restarse a su durabilidad su fuerza.

	    hacha.DesgastarMaterial(madera);
	    hacha.DesgastarMaterial(piedra);
	    hacha.DesgastarMaterial(metal);
	    hacha.DesgastarMaterial(diamante);


	    Assert.assertEquals((durabilidadHacha-4*fuerzaHacha)  , hacha.getDurabilidad() );
	}

    @Test
    public void Test10HachaDePiedraDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales(){
        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Material diamante = new Diamante();
        Herramienta hacha = new Hacha();
        int durabilidadHacha = hacha.getDurabilidad();
        int fuerzaHacha = hacha.getFuerza();

        //Uso el Hacha contra cada material y por cada uso deberia restarse a su durabilidad su fuerza.

        hacha.DesgastarMaterial(madera);
        hacha.DesgastarMaterial(piedra);
        hacha.DesgastarMaterial(metal);
        hacha.DesgastarMaterial(diamante);


        Assert.assertEquals((durabilidadHacha-4*fuerzaHacha)  , hacha.getDurabilidad() );
    }

    @Test
    public void Test11HachadeMetalDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales(){
        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Material diamante = new Diamante();
        Herramienta hacha = new Hacha();
        int durabilidadHacha = hacha.getDurabilidad();
        int fuerzaHacha = hacha.getFuerza();


        //Uso el Hacha contra cada material y por cada uso deberia restarse a su durabilidad su fuerza/2.

        hacha.DesgastarMaterial(madera);
        hacha.DesgastarMaterial(piedra);
        hacha.DesgastarMaterial(metal);
        hacha.DesgastarMaterial(diamante);


        Assert.assertEquals((durabilidadHacha-4*(fuerzaHacha/2)) , hacha.getDurabilidad() );
    }

    @Test
    public void Test12PicodeMaderaDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales(){
        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Material diamante = new Diamante();
        Herramienta pico = new Pico();
        int durabilidadPico = pico.getDurabilidad();
        int fuerzaPico = pico.getFuerza();

        //Uso el pico contra cada material y por cada uso deberia restarse a su durabilidad su fuerza.

        pico.DesgastarMaterial(madera);
        pico.DesgastarMaterial(piedra);
        pico.DesgastarMaterial(metal);
        pico.DesgastarMaterial(diamante);


        Assert.assertEquals((durabilidadPico-4*fuerzaPico ) , pico.getDurabilidad() );
    }

    @Test
    public void Test13PicoDePiedraDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales(){
        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Material diamante = new Diamante();
        Herramienta pico = new Pico();
        int durabilidadPico = pico.getDurabilidad();
        int fuerzaPico = pico.getFuerza();

        //Uso el Pico contra cada material y por cada uso deberia restarse a su durabilidad su fuerza sobre 1.5.

        pico.DesgastarMaterial(madera);
        pico.DesgastarMaterial(piedra);
        pico.DesgastarMaterial(metal);
        pico.DesgastarMaterial(diamante);


        Assert.assertEquals((durabilidadPico-4*(fuerzaPico/1.5))  , pico.getDurabilidad() );
    }

    @Test
    public void Test14PicoDeMetalDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales(){
        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Material diamante = new Diamante();
        Herramienta pico = new Pico();
        int durabilidadPico = pico.getDurabilidad();

        //Uso el Pico contra cada material y por cada uso no deberia cambiar su durabilidad.

        pico.DesgastarMaterial(madera);
        pico.DesgastarMaterial(piedra);
        pico.DesgastarMaterial(metal);
        pico.DesgastarMaterial(diamante);


        Assert.assertEquals(durabilidadPico , pico.getDurabilidad() );
    }

    @Test
    public void Test13PicoDeMetalDeberiaRomperseCuandoSeUsa10Veces() {
        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Material diamante = new Diamante();
        Herramienta pico = new Pico();


        //Uso el Pico contra cada material y por cada uso no deberia cambiar su durabilidad.
        for (int i = 0; i < 2; i++) {
            pico.DesgastarMaterial(madera);
            pico.DesgastarMaterial(madera);
            pico.DesgastarMaterial(piedra);
            pico.DesgastarMaterial(metal);
            pico.DesgastarMaterial(diamante);
        }

        Assert.assertEquals(0, pico.getDurabilidad());

    }


    @Test
    public void Test15PicoFinoDeberiaDebilitarseCorrectamenteCuandoSeUsaContraDiamante(){

        Material diamante = new Diamante();
        Herramienta picoFino = new PicoFino();
        int durabilidadPicoFino = picoFino.getDurabilidad();

        //Uso el PicoFino contra el Diamante y por cada uso deberia restarse a su durabilidad su durabilidad sobre 10.

        picoFino.DesgastarMaterial(diamante);
        picoFino.DesgastarMaterial(diamante);
        picoFino.DesgastarMaterial(diamante);
        picoFino.DesgastarMaterial(diamante);


        Assert.assertEquals((durabilidadPicoFino - 4*( durabilidadPicoFino / 10 ))  , picoFino.getDurabilidad() );
    }

    @Test
    public void Test16PicoFinoNoDeberiaDebilitarseCuandoSeUsaContraMaterialesQueNoSeanDiamante() {

        Material madera = new Madera();
        Material piedra = new Piedra();
        Material metal = new Metal();
        Herramienta picoFino = new PicoFino();
        int durabilidadPicoFino = picoFino.getDurabilidad();

        for (int i = 0; i < 5; i++) {
            picoFino.DesgastarMaterial(madera);
            picoFino.DesgastarMaterial(piedra);
            picoFino.DesgastarMaterial(metal);
        }

        Assert.assertEquals(durabilidadPicoFino, picoFino.getDurabilidad());

    }
}
