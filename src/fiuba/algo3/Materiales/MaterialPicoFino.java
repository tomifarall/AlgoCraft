package fiuba.algo3.Materiales;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Pico;

public class MaterialPicoFino extends Material {

    public MaterialPicoFino(){
        this.durabilidad = 10;
    }

    @Override
    public void golpearMaterial(Hacha hacha, IMaterialMapa material) {
    }

    @Override
    public void golpearMaterial(Pico pico, IMaterialMapa material) {
    }

    @Override
    public void golpearMaterial(Pico pico, IMaterialMapa material, Fino finitud){
        pico.golpearMaterial(material, finitud, this);
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
    public void serGolpeado(Pico pico, MaterialPicoFino materialPicoFino, Desgaste desgaste, Fino finitud){

    }
}
