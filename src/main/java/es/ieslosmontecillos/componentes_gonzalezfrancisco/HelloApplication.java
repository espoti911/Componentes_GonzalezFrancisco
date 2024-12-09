package es.ieslosmontecillos.componentes_gonzalezfrancisco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        StackPane root = new StackPane();
        VBox vbox = new VBox();
        Temporizador temporizador = new Temporizador();
        temporizador.setTimer(5);
        temporizador.setLabelString("Temporizador personalizado: ");

        temporizador.setOnAction(e -> {
            System.out.println("FIN TEMPORIZADOR");
        });

        temporizador.startTimer();

        vbox.getChildren().add(temporizador);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}