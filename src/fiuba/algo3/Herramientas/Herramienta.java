package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.MaterialHerramienta;
import fiuba.algo3.Materiales.MaterialMapa;





public abstract class Herramienta {

    protected Desgaste desgaste;

    protected MaterialHerramienta material;

    public int getDurabilidad() {
        return desgaste.getDurabilidad();
    }

    public int getFuerza(){ return desgaste.getFuerza(); }

    public void golpearMaterial( MaterialMapa material ){
    }
}
