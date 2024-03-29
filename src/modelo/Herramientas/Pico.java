package modelo.Herramientas;

import modelo.Interfaces.IMaterialMapa;
import modelo.Materiales.*;

public class Pico extends Herramienta {


    public Pico(Madera madera) {
        this.material = madera;
        this.desgaste = new DesgasteLineal(100,2,1);
    }
    public Pico(Piedra piedra) {

        this.material = piedra;
        this.desgaste = new DesgasteLineal(200,4,1/1.5f);
    }
    public Pico(Metal metal) {
        this.material = metal;
        this.desgaste = new DesgastePorUsos(400,10, 12);
    }

    @Override
    public void golpearMaterial(IMaterialMapa material ){
        try{
            this.material.golpearMaterial(this, material);
        }catch(HerramientaRotaException e){throw e;}
    }

    @Override
    public void golpearMaterial( IMaterialMapa material , Madera maderaHerramienta){
        try{
            material.serGolpeado(this, maderaHerramienta, this.desgaste);
        }catch (HerramientaRotaException e) { throw e;}
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Piedra piedraHerramienta){
        try{
            material.serGolpeado(this, piedraHerramienta, this.desgaste);

        }catch(HerramientaRotaException e){throw e;}
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Metal metalHerramienta){
        try{
            material.serGolpeado(this, metalHerramienta, this.desgaste);

        }catch(HerramientaRotaException e){ throw e;}
    }
    @Override
    public void golpearMaterial( IMaterialMapa material , Diamante diamante){
    }
    @Override
    public void golpearMaterial(IMaterialMapa material, MetalYPiedra metalYPiedraHerramienta) {

    }
}
