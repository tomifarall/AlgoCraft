package modelo.Jugador;

import modelo.Herramientas.Herramienta;
import modelo.Herramientas.PicoFino;
import modelo.Mapa.Casillero;
import modelo.Mapa.Posicion;
import modelo.Materiales.Material;
import modelo.Materiales.Metal;
import modelo.Materiales.MetalYPiedra;
import modelo.Materiales.Piedra;

import java.util.HashMap;

public class MoldePicoFino extends Molde {

    public MoldePicoFino(){
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
        Posicion posicionEspecialPicoFino = new Posicion(1,0 );
        Casillero casilleroEspecialPicoFino = receta.get(posicionEspecialPicoFino);
        casilleroEspecialPicoFino.ocuparCon(new Piedra());
    }


    @Override
    public Herramienta create() {
        MetalYPiedra metalYPiedra = new MetalYPiedra();
        return new PicoFino(metalYPiedra);
    }
}
