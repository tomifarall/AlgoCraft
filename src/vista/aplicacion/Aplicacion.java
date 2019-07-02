package vista.aplicacion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoCraft");

        ContenedorMapaJuego contenedorMapaJuego = new ContenedorMapaJuego();
        Scene escenaJuego = new Scene(contenedorMapaJuego,640,480);

        ContenedorMenuJuego contenedorMenuJuego = new ContenedorMenuJuego(stage,escenaJuego);
        Scene escenaMenuJuego = new Scene(contenedorMenuJuego, 640, 480);

        stage.setScene(escenaMenuJuego);
        stage.setFullScreen(true);

        stage.show();
    }

}
