package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;

public class MaterialHerramientaMetal extends MaterialHerramienta{
    public MaterialHerramientaMetal(){
        this.inicializarDesgaste();
    }

    @Override
    protected void inicializarDesgaste(){
        this.desgaste = new DesgasteLineal(50);
    }


    @Override
    public void golpear(Hacha hacha, MaterialMapa material, Desgaste desgaste) {
        material.serGolpeado(hacha,this,desgaste);
    }

    @Override
    public void golpear(Pico pico, MaterialMapa material, Desgaste desgaste) {
        material.serGolpeado(pico,this,desgaste);
    }

    /*@Override
    public void golpear(PicoFino picoFino, Material material, Desgaste desgaste) {
        material.serGolpeado(picoFino,this,desgaste);
    }*/

}
