package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public class MaterialMapaMetal extends MaterialMapa {

    public MaterialMapaMetal(){
        this.inicializarDesgaste();
    }

    @Override
    protected void inicializarDesgaste(){
        this.desgaste = new DesgasteLineal(50);
    }

    @Override
    public void serGolpeado(Hacha hacha, MaterialHerramientaMadera madera, Desgaste desgaste) {
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Hacha hacha, MaterialHerramientaPiedra piedra, Desgaste desgaste){
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Hacha hacha, MaterialHerramientaMetal metal, Desgaste desgaste){
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Pico pico, MaterialHerramientaMadera madera, Desgaste desgaste){
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Pico pico, MaterialHerramientaPiedra piedra, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){}
        this.desgaste.usar(desgaste.getFuerza());
    }

    @Override
    public void serGolpeado(Pico pico, MaterialHerramientaMetal metal, Desgaste desgaste){
        desgaste.usar();
    }
}
