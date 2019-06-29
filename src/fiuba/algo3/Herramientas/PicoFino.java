package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Materiales.*;

public class PicoFino extends Herramienta {

    public PicoFino(MetalYPiedra metalYPiedra) {
        this.material = metalYPiedra;
        this.desgaste = new DesgastePorcentual(1000,20, 0.1f);
    }

    @Override
    public void golpearMaterial( IMaterialMapa material ){
        try {
            this.material.golpearMaterial(this, material);
        }catch (NoSePuedeUsarSinDurabilidadException e){throw e;}
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Madera maderaHerramienta){


    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Piedra piedraHerramienta){


    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Metal metalHerramienta){


    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Diamante diamante){
    }

    @Override
    public  void golpearMaterial ( IMaterialMapa material, MetalYPiedra metalYPiedra){
        try {
            material.serGolpeado(this, metalYPiedra, this.desgaste);
        }catch (NoSePuedeUsarSinDurabilidadException e){throw e;}
    }
}
