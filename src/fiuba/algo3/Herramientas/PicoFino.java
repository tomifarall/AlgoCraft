package fiuba.algo3.Herramientas;

import fiuba.algo3.Materiales.*;

public class PicoFino extends Herramienta {

    @Override
    public void golpearMaterial( IMaterialMapa material ){

        this.material.golpearMaterial(this, material);
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

    public void golpearMaterial( IMaterialMapa material , MaterialPicoFino materialPicoFino){
        material.serGolpeado(this, materialPicoFino, this.desgaste);
    }
}
