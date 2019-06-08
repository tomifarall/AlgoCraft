package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Materiales.*;


public abstract class Herramienta {

    protected Desgaste desgaste;

    protected Material material;

    public int getDurabilidad() {
        return desgaste.getDurabilidad();
    }

    public int getFuerza(){ return desgaste.getFuerza(); }

    public void golpearMaterial( Material material ){
    }
    public abstract void golpearMaterial(Material material, Madera maderaHerramienta);
    public abstract void golpearMaterial(Material material, Piedra piedraHerramienta);
    public abstract void golpearMaterial(Material material, Metal metalHerramienta);
    public abstract void golpearMaterial(Material material, Diamante diamanteHerramienta);
}
