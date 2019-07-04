package modelo.Materiales;

import modelo.Herramientas.*;
import modelo.Interfaces.IMaterialMapa;

public class Piedra extends Material {

    public Piedra(){
        this.durabilidadInicial = 30;
        durabilidad = durabilidadInicial;
        this.tipoMaterial = "piedra";
    }

    @Override
    public void golpearMaterial(Hacha hacha, IMaterialMapa material) {
        try {
            hacha.golpearMaterial(material, this);
        }catch(HerramientaRotaException e){throw e;}
    }

    @Override
    public void golpearMaterial(Pico pico, IMaterialMapa material) {
        try {
            pico.golpearMaterial(material, this);
        }catch(HerramientaRotaException e){throw e;}
    }

    @Override
    public void golpearMaterial(PicoFino picoFino, IMaterialMapa material) {}

    @Override
    public void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste) {
        try{
            desgaste.usar();

        }catch (HerramientaRotaException e){
            throw e;
        }
    }

    @Override
    public void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste){
        try{
            desgaste.usar();

        }catch (HerramientaRotaException e){
            throw e;
        }
    }

    @Override
    public void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste){
        try{
            desgaste.usar();

        }catch (HerramientaRotaException e){
            throw e;
        }
    }

    @Override
    public void serGolpeado(Pico pico, Madera madera, Desgaste desgaste){
        desgaste.debilitarMaterial(this);
        try {
            desgaste.usar();
        }catch (HerramientaRotaException e){
            throw e;
        }

    }

    @Override
    public void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste){
        desgaste.debilitarMaterial(this);
        try {
            desgaste.usar();
        }catch (HerramientaRotaException e){
            throw e;
        }
    }

    @Override
    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){
        desgaste.debilitarMaterial(this);
        try {
            desgaste.usar();
        }catch (HerramientaRotaException e){ throw e;}

    }

    @Override
    public  void serGolpeado (PicoFino picoFino, MetalYPiedra materialPicoFino, Desgaste desgaste){}
}
