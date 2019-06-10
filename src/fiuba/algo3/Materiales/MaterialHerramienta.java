package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public abstract class MaterialHerramienta extends Material {

    public abstract void golpear(Hacha hacha, MaterialMapa material, Desgaste desgaste);

    public abstract void golpear(Pico pico, MaterialMapa material, Desgaste desgaste);

    public void golpear(PicoFino picoFino, MaterialMapa material, Desgaste desgaste){

    }

}
