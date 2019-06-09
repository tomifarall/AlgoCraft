package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public class MaterialPicoFino extends Material{

    protected void inicializarDesgaste(){
        desgaste= new DesgastePorcentual(1000, 0.1);
    }


    public void golpearMaterial(Hacha hacha, Material material){

    }

    public void golpearMaterial(Pico pico, Material material){

    }

    public void golpearMaterial(PicoFino picoFino, Material material, Desgaste desgaste){
        material.serGolpeado(picoFino, this, desgaste);
    }

    public void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste){

    }

    public void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste){

    }

    public void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste){

    }

    public void serGolpeado(Pico pico, Madera madera, Desgaste desgaste){

    }

    public void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste){

    }

    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){

    }

}
