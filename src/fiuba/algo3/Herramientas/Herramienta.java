package fiuba.algo3.Herramientas;

import fiuba.algo3.Materiales.Material;





public abstract class Herramienta {



    public int getDurabilidad() {
        return 0;
    }

    public int getFuerza(){ return 0; }

    public abstract void DesgastarMaterial( Material madera);
}
