package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.DesgastePorUsos;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.Piedra;

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

        this.material.golpear(this, material, this.desgaste);
    }
}
