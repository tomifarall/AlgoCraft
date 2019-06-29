package fiuba.algo3.Desgastes;

import fiuba.algo3.Materiales.Diamante;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.Piedra;

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

