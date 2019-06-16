package fiuba.algo3.Materiales;

import fiuba.algo3.Herramientas.Pico;

public class NoFino implements IFinitud{

    public void golpearMaterial(Pico pico, IMaterialMapa material){
        pico.golpearMaterial(material, this);
    }
}
