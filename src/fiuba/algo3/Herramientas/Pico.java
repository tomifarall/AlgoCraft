package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.DesgastePorUsos;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.Piedra;

public class Pico extends Herramienta {

    Pico(Madera madera)
    {
        material = madera;
        desgaste = new DesgasteLineal(100,2,1);
    }
    Pico(Piedra piedra)
    {
        material = piedra;
        desgaste = new DesgasteLineal(200,4,1/1.5);
    }
    Pico(Metal metal)
    {
        material = metal;
        desgaste = new DesgastePorUsos(400,10);
    }

    @Override
    public void DesgastarMaterial(Material madera) {

    }
}
