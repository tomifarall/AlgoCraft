

import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Materiales.MaterialMapaMadera;
import fiuba.algo3.Materiales.MaterialMapaMetal;
import fiuba.algo3.Materiales.MaterialMapaPiedra;
import org.junit.Test;
import org.junit.Assert;

public class MaterialTest {

    @Test
    public void test01MaderaSeGolpeaConHachaDeMaderaYSeReduceLaDurabilidadDelMaterial() {
        MaterialMapaMadera madera = new MaterialMapaMadera();
        MaterialMapaMadera maderaMapa = new MaterialMapaMadera();
        Hacha hacha = new Hacha(madera);

        hacha.golpearMaterial(maderaMapa);

        Assert.assertEquals(8, maderaMapa.getDurabilidad());
    }

    @Test
    public void test02PiedraSeGolpeaConUnHachaYNoSeReduceLaDurabilidadDelMaterial() {
        MaterialMapaPiedra piedraMapa = new MaterialMapaPiedra();
        MaterialMapaMadera madera = new MaterialMapaMadera();
        Hacha hacha = new Hacha(madera);

        hacha.golpearMaterial(piedraMapa);

        Assert.assertEquals(30, piedraMapa.getDurabilidad());
    }
    @Test
    public void test03MetalSeGolpeaConUnPicoDeMaderaYNoSeReduceLaDurabilidadDelMaterial(){
        MaterialMapaMetal metalMapa = new MaterialMapaMetal();
        MaterialMapaMadera madera = new MaterialMapaMadera();
        Pico pico = new Pico(madera);

        pico.golpearMaterial(metalMapa);

        Assert.assertEquals(50, metalMapa.getDurabilidad());
    }
}
