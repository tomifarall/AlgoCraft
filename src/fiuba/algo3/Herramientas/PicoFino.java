package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Materiales.*;

public class PicoFino extends Herramienta {

    public PicoFino(){
        material= new MaterialPicoFino();
        desgaste= new DesgastePorcentual(1000, 0.1);
    }

    @Override
    public void golpearMaterial(Material material){

        this.material.golpearMaterial(this, material, this.desgaste);
    }

    @Override
    public void golpearMaterial( Material material , Madera maderaHerramienta){


    }
    @Override
    public void golpearMaterial( Material material , Piedra piedraHerramienta){


    }
    @Override
    public void golpearMaterial( Material material , Metal metalHerramienta){


    }
    @Override
    public void golpearMaterial( Material material , Diamante diamante){


    }
}
