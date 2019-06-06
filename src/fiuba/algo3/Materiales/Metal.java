package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public class Metal extends Material {

    public Metal(){
        this.inicializarDesgaste();
    }

    @Override
    protected void inicializarDesgaste(){
        this.desgaste = new DesgasteLineal(50);
    }


    @Override
    public void golpear(Hacha hacha, Material material, Desgaste desgaste) {
        material.serGolpeado(hacha,this,desgaste);
    }

    @Override
    public void golpear(Pico pico, Material material, Desgaste desgaste) {
        material.serGolpeado(pico,this,desgaste);
    }

    /*@Override
    public void golpear(PicoFino picoFino, Material material, Desgaste desgaste) {
        material.serGolpeado(picoFino,this,desgaste);
    }*/

    @Override
    public void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste) {
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste){
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste){
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Pico pico, Madera madera, Desgaste desgaste){
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){}
        this.desgaste.usar(desgaste.getFuerza());
    }

    @Override
    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){
        desgaste.usar();
    }
}
