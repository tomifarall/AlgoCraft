package fiuba.algo3.Herramientas;

import fiuba.algo3.Desgastes.Desgaste;
import fiuba.algo3.Interfaces.IColeccionable;
import fiuba.algo3.Interfaces.IMaterialHerramienta;
import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Materiales.*;

public abstract class Herramienta implements IColeccionable {

    protected Desgaste desgaste;
    protected IMaterialHerramienta material;

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
