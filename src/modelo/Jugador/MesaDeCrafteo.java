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
   /*     int posI = posicionTablero.getPosicionI();
        int posJ = posicionTablero.getPosicionJ();
        if ( (posI >2 || posI<0) || (posJ>2 || posJ<0) ){
            throw new PosicionInvalidaException();
        }*/                                                       //NO ES NECESARIO PORQUE EN LA INTERFAZ NUNCA SE VA A PODER HACER ESO
        Casillero casilleroDeCraft =  this.tableroDeCraft.get(posicionTablero);
        casilleroDeCraft.ocuparCon(material);
    }
/*
    public Material eliminarMaterial(Posicion posicionTablero){
        int posI = posicionTablero.getPosicionI();
        int posJ = posicionTablero.getPosicionJ();
        if ( (posI >2 || posI<0) || (posJ>2 || posJ<0) ){    //ESTO NO HACE FALTA PORQUE LA INTERFAZ NO LO PERMITE
            throw new PosicionInvalidaException();
        }
        Casillero casilleroDeCraft = this.tableroDeCraft.get(posicionTablero);
        if (casilleroDeCraft.getOcupante().esVacio()) {
            throw new PosicionVaciaEnLaMesaDeCrafteoException(); //// encap
        }
        IMapeable materialEliminado = casilleroDeCraft.removeOcupante();
        return  ( Material) materialEliminado; //casteo
    }

 */

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






















    /*private void generarMoldeHacha(HashMap<Integer,Material> molde,Material material){
        molde.put(1,material);
        molde.put(2,material);
        molde.put(4,material);
        this.agregarMango(molde);
    }

    private void agregarMango(HashMap<Integer, Material> molde) {
        molde.put(5,new Madera());
        molde.put(8,new Madera());
    }

    private void generarMoldePico(HashMap<Integer,Material> molde, Material material){
        molde.put(1,material);
        molde.put(2,material);
        molde.put(3,material);
        this.agregarMango(molde);
    }

    private void generarMoldePicoFino(){
        moldePicoFino.put(1,new Metal());
        moldePicoFino.put(2,new Metal());
        moldePicoFino.put(3,new Metal());
        moldePicoFino.put(4,new Piedra());
        this.agregarMango(moldePicoFino);
    }

    public Hacha crearHachaDeMadera(){
        if (this.esElMoldeCorrecto(tablero,moldeHachaDeMadera)) return new Hacha(new Madera());
    }
    public Hacha crearHachaDePiedra(){
        if (this.esElMoldeCorrecto(tablero,moldeHachaDePiedra)) return new Hacha(new Piedra());
    }
    public Hacha crearHachaDeMetal(){
        if (this.esElMoldeCorrecto(tablero,moldeHachaDeMetal)) return new Hacha(new Metal());
    }

    public Pico crearPicoDeMadera(){
        if (this.esElMoldeCorrecto(tablero,moldePicoDeMadera)) return new Pico(new Madera());
    }

    public Pico crearPicoDePiedra(){
        if (this.esElMoldeCorrecto(tablero,moldePicoDePiedra)) return new Pico(new Piedra());
    }

    public Pico crearPicoDeMetal(){
        if (this.esElMoldeCorrecto(tablero,moldePicoDeMetal)) return new Pico(new Metal());
    }

    public PicoFino crearPicoFino(){
        if (this.esElMoldeCorrecto(tablero,moldePicoFino)) return new PicoFino(); //CAMBIARLO A PICO CON FINITUD
    }
    private boolean esElMoldeCorrecto(HashMap<Integer, Material> tablero, HashMap<Integer, Material> moldeHerramienta) {
        for (int i = 1; i < 10; i++){
            if (!(moldeHerramienta.get(i).compararCon((tablero.get(i))))) return false;
        }
        return true;
    }*/