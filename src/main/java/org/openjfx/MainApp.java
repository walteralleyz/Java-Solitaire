package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.layouts.MenuPane;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        MenuPane pane = new MenuPane().setup(stage);
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