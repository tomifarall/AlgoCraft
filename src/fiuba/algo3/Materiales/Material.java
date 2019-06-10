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
}
