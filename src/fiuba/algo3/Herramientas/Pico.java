package fiuba.algo3.Herramientas;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.DesgastePorUsos;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.MaterialHerramienta;
import fiuba.algo3.Materiales.MaterialHerramientaMadera;
import fiuba.algo3.Materiales.MaterialMapaMadera;
import fiuba.algo3.Materiales.MaterialMapa;
import fiuba.algo3.Materiales.MaterialMapaMetal;
import fiuba.algo3.Materiales.MaterialHerramientaMetal;
import fiuba.algo3.Materiales.MaterialMapaPiedra;
import fiuba.algo3.Materiales.MaterialHerramientaPiedra;

public class Pico extends Herramienta {


    public Pico(MaterialMapaMadera madera) {
        material = new MaterialHerramientaMadera();
        desgaste = new DesgasteLineal(100,2,1);
    }
    public Pico(MaterialMapaPiedra piedra) {
        material = new MaterialHerramientaPiedra();
        desgaste = new DesgasteLineal(200,4,1/1.5);
    }
    public Pico(MaterialMapaMetal metal) {
        material = new MaterialHerramientaMetal();
        desgaste = new DesgastePorUsos(400,10, 12);
    }

    @Override
    public void golpearMaterial( MaterialMapa material ){

        this.material.golpear(this, material, this.desgaste);
    }
}
