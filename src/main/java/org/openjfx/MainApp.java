package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.game.Game;
import org.openjfx.layout.Pane;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        final Pane pane = new Game().setup();
        Scene scene = new Scene(pane);

        stage.setTitle("Java Solitaire");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}