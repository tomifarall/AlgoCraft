package modelo.Mapa;
import com.opencsv.CSVReader;
import modelo.Direccion.*;
import modelo.Interfaces.IMapeable;
import modelo.Jugador.Jugador;
import modelo.Materiales.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Mapa {

    private static Mapa actual;
    private Posicion posicionJugador;
    String archivo = "Mapa.txt";
    private HashMap<Posicion, Casillero> tablero;

    private Mapa(){
        this.tablero = new HashMap<>();
        generarMapa(this.tablero);
    }

    public static Mapa getMapa(){
        if( actual == null){
            actual = new Mapa();
        }
        return actual;
    }

    /////////////////////CREACION MAPA /////////////////////////////////
    private void generarMapa(HashMap tablero){
        for (int largo=0; largo<51 ; largo++) {
            for (int ancho = 0; ancho < 51; ancho++) {
                Casillero nuevoCasillero = new Casillero();
                Posicion clave = new Posicion(largo, ancho);
                tablero.put(clave, nuevoCasillero);
            }
        }
        inyectarEnMapa(archivo,this.tablero);

    }

    private void rellenarConElementos(int inicioI, int finI, int inicioJ, int finJ, HashMap tablero, String elemento) {
        for (int i =inicioI ; i <= finI; i++) {
            for (int j = inicioJ; j <= finJ; j++) {
                IMapeable elementoMapa = obtenerElemento(elemento);
                Posicion posicion = new Posicion(i,j);
                elementoMapa.setPosicion(posicion);
                Casillero casillero = (Casillero) tablero.get(posicion);
                casillero.ocuparCon(elementoMapa);
            }
        }
    }
    private IMapeable obtenerElemento(String elemento) {
        if (elemento.equals("madera")) return new Madera();
        if (elemento.equals("piedra")) return new Piedra();
        if (elemento.equals("metal"))  return new Metal();
        if (elemento.equals("diamante")) return  new Diamante();
        else {
            return new Vacio();
        }
    }


    private void inyectarEnMapa(String archivo, HashMap tablero) {
        try {

            FileReader lector = new FileReader(archivo);
            CSVReader csvReader = new CSVReader(lector);
            String[] fila;
            while ((fila = csvReader.readNext()) != null) {
                int anchoIn = Integer.parseInt(fila[0]);
                int anchoOut = Integer.parseInt(fila[1]);
                int largoIn = Integer.parseInt(fila[2]);
                int largoOut = Integer.parseInt(fila[3]);
                rellenarConElementos(largoIn, largoOut, anchoIn, anchoOut, tablero, fila[4]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //////////////////////////////////////////////////////////

    public Posicion getPosicionJugador(){
        return posicionJugador;
    }

    public void setPosicionJugadorCreado(Posicion posicion,Jugador jugador){
            if (posicionJugador == null){
                posicionJugador = posicion;
                Casillero casilleroJugador = tablero.get(posicionJugador);
                casilleroJugador.ocuparCon(jugador);
                return;
            }
            Casillero casilleroJugador = tablero.get(posicionJugador);
            casilleroJugador.eliminarOcupante();
            this.posicionJugador = posicion;
            Casillero nuevoCasilleroJugador = tablero.get(posicionJugador);
            nuevoCasilleroJugador.ocuparCon(jugador);
    }

    public HashMap<Posicion,Casillero> getTableroMapa(){
        return tablero;
    }

    public void actualizarPosicion(IMapeable elemento, Direccion direccion) {
        Posicion nuevaPosicion = posicionJugador.obtenerPosicionSiguiente(direccion);
        if (!this.tablero.containsKey(nuevaPosicion)) {
            throw new PosicionInvalidaException();
        }
        Casillero nuevoCasillero = this.tablero.get(nuevaPosicion);
        Casillero casilleroJugador = this.tablero.get(posicionJugador);
        casilleroJugador.eliminarOcupante();
        try {
            nuevoCasillero.ocuparCon(elemento);
        } catch (CasilleroOcupadoException e) {
            casilleroJugador.ocuparCon(elemento);
            throw e;
        }
        posicionJugador = nuevaPosicion;
    }

    public void eliminarElemento(Posicion posicion){
        Casillero casilleroElemento = this.tablero.get(posicion);
        casilleroElemento.eliminarOcupante();
    }

    public Material obtenerMaterialEnPosicion(Posicion posicion) {
        Casillero casilleroABuscar = this.tablero.get(posicion);
        return  (Material) casilleroABuscar.getOcupante();
    }

    public void verificarAdyacenciaConPosicion(Posicion posicion) {
        ArrayList<Posicion> adyacentes = this.obtenerAdyacentes(posicionJugador);
        for (Posicion adyacente : adyacentes) {
            if (posicion.equals(adyacente)) return;
        }
        throw new PosicionNoAdyacenteException();
    }

    private ArrayList<Posicion> obtenerAdyacentes(Posicion posicion) {
        ArrayList<Posicion> adyacentes = new ArrayList<>();
        Direccion derecha = new DireccionDerecha();
        Direccion izquierda = new DireccionIzquierda();
        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        adyacentes.add(posicion.obtenerPosicionSiguiente(derecha));
        adyacentes.add(posicion.obtenerPosicionSiguiente(izquierda));
        adyacentes.add(posicion.obtenerPosicionSiguiente(arriba));
        adyacentes.add(posicion.obtenerPosicionSiguiente(abajo));
        return adyacentes;
    }
}
