package fiuba.algo3.Interfaces;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.MetalYPiedra;
import fiuba.algo3.Materiales.Piedra;

public interface IMaterialMapa {

    void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste);

    void serGolpeado(Pico pico, Madera madera, Desgaste desgaste);

    void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Pico pico, Metal metal, Desgaste desgaste);

    void serGolpeado(PicoFino picoFino, MetalYPiedra metalYPiedra , Desgaste desgaste);

    void serRecolectado();
}
