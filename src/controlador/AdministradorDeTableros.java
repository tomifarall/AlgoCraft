package controlador;

import modelo.Materiales.*;
import vista.aplicacion.ContenedorMapaJuego;
import modelo.Herramientas.*;
import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Juego.Juego;
import modelo.Mapa.Casillero;
import modelo.Mapa.Mapa;
import modelo.Mapa.Posicion;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;

public class AdministradorDeTableros {

    private Image casilleroVacio;
    private Image casilleroHachaDeMadera;
    private Image casilleroHachaDePiedra;
    private Image casilleroHachaDeMetal;
    private Image casilleroPicoDePiedra;
    private Image casilleroPicoDeMetal;
    private Image casilleroPicoDeMadera;
    private Image casilleroPicoFino;
    private Image casilleroMadera;
    private Image casilleroPiedra;
    private Image casilleroMetal;
    private Image casilleroDiamante;
    private Image pasto;
    private Image jugador;
    private Image madera;
    private Image piedra;
    private Image diamante;
    private Image metal;
    private ContenedorMapaJuego contenedorMapaJuego;
    private GridPane mapaJuego;
    private GridPane tableroInventario;
    private GridPane tableroHerramientaEnMano;
    private GridPane tableroCraftingTable;


    public AdministradorDeTableros(ContenedorMapaJuego contenedorMapaJuego,GridPane mapaJuego, GridPane tableroInventario, GridPane tableroCraftingTable, GridPane tableroHerramientaEnMano){
        this.mapaJuego = mapaJuego;
        this.tableroInventario = tableroInventario;
        this.tableroHerramientaEnMano = tableroHerramientaEnMano;
        this.tableroCraftingTable = tableroCraftingTable;
        this.contenedorMapaJuego = contenedorMapaJuego;
        this.inicializarImagenesJuego();
    }

    private void inicializarImagenesJuego() {
        pasto = new Image("vista\\imagenes\\pasto.png");
        piedra = new Image("vista\\imagenes\\piedra.png");
        madera = new Image("vista\\imagenes\\madera.png");
        metal = new Image("vista\\imagenes\\metal.jpeg");
        diamante = new Image("vista\\imagenes\\diamante.jpeg");
        jugador = new Image("vista\\imagenes\\steve.png");
        casilleroVacio = new Image("vista\\imagenes\\casillerotablero.jpg");
        casilleroDiamante = new Image("vista\\imagenes\\diamantetablero.jpg");
        casilleroPiedra = new Image("vista\\imagenes\\piedratablero.jpg");
        casilleroMetal = new Image("vista\\imagenes\\metaltablero.jpg");
        casilleroMadera = new Image("vista\\imagenes\\maderatablero.jpg");
        casilleroHachaDePiedra = new Image("vista\\imagenes\\hachapiedratablero.jpg");
        casilleroHachaDeMadera = new Image("vista\\imagenes\\hachamaderatablero.jpg");
        casilleroHachaDeMetal = new Image("vista\\imagenes\\hachametaltablero.jpg");
        casilleroPicoDePiedra = new Image("vista\\imagenes\\picopiedratablero.jpg");
        casilleroPicoDeMadera = new Image("vista\\imagenes\\picomaderatablero.jpg");
        casilleroPicoDeMetal = new Image("vista\\imagenes\\picometaltablero.jpg");
        casilleroPicoFino = new Image("vista\\imagenes\\picofinotablero.png");
    }

    public ImageView generarImageview(Image imagen) {
        ImageView imageViewImagen = new ImageView(imagen);
        imageViewImagen.setFitHeight(60);
        imageViewImagen.setFitHeight(60);
        imageViewImagen.setFitWidth(60);
        imageViewImagen.setFitWidth(60);
        return imageViewImagen;
    }

    public Posicion obtenerCoordenadasDeElementoEnGridPane(GridPane grid, Node nodoElemento){
        int coordenadaI = -1;
        int coordenadaJ = -1;
        for (Node nodo : grid.getChildren()) {
            if (nodo == nodoElemento) {
                coordenadaJ = grid.getColumnIndex(nodo);
                coordenadaI = grid.getRowIndex(nodo);
            }
        }
        if ( !(coordenadaI == -1) && !(coordenadaJ==-1)){
            Posicion posicionElemento = new Posicion(coordenadaI,coordenadaJ);
            return posicionElemento;
        }
        return null;
    }

    private ImageView generarImageviewHerramienta(Herramienta herramienta){
        Material materialHerramienta = herramienta.getMaterial();
        if (herramienta instanceof Hacha) {
            if (materialHerramienta.getTipo()== "madera") return this.generarImageview(casilleroHachaDeMadera);
            if (materialHerramienta.getTipo()== "piedra") return this.generarImageview(casilleroHachaDePiedra);
            if (materialHerramienta.getTipo()== "metal") return this.generarImageview(casilleroHachaDeMetal);
        }
        if (herramienta instanceof Pico){
            if (materialHerramienta.getTipo()== "madera") return this.generarImageview(casilleroPicoDeMadera);
            if (materialHerramienta.getTipo()== "piedra") return this.generarImageview(casilleroPicoDePiedra);
            if (materialHerramienta.getTipo()== "metal") return this.generarImageview(casilleroPicoDeMetal);
        }
        return this.generarImageview(casilleroPicoFino);
    }

    private ImageView generarImageviewMaterial(Material material){
        if (material.getTipo()== "piedra") return this.generarImageview(casilleroPiedra);
        if (material.getTipo()== "madera") return this.generarImageview(casilleroMadera);
        if (material.getTipo()== "metal") return this.generarImageview(casilleroMetal);
        return this.generarImageview(casilleroDiamante);

    }

    public Image getImagenMapa(String imagenBuscada) {
        if (imagenBuscada.equals("piedra")) return piedra;
        if (imagenBuscada.equals("madera")) return madera;
        if (imagenBuscada.equals("metal")) return metal;
        if (imagenBuscada.equals("diamante")) return diamante;
        if (imagenBuscada.equals("jugador")) return jugador;
        else return pasto;
    }

    public  void redibujarTableroCraftingTable(Juego juego) {
        HashMap<Posicion,Casillero> mesaDeCrafteo = juego.getMesaDeCrafteoJugador();
        ImageView nuevoCasillero;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casillero casillero = mesaDeCrafteo.get(new Posicion(i,j));
                IMapeable ocupanteCasillero = casillero.getOcupante();
                if (ocupanteCasillero.esVacio()){
                    nuevoCasillero = this.generarImageview(casilleroVacio);
                    contenedorMapaJuego.setearEventoACasilleroCraftingTable(nuevoCasillero);
                }else{
                    nuevoCasillero = this.generarImageviewMaterial((Material)ocupanteCasillero);
                    contenedorMapaJuego.setearEventoAMaterialEnCraftingTable(nuevoCasillero);
                }
                tableroCraftingTable.add(nuevoCasillero, j, i, 1, 1);
            }
        }
    }


    public void redibujarTableroHerramientaEnMano(Juego juego){
        ImageView nuevaHerramientaEnMano;
        Herramienta herramientaEnMano = juego.getJugador().getHerramientaEnMano();
        if (herramientaEnMano == null) nuevaHerramientaEnMano = this.generarImageview(casilleroVacio);
        else nuevaHerramientaEnMano = this.generarImageviewHerramienta(herramientaEnMano);
        tableroHerramientaEnMano.add(nuevaHerramientaEnMano,0,0,1,1);
    }

    public void redibujarInventario(Juego juego){
        HashMap<Posicion,IColeccionable> inventario = juego.getInventarioJugador();
        for (int i = 0; i<3; i++){
            for (int j = 0; j<5; j++){
                ImageView imageviewCasilleroInventario = null;
                IColeccionable coleccionable = inventario.get(new Posicion(i,j));
                if (coleccionable == null) imageviewCasilleroInventario = this.generarImageview(casilleroVacio);
                else if (coleccionable instanceof Herramienta){
                    imageviewCasilleroInventario = this.generarImageviewHerramienta((Herramienta)coleccionable);
                    contenedorMapaJuego.setearEventoAHerramientaInventario(imageviewCasilleroInventario,i,j);
                }
                else if (coleccionable instanceof Material){
                    imageviewCasilleroInventario = this.generarImageviewMaterial((Material) coleccionable);
                    contenedorMapaJuego.setearEventoAMaterialInventario(imageviewCasilleroInventario,i,j);
                }
                tableroInventario.add(imageviewCasilleroInventario,j,i,1,1);
                }
            }
    }


    public void redibujarMapa(Juego juego){
        Mapa mapa = juego.getMapa();
        int posicionIJugador = mapa.getPosicionJugador().getPosicionI();
        int posicionJJugador = mapa.getPosicionJugador().getPosicionJ();
        HashMap<Posicion, Casillero> tableroMapa = juego.getMapaJuego();
        for (int i = 0; i<51; i++){
            for (int j = 0; j<51 ; j++){
                if (i==posicionIJugador && j==posicionJJugador){
                    mapaJuego.add(this.generarImageview(jugador),j,i,1,1);
                    continue;
                }
                Posicion nuevaPosicion = new Posicion(i,j);
                Casillero casilleroMapa = tableroMapa.get(nuevaPosicion);
                IMapeable materialNuevo = casilleroMapa.getOcupante();
                String tipoMaterial = materialNuevo.getTipo();
                Image imagenMaterial = this.getImagenMapa(materialNuevo.getTipo());
                ImageView nuevoMaterialMapa = this.generarImageview(imagenMaterial);
                if (tipoMaterial != "vacio") contenedorMapaJuego.setearEventoAMaterialMapa(nuevoMaterialMapa,i,j);
                mapaJuego.add(nuevoMaterialMapa,j,i,1,1);
            }
        }
    }

    public void redibujarMapa(Juego juego,Posicion posicionJugador, Posicion posicionSiguienteJugador){
        int posicionIJugador = posicionJugador.getPosicionI();
        int posicionJJugador = posicionJugador.getPosicionJ();
        int posicionISiguienteJugador = posicionSiguienteJugador.getPosicionI();
        int posicionJSiguienteJugador = posicionSiguienteJugador.getPosicionJ();

        IMapeable mapeableEnPosicionJugador = juego.getMapaJuego().get(posicionJugador).getOcupante();
        IMapeable mapeableEnPosicionSiguienteJugador = juego.getMapaJuego().get(posicionSiguienteJugador).getOcupante();
        Image imagenMapeableEnPosicionJugador = this.getImagenMapa(mapeableEnPosicionJugador.getTipo());
        Image imagenMapeableEnPosicionSiguienteJugador = this.getImagenMapa(mapeableEnPosicionSiguienteJugador.getTipo());
        ImageView imageviewMapeableEnPosicionJugador = this.generarImageview(imagenMapeableEnPosicionJugador);
        ImageView imageviewMapeableEnPosicionSiguienteJugador = this.generarImageview(imagenMapeableEnPosicionSiguienteJugador);
        mapaJuego.add(imageviewMapeableEnPosicionJugador,posicionJJugador,posicionIJugador,1,1);
        mapaJuego.add(imageviewMapeableEnPosicionSiguienteJugador,posicionJSiguienteJugador,posicionISiguienteJugador,1,1);
    }

    public void redibujarMapa(Juego juego,Posicion posicionMaterial){
        int posicionIMapeable = posicionMaterial.getPosicionI();
        int posicionJMapeable = posicionMaterial.getPosicionJ();
        IMapeable mapeableEnPosicion = juego.getMapaJuego().get(posicionMaterial).getOcupante();
        Image imagenMapeableEnPosicion = this.getImagenMapa(mapeableEnPosicion.getTipo());
        ImageView imageviewMapeableEnPosicion = this.generarImageview(imagenMapeableEnPosicion);
        mapaJuego.add(imageviewMapeableEnPosicion,posicionJMapeable,posicionIMapeable,1,1);
        if (mapeableEnPosicion instanceof Material) contenedorMapaJuego.setearEventoAMaterialMapa(imageviewMapeableEnPosicion,posicionIMapeable,posicionJMapeable);
    }

}


