package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public abstract class MaterialMapa extends Material{

    public abstract void serGolpeado(Hacha hacha, MaterialHerramientaMadera madera, Desgaste desgaste);

    public abstract void serGolpeado(Hacha hacha, MaterialHerramientaPiedra piedra, Desgaste desgaste);

    public abstract void serGolpeado(Hacha hacha, MaterialHerramientaMetal metal, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, MaterialHerramientaMadera madera, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, MaterialHerramientaPiedra piedra, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, MaterialHerramientaMetal metal, Desgaste desgaste);

    public void serGolpeado(PicoFino picoFino, MaterialHerramientaPicoFino materialPicoFino, Desgaste desgaste){

    }
}
