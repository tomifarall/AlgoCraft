package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;

public abstract class Material implements IMaterialHerramienta, IMaterialMapa{

    protected int durabilidad;

    public int getDurabilidad() { return this.durabilidad;}

    protected void debilitarse(int fuerza) { this.durabilidad -= fuerza; }

    public abstract void golpearMaterial(Hacha hacha, IMaterialMapa material);

    public abstract void golpearMaterial(Pico pico, IMaterialMapa material);

    public abstract void golpearMaterial(Pico pico, IMaterialMapa material, Fino finitud);

    public abstract void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste);

    public abstract void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste);

    public abstract void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, Madera madera, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste);

    public abstract void serGolpeado(Pico pico, Metal metal, Desgaste desgaste);

}
