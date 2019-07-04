package modelo.Herramientas;

import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMaterialMapa;
import modelo.Materiales.*;


public abstract class Herramienta implements IColeccionable {

    protected Desgaste desgaste;

    protected Material material;

    public Material getMaterial(){
        return material;
    }

    public int getDurabilidad() {
        return desgaste.getDurabilidad();
    }

    public int getFuerza(){ return desgaste.getFuerza(); }

    public abstract void golpearMaterial( IMaterialMapa material );

    public abstract void golpearMaterial(IMaterialMapa material, Madera maderaHerramienta);
    public abstract void golpearMaterial(IMaterialMapa material, Piedra piedraHerramienta);
    public abstract void golpearMaterial(IMaterialMapa material, Metal metalHerramienta);
    public abstract void golpearMaterial(IMaterialMapa material, Diamante diamanteHerramienta);
    public abstract void golpearMaterial(IMaterialMapa material, MetalYPiedra metalYPiedraHerramienta);
}
