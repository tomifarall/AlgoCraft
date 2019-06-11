package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;
import fiuba.algo3.Materiales.Material;

public class Piedra extends Material {

    public Piedra(){ this.durabilidad = 30; }




    @Override
    public void golpearMaterial(Hacha hacha, IMaterialMapa material) {
        hacha.golpearMaterial(material,this);
    }

    @Override
    public void golpearMaterial(Pico pico, IMaterialMapa material) {
        pico.golpearMaterial(material,this);
    }

    @Override
    public void golpearMaterial(PicoFino picoFino, IMaterialMapa material){}

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
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){}
        this.debilitarse(desgaste.getFuerza());
    }

    @Override
    public void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){}
        this.debilitarse(desgaste.getFuerza());
    }

    @Override
    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){}
        this.debilitarse(desgaste.getFuerza());
    }

    @Override
    public void serGolpeado(PicoFino picoFino, MaterialPicoFino materialPicoFino, Desgaste desgaste){}
}
