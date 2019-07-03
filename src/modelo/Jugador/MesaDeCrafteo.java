package modelo.Jugador;


import modelo.Herramientas.Herramienta;
import modelo.Interfaces.IMapeable;
import modelo.Mapa.Casillero;
import modelo.Mapa.Posicion;
import modelo.Mapa.PosicionInvalidaException;
import modelo.Materiales.Material;
import modelo.Materiales.Vacio;
import modelo.Moldes.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MesaDeCrafteo {

    private HashMap<Posicion, Casillero> tableroDeCraft;
    private List <Molde> moldes;

    public MesaDeCrafteo(){
        this.tableroDeCraft = new HashMap<>();
        this.inicializarTableroDeCraft();
        this.moldes = crearMoldes();
    }

    private void inicializarTableroDeCraft(){
        for (int i = 0; i <3; i++){
            for (int j = 0; j<3; j++){
                Posicion posCasillero = new Posicion(i,j);
                Casillero casilleroCraft = new Casillero();
                Vacio elemento = new Vacio();
                casilleroCraft.ocuparCon(elemento);
                this.tableroDeCraft.put(posCasillero,casilleroCraft);
            }
        }
    }

    public HashMap<Posicion, Casillero> getTablero(){
        return tableroDeCraft;
    }

    public List crearMoldes(){
        List  moldes = new ArrayList <Molde>();
        Molde moldeHachaDeMadera = new MoldeHachaDeMadera();
        Molde moldeHachaDePiedra = new MoldeHachaDePiedra();
        Molde moldeHachaDeMetal = new MoldeHachaDeMetal();
        Molde moldePicoDeMadera = new MoldePicoDeMadera();
        Molde moldePicoDePiedra = new MoldePicoDePiedra();
        Molde moldePicoDeMetal = new MoldePicoDeMetal();
        Molde moldePicoFino = new MoldePicoFino();
        moldes.add(moldeHachaDeMadera);
        moldes.add(moldeHachaDePiedra);
        moldes.add(moldeHachaDeMetal);
        moldes.add(moldePicoDeMadera);
        moldes.add(moldePicoDePiedra);
        moldes.add(moldePicoDeMetal);
        moldes.add(moldePicoFino);
        return moldes;
    }

     public void agregarMaterial(Material material, Posicion posicionTablero){
        Casillero casilleroDeCraft =  this.tableroDeCraft.get(posicionTablero);
        casilleroDeCraft.ocuparCon(material);
    }


    public Material eliminarMaterial(Posicion posicionTablero){
        Casillero casilleroDeCraft = this.tableroDeCraft.get(posicionTablero);
        if (casilleroDeCraft.getOcupante().esVacio()) {
            throw new PosicionVaciaEnLaMesaDeCrafteoException(); //// encap
        }
        IMapeable materialEliminado = casilleroDeCraft.removeOcupante();
        return  ( Material) materialEliminado; //casteo
    }


    public Herramienta craftear(){
        for (Molde molde : this.moldes){
            if ( molde.esIgual(this.tableroDeCraft))
                return molde.create();
        }
        throw new MoldeInvalidoException();
    }

    public void vaciarTablero(){
        this.inicializarTableroDeCraft();
    }

}