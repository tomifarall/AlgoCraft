package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Materiales.Material;





public abstract class Herramienta {

    protected Desgaste desgaste;

    protected Material material;

    public int getDurabilidad() {
        return desgaste.getDurabilidad();
    }

    public int getFuerza(){ return desgaste.getFuerza(); }

    public void golpearMaterial( Material material ){
    }
}
