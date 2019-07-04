package modelo.Interfaces;

import modelo.Herramientas.*;

public interface IMaterialHerramienta {

    void golpearMaterial(Hacha hacha, IMaterialMapa material);

    void golpearMaterial(Pico pico, IMaterialMapa material);

    void golpearMaterial(PicoFino picoFino, IMaterialMapa material);
}
