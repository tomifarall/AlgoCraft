package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.DesgastePorUsos;
import fiuba.algo3.Materiales.*;

public class Pico extends Herramienta {


    public Pico(Madera madera) {
        material = new Madera();
        desgaste = new DesgasteLineal(100,2,1);
    }
    public Pico(Piedra piedra) {
        material = new Piedra();
        desgaste = new DesgasteLineal(200,4,1/1.5);
    }
    public Pico(Metal metal) {
        material = new Metal();
        desgaste = new DesgastePorUsos(400,10, 12);
    }

    @Override
    public void golpearMaterial( Material material ){

        this.material.golpearMaterial(this, material);
    }

    @Override
    public void golpearMaterial( Material material , Madera maderaHerramienta){

        material.serGolpeado(this, maderaHerramienta, this.desgaste);
    }
    @Override
    public void golpearMaterial( Material material , Piedra piedraHerramienta){

        material.serGolpeado(this, piedraHerramienta, this.desgaste);
    }
    @Override
    public void golpearMaterial( Material material , Metal metalHerramienta){

        material.serGolpeado(this, metalHerramienta, this.desgaste);
    }
    @Override
    public void golpearMaterial( Material material , Diamante diamante){


    }
}
