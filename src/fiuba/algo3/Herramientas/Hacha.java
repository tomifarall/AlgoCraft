package fiuba.algo3.Herramientas;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.Piedra;

public class Hacha extends Herramienta {

    Hacha(Madera madera)
    {
        material = madera;
        desgaste = new DesgasteLineal(100,2,1);
    }
    Hacha(Piedra piedra)
    {
        material = piedra;
        desgaste = new DesgasteLineal(200,5,1);
    }
    Hacha(Metal metal)
    {
        material = metal;
        desgaste = new DesgasteLineal(400,10,0.5);
    }

    @Override
    public  void DesgastarMaterial(Material madera) {

    }
}
