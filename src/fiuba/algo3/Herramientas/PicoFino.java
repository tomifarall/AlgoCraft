package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Materiales.MaterialMapa;
import fiuba.algo3.Materiales.MaterialHerramientaPicoFino;

public class PicoFino extends Herramienta {


    public PicoFino() {
        material = new MaterialHerramientaPicoFino();
        desgaste = new DesgastePorcentual(1000,0.1);
    }

    public void golpearMaterial( MaterialMapa materialMapa){
            this.material.golpear(this, materialMapa, this.desgaste);
    }
}
