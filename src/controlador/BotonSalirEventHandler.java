package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    private Button boton;

    public BotonSalirEventHandler(Button boton){
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) boton.getScene().getWindow();
        stage.close();
    }
}
