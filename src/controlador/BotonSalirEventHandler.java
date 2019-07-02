package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    private Button boton;
 //   private Stage stage;

    public BotonSalirEventHandler(Button boton/* Stage stage*/){
        this.boton = boton;
   //     this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) boton.getScene().getWindow();
        stage.close();
    }
}
