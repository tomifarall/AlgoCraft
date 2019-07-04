package modelo.Herramientas;

import modelo.Desgastes.DesgastePorcentual;
import modelo.Desgastes.HerramientaRotaException;
import modelo.Interfaces.IMaterialMapa;
import modelo.Materiales.*;

public class PicoFino extends Herramienta {

    public PicoFino(MetalYPiedra metalYPiedra) {
        this.material = metalYPiedra;
        this.desgaste = new DesgastePorcentual(1000,20, 0.1f);
    }

    @Override
    public void golpearMaterial( IMaterialMapa material ){

        try {
            this.material.golpearMaterial(this, material);
        }catch (HerramientaRotaException e){throw e;}
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
        }catch (HerramientaRotaException e){throw e;}
    }
}
