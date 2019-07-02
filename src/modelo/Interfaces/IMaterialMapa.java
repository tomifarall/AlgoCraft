package modelo.Interfaces;

import modelo.Desgastes.Desgaste;
import modelo.Herramientas.Hacha;
import modelo.Herramientas.Pico;
import modelo.Herramientas.PicoFino;
import modelo.Materiales.Madera;
import modelo.Materiales.Metal;
import modelo.Materiales.MetalYPiedra;
import modelo.Materiales.Piedra;

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
