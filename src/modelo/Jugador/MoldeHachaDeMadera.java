package modelo.Jugador;

import modelo.Herramientas.Hacha;
import modelo.Herramientas.Herramienta;
import modelo.Mapa.Casillero;
import modelo.Mapa.CasilleroOcupadoException;
import modelo.Mapa.Posicion;
import modelo.Materiales.Madera;
import modelo.Materiales.Material;

import java.util.HashMap;

public class MoldeHachaDeMadera extends Molde {

    public MoldeHachaDeMadera(){
        receta = new HashMap<>();
        this.inicializarReceta(this.receta);
        this.rellenarReceta(this.receta);
    }

    @Override
    public void rellenarReceta(HashMap<Posicion,Casillero> receta) {
        this.crearMango(receta);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Posicion posCasillero = new Posicion(i, j);
                Casillero casilleroReceta = receta.get(posCasillero);
                Material materialDeReceta = new Madera();
                try {
                    casilleroReceta.ocuparCon(materialDeReceta);
                } catch (CasilleroOcupadoException e) {
                }
            }
        }
    }

    @Override
    public Herramienta create() {
        Madera madera = new Madera();
        return new Hacha(madera);
    }
}
