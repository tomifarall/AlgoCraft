package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public interface IMaterialMapa {

    void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste);

    void serGolpeado(Pico pico, Madera madera, Desgaste desgaste);

    void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Pico pico, Metal metal, Desgaste desgaste);

    void serGolpeado(PicoFino picoFino, MaterialPicoFino materialPicoFino, Desgaste desgaste);
}
