package modelo.Herramientas;

import modelo.Desgastes.DesgastePorcentual;
import modelo.Desgastes.HerramientaRotaException;
import modelo.Interfaces.IMaterialMapa;
import modelo.Materiales.*;

public class PicoFino extends Herramienta {

    public PicoFino(MetalYPiedra metalYPiedra) {
        //material = new Metal();
        material = metalYPiedra;
        desgaste = new DesgastePorcentual(1000,20, 0.1f);
    }

    @Override
    public void golpearMaterial( IMaterialMapa material ){

        this.material.golpearMaterial(this, material );
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
