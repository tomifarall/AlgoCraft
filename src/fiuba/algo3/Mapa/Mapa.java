package fiuba.algo3.Mapa;

import com.opencsv.CSVReader;
import fiuba.algo3.Direccion.*;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Jugador.Jugador;
import fiuba.algo3.Materiales.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Mapa {

    private static Mapa actual;
    private Posicion posJugador;
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

    public void actualizarPosicion(IMapeable elemento, Direccion direccion) {
        Posicion nuevaPosicion = posJugador.obtenerPosicionSiguiente(direccion);
        if (!this.tablero.containsKey(nuevaPosicion)) {
            throw new PosicionInvalidaException();
        }
        Casillero nuevoCasillero = this.tablero.get(nuevaPosicion);
        Casillero casilleroJugador = this.tablero.get(posJugador);
        casilleroJugador.removeOcupante();
        try {
            nuevoCasillero.ocuparCon(elemento);
        } catch (CasilleroOcupadoException e) {
            casilleroJugador.ocuparCon(elemento);
            return;
        }
        posJugador = nuevaPosicion;
    }


    private void generarMapa(HashMap tablero){
        for (int largo=0; largo<51 ; largo++) {
            for (int ancho = 0; ancho < 51; ancho++) {
                Casillero nuevoCasillero = new Casillero();
                Posicion posCasillero = new Posicion(largo, ancho);
                tablero.put( posCasillero, nuevoCasillero);
            }
        }
        inyectarEnMapa(archivo,this.tablero);
    }

    private void rellenarConElementos(int largoIn, int largoEnd, int anchoIn, int anchoEnd, HashMap<Posicion,Casillero> tablero, String elemento) {
        for (int i =largoIn ; i <= largoEnd; i++) {
            for (int j = anchoIn; j <= anchoEnd; j++) {
                IMapeable elementoMapa = obtenerElemento(elemento);
                Posicion posicion = new Posicion(i,j);
                elementoMapa.setPosicion(posicion);
                Casillero casillero = tablero.get(posicion);
                casillero.ocuparCon(elementoMapa);
            }
        }
    }
    private IMapeable obtenerElemento(String elemento) {
        if (elemento.equals("madera")) return new Madera();
        if (elemento.equals("piedra")) return new Piedra();
        if (elemento.equals("metal"))  return new Metal();
        else {
            return  new Diamante();
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

    public Posicion getPosicionJugador(){
        return  posJugador;
    }

    //Metodo Necesario para que pasen las pruebas debido a la instancia Singleton
    public void setPosicionJugadorCreado(Posicion posicion,Jugador jugador){
        if (posJugador == null){
            posJugador = posicion;
            Casillero casilleroJugador = tablero.get(posJugador);
            casilleroJugador.ocuparCon(jugador);
            return;
        }
        Casillero casilleroJugador = tablero.get(posJugador);
        casilleroJugador.removeOcupante();
        this.posJugador = posicion;
        Casillero nuevoCasilleroJugador = tablero.get(posJugador);
        nuevoCasilleroJugador.ocuparCon(jugador);
    }

    public IMapeable eliminarElemento(Posicion posicion){
        Casillero casilleroElemento = this.tablero.get(posicion);
        return casilleroElemento.removeOcupante();

    }

    public Material obtenerMaterialEnPosicion(Posicion posicion) {
        Casillero casilleroABuscar = this.tablero.get(posicion);
        return  (Material) casilleroABuscar.getOcupante();
    }

    public HashMap<Posicion,Casillero> getTablero(){
        return this.tablero;
    }

    public void verificarAdyacenciaConPos(Posicion posicion) {
        ArrayList<Posicion> adyacentes = this.obtnenerAdyacentes(posJugador);
        for (Posicion adyacente : adyacentes) {
            if (posicion.equals(adyacente)) return;
        }
        throw new PosicionNoAdyacente();
    }

    private ArrayList<Posicion> obtnenerAdyacentes(Posicion posicion) {
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
