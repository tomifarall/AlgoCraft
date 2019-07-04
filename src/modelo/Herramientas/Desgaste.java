package modelo.Herramientas;

import modelo.Materiales.Diamante;
import modelo.Materiales.Madera;
import modelo.Materiales.Metal;
import modelo.Materiales.Piedra;

public abstract class Desgaste {

    protected int durabilidad;
    protected int fuerza;

    public int getDurabilidad(){
        return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

    public abstract void usar();

    public void debilitarMaterial(Madera madera){
        madera.debilitarse(this.fuerza);
    }

    public void debilitarMaterial(Piedra piedra){
        piedra.debilitarse(this.fuerza);
    }

    public void debilitarMaterial(Metal metal){
        metal.debilitarse(this.fuerza);
    }

    public void debiliatarMaterial(Diamante diamante) { diamante.debilitarse(this.fuerza);}
}

