package vista.aplicacion;

import controlador.BotonComenzarAJugarEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInstruccionesDelJuego extends BorderPane {

    private GridPane gridMoldes;

    public ContenedorInstruccionesDelJuego(Stage stage, Scene escenaJuego){
        VBox vboxCentral = new VBox();
        vboxCentral.setMinWidth(640);
        vboxCentral.setMinHeight(480);
        vboxCentral.setAlignment(Pos.CENTER);
        vboxCentral.setSpacing(20);
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(vboxCentral);
        scroll.setFitToWidth(true);
        scroll.setVvalue(0.0);
        ImageView imageviewInstrucciones = new ImageView("vista\\imagenes\\Instrucciones.png");
        imageviewInstrucciones.setFitHeight(60);
        imageviewInstrucciones.setFitWidth(700);
        Image imagenFondoInstrucciones = new Image("vista\\imagenes\\fondoinstrucciones3.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenFondoInstrucciones, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vboxCentral.setBackground(new Background(imagenDeFondo));
        vboxCentral.getChildren().add(imageviewInstrucciones);
        this.inicializarIndicaciones(vboxCentral);
        this.inicializarMoldesHerramientas(vboxCentral);
        this.inicializarMaterialesYSusCaracteristicas(vboxCentral);
        this.inicializarBotonComenzarAJugar(stage,escenaJuego,vboxCentral);
        this.setCenter(scroll);
    }

    private void inicializarMaterialesYSusCaracteristicas(VBox vboxCentral) {
        GridPane gridMateriales = new GridPane();
        Image madera = new Image("vista\\imagenes\\madera.png");
        Image maderaCaracteristicas = new Image("vista\\imagenes\\maderacaracteristicas.png");
        Image metal = new Image("vista\\imagenes\\metal.jpeg");
        Image metalCaracteristicas = new Image("vista\\imagenes\\metalcaracteristicas.png");
        Image piedra = new Image("vista\\imagenes\\piedra.png");
        Image piedraCaracteristicas = new Image("vista\\imagenes\\piedracaracteristicas.png");
        Image diamante = new Image("vista\\imagenes\\diamante.jpeg");
        Image diamanteCaracteristicas = new Image("vista\\imagenes\\maderacaracteristicas.png");
        Label labelCaracteristicas = this.generarLabel("A continuación se muestran las características de los distintos materiales en el mapa:");
        gridMateriales.add(labelCaracteristicas,0,0,2,1);
        gridMateriales.addRow(1,this.generarImageViewMaterial(madera),this.generarImageViewCaracteristicas(maderaCaracteristicas));
        gridMateriales.addRow(2,this.generarImageViewMaterial(piedra),this.generarImageViewCaracteristicas(piedraCaracteristicas));
        gridMateriales.addRow(3,this.generarImageViewMaterial(metal),this.generarImageViewCaracteristicas(metalCaracteristicas));
        gridMateriales.addRow(4,this.generarImageViewMaterial(diamante),this.generarImageViewCaracteristicas(diamanteCaracteristicas));
        Label labelFinal = this.generarLabel(" ↑↑ Subir para ver las instrucciones ↑↑");
        gridMateriales.add(labelFinal,0,5,2,1);
        gridMateriales.setAlignment(Pos.CENTER);
        vboxCentral.getChildren().add(gridMateriales);
    }

    private ImageView generarImageViewCaracteristicas(Image imagenCaracteristicasMaterial) {
        ImageView nuevaImageView = new ImageView(imagenCaracteristicasMaterial);
        nuevaImageView.setFitWidth(600);
        nuevaImageView.setFitHeight(120);
        return nuevaImageView;
    }

    private void inicializarBotonComenzarAJugar(Stage stageMenuJuego, Scene escenaMenuJuego, VBox vboxCentral) {
        Button botonComenzarAJugar = new Button("Comenzar a jugar");
        ImageView comenzarAJugar = new ImageView ("vista\\imagenes\\pico.jpg");
        comenzarAJugar.setFitHeight(40);
        comenzarAJugar.setFitWidth(40);
        botonComenzarAJugar.setGraphic(comenzarAJugar);
        BotonComenzarAJugarEventHandler eventHandlerBotonComenzarAJugar = new BotonComenzarAJugarEventHandler(stageMenuJuego,escenaMenuJuego);
        botonComenzarAJugar.setOnAction(eventHandlerBotonComenzarAJugar);
        botonComenzarAJugar.setAlignment(Pos.BOTTOM_LEFT);
        vboxCentral.getChildren().add(botonComenzarAJugar);

    }

    private void inicializarIndicaciones(VBox vboxCentral){

        Label labelMovimientos = this.generarLabel("♦ Para moverte por el mapa podés usar tanto las flechas del teclado como las teclas 'w', 'a', 's' y 'd'.");
        Label labelGolpes = this.generarLabel("♦ Para golpear un material del mapa hacé click sobre el material que quieras romper, debés tener en cuenta que para poder hacer eso");
        Label labelGolpes2 = this.generarLabel(" tenés que tener una herramienta en mano y también el jugador debe estar parado al lado del material.");
        Label labelHerramientaEnMano = this.generarLabel("♦ Para cambiar la herramienta en mano hacé click derecho sobre la herramienta en tu inventario que quieras usar y seleccioná 'elegir herramienta en mano'.");
        Label labelCraftingTable = this.generarLabel("♦ Para poner un material en la mesa de crafteo arrastrá el material que quieras poner sobre ella en el casillero que desees ponerlo.");
        Label labelEliminar = this.generarLabel("♦ Para eliminar un material o herramienta tanto de la mesa de crafteo como del inventario, hacé click derecho sobre el elemento y seleccioná");
        Label labelEliminar2 = this.generarLabel("'eliminar elemento del inventario' o 'eliminar material de la mesa de crafteo'.");
        Label labelCraftingTable3 = this.generarLabel("♦ Para crear una herramienta en la mesa de crafteo poner los materiales en sus correspondientes posiciones para la herramienta que quieras crear y clickeá el botón 'crear'.");
        Label labelCraftingTable5 = this.generarLabel("A continuación se muestran los moldes para generar cada una de las posibles herramientas del juego con sus respectivas características:");
        vboxCentral.getChildren().addAll(labelMovimientos,labelGolpes,labelGolpes2,labelHerramientaEnMano,labelCraftingTable,labelEliminar,labelEliminar2,labelCraftingTable3,labelCraftingTable5);
    }

    private void inicializarMoldesHerramientas(VBox vboxCentral){
        this.gridMoldes = new GridPane();
        Image imagenFlecha = new Image("vista\\imagenes\\flecha.png");
        Image imagenTitulosEspecificaciones = new Image("vista\\imagenes\\titulos.png");
        Image imagenMoldeHachaDeMadera = new Image("vista\\imagenes\\moldehachademadera.png");
        Image imagenHachaDeMadera = new Image("vista\\imagenes\\hachamaderatablero.jpg");
        Image imagenEspecificacionesHachaMadera = new Image("vista\\imagenes\\hachamadera.png");
        this.agregarMolde(imagenMoldeHachaDeMadera,imagenHachaDeMadera,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesHachaMadera,"Molde de hacha de madera:",0);
        Image imagenMoldeHachaDePiedra = new Image("vista\\imagenes\\moldehachadepiedra.png");
        Image imagenHachaDePiedra = new Image("vista\\imagenes\\hachapiedratablero.jpg");
        Image imagenEspecificacionesHachaPiedra = new Image("vista\\imagenes\\hachapiedra.png");
        this.agregarMolde(imagenMoldeHachaDePiedra,imagenHachaDePiedra,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesHachaPiedra,"Molde de hacha de piedra:",2);
        Image imagenMoldeHachaDeMetal = new Image("vista\\imagenes\\moldehachademetal.png");
        Image imagenHachaDeMetal = new Image("vista\\imagenes\\hachametaltablero.jpg");
        Image imagenEspecificacionesHachaMetal = new Image("vista\\imagenes\\hachametal.png");
        this.agregarMolde(imagenMoldeHachaDeMetal,imagenHachaDeMetal,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesHachaMetal,"Molde de hacha de metal:",4);
        Image imagenMoldePicoDeMadera = new Image("vista\\imagenes\\moldepicodemadera.png");
        Image imagenPicoDeMadera = new Image("vista\\imagenes\\picomaderatablero.jpg");
        Image imagenEspecificacionesPicoMadera = new Image("vista\\imagenes\\picomadera.png");
        this.agregarMolde(imagenMoldePicoDeMadera,imagenPicoDeMadera,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesPicoMadera,"Molde de pico de madera:",6);
        Image imagenMoldePicoDePiedra = new Image("vista\\imagenes\\moldepicodepiedra.png");
        Image imagenPicoDePiedra = new Image("vista\\imagenes\\picopiedratablero.jpg");
        Image imagenEspecificacionesPicoPiedra = new Image("vista\\imagenes\\picopiedra.png");
        this.agregarMolde(imagenMoldePicoDePiedra,imagenPicoDePiedra,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesPicoPiedra,"Molde de pico de piedra:",8);
        Image imagenMoldePicoDeMetal = new Image("vista\\imagenes\\moldepicodemetal.png");
        Image imagenPicoDeMetal = new Image("vista\\imagenes\\picometaltablero.jpg");
        Image imagenEspecificacionesPicoMetal = new Image("vista\\imagenes\\picometal.png");
        this.agregarMolde(imagenMoldePicoDeMetal,imagenPicoDeMetal,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesPicoMetal,"Molde de pico de metal:",10);
        Image imagenMoldePicoFino = new Image("vista\\imagenes\\moldepicofino.png");
        Image imagenPicoFino = new Image("vista\\imagenes\\picofinotablero.png");
        Image imagenEspecificacionesPicoFino = new Image("vista\\imagenes\\picofino.png");
        this.agregarMolde(imagenMoldePicoFino,imagenPicoFino,imagenFlecha,imagenTitulosEspecificaciones,imagenEspecificacionesPicoFino,"Molde de pico fino:", 12);
        gridMoldes.setAlignment(Pos.CENTER);
        vboxCentral.getChildren().add(gridMoldes);
    }

    private Label generarLabel(String mensajeLabel){
        Label nuevoLabel = new Label(mensajeLabel);
        nuevoLabel.setFont(Font.font("Gruppo", FontWeight.BOLD, 16));
        nuevoLabel.setTextFill(Color.BLACK);
        return nuevoLabel;
    }

    private ImageView generarImageViewMaterial(Image imagen){
        ImageView nuevaImageView = new ImageView(imagen);
        nuevaImageView.setFitWidth(90);
        nuevaImageView.setFitHeight(90);
        return nuevaImageView;
    }

    private ImageView generarImageView(Image imagen){
        ImageView nuevaImageView = new ImageView(imagen);
        nuevaImageView.setFitWidth(180);
        nuevaImageView.setFitHeight(180);
        return nuevaImageView;
    }

    private void agregarMolde(Image imagenMolde, Image imagenHerramienta, Image imagenFlecha,Image imagenTitulosEspecificaciones, Image imagenEspecificaciones, String stringLabel, int fila){
        ImageView imageviewMolde = this.generarImageView(imagenMolde);
        ImageView imageviewHerramienta = this.generarImageView(imagenHerramienta);
        ImageView imageviewTitulosEspecificaciones = this.generarImageView(imagenTitulosEspecificaciones);
        ImageView imageviewEspecificacionesHerramienta = this.generarImageView(imagenEspecificaciones);
        Label labelMolde = this.generarLabel(stringLabel);
        gridMoldes.add(labelMolde,0,fila,2,1);
        gridMoldes.addRow(fila+1,imageviewMolde,this.generarImageView(imagenFlecha),imageviewHerramienta,imageviewTitulosEspecificaciones,imageviewEspecificacionesHerramienta);
    }
}
