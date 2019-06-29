package fiuba.algo3.Moldes;

import fiuba.algo3.Herramientas.Hacha;
import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Mapa.Casillero;
import fiuba.algo3.Mapa.CasilleroOcupadoException;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.Metal;
import fiuba.algo3.Materiales.Piedra;

import java.util.HashMap;

public class MoldeHachaDeMetal extends Molde {

    public MoldeHachaDeMetal(){
        receta = new HashMap<>();
        this.inicializarReceta(this.receta);
        this.rellenarReceta(this.receta);
    }

    @Override
    public void rellenarReceta(HashMap<Posicion,Casillero> receta){
        this.crearMango(receta);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Posicion posCasillero = new Posicion(i, j);
                Casillero casilleroReceta = receta.get(posCasillero);
                Material materialDeReceta = new Metal();
                try {
                    casilleroReceta.ocuparCon(materialDeReceta);
                } catch (CasilleroOcupadoException e) {
                }
            }
        }
    }

    @Override
    public Herramienta create() {
        Metal metal = new Metal();
        return new Hacha(metal);
    }
}
