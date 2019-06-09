package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;

public class Diamante extends Material {
    public Diamante(){
        this.inicializarDesgaste();
    }

    @Override
    protected void inicializarDesgaste(){
        this.desgaste = new DesgasteLineal(100);
    }

    @Override
    public void golpearMaterial(Hacha hacha, Material material) {
        hacha.golpearMaterial(material,this);
    }

    @Override
    public void golpearMaterial(Pico pico, Material material) {
        pico.golpearMaterial(material,this);
    }

    /*@Override
    public void golpearMaterial(PicoFino picoFino, Material material, Desgaste desgaste) {
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
        desgaste.usar();
    }

    @Override
    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){
        desgaste.usar();
    }

    public void serGolpeado(PicoFino pico, MaterialPicoFino material, Desgaste desgaste){
        desgaste.usar();
    }

}
