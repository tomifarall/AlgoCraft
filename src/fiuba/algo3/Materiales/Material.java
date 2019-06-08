package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public abstract class Material {

    protected Desgaste desgaste;

    public Material() {
        this.inicializarDesgaste();
    }

    protected abstract void inicializarDesgaste();

    public int getDurabilidad() { return desgaste.getDurabilidad();}

    public abstract void golpearMaterial(Hacha hacha, Material material);

    public abstract void golpearMaterial(Pico pico, Material material);

    /*public abstract void golpearMaterial(PicoFino picoFino, Material material, Desgaste desgaste);*/

    public abstract void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste);

    public abstract void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste);

    public abstract void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, Madera madera, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, Metal metal, Desgaste desgaste);



}
