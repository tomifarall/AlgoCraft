package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.DesgastePorUsos;
import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Materiales.*;

public class Pico extends Herramienta {

    private IFinitud finitud;

    public Pico(Madera madera) {
        material = new Madera();
        desgaste = new DesgasteLineal(100,2,1);
        finitud = new NoFino();
    }
    public Pico(Piedra piedra) {
        material = new Piedra();
        desgaste = new DesgasteLineal(200,4,1/1.5);
        finitud = new NoFino();
    }
    public Pico(Metal metal) {
        material = new Metal();
        desgaste = new DesgastePorUsos(400,10, 12);
        finitud = new NoFino();
    }

    public Pico(MaterialPicoFino materialPicoFino, IFinitud finitud) {
        material = new MaterialPicoFino();
        desgaste = new DesgastePorcentual(1000,20,0.1f);
        this.finitud = finitud;
    }


    @Override
    public void golpearMaterial( IMaterialMapa material ){
        
        this.finitud.golpearMaterial(this, material);
    }

    @Override
    public void golpearMaterial( IMaterialMapa material , Madera maderaHerramienta){

        material.serGolpeado(this, maderaHerramienta, this.desgaste);
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Piedra piedraHerramienta){

        material.serGolpeado(this, piedraHerramienta, this.desgaste);
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Metal metalHerramienta){

        material.serGolpeado(this, metalHerramienta, this.desgaste);
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Diamante diamante){

    }

    public void golpearMaterial( IMaterialMapa material , Fino finitud){

        this.material.golpearMaterial(this, material, finitud);
    }

    public void golpearMaterial( IMaterialMapa material , NoFino finitud){

        this.material.golpearMaterial(this, material);
    }

    public void golpearMaterial( IMaterialMapa material , Fino finitud, MaterialPicoFino materialPicoFino){
        material.serGolpeado(this, materialPicoFino, desgaste, finitud);
    }
}
