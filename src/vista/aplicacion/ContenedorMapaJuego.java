package vista.aplicacion;

import controlador.*;
import modelo.Juego.Juego;
import modelo.Mapa.Posicion;
import modelo.Materiales.Material;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.FontWeight;


import static javafx.scene.input.KeyCode.*;

public class ContenedorMapaJuego extends BorderPane {

    private AdministradorDeTableros administradorDeTableros;
    private GridPane tableroHerramientaEnMano;
    private GridPane tableroInventario;
    private GridPane tableroCraftingTable;
    private GridPane mapaJuego;
    private Node ultimoElementoDraggeado;
    private Label ultimoMensaje;
    private Label mensajeDurabilidadHerramientaEnMano;
    private Juego juego;

    public ContenedorMapaJuego() {
        super();
        this.juego = new Juego();
        mapaJuego = new GridPane();
        tableroInventario = new GridPane();
        tableroCraftingTable = new GridPane();
        tableroHerramientaEnMano = new GridPane();
        this.administradorDeTableros = new AdministradorDeTableros( this,mapaJuego,tableroInventario,tableroCraftingTable,tableroHerramientaEnMano);
        this.inicializarMapaJuego();
        this.inicializarSeccionIzquierda();
        this.inicializarSeccionAbajo();
    }

    private void inicializarSeccionAbajo(){
        HBox hbox = new HBox(500);
        this.ultimoMensaje =  new Label("Para comenzar a moverse por el mapa haga click en la pantalla central");
        this.ultimoMensaje.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        this.mensajeDurabilidadHerramientaEnMano = new Label("Durabilidad herramienta en mano:" + juego.getJugador().getHerramientaEnMano().getDurabilidad());
        this.mensajeDurabilidadHerramientaEnMano.setFont(Font.font("Verdana",FontWeight.BOLD,13));
        hbox.setMinHeight(25);
        ultimoMensaje.setMinSize(300,23);
        mensajeDurabilidadHerramientaEnMano.setMinSize(300,23);
        hbox.getChildren().addAll(ultimoMensaje,mensajeDurabilidadHerramientaEnMano);
        this.setBottom(hbox);
    }

    private void inicializarMapaJuego() {
        administradorDeTableros.redibujarMapa(juego);
        this.inicializarScrollPane();
    }

    private void inicializarScrollPane() {
        ScrollPane scroll = new ScrollPane();
        MovimientosMapaEventHandler eventHandlerMapa = new MovimientosMapaEventHandler(this, administradorDeTableros, juego);
        scroll.setContent(mapaJuego);
        scroll.setHvalue(0.5);
        scroll.setVvalue(0.5);
        scroll.setOnKeyPressed(event -> {
            if (event.getCode().equals(UP) || event.getCode().equals(DOWN) || event.getCode().equals(LEFT) || event.getCode().equals(RIGHT) || event.getCode().equals(SPACE))
                event.consume();
            eventHandlerMapa.handle(event);
        });
        this.setCenter(scroll);
    }

    private void inicializarSeccionIzquierda() {
        VBox vBoxIzquierda = new VBox(20);
        vBoxIzquierda.setMinWidth(100);
        this.generarTableroCraftingTable(vBoxIzquierda);
        this.generarTableroInventario(vBoxIzquierda);
        this.inicializarHerramientaEnMano(vBoxIzquierda);
        Image imagenFondoIzquierdo = new Image("vista\\imagenes\\fondogris.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(imagenFondoIzquierdo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBoxIzquierda.setBackground(new Background(backgroundImage));
        this.setLeft(vBoxIzquierda);
    }

    public void actualizarVentanaDeMensajes(String nuevoMensaje) {
        this.ultimoMensaje.setText(nuevoMensaje);
    }

    public void actualizarVentanaDurabilidadHerramientaEnMano(String mensajeNuevaDurabilidad){this.mensajeDurabilidadHerramientaEnMano.setText(mensajeNuevaDurabilidad);}

    private void inicializarHerramientaEnMano(VBox vBox) {
        Label labelHerramientaEnMano =  new Label("Herramienta en mano:");
        labelHerramientaEnMano.setFont(Font.font("Verdana", FontWeight.BOLD, 19));
        administradorDeTableros.redibujarTableroHerramientaEnMano(juego);
        tableroHerramientaEnMano.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelHerramientaEnMano,tableroHerramientaEnMano);
    }

    private void generarTableroCraftingTable(VBox vbox) {
        administradorDeTableros.redibujarTableroCraftingTable(juego);
        Label labelMesaDeCrafteo=  new Label("Mesa de crafteo:");
        labelMesaDeCrafteo.setFont(Font.font("Verdana", FontWeight.BOLD, 19));
        tableroCraftingTable.setAlignment(Pos.TOP_CENTER);
        Button boton = new Button("Crear");
        BotonCrearEventHandler eventHandlerCrear = new BotonCrearEventHandler(juego,this,administradorDeTableros);
        boton.setOnAction(eventHandlerCrear);
        tableroCraftingTable.add(boton,1,3,1,1);
        boton.setMinSize(60,30);
        vbox.getChildren().addAll(labelMesaDeCrafteo, tableroCraftingTable);
    }

    public void setearEventoACasilleroCraftingTable(ImageView imageviewCasilleroVacio) {
        imageviewCasilleroVacio.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                dragOver(event);
            }
        });
        imageviewCasilleroVacio.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                dragDropped(event, imageviewCasilleroVacio);
            }
        });
    }

    //DESDE ACA SON LAS FUNCIONES DE LA PAGINA PARA DRAG AND DROP
    private void dragDetected(MouseEvent event, ImageView imageViewMaterial) {
        // Initiate a drag-and-drop gesture
        Dragboard dragboard = imageViewMaterial.startDragAndDrop(TransferMode.COPY_OR_MOVE);

        // Add the source text to the Dragboard         //MMMM BORRAR???
        ClipboardContent content = new ClipboardContent();
        content.putImage(imageViewMaterial.getImage());
        dragboard.setContent(content);
        event.consume();
    }

    private void dragOver(DragEvent event) {
        // If drag board has a string, let the event know that
        // the target accepts copy and move transfer modes
        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasImage()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    private void dragDropped(DragEvent event, ImageView imageviewCasilleroCraftingTablero) {
        // Transfer the data to the target
        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasImage()) {
            imageviewCasilleroCraftingTablero.setImage(dragboard.getImage());
            // Data transfer is successful
            event.setDropCompleted(true);
            this.ultimoElementoDraggeado = imageviewCasilleroCraftingTablero;
        } else {
            // Data transfer is not successful
            event.setDropCompleted(false);
        }

        event.consume();
    }

    private void dragDone(DragEvent event, ImageView imageviewMaterial) {
        // Check how data was transfered to the target. If it was moved, clear the text in the source.
        TransferMode modeUsed = event.getTransferMode();

        if (modeUsed == TransferMode.MOVE) {
            Posicion posicionMaterialEnInventario = administradorDeTableros.obtenerCoordenadasDeElementoEnGridPane(tableroInventario, imageviewMaterial);
            Material materialDeInventario = (Material) juego.getInventarioJugador().get(posicionMaterialEnInventario);
            int coordenadaIMaterialCraftingTable = tableroCraftingTable.getRowIndex(ultimoElementoDraggeado);
            int coordenadaJMaterialCraftingTable = tableroCraftingTable.getColumnIndex(ultimoElementoDraggeado);
            Posicion posicionMaterialEnCraftingTable = new Posicion(coordenadaIMaterialCraftingTable,coordenadaJMaterialCraftingTable);
            juego.eliminarDeInventario(posicionMaterialEnInventario);
            juego.agregarMaterialAMesaDeCrafteo(materialDeInventario,posicionMaterialEnCraftingTable);
            administradorDeTableros.redibujarInventario(juego);
            administradorDeTableros.redibujarTableroCraftingTable(juego);
        }
        event.consume();
    }

    public void setearEventoAMaterialEnCraftingTable(ImageView imageviewMaterial) {
        MaterialEnCraftingTableEventHandler eventHandler = new MaterialEnCraftingTableEventHandler(this, administradorDeTableros, tableroCraftingTable, imageviewMaterial,juego);
        imageviewMaterial.setOnMouseClicked(eventHandler);
    }

    private void generarTableroInventario(VBox vbox) {
        administradorDeTableros.redibujarInventario(juego);
        Label labelInventario =  new Label("Inventario:");
        labelInventario.setFont(Font.font("Verdana", FontWeight.BOLD, 19));
        tableroInventario.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(labelInventario, tableroInventario);
    }

    public void setearEventoAMaterialInventario(ImageView imageViewMaterial,int posicionIMaterial, int posicionJMaterial) {
        imageViewMaterial.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                dragDetected(event, imageViewMaterial);
            }
        });
        imageViewMaterial.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                dragDone(event, imageViewMaterial);
            }
        });
        MaterialInventarioEventHandler eventHandlerMaterialInventario = new MaterialInventarioEventHandler(juego,new Posicion(posicionIMaterial,posicionJMaterial),administradorDeTableros,imageViewMaterial);
        imageViewMaterial.setOnMouseClicked(eventHandlerMaterialInventario);
    }

    public void setearEventoAHerramientaInventario(ImageView imageviewHerramienta,int posicionIHerramienta, int posicionJHerramienta) {
        HerramientaInventarioEventHandler eventHandlerHerramientaInventario = new HerramientaInventarioEventHandler(imageviewHerramienta, administradorDeTableros,new Posicion(posicionIHerramienta,posicionJHerramienta),juego,this);
        imageviewHerramienta.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlerHerramientaInventario);
    }

    public void setearEventoAMaterialMapa(ImageView imageviewMaterial, int indiceI, int indiceJ) {
        MaterialMapaEventHandler eventHandlerJugador = new MaterialMapaEventHandler(this, administradorDeTableros, indiceI, indiceJ, juego);
        imageviewMaterial.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlerJugador);
    }

}