package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Herramientas.PicoFino;
import fiuba.algo3.Interfaces.IMaterialMapa;

public class Madera extends Material {

    public Madera(){
        this.durabilidadInicial = 10;
        this.durabilidad = this.durabilidadInicial;
    }

    @Override
    public void golpearMaterial(Hacha hacha, IMaterialMapa material) {

        try{
            hacha.golpearMaterial(material,this);
        }catch(NoSePuedeUsarSinDurabilidadException e){throw e;}
    }


    @Override
    public void golpearMaterial(Pico pico, IMaterialMapa material) {
        try {
            pico.golpearMaterial(material, this);
        }catch(NoSePuedeUsarSinDurabilidadException e){throw e;}
    }

    @Override
    public void golpearMaterial(PicoFino picoFino, IMaterialMapa material) {}

    @Override
    public void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste) {
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){ throw e;}

        desgaste.debilitarMaterial(this);
    }

    @Override
    public void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch (NoSePuedeUsarSinDurabilidadException e){throw  e;}
        desgaste.debilitarMaterial(this);

    }

    @Override
    public void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch(NoSePuedeUsarSinDurabilidadException e){throw e;}
        desgaste.debilitarMaterial(this);
    }

    @Override
    public void serGolpeado(Pico pico, Madera madera, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch(NoSePuedeUsarSinDurabilidadException e){throw e;}
        desgaste.debilitarMaterial(this);
    }

    @Override
    public void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch(NoSePuedeUsarSinDurabilidadException e){throw e;}
        desgaste.debilitarMaterial(this);
    }

    @Override
    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){
        try {
            desgaste.usar();
        }catch(NoSePuedeUsarSinDurabilidadException e){throw e;}
        desgaste.debilitarMaterial(this);
    }

    @Override
    public  void serGolpeado (PicoFino picoFino, MetalYPiedra materialPicoFino, Desgaste desgaste){}
}
