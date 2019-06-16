package fiuba.algo3.Materiales;

import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;

public interface IMaterialHerramienta {

    void golpearMaterial(Hacha hacha, IMaterialMapa material);

    void golpearMaterial(Pico pico, IMaterialMapa material);

    void golpearMaterial(Pico pico, IMaterialMapa material, Fino finitud);
}
