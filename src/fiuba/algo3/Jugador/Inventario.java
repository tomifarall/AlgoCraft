package fiuba.algo3.Jugador;

import fiuba.algo3.Herramientas.Herramienta;
import fiuba.algo3.Interfaces.IColeccionable;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Mapa.Posicion;
import fiuba.algo3.Materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<IColeccionable> elementosAlmacenados;
    private int cantidadDeEspacios;

    public Inventario(){
        this.elementosAlmacenados = new ArrayList<>();
        this.cantidadDeEspacios = 15;
    }

    public void agregar(IColeccionable elemento){
        if (this.elementosAlmacenados.size() >= this.cantidadDeEspacios){
            throw new InventarioLlenoException();
        }
        elementosAlmacenados.add(elemento);
    }


    public void eliminar(IColeccionable elemento){
         elementosAlmacenados.remove(elemento);
    }

    public int getCantidadElementos() {
        return elementosAlmacenados.size();
    }

    public IColeccionable getElemento(Posicion posicion) {
        return  null;
    }
}
