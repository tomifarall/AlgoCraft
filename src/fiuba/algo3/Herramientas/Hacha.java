package fiuba.algo3.Herramientas;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.MaterialHerramienta;
import fiuba.algo3.Materiales.MaterialHerramientaMadera;
import fiuba.algo3.Materiales.MaterialMapaMadera;
import fiuba.algo3.Materiales.MaterialMapa;
import fiuba.algo3.Materiales.MaterialMapaMetal;
import fiuba.algo3.Materiales.MaterialHerramientaMetal;
import fiuba.algo3.Materiales.MaterialMapaPiedra;
import fiuba.algo3.Materiales.MaterialHerramientaPiedra;


public class Hacha extends Herramienta {


    public Hacha(MaterialMapaMadera madera) {
        material = new MaterialHerramientaMadera();
        desgaste = new DesgasteLineal(100,2,1);
    }
    public Hacha(MaterialMapaPiedra piedra) {
        material = new MaterialHerramientaPiedra();
        desgaste = new DesgasteLineal(200,5,1);
    }
    public Hacha(MaterialMapaMetal metal) {
        material = new MaterialHerramientaMetal();
        desgaste = new DesgasteLineal(400,10,0.5);
    }

    @Override
    public void golpearMaterial( MaterialMapa material ){

        this.material.golpear(this, material, this.desgaste);
    }
}
