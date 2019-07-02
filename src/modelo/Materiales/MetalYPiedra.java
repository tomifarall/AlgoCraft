package modelo.Materiales;

import modelo.Desgastes.Desgaste;
import modelo.Desgastes.HerramientaRotaException;
import modelo.Herramientas.Hacha;
import modelo.Herramientas.Pico;
import modelo.Herramientas.PicoFino;
import modelo.Interfaces.IMaterialMapa;

public class MetalYPiedra extends Material  {

    public MetalYPiedra(){
        this.durabilidadInicial = 10;
        this.durabilidad = durabilidadInicial;
        this.tipoMaterial = "metal y piedra";
    }

    @Override
    public void golpearMaterial(Hacha hacha, IMaterialMapa material) {
    }

    @Override
    public void golpearMaterial(Pico pico, IMaterialMapa material) {
    }

    @Override
    public void golpearMaterial(PicoFino picoFino, IMaterialMapa material) {
        try{
            picoFino.golpearMaterial(material,this);

        }catch (HerramientaRotaException e){throw e;}
    }

    @Override
    public void serGolpeado(Hacha hacha, Madera madera, Desgaste desgaste) {

    }

    @Override
    public void serGolpeado(Hacha hacha, Piedra piedra, Desgaste desgaste){

    }

    @Override
    public void serGolpeado(Hacha hacha, Metal metal, Desgaste desgaste){

    }

    @Override
    public void serGolpeado(Pico pico, Madera madera, Desgaste desgaste){

    }

    @Override
    public void serGolpeado(Pico pico, Piedra piedra, Desgaste desgaste){

    }

    @Override
    public void serGolpeado(Pico pico, Metal metal, Desgaste desgaste){

    }
    @Override
    public void serGolpeado(PicoFino picoFino, MetalYPiedra materialPicoFino, Desgaste desgaste){

    }
}
