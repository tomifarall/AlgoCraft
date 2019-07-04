package modelo.Interfaces;

import modelo.Herramientas.*;
import modelo.Materiales.*;

public interface IMaterialMapa {

    void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste);

    int  getDurabilidad();

    void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste);

    void serGolpeado(Pico pico, Madera madera, Desgaste desgaste);

    void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste);

    void serGolpeado(Pico pico, Metal metal, Desgaste desgaste);

    void serGolpeado(PicoFino picoFino, MetalYPiedra metalYPiedra , Desgaste desgaste);

    void serRecolectado();
}
