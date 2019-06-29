package fiuba.algo3.Moldes;

import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Mapa.Casillero;
import fiuba.algo3.Mapa.CasilleroOcupadoException;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.Madera;
import fiuba.algo3.Materiales.Material;
import fiuba.algo3.Materiales.Vacio;
import javafx.geometry.Pos;

import java.util.HashMap;

public abstract class Molde {
    protected HashMap<Posicion, Casillero> receta;

    protected void inicializarReceta(HashMap<Posicion, Casillero> receta) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Posicion posCasillero = new Posicion(i, j);
                Casillero casilleroMolde = new Casillero();
                receta.put(posCasillero,casilleroMolde);
            }
        }
    }



    protected void crearMango(HashMap<Posicion, Casillero> receta) {
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 2; j++) {
                Posicion posReceta = new Posicion(i, j);
                Casillero casilleroReceta = receta.get(posReceta);
                Material parteMango = new Madera();
                casilleroReceta.ocuparCon(parteMango);
            }
        }
    }

    public boolean esIgual(HashMap<Posicion, Casillero> tableroDeCraft) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Posicion posicionAComparar = new Posicion(i, j);
                Casillero casilleroDelCraft = tableroDeCraft.get(posicionAComparar);
                Casillero casilleroDeReceta = this.receta.get(posicionAComparar);
                IMapeable materialDelCraft = casilleroDelCraft.getOcupante();
                IMapeable materialDeReceta = casilleroDeReceta.getOcupante();
                if (!materialDelCraft.esIgual(materialDeReceta)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected abstract void rellenarReceta(HashMap<Posicion, Casillero> receta);


    public abstract Herramienta create();

}
