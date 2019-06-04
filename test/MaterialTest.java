import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertThrows;

import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Piedra;
import org.junit.Test;

public class MaterialTest {

    @Test
    public void test01MaderaSeGolpeaConHachaDeMaderaYSeReduceLaDurabilidadDelMaterial() {
        Madera madera = new Madera();
        Madera maderaMapa = new Madera();     //DUDAAAA HACERLO CON INTERFAZ O ASÍ?????
        Hacha hacha = new Hacha(madera);

        hacha.golpear(maderaMapa);

        assertEquals(8, maderaMapa.durabilidad());
    }

    @Test
    public void test02PiedraSeGolpeaConUnHachaYNoSeReduceLaDurabilidadDelMaterial() {
        Piedra piedraMapa = new Piedra();
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);

        hacha.golpear(piedraMapa);

        assertEquals(30, piedraMapa.durabilidad());
    }
    @Test
    public void test03MetalSeGolpeaConUnPicoDeMaderaYNoSeReduceLaDurabilidadDelMaterial(){
        Metal metalMapa = new Metal();
        Madera madera = new Madera();
        Pico pico = new Pico(madera);

        pico.golpear(metalMapa);

        assertEquals(50, metalMapa.durabilidad());
    }
}
