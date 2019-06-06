

import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.Piedra;
import org.junit.Test;
import org.junit.Assert;

public class MaterialTest {

    @Test
    public void test01MaderaSeGolpeaConHachaDeMaderaYSeReduceLaDurabilidadDelMaterial() {
        Madera madera = new Madera();
        Madera maderaMapa = new Madera();
        Hacha hacha = new Hacha(madera);

        hacha.golpearMaterial(maderaMapa);

        Assert.assertEquals(8, maderaMapa.getDurabilidad());
    }

    @Test
    public void test02PiedraSeGolpeaConUnHachaYNoSeReduceLaDurabilidadDelMaterial() {
        Piedra piedraMapa = new Piedra();
        Madera madera = new Madera();
        Hacha hacha = new Hacha(madera);

        hacha.golpearMaterial(piedraMapa);

        Assert.assertEquals(30, piedraMapa.getDurabilidad());
    }
    @Test
    public void test03MetalSeGolpeaConUnPicoDeMaderaYNoSeReduceLaDurabilidadDelMaterial(){
        Metal metalMapa = new Metal();
        Madera madera = new Madera();
        Pico pico = new Pico(madera);

        pico.golpearMaterial(metalMapa);

        Assert.assertEquals(50, metalMapa.getDurabilidad());
    }
}
