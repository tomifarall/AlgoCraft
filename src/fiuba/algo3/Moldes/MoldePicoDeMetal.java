package fiuba.algo3.Moldes;

import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Herramientas.Pico;
import fiuba.algo3.Mapa.Casillero;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.Metal;

import java.util.HashMap;

public class MoldePicoDeMetal extends Molde {

    public MoldePicoDeMetal(){
        receta = new HashMap<>();
        this.inicializarReceta(this.receta);
        this.rellenarReceta(this.receta);
    }


    @Override
    public void rellenarReceta(HashMap<Posicion, Casillero> receta){
        this.crearMango(receta);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                Posicion posCasillero = new Posicion(i, j);
                Casillero casilleroReceta = receta.get(posCasillero);
                Material materialDeReceta = new Metal();
                casilleroReceta.ocuparCon(materialDeReceta);
            }
        }
    }

    @Override
    public Herramienta create() {
        Metal metal = new Metal();
        return new Pico(metal);
    }
}
