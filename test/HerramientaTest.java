import modelo.Herramientas.FuerzaInvalidaException;
import modelo.Herramientas.HerramientaRotaException;
import modelo.Herramientas.Herramienta;
import modelo.Herramientas.Hacha;
import modelo.Herramientas.Pico;
import modelo.Herramientas.PicoFino;
import modelo.Interfaces.IMaterialMapa;
import modelo.Materiales.*;
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
        public void Test11HachaDeMetalDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
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
        public void Test12PicoDeMaderaDeberiaDebilitarseCorrectamenteCuandoSeUsaContraLosMateriales() {
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

        @Test (expected = HerramientaRotaException.class)
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


        @Test (expected = HerramientaRotaException.class)
        public void Test18HachaDeMaderaHerramientaRota(){
            Madera maderaHerramienta = new Madera();
            IMaterialMapa diamante = new Diamante();
            Herramienta hacha = new Hacha(maderaHerramienta);
            int fuerza = hacha.getFuerza();
            int durabilidad = hacha.getDurabilidad();
            float multiplicador = 1;
            int cantidadDeUsos = durabilidad / ((int) (fuerza*multiplicador)) -1;

            for (int i = 0; i < cantidadDeUsos; i++){
                try{
                    hacha.golpearMaterial(diamante);
                }catch (HerramientaRotaException e){throw new FuerzaInvalidaException();
                }
            }

            hacha.golpearMaterial(diamante);
        }

        @Test (expected = HerramientaRotaException.class)
        public void Test19HachaDePiedraHerramientaRota(){
            Piedra piedraHerramienta = new Piedra();
            IMaterialMapa madera = new Madera();
            Herramienta hacha = new Hacha(piedraHerramienta);
            int fuerza = hacha.getFuerza();
            int durabilidad = hacha.getDurabilidad();
            float multiplicador = 1;
            int cantidadDeUsos = durabilidad / ((int) (fuerza*multiplicador)) -1;

            for (int i = 0; i < cantidadDeUsos; i++){
                try {
                    hacha.golpearMaterial(madera);
                }catch (HerramientaRotaException e) {
                    throw new FuerzaInvalidaException();
                }
            }

            hacha.golpearMaterial(madera);
        }

        @Test (expected = HerramientaRotaException.class)
        public void Test20HachaDeMetalHerramientaRota(){
            Metal metalHerramienta = new Metal();
            IMaterialMapa piedra = new Piedra();
            Herramienta hacha = new Hacha(metalHerramienta);
            int fuerza = hacha.getFuerza();
            int durabilidad = hacha.getDurabilidad();
            float multiplicador = 1/2f;
            int cantidadDeUsos = durabilidad / ((int) (fuerza*multiplicador)) -1;

            for (int i = 0; i < cantidadDeUsos; i++){
                try {
                    hacha.golpearMaterial(piedra);
                }catch (HerramientaRotaException e) {
                    throw new FuerzaInvalidaException();
                }
            }

            hacha.golpearMaterial(piedra);
        }

        @Test (expected = HerramientaRotaException.class)
        public void Test21PicoDeMaderaHerramientaRota(){
            Madera maderaHerramienta = new Madera();
            IMaterialMapa diamante = new Diamante();
            Herramienta pico = new Pico(maderaHerramienta);
            int fuerza = pico.getFuerza();
            int durabilidad = pico.getDurabilidad();
            float multiplicador = 1;
            int cantidadDeUsos = durabilidad / ((int) (fuerza*multiplicador)) -1;

            for (int i = 0; i < cantidadDeUsos; i++){
                try {
                    pico.golpearMaterial(diamante);
                }catch (HerramientaRotaException e) {
                    throw new FuerzaInvalidaException();
                }
            }

            pico.golpearMaterial(diamante);
        }

        @Test (expected = HerramientaRotaException.class)
        public void Test22PicoDePiedraHerramientaRota(){
            Piedra piedraHerramienta = new Piedra();
            IMaterialMapa madera = new Madera();
            Herramienta pico = new Pico(piedraHerramienta);
            int fuerza = pico.getFuerza();
            int durabilidad = pico.getDurabilidad();
            float multiplicador = 1/1.5f;
            int cantidadDeUsos = durabilidad / ((int) (fuerza*multiplicador)) -1;

            for (int i = 0; i < cantidadDeUsos; i++){
                try {
                    pico.golpearMaterial(madera);
                }catch (HerramientaRotaException e) {
                    throw new FuerzaInvalidaException();
                }
            }

            pico.golpearMaterial(madera);
        }

        @Test (expected = HerramientaRotaException.class)
        public void Test23PicoDeMetalHerramientaRota(){
            Metal metalHerramienta = new Metal();
            IMaterialMapa diamante = new Diamante();
            Herramienta pico = new Pico(metalHerramienta);

            for (int i = 0; i < 9; i++){
                try {
                    pico.golpearMaterial(diamante);
                }catch (HerramientaRotaException e) {
                    throw new FuerzaInvalidaException();
                }
            }

            pico.golpearMaterial(diamante);
        }

        @Test
        public void Test24HachadeMaderaDebilitaMadera() {
            Madera madera = new Madera();
            Herramienta hacha = new Hacha(new Madera());
            int durabilidad = madera.getDurabilidad();
            int fuerzaHacha = hacha.getFuerza();

            hacha.golpearMaterial(madera);
            hacha.golpearMaterial(madera);

            Assert.assertEquals((durabilidad - 2 * fuerzaHacha), madera.getDurabilidad());
        }

        @Test
        public void Test25HachadeMaderaNoDebilitaPiedra() {
            Piedra piedra = new Piedra();
            Herramienta hacha = new Hacha(new Madera());
            int durabilidad = piedra.getDurabilidad();

            hacha.golpearMaterial(piedra);
            hacha.golpearMaterial(piedra);
            hacha.golpearMaterial(piedra);

            Assert.assertEquals(durabilidad, piedra.getDurabilidad());
        }

        @Test
        public void Test26HachadeMaderaNoDebilitaMetal() {
            Metal metal = new Metal();
            Herramienta hacha = new Hacha(new Madera());
            int durabilidad = metal.getDurabilidad();

            hacha.golpearMaterial(metal);
            hacha.golpearMaterial(metal);
            hacha.golpearMaterial(metal);

            Assert.assertEquals(durabilidad , metal.getDurabilidad());
        }

        @Test
        public void Test27HachadeMaderaNoDebilitaDiamante() {
            Diamante diamante = new Diamante();
            Herramienta hacha = new Hacha(new Madera());
            int durabilidad = diamante.getDurabilidad();

            hacha.golpearMaterial(diamante);
            hacha.golpearMaterial(diamante);
            hacha.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad, diamante.getDurabilidad());
        }

        @Test
        public void Test28HachaDePiedraDebilitaMadera() {
            Madera madera = new Madera();
            Herramienta hacha = new Hacha(new Piedra());
            int durabilidad = madera.getDurabilidad();
            int fuerza = hacha.getFuerza();

            hacha.golpearMaterial(madera);

            Assert.assertEquals(durabilidad - fuerza, madera.getDurabilidad());
        }

        @Test
        public void Test29HachaDePiedraNoDebilitaPiedra() {
            Piedra piedra = new Piedra();
            Herramienta hacha = new Hacha(new Piedra());
            int durabilidad = piedra.getDurabilidad();

            hacha.golpearMaterial(piedra);
            hacha.golpearMaterial(piedra);
            hacha.golpearMaterial(piedra);

            Assert.assertEquals(durabilidad, piedra.getDurabilidad());
        }

        @Test
        public void Test30HachaDePiedraNoDebilitaMetal() {
            Metal metal = new Metal();
            Herramienta hacha = new Hacha(new Piedra());
            int durabilidad = metal.getDurabilidad();

            hacha.golpearMaterial(metal);
            hacha.golpearMaterial(metal);
            hacha.golpearMaterial(metal);

            Assert.assertEquals(durabilidad, metal.getDurabilidad());
        }

        @Test
        public void Test31HachaDePiedraNoDebilitaDiamante() {
            Diamante diamante = new Diamante();
            Herramienta hacha = new Hacha(new Piedra());
            int durabilidad = diamante.getDurabilidad();

            hacha.golpearMaterial(diamante);
            hacha.golpearMaterial(diamante);
            hacha.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad, diamante.getDurabilidad());
        }

        @Test
        public void Test32HachaDeMetalDebilitaMadera() {
            Madera madera = new Madera();
            Herramienta hacha = new Hacha(new Metal());
            int durabilidad = madera.getDurabilidad();
            int fuerza = hacha.getFuerza();

            hacha.golpearMaterial(madera);

            Assert.assertEquals(durabilidad - fuerza, madera.getDurabilidad());
        }

        @Test
        public void Test33HachaDeMetalNoDebilitaPiedra() {
            Piedra piedra = new Piedra();
            Herramienta hacha = new Hacha(new Metal());
            int durabilidad = piedra.getDurabilidad();

            hacha.golpearMaterial(piedra);
            hacha.golpearMaterial(piedra);
            hacha.golpearMaterial(piedra);

            Assert.assertEquals(durabilidad, piedra.getDurabilidad());
        }

        @Test
        public void Test34HachaDeMetalNoDebilitaMetal() {
            Metal metal = new Metal();
            Herramienta hacha = new Hacha(new Metal());
            int durabilidad = metal.getDurabilidad();

            hacha.golpearMaterial(metal);
            hacha.golpearMaterial(metal);
            hacha.golpearMaterial(metal);

            Assert.assertEquals(durabilidad, metal.getDurabilidad());
        }

        @Test
        public void Test35HachaDeMetalNoDebilitaDiamante() {
            Diamante diamante = new Diamante();
            Herramienta hacha = new Hacha(new Metal());
            int durabilidad = diamante.getDurabilidad();

            hacha.golpearMaterial(diamante);
            hacha.golpearMaterial(diamante);
            hacha.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad, diamante.getDurabilidad());
        }


        @Test
        public void Test36PicoDeMaderaNoDebilitaMadera() {
            Madera madera = new Madera();
            Herramienta pico = new Pico(new Madera());
            int durabilidad = madera.getDurabilidad();

            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);

            Assert.assertEquals(durabilidad, madera.getDurabilidad());
        }
        @Test
        public void Test37PicoMaderaDebilitaPiedra() {
            Piedra piedra = new Piedra();
            Herramienta pico = new Pico(new Madera());
            int durabilidad = piedra.getDurabilidad();
            int fuerza = pico.getFuerza();

            pico.golpearMaterial(piedra);
            pico.golpearMaterial(piedra);
            pico.golpearMaterial(piedra);


            Assert.assertEquals(durabilidad - 3 * fuerza, piedra.getDurabilidad());
        }

        @Test
        public void Test38PicoDeMaderaNoDebilitaMetal() {
            Metal metal = new Metal();
            Herramienta pico = new Pico(new Madera());
            int durabilidad = metal.getDurabilidad();

            pico.golpearMaterial(metal);
            pico.golpearMaterial(metal);
            pico.golpearMaterial(metal);

            Assert.assertEquals(durabilidad, metal.getDurabilidad());
        }

        @Test
        public void Test39PicoDeMaderaNoDebilitaDiamante() {
            Diamante diamante = new Diamante();
            Herramienta pico = new Pico(new Madera());
            int durabilidad = diamante.getDurabilidad();

            pico.golpearMaterial(diamante);
            pico.golpearMaterial(diamante);
            pico.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad, diamante.getDurabilidad());
        }
        @Test
        public void Test40PicoDePiedraNoDebilitaMadera() {
            Madera madera = new Madera();
            Herramienta pico = new Pico(new Piedra());
            int durabilidad = madera.getDurabilidad();

            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);

            Assert.assertEquals(durabilidad, madera.getDurabilidad());
        }

        @Test
        public void Test41PicoPiedraDebilitaPiedra() {
            Piedra piedra = new Piedra();
            Herramienta pico = new Pico(new Piedra());
            int durabilidad = piedra.getDurabilidad();
            int fuerza = pico.getFuerza();

            pico.golpearMaterial(piedra);
            pico.golpearMaterial(piedra);
            pico.golpearMaterial(piedra);


            Assert.assertEquals(durabilidad - 3 * fuerza, piedra.getDurabilidad());
        }
        @Test
        public void Test42PicoDePiedraDebilitaMetal() {
            Metal metal = new Metal();
            Herramienta pico = new Pico(new Piedra());
            int durabilidad = metal.getDurabilidad();
            int fuerza = pico.getFuerza();

            pico.golpearMaterial(metal);
            pico.golpearMaterial(metal);
            pico.golpearMaterial(metal);

            Assert.assertEquals(durabilidad - 3 * fuerza, metal.getDurabilidad());
        }

        @Test
        public void Test43PicoDePiedraNoDebilitaDiamante() {
            Diamante diamante = new Diamante();
            Herramienta pico = new Pico(new Piedra());
            int durabilidad = diamante.getDurabilidad();

            pico.golpearMaterial(diamante);
            pico.golpearMaterial(diamante);
            pico.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad, diamante.getDurabilidad());
        }

        @Test
        public void Test44PicoDeMetalNoDebilitaMadera() {
            Madera madera = new Madera();
            Herramienta pico = new Pico(new Metal());
            int durabilidad = madera.getDurabilidad();

            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);
            pico.golpearMaterial(madera);

            Assert.assertEquals(durabilidad, madera.getDurabilidad());
        }

        @Test
        public void Test45PicoDeMetalDebilitaPiedra() {
            Piedra piedra = new Piedra();
            Herramienta pico = new Pico(new Metal());
            int durabilidad = piedra.getDurabilidad();
            int fuerza = pico.getFuerza();

            pico.golpearMaterial(piedra);
            pico.golpearMaterial(piedra);
            pico.golpearMaterial(piedra);


            Assert.assertEquals(durabilidad - 3 * fuerza, piedra.getDurabilidad());
        }

        @Test
        public void Test46PicoDeMetalNoDebilitaMetal() {
            Metal metal = new Metal();
            Herramienta pico = new Pico(new Metal());
            int durabilidad = metal.getDurabilidad();

            pico.golpearMaterial(metal);
            pico.golpearMaterial(metal);
            pico.golpearMaterial(metal);

            Assert.assertEquals(durabilidad, metal.getDurabilidad());
        }

        @Test
        public void Test47PicoDeMetalNoDebilitaDiamante() {
            Diamante diamante = new Diamante();
            Herramienta pico = new Pico(new Metal());
            int durabilidad = diamante.getDurabilidad();

            pico.golpearMaterial(diamante);
            pico.golpearMaterial(diamante);
            pico.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad, diamante.getDurabilidad());
        }

        @Test
        public void test48PicoFinoNoDebilitaMadera(){
            Madera madera = new Madera();
            Herramienta picoFino = new PicoFino(new MetalYPiedra());
            int durabilidad = madera.getDurabilidad();

            picoFino.golpearMaterial(madera);
            picoFino.golpearMaterial(madera);
            picoFino.golpearMaterial(madera);

            Assert.assertEquals(durabilidad, madera.getDurabilidad());
        }
        @Test
        public void test49PicoFinoNoDebilitaPiedra(){
            Piedra piedra = new Piedra();
            Herramienta picoFino = new PicoFino(new MetalYPiedra());
            int durabilidad = piedra.getDurabilidad();

            picoFino.golpearMaterial(piedra);
            picoFino.golpearMaterial(piedra);
            picoFino.golpearMaterial(piedra);

            Assert.assertEquals(durabilidad, piedra.getDurabilidad());
        }

        @Test
        public void test50PicoFinoNoDebilitaMetal(){
            Metal metal = new Metal();
            Herramienta picoFino = new PicoFino(new MetalYPiedra());
            int durabilidad = metal.getDurabilidad();

            picoFino.golpearMaterial(metal);
            picoFino.golpearMaterial(metal);
            picoFino.golpearMaterial(metal);

            Assert.assertEquals(durabilidad, metal.getDurabilidad());
        }
        @Test
        public void test51PicoFinoDebilitaDiamante(){
            Diamante diamante = new Diamante();
            Herramienta picoFino = new PicoFino(new MetalYPiedra());
            int durabilidad = diamante.getDurabilidad();
            int fuerza = picoFino.getFuerza();

            picoFino.golpearMaterial(diamante);
            picoFino.golpearMaterial(diamante);
            picoFino.golpearMaterial(diamante);

            Assert.assertEquals(durabilidad - 3 * fuerza, diamante.getDurabilidad());
        }

        @Test (expected = HerramientaRotaException.class)
        public void Test52PicoFinoHerramientaRota(){
            MetalYPiedra metalYPiedra = new MetalYPiedra();
            IMaterialMapa diamante = new Diamante();
            Herramienta picoFino = new PicoFino(metalYPiedra);

            for (int i = 0; i < 50; i++){
                picoFino.golpearMaterial(diamante);
                diamante = new Diamante();
            }

            Assert.assertEquals(0, picoFino.getDurabilidad());

            picoFino.golpearMaterial(diamante);
        }

}






