package fiuba.algo3.Materiales;

import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;

public class Fino implements IFinitud{

    public void golpearMaterial(Pico pico, IMaterialMapa material){
        pico.golpearMaterial(material, this);
    }
}
