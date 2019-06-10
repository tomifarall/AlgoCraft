package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public class MaterialHerramientaPicoFino extends MaterialHerramienta{

    protected void inicializarDesgaste(){
        desgaste= new DesgastePorcentual(1000, 0.1);
    }


    public void golpear(Hacha hacha, MaterialMapa material, Desgaste desgaste){

    }

    public void golpear(Pico pico, MaterialMapa material, Desgaste desgaste){

    }

    public void golpear(PicoFino picoFino, MaterialMapa material, Desgaste desgaste){
        material.serGolpeado(picoFino, this, desgaste);
    }

}
