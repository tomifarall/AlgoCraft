package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;

public interface IMaterialMapa {

    void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste);

    void serGolpeado(Pico pico, Madera madera, Desgaste desgaste);

    void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Pico pico, Metal metal, Desgaste desgaste);

    void serGolpeado(Pico pico, MaterialPicoFino materialPicoFino, Desgaste desgaste, Fino finitud);
}
